package com.tencent.ecommerce.richtext.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f105493b;

    /* renamed from: a, reason: collision with root package name */
    private final DecimalFormat f105494a;

    b() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        this.f105494a = decimalFormat;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    public static b b() {
        if (f105493b == null) {
            synchronized (b.class) {
                if (f105493b == null) {
                    f105493b = new b();
                }
            }
        }
        return f105493b;
    }

    public String a(double d16) {
        return this.f105494a.format(d16);
    }
}
