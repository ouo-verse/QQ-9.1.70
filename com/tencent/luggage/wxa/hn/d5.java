package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127455e;

    /* renamed from: f, reason: collision with root package name */
    public String f127456f;

    /* renamed from: g, reason: collision with root package name */
    public int f127457g;

    /* renamed from: h, reason: collision with root package name */
    public String f127458h;

    /* renamed from: i, reason: collision with root package name */
    public String f127459i;

    /* renamed from: j, reason: collision with root package name */
    public int f127460j;

    /* renamed from: k, reason: collision with root package name */
    public int f127461k;

    /* renamed from: l, reason: collision with root package name */
    public int f127462l;

    /* renamed from: m, reason: collision with root package name */
    public String f127463m;

    /* renamed from: n, reason: collision with root package name */
    public String f127464n;

    /* renamed from: o, reason: collision with root package name */
    public String f127465o;

    /* renamed from: p, reason: collision with root package name */
    public int f127466p;

    /* renamed from: q, reason: collision with root package name */
    public String f127467q;

    /* renamed from: r, reason: collision with root package name */
    public String f127468r;

    /* renamed from: s, reason: collision with root package name */
    public String f127469s;

    /* renamed from: t, reason: collision with root package name */
    public int f127470t;

    /* renamed from: u, reason: collision with root package name */
    public int f127471u;

    /* renamed from: v, reason: collision with root package name */
    public int f127472v;

    /* renamed from: w, reason: collision with root package name */
    public int f127473w;

    /* renamed from: x, reason: collision with root package name */
    public long f127474x;

    /* renamed from: y, reason: collision with root package name */
    public int f127475y;

    /* renamed from: z, reason: collision with root package name */
    public int f127476z;

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
            String str = this.f127455e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127456f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127457g);
            String str3 = this.f127458h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127459i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            aVar.b(7, this.f127460j);
            aVar.b(8, this.f127461k);
            aVar.b(9, this.f127462l);
            String str5 = this.f127463m;
            if (str5 != null) {
                aVar.a(10, str5);
            }
            String str6 = this.f127464n;
            if (str6 != null) {
                aVar.a(11, str6);
            }
            String str7 = this.f127465o;
            if (str7 != null) {
                aVar.a(12, str7);
            }
            aVar.b(13, this.f127466p);
            String str8 = this.f127467q;
            if (str8 != null) {
                aVar.a(14, str8);
            }
            String str9 = this.f127468r;
            if (str9 != null) {
                aVar.a(15, str9);
            }
            String str10 = this.f127469s;
            if (str10 != null) {
                aVar.a(16, str10);
            }
            aVar.b(17, this.f127470t);
            aVar.b(18, this.f127471u);
            aVar.b(19, this.f127472v);
            aVar.b(20, this.f127473w);
            aVar.a(21, this.f127474x);
            aVar.b(22, this.f127475y);
            aVar.b(23, this.f127476z);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a()) + 0;
            }
            String str11 = this.f127455e;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str11);
            }
            String str12 = this.f127456f;
            if (str12 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str12);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127457g);
            String str13 = this.f127458h;
            if (str13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str13);
            }
            String str14 = this.f127459i;
            if (str14 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str14);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f127460j) + com.tencent.luggage.wxa.gr.a.b(8, this.f127461k) + com.tencent.luggage.wxa.gr.a.b(9, this.f127462l);
            String str15 = this.f127463m;
            if (str15 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(10, str15);
            }
            String str16 = this.f127464n;
            if (str16 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str16);
            }
            String str17 = this.f127465o;
            if (str17 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str17);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(13, this.f127466p);
            String str18 = this.f127467q;
            if (str18 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(14, str18);
            }
            String str19 = this.f127468r;
            if (str19 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(15, str19);
            }
            String str20 = this.f127469s;
            if (str20 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(16, str20);
            }
            return b18 + com.tencent.luggage.wxa.gr.a.b(17, this.f127470t) + com.tencent.luggage.wxa.gr.a.b(18, this.f127471u) + com.tencent.luggage.wxa.gr.a.b(19, this.f127472v) + com.tencent.luggage.wxa.gr.a.b(20, this.f127473w) + com.tencent.luggage.wxa.gr.a.a(21, this.f127474x) + com.tencent.luggage.wxa.gr.a.b(22, this.f127475y) + com.tencent.luggage.wxa.gr.a.b(23, this.f127476z);
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
        d5 d5Var = (d5) objArr[1];
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
                    d5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                d5Var.f127455e = aVar3.i(intValue);
                return 0;
            case 3:
                d5Var.f127456f = aVar3.i(intValue);
                return 0;
            case 4:
                d5Var.f127457g = aVar3.f(intValue);
                return 0;
            case 5:
                d5Var.f127458h = aVar3.i(intValue);
                return 0;
            case 6:
                d5Var.f127459i = aVar3.i(intValue);
                return 0;
            case 7:
                d5Var.f127460j = aVar3.f(intValue);
                return 0;
            case 8:
                d5Var.f127461k = aVar3.f(intValue);
                return 0;
            case 9:
                d5Var.f127462l = aVar3.f(intValue);
                return 0;
            case 10:
                d5Var.f127463m = aVar3.i(intValue);
                return 0;
            case 11:
                d5Var.f127464n = aVar3.i(intValue);
                return 0;
            case 12:
                d5Var.f127465o = aVar3.i(intValue);
                return 0;
            case 13:
                d5Var.f127466p = aVar3.f(intValue);
                return 0;
            case 14:
                d5Var.f127467q = aVar3.i(intValue);
                return 0;
            case 15:
                d5Var.f127468r = aVar3.i(intValue);
                return 0;
            case 16:
                d5Var.f127469s = aVar3.i(intValue);
                return 0;
            case 17:
                d5Var.f127470t = aVar3.f(intValue);
                return 0;
            case 18:
                d5Var.f127471u = aVar3.f(intValue);
                return 0;
            case 19:
                d5Var.f127472v = aVar3.f(intValue);
                return 0;
            case 20:
                d5Var.f127473w = aVar3.f(intValue);
                return 0;
            case 21:
                d5Var.f127474x = aVar3.g(intValue);
                return 0;
            case 22:
                d5Var.f127475y = aVar3.f(intValue);
                return 0;
            case 23:
                d5Var.f127476z = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
