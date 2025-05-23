package com.tencent.luggage.wxa.fg;

import com.tencent.luggage.wxa.xd.k0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements com.tencent.luggage.wxa.fg.a {

    /* renamed from: b, reason: collision with root package name */
    public static h f126170b = new h();

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.fg.a f126171a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.fg.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public boolean A() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public boolean M() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public boolean R() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public boolean a(com.tencent.luggage.wxa.xd.d dVar, k0 k0Var) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public int h() {
            return 20;
        }

        @Override // com.tencent.luggage.wxa.fg.a
        public int l() {
            return 200;
        }
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public boolean A() {
        return b().A();
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public boolean M() {
        return b().M();
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public boolean R() {
        return b().R();
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, k0 k0Var) {
        return b().a(dVar, k0Var);
    }

    public com.tencent.luggage.wxa.fg.a b() {
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.fg.a.class) != null) {
            return (com.tencent.luggage.wxa.fg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.fg.a.class);
        }
        return this.f126171a;
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public int h() {
        return b().h();
    }

    @Override // com.tencent.luggage.wxa.fg.a
    public int l() {
        return b().l();
    }
}
