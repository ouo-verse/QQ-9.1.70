package com.tencent.luggage.wxa.ae;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final g f121049a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f121050b;

    public a(g gVar) {
        this.f121049a = gVar;
    }

    @Override // com.tencent.luggage.wxa.ae.g
    public void b() {
        if (this.f121050b) {
            return;
        }
        g gVar = this.f121049a;
        if (gVar != null) {
            gVar.b();
        }
        this.f121050b = true;
    }
}
