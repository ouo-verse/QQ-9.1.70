package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* loaded from: classes3.dex */
public class QQAVImageTwoPassTextureSamplingFilter extends QQAVImageTwoPassFilter {
    public QQAVImageTwoPassTextureSamplingFilter(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    public float getHorizontalTexelOffsetRatio() {
        return 1.0f;
    }

    public float getVerticalTexelOffsetRatio() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTexelOffsets() {
        float horizontalTexelOffsetRatio = getHorizontalTexelOffsetRatio();
        QQAVImageFilter qQAVImageFilter = this.mFilters.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(qQAVImageFilter.getProgram(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(qQAVImageFilter.getProgram(), "texelHeightOffset");
        qQAVImageFilter.setFloat(glGetUniformLocation, horizontalTexelOffsetRatio / this.mOutputWidth);
        qQAVImageFilter.setFloat(glGetUniformLocation2, 0.0f);
        float verticalTexelOffsetRatio = getVerticalTexelOffsetRatio();
        QQAVImageFilter qQAVImageFilter2 = this.mFilters.get(1);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(qQAVImageFilter2.getProgram(), "texelWidthOffset");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(qQAVImageFilter2.getProgram(), "texelHeightOffset");
        qQAVImageFilter2.setFloat(glGetUniformLocation3, 0.0f);
        qQAVImageFilter2.setFloat(glGetUniformLocation4, verticalTexelOffsetRatio / this.mOutputHeight);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        initTexelOffsets();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        initTexelOffsets();
    }
}
