package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GaussianBlurFilterCompose {
    private static final int GAUSSIAN_WEIGHT_SAMPLES = 11;
    private GaussianBlurFilter filter;
    private RenderBuffer mRenderScale;
    private int mScaleHeight;
    private int mScaleTextureFirst;
    private int mScaleWidth;
    private float radius = 9.8f;
    private TextureRender renderDraw;

    private float[] getWeight(float f16) {
        int i3;
        if (f16 >= 1.0f) {
            double d16 = f16;
            int floor = (int) Math.floor(Math.sqrt(Math.pow(d16, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d))));
            i3 = floor + (floor % 2);
        } else {
            i3 = 0;
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d17 = f16;
            float exp = (float) (Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d17, 2.0d) * 2.0d)) * (1.0d / Math.sqrt(Math.pow(d17, 2.0d) * 6.283185307179586d)));
            fArr[i17] = exp;
            if (i17 == 0) {
                f17 += exp;
            } else {
                f17 = (float) (f17 + (exp * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int i19 = (i3 / 2) + (i3 % 2);
        int min = Math.min(i19, 7);
        float[] fArr2 = new float[min];
        for (int i26 = 0; i26 < min; i26++) {
            int i27 = i26 * 2;
            int i28 = i27 + 1;
            float f18 = fArr[i28];
            int i29 = i27 + 2;
            float f19 = fArr[i29];
            fArr2[i26] = ((f18 * i28) + (f19 * i29)) / (f18 + f19);
        }
        float[] fArr3 = new float[11];
        for (int i36 = 0; i36 < 11; i36++) {
            fArr3[i36] = 0.0f;
        }
        for (int i37 = 0; i37 < min; i37++) {
            int i38 = i37 * 2;
            fArr3[i37] = fArr[i38 + 1] + fArr[i38 + 2];
        }
        if (i19 > min) {
            while (min < i19) {
                int i39 = min * 2;
                fArr3[min] = fArr[i39 + 1] + fArr[i39 + 2];
                min++;
            }
        }
        float f26 = -fArr3[0];
        for (int i46 = 0; i46 < 11; i46++) {
            f26 += fArr3[i46] * 2.0f;
        }
        for (int i47 = 0; i47 < 11; i47++) {
            fArr3[i47] = fArr3[i47] / f26;
        }
        return fArr3;
    }

    public void destroy() {
        GaussianBlurFilter gaussianBlurFilter = this.filter;
        if (gaussianBlurFilter != null) {
            gaussianBlurFilter.destroy();
            this.filter = null;
        }
        RenderBuffer renderBuffer = this.mRenderScale;
        if (renderBuffer != null) {
            GlUtil.deleteTexture(renderBuffer.getTexId());
            this.mRenderScale.destroy();
            this.mRenderScale = null;
        }
        TextureRender textureRender = this.renderDraw;
        if (textureRender != null) {
            textureRender.release();
            this.renderDraw = null;
        }
        int i3 = this.mScaleTextureFirst;
        if (i3 > 0) {
            GlUtil.deleteTexture(i3);
        }
    }

    public void drawTexture(int i3) {
        GaussianBlurFilter gaussianBlurFilter = this.filter;
        if (gaussianBlurFilter == null || !gaussianBlurFilter.isInitSucc()) {
            return;
        }
        this.mRenderScale.bind();
        this.renderDraw.drawTexture(GLSLRender.GL_TEXTURE_2D, i3, null, null);
        this.mRenderScale.unbind();
        int texId = this.mRenderScale.getTexId();
        this.mRenderScale.setUserTextureId(this.mScaleTextureFirst);
        this.mRenderScale.bind();
        this.filter.setStepRatio(null, 1.0f, 0.0f);
        this.filter.drawTexture(texId);
        this.mRenderScale.unbind();
        this.mRenderScale.setUserTextureId(texId);
        this.mRenderScale.bind();
        this.filter.setStepRatio(null, 0.0f, 1.0f);
        this.filter.drawTexture(this.mScaleTextureFirst);
        this.mRenderScale.unbind();
    }

    public GaussianBlurFilter getFilter() {
        return this.filter;
    }

    public int getOutputHeight() {
        return this.mScaleHeight;
    }

    public int getOutputWidth() {
        return this.mScaleWidth;
    }

    public int getTextureId() {
        return this.mRenderScale.getTexId();
    }

    public void init(int i3, int i16) {
        int i17 = (int) (i3 * 0.25f);
        this.mScaleWidth = i17;
        int i18 = (int) (i16 * 0.25f);
        this.mScaleHeight = i18;
        this.mRenderScale = new RenderBuffer(i17, i18, 33986);
        this.mScaleTextureFirst = GlUtil.createTextureAllocate(this.mScaleWidth, this.mScaleHeight, false);
        this.renderDraw = new TextureRender();
        GaussianBlurFilter gaussianBlurFilter = new GaussianBlurFilter();
        this.filter = gaussianBlurFilter;
        gaussianBlurFilter.init(this.mScaleWidth, this.mScaleHeight);
        this.filter.setStepRatio(getWeight(this.radius), 0.0f, 0.0f);
    }

    public void setRadius(float f16) {
        this.radius = f16;
    }
}
