package com.tencent.av.video.effect.core.qqavimage.lowlight;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageLowLightCoreFilter extends QQAVImageFilter {
    protected int mGLUniformLowLightImageTexture;
    protected int mGLUniformTexelHeight;
    protected int mGLUniformTexelWidth;
    public int mLowLightImageTexture;

    public QQAVImageLowLightCoreFilter() {
        super(String.valueOf(6), String.valueOf(7));
        this.mLowLightImageTexture = -1;
    }

    private void initTexelOffsets() {
        int i3 = this.mOutputWidth;
        if (i3 != 0) {
            setFloat(this.mGLUniformTexelWidth, 1.0f / i3);
        }
        int i16 = this.mOutputHeight;
        if (i16 != 0) {
            setFloat(this.mGLUniformTexelHeight, 1.0f / i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysAfter() {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glActiveTexture(33984);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    protected void onDrawArraysPre() {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mLowLightImageTexture);
        GLES20.glUniform1i(this.mGLUniformLowLightImageTexture, 1);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mGLUniformTexelWidth = GLES20.glGetUniformLocation(this.mGLProgId, "texelWidth");
        this.mGLUniformTexelHeight = GLES20.glGetUniformLocation(this.mGLProgId, "texelHeight");
        this.mGLUniformLowLightImageTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture2");
        initTexelOffsets();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        initTexelOffsets();
    }

    public void setLowLightImage(Bitmap bitmap) {
        GLES20.glActiveTexture(33985);
        this.mLowLightImageTexture = OpenGlUtils.loadTexture(bitmap, this.mLowLightImageTexture, false);
    }
}
