package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.LightEstimateType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightEstimateComponent extends Component {
    private LightEstimateType lightEstimateType;
    private String renderTargetKey = "";
    private String imagePath = "";
    private boolean enableLightIntensity = true;
    private float lightIntensityMax = 50.0f;
    private float lightIntensityMin = 0.0f;
    private boolean enableLightColor = true;
    private boolean enableLightDirection = true;
    private boolean useScriptSet = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof LightEstimateComponent) {
            LightEstimateComponent lightEstimateComponent = (LightEstimateComponent) componentBase;
            this.lightEstimateType = lightEstimateComponent.lightEstimateType;
            this.renderTargetKey = lightEstimateComponent.renderTargetKey;
            this.imagePath = lightEstimateComponent.imagePath;
            this.enableLightIntensity = lightEstimateComponent.enableLightIntensity;
            this.lightIntensityMax = lightEstimateComponent.lightIntensityMax;
            this.lightIntensityMin = lightEstimateComponent.lightIntensityMin;
            this.enableLightColor = lightEstimateComponent.enableLightColor;
            this.enableLightDirection = lightEstimateComponent.enableLightDirection;
            this.useScriptSet = lightEstimateComponent.useScriptSet;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEnableLightColor() {
        return this.enableLightColor;
    }

    public boolean getEnableLightDirection() {
        return this.enableLightDirection;
    }

    public boolean getEnableLightIntensity() {
        return this.enableLightIntensity;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public LightEstimateType getLightEstimateType() {
        return this.lightEstimateType;
    }

    public float getLightIntensityMax() {
        return this.lightIntensityMax;
    }

    public float getLightIntensityMin() {
        return this.lightIntensityMin;
    }

    public String getRenderTargetKey() {
        return this.renderTargetKey;
    }

    public boolean getUseScriptSet() {
        return this.useScriptSet;
    }

    public void setEnableLightColor(boolean z16) {
        this.enableLightColor = z16;
        reportPropertyChange("enableLightColor", Boolean.valueOf(z16));
    }

    public void setEnableLightDirection(boolean z16) {
        this.enableLightDirection = z16;
        reportPropertyChange("enableLightDirection", Boolean.valueOf(z16));
    }

    public void setEnableLightIntensity(boolean z16) {
        this.enableLightIntensity = z16;
        reportPropertyChange("enableLightIntensity", Boolean.valueOf(z16));
    }

    public void setImagePath(String str) {
        this.imagePath = str;
        reportPropertyChange("imagePath", str);
    }

    public void setLightEstimateType(LightEstimateType lightEstimateType) {
        this.lightEstimateType = lightEstimateType;
        reportPropertyChange("lightEstimateType", lightEstimateType);
    }

    public void setLightIntensityMax(float f16) {
        this.lightIntensityMax = f16;
        reportPropertyChange("lightIntensityMax", Float.valueOf(f16));
    }

    public void setLightIntensityMin(float f16) {
        this.lightIntensityMin = f16;
        reportPropertyChange("lightIntensityMin", Float.valueOf(f16));
    }

    public void setRenderTargetKey(String str) {
        this.renderTargetKey = str;
        reportPropertyChange("renderTargetKey", str);
    }

    public void setUseScriptSet(boolean z16) {
        this.useScriptSet = z16;
        reportPropertyChange("useScriptSet", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "LightEstimateComponent";
    }
}
