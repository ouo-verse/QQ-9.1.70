package com.tencent.luggage.wxa.cm;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    public int f123709a;

    /* renamed from: b, reason: collision with root package name */
    public final int f123710b;

    public a(float f16, int i3) {
        this.f123710b = i3 & 112;
        a(f16);
    }

    public int a() {
        return this.f123709a;
    }

    public boolean b(float f16) {
        if (this.f123709a != Math.round(f16)) {
            return true;
        }
        return false;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
        int i19 = fontMetricsInt.ascent;
        int i26 = -i19;
        int i27 = this.f123709a;
        if (i26 > i27) {
            int i28 = -i27;
            fontMetricsInt.ascent = i28;
            fontMetricsInt.top = i28;
            fontMetricsInt.descent = 0;
            fontMetricsInt.bottom = 0;
            return;
        }
        int i29 = fontMetricsInt.descent;
        int i36 = i26 + i29;
        if (i36 > i27) {
            int i37 = fontMetricsInt.bottom;
            fontMetricsInt.descent = i37;
            int i38 = i37 - i27;
            fontMetricsInt.ascent = i38;
            fontMetricsInt.top = i38;
            return;
        }
        int i39 = fontMetricsInt.bottom;
        if (i26 + i39 > i27) {
            fontMetricsInt.top = i19;
            fontMetricsInt.bottom = i19 + i27;
            return;
        }
        int i46 = fontMetricsInt.top;
        if ((-i46) + i39 > i27) {
            fontMetricsInt.top = i39 - i27;
            return;
        }
        int i47 = i27 - i36;
        int i48 = this.f123710b;
        if (i48 == 48) {
            fontMetricsInt.descent = i29 + i47;
            fontMetricsInt.bottom = i39 + i47;
            return;
        }
        if (i48 == 80) {
            fontMetricsInt.top = i46 - i47;
            fontMetricsInt.ascent = i19 - i47;
        } else if (i48 == 16) {
            int round = Math.round(i47 / 2.0f);
            fontMetricsInt.top -= round;
            fontMetricsInt.ascent -= round;
            fontMetricsInt.bottom += round;
            fontMetricsInt.descent += round;
        }
    }

    public void a(float f16) {
        this.f123709a = Math.round(f16);
    }
}
