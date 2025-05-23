package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.GlMatricUtil;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQTrackerStickersFilter extends QQBaseFilter {
    private static String TAG = "QQTrackerStickersFilter";
    private boolean bwork;
    private ArrayList<TrackerStickerParam> listStickers;
    private GPUAlphaBlendFilter mMultiStickerFilter;
    private RenderBuffer mRenderFBO;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private boolean mbReversed;
    private float[][] mvpMatrix;
    private int[] textureId;
    private float[] textureMatrix;

    public QQTrackerStickersFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.bwork = false;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mbReversed = true;
        this.textureMatrix = null;
    }

    public void InitTrackerStickers(ArrayList<TrackerStickerParam> arrayList) {
        this.listStickers = arrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.textureId = new int[this.listStickers.size()];
            this.mvpMatrix = new float[this.listStickers.size()];
            this.bwork = true;
        } else {
            this.bwork = false;
            SLog.i(TAG, "TrackerStickerParam is null or zero");
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

    public float[] caculateMatrix(TrackerStickerParam trackerStickerParam, TrackerStickerParam.MotionInfo motionInfo) {
        float f16;
        float f17 = this.mSurfaceWidth / this.mSurfaceHeight;
        GlMatricUtil glMatricUtil = new GlMatricUtil();
        glMatricUtil.ortho(f17 * (-1.0f), f17 * 1.0f, -1.0f, 1.0f, 3.0f, 20.0f);
        glMatricUtil.setCamera(0.0f, 0.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        float f18 = (motionInfo.f281358x * 2.0f) / trackerStickerParam.layerWidth;
        float f19 = (motionInfo.f281359y * 2.0f) / trackerStickerParam.layerHeight;
        if (this.mbReversed) {
            glMatricUtil.translate((f18 - 1.0f) * f17, f19 - 1.0f, 0.0f);
            f16 = 1.0f;
        } else {
            f16 = 1.0f;
            glMatricUtil.translate((f18 - 1.0f) * f17, 1.0f - f19, 0.0f);
        }
        int i3 = this.mSurfaceWidth;
        float f26 = i3 / trackerStickerParam.layerWidth;
        int i16 = this.mSurfaceHeight;
        float f27 = i16 / trackerStickerParam.layerHeight;
        float f28 = trackerStickerParam.width / i3;
        float f29 = trackerStickerParam.height / i16;
        float f36 = trackerStickerParam.scale;
        float f37 = f26 * f36 * f28 * f17;
        float f38 = f36 * f27 * f29;
        glMatricUtil.rotate(trackerStickerParam.rotate, 0.0f, 0.0f, f16);
        glMatricUtil.scale(f37, f38, f16);
        SLog.d("trackerMatrix ", "finalScaleX : " + f37 + " finalScaleY:" + f38);
        float[] finalMatrix = glMatricUtil.getFinalMatrix();
        String str = "mvp: ";
        for (int i17 = 0; i17 < 16; i17++) {
            str = str + " " + finalMatrix[i17];
        }
        SLog.d("trackerMatrix ", str);
        return finalMatrix;
    }

    TrackerStickerParam.MotionInfo getTrackerPoint(long j3, TrackerStickerParam trackerStickerParam) {
        TrackerStickerParam.MotionInfo motionInfo = trackerStickerParam.mapMotionTrack.get(Long.valueOf(j3));
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
        int i3;
        int i16;
        if (this.bwork) {
            long orgTimeStamp = getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp();
            long presentTimeStamp = getQQFilterRenderManager().getBusinessOperation().getPresentTimeStamp();
            long videoStartTime = getQQFilterRenderManager().getBusinessOperation().getVideoStartTime();
            long j16 = orgTimeStamp / 1000000;
            if (j16 > videoStartTime) {
                j3 = j16 - videoStartTime;
            } else {
                j3 = 0;
            }
            long j17 = j3;
            try {
                this.mRenderFBO.setTexId(this.mInputTextureID);
                this.mRenderFBO.bind();
                int i17 = 0;
                int i18 = 0;
                while (i18 < this.listStickers.size()) {
                    TrackerStickerParam trackerStickerParam = this.listStickers.get(i18);
                    if (trackerStickerParam.isShow((int) j17)) {
                        Map<Long, TrackerStickerParam.MotionInfo> map = trackerStickerParam.mapMotionTrack;
                        if (map != null && map.size() != 0) {
                            TrackerStickerParam.MotionInfo trackerPoint = getTrackerPoint(orgTimeStamp, trackerStickerParam);
                            if (!trackerPoint.isLost) {
                                this.mvpMatrix[i18] = caculateMatrix(trackerStickerParam, trackerPoint);
                                GLES20.glViewport(i17, i17, this.mSurfaceWidth, this.mSurfaceHeight);
                                this.mMultiStickerFilter.drawTexture(this.textureId[i18], this.textureMatrix, this.mvpMatrix[i18]);
                            }
                        }
                        PointF pointF = trackerStickerParam.centerP;
                        i3 = i18;
                        this.mvpMatrix[i3] = caculateMatrix(trackerStickerParam, new TrackerStickerParam.MotionInfo(false, presentTimeStamp, pointF.x + trackerStickerParam.translateXValue, pointF.y + trackerStickerParam.translateYValue, 1.0f, 0.0f));
                        i16 = 0;
                        GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
                        this.mMultiStickerFilter.drawTexture(this.textureId[i3], this.textureMatrix, this.mvpMatrix[i3]);
                        i18 = i3 + 1;
                        i17 = i16;
                    }
                    i16 = i17;
                    i3 = i18;
                    i18 = i3 + 1;
                    i17 = i16;
                }
                this.mRenderFBO.unbind();
                this.mOutputTextureID = this.mRenderFBO.getTexId();
                return;
            } catch (Throwable unused) {
                this.mOutputTextureID = this.mInputTextureID;
                return;
            }
        }
        this.mOutputTextureID = this.mInputTextureID;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        if (i3 != this.mSurfaceWidth || i16 != this.mSurfaceHeight) {
            this.mSurfaceWidth = i3;
            this.mSurfaceHeight = i16;
            this.mRenderFBO = null;
            this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
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
        if (this.listStickers != null) {
            for (int i3 = 0; i3 < this.listStickers.size(); i3++) {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.listStickers.get(i3).path);
                if (decodeFile != null) {
                    this.textureId[i3] = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, decodeFile);
                }
            }
        }
        this.mSurfaceWidth = getQQFilterRenderManager().getSufaceWidth();
        this.mSurfaceHeight = getQQFilterRenderManager().getSurfaceHeight();
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
