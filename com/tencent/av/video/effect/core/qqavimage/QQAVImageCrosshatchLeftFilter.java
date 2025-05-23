package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageCrosshatchLeftFilter extends QQAVImageFilter {
    private float mCrossHatchSpacing;
    private int mCrossHatchSpacingLocation;
    private float mLineWidth;
    private int mLineWidthLocation;

    public QQAVImageCrosshatchLeftFilter() {
        this(0.018f, 0.0025f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mCrossHatchSpacingLocation = GLES20.glGetUniformLocation(getProgram(), "crossHatchSpacing");
        this.mLineWidthLocation = GLES20.glGetUniformLocation(getProgram(), "lineWidth");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setCrossHatchSpacing(this.mCrossHatchSpacing);
        setLineWidth(this.mLineWidth);
    }

    public void setCrossHatchSpacing(float f16) {
        float f17;
        if (getOutputWidth() != 0) {
            f17 = 1.0f / getOutputWidth();
        } else {
            f17 = 4.8828125E-4f;
        }
        if (f16 < f17) {
            this.mCrossHatchSpacing = f17;
        } else {
            this.mCrossHatchSpacing = f16;
        }
        setFloat(this.mCrossHatchSpacingLocation, this.mCrossHatchSpacing);
    }

    public void setLineWidth(float f16) {
        this.mLineWidth = f16;
        setFloat(this.mLineWidthLocation, f16);
    }

    public QQAVImageCrosshatchLeftFilter(float f16, float f17) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(11));
        this.mCrossHatchSpacing = f16;
        this.mLineWidth = f17;
    }
}
