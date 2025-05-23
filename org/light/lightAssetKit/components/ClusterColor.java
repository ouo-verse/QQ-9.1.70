package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClusterColor extends Component {
    private boolean colorReady;
    private String colorRenderTargetID = "";
    private int colorNum = 4;
    private int clusterColorNum = 16;
    private ArrayList<ColorItem> colorArray = new ArrayList<>();
    private boolean isSync = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ClusterColor) {
            ClusterColor clusterColor = (ClusterColor) componentBase;
            this.colorRenderTargetID = clusterColor.colorRenderTargetID;
            this.colorNum = clusterColor.colorNum;
            this.clusterColorNum = clusterColor.clusterColorNum;
            this.colorReady = clusterColor.colorReady;
            this.colorArray = clusterColor.colorArray;
            this.isSync = clusterColor.isSync;
        }
        super.doUpdate(componentBase);
    }

    public int getClusterColorNum() {
        return this.clusterColorNum;
    }

    public ArrayList<ColorItem> getColorArray() {
        return this.colorArray;
    }

    public int getColorNum() {
        return this.colorNum;
    }

    public boolean getColorReady() {
        return this.colorReady;
    }

    public String getColorRenderTargetID() {
        return this.colorRenderTargetID;
    }

    public boolean getIsSync() {
        return this.isSync;
    }

    public void setClusterColorNum(int i3) {
        this.clusterColorNum = i3;
        reportPropertyChange("clusterColorNum", Integer.valueOf(i3));
    }

    public void setColorArray(ArrayList<ColorItem> arrayList) {
        this.colorArray = arrayList;
        reportPropertyChange("colorArray", arrayList);
    }

    public void setColorNum(int i3) {
        this.colorNum = i3;
        reportPropertyChange("colorNum", Integer.valueOf(i3));
    }

    public void setColorReady(boolean z16) {
        this.colorReady = z16;
        reportPropertyChange("colorReady", Boolean.valueOf(z16));
    }

    public void setColorRenderTargetID(String str) {
        this.colorRenderTargetID = str;
        reportPropertyChange("colorRenderTargetID", str);
    }

    public void setIsSync(boolean z16) {
        this.isSync = z16;
        reportPropertyChange("isSync", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ClusterColor";
    }
}
