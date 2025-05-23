package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUAvgPixelsFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterComputeFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUGuideFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUImgFilterRecoverFilter;
import com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUMinMaxPixelsFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class QQImgHazeRmoveFilter extends QQBaseFilter {
    public static final String TAG = "QQImgHazeRmoveFilter";
    public int CLIP_HEIGHT;
    public int CLIP_WIDTH;
    public int SRC_HEIGHT;
    public int SRC_WIDTH;
    private boolean enableImgFilter;
    private GPUGuideFilterComputeFilter gpuGuideFilterComputeFilter;
    private GPUGuideFilterRecoverFilter gpuGuideFilterRecoverFilter;
    private GPUImgFilterRecoverFilter gpuImgFilterRecoverFilter;
    private GPUAvgPixelsFilter imgFilterPixelsFilter;
    private RenderBuffer mClip8RenderFBO;
    private RenderBuffer mCopyRenderFBO;
    private TextureRender mCopyTextureRender;
    private RenderBuffer mOutputRenderFBO;
    private RenderBuffer mSrcRenderFBO;
    private RenderBuffer mTranmissionRenderFBO;
    private float mW;
    private int mWindow;
    private GPUMinMaxPixelsFilter minMaxPixelsFilter;

    public QQImgHazeRmoveFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.mWindow = 11;
        this.mW = 0.9f;
        this.enableImgFilter = false;
    }

    private int clipTexture(int i3) {
        this.mClip8RenderFBO.bind();
        this.mCopyTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        this.mClip8RenderFBO.unbind();
        return this.mClip8RenderFBO.getTexId();
    }

    private int copyInputTexture(int i3) {
        this.mCopyRenderFBO.bind();
        this.mCopyTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        this.mCopyRenderFBO.unbind();
        return this.mCopyRenderFBO.getTexId();
    }

    private int copyTransmissionTexture() {
        int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D);
        this.mTranmissionRenderFBO.bind();
        this.mCopyTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, createTexture, null, null);
        this.mTranmissionRenderFBO.unbind();
        return this.mTranmissionRenderFBO.getTexId();
    }

    private int copyoutputTexture(int i3) {
        this.mOutputRenderFBO.bind();
        this.mCopyTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        this.mOutputRenderFBO.unbind();
        return this.mOutputRenderFBO.getTexId();
    }

    private void getTransmissionDark(int i3, int i16, int[] iArr, int i17, int i18, float[] fArr, float f16, int i19) {
        this.minMaxPixelsFilter.glDisPatchGPUMinMaxPixelsFilterCompute(i3, i17, i18, iArr, f16, i19);
        this.gpuGuideFilterComputeFilter.glDisPatchGuideFilterComputerCompute(iArr, i17, i18, i19, 0.001f);
        this.gpuGuideFilterRecoverFilter.glDisPatchGuideFilterRecoverFilterCompute(i16, iArr, i17, i18, i19);
    }

    private void init() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        RenderBuffer renderBuffer = this.mClip8RenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.mSrcRenderFBO;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
        RenderBuffer renderBuffer3 = this.mOutputRenderFBO;
        if (renderBuffer3 != null) {
            renderBuffer3.destroy();
        }
        RenderBuffer renderBuffer4 = this.mCopyRenderFBO;
        if (renderBuffer4 != null) {
            renderBuffer4.destroy();
        }
        RenderBuffer renderBuffer5 = this.mTranmissionRenderFBO;
        if (renderBuffer5 != null) {
            renderBuffer5.destroy();
        }
        TextureRender textureRender = this.mCopyTextureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        GPUImgFilterRecoverFilter gPUImgFilterRecoverFilter = this.gpuImgFilterRecoverFilter;
        if (gPUImgFilterRecoverFilter != null) {
            gPUImgFilterRecoverFilter.destroy();
        }
        this.gpuImgFilterRecoverFilter = new GPUImgFilterRecoverFilter();
        GPUAvgPixelsFilter gPUAvgPixelsFilter = this.imgFilterPixelsFilter;
        if (gPUAvgPixelsFilter != null) {
            gPUAvgPixelsFilter.destroy();
        }
        this.imgFilterPixelsFilter = new GPUAvgPixelsFilter();
        GPUGuideFilterComputeFilter gPUGuideFilterComputeFilter = this.gpuGuideFilterComputeFilter;
        if (gPUGuideFilterComputeFilter != null) {
            gPUGuideFilterComputeFilter.destroy();
        }
        this.gpuGuideFilterComputeFilter = new GPUGuideFilterComputeFilter();
        GPUGuideFilterRecoverFilter gPUGuideFilterRecoverFilter = this.gpuGuideFilterRecoverFilter;
        if (gPUGuideFilterRecoverFilter != null) {
            gPUGuideFilterRecoverFilter.destroy();
        }
        this.gpuGuideFilterRecoverFilter = new GPUGuideFilterRecoverFilter();
        GPUMinMaxPixelsFilter gPUMinMaxPixelsFilter = this.minMaxPixelsFilter;
        if (gPUMinMaxPixelsFilter != null) {
            gPUMinMaxPixelsFilter.destroy();
        }
        this.minMaxPixelsFilter = new GPUMinMaxPixelsFilter();
        this.SRC_WIDTH = getQQFilterRenderManager().getFilterWidth();
        this.SRC_HEIGHT = getQQFilterRenderManager().getFilterHeight();
        this.CLIP_WIDTH = getAlignment16(getQQFilterRenderManager().getFilterWidth() / 10);
        int alignment16 = getAlignment16(getQQFilterRenderManager().getFilterHeight() / 10);
        this.CLIP_HEIGHT = alignment16;
        int i3 = this.CLIP_WIDTH;
        boolean z26 = true;
        if (DeviceInstance.getSDKVersion() >= 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mClip8RenderFBO = new RenderBuffer(i3, alignment16, 33984, z16);
        int i16 = this.SRC_WIDTH;
        int i17 = this.SRC_HEIGHT;
        if (DeviceInstance.getSDKVersion() >= 21) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mSrcRenderFBO = new RenderBuffer(i16, i17, 33984, z17);
        int i18 = this.SRC_WIDTH;
        int i19 = this.SRC_HEIGHT;
        if (DeviceInstance.getSDKVersion() >= 21) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.mOutputRenderFBO = new RenderBuffer(i18, i19, 33984, z18);
        int i26 = this.SRC_WIDTH;
        int i27 = this.SRC_HEIGHT;
        if (DeviceInstance.getSDKVersion() >= 21) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.mCopyRenderFBO = new RenderBuffer(i26, i27, 33984, z19);
        int i28 = this.CLIP_WIDTH;
        int i29 = this.CLIP_HEIGHT;
        if (DeviceInstance.getSDKVersion() < 21) {
            z26 = false;
        }
        this.mTranmissionRenderFBO = new RenderBuffer(i28, i29, 33984, z26);
        this.mCopyTextureRender = new TextureRender();
        SLog.d(TAG, "init CLIP_HEIGHT=" + this.CLIP_HEIGHT + " CLIP_WIDTH=" + this.CLIP_WIDTH);
    }

    private int[] maxFilter(int[] iArr, int i3, int i16, int i17) {
        int i18;
        int[] iArr2 = new int[i3 * i16];
        int i19 = (i17 << 1) + 1;
        int[] iArr3 = new int[i16];
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = i26 * i3;
            getMax(iArr, iArr2, i26, i3, i17);
            for (int i28 = 0; i28 < i17; i28++) {
                int i29 = i28 + i27;
                iArr2[i29] = iArr[i29];
                int i36 = ((i3 - i28) - 1) + i27;
                iArr2[i36] = iArr[i36];
            }
        }
        for (int i37 = 0; i37 < i3; i37++) {
            int i38 = iArr2[i37];
            int i39 = 0;
            for (int i46 = 1; i46 < i19; i46++) {
                int i47 = iArr2[(i46 * i3) + i37];
                if (i38 <= i47) {
                    i39 = i46;
                    i38 = i47;
                }
            }
            iArr3[i17] = i38;
            int i48 = i17 + 1;
            while (true) {
                i18 = i16 - i17;
                if (i48 >= i18) {
                    break;
                }
                int i49 = i48 - i17;
                if (i39 >= i49) {
                    int i56 = i48 + i17;
                    int i57 = iArr2[(i56 * i3) + i37];
                    if (i38 <= i57) {
                        i39 = i56;
                        i38 = i57;
                    }
                } else {
                    i38 = iArr2[(i49 * i3) + i37];
                    for (int i58 = i49 + 1; i58 < (i19 + i48) - i17; i58++) {
                        int i59 = iArr2[(i58 * i3) + i37];
                        if (i38 <= i59) {
                            i49 = i58;
                            i38 = i59;
                        }
                    }
                    i39 = i49;
                }
                iArr3[i48] = i38;
                i48++;
            }
            for (int i65 = i17; i65 < i18; i65++) {
                iArr2[(i65 * i3) + i37] = iArr3[i65];
            }
        }
        return iArr2;
    }

    private int[] minFilter(int[] iArr, int i3, int i16, int i17) {
        int i18;
        int[] iArr2 = new int[i3 * i16];
        int i19 = (i17 << 1) + 1;
        int[] iArr3 = new int[i16];
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = i26 * i3;
            getMin(iArr, iArr2, i26, i3, i17);
            for (int i28 = 0; i28 < i17; i28++) {
                int i29 = i28 + i27;
                iArr2[i29] = iArr[i29];
                int i36 = ((i3 - i28) - 1) + i27;
                iArr2[i36] = iArr[i36];
            }
        }
        for (int i37 = 0; i37 < i3; i37++) {
            int i38 = iArr2[i37];
            int i39 = 0;
            for (int i46 = 1; i46 < i19; i46++) {
                int i47 = iArr2[(i46 * i3) + i37];
                if (i38 >= i47) {
                    i39 = i46;
                    i38 = i47;
                }
            }
            iArr3[i17] = i38;
            int i48 = i17 + 1;
            while (true) {
                i18 = i16 - i17;
                if (i48 >= i18) {
                    break;
                }
                int i49 = i48 - i17;
                if (i39 >= i49) {
                    int i56 = i48 + i17;
                    int i57 = iArr2[(i56 * i3) + i37];
                    if (i38 >= i57) {
                        i39 = i56;
                        i38 = i57;
                    }
                } else {
                    i38 = iArr2[(i49 * i3) + i37];
                    for (int i58 = i49 + 1; i58 < (i19 + i48) - i17; i58++) {
                        int i59 = iArr2[(i58 * i3) + i37];
                        if (i38 >= i59) {
                            i49 = i58;
                            i38 = i59;
                        }
                    }
                    i39 = i49;
                }
                iArr3[i48] = i38;
                i48++;
            }
            for (int i65 = i17; i65 < i18; i65++) {
                iArr2[(i65 * i3) + i37] = iArr3[i65];
            }
        }
        return iArr2;
    }

    private void produceDarkImgAndLightImg(byte[] bArr, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i3 = 0;
        for (int i16 = 3; i16 < bArr.length; i16 += 4) {
            int i17 = bArr[i16 - 3] & 255;
            int i18 = bArr[i16 - 2] & 255;
            int i19 = bArr[i16 - 1] & 255;
            int max = getMax(i17, i18, i19);
            int min = getMin(i17, i18, i19);
            int gray = getGray(i17, i18, i19);
            iArr[i3] = max;
            iArr2[i3] = min;
            iArr3[i3] = gray;
            int i26 = gray / 20;
            iArr4[i26] = iArr4[i26] + 1;
            i3++;
        }
    }

    private int scaleTexture(int i3) {
        this.mSrcRenderFBO.bind();
        this.mCopyTextureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        this.mSrcRenderFBO.unbind();
        return this.mSrcRenderFBO.getTexId();
    }

    public void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                SLog.e(TAG, new RuntimeException(str + ": glError " + glGetError));
            } else {
                return;
            }
        }
    }

    public int getAlignment16(int i3) {
        int i16 = i3 % 16;
        if (i16 == 0) {
            return i3;
        }
        return (i3 + 16) - i16;
    }

    float getAtmosphericLight(int[] iArr, long[] jArr, int i3, int i16, int i17) {
        int i18 = i3 * i16;
        int i19 = i18 / 1000;
        if (i19 <= 0) {
            i19 = i18 / 100;
        }
        int i26 = 0;
        float f16 = 0.0f;
        for (int i27 = 12; i27 >= 0 && i26 <= i19; i27--) {
            int i28 = iArr[i27];
            i26 += i28;
            if (i28 > 0) {
                f16 += ((float) jArr[i27]) * 1.0f;
            }
        }
        return f16 / i26;
    }

    public int getGray(int i3, int i16, int i17) {
        return (int) ((i3 * 0.299f) + (i16 * 0.587f) + (i17 * 0.114f));
    }

    public int getMax(int i3, int i16, int i17) {
        if (i16 > i3) {
            i3 = i16;
        }
        return i17 > i3 ? i17 : i3;
    }

    public int getMin(int i3, int i16, int i17) {
        if (i16 < i3) {
            i3 = i16;
        }
        return i17 < i3 ? i17 : i3;
    }

    public void guidedFilter(float[] fArr, float[] fArr2, int i3, float f16, int i16, int i17, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6) {
        int i18;
        int i19 = (i3 * 2) + 1;
        int i26 = i19 * i19;
        for (int i27 = 0; i27 < i17; i27++) {
            for (int i28 = 0; i28 < i16; i28++) {
                int i29 = i27 - i3;
                int i36 = 0;
                float f17 = 0.0f;
                float f18 = 0.0f;
                int i37 = i29;
                while (true) {
                    i18 = i27 + i3;
                    if (i37 > i18) {
                        break;
                    }
                    for (int i38 = i28 - i3; i38 <= i28 + i3; i38++) {
                        if (i37 >= 0 && i37 < i17 && i38 >= 0 && i38 < i16) {
                            int i39 = (i37 * i16) + i38;
                            f17 += fArr2[i39];
                            f18 += fArr[i39];
                        } else {
                            i36++;
                        }
                    }
                    i37++;
                }
                float f19 = i26 - i36;
                float f26 = f17 / f19;
                float f27 = f18 / f19;
                int i46 = 0;
                float f28 = 0.0f;
                float f29 = 0.0f;
                while (i29 <= i18) {
                    for (int i47 = i28 - i3; i47 <= i28 + i3; i47++) {
                        if (i29 >= 0 && i29 < i17 && i47 >= 0 && i47 < i16) {
                            int i48 = (i29 * i16) + i47;
                            float f36 = fArr[i48];
                            float f37 = fArr2[i48];
                            f28 += f36 * f37;
                            f29 += (f37 - f26) * (f37 - f26);
                        } else {
                            i46++;
                        }
                    }
                    i29++;
                }
                int i49 = (i27 * i16) + i28;
                float f38 = i26 - i46;
                float f39 = ((f28 / f38) - (f26 * f27)) / ((f29 / f38) + f16);
                fArr3[i49] = f39;
                fArr4[i49] = f27 - (f39 * f26);
            }
        }
        for (int i56 = 0; i56 < i17; i56++) {
            for (int i57 = 0; i57 < i16; i57++) {
                int i58 = 0;
                float f46 = 0.0f;
                float f47 = 0.0f;
                for (int i59 = i56 - i3; i59 <= i56 + i3; i59++) {
                    for (int i65 = i57 - i3; i65 <= i57 + i3; i65++) {
                        if (i59 >= 0 && i59 < i17 && i65 >= 0 && i65 < i16) {
                            int i66 = (i59 * i16) + i65;
                            f46 += fArr3[i66];
                            f47 += fArr4[i66];
                        } else {
                            i58++;
                        }
                    }
                }
                int i67 = (i56 * i16) + i57;
                float f48 = i26 - i58;
                fArr5[i67] = f46 / f48;
                float f49 = f47 / f48;
                fArr6[i67] = f49;
                float f56 = (fArr5[i67] * fArr2[i67]) + f49;
                if (f56 > 1.0f) {
                    f56 = 1.0f;
                }
                if (f56 < 0.0f) {
                    f56 = 0.0f;
                }
                fArr[i67] = f56;
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return super.isFilterWork();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    @SuppressLint({"NewApi"})
    public void onDrawFrame() {
        if (!this.enableImgFilter) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        if (this.mClip8RenderFBO != null && this.mCopyTextureRender != null) {
            int[] iArr = new int[5];
            GLES20.glGenBuffers(5, iArr, 0);
            checkGlError("glGenBuffers");
            int clipTexture = clipTexture(this.mInputTextureID);
            int[] glDisPatchGPUAvgPixelsFilterCompute = this.imgFilterPixelsFilter.glDisPatchGPUAvgPixelsFilterCompute(clipTexture, this.CLIP_WIDTH, this.CLIP_HEIGHT, iArr, this.mWindow);
            float[] fArr = new float[this.CLIP_HEIGHT * this.CLIP_WIDTH];
            int[] iArr2 = new int[13];
            long[] jArr = new long[13];
            int i3 = 0;
            while (i3 < glDisPatchGPUAvgPixelsFilterCompute.length) {
                int i16 = glDisPatchGPUAvgPixelsFilterCompute[i3];
                int i17 = i16 / 20;
                iArr2[i17] = iArr2[i17] + 1;
                jArr[i17] = jArr[i17] + i16;
                fArr[i3] = i16 / 255.0f;
                i3++;
                iArr = iArr;
            }
            int[] iArr3 = iArr;
            float atmosphericLight = getAtmosphericLight(iArr2, jArr, this.CLIP_WIDTH, this.CLIP_HEIGHT, this.mWindow);
            SLog.d(TAG, "getAtmosphericLight=" + atmosphericLight);
            int copyTransmissionTexture = copyTransmissionTexture();
            getTransmissionDark(clipTexture, copyTransmissionTexture, iArr3, this.CLIP_WIDTH, this.CLIP_HEIGHT, fArr, atmosphericLight, this.mWindow);
            int glDisPatchImgFilterCompute = this.gpuImgFilterRecoverFilter.glDisPatchImgFilterCompute(iArr3, copyInputTexture(this.mInputTextureID), copyoutputTexture(this.mInputTextureID), scaleTexture(copyTransmissionTexture), atmosphericLight, this.SRC_WIDTH, this.SRC_HEIGHT, null);
            GLES20.glDeleteBuffers(5, iArr3, 0);
            this.mOutputTextureID = glDisPatchImgFilterCompute;
            return;
        }
        init();
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
    }

    public void setEnable(boolean z16) {
        this.enableImgFilter = z16;
    }

    void getMax(int[] iArr, int[] iArr2, int i3, int i16, int i17) {
        int i18 = i3 * i16;
        int i19 = i17 << 1;
        int i26 = i19 + 1;
        int i27 = iArr[i18 + 0];
        int i28 = 0;
        for (int i29 = 1; i29 < i26; i29++) {
            int i36 = iArr[i29 + i18];
            if (i27 <= i36) {
                i28 = i29;
                i27 = i36;
            }
        }
        iArr2[i17 + i18] = iArr[i28 + i18];
        for (int i37 = i17 + 1; i37 < i16 - i17; i37++) {
            int i38 = i37 - i17;
            if (i28 >= i38) {
                i38 = (i19 + i37) - i17;
                if (iArr[i28 + i18] > iArr[i38 + i18]) {
                    iArr2[i37 + i18] = iArr[i28 + i18];
                }
            } else {
                int i39 = iArr[i38 + i18];
                for (int i46 = i38 + 1; i46 < (i26 + i37) - i17; i46++) {
                    int i47 = iArr[i46 + i18];
                    if (i39 <= i47) {
                        i38 = i46;
                        i39 = i47;
                    }
                }
            }
            i28 = i38;
            iArr2[i37 + i18] = iArr[i28 + i18];
        }
    }

    void getMin(int[] iArr, int[] iArr2, int i3, int i16, int i17) {
        int i18 = i3 * i16;
        int i19 = i17 << 1;
        int i26 = i19 + 1;
        int i27 = iArr[i18 + 0];
        int i28 = 0;
        for (int i29 = 1; i29 < i26; i29++) {
            int i36 = iArr[i29 + i18];
            if (i27 >= i36) {
                i28 = i29;
                i27 = i36;
            }
        }
        iArr2[i17 + i18] = iArr[i28 + i18];
        for (int i37 = i17 + 1; i37 < i16 - i17; i37++) {
            int i38 = i37 - i17;
            if (i28 >= i38) {
                i38 = (i19 + i37) - i17;
                if (iArr[i28 + i18] < iArr[i38 + i18]) {
                    iArr2[i37 + i18] = iArr[i28 + i18];
                }
            } else {
                int i39 = iArr[i38 + i18];
                for (int i46 = i38 + 1; i46 < (i26 + i37) - i17; i46++) {
                    int i47 = iArr[i46 + i18];
                    if (i39 >= i47) {
                        i38 = i46;
                        i39 = i47;
                    }
                }
            }
            i28 = i38;
            iArr2[i37 + i18] = iArr[i28 + i18];
        }
    }
}
