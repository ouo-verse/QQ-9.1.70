package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQImage2FrameFilter extends QQBaseFilter {
    private GPUBaseFilter mBaseFilter;
    private GaussianBlurFilterCompose mGaussianBlurFilter;
    private int mImageHeight;
    private int mImageWidth;
    private float[] mMvpMatirx;
    private RenderBuffer mRenderFBO;
    private RenderBuffer mRollFBO;
    private boolean mRollY;
    private int mSurfaceHeight;
    private int mSurfaceWidth;

    public QQImage2FrameFilter(QQFilterRenderManager qQFilterRenderManager) {
        super(170, qQFilterRenderManager);
        this.mRollY = true;
    }

    private void initTexture(int i3, int i16) {
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
        GPUBaseFilter gPUBaseFilter = new GPUBaseFilter();
        this.mBaseFilter = gPUBaseFilter;
        gPUBaseFilter.init();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = new GaussianBlurFilterCompose();
        this.mGaussianBlurFilter = gaussianBlurFilterCompose;
        gaussianBlurFilterCompose.init(i3, i16);
        this.mMvpMatirx = new float[16];
        if (this.mRollY) {
            this.mRollFBO = new RenderBuffer(i3, i16, 33984);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onDrawFrame() {
        super.onDrawFrame();
        this.mRenderFBO.bind();
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        GLES20.glClear(16384);
        this.mRenderFBO.unbind();
        float f16 = (this.mSurfaceWidth * 1.0f) / this.mSurfaceHeight;
        float f17 = (this.mImageWidth * 1.0f) / this.mImageHeight;
        Matrix.setIdentityM(this.mMvpMatirx, 0);
        if (f17 > f16) {
            Matrix.scaleM(this.mMvpMatirx, 0, 1.0f, (((this.mSurfaceWidth * 1.0f) / this.mImageWidth) * this.mImageHeight) / this.mSurfaceHeight, 1.0f);
        } else {
            Matrix.scaleM(this.mMvpMatirx, 0, (((this.mSurfaceHeight * 1.0f) / this.mImageHeight) * this.mImageWidth) / this.mSurfaceWidth, 1.0f, 1.0f);
        }
        GaussianBlurFilterCompose gaussianBlurFilterCompose = this.mGaussianBlurFilter;
        if (gaussianBlurFilterCompose != null) {
            gaussianBlurFilterCompose.drawTexture(this.mInputTextureID);
            this.mOutputTextureID = this.mGaussianBlurFilter.getTextureId();
        }
        this.mRenderFBO.bind();
        this.mBaseFilter.drawTexture(this.mOutputTextureID, null, null);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(32771, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        GLES20.glBlendColor(0.0f, 0.0f, 0.0f, 0.75f);
        this.mBaseFilter.drawTexture(this.mInputTextureID, null, this.mMvpMatirx);
        GLES20.glDisable(3042);
        this.mRenderFBO.unbind();
        if (this.mRollY) {
            this.mRollFBO.bind();
            this.mBaseFilter.drawTexture(this.mRenderFBO.getTexId(), new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f}, null);
            this.mRollFBO.unbind();
            this.mOutputTextureID = this.mRollFBO.getTexId();
            return;
        }
        this.mOutputTextureID = this.mRenderFBO.getTexId();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceChange(int i3, int i16) {
        super.onSurfaceChange(i3, i16);
        initTexture(i3, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceCreate() {
        super.onSurfaceCreate();
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        GaussianBlurFilterCompose gaussianBlurFilterCompose = this.mGaussianBlurFilter;
        if (gaussianBlurFilterCompose != null) {
            gaussianBlurFilterCompose.destroy();
            this.mGaussianBlurFilter = null;
        }
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            GlUtil.deleteTexture(renderBuffer.getTexId());
            this.mRenderFBO.destroy();
            this.mRenderFBO = null;
        }
        this.mMvpMatirx = null;
        GPUBaseFilter gPUBaseFilter = this.mBaseFilter;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
            this.mBaseFilter = null;
        }
        RenderBuffer renderBuffer2 = this.mRollFBO;
        if (renderBuffer2 != null) {
            GlUtil.deleteTexture(renderBuffer2.getTexId());
            this.mRollFBO.destroy();
            this.mRollFBO = null;
        }
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
    }

    public void setImageSize(int i3, int i16) {
        this.mImageWidth = i3;
        this.mImageHeight = i16;
    }
}
