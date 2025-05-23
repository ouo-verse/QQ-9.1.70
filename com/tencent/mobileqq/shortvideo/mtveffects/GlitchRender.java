package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GlitchRender {
    private static final String TAG = "GlitchRender";
    private GlitchFilter mGlitchFiler;
    private MaterialFilter mMaterialFilter;
    private RenderBuffer mRenderFBO;
    private RenderBuffer mRenderFBO2;
    private ScaleFilter mScaleFilter;
    private int mDisColorH = -1;
    private float mMaxDisH = 0.5f;
    private int mDisColorV = -1;
    private float mMaxDisV = 0.5f;
    private RectF mRcSrc = null;

    public boolean init(RectF rectF, int i3, float f16, int i16, float f17) {
        this.mDisColorH = i3;
        this.mDisColorV = i16;
        this.mMaxDisH = f16;
        this.mMaxDisV = f17;
        this.mRcSrc = rectF;
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(35660, iArr, 0);
        if (iArr[0] > 0) {
            return true;
        }
        return false;
    }

    public void onSurfaceChanged(int i3, int i16) {
        if (i3 != 0 && i16 != 0) {
            GlitchFilter glitchFilter = this.mGlitchFiler;
            if (glitchFilter != null) {
                glitchFilter.onOutputSizeChanged(i3, i16);
            } else if (this.mRcSrc != null) {
                GlitchFilter glitchFilter2 = new GlitchFilter(this.mRcSrc);
                this.mGlitchFiler = glitchFilter2;
                glitchFilter2.init();
                this.mGlitchFiler.onOutputSizeChanged(i3, i16);
            } else {
                this.mGlitchFiler = null;
            }
            ScaleFilter scaleFilter = this.mScaleFilter;
            if (scaleFilter != null) {
                scaleFilter.onOutputSizeChanged(i3, i16);
            } else {
                ScaleFilter scaleFilter2 = new ScaleFilter();
                this.mScaleFilter = scaleFilter2;
                scaleFilter2.init();
                this.mScaleFilter.onOutputSizeChanged(i3, i16);
            }
            MaterialFilter materialFilter = this.mMaterialFilter;
            if (materialFilter != null) {
                materialFilter.onOutputSizeChanged(i3, i16);
            } else {
                MaterialFilter materialFilter2 = new MaterialFilter();
                this.mMaterialFilter = materialFilter2;
                materialFilter2.init();
                this.mMaterialFilter.onOutputSizeChanged(i3, i16);
            }
            RenderBuffer renderBuffer = this.mRenderFBO;
            if (renderBuffer == null || renderBuffer.getWidth() != i3 || this.mRenderFBO.getHeight() != i16) {
                RenderBuffer renderBuffer2 = this.mRenderFBO;
                if (renderBuffer2 != null) {
                    if (renderBuffer2.getTexId() >= 0) {
                        GlUtil.deleteTexture(this.mRenderFBO.getTexId());
                    }
                    this.mRenderFBO.destroy();
                    this.mRenderFBO = null;
                }
                this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
            }
            RenderBuffer renderBuffer3 = this.mRenderFBO2;
            if (renderBuffer3 == null || renderBuffer3.getWidth() != i3 || this.mRenderFBO2.getHeight() != i16) {
                RenderBuffer renderBuffer4 = this.mRenderFBO2;
                if (renderBuffer4 != null) {
                    if (renderBuffer4.getTexId() >= 0) {
                        GlUtil.deleteTexture(this.mRenderFBO2.getTexId());
                    }
                    this.mRenderFBO2.destroy();
                    this.mRenderFBO2 = null;
                }
                this.mRenderFBO2 = new RenderBuffer(i3, i16, 33984);
            }
        }
    }

    public void onSurfaceDestroy() {
        GlitchFilter glitchFilter = this.mGlitchFiler;
        if (glitchFilter != null) {
            glitchFilter.destroy();
            this.mGlitchFiler = null;
        }
        ScaleFilter scaleFilter = this.mScaleFilter;
        if (scaleFilter != null) {
            scaleFilter.destroy();
            this.mScaleFilter = null;
        }
        MaterialFilter materialFilter = this.mMaterialFilter;
        if (materialFilter != null) {
            materialFilter.destroy();
            this.mMaterialFilter = null;
        }
        LayerRenderBase.releaseRenderBuffer(this.mRenderFBO);
        LayerRenderBase.releaseRenderBuffer(this.mRenderFBO2);
    }

    public int process(RenderBuffer renderBuffer, int i3, int i16, RectF rectF, boolean z16, int i17, float[] fArr, float[] fArr2) {
        int i18;
        boolean z17;
        float f16;
        float f17;
        boolean z18;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        if (i16 >= 0 && renderBuffer != null && this.mRcSrc != null && rectF != null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z19 = true;
            if (i3 >= 0 && this.mGlitchFiler != null) {
                LayerRenderBase.clearColorBuffer(this.mRenderFBO, 0);
                this.mRenderFBO.bind();
                GlitchFilter glitchFilter = this.mGlitchFiler;
                int i19 = this.mDisColorH;
                float f18 = this.mMaxDisH;
                float f19 = rectF.left;
                RectF rectF5 = this.mRcSrc;
                glitchFilter.updateData(i19, f18, f19 - rectF5.left, this.mDisColorV, this.mMaxDisV, rectF.top - rectF5.top);
                this.mGlitchFiler.process(i3, i16, z16, i17, true);
                this.mRenderFBO.unbind();
                i18 = this.mRenderFBO.getTexId();
                z17 = true;
            } else {
                i18 = i16;
                z17 = false;
            }
            Log.d(TAG, "glitch time:" + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if ((rectF.width() != this.mRcSrc.width() || rectF.height() != this.mRcSrc.height()) && this.mScaleFilter != null) {
                LayerRenderBase.clearColorBuffer(this.mRenderFBO2, 0);
                this.mRenderFBO2.bind();
                if (z17) {
                    f16 = rectF.left;
                } else {
                    f16 = this.mRcSrc.left;
                }
                float f26 = f16;
                if (z17) {
                    f17 = rectF.top;
                } else {
                    f17 = this.mRcSrc.top;
                }
                this.mScaleFilter.process(i18, f26, f17, rectF.width() / this.mRcSrc.width(), fArr, fArr2);
                this.mRenderFBO2.unbind();
                i18 = this.mRenderFBO2.getTexId();
                z18 = true;
            } else {
                z18 = false;
            }
            int i26 = i18;
            Log.d(TAG, "sclae time:" + (System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis3 = System.currentTimeMillis();
            if (this.mMaterialFilter != null) {
                if (z17) {
                    rectF3 = new RectF(0.0f, 1.0f, 1.0f, 0.0f);
                } else {
                    if (z18) {
                        RectF rectF6 = this.mRcSrc;
                        float f27 = rectF6.left;
                        rectF2 = new RectF(f27, rectF6.top, rectF.width() + f27, this.mRcSrc.top + rectF.height());
                    } else {
                        rectF2 = this.mRcSrc;
                    }
                    rectF3 = rectF2;
                    z19 = false;
                }
                renderBuffer.bind();
                MaterialFilter materialFilter = this.mMaterialFilter;
                if (z19) {
                    rectF4 = rectF3;
                } else {
                    rectF4 = rectF;
                }
                materialFilter.process(i26, rectF3, rectF4, z16, i17, fArr, fArr2);
                renderBuffer.unbind();
                Log.d(TAG, "final time:" + (System.currentTimeMillis() - currentTimeMillis3));
                return renderBuffer.getTexId();
            }
        }
        return -1;
    }
}
