package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Face3DComponent extends Component {
    private boolean showUserHead;
    private int use3DMMHead;
    private boolean useCustom3DHead;
    private ArrayList<Integer> faceIndex = new ArrayList<>();
    private String custom3DHead = "";
    private int motionFaceIndex_ = 0;
    private boolean stopVertexUpdate = false;
    private boolean stopNormalUpdate = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Face3DComponent) {
            Face3DComponent face3DComponent = (Face3DComponent) componentBase;
            this.use3DMMHead = face3DComponent.use3DMMHead;
            this.showUserHead = face3DComponent.showUserHead;
            this.faceIndex = face3DComponent.faceIndex;
            this.useCustom3DHead = face3DComponent.useCustom3DHead;
            this.custom3DHead = face3DComponent.custom3DHead;
            this.motionFaceIndex_ = face3DComponent.motionFaceIndex_;
            this.stopVertexUpdate = face3DComponent.stopVertexUpdate;
            this.stopNormalUpdate = face3DComponent.stopNormalUpdate;
        }
        super.doUpdate(componentBase);
    }

    public String getCustom3DHead() {
        return this.custom3DHead;
    }

    public ArrayList<Integer> getFaceIndex() {
        return this.faceIndex;
    }

    public int getMotionFaceIndex_() {
        return this.motionFaceIndex_;
    }

    public boolean getShowUserHead() {
        return this.showUserHead;
    }

    public boolean getStopNormalUpdate() {
        return this.stopNormalUpdate;
    }

    public boolean getStopVertexUpdate() {
        return this.stopVertexUpdate;
    }

    public int getUse3DMMHead() {
        return this.use3DMMHead;
    }

    public boolean getUseCustom3DHead() {
        return this.useCustom3DHead;
    }

    public void setCustom3DHead(String str) {
        this.custom3DHead = str;
        reportPropertyChange("custom3DHead", str);
    }

    public void setFaceIndex(ArrayList<Integer> arrayList) {
        this.faceIndex = arrayList;
        reportPropertyChange("faceIndex", arrayList);
    }

    public void setMotionFaceIndex_(int i3) {
        this.motionFaceIndex_ = i3;
        reportPropertyChange("motionFaceIndex_", Integer.valueOf(i3));
    }

    public void setShowUserHead(boolean z16) {
        this.showUserHead = z16;
        reportPropertyChange("showUserHead", Boolean.valueOf(z16));
    }

    public void setStopNormalUpdate(boolean z16) {
        this.stopNormalUpdate = z16;
        reportPropertyChange("stopNormalUpdate", Boolean.valueOf(z16));
    }

    public void setStopVertexUpdate(boolean z16) {
        this.stopVertexUpdate = z16;
        reportPropertyChange("stopVertexUpdate", Boolean.valueOf(z16));
    }

    public void setUse3DMMHead(int i3) {
        this.use3DMMHead = i3;
        reportPropertyChange("use3DMMHead", Integer.valueOf(i3));
    }

    public void setUseCustom3DHead(boolean z16) {
        this.useCustom3DHead = z16;
        reportPropertyChange("useCustom3DHead", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Face3DComponent";
    }
}
