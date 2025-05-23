package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MTV1BottomLayerRender extends LayerRenderBase {
    private static final float DISTORTION_CENTER_X = 0.5f;
    private static final float DISTORTION_CENTER_Y = 0.5f;
    private static final float DISTORTION_RATE_1 = 1.5f;
    private static final float DISTORTION_RATE_2 = 0.5f;
    private static final float DISTORTION_SCALE = 1.0f;
    public static final int MATERIAL_ID_TEXT = 0;
    private int mBGColor = 0;
    private DistortionFilter mDistortFilter;
    private MaterialFilter mMaterialFilter;
    private RenderBuffer mRenderBuffer;
    private MTVBaseFilter.TextParam mTextParam;

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceChanged(int i3, int i16) {
        super.onSurfaceChanged(i3, i16);
        if (i3 != 0 && i16 != 0) {
            MaterialFilter materialFilter = this.mMaterialFilter;
            if (materialFilter != null) {
                materialFilter.onOutputSizeChanged(i3, i16);
            } else {
                MaterialFilter materialFilter2 = new MaterialFilter();
                this.mMaterialFilter = materialFilter2;
                materialFilter2.init();
                this.mMaterialFilter.onOutputSizeChanged(i3, i16);
            }
            DistortionFilter distortionFilter = this.mDistortFilter;
            if (distortionFilter != null) {
                distortionFilter.onOutputSizeChanged(i3, i16);
            } else {
                DistortionFilter distortionFilter2 = new DistortionFilter();
                this.mDistortFilter = distortionFilter2;
                distortionFilter2.init();
                this.mDistortFilter.onOutputSizeChanged(i3, i16);
            }
            RenderBuffer renderBuffer = this.mRenderBuffer;
            if (renderBuffer != null) {
                LayerRenderBase.releaseRenderBuffer(renderBuffer);
                this.mRenderBuffer = null;
            }
            if (this.mRenderBuffer == null) {
                this.mRenderBuffer = new RenderBuffer(getWidth(), getHeight(), 33984);
            }
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        DistortionFilter distortionFilter = this.mDistortFilter;
        if (distortionFilter != null) {
            distortionFilter.destroy();
            this.mDistortFilter = null;
        }
        MaterialFilter materialFilter = this.mMaterialFilter;
        if (materialFilter != null) {
            materialFilter.destroy();
            this.mMaterialFilter = null;
        }
        RenderBuffer renderBuffer = this.mRenderBuffer;
        if (renderBuffer != null) {
            LayerRenderBase.releaseRenderBuffer(renderBuffer);
            this.mRenderBuffer = null;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public int process(RenderBuffer renderBuffer, int i3, float[] fArr, float[] fArr2) {
        MTVBaseFilter.TextParam textParam;
        LayerRenderBase.clearColorBuffer(renderBuffer, this.mBGColor);
        if (this.mMaterialFilter != null && (textParam = this.mTextParam) != null && textParam.mShow) {
            if (!textParam.mDistortion) {
                renderBuffer.bind();
                MaterialFilter materialFilter = this.mMaterialFilter;
                int materialTextureID = getMaterialTextureID();
                RectF materialArea = getMaterialArea(0);
                MTVBaseFilter.TextParam textParam2 = this.mTextParam;
                materialFilter.process(materialTextureID, materialArea, textParam2.mRect, textParam2.mChangeColor, textParam2.mColor, fArr, fArr2);
                renderBuffer.unbind();
            } else {
                RenderBuffer renderBuffer2 = this.mRenderBuffer;
                if (renderBuffer2 != null) {
                    LayerRenderBase.clearColorBuffer(renderBuffer2, 0);
                    RectF rectF = new RectF(0.0f, 1.0f, 1.0f, 0.0f);
                    this.mRenderBuffer.bind();
                    MaterialFilter materialFilter2 = this.mMaterialFilter;
                    int materialTextureID2 = getMaterialTextureID();
                    RectF materialArea2 = getMaterialArea(0);
                    MTVBaseFilter.TextParam textParam3 = this.mTextParam;
                    materialFilter2.process(materialTextureID2, materialArea2, rectF, textParam3.mChangeColor, textParam3.mColor, fArr, fArr2);
                    this.mRenderBuffer.unbind();
                    renderBuffer.bind();
                    float width = getWidth();
                    RectF rectF2 = this.mTextParam.mRect;
                    GLES20.glViewport((int) (width * rectF2.left), (int) (rectF2.bottom * getHeight()), (int) (getWidth() * this.mTextParam.mRect.width()), (int) (getHeight() * this.mTextParam.mRect.height() * (-1.0f)));
                    this.mDistortFilter.process(this.mRenderBuffer.getTexId(), 1.5f, 0.5f, 1.0f, 0.5f, 0.5f, fArr, fArr2);
                    GLES20.glViewport(0, 0, getWidth(), getHeight());
                    renderBuffer.unbind();
                }
            }
        }
        return renderBuffer.getTexId();
    }

    public void updateData(int i3, MTVBaseFilter.TextParam textParam) {
        this.mBGColor = i3;
        this.mTextParam = textParam;
    }
}
