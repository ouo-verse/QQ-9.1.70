package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQDynamicStickersFilter extends QQBaseFilter {
    private static String TAG = "QQDynamicStickersFilter";
    private boolean bwork;
    private List<DynamicStickerData> mDynamicStickers;
    private GPUAlphaBlendFilter mMultiStickerFilter;
    private RenderBuffer mRenderFBO;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private boolean mbReversed;
    private float[][] mvpMatrix;
    private int textureId;
    private float[] textureMatrix;

    public QQDynamicStickersFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.bwork = false;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mbReversed = true;
        this.textureMatrix = null;
    }

    public void InitDynamicStickers(List<DynamicStickerData> list) {
        if (list != null && list.size() > 0) {
            this.mDynamicStickers = list;
            Iterator<DynamicStickerData> it = list.iterator();
            while (it.hasNext()) {
                it.next().mGifDecoder.init();
            }
            this.mvpMatrix = new float[list.size()];
            this.bwork = true;
        }
        if (this.mbReversed) {
            this.textureMatrix = null;
        } else {
            this.textureMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        }
    }

    public void SetReversedCoordination(boolean z16) {
        this.mbReversed = z16;
        if (z16) {
            this.textureMatrix = null;
        } else {
            this.textureMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        }
    }

    public float[] caculateMatrix(DynamicStickerData dynamicStickerData, TrackerStickerParam.MotionInfo motionInfo) {
        float f16;
        float f17 = this.mSurfaceWidth / this.mSurfaceHeight;
        GlMatricUtil glMatricUtil = new GlMatricUtil();
        glMatricUtil.ortho(f17 * (-1.0f), f17 * 1.0f, -1.0f, 1.0f, 3.0f, 20.0f);
        glMatricUtil.setCamera(0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        PointF pointF = dynamicStickerData.centerP;
        float f18 = pointF.x + dynamicStickerData.translateX;
        float f19 = pointF.y + dynamicStickerData.translateY;
        if (motionInfo != null) {
            f18 = motionInfo.f281358x;
            f19 = motionInfo.f281359y;
        }
        float f26 = (f18 * 2.0f) / dynamicStickerData.layerWidth;
        float f27 = (f19 * 2.0f) / dynamicStickerData.layerHeight;
        if (this.mbReversed) {
            glMatricUtil.translate((f26 - 1.0f) * f17, f27 - 1.0f, 0.0f);
            f16 = 1.0f;
        } else {
            f16 = 1.0f;
            glMatricUtil.translate((f26 - 1.0f) * f17, 1.0f - f27, 0.0f);
        }
        int i3 = this.mSurfaceWidth;
        float f28 = i3 / dynamicStickerData.layerWidth;
        int i16 = this.mSurfaceHeight;
        float f29 = i16 / dynamicStickerData.layerHeight;
        float f36 = dynamicStickerData.width / i3;
        float f37 = dynamicStickerData.height / i16;
        float f38 = dynamicStickerData.scale;
        float f39 = f28 * f38 * f36 * f17;
        float f46 = f38 * f29 * f37;
        glMatricUtil.rotate(dynamicStickerData.rotate, 0.0f, 0.0f, f16);
        glMatricUtil.scale(f39, f46, f16);
        SLog.d("giftrackerMatrix ", "finalScaleX : " + f39 + " finalScaleY:" + f46);
        float[] finalMatrix = glMatricUtil.getFinalMatrix();
        String str = "mvp: ";
        for (int i17 = 0; i17 < 16; i17++) {
            str = str + " " + finalMatrix[i17];
        }
        SLog.d("giftrackerMatrix ", str);
        return finalMatrix;
    }

    TrackerStickerParam.MotionInfo getTrackerPoint(long j3, DynamicStickerData dynamicStickerData) {
        TrackerStickerParam.MotionInfo motionInfo = dynamicStickerData.mapMotionTrack.get(Long.valueOf(j3));
        if (motionInfo == null) {
            return new TrackerStickerParam.MotionInfo(true, 0L, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        return motionInfo;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        return this.bwork;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    @TargetApi(17)
    public void onDrawFrame() {
        long j3;
        boolean z16;
        if (this.bwork && this.mRenderFBO != null) {
            long presentTimeStamp = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
            long orgTimeStamp = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
            long videoStartTime = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
            long j16 = orgTimeStamp / 1000000;
            if (j16 > videoStartTime) {
                j3 = j16 - videoStartTime;
            } else {
                j3 = 0;
            }
            List<DynamicStickerData> list = this.mDynamicStickers;
            if (list != null && list.size() > 0) {
                try {
                    this.mRenderFBO.setTexId(this.mInputTextureID);
                    this.mRenderFBO.bind();
                    for (int i3 = 0; i3 < this.mDynamicStickers.size(); i3++) {
                        Bitmap nextGifFrame = this.mDynamicStickers.get(i3).mGifDecoder.getNextGifFrame(presentTimeStamp);
                        if (this.mDynamicStickers.get(i3).isShow((int) j3)) {
                            DynamicStickerData dynamicStickerData = this.mDynamicStickers.get(i3);
                            if (dynamicStickerData.mapMotionTrack.size() != 0) {
                                TrackerStickerParam.MotionInfo trackerPoint = getTrackerPoint(presentTimeStamp, dynamicStickerData);
                                if (!trackerPoint.isLost) {
                                    this.mvpMatrix[i3] = caculateMatrix(dynamicStickerData, trackerPoint);
                                } else {
                                    z16 = true;
                                    if (nextGifFrame != null && !z16) {
                                        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
                                        GlUtil.checkGlError("glBindTexture " + this.textureId);
                                        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                                        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                                        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
                                        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
                                        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, nextGifFrame, 0);
                                        GlUtil.checkGlError("glTexParameter");
                                        this.mMultiStickerFilter.drawTexture(this.textureId, this.textureMatrix, this.mvpMatrix[i3]);
                                    }
                                }
                            }
                            z16 = false;
                            if (nextGifFrame != null) {
                                GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureId);
                                GlUtil.checkGlError("glBindTexture " + this.textureId);
                                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
                                GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
                                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
                                GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
                                GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, nextGifFrame, 0);
                                GlUtil.checkGlError("glTexParameter");
                                this.mMultiStickerFilter.drawTexture(this.textureId, this.textureMatrix, this.mvpMatrix[i3]);
                            }
                        }
                    }
                    this.mRenderFBO.unbind();
                    this.mOutputTextureID = this.mRenderFBO.getTexId();
                } catch (Throwable unused) {
                    this.mOutputTextureID = this.mInputTextureID;
                }
            }
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        this.textureId = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D);
        if (i3 != this.mSurfaceWidth || i16 != this.mSurfaceHeight) {
            this.mSurfaceWidth = i3;
            this.mSurfaceHeight = i16;
            this.mRenderFBO = null;
            this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
            for (int i17 = 0; i17 < this.mDynamicStickers.size(); i17++) {
                this.mvpMatrix[i17] = caculateMatrix(this.mDynamicStickers.get(i17), null);
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
        if (this.mMultiStickerFilter == null) {
            GPUAlphaBlendFilter gPUAlphaBlendFilter = new GPUAlphaBlendFilter();
            this.mMultiStickerFilter = gPUAlphaBlendFilter;
            gPUAlphaBlendFilter.init();
            GPUBaseFilter.checkGlError("filter init");
        }
        this.mSurfaceWidth = getQQFilterRenderManager().getSufaceWidth();
        this.mSurfaceHeight = getQQFilterRenderManager().getSurfaceHeight();
        if (this.mDynamicStickers != null) {
            for (int i3 = 0; i3 < this.mDynamicStickers.size(); i3++) {
                this.mvpMatrix[i3] = caculateMatrix(this.mDynamicStickers.get(i3), null);
            }
        }
        try {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                SLog.e(TAG, "previousUnknownError: glError 0x" + Integer.toHexString(glGetError));
            }
            this.mRenderFBO = new RenderBuffer(this.mSurfaceWidth, this.mSurfaceHeight, 33984);
        } catch (Throwable unused) {
            this.mRenderFBO = null;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        this.mMultiStickerFilter.destroy();
    }
}
