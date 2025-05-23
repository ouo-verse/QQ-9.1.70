package com.tencent.luggage.wxa.n0;

import android.os.Trace;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t {
    public static void a(String str) {
        if (v.f135103a >= 18) {
            b(str);
        }
    }

    public static void b(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }

    public static void a() {
        if (v.f135103a >= 18) {
            b();
        }
    }
}
