package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.l0.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements f.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f133957a;

    /* renamed from: b, reason: collision with root package name */
    public final long f133958b;

    /* renamed from: c, reason: collision with root package name */
    public final int f133959c;

    public c(a aVar, long j3) {
        this(aVar, j3, 20480);
    }

    @Override // com.tencent.luggage.wxa.l0.f.a
    public com.tencent.luggage.wxa.l0.f a() {
        return new b(this.f133957a, this.f133958b, this.f133959c);
    }

    public c(a aVar, long j3, int i3) {
        this.f133957a = aVar;
        this.f133958b = j3;
        this.f133959c = i3;
    }
}
