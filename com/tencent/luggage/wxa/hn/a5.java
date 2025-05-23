package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127268e;

    /* renamed from: f, reason: collision with root package name */
    public String f127269f;

    /* renamed from: g, reason: collision with root package name */
    public String f127270g;

    /* renamed from: h, reason: collision with root package name */
    public String f127271h;

    /* renamed from: i, reason: collision with root package name */
    public String f127272i;

    /* renamed from: j, reason: collision with root package name */
    public String f127273j;

    /* renamed from: k, reason: collision with root package name */
    public String f127274k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127275l;

    /* renamed from: m, reason: collision with root package name */
    public int f127276m;

    /* renamed from: n, reason: collision with root package name */
    public String f127277n;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            g0 g0Var = this.f128671d;
            if (g0Var != null) {
                aVar.c(1, g0Var.a());
                this.f128671d.a(aVar);
            }
            String str = this.f127268e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127269f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127270g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f127271h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f127272i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            String str6 = this.f127273j;
            if (str6 != null) {
                aVar.a(7, str6);
            }
            String str7 = this.f127274k;
            if (str7 != null) {
                aVar.a(8, str7);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f127275l;
            if (cVar != null) {
                aVar.a(9, cVar);
            }
            aVar.b(10, this.f127276m);
            String str8 = this.f127277n;
            if (str8 != null) {
                aVar.a(11, str8);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str9 = this.f127268e;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str9);
            }
            String str10 = this.f127269f;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str10);
            }
            String str11 = this.f127270g;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str11);
            }
            String str12 = this.f127271h;
            if (str12 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str12);
            }
            String str13 = this.f127272i;
            if (str13 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(6, str13);
            }
            String str14 = this.f127273j;
            if (str14 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(7, str14);
            }
            String str15 = this.f127274k;
            if (str15 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(8, str15);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127275l;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(9, cVar2);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(10, this.f127276m);
            String str16 = this.f127277n;
            if (str16 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(11, str16);
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
        a5 a5Var = (a5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr != null && bArr.length > 0) {
                        g0Var3.a(bArr);
                    }
                    a5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                a5Var.f127268e = aVar3.i(intValue);
                return 0;
            case 3:
                a5Var.f127269f = aVar3.i(intValue);
                return 0;
            case 4:
                a5Var.f127270g = aVar3.i(intValue);
                return 0;
            case 5:
                a5Var.f127271h = aVar3.i(intValue);
                return 0;
            case 6:
                a5Var.f127272i = aVar3.i(intValue);
                return 0;
            case 7:
                a5Var.f127273j = aVar3.i(intValue);
                return 0;
            case 8:
                a5Var.f127274k = aVar3.i(intValue);
                return 0;
            case 9:
                a5Var.f127275l = aVar3.b(intValue);
                return 0;
            case 10:
                a5Var.f127276m = aVar3.f(intValue);
                return 0;
            case 11:
                a5Var.f127277n = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
