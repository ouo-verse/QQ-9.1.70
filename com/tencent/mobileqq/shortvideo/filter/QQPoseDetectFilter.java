package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor;
import com.tencent.mobileqq.shortvideo.dancemachine.tempDir.HumanPoseFilter;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* loaded from: classes18.dex */
public class QQPoseDetectFilter extends QQBaseFilter {
    public static final String TAG = "QQPoseDetectFilter";
    float[] inMvpMatrix;
    private int initHeight;
    private int initWidth;
    private HumanPoseFilter mHumanFilter;
    private PoseDetectProcessor mProcessor;
    private RenderBuffer mRenderInFBO;
    private RenderBuffer mRenderOutFBO;
    private RenderBuffer mRenderTmp;
    private int scaleTexture;
    private boolean shouldInitTexture;
    private int surfaceHeight;
    private int surfaceWidth;
    private TextureRender textureRender;

    public QQPoseDetectFilter(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.shouldInitTexture = false;
        this.mProcessor = null;
        this.initWidth = 144;
        this.initHeight = 256;
        this.mHumanFilter = new HumanPoseFilter(this.initWidth, this.initHeight);
        this.inMvpMatrix = new float[16];
        QmcfManager.getInstance().setCurrQmcfMode(0);
        this.mProcessor = new PoseDetectProcessor(this.initWidth, this.initHeight);
    }

    private void initTexture() {
        boolean z16;
        RenderBuffer renderBuffer = this.mRenderInFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.mRenderOutFBO;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
        TextureRender textureRender = this.textureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        RenderBuffer renderBuffer3 = this.mRenderTmp;
        if (renderBuffer3 != null) {
            renderBuffer3.destroy();
        }
        int inputHeight = this.mProcessor.getInputHeight();
        int inputWidth = this.mProcessor.getInputWidth();
        if (DeviceInstance.getSDKVersion() >= 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mRenderInFBO = new RenderBuffer(inputHeight, inputWidth, 33984, z16);
        this.mRenderOutFBO = new RenderBuffer(this.surfaceWidth, this.surfaceHeight, 33984);
        RenderBuffer renderBuffer4 = new RenderBuffer(this.surfaceWidth, this.surfaceHeight);
        this.mRenderTmp = renderBuffer4;
        this.mHumanFilter.updateFboSize(renderBuffer4);
        this.textureRender = new TextureRender();
    }

    public float[] getKeyPoints() {
        return this.mProcessor.getKeyPoints();
    }

    public int getPoseInitHeight() {
        return this.initHeight;
    }

    public int getPoseInitWidth() {
        return this.initWidth;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        if (QmcfManager.getInstance().getCurrQmcfMode() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        try {
            this.mProcessor.doInit();
            if (this.shouldInitTexture) {
                initTexture();
                this.shouldInitTexture = false;
                this.mOutputTextureID = this.mInputTextureID;
                return;
            }
            Matrix.setIdentityM(this.inMvpMatrix, 0);
            Matrix.setRotateM(this.inMvpMatrix, 0, 180.0f, 1.0f, 0.0f, 0.0f);
            this.mRenderInFBO.bind();
            this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mInputTextureID, QmcfManager.getInstance().mSTMatrix, this.inMvpMatrix);
            this.mRenderInFBO.unbind();
            int texId = this.mRenderInFBO.getTexId();
            this.scaleTexture = texId;
            this.mProcessor.doProcess(texId, this.mRenderOutFBO.getTexId());
            if (QmcfManager.isDebugMode && this.mHumanFilter != null) {
                this.mRenderTmp.setUserTextureId(this.mInputTextureID);
                this.mRenderTmp.bind();
                this.mHumanFilter.updateParams(this.mRenderTmp, this.mProcessor.getKeyPoints());
                this.mHumanFilter.drawFrame(this.mRenderTmp);
            }
            this.mOutputTextureID = this.mInputTextureID;
        } catch (Error e16) {
            QmcfManager.getInstance().setQmcfRunSupported(false, false, 2);
            this.mOutputTextureID = this.mInputTextureID;
            SLog.e(TAG, "process excep!", e16);
        } catch (Exception e17) {
            QmcfManager.getInstance().setQmcfRunSupported(false, false, 2);
            this.mOutputTextureID = this.mInputTextureID;
            SLog.e(TAG, "process excep!", e17);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceChange");
        }
        this.surfaceWidth = i3;
        this.surfaceHeight = i16;
        this.shouldInitTexture = true;
        this.mProcessor.doDestroy();
        if (this.surfaceWidth > 0 && this.surfaceHeight > 0 && QmcfManager.getInstance().getCurrFrameType() != 1) {
            int i17 = this.initHeight;
            int i18 = (this.surfaceWidth * i17) / this.surfaceHeight;
            this.initWidth = i18;
            if (i18 < 144) {
                this.initWidth = 144;
            }
            this.mProcessor.setInputSize(this.initWidth, i17);
            if (QmcfManager.isDebugMode) {
                this.mHumanFilter.updatePoseSize(this.initWidth, this.initHeight);
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceCreate");
        }
        this.shouldInitTexture = true;
        this.mHumanFilter.initHumanFilter();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        this.shouldInitTexture = true;
        this.mProcessor.doDestroy();
        QmcfManager.getInstance().destroy();
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceDestroy");
        }
    }
}
