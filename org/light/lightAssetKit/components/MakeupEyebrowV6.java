package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupEyebrowV6 extends MakeupComponent {
    private String eyebrowImageName = "";
    private String eyebrowCropImageName = "";
    private Rect cropRect = new Rect();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupEyebrowV6) {
            MakeupEyebrowV6 makeupEyebrowV6 = (MakeupEyebrowV6) componentBase;
            this.eyebrowImageName = makeupEyebrowV6.eyebrowImageName;
            this.eyebrowCropImageName = makeupEyebrowV6.eyebrowCropImageName;
            this.cropRect = makeupEyebrowV6.cropRect;
        }
        super.doUpdate(componentBase);
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public String getEyebrowCropImageName() {
        return this.eyebrowCropImageName;
    }

    public String getEyebrowImageName() {
        return this.eyebrowImageName;
    }

    public void setCropRect(Rect rect) {
        this.cropRect = rect;
        reportPropertyChange("cropRect", rect);
    }

    public void setEyebrowCropImageName(String str) {
        this.eyebrowCropImageName = str;
        reportPropertyChange("eyebrowCropImageName", str);
    }

    public void setEyebrowImageName(String str) {
        this.eyebrowImageName = str;
        reportPropertyChange("eyebrowImageName", str);
    }

    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupEyebrowV6";
    }
}
