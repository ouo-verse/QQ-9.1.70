package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQFaceDetectBase extends QQBaseFilter {
    public static final int FACE_DETECT_OFF = 2;
    public static final int FACE_DETECT_ON = 1;
    private boolean isCaptureMode;
    boolean isInit;
    private int lastFrameHeight;
    private int lastFrameWidth;
    private BaseFilter mCopyFilter;
    private int mDetectCount;
    private int mFaceDetectType;
    private BaseFilter mFlipFilter;
    private boolean mNeedDetectCount;
    private boolean needFlip;

    public QQFaceDetectBase(QQFilterRenderManager qQFilterRenderManager) {
        super(-1, qQFilterRenderManager);
        this.mCopyFilter = null;
        this.mFlipFilter = null;
        this.isInit = false;
        this.needFlip = true;
        this.mFaceDetectType = 1;
        this.mNeedDetectCount = false;
        this.mDetectCount = 0;
        this.isCaptureMode = false;
        this.lastFrameWidth = 0;
        this.lastFrameHeight = 0;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        Frame RenderProcess;
        Frame RenderProcess2;
        boolean z16 = true;
        if (!this.isInit && FeatureManager.loadBasicFeatures()) {
            BaseFilter baseFilter = this.mFlipFilter;
            if (baseFilter == null) {
                this.mFlipFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
            } else {
                baseFilter.clearGLSL();
            }
            this.mFlipFilter.apply();
            this.mFlipFilter.setRotationAndFlip(0, 0, 1);
            BaseFilter baseFilter2 = this.mCopyFilter;
            if (baseFilter2 == null) {
                this.mCopyFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
            } else {
                baseFilter2.clearGLSL();
            }
            this.mCopyFilter.apply();
            this.isInit = true;
        }
        if (this.isInit) {
            QQFilterLogManager.setPTVStart();
            if (this.needFlip) {
                RenderProcess = this.mFlipFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
            } else {
                RenderProcess = this.mCopyFilter.RenderProcess(this.mInputTextureID, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
            }
            QQFilterLogManager.setPTVEnd("\u7b2c\u4e00\u6b21\u7ffb\u8f6ctexture\u8017\u65f6");
            getQQFilterRenderManager().setFaceDetectFlags(true);
            getQQFilterRenderManager().initDetectFaceSDK(RenderProcess);
            if (this.lastFrameWidth != RenderProcess.width || this.lastFrameHeight != RenderProcess.height) {
                getQQFilterRenderManager().initDetectFaceSDK(RenderProcess);
            }
            this.lastFrameWidth = RenderProcess.width;
            this.lastFrameHeight = RenderProcess.height;
            QQFilterLogManager.setPTVEnd("\u4eba\u8138sdk\u8017\u65f6");
            if (this.mNeedDetectCount && getQQFilterRenderManager().hasAEDetectorInited()) {
                this.mDetectCount++;
            }
            if (this.mNeedDetectCount) {
                if (this.mDetectCount < 2) {
                    z16 = false;
                }
                if (z16) {
                    this.mNeedDetectCount = false;
                    this.mDetectCount = 0;
                    SLog.d("QQFaceDetectBase", "reset mNeedDetectCount!");
                }
            }
            PTFaceAttr faceAttr = getQQFilterRenderManager().getFaceAttr();
            if (getQQFilterRenderManager().hasAEDetectorInited() && faceAttr != null && faceAttr.getFaceCount() > 0 && z16) {
                RenderProcess = getQQFilterRenderManager().getFaceAttr().getOrigFrame();
            }
            if (this.needFlip) {
                RenderProcess2 = this.mFlipFilter.RenderProcess(RenderProcess.getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
            } else {
                RenderProcess2 = this.mCopyFilter.RenderProcess(RenderProcess.getTextureId(), getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
            }
            this.mOutputTextureID = RenderProcess2.getTextureId();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void setCaptureMode(boolean z16) {
        this.isCaptureMode = z16;
    }

    public void setFaceDetectType(int i3) {
        if (this.mFaceDetectType == 2 && i3 == 1) {
            this.mNeedDetectCount = true;
            this.mDetectCount = 0;
            SLog.d("QQFaceDetectBase", "mNeedDetectCount on!");
        }
        this.mFaceDetectType = i3;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void setInputTextureID(int i3) {
        super.setInputTextureID(i3);
        this.mOutputTextureID = this.mInputTextureID;
    }

    public void setNeedFlip(boolean z16) {
        this.needFlip = z16;
    }
}
