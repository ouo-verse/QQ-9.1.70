package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageComicFilter extends QQAVImageFilter {
    private QQAVImageCrosshatchLeftFilter mCrossFilter;
    private float mCrosshatchSspacing;
    private QQAVImageThresholdSketchFilter mEdgeFilter;
    private float mEdgeStrenght;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private float mLineWidth;
    private float mThreshold;
    private QQAVImageComicBlendFilter mTwoFilter;

    public QQAVImageComicFilter() {
        this.mFrameBufferTextures = new int[2];
        this.mFrameBuffers = new int[2];
        this.mEdgeStrenght = 1.0f;
        this.mThreshold = 0.5f;
        this.mCrosshatchSspacing = 0.018f;
        this.mLineWidth = 0.0025f;
        this.mEdgeFilter = new QQAVImageThresholdSketchFilter();
        this.mCrossFilter = new QQAVImageCrosshatchLeftFilter();
        this.mTwoFilter = new QQAVImageComicBlendFilter();
        super.setQQAVEffectType(3);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        int[] iArr = this.mFrameBuffers;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.mFrameBufferTextures;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        this.mEdgeFilter.onDestroy();
        this.mCrossFilter.onDestroy();
        this.mTwoFilter.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        int[] iArr;
        runPendingOnDrawTasks();
        if (isInitialized() && (iArr = this.mFrameBuffers) != null && this.mFrameBufferTextures != null) {
            this.mEdgeFilter.onDraw2(i3, iArr[0]);
            this.mCrossFilter.onDraw2(i3, this.mFrameBuffers[1]);
            QQAVImageComicBlendFilter qQAVImageComicBlendFilter = this.mTwoFilter;
            int[] iArr2 = this.mFrameBufferTextures;
            qQAVImageComicBlendFilter.mFilterSourceTexture2 = iArr2[1];
            qQAVImageComicBlendFilter.onDraw2(iArr2[0], i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mEdgeFilter.onInit();
        this.mCrossFilter.onInit();
        this.mTwoFilter.onInit();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        this.mEdgeFilter.onInitialized();
        this.mCrossFilter.onInitialized();
        this.mTwoFilter.onInitialized();
        this.mCrossFilter.setCrossHatchSpacing(this.mCrosshatchSspacing);
        this.mCrossFilter.setLineWidth(this.mLineWidth);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        int[] iArr = this.mFrameBuffers;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.mFrameBufferTextures;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        this.mEdgeFilter.onOutputSizeChanged(i3, i16);
        this.mCrossFilter.onOutputSizeChanged(i3, i16);
        this.mTwoFilter.onOutputSizeChanged(i3, i16);
        for (int i17 = 0; i17 < 2; i17++) {
            GLES20.glGenFramebuffers(1, this.mFrameBuffers, i17);
            GLES20.glGenTextures(1, this.mFrameBufferTextures, i17);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i17]);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i17]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i17], 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public QQAVImageComicFilter(float f16) {
        this.mFrameBufferTextures = new int[2];
        this.mFrameBuffers = new int[2];
        this.mEdgeStrenght = 1.0f;
        this.mThreshold = 0.5f;
        this.mCrosshatchSspacing = 0.018f;
        this.mLineWidth = 0.0025f;
        this.mEdgeFilter = new QQAVImageThresholdSketchFilter();
        this.mCrossFilter = new QQAVImageCrosshatchLeftFilter();
        this.mTwoFilter = new QQAVImageComicBlendFilter();
        super.setQQAVEffectType(3);
    }
}
