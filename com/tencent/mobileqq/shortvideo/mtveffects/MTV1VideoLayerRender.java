package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MTV1VideoLayerRender extends LayerRenderBase {
    public static final int MATERIAL_ID_PALETTE_BLUE = 1;
    public static final int MATERIAL_ID_PALETTE_RED = 0;
    private ColoramaFilter mColoramaFilter;
    private RenderBuffer mRenderFBO;
    private float[] mShapePoints;
    private ShapeRender mShapeRender = new ShapeRender();
    private int mPaletteID = -1;

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceChanged(int i3, int i16) {
        super.onSurfaceChanged(i3, i16);
        if (i3 != 0 && i16 != 0) {
            this.mShapeRender.onSurfaceChanged(i3, i16);
            RenderBuffer renderBuffer = this.mRenderFBO;
            if (renderBuffer != null) {
                LayerRenderBase.releaseRenderBuffer(renderBuffer);
                this.mRenderFBO = null;
            }
            this.mRenderFBO = new RenderBuffer(i3, i16, 33984);
            ColoramaFilter coloramaFilter = this.mColoramaFilter;
            if (coloramaFilter != null) {
                coloramaFilter.onOutputSizeChanged(i3, i16);
                return;
            }
            ColoramaFilter coloramaFilter2 = new ColoramaFilter();
            this.mColoramaFilter = coloramaFilter2;
            coloramaFilter2.init();
            this.mColoramaFilter.onOutputSizeChanged(this.mWidth, this.mHeight);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        this.mShapeRender.onSurfaceDestroy();
        RenderBuffer renderBuffer = this.mRenderFBO;
        if (renderBuffer != null) {
            LayerRenderBase.releaseRenderBuffer(renderBuffer);
            this.mRenderFBO = null;
        }
        ColoramaFilter coloramaFilter = this.mColoramaFilter;
        if (coloramaFilter != null) {
            coloramaFilter.destroy();
            this.mColoramaFilter = null;
        }
        this.mShapePoints = null;
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public int process(RenderBuffer renderBuffer, int i3, float[] fArr, float[] fArr2) {
        boolean z16;
        RenderBuffer renderBuffer2;
        if (this.mPaletteID >= 0 && this.mColoramaFilter != null && (renderBuffer2 = this.mRenderFBO) != null) {
            LayerRenderBase.clearColorBuffer(renderBuffer2, 0);
            RectF materialArea = getMaterialArea(this.mPaletteID);
            if (materialArea != null) {
                this.mRenderFBO.bind();
                this.mColoramaFilter.process(i3, getMaterialTextureID(), materialArea, materialArea.left, materialArea.width(), 1.0f, fArr, fArr2);
                this.mRenderFBO.unbind();
                i3 = this.mRenderFBO.getTexId();
            }
        }
        float[] fArr3 = this.mShapePoints;
        if (fArr3 != null && fArr3.length > 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mShapeRender.setShapeData(1, fArr3);
            this.mShapeRender.begin();
            int shape = this.mShapeRender.shape(renderBuffer, i3);
            this.mShapeRender.end();
            this.mShapeRender.setShapeData(0, null);
            return shape;
        }
        return i3;
    }

    public void updateData(float[] fArr, int i3) {
        this.mShapePoints = fArr;
        this.mPaletteID = i3;
    }
}
