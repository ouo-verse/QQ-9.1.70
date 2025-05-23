package com.etrump.mixlayout;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.style.DynamicDrawableSpan;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AnimatedImageSpan extends DynamicDrawableSpan {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f32600d;

    public AnimatedImageSpan(Drawable drawable) {
        this.f32600d = drawable;
        final Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.etrump.mixlayout.AnimatedImageSpan.1
            @Override // java.lang.Runnable
            public void run() {
                if (AnimatedImageSpan.this.f32600d != null && (AnimatedImageSpan.this.f32600d instanceof AnimatedImageDrawable)) {
                    ((AnimatedImageDrawable) AnimatedImageSpan.this.f32600d).f();
                    handler.postDelayed(this, r0.e());
                }
            }
        });
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return this.f32600d;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            int i17 = -bounds.bottom;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
