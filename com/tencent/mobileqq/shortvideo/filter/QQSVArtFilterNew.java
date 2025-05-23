package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor;
import com.tencent.mobileqq.qmcf.processor.BaseQmcfProcessor;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQSVArtFilterNew extends QQBaseFilter {
    public static final String TAG = "QQSVArtFilter";
    private int frameCount;
    private int initHeight;
    private int initWidth;
    private RenderBuffer mFilterOutFBO;
    private BaseQmcfProcessor mProcessor;
    private RenderBuffer mSoInFBO;
    private int mSoInTexture;
    private RenderBuffer mSoOutFBO;
    private int mSoOutTexture;
    private boolean shouldInitTexture;
    private TextureRender textureRender;

    public QQSVArtFilterNew(int i3, QQFilterRenderManager qQFilterRenderManager) {
        super(i3, qQFilterRenderManager);
        this.shouldInitTexture = false;
        this.mProcessor = null;
        this.initWidth = 480;
        this.initHeight = 640;
        this.frameCount = 0;
        QmcfManager.getInstance().setCurrQmcfMode(0);
        this.mProcessor = new ArtFilterProcessor(this.initWidth, this.initHeight);
    }

    private void initTexture() {
        boolean z16;
        RenderBuffer renderBuffer = this.mSoInFBO;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.mSoOutFBO;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
        }
        RenderBuffer renderBuffer3 = this.mFilterOutFBO;
        if (renderBuffer3 != null) {
            renderBuffer3.destroy();
        }
        TextureRender textureRender = this.textureRender;
        if (textureRender != null) {
            textureRender.release();
        }
        int inputWidth = this.mProcessor.getInputWidth();
        int inputHeight = this.mProcessor.getInputHeight();
        boolean z17 = true;
        if (DeviceInstance.getSDKVersion() >= 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mSoInFBO = new RenderBuffer(inputWidth, inputHeight, 33984, z16);
        int inputWidth2 = this.mProcessor.getInputWidth();
        int inputHeight2 = this.mProcessor.getInputHeight();
        if (DeviceInstance.getSDKVersion() < 21) {
            z17 = false;
        }
        this.mSoOutFBO = new RenderBuffer(inputWidth2, inputHeight2, 33984, z17);
        this.mFilterOutFBO = new RenderBuffer(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), 33984);
        this.textureRender = new TextureRender();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public boolean isFilterWork() {
        if (QmcfManager.getInstance().getCurrQmcfMode() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        if (QmcfManager.getInstance().getCurrQmcfMode() != 1) {
            this.mOutputTextureID = this.mInputTextureID;
            return;
        }
        try {
            this.mProcessor.doInit();
            if (this.shouldInitTexture) {
                this.frameCount = 0;
                initTexture();
                this.shouldInitTexture = false;
                this.mOutputTextureID = this.mInputTextureID;
                return;
            }
            this.mSoInFBO.bind();
            this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mInputTextureID, null, null);
            this.mSoInFBO.unbind();
            this.mSoInTexture = this.mSoInFBO.getTexId();
            int texId = this.mSoOutFBO.getTexId();
            this.mSoOutTexture = texId;
            this.mProcessor.doProcess(this.mSoInTexture, texId);
            this.mFilterOutFBO.bind();
            this.textureRender.drawTexture(GLSLRender.GL_TEXTURE_2D, this.mSoOutTexture, null, null);
            this.mFilterOutFBO.unbind();
            this.mOutputTextureID = this.mFilterOutFBO.getTexId();
            QQFilterLogManager.setFilterStatus(TAG, true);
            int i3 = this.frameCount + 1;
            this.frameCount = i3;
            if (i3 < 3) {
                this.mOutputTextureID = this.mInputTextureID;
            }
        } catch (Error e16) {
            QmcfManager.getInstance().setQmcfRunSupported(false, false, 1);
            this.mOutputTextureID = this.mInputTextureID;
            SLog.e(TAG, "process excep!", e16);
        } catch (Exception e17) {
            QmcfManager.getInstance().setQmcfRunSupported(false, false, 1);
            this.mOutputTextureID = this.mInputTextureID;
            SLog.e(TAG, "process excep!", e17);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceChange");
        }
        if (i3 > 0 && i16 > 0) {
            int i17 = this.initHeight;
            int i18 = (i3 * i17) / i16;
            int i19 = i18 - (i18 % 4);
            if (i19 != this.initWidth) {
                this.initWidth = i19;
                this.mProcessor.setInputSize(i19, i17);
                if (SLog.isEnable()) {
                    SLog.d(TAG, String.format("onSurfaceChange resize input width[%d], height[%d]", Integer.valueOf(this.initWidth), Integer.valueOf(this.initHeight)));
                }
                this.shouldInitTexture = true;
                this.mProcessor.doDestroy();
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceCreate");
        }
        this.shouldInitTexture = true;
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        QmcfManager.getInstance().destroy();
        this.mProcessor.doDestroy();
        if (SLog.isEnable()) {
            SLog.d(TAG, "onSurfaceDestroy");
        }
    }
}
