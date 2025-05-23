package org.light.lightAssetKit.components;

import java.util.ArrayList;
import java.util.Arrays;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TrackingComponent extends Component {
    private ArrayList<Integer> alignPoints = new ArrayList<>(Arrays.asList(64));
    private int scalePivotPoint1 = 0;
    private int scalePivotPoint2 = 18;
    private boolean xAxisTrack = true;
    private boolean yAxisTrack = true;
    private boolean xAxisRotateTrack = true;
    private boolean yAxisRotateTrack = true;
    private boolean zAxisRotateTrack = true;
    private boolean xAxisScale = true;
    private boolean yAxisScale = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof TrackingComponent) {
            TrackingComponent trackingComponent = (TrackingComponent) componentBase;
            this.alignPoints = trackingComponent.alignPoints;
            this.scalePivotPoint1 = trackingComponent.scalePivotPoint1;
            this.scalePivotPoint2 = trackingComponent.scalePivotPoint2;
            this.xAxisTrack = trackingComponent.xAxisTrack;
            this.yAxisTrack = trackingComponent.yAxisTrack;
            this.xAxisRotateTrack = trackingComponent.xAxisRotateTrack;
            this.yAxisRotateTrack = trackingComponent.yAxisRotateTrack;
            this.zAxisRotateTrack = trackingComponent.zAxisRotateTrack;
            this.xAxisScale = trackingComponent.xAxisScale;
            this.yAxisScale = trackingComponent.yAxisScale;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<Integer> getAlignPoints() {
        return this.alignPoints;
    }

    public int getScalePivotPoint1() {
        return this.scalePivotPoint1;
    }

    public int getScalePivotPoint2() {
        return this.scalePivotPoint2;
    }

    public boolean getXAxisRotateTrack() {
        return this.xAxisRotateTrack;
    }

    public boolean getXAxisScale() {
        return this.xAxisScale;
    }

    public boolean getXAxisTrack() {
        return this.xAxisTrack;
    }

    public boolean getYAxisRotateTrack() {
        return this.yAxisRotateTrack;
    }

    public boolean getYAxisScale() {
        return this.yAxisScale;
    }

    public boolean getYAxisTrack() {
        return this.yAxisTrack;
    }

    public boolean getZAxisRotateTrack() {
        return this.zAxisRotateTrack;
    }

    public void setAlignPoints(ArrayList<Integer> arrayList) {
        this.alignPoints = arrayList;
        reportPropertyChange("alignPoints", arrayList);
    }

    public void setScalePivotPoint1(int i3) {
        this.scalePivotPoint1 = i3;
        reportPropertyChange("scalePivotPoint1", Integer.valueOf(i3));
    }

    public void setScalePivotPoint2(int i3) {
        this.scalePivotPoint2 = i3;
        reportPropertyChange("scalePivotPoint2", Integer.valueOf(i3));
    }

    public void setXAxisRotateTrack(boolean z16) {
        this.xAxisRotateTrack = z16;
        reportPropertyChange("xAxisRotateTrack", Boolean.valueOf(z16));
    }

    public void setXAxisScale(boolean z16) {
        this.xAxisScale = z16;
        reportPropertyChange("xAxisScale", Boolean.valueOf(z16));
    }

    public void setXAxisTrack(boolean z16) {
        this.xAxisTrack = z16;
        reportPropertyChange("xAxisTrack", Boolean.valueOf(z16));
    }

    public void setYAxisRotateTrack(boolean z16) {
        this.yAxisRotateTrack = z16;
        reportPropertyChange("yAxisRotateTrack", Boolean.valueOf(z16));
    }

    public void setYAxisScale(boolean z16) {
        this.yAxisScale = z16;
        reportPropertyChange("yAxisScale", Boolean.valueOf(z16));
    }

    public void setYAxisTrack(boolean z16) {
        this.yAxisTrack = z16;
        reportPropertyChange("yAxisTrack", Boolean.valueOf(z16));
    }

    public void setZAxisRotateTrack(boolean z16) {
        this.zAxisRotateTrack = z16;
        reportPropertyChange("zAxisRotateTrack", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "TrackingComponent";
    }
}
