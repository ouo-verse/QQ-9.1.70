package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name */
    private final float f66919d;

    /* renamed from: e, reason: collision with root package name */
    private final float f66920e;

    public a(float f16, float f17) {
        this.f66919d = f16;
        this.f66920e = f17;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        if (charSequence != null) {
            paint.setTextSize(this.f66919d);
            canvas.drawText(charSequence, i3, i16, f16, i18, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        if (charSequence == null) {
            return 0;
        }
        paint.setTextSize(this.f66919d);
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            float f16 = fontMetricsInt2.top;
            float f17 = this.f66920e;
            fontMetricsInt.top = (int) (f16 * f17);
            fontMetricsInt.ascent = (int) (fontMetricsInt2.ascent * f17);
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
            fontMetricsInt.leading = fontMetricsInt2.leading;
        }
        return Math.round(paint.measureText(charSequence, i3, i16));
    }
}
