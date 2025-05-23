package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f129074d;

    /* renamed from: e, reason: collision with root package name */
    public String f129075e;

    /* renamed from: f, reason: collision with root package name */
    public String f129076f;

    /* renamed from: g, reason: collision with root package name */
    public String f129077g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f129078h;

    /* renamed from: i, reason: collision with root package name */
    public String f129079i;

    /* renamed from: j, reason: collision with root package name */
    public String f129080j;

    /* renamed from: k, reason: collision with root package name */
    public String f129081k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f129082l;

    /* renamed from: m, reason: collision with root package name */
    public String f129083m;

    /* renamed from: n, reason: collision with root package name */
    public String f129084n;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f129074d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f129075e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f129076f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f129077g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            aVar.a(5, this.f129078h);
            String str5 = this.f129079i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            String str6 = this.f129080j;
            if (str6 != null) {
                aVar.a(7, str6);
            }
            String str7 = this.f129081k;
            if (str7 != null) {
                aVar.a(8, str7);
            }
            aVar.a(9, this.f129082l);
            String str8 = this.f129083m;
            if (str8 != null) {
                aVar.a(10, str8);
            }
            String str9 = this.f129084n;
            if (str9 != null) {
                aVar.a(11, str9);
            }
            return 0;
        }
        if (i3 == 1) {
            String str10 = this.f129074d;
            if (str10 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str10);
            }
            String str11 = this.f129075e;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str11);
            }
            String str12 = this.f129076f;
            if (str12 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str12);
            }
            String str13 = this.f129077g;
            if (str13 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str13);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(5, this.f129078h);
            String str14 = this.f129079i;
            if (str14 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str14);
            }
            String str15 = this.f129080j;
            if (str15 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str15);
            }
            String str16 = this.f129081k;
            if (str16 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str16);
            }
            int a17 = a16 + com.tencent.luggage.wxa.gr.a.a(9, this.f129082l);
            String str17 = this.f129083m;
            if (str17 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(10, str17);
            }
            String str18 = this.f129084n;
            if (str18 != null) {
                return a17 + com.tencent.luggage.wxa.gr.a.a(11, str18);
            }
            return a17;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a18 = com.tencent.luggage.wxa.fn.b.a(aVar2); a18 > 0; a18 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a18)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        y7 y7Var = (y7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                y7Var.f129074d = aVar3.i(intValue);
                return 0;
            case 2:
                y7Var.f129075e = aVar3.i(intValue);
                return 0;
            case 3:
                y7Var.f129076f = aVar3.i(intValue);
                return 0;
            case 4:
                y7Var.f129077g = aVar3.i(intValue);
                return 0;
            case 5:
                y7Var.f129078h = aVar3.a(intValue);
                return 0;
            case 6:
                y7Var.f129079i = aVar3.i(intValue);
                return 0;
            case 7:
                y7Var.f129080j = aVar3.i(intValue);
                return 0;
            case 8:
                y7Var.f129081k = aVar3.i(intValue);
                return 0;
            case 9:
                y7Var.f129082l = aVar3.a(intValue);
                return 0;
            case 10:
                y7Var.f129083m = aVar3.i(intValue);
                return 0;
            case 11:
                y7Var.f129084n = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
