package com.tencent.luggage.wxa.nd;

import rx.Observable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.rd.b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ld.d f135635b;

    /* renamed from: c, reason: collision with root package name */
    public a f135636c = a.a();

    public d(com.tencent.luggage.wxa.ld.d dVar) {
        this.f135635b = dVar;
    }

    public Observable b() {
        return this.f135636c.a(this.f135635b).compose(a());
    }
}
