package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128337d;

    /* renamed from: e, reason: collision with root package name */
    public String f128338e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f128339f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f128340g;

    /* renamed from: h, reason: collision with root package name */
    public String f128341h;

    /* renamed from: i, reason: collision with root package name */
    public String f128342i;

    /* renamed from: j, reason: collision with root package name */
    public String f128343j;

    /* renamed from: k, reason: collision with root package name */
    public String f128344k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128337d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128338e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.a(3, this.f128339f);
            aVar.a(4, this.f128340g);
            String str3 = this.f128341h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128342i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f128343j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            String str6 = this.f128344k;
            if (str6 != null) {
                aVar.a(8, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f128337d;
            if (str7 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str7);
            }
            String str8 = this.f128338e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, this.f128339f) + com.tencent.luggage.wxa.gr.a.a(4, this.f128340g);
            String str9 = this.f128341h;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f128342i;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str10);
            }
            String str11 = this.f128343j;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str11);
            }
            String str12 = this.f128344k;
            if (str12 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(8, str12);
            }
            return a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a17 = com.tencent.luggage.wxa.fn.b.a(aVar2); a17 > 0; a17 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a17)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        o7 o7Var = (o7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                o7Var.f128337d = aVar3.i(intValue);
                return 0;
            case 2:
                o7Var.f128338e = aVar3.i(intValue);
                return 0;
            case 3:
                o7Var.f128339f = aVar3.a(intValue);
                return 0;
            case 4:
                o7Var.f128340g = aVar3.a(intValue);
                return 0;
            case 5:
                o7Var.f128341h = aVar3.i(intValue);
                return 0;
            case 6:
                o7Var.f128342i = aVar3.i(intValue);
                return 0;
            case 7:
                o7Var.f128343j = aVar3.i(intValue);
                return 0;
            case 8:
                o7Var.f128344k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
