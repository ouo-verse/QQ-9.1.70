package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.Light3DType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Light3DComponent extends Component {
    private float envRotation;
    private float innerAngle;
    private float intensity;
    private Light3DType lightType;
    private float outerAngle;
    private String lightColor = "";
    private float radius = 4.0f;
    private Vec3 position = new Vec3();
    private String iblPath = "";
    private String irradiancePath = "";
    private SkyBoxConfig skyBoxConfig = new SkyBoxConfig();
    private ShadowConfig shadowConfig = new ShadowConfig();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Light3DComponent) {
            Light3DComponent light3DComponent = (Light3DComponent) componentBase;
            this.lightType = light3DComponent.lightType;
            this.intensity = light3DComponent.intensity;
            this.lightColor = light3DComponent.lightColor;
            this.radius = light3DComponent.radius;
            this.position = light3DComponent.position;
            this.innerAngle = light3DComponent.innerAngle;
            this.outerAngle = light3DComponent.outerAngle;
            this.iblPath = light3DComponent.iblPath;
            this.irradiancePath = light3DComponent.irradiancePath;
            this.envRotation = light3DComponent.envRotation;
            this.skyBoxConfig = light3DComponent.skyBoxConfig;
            this.shadowConfig = light3DComponent.shadowConfig;
        }
        super.doUpdate(componentBase);
    }

    public float getEnvRotation() {
        return this.envRotation;
    }

    public String getIblPath() {
        return this.iblPath;
    }

    public float getInnerAngle() {
        return this.innerAngle;
    }

    public float getIntensity() {
        return this.intensity;
    }

    public String getIrradiancePath() {
        return this.irradiancePath;
    }

    public String getLightColor() {
        return this.lightColor;
    }

    public Light3DType getLightType() {
        return this.lightType;
    }

    public float getOuterAngle() {
        return this.outerAngle;
    }

    public Vec3 getPosition() {
        return this.position;
    }

    public float getRadius() {
        return this.radius;
    }

    public ShadowConfig getShadowConfig() {
        return this.shadowConfig;
    }

    public SkyBoxConfig getSkyBoxConfig() {
        return this.skyBoxConfig;
    }

    public void setEnvRotation(float f16) {
        this.envRotation = f16;
        reportPropertyChange("envRotation", Float.valueOf(f16));
    }

    public void setIblPath(String str) {
        this.iblPath = str;
        reportPropertyChange("iblPath", str);
    }

    public void setInnerAngle(float f16) {
        this.innerAngle = f16;
        reportPropertyChange("innerAngle", Float.valueOf(f16));
    }

    public void setIntensity(float f16) {
        this.intensity = f16;
        reportPropertyChange("intensity", Float.valueOf(f16));
    }

    public void setIrradiancePath(String str) {
        this.irradiancePath = str;
        reportPropertyChange("irradiancePath", str);
    }

    public void setLightColor(String str) {
        this.lightColor = str;
        reportPropertyChange("lightColor", str);
    }

    public void setLightType(Light3DType light3DType) {
        this.lightType = light3DType;
        reportPropertyChange("lightType", light3DType);
    }

    public void setOuterAngle(float f16) {
        this.outerAngle = f16;
        reportPropertyChange("outerAngle", Float.valueOf(f16));
    }

    public void setPosition(Vec3 vec3) {
        this.position = vec3;
        reportPropertyChange("position", vec3);
    }

    public void setRadius(float f16) {
        this.radius = f16;
        reportPropertyChange("radius", Float.valueOf(f16));
    }

    public void setShadowConfig(ShadowConfig shadowConfig) {
        this.shadowConfig = shadowConfig;
        reportPropertyChange("shadowConfig", shadowConfig);
    }

    public void setSkyBoxConfig(SkyBoxConfig skyBoxConfig) {
        this.skyBoxConfig = skyBoxConfig;
        reportPropertyChange("skyBoxConfig", skyBoxConfig);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Light3DComponent";
    }
}
