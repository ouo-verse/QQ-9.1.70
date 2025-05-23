package com.tencent.mobileqq.activity.aio.intimate;

import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TopAlignSuperscriptSpan extends SuperscriptSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f178909d;

    /* renamed from: e, reason: collision with root package name */
    private float f178910e;

    public TopAlignSuperscriptSpan() {
        this.f178909d = 2;
        this.f178910e = 0.0f;
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            float ascent = textPaint.ascent();
            textPaint.setTextSize(textPaint.getTextSize() / this.f178909d);
            float f16 = textPaint.getFontMetrics().ascent;
            float f17 = textPaint.baselineShift;
            float f18 = this.f178910e;
            textPaint.baselineShift = (int) (f17 + ((ascent - (ascent * f18)) - (f16 - (f18 * f16))));
        }
    }

    @Override // android.text.style.SuperscriptSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        updateDrawState(textPaint);
    }

    public TopAlignSuperscriptSpan(float f16) {
        this.f178909d = 2;
        this.f178910e = 0.0f;
        double d16 = f16;
        if (d16 <= 0.0d || d16 >= 1.0d) {
            return;
        }
        this.f178910e = f16;
    }
}
