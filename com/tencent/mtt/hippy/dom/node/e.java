package com.tencent.mtt.hippy.dom.node;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f337409a;

    public e(float f16) {
        this.f337409a = (int) Math.ceil(f16);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
        int i19 = fontMetricsInt.descent;
        int i26 = this.f337409a;
        if (i19 > i26) {
            int min = Math.min(i26, i19);
            fontMetricsInt.descent = min;
            fontMetricsInt.bottom = min;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
            return;
        }
        int i27 = fontMetricsInt.ascent;
        if ((-i27) + i19 > i26) {
            fontMetricsInt.bottom = i19;
            int i28 = (-i26) + i19;
            fontMetricsInt.ascent = i28;
            fontMetricsInt.top = i28;
            return;
        }
        int i29 = fontMetricsInt.bottom;
        if ((-i27) + i29 > i26) {
            fontMetricsInt.top = i27;
            fontMetricsInt.bottom = i27 + i26;
            return;
        }
        int i36 = fontMetricsInt.top;
        if ((-i36) + i29 > i26) {
            fontMetricsInt.top = i29 - i26;
            return;
        }
        double d16 = (i26 - ((-i36) + i29)) / 2.0f;
        fontMetricsInt.top = i36 - ((int) Math.ceil(d16));
        int floor = fontMetricsInt.bottom + ((int) Math.floor(d16));
        fontMetricsInt.bottom = floor;
        fontMetricsInt.ascent = fontMetricsInt.top;
        fontMetricsInt.descent = floor;
    }
}
