package com.tencent.mtt.hippy.dom.node;

import android.annotation.TargetApi;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes20.dex */
public class d extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    final float f337408a;

    public d(float f16) {
        this.f337408a = f16;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (!Float.isNaN(this.f337408a)) {
            textPaint.setLetterSpacing(this.f337408a / textPaint.getTextSize());
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        if (!Float.isNaN(this.f337408a)) {
            textPaint.setLetterSpacing(this.f337408a / textPaint.getTextSize());
        }
    }
}
