package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageSharpenFilter extends QQAVImageFilter {
    private int mImageHeightFactorLocation;
    private int mImageWidthFactorLocation;
    private float mSharpness;
    private int mSharpnessLocation;

    public QQAVImageSharpenFilter() {
        this(0.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mSharpnessLocation = GLES20.glGetUniformLocation(getProgram(), "sharpness");
        this.mImageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
        this.mImageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
        setSharpness(this.mSharpness);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mImageWidthFactorLocation, 1.0f / i3);
        setFloat(this.mImageHeightFactorLocation, 1.0f / i16);
    }

    public void setSharpness(float f16) {
        this.mSharpness = f16;
        setFloat(this.mSharpnessLocation, f16);
    }

    public QQAVImageSharpenFilter(float f16) {
        super(String.valueOf(18), String.valueOf(25));
        this.mSharpness = f16;
    }
}
