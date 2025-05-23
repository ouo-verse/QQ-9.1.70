package com.tencent.luggage.wxa.ya;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e implements c, b {

    /* renamed from: a, reason: collision with root package name */
    public a f145500a;

    public e(a aVar) {
        this.f145500a = aVar;
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void G() {
        a aVar = this.f145500a;
        if (aVar instanceof b) {
            ((b) aVar).G();
        }
    }

    @Override // com.tencent.luggage.wxa.ya.b
    public void e() {
        a aVar = this.f145500a;
        if (aVar instanceof b) {
            ((b) aVar).e();
        }
    }

    @Override // com.tencent.luggage.wxa.ya.c
    public a get() {
        return this.f145500a;
    }
}
