package com.tencent.luggage.wxa.h6;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.dq.a f126870a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f126871b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f126872c = 0;

    /* renamed from: d, reason: collision with root package name */
    public volatile long f126873d = -1;

    public b(com.tencent.luggage.wxa.dq.a aVar, Runnable runnable) {
        this.f126870a = aVar;
        this.f126871b = runnable;
    }

    public void a(long j3) {
        com.tencent.luggage.wxa.er.a.b(j3 >= 0);
        this.f126872c = w0.c();
        this.f126873d = j3;
        this.f126870a.b(this.f126871b);
        this.f126870a.a(this.f126871b, j3);
    }

    public void a() {
        this.f126870a.b(this.f126871b);
    }
}
