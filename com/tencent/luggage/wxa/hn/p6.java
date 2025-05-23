package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p6 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f128401e;

    /* renamed from: f, reason: collision with root package name */
    public String f128402f;

    /* renamed from: g, reason: collision with root package name */
    public String f128403g;

    /* renamed from: h, reason: collision with root package name */
    public int f128404h;

    /* renamed from: i, reason: collision with root package name */
    public String f128405i;

    /* renamed from: j, reason: collision with root package name */
    public String f128406j;

    /* renamed from: k, reason: collision with root package name */
    public String f128407k;

    /* renamed from: l, reason: collision with root package name */
    public int f128408l;

    /* renamed from: m, reason: collision with root package name */
    public int f128409m;

    /* renamed from: n, reason: collision with root package name */
    public int f128410n;

    /* renamed from: o, reason: collision with root package name */
    public int f128411o;

    /* renamed from: p, reason: collision with root package name */
    public long f128412p;

    /* renamed from: q, reason: collision with root package name */
    public int f128413q;

    /* renamed from: r, reason: collision with root package name */
    public int f128414r;

    /* renamed from: s, reason: collision with root package name */
    public int f128415s;

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
            aVar.b(2, this.f128401e);
            String str = this.f128402f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f128403g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            aVar.b(5, this.f128404h);
            String str3 = this.f128405i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            String str4 = this.f128406j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f128407k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            aVar.b(9, this.f128408l);
            aVar.b(10, this.f128409m);
            aVar.b(11, this.f128410n);
            aVar.b(12, this.f128411o);
            aVar.a(13, this.f128412p);
            aVar.b(14, this.f128413q);
            aVar.b(15, this.f128414r);
            aVar.b(16, this.f128415s);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a()) + 0;
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128401e);
            String str6 = this.f128402f;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            String str7 = this.f128403g;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128404h);
            String str8 = this.f128405i;
            if (str8 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            String str9 = this.f128406j;
            if (str9 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(7, str9);
            }
            String str10 = this.f128407k;
            if (str10 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(8, str10);
            }
            return b17 + com.tencent.luggage.wxa.gr.a.b(9, this.f128408l) + com.tencent.luggage.wxa.gr.a.b(10, this.f128409m) + com.tencent.luggage.wxa.gr.a.b(11, this.f128410n) + com.tencent.luggage.wxa.gr.a.b(12, this.f128411o) + com.tencent.luggage.wxa.gr.a.a(13, this.f128412p) + com.tencent.luggage.wxa.gr.a.b(14, this.f128413q) + com.tencent.luggage.wxa.gr.a.b(15, this.f128414r) + com.tencent.luggage.wxa.gr.a.b(16, this.f128415s);
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
        p6 p6Var = (p6) objArr[1];
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
                    p6Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                p6Var.f128401e = aVar3.f(intValue);
                return 0;
            case 3:
                p6Var.f128402f = aVar3.i(intValue);
                return 0;
            case 4:
                p6Var.f128403g = aVar3.i(intValue);
                return 0;
            case 5:
                p6Var.f128404h = aVar3.f(intValue);
                return 0;
            case 6:
                p6Var.f128405i = aVar3.i(intValue);
                return 0;
            case 7:
                p6Var.f128406j = aVar3.i(intValue);
                return 0;
            case 8:
                p6Var.f128407k = aVar3.i(intValue);
                return 0;
            case 9:
                p6Var.f128408l = aVar3.f(intValue);
                return 0;
            case 10:
                p6Var.f128409m = aVar3.f(intValue);
                return 0;
            case 11:
                p6Var.f128410n = aVar3.f(intValue);
                return 0;
            case 12:
                p6Var.f128411o = aVar3.f(intValue);
                return 0;
            case 13:
                p6Var.f128412p = aVar3.g(intValue);
                return 0;
            case 14:
                p6Var.f128413q = aVar3.f(intValue);
                return 0;
            case 15:
                p6Var.f128414r = aVar3.f(intValue);
                return 0;
            case 16:
                p6Var.f128415s = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
