package com.tencent.av.video.effect.core.qqavimage.denoise;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageDenoiseFilter extends QQAVImageFilter {
    public static final String INIT_FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n void main()\n {\n      gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n }";
    private static final String TAG = "QQAVImageDenoiseFilter";
    private float mUpdateRate = 0.0f;
    private int[] mFrameBufferTextures = new int[3];
    private int[] mFrameBuffers = new int[3];
    private boolean mFirstFrameFlag = true;
    private int mLastStoreTexture = -1;
    private int mLastStoreFbo = -1;
    private int mLastStoreBlurTexture = -1;
    private int mLastStoreBlurFbo = -1;
    private QQAVImageDenoiseRGB2YUVFilter mRGB2YUVFilter = new QQAVImageDenoiseRGB2YUVFilter();
    private QQAVImageDenoiseGaussianBlurFilter mGaussianBlurFilter = new QQAVImageDenoiseGaussianBlurFilter(1.0f);
    private QQAVImageDenoiseVDCalAndPredFilter mVDCalAndPredFilter = new QQAVImageDenoiseVDCalAndPredFilter();
    private QQAVImageDenoiseYUV2RGBFilter mYUV2RGBFilter = new QQAVImageDenoiseYUV2RGBFilter();
    private QQAVImageFilter mInitFilter = new QQAVImageFilter(INIT_FRAGMENT_SHADER);
    private QQAVImageFilter mEmptyFilter = new QQAVImageFilter();

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDestroy() {
        int[] iArr = this.mFrameBuffers;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.mFrameBufferTextures;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
        int i3 = this.mLastStoreTexture;
        if (i3 != -1) {
            GLES20.glDeleteTextures(2, new int[]{i3, this.mLastStoreBlurTexture}, 0);
            GLES20.glDeleteFramebuffers(2, new int[]{this.mLastStoreFbo, this.mLastStoreBlurFbo}, 0);
            this.mLastStoreTexture = -1;
            this.mLastStoreFbo = -1;
            this.mLastStoreBlurTexture = -1;
            this.mLastStoreBlurFbo = -1;
        }
        this.mRGB2YUVFilter.destroy();
        this.mGaussianBlurFilter.destroy();
        this.mVDCalAndPredFilter.destroy();
        this.mYUV2RGBFilter.destroy();
        this.mInitFilter.destroy();
        this.mEmptyFilter.destroy();
        super.onDestroy();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        int[] iArr;
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && (iArr = this.mFrameBufferTextures) != null) {
            if (this.mFirstFrameFlag) {
                this.mFirstFrameFlag = false;
                this.mInitFilter.onDraw2(iArr[0], this.mLastStoreFbo);
                this.mInitFilter.onDraw2(this.mFrameBufferTextures[0], this.mLastStoreBlurFbo);
                Log.d(TAG, "init last store");
            }
            this.mRGB2YUVFilter.onDraw2(i3, this.mFrameBuffers[0]);
            this.mGaussianBlurFilter.onDraw2(this.mFrameBufferTextures[0], this.mFrameBuffers[1]);
            QQAVImageDenoiseVDCalAndPredFilter qQAVImageDenoiseVDCalAndPredFilter = this.mVDCalAndPredFilter;
            int[] iArr2 = this.mFrameBufferTextures;
            qQAVImageDenoiseVDCalAndPredFilter.mFilterSourceTexture2 = iArr2[1];
            qQAVImageDenoiseVDCalAndPredFilter.mFilterSourceTexture3 = iArr2[0];
            qQAVImageDenoiseVDCalAndPredFilter.mFilterSourceTexture4 = this.mLastStoreBlurTexture;
            qQAVImageDenoiseVDCalAndPredFilter.onDraw2(this.mLastStoreTexture, this.mFrameBuffers[2]);
            this.mEmptyFilter.onDraw2(this.mFrameBufferTextures[2], this.mLastStoreFbo);
            this.mEmptyFilter.onDraw2(this.mFrameBufferTextures[1], this.mLastStoreBlurFbo);
            QQAVImageDenoiseYUV2RGBFilter qQAVImageDenoiseYUV2RGBFilter = this.mYUV2RGBFilter;
            int[] iArr3 = this.mFrameBufferTextures;
            qQAVImageDenoiseYUV2RGBFilter.mFilterSourceTexture2 = iArr3[0];
            qQAVImageDenoiseYUV2RGBFilter.onDraw2(iArr3[2], i16);
        }
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mRGB2YUVFilter.onInit();
        this.mGaussianBlurFilter.onInit();
        this.mVDCalAndPredFilter.onInit();
        this.mYUV2RGBFilter.onInit();
        this.mInitFilter.onInit();
        this.mEmptyFilter.onInit();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        this.mRGB2YUVFilter.onInitialized();
        this.mGaussianBlurFilter.onInitialized();
        this.mVDCalAndPredFilter.onInitialized();
        this.mYUV2RGBFilter.onInitialized();
        this.mInitFilter.onInitialized();
        this.mEmptyFilter.onInitialized();
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
            this.mRGB2YUVFilter.onOutputSizeChanged(i3, i16);
            this.mGaussianBlurFilter.onOutputSizeChanged(i3, i16);
            this.mVDCalAndPredFilter.onOutputSizeChanged(i3, i16);
            this.mYUV2RGBFilter.onOutputSizeChanged(i3, i16);
            this.mInitFilter.onOutputSizeChanged(i3, i16);
            this.mEmptyFilter.onOutputSizeChanged(i3, i16);
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
            int i19 = this.mLastStoreTexture;
            if (i19 != -1) {
                GLES20.glDeleteTextures(2, new int[]{i19, this.mLastStoreBlurTexture}, 0);
                GLES20.glDeleteFramebuffers(2, new int[]{this.mLastStoreFbo, this.mLastStoreBlurFbo}, 0);
                this.mLastStoreTexture = -1;
                this.mLastStoreFbo = -1;
                this.mLastStoreBlurTexture = -1;
                this.mLastStoreBlurFbo = -1;
            }
            int[] iArr3 = new int[2];
            GLES20.glGenTextures(2, iArr3, 0);
            int i26 = iArr3[0];
            this.mLastStoreTexture = i26;
            this.mLastStoreFbo = CommonUtils.initFrameBuffer(i3, i16, i26);
            int i27 = iArr3[1];
            this.mLastStoreBlurTexture = i27;
            this.mLastStoreBlurFbo = CommonUtils.initFrameBuffer(i3, i16, i27);
            this.mFirstFrameFlag = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
    
        if (r3 < 0.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setUpdateRate(float f16) {
        float f17 = 40.0f;
        if (f16 <= 40.0f) {
            f17 = 0.0f;
        }
        f16 = f17;
        this.mUpdateRate = f16;
        this.mVDCalAndPredFilter.setUpdateRateLocal(f16);
    }
}
