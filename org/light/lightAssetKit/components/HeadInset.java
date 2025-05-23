package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HeadInset extends Component {
    private String renderTarget = "";
    private boolean isCorrected = true;
    private float blurRadius = 3.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof HeadInset) {
            HeadInset headInset = (HeadInset) componentBase;
            this.renderTarget = headInset.renderTarget;
            this.isCorrected = headInset.isCorrected;
            this.blurRadius = headInset.blurRadius;
        }
        super.doUpdate(componentBase);
    }

    public float getBlurRadius() {
        return this.blurRadius;
    }

    public boolean getIsCorrected() {
        return this.isCorrected;
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public void setBlurRadius(float f16) {
        this.blurRadius = f16;
        reportPropertyChange("blurRadius", Float.valueOf(f16));
    }

    public void setIsCorrected(boolean z16) {
        this.isCorrected = z16;
        reportPropertyChange("isCorrected", Boolean.valueOf(z16));
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "HeadInset";
    }
}
