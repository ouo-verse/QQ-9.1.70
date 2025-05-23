package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import cooperation.qzone.report.QZonePushReporter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBeautySharpenAndExposureFilter extends QQAVImageFilter {
    private float mExposure;
    private int mExposureLocation;
    private int mImageHeightFactorLocation;
    private int mImageWidthFactorLocation;
    private float mSharpness;
    private int mSharpnessLocation;

    public QQAVImageBeautySharpenAndExposureFilter() {
        this(0.0f, 0.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mSharpnessLocation = GLES20.glGetUniformLocation(getProgram(), "sharpness");
        this.mExposureLocation = GLES20.glGetUniformLocation(getProgram(), QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
        this.mImageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
        this.mImageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
        setSharpness(this.mSharpness);
        setExposure(this.mExposure);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mImageWidthFactorLocation, 1.0f / i3);
        setFloat(this.mImageHeightFactorLocation, 1.0f / i16);
    }

    public void setExposure(float f16) {
        this.mExposure = f16;
        setFloat(this.mExposureLocation, f16);
    }

    public void setSharpness(float f16) {
        this.mSharpness = f16;
        setFloat(this.mSharpnessLocation, f16);
    }

    public QQAVImageBeautySharpenAndExposureFilter(float f16, float f17) {
        super(String.valueOf(3), String.valueOf(4));
        this.mSharpness = f16;
        this.mExposure = f17;
    }
}
