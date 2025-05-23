package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FaceInset extends Component {
    private Rect cutRange = new Rect();
    private String maskResource = "";
    private float Flip = 0.0f;
    private Vec2 scale = new Vec2();
    private String stretchResource = "";
    private String renderTarget = "";
    private String modelVersion = "V5";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FaceInset) {
            FaceInset faceInset = (FaceInset) componentBase;
            this.cutRange = faceInset.cutRange;
            this.maskResource = faceInset.maskResource;
            this.Flip = faceInset.Flip;
            this.scale = faceInset.scale;
            this.stretchResource = faceInset.stretchResource;
            this.renderTarget = faceInset.renderTarget;
            this.modelVersion = faceInset.modelVersion;
        }
        super.doUpdate(componentBase);
    }

    public Rect getCutRange() {
        return this.cutRange;
    }

    public float getFlip() {
        return this.Flip;
    }

    public String getMaskResource() {
        return this.maskResource;
    }

    public String getModelVersion() {
        return this.modelVersion;
    }

    public String getRenderTarget() {
        return this.renderTarget;
    }

    public Vec2 getScale() {
        return this.scale;
    }

    public String getStretchResource() {
        return this.stretchResource;
    }

    public void setCutRange(Rect rect) {
        this.cutRange = rect;
        reportPropertyChange("cutRange", rect);
    }

    public void setFlip(float f16) {
        this.Flip = f16;
        reportPropertyChange("Flip", Float.valueOf(f16));
    }

    public void setMaskResource(String str) {
        this.maskResource = str;
        reportPropertyChange("maskResource", str);
    }

    public void setModelVersion(String str) {
        this.modelVersion = str;
        reportPropertyChange("modelVersion", str);
    }

    public void setRenderTarget(String str) {
        this.renderTarget = str;
        reportPropertyChange("renderTarget", str);
    }

    public void setScale(Vec2 vec2) {
        this.scale = vec2;
        reportPropertyChange("scale", vec2);
    }

    public void setStretchResource(String str) {
        this.stretchResource = str;
        reportPropertyChange("stretchResource", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FaceInset";
    }
}
