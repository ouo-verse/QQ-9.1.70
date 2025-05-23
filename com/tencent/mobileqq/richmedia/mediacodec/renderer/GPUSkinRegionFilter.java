package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes18.dex */
public class GPUSkinRegionFilter {
    private static final String TAG = "GPUSkinRegionFilter";
    private static final int outputMaskHeight = 240;
    private static final int outputMaskWidth = 136;
    private static final int skinComputeHeight = 120;
    private static final int skinComputeWidth = 68;
    private static final boolean useFace = false;
    private int imageHeight;
    private int imageWidth;
    private RenderBuffer mRenderFBO;
    private final Object mTextureLock;
    private RenderBuffer mZoomFBO;
    private byte[] maskData;
    private SkinRegionComputeThread skinRegionComputeThread;
    private boolean mIsInitialized = false;
    private GPUTextureMergeFilter textureMergeFilter = new GPUTextureMergeFilter();
    private GPUBaseFilter zoomFilter = new GPUBaseFilter();

    public GPUSkinRegionFilter() {
        SkinRegionComputeThread skinRegionComputeThread = new SkinRegionComputeThread();
        this.skinRegionComputeThread = skinRegionComputeThread;
        skinRegionComputeThread.initRegionCompute(68, 120, 136, 240, false);
        this.mTextureLock = new Object();
    }

    public void init() {
        if (SLog.isEnable()) {
            SLog.d(TAG, "GPU Skin RegionFilter init");
        }
        if (this.mIsInitialized) {
            return;
        }
        this.mIsInitialized = true;
        this.textureMergeFilter.init();
        this.zoomFilter.init();
        this.zoomFilter.onOutputSizeChanged(68, 120);
        if (this.mZoomFBO == null) {
            this.mZoomFBO = new RenderBuffer(false, 68, 120, 33985);
        }
        this.maskData = new byte[32640];
    }

    public int mergeTexture(List<List<PointF>> list, int i3, int i16) {
        float f16;
        float f17;
        float f18;
        boolean z16;
        if (this.mRenderFBO == null) {
            SLog.e(TAG, "mergeTexture error, renderFBO == null");
            return i16;
        }
        float f19 = 0.0f;
        if (list.size() > 0) {
            List<PointF> list2 = list.get(0);
            f16 = 0.0f;
            f17 = 0.0f;
            f18 = 0.0f;
            for (int i17 = 0; i17 < list2.size(); i17++) {
                PointF pointF = list2.get(i17);
                if (i17 == 0) {
                    f19 = pointF.x;
                    f17 = pointF.y;
                    f18 = f17;
                    f16 = f19;
                } else {
                    float f26 = pointF.x;
                    if (f19 >= f26) {
                        f19 = f26;
                    }
                    float f27 = pointF.y;
                    if (f17 >= f27) {
                        f17 = f27;
                    }
                    if (f16 <= f26) {
                        f16 = f26;
                    }
                    if (f18 <= f27) {
                        f18 = f27;
                    }
                }
            }
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
            f18 = 0.0f;
        }
        float f28 = (68.0f / this.imageWidth) / 0.25f;
        float f29 = (120.0f / this.imageHeight) / 0.25f;
        float f36 = f19 * f28;
        float f37 = f16 * f28;
        float f38 = 120.0f - (f17 * f29);
        float f39 = 120.0f - (f18 * f29);
        if ((f37 - f36) * (f38 - f39) > 4080.0f) {
            return i16;
        }
        float[] fArr = {f36, f39, f37, f38};
        if (this.skinRegionComputeThread != null) {
            synchronized (this.mTextureLock) {
                this.mZoomFBO.bind();
                this.zoomFilter.drawTexture(i3, null, null);
                this.mZoomFBO.unbind();
            }
            this.skinRegionComputeThread.skinRegionCompute(this.mZoomFBO.getTexId(), fArr);
            z16 = this.skinRegionComputeThread.copyMaskData(this.maskData);
        } else {
            z16 = false;
        }
        if (!z16) {
            SLog.d(TAG, "maskData not exist, return");
            return i16;
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.maskData);
        wrap.position(0);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, iArr[0]);
        GlUtil.checkGlError("glBindTexture " + iArr[0]);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, NativeBitmapStruct.GLFormat.GL_ALPHA, 136, 240, 0, NativeBitmapStruct.GLFormat.GL_ALPHA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, wrap);
        int i18 = iArr[0];
        GlUtil.checkGlError("glTexParameter");
        this.mRenderFBO.setTexId(i16);
        this.mRenderFBO.bind();
        this.textureMergeFilter.drawTexture(i3, i16, i18, null, null);
        this.mRenderFBO.unbind();
        return i16;
    }

    public void onOutputSizeChanged(int i3, int i16) {
        this.textureMergeFilter.onOutputSizeChanged(i3, i16);
        this.imageWidth = i3;
        this.imageHeight = i16;
        if (DeviceInstance.getSDKVersion() >= 17) {
            this.skinRegionComputeThread.init(i3, i16, EGL14.eglGetCurrentContext(), this.mTextureLock);
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer == null || ((renderBuffer.getHeight() != i16 && i16 != 0) || (this.mRenderFBO.getWidth() != i3 && i3 != 0))) {
            RenderBuffer renderBuffer2 = this.mRenderFBO;
            if (renderBuffer2 != null) {
                renderBuffer2.destroy();
            }
            this.mRenderFBO = new RenderBuffer(false, i3, i16, 33985);
        }
    }

    public void release() {
        GPUTextureMergeFilter gPUTextureMergeFilter = this.textureMergeFilter;
        if (gPUTextureMergeFilter != null) {
            gPUTextureMergeFilter.destroy();
            this.textureMergeFilter = null;
        }
        GPUBaseFilter gPUBaseFilter = this.zoomFilter;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
            this.zoomFilter = null;
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.mRenderFBO = null;
        }
        RenderBuffer renderBuffer2 = this.mZoomFBO;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
            this.mZoomFBO = null;
        }
        SkinRegionComputeThread skinRegionComputeThread = this.skinRegionComputeThread;
        if (skinRegionComputeThread != null) {
            skinRegionComputeThread.onDestroy();
            this.skinRegionComputeThread = null;
        }
    }
}
