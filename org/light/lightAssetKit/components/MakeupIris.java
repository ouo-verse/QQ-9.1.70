package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupIris extends MakeupComponent {
    private String irisImage = "";
    private String eyeMask = "";
    private float multRadius = 0.72f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupIris) {
            MakeupIris makeupIris = (MakeupIris) componentBase;
            this.irisImage = makeupIris.irisImage;
            this.eyeMask = makeupIris.eyeMask;
            this.multRadius = makeupIris.multRadius;
        }
        super.doUpdate(componentBase);
    }

    public String getEyeMask() {
        return this.eyeMask;
    }

    public String getIrisImage() {
        return this.irisImage;
    }

    public float getMultRadius() {
        return this.multRadius;
    }

    public void setEyeMask(String str) {
        this.eyeMask = str;
        reportPropertyChange("eyeMask", str);
    }

    public void setIrisImage(String str) {
        this.irisImage = str;
        reportPropertyChange("irisImage", str);
    }

    public void setMultRadius(float f16) {
        this.multRadius = f16;
        reportPropertyChange("multRadius", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupIris";
    }
}
