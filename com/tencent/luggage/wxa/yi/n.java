package com.tencent.luggage.wxa.yi;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class n implements k {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f145923a = new AtomicInteger(1);

    public static g c(g gVar) {
        if (gVar instanceof h) {
            return ((h) gVar).a();
        }
        return gVar;
    }

    @Override // com.tencent.luggage.wxa.yi.k
    public int a() {
        return this.f145923a.incrementAndGet();
    }
}
