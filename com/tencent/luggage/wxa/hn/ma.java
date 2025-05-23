package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ma extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128175d;

    /* renamed from: e, reason: collision with root package name */
    public int f128176e;

    /* renamed from: f, reason: collision with root package name */
    public int f128177f;

    /* renamed from: g, reason: collision with root package name */
    public String f128178g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f128179h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    public int f128180i;

    /* renamed from: j, reason: collision with root package name */
    public String f128181j;

    /* renamed from: k, reason: collision with root package name */
    public int f128182k;

    /* renamed from: l, reason: collision with root package name */
    public int f128183l;

    /* renamed from: m, reason: collision with root package name */
    public String f128184m;

    /* renamed from: n, reason: collision with root package name */
    public String f128185n;

    /* renamed from: o, reason: collision with root package name */
    public int f128186o;

    /* renamed from: p, reason: collision with root package name */
    public int f128187p;

    /* renamed from: q, reason: collision with root package name */
    public int f128188q;

    /* renamed from: r, reason: collision with root package name */
    public String f128189r;

    /* renamed from: s, reason: collision with root package name */
    public int f128190s;

    /* renamed from: t, reason: collision with root package name */
    public int f128191t;

    /* renamed from: u, reason: collision with root package name */
    public int f128192u;

    /* renamed from: v, reason: collision with root package name */
    public int f128193v;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128175d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f128176e);
            aVar.b(5, this.f128177f);
            String str2 = this.f128178g;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            aVar.a(7, 8, this.f128179h);
            aVar.b(8, this.f128180i);
            String str3 = this.f128181j;
            if (str3 != null) {
                aVar.a(9, str3);
            }
            aVar.b(10, this.f128182k);
            aVar.b(11, this.f128183l);
            String str4 = this.f128184m;
            if (str4 != null) {
                aVar.a(12, str4);
            }
            String str5 = this.f128185n;
            if (str5 != null) {
                aVar.a(13, str5);
            }
            aVar.b(14, this.f128186o);
            aVar.b(16, this.f128187p);
            aVar.b(17, this.f128188q);
            String str6 = this.f128189r;
            if (str6 != null) {
                aVar.a(18, str6);
            }
            aVar.b(19, this.f128190s);
            aVar.b(20, this.f128191t);
            aVar.b(21, this.f128192u);
            aVar.b(23, this.f128193v);
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f128175d;
            if (str7 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.a(1, str7) + 0;
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128176e) + com.tencent.luggage.wxa.gr.a.b(5, this.f128177f);
            String str8 = this.f128178g;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            int a16 = b16 + com.tencent.luggage.wxa.gr.a.a(7, 8, this.f128179h) + com.tencent.luggage.wxa.gr.a.b(8, this.f128180i);
            String str9 = this.f128181j;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str9);
            }
            int b17 = a16 + com.tencent.luggage.wxa.gr.a.b(10, this.f128182k) + com.tencent.luggage.wxa.gr.a.b(11, this.f128183l);
            String str10 = this.f128184m;
            if (str10 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str10);
            }
            String str11 = this.f128185n;
            if (str11 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(13, str11);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(14, this.f128186o) + com.tencent.luggage.wxa.gr.a.b(16, this.f128187p) + com.tencent.luggage.wxa.gr.a.b(17, this.f128188q);
            String str12 = this.f128189r;
            if (str12 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(18, str12);
            }
            return b18 + com.tencent.luggage.wxa.gr.a.b(19, this.f128190s) + com.tencent.luggage.wxa.gr.a.b(20, this.f128191t) + com.tencent.luggage.wxa.gr.a.b(21, this.f128192u) + com.tencent.luggage.wxa.gr.a.b(23, this.f128193v);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128179h.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        ma maVar = (ma) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                maVar.f128175d = aVar3.i(intValue);
                return 0;
            case 2:
                maVar.f128176e = aVar3.f(intValue);
                return 0;
            case 3:
            case 4:
            case 15:
            case 22:
            default:
                return -1;
            case 5:
                maVar.f128177f = aVar3.f(intValue);
                return 0;
            case 6:
                maVar.f128178g = aVar3.i(intValue);
                return 0;
            case 7:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    c6 c6Var = new c6();
                    if (bArr2 != null && bArr2.length > 0) {
                        c6Var.a(bArr2);
                    }
                    maVar.f128179h.add(c6Var);
                }
                return 0;
            case 8:
                maVar.f128180i = aVar3.f(intValue);
                return 0;
            case 9:
                maVar.f128181j = aVar3.i(intValue);
                return 0;
            case 10:
                maVar.f128182k = aVar3.f(intValue);
                return 0;
            case 11:
                maVar.f128183l = aVar3.f(intValue);
                return 0;
            case 12:
                maVar.f128184m = aVar3.i(intValue);
                return 0;
            case 13:
                maVar.f128185n = aVar3.i(intValue);
                return 0;
            case 14:
                maVar.f128186o = aVar3.f(intValue);
                return 0;
            case 16:
                maVar.f128187p = aVar3.f(intValue);
                return 0;
            case 17:
                maVar.f128188q = aVar3.f(intValue);
                return 0;
            case 18:
                maVar.f128189r = aVar3.i(intValue);
                return 0;
            case 19:
                maVar.f128190s = aVar3.f(intValue);
                return 0;
            case 20:
                maVar.f128191t = aVar3.f(intValue);
                return 0;
            case 21:
                maVar.f128192u = aVar3.f(intValue);
                return 0;
            case 23:
                maVar.f128193v = aVar3.f(intValue);
                return 0;
        }
    }
}
