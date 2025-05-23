package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f128863e;

    /* renamed from: f, reason: collision with root package name */
    public String f128864f;

    /* renamed from: g, reason: collision with root package name */
    public int f128865g;

    /* renamed from: h, reason: collision with root package name */
    public int f128866h;

    /* renamed from: i, reason: collision with root package name */
    public String f128867i;

    /* renamed from: j, reason: collision with root package name */
    public LinkedList f128868j = new LinkedList();

    /* renamed from: k, reason: collision with root package name */
    public int f128869k;

    /* renamed from: l, reason: collision with root package name */
    public String f128870l;

    /* renamed from: m, reason: collision with root package name */
    public String f128871m;

    /* renamed from: n, reason: collision with root package name */
    public int f128872n;

    /* renamed from: o, reason: collision with root package name */
    public String f128873o;

    /* renamed from: p, reason: collision with root package name */
    public String f128874p;

    /* renamed from: q, reason: collision with root package name */
    public String f128875q;

    /* renamed from: r, reason: collision with root package name */
    public String f128876r;

    /* renamed from: s, reason: collision with root package name */
    public int f128877s;

    /* renamed from: t, reason: collision with root package name */
    public int f128878t;

    /* renamed from: u, reason: collision with root package name */
    public z6 f128879u;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(1, h0Var.a());
                this.f128743d.a(aVar);
            }
            wd wdVar = this.f128863e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f128863e.a(aVar);
            }
            String str = this.f128864f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.b(4, this.f128865g);
            aVar.b(5, this.f128866h);
            String str2 = this.f128867i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            aVar.a(7, 8, this.f128868j);
            aVar.b(8, this.f128869k);
            String str3 = this.f128870l;
            if (str3 != null) {
                aVar.a(9, str3);
            }
            String str4 = this.f128871m;
            if (str4 != null) {
                aVar.a(10, str4);
            }
            aVar.b(11, this.f128872n);
            String str5 = this.f128873o;
            if (str5 != null) {
                aVar.a(12, str5);
            }
            String str6 = this.f128874p;
            if (str6 != null) {
                aVar.a(13, str6);
            }
            String str7 = this.f128875q;
            if (str7 != null) {
                aVar.a(14, str7);
            }
            String str8 = this.f128876r;
            if (str8 != null) {
                aVar.a(15, str8);
            }
            aVar.b(16, this.f128877s);
            aVar.b(17, this.f128878t);
            z6 z6Var = this.f128879u;
            if (z6Var != null) {
                aVar.c(18, z6Var.a());
                this.f128879u.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            wd wdVar2 = this.f128863e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            String str9 = this.f128864f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128865g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128866h);
            String str10 = this.f128867i;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str10);
            }
            int a16 = b16 + com.tencent.luggage.wxa.gr.a.a(7, 8, this.f128868j) + com.tencent.luggage.wxa.gr.a.b(8, this.f128869k);
            String str11 = this.f128870l;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str11);
            }
            String str12 = this.f128871m;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(10, str12);
            }
            int b17 = a16 + com.tencent.luggage.wxa.gr.a.b(11, this.f128872n);
            String str13 = this.f128873o;
            if (str13 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str13);
            }
            String str14 = this.f128874p;
            if (str14 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(13, str14);
            }
            String str15 = this.f128875q;
            if (str15 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(14, str15);
            }
            String str16 = this.f128876r;
            if (str16 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(15, str16);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(16, this.f128877s) + com.tencent.luggage.wxa.gr.a.b(17, this.f128878t);
            z6 z6Var2 = this.f128879u;
            if (z6Var2 != null) {
                return b18 + com.tencent.luggage.wxa.gr.a.c(18, z6Var2.a());
            }
            return b18;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128868j.clear();
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
        v3 v3Var = (v3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr2 != null && bArr2.length > 0) {
                        h0Var3.a(bArr2);
                    }
                    v3Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    wd wdVar3 = new wd();
                    if (bArr3 != null && bArr3.length > 0) {
                        wdVar3.a(bArr3);
                    }
                    v3Var.f128863e = wdVar3;
                }
                return 0;
            case 3:
                v3Var.f128864f = aVar3.i(intValue);
                return 0;
            case 4:
                v3Var.f128865g = aVar3.f(intValue);
                return 0;
            case 5:
                v3Var.f128866h = aVar3.f(intValue);
                return 0;
            case 6:
                v3Var.f128867i = aVar3.i(intValue);
                return 0;
            case 7:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    z6 z6Var3 = new z6();
                    if (bArr4 != null && bArr4.length > 0) {
                        z6Var3.a(bArr4);
                    }
                    v3Var.f128868j.add(z6Var3);
                }
                return 0;
            case 8:
                v3Var.f128869k = aVar3.f(intValue);
                return 0;
            case 9:
                v3Var.f128870l = aVar3.i(intValue);
                return 0;
            case 10:
                v3Var.f128871m = aVar3.i(intValue);
                return 0;
            case 11:
                v3Var.f128872n = aVar3.f(intValue);
                return 0;
            case 12:
                v3Var.f128873o = aVar3.i(intValue);
                return 0;
            case 13:
                v3Var.f128874p = aVar3.i(intValue);
                return 0;
            case 14:
                v3Var.f128875q = aVar3.i(intValue);
                return 0;
            case 15:
                v3Var.f128876r = aVar3.i(intValue);
                return 0;
            case 16:
                v3Var.f128877s = aVar3.f(intValue);
                return 0;
            case 17:
                v3Var.f128878t = aVar3.f(intValue);
                return 0;
            case 18:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    z6 z6Var4 = new z6();
                    if (bArr5 != null && bArr5.length > 0) {
                        z6Var4.a(bArr5);
                    }
                    v3Var.f128879u = z6Var4;
                }
                return 0;
            default:
                return -1;
        }
    }
}
