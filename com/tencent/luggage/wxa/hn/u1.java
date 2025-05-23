package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128782d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f128783e;

    /* renamed from: f, reason: collision with root package name */
    public int f128784f;

    /* renamed from: g, reason: collision with root package name */
    public int f128785g;

    /* renamed from: h, reason: collision with root package name */
    public int f128786h;

    /* renamed from: i, reason: collision with root package name */
    public int f128787i;

    /* renamed from: j, reason: collision with root package name */
    public int f128788j;

    /* renamed from: k, reason: collision with root package name */
    public int f128789k;

    /* renamed from: l, reason: collision with root package name */
    public int f128790l;

    /* renamed from: m, reason: collision with root package name */
    public int f128791m;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128782d);
            aVar.a(2, this.f128783e);
            aVar.b(3, this.f128784f);
            aVar.b(4, this.f128785g);
            aVar.b(5, this.f128786h);
            aVar.b(6, this.f128787i);
            aVar.b(7, this.f128788j);
            aVar.b(8, this.f128789k);
            aVar.b(9, this.f128790l);
            aVar.b(10, this.f128791m);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f128782d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, this.f128783e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128784f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128785g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128786h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128787i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128788j) + com.tencent.luggage.wxa.gr.a.b(8, this.f128789k) + com.tencent.luggage.wxa.gr.a.b(9, this.f128790l) + com.tencent.luggage.wxa.gr.a.b(10, this.f128791m);
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar2); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a16)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        u1 u1Var = (u1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                u1Var.f128782d = aVar3.f(intValue);
                return 0;
            case 2:
                u1Var.f128783e = aVar3.a(intValue);
                return 0;
            case 3:
                u1Var.f128784f = aVar3.f(intValue);
                return 0;
            case 4:
                u1Var.f128785g = aVar3.f(intValue);
                return 0;
            case 5:
                u1Var.f128786h = aVar3.f(intValue);
                return 0;
            case 6:
                u1Var.f128787i = aVar3.f(intValue);
                return 0;
            case 7:
                u1Var.f128788j = aVar3.f(intValue);
                return 0;
            case 8:
                u1Var.f128789k = aVar3.f(intValue);
                return 0;
            case 9:
                u1Var.f128790l = aVar3.f(intValue);
                return 0;
            case 10:
                u1Var.f128791m = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
