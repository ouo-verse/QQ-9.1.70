package com.tencent.luggage.wxa.yp;

import android.util.Printer;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c implements Printer {

    /* renamed from: a, reason: collision with root package name */
    public final int f146062a;

    /* renamed from: b, reason: collision with root package name */
    public final String f146063b;

    public c(int i3, String str) {
        this.f146062a = i3;
        this.f146063b = str;
    }

    @Override // android.util.Printer
    public void println(String str) {
        b.a(this.f146062a, this.f146063b, str);
    }
}
