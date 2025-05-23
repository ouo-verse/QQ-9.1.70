package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class Paint extends Component {
    private String canvasColor = "#00000000";
    private String brushColor = "#FFFFFFFF";
    private int brushSize = 100;
    private String brushImage = "";
    private String renderTarget = "";
    private int paintMode = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Paint) {
            Paint paint = (Paint) componentBase;
            this.canvasColor = paint.canvasColor;
            this.brushColor = paint.brushColor;
            this.brushSize = paint.brushSize;
            this.brushImage = paint.brushImage;
            this.renderTarget = paint.renderTarget;
            this.paintMode = paint.paintMode;
        }
        super.doUpdate(componentBase);
    }

    public String getBrushColor() {
        return this.brushColor;
    }

    public String getBrushImage() {
        return this.brushImage;
    }

    public int getBrushSize() {
        return this.brushSize;
    }

    public String getCanvasColor() {
        return this.canvasColor;
    }

    public int getPaintMode() {
        return this.paintMode;
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public void setBrushColor(String str) {
        this.brushColor = str;
        reportPropertyChange("brushColor", str);
    }

    public void setBrushImage(String str) {
        this.brushImage = str;
        reportPropertyChange("brushImage", str);
    }

    public void setBrushSize(int i3) {
        this.brushSize = i3;
        reportPropertyChange("brushSize", Integer.valueOf(i3));
    }

    public void setCanvasColor(String str) {
        this.canvasColor = str;
        reportPropertyChange("canvasColor", str);
    }

    public void setPaintMode(int i3) {
        this.paintMode = i3;
        reportPropertyChange("paintMode", Integer.valueOf(i3));
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Paint";
    }
}
