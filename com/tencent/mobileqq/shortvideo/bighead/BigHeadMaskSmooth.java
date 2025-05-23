package com.tencent.mobileqq.shortvideo.bighead;

import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BigHeadMaskSmooth {
    private FeatherBlurFilter blurFeather;
    private GpuGaussianBlurFilter blurFilter;
    private RenderBuffer mRenderFBO;
    private int mOrgTextureId = 0;
    private final float[] weights = {0.110632844f, 0.11134947f, 0.110632844f, 0.11134947f, 0.11207074f, 0.11134947f, 0.110632844f, 0.11134947f, 0.110632844f};

    public BigHeadMaskSmooth() {
        GpuGaussianBlurFilter gpuGaussianBlurFilter = new GpuGaussianBlurFilter();
        this.blurFilter = gpuGaussianBlurFilter;
        gpuGaussianBlurFilter.setStepRatio(3.0f, 2.0f);
        this.mRenderFBO = new RenderBuffer(false, 0, 0);
        FeatherBlurFilter featherBlurFilter = new FeatherBlurFilter();
        this.blurFeather = featherBlurFilter;
        featherBlurFilter.setStepRatio(1.0f, 1.0f);
    }

    private void allocateTexture(int i3, int i16) {
        this.mRenderFBO.setUserTextureId(this.mOrgTextureId);
        if (this.mRenderFBO.getTexId() == 0) {
            int createTextureAllocate = GlUtil.createTextureAllocate(i3, i16, false);
            this.mOrgTextureId = createTextureAllocate;
            this.mRenderFBO.setUserTextureId(createTextureAllocate);
            this.mRenderFBO.setSize(i3, i16);
        }
    }

    public void destroy() {
        this.blurFilter.destroy();
        this.blurFeather.destroy();
        this.mRenderFBO.destroy();
        BigHeadInitFilter.releaseRenderFBOTexture(this.mRenderFBO);
    }

    public void drawTexture(int i3, int i16, int i17, float[] fArr, Rect rect) {
        allocateTexture(i16, i17);
        this.mRenderFBO.bind();
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glViewport(rect.left, rect.top, rect.width(), rect.height());
        this.blurFilter.init(i16, i17, this.weights);
        this.blurFilter.drawTexture(i3, fArr, null);
        this.mRenderFBO.unbind();
        this.mRenderFBO.setUserTextureId(i3);
        this.mRenderFBO.bind();
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glViewport(rect.left, rect.top, rect.width(), rect.height());
        this.blurFeather.init(i16, i17);
        if (this.blurFeather.getProgram() != 0) {
            this.blurFeather.drawTexture(this.mOrgTextureId, fArr, null);
        } else {
            GLES20.glGetError();
            this.mRenderFBO.setUserTextureId(this.mOrgTextureId);
        }
        this.mRenderFBO.unbind();
    }

    public int getOutputTexture() {
        return this.mRenderFBO.getTexId();
    }
}
