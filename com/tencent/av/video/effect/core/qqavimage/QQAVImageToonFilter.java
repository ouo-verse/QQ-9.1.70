package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageToonFilter extends QQAVImage3x3TextureSamplingFilter {
    float mQuantizationLevels;
    int mQuantizationLevelsLocation;
    float mThreshold;
    int mThresholdLocation;

    public QQAVImageToonFilter() {
        this(0.2f, 10.0f);
        super.setQQAVEffectType(4);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImage3x3TextureSamplingFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "threshold");
        this.mQuantizationLevelsLocation = GLES20.glGetUniformLocation(getProgram(), "quantizationLevels");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setThreshold(this.mThreshold);
        setQuantizationLevels(this.mQuantizationLevels);
    }

    public void setQuantizationLevels(float f16) {
        this.mQuantizationLevels = f16;
        setFloat(this.mQuantizationLevelsLocation, f16);
    }

    public void setThreshold(float f16) {
        this.mThreshold = f16;
        setFloat(this.mThresholdLocation, f16);
    }

    public QQAVImageToonFilter(float f16, float f17) {
        super(String.valueOf(19));
        this.mThreshold = f16;
        this.mQuantizationLevels = f17;
        super.setQQAVEffectType(4);
    }
}
