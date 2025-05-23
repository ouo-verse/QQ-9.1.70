package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VerticalCenterImageSpan extends ImageSpan {
    private int mLeftPadding;
    private int mRightPadding;

    public VerticalCenterImageSpan(Drawable drawable, int i3) {
        super(drawable, i3);
        this.mLeftPadding = 0;
        this.mRightPadding = 0;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        canvas.translate((f16 + this.mLeftPadding) - this.mRightPadding, (((i19 - i17) - drawable.getBounds().bottom) / 2) + i17);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i17 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 / 4;
            int i26 = i18 - i19;
            int i27 = -(i18 + i19);
            fontMetricsInt.ascent = i27;
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return bounds.right + this.mLeftPadding + this.mRightPadding;
    }

    public void setPadding(int i3, int i16) {
        this.mLeftPadding = i3;
        this.mRightPadding = i16;
    }

    public VerticalCenterImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
        this.mLeftPadding = 0;
        this.mRightPadding = 0;
    }
}
