package com.tencent.av.video.effect.core.qqavimage.lowlight;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageSaturationFilter;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageLowLightFilter extends QQAVImageFilter {
    private static final String TAG = "QQAVImageLowLightFilter";
    private int[] mFrameBufferTextures = new int[1];
    private int[] mFrameBuffers = new int[1];
    private QQAVImageLowLightCoreFilter mLowLightCoreFilter = new QQAVImageLowLightCoreFilter();
    private QQAVImageSaturationFilter mSaturationFilter = new QQAVImageSaturationFilter();

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        int[] iArr = this.mFrameBuffers;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.mFrameBufferTextures;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        this.mLowLightCoreFilter.destroy();
        this.mSaturationFilter.destroy();
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        int[] iArr;
        runPendingOnDrawTasks();
        if (isInitialized() && (iArr = this.mFrameBuffers) != null && this.mFrameBufferTextures != null) {
            this.mLowLightCoreFilter.onDraw2(i3, iArr[0]);
            this.mSaturationFilter.onDraw2(this.mFrameBufferTextures[0], i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mLowLightCoreFilter.onInit();
        this.mSaturationFilter.onInit();
        setSaturation(1.3f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        this.mLowLightCoreFilter.onInitialized();
        this.mSaturationFilter.onInitialized();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        boolean z16;
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
            this.mLowLightCoreFilter.onOutputSizeChanged(i3, i16);
            this.mSaturationFilter.onOutputSizeChanged(i3, i16);
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

    public void setLowLightImage(Bitmap bitmap) {
        QQAVImageLowLightCoreFilter qQAVImageLowLightCoreFilter = this.mLowLightCoreFilter;
        if (qQAVImageLowLightCoreFilter != null && bitmap != null) {
            qQAVImageLowLightCoreFilter.setLowLightImage(bitmap);
        }
    }

    public void setSaturation(float f16) {
        QQAVImageSaturationFilter qQAVImageSaturationFilter = this.mSaturationFilter;
        if (qQAVImageSaturationFilter != null) {
            qQAVImageSaturationFilter.setSaturation(f16);
        }
    }
}
