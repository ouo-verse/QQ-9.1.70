package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupFace extends MakeupComponent {
    private boolean faceExchangeImageDisableFaceCrop = false;
    private boolean faceExchangeImageEnableOpacity = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupFace) {
            MakeupFace makeupFace = (MakeupFace) componentBase;
            this.faceExchangeImageDisableFaceCrop = makeupFace.faceExchangeImageDisableFaceCrop;
            this.faceExchangeImageEnableOpacity = makeupFace.faceExchangeImageEnableOpacity;
        }
        super.doUpdate(componentBase);
    }

    public boolean getFaceExchangeImageDisableFaceCrop() {
        return this.faceExchangeImageDisableFaceCrop;
    }

    public boolean getFaceExchangeImageEnableOpacity() {
        return this.faceExchangeImageEnableOpacity;
    }

    public void setFaceExchangeImageDisableFaceCrop(boolean z16) {
        this.faceExchangeImageDisableFaceCrop = z16;
        reportPropertyChange("faceExchangeImageDisableFaceCrop", Boolean.valueOf(z16));
    }

    public void setFaceExchangeImageEnableOpacity(boolean z16) {
        this.faceExchangeImageEnableOpacity = z16;
        reportPropertyChange("faceExchangeImageEnableOpacity", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupFace";
    }
}
