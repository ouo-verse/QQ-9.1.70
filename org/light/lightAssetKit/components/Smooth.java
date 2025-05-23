package org.light.lightAssetKit.components;

import com.tencent.qcircle.weishi.module.publisher.model.AIModelConfig;
import org.light.LightConstants;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.SmoothSharpenType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Smooth extends Component {
    private float smooth = 0.6f;
    private float faceColorAlpha = 0.0f;
    private float sharpenStrength = 0.0f;
    private float brightenEyeStrength = 1.0f;
    private float exposureValue = 50.0f;
    private float averageSkinDegree = 0.0f;
    private SmoothSharpenType sharpenType = SmoothSharpenType.SharpenDefault;
    private int histogramMinVal = 0;
    private int histogramMaxVal = 255;
    private String smoothVersion = "v6";
    private int subVersion = 0;
    private boolean overallSmooth = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Smooth) {
            Smooth smooth = (Smooth) componentBase;
            this.smooth = smooth.smooth;
            this.faceColorAlpha = smooth.faceColorAlpha;
            this.sharpenStrength = smooth.sharpenStrength;
            this.brightenEyeStrength = smooth.brightenEyeStrength;
            this.exposureValue = smooth.exposureValue;
            this.averageSkinDegree = smooth.averageSkinDegree;
            this.sharpenType = smooth.sharpenType;
            this.histogramMinVal = smooth.histogramMinVal;
            this.histogramMaxVal = smooth.histogramMaxVal;
            this.smoothVersion = smooth.smoothVersion;
            this.subVersion = smooth.subVersion;
            this.overallSmooth = smooth.overallSmooth;
        }
        super.doUpdate(componentBase);
    }

    public float getAverageSkinDegree() {
        return this.averageSkinDegree;
    }

    public float getBrightenEyeStrength() {
        return this.brightenEyeStrength;
    }

    public float getExposureValue() {
        return this.exposureValue;
    }

    public float getFaceColorAlpha() {
        return this.faceColorAlpha;
    }

    public int getHistogramMaxVal() {
        return this.histogramMaxVal;
    }

    public int getHistogramMinVal() {
        return this.histogramMinVal;
    }

    public boolean getOverallSmooth() {
        return this.overallSmooth;
    }

    public float getSharpenStrength() {
        return this.sharpenStrength;
    }

    public SmoothSharpenType getSharpenType() {
        return this.sharpenType;
    }

    public float getSmooth() {
        return this.smooth;
    }

    public String getSmoothVersion() {
        return this.smoothVersion;
    }

    public int getSubVersion() {
        return this.subVersion;
    }

    public void setAverageSkinDegree(float f16) {
        this.averageSkinDegree = f16;
        reportPropertyChange("averageSkinDegree", Float.valueOf(f16));
    }

    public void setBrightenEyeStrength(float f16) {
        this.brightenEyeStrength = f16;
        reportPropertyChange("brightenEyeStrength", Float.valueOf(f16));
    }

    public void setExposureValue(float f16) {
        this.exposureValue = f16;
        reportPropertyChange("exposureValue", Float.valueOf(f16));
    }

    public void setFaceColorAlpha(float f16) {
        this.faceColorAlpha = f16;
        reportPropertyChange("faceColorAlpha", Float.valueOf(f16));
    }

    public void setHistogramMaxVal(int i3) {
        this.histogramMaxVal = i3;
        reportPropertyChange("histogramMaxVal", Integer.valueOf(i3));
    }

    public void setHistogramMinVal(int i3) {
        this.histogramMinVal = i3;
        reportPropertyChange("histogramMinVal", Integer.valueOf(i3));
    }

    public void setOverallSmooth(boolean z16) {
        this.overallSmooth = z16;
        reportPropertyChange("overallSmooth", Boolean.valueOf(z16));
    }

    public void setSharpenStrength(float f16) {
        this.sharpenStrength = f16;
        reportPropertyChange("sharpenStrength", Float.valueOf(f16));
    }

    public void setSharpenType(SmoothSharpenType smoothSharpenType) {
        this.sharpenType = smoothSharpenType;
        reportPropertyChange("sharpenType", smoothSharpenType);
    }

    public void setSmooth(float f16) {
        this.smooth = f16;
        reportPropertyChange(LightConstants.DowngradeStrategyKey.SMOOTH, Float.valueOf(f16));
    }

    public void setSmoothVersion(String str) {
        this.smoothVersion = str;
        reportPropertyChange(AIModelConfig.SMOOTHVERSION, str);
    }

    public void setSubVersion(int i3) {
        this.subVersion = i3;
        reportPropertyChange("subVersion", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Smooth";
    }
}
