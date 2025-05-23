package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public double f128155d;

    /* renamed from: e, reason: collision with root package name */
    public double f128156e;

    /* renamed from: f, reason: collision with root package name */
    public double f128157f;

    /* renamed from: g, reason: collision with root package name */
    public int f128158g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(2, this.f128155d);
            aVar.a(3, this.f128156e);
            aVar.a(5, this.f128157f);
            aVar.b(6, this.f128158g);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(2, this.f128155d) + 0 + com.tencent.luggage.wxa.gr.a.a(3, this.f128156e) + com.tencent.luggage.wxa.gr.a.a(5, this.f128157f) + com.tencent.luggage.wxa.gr.a.b(6, this.f128158g);
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
        m6 m6Var = (m6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 2) {
            if (intValue != 3) {
                if (intValue != 5) {
                    if (intValue != 6) {
                        return -1;
                    }
                    m6Var.f128158g = aVar3.f(intValue);
                    return 0;
                }
                m6Var.f128157f = aVar3.c(intValue);
                return 0;
            }
            m6Var.f128156e = aVar3.c(intValue);
            return 0;
        }
        m6Var.f128155d = aVar3.c(intValue);
        return 0;
    }
}
