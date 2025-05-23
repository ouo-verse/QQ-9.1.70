package com.tencent.luggage.wxa.aa;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f120976a;

    public c() {
        c();
    }

    public static long b() {
        return SystemClock.elapsedRealtime();
    }

    public long a() {
        return b() - this.f120976a;
    }

    public void c() {
        this.f120976a = b();
    }
}
