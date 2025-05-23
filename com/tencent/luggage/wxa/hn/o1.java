package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128317d;

    /* renamed from: e, reason: collision with root package name */
    public String f128318e;

    /* renamed from: f, reason: collision with root package name */
    public int f128319f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128317d);
            String str = this.f128318e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f128319f);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128317d) + 0;
            String str2 = this.f128318e;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128319f);
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
        o1 o1Var = (o1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                o1Var.f128319f = aVar3.f(intValue);
                return 0;
            }
            o1Var.f128318e = aVar3.i(intValue);
            return 0;
        }
        o1Var.f128317d = aVar3.f(intValue);
        return 0;
    }
}
