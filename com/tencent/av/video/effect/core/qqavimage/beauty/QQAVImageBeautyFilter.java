package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBeautyFilter extends QQAVImageFilter {
    private static final String TAG = "QQAVImageBeautyFilter";
    private float mAmount;
    private float mExposure;
    private QQAVImageBeautyExposureAndOverlayFilter mExposureAndOverlayFilter;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private QQAVImageBeautyHighPassFilter mHighPassFilter;
    private boolean mIsNeedSkinColor;
    private boolean mIsUseMultiParams;
    private float mMixPercent;
    private QQAVImageBeautySharpenAndExposureFilter mSharpenAndExposureFilter;
    private float mSharpness;
    private QQAVImageFilter mSkinColorFilter;
    private QQAVImageBeautySkinCurveAndComposeFilter mSkinCurveAndComposeFilter;

    public QQAVImageBeautyFilter() {
        this(0.3f);
    }

    public float getAmount() {
        return this.mAmount;
    }

    public float getExposure() {
        return this.mExposure;
    }

    public float getMixPercent() {
        return this.mMixPercent;
    }

    public float getSharpness() {
        return this.mSharpness;
    }

    public boolean isUseMultiParams() {
        return this.mIsUseMultiParams;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        int[] iArr = this.mFrameBuffers;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.mFrameBufferTextures;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        this.mExposureAndOverlayFilter.destroy();
        this.mHighPassFilter.destroy();
        this.mSkinCurveAndComposeFilter.destroy();
        this.mSharpenAndExposureFilter.destroy();
        QQAVImageFilter qQAVImageFilter = this.mSkinColorFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null) {
            if (this.mIsUseMultiParams) {
                Log.d(TAG, "BeautyFilter onDraw current mixPercent:" + this.mMixPercent + ",sharpness:" + this.mSharpness + ",exposure:" + this.mExposure + ",mIsNeedSkinColor:" + this.mIsNeedSkinColor);
            } else {
                Log.d(TAG, "BeautyFilter onDraw current amount:" + this.mAmount + ",mIsNeedSkinColor:" + this.mIsNeedSkinColor);
            }
            this.mExposureAndOverlayFilter.onDraw2(i3, this.mFrameBuffers[0]);
            this.mHighPassFilter.onDraw2(this.mFrameBufferTextures[0], this.mFrameBuffers[1]);
            QQAVImageBeautySkinCurveAndComposeFilter qQAVImageBeautySkinCurveAndComposeFilter = this.mSkinCurveAndComposeFilter;
            qQAVImageBeautySkinCurveAndComposeFilter.mFilterSourceTexture2 = this.mFrameBufferTextures[1];
            qQAVImageBeautySkinCurveAndComposeFilter.onDraw2(i3, this.mFrameBuffers[2]);
            if (this.mIsNeedSkinColor && this.mSkinColorFilter != null) {
                this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], this.mFrameBuffers[3]);
                this.mSkinColorFilter.onDraw2(this.mFrameBufferTextures[3], i16);
            } else {
                this.mSharpenAndExposureFilter.onDraw2(this.mFrameBufferTextures[2], i16);
            }
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mExposureAndOverlayFilter.onInit();
        this.mExposureAndOverlayFilter.setExposure(-1.0f);
        this.mHighPassFilter.onInit();
        this.mSkinCurveAndComposeFilter.onInit();
        this.mSharpenAndExposureFilter.onInit();
        QQAVImageFilter qQAVImageFilter = this.mSkinColorFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.onInit();
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        this.mExposureAndOverlayFilter.onInitialized();
        this.mHighPassFilter.onInitialized();
        this.mSkinCurveAndComposeFilter.onInitialized();
        this.mSharpenAndExposureFilter.onInitialized();
        QQAVImageFilter qQAVImageFilter = this.mSkinColorFilter;
        if (qQAVImageFilter != null) {
            qQAVImageFilter.onInitialized();
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        boolean z16;
        float f16;
        int i17 = 1;
        if (this.mOutputWidth == i3 && this.mOutputHeight == i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        super.onOutputSizeChanged(i3, i16);
        if (z16) {
            int[] iArr = this.mFrameBuffers;
            if (iArr != null) {
                GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                int[] iArr2 = this.mFrameBufferTextures;
                GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            }
            this.mExposureAndOverlayFilter.onOutputSizeChanged(i3, i16);
            this.mHighPassFilter.onOutputSizeChanged(i3, i16);
            this.mSkinCurveAndComposeFilter.onOutputSizeChanged(i3, i16);
            this.mSharpenAndExposureFilter.onOutputSizeChanged(i3, i16);
            QQAVImageFilter qQAVImageFilter = this.mSkinColorFilter;
            if (qQAVImageFilter != null) {
                qQAVImageFilter.onOutputSizeChanged(i3, i16);
            }
            if (i3 > 720) {
                f16 = 5.0f;
            } else if (i3 >= 540 && i3 <= 720) {
                f16 = 3.0f;
            } else if ((i3 < 480 || i3 >= 540) && i3 < 480) {
                f16 = 1.0f;
            } else {
                f16 = 2.0f;
            }
            this.mHighPassFilter.setRadiusInPixels(f16);
            int length = this.mFrameBufferTextures.length;
            int i18 = 0;
            while (i18 < length) {
                GLES20.glGenFramebuffers(i17, this.mFrameBuffers, i18);
                GLES20.glGenTextures(i17, this.mFrameBufferTextures, i18);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i18]);
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i18]);
                GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.mFrameBufferTextures[i18], 0);
                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i18++;
                i17 = 1;
            }
        }
    }

    public void setAmount(float f16) {
        double d16 = f16;
        if (d16 < 0.0d) {
            this.mAmount = 0.0f;
        } else if (d16 > 1.0d) {
            this.mAmount = 1.0f;
        } else {
            this.mAmount = f16;
        }
        float f17 = this.mAmount * 1.25f;
        QQAVImageBeautySkinCurveAndComposeFilter qQAVImageBeautySkinCurveAndComposeFilter = this.mSkinCurveAndComposeFilter;
        if (qQAVImageBeautySkinCurveAndComposeFilter != null) {
            qQAVImageBeautySkinCurveAndComposeFilter.setMixPercent(f17 * 10.0f * 0.14f);
        }
        QQAVImageBeautySharpenAndExposureFilter qQAVImageBeautySharpenAndExposureFilter = this.mSharpenAndExposureFilter;
        if (qQAVImageBeautySharpenAndExposureFilter != null) {
            qQAVImageBeautySharpenAndExposureFilter.setSharpness(f17 * 10.0f * 0.03f);
            this.mSharpenAndExposureFilter.setExposure(0.0f);
        }
        this.mIsUseMultiParams = false;
    }

    public void setBeauty(float f16, float f17, float f18) {
        double d16 = f16;
        if (d16 < 0.0d) {
            this.mMixPercent = 0.0f;
        } else if (d16 > 1.75d) {
            this.mMixPercent = 1.75f;
        } else {
            this.mMixPercent = f16;
        }
        double d17 = f17;
        if (d17 < -1.0d) {
            this.mSharpness = -1.0f;
        } else if (d17 > 1.5d) {
            this.mSharpness = 1.5f;
        } else {
            this.mSharpness = f17;
        }
        double d18 = f18;
        if (d18 < -1.0d) {
            this.mExposure = -1.0f;
        } else if (d18 > 1.0d) {
            this.mExposure = 1.0f;
        } else {
            this.mExposure = f18;
        }
        QQAVImageBeautySkinCurveAndComposeFilter qQAVImageBeautySkinCurveAndComposeFilter = this.mSkinCurveAndComposeFilter;
        if (qQAVImageBeautySkinCurveAndComposeFilter != null) {
            qQAVImageBeautySkinCurveAndComposeFilter.setMixPercent(this.mMixPercent);
        }
        QQAVImageBeautySharpenAndExposureFilter qQAVImageBeautySharpenAndExposureFilter = this.mSharpenAndExposureFilter;
        if (qQAVImageBeautySharpenAndExposureFilter != null) {
            qQAVImageBeautySharpenAndExposureFilter.setSharpness(this.mSharpness);
            this.mSharpenAndExposureFilter.setExposure(this.mExposure);
        }
        this.mIsUseMultiParams = true;
    }

    public void setNeedSkinColor(boolean z16) {
        this.mIsNeedSkinColor = z16;
    }

    public void setSkinColorFilter(QQAVImageFilter qQAVImageFilter) {
        this.mSkinColorFilter = qQAVImageFilter;
    }

    public QQAVImageBeautyFilter(float f16) {
        this(f16, null);
    }

    public QQAVImageBeautyFilter(float f16, QQAVImageFilter qQAVImageFilter) {
        this.mIsUseMultiParams = false;
        this.mAmount = 0.3f;
        this.mMixPercent = 0.0f;
        this.mSharpness = 0.0f;
        this.mExposure = 0.0f;
        this.mIsNeedSkinColor = true;
        this.mFrameBufferTextures = new int[4];
        this.mFrameBuffers = new int[4];
        this.mExposureAndOverlayFilter = new QQAVImageBeautyExposureAndOverlayFilter();
        this.mHighPassFilter = new QQAVImageBeautyHighPassFilter();
        this.mSkinCurveAndComposeFilter = new QQAVImageBeautySkinCurveAndComposeFilter();
        this.mSharpenAndExposureFilter = new QQAVImageBeautySharpenAndExposureFilter();
        this.mSkinColorFilter = qQAVImageFilter;
        this.mIsNeedSkinColor = true;
        super.setQQAVEffectType(5);
        setAmount(f16);
    }
}
