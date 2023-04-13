import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.application.*;
import javafx.scene.*; 
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.lang.Object;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;

class drawCanvas extends Canvas
{
   private GraphicsContext gc = getGraphicsContext2D();
   
   public drawCanvas()
   {
     setWidth(80);
     setHeight(80); 
   }
   
   public void drawCircle()
   {
       gc.setFill(Color.PINK); 
       gc.fillOval(0, 0, 80,80);
   }
   
   public void clearCircle()
   {
     gc.clearRect(0,0,80,80);
   } 

}


public class Project extends Application 
{

      GridPane grid = new GridPane(); 

      private GamePane [][] gaming = new GamePane[4][4]; 
        
    
      private Button TL = new Button();       
      private Button TR = new Button();        
      private Button BL = new Button();        
      private Button BR = new Button(); 
      
      
    public void start(Stage primaryStage) 
    {
      
      // setting a default label
      
     VBox vbox1 = new VBox();
     Label texting = new Label(); 
     texting.setText("                      Balls Left: " + " " + "Possible Moves: " + " "); 
     vbox1.getChildren().add(texting);

     
     primaryStage.show();
     

      // grid pane and board pane
      
      BorderPane bp = new BorderPane();
      grid.setAlignment(Pos.CENTER);
      bp.setTop(vbox1);
      bp.setCenter(grid); 
                
      // Creating a loop that creates a 4 by 4 of the game pane in an array, making 0,2 empty 

      for (int i =0; i < 4; i++)
      {
         for (int j = 0; j < 4; j++)
         {  
            gaming[i][j] = new GamePane(); 
            grid.add(gaming[i][j],i,j);  

         }
      }
         
         gaming[2][0].setBallVisible(false); 
         gaming[0][0].setTL(true); 
         gaming[2][2].setTR(true); 
         gaming[0][2].draw(); 
        
      
     // setting the scene 
     
     Scene scene = new Scene(bp, 600, 600);
     primaryStage.setTitle("ball game");
     primaryStage.setScene(scene);
     primaryStage.show();
        
   }

  public class GamePane extends GridPane
  {
   
        Button TL = new Button();       
        Button TR = new Button();        
        Button BL = new Button();        
        Button BR = new Button();
        
        drawCanvas canvas = new drawCanvas();
        
      public GamePane()
      {
         // Setting up all buttons with sizes  

          TL.setPrefSize(80,20); 
          TR.setPrefSize(20,80); 
          BL.setPrefSize(20,80);
          BR.setPrefSize(80,20);
         
        //adding the buttons to grid using add from GridPane
        
         add(TL, 1, 0);
         add(TR, 2, 1);
         add(BL, 0, 1);
         add(BR, 1, 2);
         
         // 1,1 centers the canvas 
         add(canvas, 1, 1);
         canvas.drawCircle();
         
      } 
         
// START OF FUNCTIONALITY 

      // Boolean to see whether the ball is visible or not 
      
      // ball vis 
      
      private boolean ballVisible = true;
      
      public boolean getBallVisible()
      {
         return ballVisible;
      }
      
      public void setBallVisible(boolean in)
      {
         ballVisible = in;
      }
      
      // Top right Vis 
      
      private boolean TRVis = false; 
      
      public boolean getTR()
      {
          return TRVis; 
      }
      
      public void setTR(boolean hello)
      {
         TRVis = hello;
      }
      
      // Bottom right vis 
      
      private boolean BRVis = false;
      
      public boolean getBR()
      {
         return BRVis;
      }
      
      public void setBR(boolean hello)
      {
         BRVis = hello;
      }
      
      // Top left vis 
      
      private boolean TLVis = false;
      
      public boolean getTL()
      {
         return TLVis;
      }
      
      public void setTL (boolean hello)
      {
         TLVis = hello;
      }
      
      // Bottom left vis
      
       private boolean BLVis = false;
      
      public boolean getBL()
      {
         return BLVis;
      }
      
      public void setBL (boolean hello)
      {
         BLVis = hello;
      }
      
         private boolean seeCircle (boolean visibleCircle) 
         {
            visibleCircle = true;
            
            if (visibleCircle)
            {
               canvas.drawCircle(); 
            }
            if (!(visibleCircle))
            {
               canvas.clearCircle();
            }
            
            return visibleCircle; 
         }
        
      // "draw" method , displays and hides button--called whenever change is made to
      // game pane 
      
      private void draw()
      {               
         for (int i =0; i < 4; i++)
         {
            for (int j = 0; j < 4; j++)
            {  
       
       // Circles   
                      
               if (gaming[i][j].getBallVisible() == true)
               {
                  gaming[i][j].canvas.drawCircle(); 
               }
               else
               {
                  canvas.clearCircle(); 
               }
               
      // Buttons 
      
               if (gaming[i][j].getTL())
               {
                  gaming[i][j].TL.setVisible(true); 
               }
               else
               {  
                 gaming[i][j].TL.setVisible(false); 
               }
               
               if (gaming[i][j].getTR())
               {
                  gaming[i][j].TR.setVisible(true);
               } 
               else
               {
                 gaming[i][j].TR.setVisible(false); 
               }
               if (gaming[i][j].getBR())
               {
                  gaming[i][j].BR.setVisible(true);
               } 
               else
               {
                 gaming[i][j].BR.setVisible(false); 
               }
               if (gaming[i][j].getBL())
               {
                  gaming[i][j].BL.setVisible(true);
               } 
               else
               {
                 gaming[i][j].BL.setVisible(false); 
               }
                       
            }
         }
     }
       
    
    // Move method  that determines which moves can be made, and if moves are valid 
    
     public void move()
     {  
      int x;
      int y; 
      
      for (int i = 0; i< 4; i++)
      {
         for (int j = 0; j < 4; j++)
         {
            if (gaming[i][j].getBallVisible() == true && gaming[i][j+1].getBallVisible() == true && gaming[i][j+2].getBallVisible() == false );
            {
               gaming[i][j].TL.setVisible(true);
            }
            if (gaming[i][j].getBallVisible() == true && gaming[i][j-1].getBallVisible() == true && gaming[i][j+2].getBallVisible() == false );
            {
               gaming[i][j].TR.setVisible(true);
            }
            if (gaming[i][j].getBallVisible() == true && gaming[i][j+1].getBallVisible() == true && gaming[i][j+2].getBallVisible() == false );
            {
               gaming[i][j].BL.setVisible(true);
            }
            if (gaming[i][j].getBallVisible() == true && gaming[i][j-1].getBallVisible() == true && gaming[i][j+2].getBallVisible() == false );
            {
               gaming[i][j].BR.setVisible(true);
            }
         
         }
      } 
    }
       
   // event handler that calls method "click" when certain buttons are clicked \
   
  public class GamePaneListener implements EventHandler<ActionEvent> 
  {
    public void handle(ActionEvent event) 
    {
        if (event.getSource() == TL)
        {
            click(TL, grid.getRowIndex(GamePane.this), grid.getColumnIndex(GamePane.this));
        }
        if (event.getSource() == TR)
        {
           click(TR, grid.getRowIndex(GamePane.this), grid.getColumnIndex(GamePane.this));
        }
        if (event.getSource() == BL)
        {
          click(BR, grid.getRowIndex(GamePane.this), grid.getColumnIndex(GamePane.this));
        }
        if (event.getSource() == BR)
        {
          click(BR, grid.getRowIndex(GamePane.this), grid.getColumnIndex(GamePane.this));
        }
    }
}
     // click method outside of the gamePane, taking in which button is being clicked, and the x and y. 
     
     // Uses the grid pane as an array. 
     
   public void click(Button direction, int x, int y)
   { 
      GamePane [][] gp = new GamePane[x][y];
      
         if (direction == TR)
         {
//                 gaming[x - 1][y];
                gaming[x - 1][y].draw(); 
          }
          if (direction == BR)
          {
//                 gaming[x][y + 1];
                gaming[x][y + 1].draw(); 
          }
          if (direction == TL)
          {
//                 gaming[x + 1][y];
                gaming[x + 1][y].draw(); 
          } 
           if (direction == TR)
           {
//                 gaming[x][y - 1];
                gaming[x][y - 1].draw();
           }     
        }
      
      
   } 
     
  //   public void text(int balls, int moves) 
//     {
//     
//     
//     }
    
    
}// end of file 