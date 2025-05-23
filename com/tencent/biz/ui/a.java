package com.tencent.biz.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Drawable> f97015d;

    public a(Drawable drawable) {
        super(drawable);
    }

    private Drawable a() {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.f97015d;
        if (weakReference != null) {
            drawable = weakReference.get();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.f97015d = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        Drawable a16 = a();
        canvas.save();
        int intrinsicHeight = a16.getIntrinsicHeight();
        canvas.translate(f16, ((i19 - a16.getBounds().bottom) + (((intrinsicHeight - paint.getFontMetricsInt().descent) + paint.getFontMetricsInt().ascent) / 2)) / 5);
        a16.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return bounds.right;
    }
}
