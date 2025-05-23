package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

/* loaded from: classes5.dex */
public class CropByPivotProcessor extends ImageProcessor {
    public static float GOLDEN_CUDGEL_RATIO = 1.78f;
    private static final float PIVOT_DEFAULT_VALUE = 0.0f;
    protected float mPivotXRate = 0.0f;
    protected float mPivotYRate = 0.0f;

    public CropByPivotProcessor() {
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        ScaleDrawable scaleDrawable = new ScaleDrawable(drawable, 10);
        scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
        return new SpecifiedDrawable(scaleDrawable, intrinsicWidth, intrinsicHeight);
    }

    public void setPivotRate(float f16, float f17) {
        if (this.mPivotXRate != f16 || this.mPivotYRate != f17) {
            this.mPivotXRate = f16;
            this.mPivotYRate = f17;
        }
    }

    public CropByPivotProcessor(float f16, float f17) {
        setPivotRate(f16, f17);
    }
}
