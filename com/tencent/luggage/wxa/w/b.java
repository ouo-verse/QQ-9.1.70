package com.tencent.luggage.wxa.w;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.luggage.wxa.n.a;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.k f143738a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143739b;

    /* renamed from: c, reason: collision with root package name */
    public final String f143740c;

    /* renamed from: d, reason: collision with root package name */
    public String f143741d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143742e;

    /* renamed from: f, reason: collision with root package name */
    public int f143743f;

    /* renamed from: g, reason: collision with root package name */
    public int f143744g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f143745h;

    /* renamed from: i, reason: collision with root package name */
    public long f143746i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j f143747j;

    /* renamed from: k, reason: collision with root package name */
    public int f143748k;

    /* renamed from: l, reason: collision with root package name */
    public long f143749l;

    public b() {
        this(null);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        this.f143743f = 0;
        this.f143744g = 0;
        this.f143745h = false;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void c() {
        this.f143738a.b(0);
        a.b a16 = com.tencent.luggage.wxa.n.a.a(this.f143738a);
        com.tencent.luggage.wxa.m.j jVar = this.f143747j;
        if (jVar == null || a16.f134898c != jVar.G || a16.f134897b != jVar.H || a16.f134896a != jVar.f133896f) {
            com.tencent.luggage.wxa.m.j a17 = com.tencent.luggage.wxa.m.j.a(this.f143741d, a16.f134896a, null, -1, -1, a16.f134898c, a16.f134897b, null, null, 0, this.f143740c);
            this.f143747j = a17;
            this.f143742e.a(a17);
        }
        this.f143748k = a16.f134899d;
        this.f143746i = (a16.f134900e * 1000000) / this.f143747j.H;
    }

    public b(String str) {
        com.tencent.luggage.wxa.n0.k kVar = new com.tencent.luggage.wxa.n0.k(new byte[8]);
        this.f143738a = kVar;
        this.f143739b = new com.tencent.luggage.wxa.n0.l(kVar.f135084a);
        this.f143743f = 0;
        this.f143740c = str;
    }

    public final boolean b(com.tencent.luggage.wxa.n0.l lVar) {
        while (true) {
            if (lVar.a() <= 0) {
                return false;
            }
            if (!this.f143745h) {
                this.f143745h = lVar.q() == 11;
            } else {
                int q16 = lVar.q();
                if (q16 == 119) {
                    this.f143745h = false;
                    return true;
                }
                this.f143745h = q16 == 11;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143741d = dVar.b();
        this.f143742e = fVar.a(dVar.c(), 1);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143749l = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int i3 = this.f143743f;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(lVar.a(), this.f143748k - this.f143744g);
                        this.f143742e.a(lVar, min);
                        int i16 = this.f143744g + min;
                        this.f143744g = i16;
                        int i17 = this.f143748k;
                        if (i16 == i17) {
                            this.f143742e.a(this.f143749l, 1, i17, 0, null);
                            this.f143749l += this.f143746i;
                            this.f143743f = 0;
                        }
                    }
                } else if (a(lVar, this.f143739b.f135088a, 8)) {
                    c();
                    this.f143739b.e(0);
                    this.f143742e.a(this.f143739b, 8);
                    this.f143743f = 2;
                }
            } else if (b(lVar)) {
                this.f143743f = 1;
                byte[] bArr = this.f143739b.f135088a;
                bArr[0] = 11;
                bArr[1] = IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND;
                this.f143744g = 2;
            }
        }
    }

    public final boolean a(com.tencent.luggage.wxa.n0.l lVar, byte[] bArr, int i3) {
        int min = Math.min(lVar.a(), i3 - this.f143744g);
        lVar.a(bArr, this.f143744g, min);
        int i16 = this.f143744g + min;
        this.f143744g = i16;
        return i16 == i3;
    }
}
