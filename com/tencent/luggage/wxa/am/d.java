package com.tencent.luggage.wxa.am;

import android.graphics.Paint;
import android.text.Spannable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends Spannable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final int f121571a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.cm.a {
        public a(float f16) {
            super(f16, 17);
        }

        @Override // com.tencent.luggage.wxa.cm.a, android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
            if (fontMetricsInt == null || fontMetricsInt.bottom - fontMetricsInt.top > a()) {
                return;
            }
            super.chooseHeight(charSequence, i3, i16, i17, i18, fontMetricsInt);
        }
    }

    public d(int i3) {
        this.f121571a = i3;
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        Spannable newSpannable = super.newSpannable(charSequence);
        if (newSpannable != null) {
            newSpannable.setSpan(new a(this.f121571a), 0, newSpannable.length(), 18);
            return newSpannable;
        }
        return null;
    }
}
