package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class te extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128762d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128763e;

    /* renamed from: f, reason: collision with root package name */
    public String f128764f;

    /* renamed from: g, reason: collision with root package name */
    public String f128765g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128762d;
            if (str != null) {
                aVar.a(1, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128763e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            String str2 = this.f128764f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128765g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128762d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128763e;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, cVar2);
            }
            String str5 = this.f128764f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f128765g;
            if (str6 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return i16;
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
        te teVar = (te) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    teVar.f128765g = aVar3.i(intValue);
                    return 0;
                }
                teVar.f128764f = aVar3.i(intValue);
                return 0;
            }
            teVar.f128763e = aVar3.b(intValue);
            return 0;
        }
        teVar.f128762d = aVar3.i(intValue);
        return 0;
    }
}
