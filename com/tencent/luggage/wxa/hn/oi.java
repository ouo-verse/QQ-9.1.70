package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class oi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128378d;

    /* renamed from: e, reason: collision with root package name */
    public String f128379e;

    /* renamed from: f, reason: collision with root package name */
    public String f128380f;

    /* renamed from: g, reason: collision with root package name */
    public String f128381g;

    /* renamed from: h, reason: collision with root package name */
    public String f128382h;

    /* renamed from: i, reason: collision with root package name */
    public String f128383i;

    /* renamed from: j, reason: collision with root package name */
    public int f128384j;

    /* renamed from: k, reason: collision with root package name */
    public String f128385k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128378d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128379e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128380f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f128381g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            String str5 = this.f128382h;
            if (str5 != null) {
                aVar.a(5, str5);
            }
            String str6 = this.f128383i;
            if (str6 != null) {
                aVar.a(6, str6);
            }
            aVar.b(7, this.f128384j);
            String str7 = this.f128385k;
            if (str7 != null) {
                aVar.a(8, str7);
            }
            return 0;
        }
        if (i3 == 1) {
            String str8 = this.f128378d;
            if (str8 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str8);
            }
            String str9 = this.f128379e;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str9);
            }
            String str10 = this.f128380f;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str10);
            }
            String str11 = this.f128381g;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str11);
            }
            String str12 = this.f128382h;
            if (str12 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str12);
            }
            String str13 = this.f128383i;
            if (str13 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(6, str13);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128384j);
            String str14 = this.f128385k;
            if (str14 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(8, str14);
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
        oi oiVar = (oi) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                oiVar.f128378d = aVar3.i(intValue);
                return 0;
            case 2:
                oiVar.f128379e = aVar3.i(intValue);
                return 0;
            case 3:
                oiVar.f128380f = aVar3.i(intValue);
                return 0;
            case 4:
                oiVar.f128381g = aVar3.i(intValue);
                return 0;
            case 5:
                oiVar.f128382h = aVar3.i(intValue);
                return 0;
            case 6:
                oiVar.f128383i = aVar3.i(intValue);
                return 0;
            case 7:
                oiVar.f128384j = aVar3.f(intValue);
                return 0;
            case 8:
                oiVar.f128385k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
