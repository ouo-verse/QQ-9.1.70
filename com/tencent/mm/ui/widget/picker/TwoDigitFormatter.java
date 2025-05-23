package com.tencent.mm.ui.widget.picker;

import android.widget.NumberPicker;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
final class TwoDigitFormatter implements NumberPicker.Formatter {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f153628a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f153629b = new Object[1];

    /* renamed from: c, reason: collision with root package name */
    public char f153630c;

    /* renamed from: d, reason: collision with root package name */
    public Formatter f153631d;

    public TwoDigitFormatter() {
        c(Locale.getDefault());
    }

    public static char b(Locale locale) {
        return '0';
    }

    public final Formatter a(Locale locale) {
        return new Formatter(this.f153628a, locale);
    }

    public final void c(Locale locale) {
        this.f153631d = a(locale);
        this.f153630c = b(locale);
    }

    @Override // android.widget.NumberPicker.Formatter
    public String format(int i3) {
        Locale locale = Locale.getDefault();
        if (this.f153630c != b(locale)) {
            c(locale);
        }
        this.f153629b[0] = Integer.valueOf(i3);
        StringBuilder sb5 = this.f153628a;
        sb5.delete(0, sb5.length());
        this.f153631d.format("%02d", this.f153629b);
        return this.f153631d.toString();
    }
}
