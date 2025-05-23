package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class nb extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128290d;

    /* renamed from: e, reason: collision with root package name */
    public String f128291e;

    /* renamed from: f, reason: collision with root package name */
    public String f128292f;

    /* renamed from: g, reason: collision with root package name */
    public String f128293g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128290d);
            String str = this.f128291e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128292f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128293g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128290d) + 0;
            String str4 = this.f128291e;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f128292f;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f128293g;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return b16;
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
        nb nbVar = (nb) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    nbVar.f128293g = aVar3.i(intValue);
                    return 0;
                }
                nbVar.f128292f = aVar3.i(intValue);
                return 0;
            }
            nbVar.f128291e = aVar3.i(intValue);
            return 0;
        }
        nbVar.f128290d = aVar3.f(intValue);
        return 0;
    }
}
