package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128953d;

    /* renamed from: e, reason: collision with root package name */
    public String f128954e;

    /* renamed from: f, reason: collision with root package name */
    public String f128955f;

    /* renamed from: g, reason: collision with root package name */
    public String f128956g;

    /* renamed from: h, reason: collision with root package name */
    public String f128957h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128953d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128954e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128955f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f128956g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            String str5 = this.f128957h;
            if (str5 != null) {
                aVar.a(5, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            String str6 = this.f128953d;
            if (str6 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str6);
            }
            String str7 = this.f128954e;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str7);
            }
            String str8 = this.f128955f;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str8);
            }
            String str9 = this.f128956g;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str9);
            }
            String str10 = this.f128957h;
            if (str10 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(5, str10);
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
        w6 w6Var = (w6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        w6Var.f128957h = aVar3.i(intValue);
                        return 0;
                    }
                    w6Var.f128956g = aVar3.i(intValue);
                    return 0;
                }
                w6Var.f128955f = aVar3.i(intValue);
                return 0;
            }
            w6Var.f128954e = aVar3.i(intValue);
            return 0;
        }
        w6Var.f128953d = aVar3.i(intValue);
        return 0;
    }
}
