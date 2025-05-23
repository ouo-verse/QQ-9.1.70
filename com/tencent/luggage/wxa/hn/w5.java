package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128942e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128943f;

    /* renamed from: g, reason: collision with root package name */
    public String f128944g;

    /* renamed from: h, reason: collision with root package name */
    public int f128945h;

    /* renamed from: i, reason: collision with root package name */
    public int f128946i;

    /* renamed from: j, reason: collision with root package name */
    public gf f128947j;

    /* renamed from: k, reason: collision with root package name */
    public int f128948k;

    /* renamed from: l, reason: collision with root package name */
    public String f128949l;

    /* renamed from: m, reason: collision with root package name */
    public int f128950m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f128951n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f128952o;

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
            String str = this.f128942e;
            if (str != null) {
                aVar.a(2, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128943f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            String str2 = this.f128944g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            aVar.b(5, this.f128945h);
            aVar.b(6, this.f128946i);
            gf gfVar = this.f128947j;
            if (gfVar != null) {
                aVar.c(7, gfVar.a());
                this.f128947j.a(aVar);
            }
            aVar.b(8, this.f128948k);
            String str3 = this.f128949l;
            if (str3 != null) {
                aVar.a(9, str3);
            }
            aVar.b(10, this.f128950m);
            aVar.a(11, this.f128951n);
            aVar.a(12, this.f128952o);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str4 = this.f128942e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128943f;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, cVar2);
            }
            String str5 = this.f128944g;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128945h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128946i);
            gf gfVar2 = this.f128947j;
            if (gfVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(7, gfVar2.a());
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(8, this.f128948k);
            String str6 = this.f128949l;
            if (str6 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str6);
            }
            return b17 + com.tencent.luggage.wxa.gr.a.b(10, this.f128950m) + com.tencent.luggage.wxa.gr.a.a(11, this.f128951n) + com.tencent.luggage.wxa.gr.a.a(12, this.f128952o);
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
        w5 w5Var = (w5) objArr[1];
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
                    w5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                w5Var.f128942e = aVar3.i(intValue);
                return 0;
            case 3:
                w5Var.f128943f = aVar3.b(intValue);
                return 0;
            case 4:
                w5Var.f128944g = aVar3.i(intValue);
                return 0;
            case 5:
                w5Var.f128945h = aVar3.f(intValue);
                return 0;
            case 6:
                w5Var.f128946i = aVar3.f(intValue);
                return 0;
            case 7:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    gf gfVar3 = new gf();
                    if (bArr2 != null && bArr2.length > 0) {
                        gfVar3.a(bArr2);
                    }
                    w5Var.f128947j = gfVar3;
                }
                return 0;
            case 8:
                w5Var.f128948k = aVar3.f(intValue);
                return 0;
            case 9:
                w5Var.f128949l = aVar3.i(intValue);
                return 0;
            case 10:
                w5Var.f128950m = aVar3.f(intValue);
                return 0;
            case 11:
                w5Var.f128951n = aVar3.a(intValue);
                return 0;
            case 12:
                w5Var.f128952o = aVar3.a(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
