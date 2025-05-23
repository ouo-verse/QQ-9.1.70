package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImage3x3TextureSamplingFilter extends QQAVImageFilter {
    private boolean mHasOverriddenImageSizeFactor;
    private float mLineSize;
    private float mTexelHeight;
    private float mTexelWidth;
    private int mUniformTexelHeightLocation;
    private int mUniformTexelWidthLocation;

    public QQAVImage3x3TextureSamplingFilter() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}");
    }

    private void updateTexelValues() {
        setFloat(this.mUniformTexelWidthLocation, this.mTexelWidth);
        setFloat(this.mUniformTexelHeightLocation, this.mTexelHeight);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mUniformTexelWidthLocation = GLES20.glGetUniformLocation(getProgram(), "texelWidth");
        this.mUniformTexelHeightLocation = GLES20.glGetUniformLocation(getProgram(), "texelHeight");
        if (this.mTexelWidth != 0.0f) {
            updateTexelValues();
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        if (!this.mHasOverriddenImageSizeFactor) {
            setLineSize(this.mLineSize);
        }
    }

    public void setLineSize(float f16) {
        this.mLineSize = f16;
        this.mTexelWidth = f16 / getOutputWidth();
        this.mTexelHeight = f16 / getOutputHeight();
        updateTexelValues();
    }

    public void setTexelHeight(float f16) {
        this.mHasOverriddenImageSizeFactor = true;
        this.mTexelHeight = f16;
        setFloat(this.mUniformTexelHeightLocation, f16);
    }

    public void setTexelWidth(float f16) {
        this.mHasOverriddenImageSizeFactor = true;
        this.mTexelWidth = f16;
        setFloat(this.mUniformTexelWidthLocation, f16);
    }

    public QQAVImage3x3TextureSamplingFilter(String str) {
        super(String.valueOf(14), str);
        this.mHasOverriddenImageSizeFactor = false;
        this.mLineSize = 1.0f;
    }
}
