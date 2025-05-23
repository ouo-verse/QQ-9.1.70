package com.etrump.mixlayout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends AnimatedImageSpan {
    public d(Drawable drawable) {
        super(drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            drawable = ((AnimatedImageDrawable) drawable).getDrawable();
        }
        if (drawable == null) {
            return;
        }
        canvas.save();
        canvas.translate(f16, i19 - getDrawable().getBounds().height());
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // com.etrump.mixlayout.AnimatedImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return super.getDrawable();
    }
}
