package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.l0.f;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.m0.d;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements g.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f133979a;

    /* renamed from: b, reason: collision with root package name */
    public final g.a f133980b;

    /* renamed from: c, reason: collision with root package name */
    public final g.a f133981c;

    /* renamed from: d, reason: collision with root package name */
    public final f.a f133982d;

    /* renamed from: e, reason: collision with root package name */
    public final int f133983e;

    /* renamed from: f, reason: collision with root package name */
    public final d.a f133984f;

    public e(a aVar, g.a aVar2, g.a aVar3, f.a aVar4, int i3, d.a aVar5) {
        this.f133979a = aVar;
        this.f133980b = aVar2;
        this.f133981c = aVar3;
        this.f133982d = aVar4;
        this.f133983e = i3;
        this.f133984f = aVar5;
    }

    @Override // com.tencent.luggage.wxa.l0.g.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d createDataSource() {
        com.tencent.luggage.wxa.l0.f fVar;
        a aVar = this.f133979a;
        com.tencent.luggage.wxa.l0.g createDataSource = this.f133980b.createDataSource();
        com.tencent.luggage.wxa.l0.g createDataSource2 = this.f133981c.createDataSource();
        f.a aVar2 = this.f133982d;
        if (aVar2 != null) {
            fVar = aVar2.a();
        } else {
            fVar = null;
        }
        return new d(aVar, createDataSource, createDataSource2, fVar, this.f133983e, this.f133984f);
    }
}
