package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PinchFace extends Component {
    private ArrayList<PointItem> points = new ArrayList<>();
    private ArrayList<PointItem> lastPoints = new ArrayList<>();
    private float strength = 1.0f;
    private boolean symmetry = true;
    private boolean fixPoints = false;
    private boolean editMode = false;
    private int width = 720;
    private int height = 960;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PinchFace) {
            PinchFace pinchFace = (PinchFace) componentBase;
            this.points = pinchFace.points;
            this.lastPoints = pinchFace.lastPoints;
            this.strength = pinchFace.strength;
            this.symmetry = pinchFace.symmetry;
            this.fixPoints = pinchFace.fixPoints;
            this.editMode = pinchFace.editMode;
            this.width = pinchFace.width;
            this.height = pinchFace.height;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEditMode() {
        return this.editMode;
    }

    public boolean getFixPoints() {
        return this.fixPoints;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<PointItem> getLastPoints() {
        return this.lastPoints;
    }

    public ArrayList<PointItem> getPoints() {
        return this.points;
    }

    public float getStrength() {
        return this.strength;
    }

    public boolean getSymmetry() {
        return this.symmetry;
    }

    public int getWidth() {
        return this.width;
    }

    public void setEditMode(boolean z16) {
        this.editMode = z16;
        reportPropertyChange("editMode", Boolean.valueOf(z16));
    }

    public void setFixPoints(boolean z16) {
        this.fixPoints = z16;
        reportPropertyChange("fixPoints", Boolean.valueOf(z16));
    }

    public void setHeight(int i3) {
        this.height = i3;
        reportPropertyChange("height", Integer.valueOf(i3));
    }

    public void setLastPoints(ArrayList<PointItem> arrayList) {
        this.lastPoints = arrayList;
        reportPropertyChange("lastPoints", arrayList);
    }

    public void setPoints(ArrayList<PointItem> arrayList) {
        this.points = arrayList;
        reportPropertyChange("points", arrayList);
    }

    public void setStrength(float f16) {
        this.strength = f16;
        reportPropertyChange("strength", Float.valueOf(f16));
    }

    public void setSymmetry(boolean z16) {
        this.symmetry = z16;
        reportPropertyChange("symmetry", Boolean.valueOf(z16));
    }

    public void setWidth(int i3) {
        this.width = i3;
        reportPropertyChange("width", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PinchFace";
    }
}
