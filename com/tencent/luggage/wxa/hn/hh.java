package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class hh extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127810e;

    /* renamed from: f, reason: collision with root package name */
    public String f127811f;

    /* renamed from: g, reason: collision with root package name */
    public int f127812g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127813h;

    /* renamed from: i, reason: collision with root package name */
    public String f127814i;

    /* renamed from: j, reason: collision with root package name */
    public int f127815j;

    /* renamed from: k, reason: collision with root package name */
    public String f127816k;

    /* renamed from: l, reason: collision with root package name */
    public String f127817l;

    /* renamed from: m, reason: collision with root package name */
    public int f127818m;

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
            String str = this.f127810e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127811f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127812g);
            com.tencent.luggage.wxa.fn.c cVar = this.f127813h;
            if (cVar != null) {
                aVar.a(5, cVar);
            }
            String str3 = this.f127814i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            aVar.b(7, this.f127815j);
            String str4 = this.f127816k;
            if (str4 != null) {
                aVar.a(8, str4);
            }
            String str5 = this.f127817l;
            if (str5 != null) {
                aVar.a(9, str5);
            }
            aVar.b(10, this.f127818m);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str6 = this.f127810e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f127811f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127812g);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127813h;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, cVar2);
            }
            String str8 = this.f127814i;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f127815j);
            String str9 = this.f127816k;
            if (str9 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(8, str9);
            }
            String str10 = this.f127817l;
            if (str10 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str10);
            }
            return b17 + com.tencent.luggage.wxa.gr.a.b(10, this.f127818m);
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
        hh hhVar = (hh) objArr[1];
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
                    hhVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                hhVar.f127810e = aVar3.i(intValue);
                return 0;
            case 3:
                hhVar.f127811f = aVar3.i(intValue);
                return 0;
            case 4:
                hhVar.f127812g = aVar3.f(intValue);
                return 0;
            case 5:
                hhVar.f127813h = aVar3.b(intValue);
                return 0;
            case 6:
                hhVar.f127814i = aVar3.i(intValue);
                return 0;
            case 7:
                hhVar.f127815j = aVar3.f(intValue);
                return 0;
            case 8:
                hhVar.f127816k = aVar3.i(intValue);
                return 0;
            case 9:
                hhVar.f127817l = aVar3.i(intValue);
                return 0;
            case 10:
                hhVar.f127818m = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
