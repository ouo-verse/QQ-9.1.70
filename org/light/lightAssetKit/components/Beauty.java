package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Beauty extends Component {
    private String beautyVersion = "";
    private int subVersion = 0;
    private float lutClearAlpha = 0.0f;
    private float lutFoundationAlpha = 0.0f;
    private float faceFeatureBlendFaceAlphaSoftlight = 0.0f;
    private float faceFeatureBlendFaceAlphaRedCheek = 0.0f;
    private float faceFeatureBlendFaceAlpha = 0.0f;
    private float faceFeatureTeethLutAlpha = 0.0f;
    private float faceFeatureLipsLutAlpha = 0.0f;
    private float faceFeatureEyeMakeupAlpha = 0.0f;
    private float deepSmoothAlpha = 0.0f;
    private float wrinkleAlpha = 0.0f;
    private float eyeLightenAlpha = 0.0f;
    private float eyebrowContrastAlpha = 0.0f;
    private float imageContrastAlpha = 0.0f;
    private float skinColorSlider = 0.0f;
    private float eyePouchAlpha = 0.0f;
    private boolean enableFaceFeature = true;
    private int lipsType = 2;
    private float beautySmooth = 0.0f;
    private float beautySharpen = 0.0f;
    private float beautyExposure = 50.0f;
    private float facialShadowEye = 0.0f;
    private float facialShadowNose = 0.0f;
    private String softLightPath = "";
    private String beautyMultiplyPath = "";
    private String lipsMaskPath = "";
    private String eyeMakeupDefaultMaskPath = "";
    private String eyeMakeupMaleMaskPath = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Beauty) {
            Beauty beauty = (Beauty) componentBase;
            this.beautyVersion = beauty.beautyVersion;
            this.subVersion = beauty.subVersion;
            this.lutClearAlpha = beauty.lutClearAlpha;
            this.lutFoundationAlpha = beauty.lutFoundationAlpha;
            this.faceFeatureBlendFaceAlphaSoftlight = beauty.faceFeatureBlendFaceAlphaSoftlight;
            this.faceFeatureBlendFaceAlphaRedCheek = beauty.faceFeatureBlendFaceAlphaRedCheek;
            this.faceFeatureBlendFaceAlpha = beauty.faceFeatureBlendFaceAlpha;
            this.faceFeatureTeethLutAlpha = beauty.faceFeatureTeethLutAlpha;
            this.faceFeatureLipsLutAlpha = beauty.faceFeatureLipsLutAlpha;
            this.faceFeatureEyeMakeupAlpha = beauty.faceFeatureEyeMakeupAlpha;
            this.deepSmoothAlpha = beauty.deepSmoothAlpha;
            this.wrinkleAlpha = beauty.wrinkleAlpha;
            this.eyeLightenAlpha = beauty.eyeLightenAlpha;
            this.eyebrowContrastAlpha = beauty.eyebrowContrastAlpha;
            this.imageContrastAlpha = beauty.imageContrastAlpha;
            this.skinColorSlider = beauty.skinColorSlider;
            this.eyePouchAlpha = beauty.eyePouchAlpha;
            this.enableFaceFeature = beauty.enableFaceFeature;
            this.lipsType = beauty.lipsType;
            this.beautySmooth = beauty.beautySmooth;
            this.beautySharpen = beauty.beautySharpen;
            this.beautyExposure = beauty.beautyExposure;
            this.facialShadowEye = beauty.facialShadowEye;
            this.facialShadowNose = beauty.facialShadowNose;
            this.softLightPath = beauty.softLightPath;
            this.beautyMultiplyPath = beauty.beautyMultiplyPath;
            this.lipsMaskPath = beauty.lipsMaskPath;
            this.eyeMakeupDefaultMaskPath = beauty.eyeMakeupDefaultMaskPath;
            this.eyeMakeupMaleMaskPath = beauty.eyeMakeupMaleMaskPath;
        }
        super.doUpdate(componentBase);
    }

    public float getBeautyExposure() {
        return this.beautyExposure;
    }

    public String getBeautyMultiplyPath() {
        return this.beautyMultiplyPath;
    }

    public float getBeautySharpen() {
        return this.beautySharpen;
    }

    public float getBeautySmooth() {
        return this.beautySmooth;
    }

    public String getBeautyVersion() {
        return this.beautyVersion;
    }

    public float getDeepSmoothAlpha() {
        return this.deepSmoothAlpha;
    }

    public boolean getEnableFaceFeature() {
        return this.enableFaceFeature;
    }

    public float getEyeLightenAlpha() {
        return this.eyeLightenAlpha;
    }

    public String getEyeMakeupDefaultMaskPath() {
        return this.eyeMakeupDefaultMaskPath;
    }

    public String getEyeMakeupMaleMaskPath() {
        return this.eyeMakeupMaleMaskPath;
    }

    public float getEyePouchAlpha() {
        return this.eyePouchAlpha;
    }

    public float getEyebrowContrastAlpha() {
        return this.eyebrowContrastAlpha;
    }

    public float getFaceFeatureBlendFaceAlpha() {
        return this.faceFeatureBlendFaceAlpha;
    }

    public float getFaceFeatureBlendFaceAlphaRedCheek() {
        return this.faceFeatureBlendFaceAlphaRedCheek;
    }

    public float getFaceFeatureBlendFaceAlphaSoftlight() {
        return this.faceFeatureBlendFaceAlphaSoftlight;
    }

    public float getFaceFeatureEyeMakeupAlpha() {
        return this.faceFeatureEyeMakeupAlpha;
    }

    public float getFaceFeatureLipsLutAlpha() {
        return this.faceFeatureLipsLutAlpha;
    }

    public float getFaceFeatureTeethLutAlpha() {
        return this.faceFeatureTeethLutAlpha;
    }

    public float getFacialShadowEye() {
        return this.facialShadowEye;
    }

    public float getFacialShadowNose() {
        return this.facialShadowNose;
    }

    public float getImageContrastAlpha() {
        return this.imageContrastAlpha;
    }

    public String getLipsMaskPath() {
        return this.lipsMaskPath;
    }

    public int getLipsType() {
        return this.lipsType;
    }

    public float getLutClearAlpha() {
        return this.lutClearAlpha;
    }

    public float getLutFoundationAlpha() {
        return this.lutFoundationAlpha;
    }

    public float getSkinColorSlider() {
        return this.skinColorSlider;
    }

    public String getSoftLightPath() {
        return this.softLightPath;
    }

    public int getSubVersion() {
        return this.subVersion;
    }

    public float getWrinkleAlpha() {
        return this.wrinkleAlpha;
    }

    public void setBeautyExposure(float f16) {
        this.beautyExposure = f16;
        reportPropertyChange("beautyExposure", Float.valueOf(f16));
    }

    public void setBeautyMultiplyPath(String str) {
        this.beautyMultiplyPath = str;
        reportPropertyChange("beautyMultiplyPath", str);
    }

    public void setBeautySharpen(float f16) {
        this.beautySharpen = f16;
        reportPropertyChange("beautySharpen", Float.valueOf(f16));
    }

    public void setBeautySmooth(float f16) {
        this.beautySmooth = f16;
        reportPropertyChange("beautySmooth", Float.valueOf(f16));
    }

    public void setBeautyVersion(String str) {
        this.beautyVersion = str;
        reportPropertyChange("beautyVersion", str);
    }

    public void setDeepSmoothAlpha(float f16) {
        this.deepSmoothAlpha = f16;
        reportPropertyChange("deepSmoothAlpha", Float.valueOf(f16));
    }

    public void setEnableFaceFeature(boolean z16) {
        this.enableFaceFeature = z16;
        reportPropertyChange("enableFaceFeature", Boolean.valueOf(z16));
    }

    public void setEyeLightenAlpha(float f16) {
        this.eyeLightenAlpha = f16;
        reportPropertyChange("eyeLightenAlpha", Float.valueOf(f16));
    }

    public void setEyeMakeupDefaultMaskPath(String str) {
        this.eyeMakeupDefaultMaskPath = str;
        reportPropertyChange("eyeMakeupDefaultMaskPath", str);
    }

    public void setEyeMakeupMaleMaskPath(String str) {
        this.eyeMakeupMaleMaskPath = str;
        reportPropertyChange("eyeMakeupMaleMaskPath", str);
    }

    public void setEyePouchAlpha(float f16) {
        this.eyePouchAlpha = f16;
        reportPropertyChange("eyePouchAlpha", Float.valueOf(f16));
    }

    public void setEyebrowContrastAlpha(float f16) {
        this.eyebrowContrastAlpha = f16;
        reportPropertyChange("eyebrowContrastAlpha", Float.valueOf(f16));
    }

    public void setFaceFeatureBlendFaceAlpha(float f16) {
        this.faceFeatureBlendFaceAlpha = f16;
        reportPropertyChange("faceFeatureBlendFaceAlpha", Float.valueOf(f16));
    }

    public void setFaceFeatureBlendFaceAlphaRedCheek(float f16) {
        this.faceFeatureBlendFaceAlphaRedCheek = f16;
        reportPropertyChange("faceFeatureBlendFaceAlphaRedCheek", Float.valueOf(f16));
    }

    public void setFaceFeatureBlendFaceAlphaSoftlight(float f16) {
        this.faceFeatureBlendFaceAlphaSoftlight = f16;
        reportPropertyChange("faceFeatureBlendFaceAlphaSoftlight", Float.valueOf(f16));
    }

    public void setFaceFeatureEyeMakeupAlpha(float f16) {
        this.faceFeatureEyeMakeupAlpha = f16;
        reportPropertyChange("faceFeatureEyeMakeupAlpha", Float.valueOf(f16));
    }

    public void setFaceFeatureLipsLutAlpha(float f16) {
        this.faceFeatureLipsLutAlpha = f16;
        reportPropertyChange("faceFeatureLipsLutAlpha", Float.valueOf(f16));
    }

    public void setFaceFeatureTeethLutAlpha(float f16) {
        this.faceFeatureTeethLutAlpha = f16;
        reportPropertyChange("faceFeatureTeethLutAlpha", Float.valueOf(f16));
    }

    public void setFacialShadowEye(float f16) {
        this.facialShadowEye = f16;
        reportPropertyChange("facialShadowEye", Float.valueOf(f16));
    }

    public void setFacialShadowNose(float f16) {
        this.facialShadowNose = f16;
        reportPropertyChange("facialShadowNose", Float.valueOf(f16));
    }

    public void setImageContrastAlpha(float f16) {
        this.imageContrastAlpha = f16;
        reportPropertyChange("imageContrastAlpha", Float.valueOf(f16));
    }

    public void setLipsMaskPath(String str) {
        this.lipsMaskPath = str;
        reportPropertyChange("lipsMaskPath", str);
    }

    public void setLipsType(int i3) {
        this.lipsType = i3;
        reportPropertyChange("lipsType", Integer.valueOf(i3));
    }

    public void setLutClearAlpha(float f16) {
        this.lutClearAlpha = f16;
        reportPropertyChange("lutClearAlpha", Float.valueOf(f16));
    }

    public void setLutFoundationAlpha(float f16) {
        this.lutFoundationAlpha = f16;
        reportPropertyChange("lutFoundationAlpha", Float.valueOf(f16));
    }

    public void setSkinColorSlider(float f16) {
        this.skinColorSlider = f16;
        reportPropertyChange("skinColorSlider", Float.valueOf(f16));
    }

    public void setSoftLightPath(String str) {
        this.softLightPath = str;
        reportPropertyChange("softLightPath", str);
    }

    public void setSubVersion(int i3) {
        this.subVersion = i3;
        reportPropertyChange("subVersion", Integer.valueOf(i3));
    }

    public void setWrinkleAlpha(float f16) {
        this.wrinkleAlpha = f16;
        reportPropertyChange("wrinkleAlpha", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Beauty";
    }
}
