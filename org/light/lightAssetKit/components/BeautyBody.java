package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BeautyBody extends Component {
    private float longLegStrength = 0.0f;
    private float thinBodyStrength = 0.0f;
    private float autothinBodyStrength = 0.0f;
    private float thinShoulderStrength = 0.0f;
    private float slimWaistStrength = 0.0f;
    private float slimHeadStrength = 0.0f;
    private float slimLegStrength = 0.0f;
    private float thinBodyParamMin = 1.05f;
    private float thinBodyParamMax = 1.2f;
    private float thinBodyParamOver = 1.3f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BeautyBody) {
            BeautyBody beautyBody = (BeautyBody) componentBase;
            this.longLegStrength = beautyBody.longLegStrength;
            this.thinBodyStrength = beautyBody.thinBodyStrength;
            this.autothinBodyStrength = beautyBody.autothinBodyStrength;
            this.thinShoulderStrength = beautyBody.thinShoulderStrength;
            this.slimWaistStrength = beautyBody.slimWaistStrength;
            this.slimHeadStrength = beautyBody.slimHeadStrength;
            this.slimLegStrength = beautyBody.slimLegStrength;
            this.thinBodyParamMin = beautyBody.thinBodyParamMin;
            this.thinBodyParamMax = beautyBody.thinBodyParamMax;
            this.thinBodyParamOver = beautyBody.thinBodyParamOver;
        }
        super.doUpdate(componentBase);
    }

    public float getAutothinBodyStrength() {
        return this.autothinBodyStrength;
    }

    public float getLongLegStrength() {
        return this.longLegStrength;
    }

    public float getSlimHeadStrength() {
        return this.slimHeadStrength;
    }

    public float getSlimLegStrength() {
        return this.slimLegStrength;
    }

    public float getSlimWaistStrength() {
        return this.slimWaistStrength;
    }

    public float getThinBodyParamMax() {
        return this.thinBodyParamMax;
    }

    public float getThinBodyParamMin() {
        return this.thinBodyParamMin;
    }

    public float getThinBodyParamOver() {
        return this.thinBodyParamOver;
    }

    public float getThinBodyStrength() {
        return this.thinBodyStrength;
    }

    public float getThinShoulderStrength() {
        return this.thinShoulderStrength;
    }

    public void setAutothinBodyStrength(float f16) {
        this.autothinBodyStrength = f16;
        reportPropertyChange("autothinBodyStrength", Float.valueOf(f16));
    }

    public void setLongLegStrength(float f16) {
        this.longLegStrength = f16;
        reportPropertyChange("longLegStrength", Float.valueOf(f16));
    }

    public void setSlimHeadStrength(float f16) {
        this.slimHeadStrength = f16;
        reportPropertyChange("slimHeadStrength", Float.valueOf(f16));
    }

    public void setSlimLegStrength(float f16) {
        this.slimLegStrength = f16;
        reportPropertyChange("slimLegStrength", Float.valueOf(f16));
    }

    public void setSlimWaistStrength(float f16) {
        this.slimWaistStrength = f16;
        reportPropertyChange("slimWaistStrength", Float.valueOf(f16));
    }

    public void setThinBodyParamMax(float f16) {
        this.thinBodyParamMax = f16;
        reportPropertyChange("thinBodyParamMax", Float.valueOf(f16));
    }

    public void setThinBodyParamMin(float f16) {
        this.thinBodyParamMin = f16;
        reportPropertyChange("thinBodyParamMin", Float.valueOf(f16));
    }

    public void setThinBodyParamOver(float f16) {
        this.thinBodyParamOver = f16;
        reportPropertyChange("thinBodyParamOver", Float.valueOf(f16));
    }

    public void setThinBodyStrength(float f16) {
        this.thinBodyStrength = f16;
        reportPropertyChange("thinBodyStrength", Float.valueOf(f16));
    }

    public void setThinShoulderStrength(float f16) {
        this.thinShoulderStrength = f16;
        reportPropertyChange("thinShoulderStrength", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BeautyBody";
    }
}
