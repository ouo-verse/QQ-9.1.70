package com.tencent.luggage.wxa.nd;

import rx.Observable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.rd.b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.pd.b f135631b;

    /* renamed from: c, reason: collision with root package name */
    public a f135632c = a.a();

    public b(com.tencent.luggage.wxa.pd.b bVar) {
        this.f135631b = bVar;
    }

    public Observable b() {
        return this.f135632c.a(this.f135631b).compose(a());
    }
}
