package com.tencent.luggage.wxa.nd;

import rx.Observable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.rd.b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ld.e f135633b;

    /* renamed from: c, reason: collision with root package name */
    public a f135634c = a.a();

    public c(com.tencent.luggage.wxa.ld.e eVar) {
        this.f135633b = eVar;
    }

    public Observable b() {
        return this.f135634c.a(this.f135633b).compose(a());
    }
}
