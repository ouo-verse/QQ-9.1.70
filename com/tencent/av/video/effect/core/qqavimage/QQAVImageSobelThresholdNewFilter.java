package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageSobelThresholdNewFilter extends QQAVImage3x3TextureSamplingFilter {
    private float mEdgeStrength;
    private float mThreshold;
    private int mUniformEdgeStrengthLocation;
    private int mUniformThresholdLocation;

    public QQAVImageSobelThresholdNewFilter() {
        this(0.5f, 1.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImage3x3TextureSamplingFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mUniformThresholdLocation = GLES20.glGetUniformLocation(getProgram(), "threshold");
        this.mUniformEdgeStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "edgeStrength");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setThreshold(this.mThreshold);
        setEdgeStrength(this.mEdgeStrength);
    }

    public void setEdgeStrength(float f16) {
        this.mEdgeStrength = f16;
        setFloat(this.mUniformEdgeStrengthLocation, f16);
    }

    public void setThreshold(float f16) {
        this.mThreshold = f16;
        setFloat(this.mUniformThresholdLocation, f16);
    }

    public QQAVImageSobelThresholdNewFilter(float f16, float f17) {
        super(String.valueOf(12));
        this.mThreshold = f16;
        this.mEdgeStrength = f17;
    }
}
