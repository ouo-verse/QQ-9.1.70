package com.tencent.mobileqq.guild.feed.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Drawable> f223902d;

    public d(@NonNull Drawable drawable) {
        super(drawable);
    }

    private Drawable a() {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.f223902d;
        if (weakReference != null) {
            drawable = weakReference.get();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f223902d = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable a16 = a();
        canvas.save();
        int i26 = i19 - a16.getBounds().bottom;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i27 = ((ImageSpan) this).mVerticalAlignment;
        if (i27 == 1) {
            i26 -= fontMetricsInt.descent;
        } else if (i27 == 2) {
            i26 = (((fontMetricsInt.descent + i18) + (i18 + fontMetricsInt.ascent)) / 2) - (a16.getBounds().bottom / 2);
        }
        canvas.translate(f16, i26);
        a16.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
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
        return bounds.right;
    }

    public d(@NonNull Drawable drawable, int i3) {
        super(drawable, i3);
    }
}
