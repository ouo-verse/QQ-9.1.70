package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodyTracking3D extends Component {
    private boolean directionalScale;
    private boolean followSpin;
    private float smoothLevel;
    private boolean syncSpin;
    private int followEntityId = -1;
    private String firstKeyPointName = "";
    private String secondKeyPointName = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BodyTracking3D) {
            BodyTracking3D bodyTracking3D = (BodyTracking3D) componentBase;
            this.followEntityId = bodyTracking3D.followEntityId;
            this.firstKeyPointName = bodyTracking3D.firstKeyPointName;
            this.secondKeyPointName = bodyTracking3D.secondKeyPointName;
            this.smoothLevel = bodyTracking3D.smoothLevel;
            this.followSpin = bodyTracking3D.followSpin;
            this.syncSpin = bodyTracking3D.syncSpin;
            this.directionalScale = bodyTracking3D.directionalScale;
        }
        super.doUpdate(componentBase);
    }

    public boolean getDirectionalScale() {
        return this.directionalScale;
    }

    public String getFirstKeyPointName() {
        return this.firstKeyPointName;
    }

    public int getFollowEntityId() {
        return this.followEntityId;
    }

    public boolean getFollowSpin() {
        return this.followSpin;
    }

    public String getSecondKeyPointName() {
        return this.secondKeyPointName;
    }

    public float getSmoothLevel() {
        return this.smoothLevel;
    }

    public boolean getSyncSpin() {
        return this.syncSpin;
    }

    public void setDirectionalScale(boolean z16) {
        this.directionalScale = z16;
        reportPropertyChange("directionalScale", Boolean.valueOf(z16));
    }

    public void setFirstKeyPointName(String str) {
        this.firstKeyPointName = str;
        reportPropertyChange("firstKeyPointName", str);
    }

    public void setFollowEntityId(int i3) {
        this.followEntityId = i3;
        reportPropertyChange("followEntityId", Integer.valueOf(i3));
    }

    public void setFollowSpin(boolean z16) {
        this.followSpin = z16;
        reportPropertyChange("followSpin", Boolean.valueOf(z16));
    }

    public void setSecondKeyPointName(String str) {
        this.secondKeyPointName = str;
        reportPropertyChange("secondKeyPointName", str);
    }

    public void setSmoothLevel(float f16) {
        this.smoothLevel = f16;
        reportPropertyChange("smoothLevel", Float.valueOf(f16));
    }

    public void setSyncSpin(boolean z16) {
        this.syncSpin = z16;
        reportPropertyChange("syncSpin", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BodyTracking3D";
    }
}
