package com.tencent.luggage.wxa.zc;

import com.tencent.luggage.wxa.tn.q0;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public q0 f146484a = new q0(100);

    public com.tencent.luggage.wxa.ad.a a() {
        com.tencent.luggage.wxa.ad.a aVar = (com.tencent.luggage.wxa.ad.a) this.f146484a.a();
        return aVar == null ? b() : aVar;
    }

    public abstract com.tencent.luggage.wxa.ad.a b();

    public void a(com.tencent.luggage.wxa.ad.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f146484a.b(aVar);
    }
}
