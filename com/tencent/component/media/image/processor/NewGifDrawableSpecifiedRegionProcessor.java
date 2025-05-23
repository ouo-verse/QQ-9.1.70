package com.tencent.component.media.image.processor;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.gif.NewGifDrawable;

/* loaded from: classes5.dex */
public class NewGifDrawableSpecifiedRegionProcessor extends SpecifiedSizeCropByPivotProcessor {
    public int height;
    private final Rect mDisplayRect;
    public int width;

    public NewGifDrawableSpecifiedRegionProcessor(int i3, int i16, Rect rect) {
        super(i3, i16);
        Rect rect2 = new Rect();
        this.mDisplayRect = rect2;
        this.width = i3;
        this.height = i16;
        if (rect != null) {
            rect2.set(rect);
        }
    }

    @Override // com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor, com.tencent.component.media.image.processor.CropByPivotProcessor, com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        if (!(drawable instanceof NewGifDrawable)) {
            return super.process(drawable);
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = drawable;
        drawable2 = drawable;
        if (intrinsicWidth != 0 && intrinsicHeight != 0) {
            NewGifDrawable newGifDrawable = (NewGifDrawable) drawable;
            drawable2 = newGifDrawable;
            if (intrinsicWidth > intrinsicHeight) {
                Rect rect = this.mDisplayRect;
                int i3 = rect.left;
                int i16 = rect.right + i3;
                drawable2 = newGifDrawable;
                if (i16 > 0) {
                    int i17 = ((intrinsicWidth - intrinsicHeight) * i3) / i16;
                    newGifDrawable.setSrcRect(new Rect(i17, 0, i17 + intrinsicHeight, intrinsicHeight));
                    newGifDrawable.setIntrinsicWidth(intrinsicHeight);
                    newGifDrawable.setIntrinsicHeight(intrinsicHeight);
                    drawable2 = newGifDrawable;
                }
            } else if (intrinsicWidth < intrinsicHeight) {
                Rect rect2 = this.mDisplayRect;
                int i18 = rect2.top;
                int i19 = rect2.bottom + i18;
                drawable2 = newGifDrawable;
                if (i19 > 0) {
                    int i26 = ((intrinsicHeight - intrinsicWidth) * i18) / i19;
                    newGifDrawable.setSrcRect(new Rect(0, i26, intrinsicWidth, i26 + intrinsicWidth));
                    newGifDrawable.setIntrinsicWidth(intrinsicWidth);
                    newGifDrawable.setIntrinsicHeight(intrinsicWidth);
                    drawable2 = newGifDrawable;
                }
            }
        }
        return drawable2;
    }
}
