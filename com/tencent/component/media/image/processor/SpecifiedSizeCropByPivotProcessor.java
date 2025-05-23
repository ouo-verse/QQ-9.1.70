package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

/* loaded from: classes5.dex */
public class SpecifiedSizeCropByPivotProcessor extends CropByPivotProcessor {
    private boolean hasPivot;
    private final int mHeight;
    private final int mWidth;

    public SpecifiedSizeCropByPivotProcessor(int i3, int i16) {
        this.hasPivot = false;
        this.mWidth = i3;
        this.mHeight = i16;
    }

    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return super.getType();
    }

    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        ScaleDrawable scaleDrawable;
        if (this.mWidth > 0 && this.mHeight > 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth == this.mWidth && intrinsicHeight == this.mHeight) {
                return drawable;
            }
            if (intrinsicWidth < intrinsicHeight * 2 && !this.hasPivot) {
                scaleDrawable = new ScaleDrawable(drawable, 0);
            } else {
                scaleDrawable = new ScaleDrawable(drawable, 10);
            }
            scaleDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
            return new SpecifiedDrawable(scaleDrawable, this.mWidth, this.mHeight);
        }
        return drawable;
    }

    public SpecifiedSizeCropByPivotProcessor(int i3, int i16, float f16, float f17) {
        this(i3, i16);
        setPivotRate(f16, f17);
        if (f16 == 0.0f && f17 == 0.0f) {
            return;
        }
        this.hasPivot = true;
    }
}
