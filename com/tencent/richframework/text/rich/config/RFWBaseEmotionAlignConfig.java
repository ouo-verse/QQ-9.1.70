package com.tencent.richframework.text.rich.config;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class RFWBaseEmotionAlignConfig implements IRFWAlignConfig {
    private int desiredDrawableHeight;
    private int desiredDrawableWidth;
    private float heightRate;
    private int marginLeft;
    private int marginRight;
    private final int[] size = new int[2];

    private static int adjustTransY(int i3, int i16, int i17, int i18) {
        if (i18 + i3 > i17) {
            i3 = i17 - i18;
        }
        if (i3 >= i16) {
            return i3;
        }
        return i16;
    }

    private void calDrawableSize(Rect rect, Paint paint) {
        int i3;
        int i16;
        if (this.heightRate > 0.0f) {
            i3 = (int) (((int) paint.getTextSize()) * this.heightRate);
            i16 = (rect.right * i3) / rect.bottom;
        } else {
            i3 = this.desiredDrawableHeight;
            i16 = this.desiredDrawableWidth;
        }
        if (i16 <= 0 || i3 <= 0) {
            i16 = rect.right;
            i3 = rect.bottom;
        }
        int[] iArr = this.size;
        iArr[0] = i16;
        iArr[1] = i3;
    }

    @Override // com.tencent.richframework.text.rich.config.IRFWAlignConfig
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Drawable drawable) {
        Rect rect;
        if (drawable != null) {
            rect = drawable.getBounds();
        } else {
            rect = new Rect();
        }
        Rect rect2 = rect;
        int[] iArr = this.size;
        int i26 = iArr[0];
        int i27 = iArr[1];
        int adjustTransY = adjustTransY(getTransY(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, paint.getFontMetricsInt(), i26, i27), i17, i19, i27);
        canvas.save();
        canvas.translate(f16 + this.marginLeft, adjustTransY);
        canvas.scale(i26 / rect2.right, i27 / rect2.bottom);
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
    }

    abstract int getCustomSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18);

    @Override // com.tencent.richframework.text.rich.config.IRFWAlignConfig
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, Drawable drawable) {
        int i17;
        if (drawable != null) {
            calDrawableSize(drawable.getBounds(), paint);
        }
        int[] iArr = this.size;
        int i18 = 0;
        int i19 = iArr[0];
        int i26 = iArr[1];
        if (fontMetricsInt != null) {
            i18 = fontMetricsInt.top - fontMetricsInt.ascent;
            i17 = fontMetricsInt.bottom - fontMetricsInt.descent;
        } else {
            i17 = 0;
        }
        int customSize = getCustomSize(paint, charSequence, i3, i16, fontMetricsInt, i19, i26);
        if (fontMetricsInt != null) {
            fontMetricsInt.top = fontMetricsInt.ascent + i18;
            fontMetricsInt.bottom = fontMetricsInt.descent + i17;
        }
        return this.marginLeft + customSize + this.marginRight;
    }

    abstract int getTransY(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27);

    @Override // com.tencent.richframework.text.rich.config.IRFWAlignConfig
    public void setDesiredSize(int i3, int i16) {
        this.desiredDrawableWidth = i3;
        this.desiredDrawableHeight = i16;
        this.heightRate = 0.0f;
    }
}
