package com.tencent.mobileqq.shortvideo.mtveffects;

import androidx.core.internal.view.SupportMenu;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShapeRender {
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_POLYGON = 1;
    private RenderBuffer mMaskFBO;
    private MaskFilter mMaskFilter;
    private ShapeFilter mShapeFilter;
    private float[] mShapePoints;
    private int mType = 1;
    private int mColor = SupportMenu.CATEGORY_MASK;

    private void drawShape() {
        RenderBuffer renderBuffer;
        if (this.mType == 1 && (renderBuffer = this.mMaskFBO) != null) {
            LayerRenderBase.clearColorBuffer(renderBuffer, 0);
            this.mMaskFBO.bind();
            this.mMaskFilter.drawShape(this.mShapePoints, this.mColor, null);
            this.mMaskFBO.unbind();
        }
    }

    public void begin() {
        if (this.mType == 0) {
            return;
        }
        drawShape();
    }

    public void onSurfaceChanged(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            MaskFilter maskFilter = this.mMaskFilter;
            if (maskFilter != null) {
                maskFilter.onOutputSizeChanged(i3, i16);
            } else {
                MaskFilter maskFilter2 = new MaskFilter();
                this.mMaskFilter = maskFilter2;
                maskFilter2.init();
                this.mMaskFilter.onOutputSizeChanged(i3, i16);
            }
            ShapeFilter shapeFilter = this.mShapeFilter;
            if (shapeFilter != null) {
                shapeFilter.onOutputSizeChanged(i3, i16);
            } else {
                ShapeFilter shapeFilter2 = new ShapeFilter();
                this.mShapeFilter = shapeFilter2;
                shapeFilter2.init();
                this.mShapeFilter.onOutputSizeChanged(i3, i16);
            }
            RenderBuffer renderBuffer = this.mMaskFBO;
            if (renderBuffer != null) {
                LayerRenderBase.releaseRenderBuffer(renderBuffer);
                this.mMaskFBO = null;
            }
            this.mMaskFBO = new RenderBuffer(i3, i16, 33984);
        }
    }

    public void onSurfaceDestroy() {
        MaskFilter maskFilter = this.mMaskFilter;
        if (maskFilter != null) {
            maskFilter.destroy();
            this.mMaskFilter = null;
        }
        ShapeFilter shapeFilter = this.mShapeFilter;
        if (shapeFilter != null) {
            shapeFilter.destroy();
            this.mShapeFilter = null;
        }
        RenderBuffer renderBuffer = this.mMaskFBO;
        if (renderBuffer != null) {
            LayerRenderBase.releaseRenderBuffer(renderBuffer);
            this.mMaskFBO = null;
        }
    }

    public void setShapeData(int i3, float[] fArr) {
        this.mType = i3;
        this.mShapePoints = fArr;
    }

    public int shape(RenderBuffer renderBuffer, int i3) {
        ShapeFilter shapeFilter = this.mShapeFilter;
        if (shapeFilter != null && this.mMaskFBO != null && shapeFilter != null) {
            renderBuffer.bind();
            this.mShapeFilter.process(i3, this.mMaskFBO.getTexId(), null, null);
            renderBuffer.unbind();
            return renderBuffer.getTexId();
        }
        return i3;
    }

    public void end() {
    }
}
