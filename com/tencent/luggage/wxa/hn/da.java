package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class da extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public y f127491e;

    /* renamed from: f, reason: collision with root package name */
    public int f127492f;

    /* renamed from: g, reason: collision with root package name */
    public x f127493g;

    /* renamed from: h, reason: collision with root package name */
    public String f127494h;

    /* renamed from: i, reason: collision with root package name */
    public String f127495i;

    /* renamed from: j, reason: collision with root package name */
    public String f127496j;

    /* renamed from: k, reason: collision with root package name */
    public String f127497k;

    /* renamed from: m, reason: collision with root package name */
    public String f127499m;

    /* renamed from: n, reason: collision with root package name */
    public String f127500n;

    /* renamed from: o, reason: collision with root package name */
    public a0 f127501o;

    /* renamed from: q, reason: collision with root package name */
    public String f127503q;

    /* renamed from: r, reason: collision with root package name */
    public vb f127504r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f127505s;

    /* renamed from: t, reason: collision with root package name */
    public String f127506t;

    /* renamed from: u, reason: collision with root package name */
    public w f127507u;

    /* renamed from: l, reason: collision with root package name */
    public LinkedList f127498l = new LinkedList();

    /* renamed from: p, reason: collision with root package name */
    public LinkedList f127502p = new LinkedList();

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
            y yVar = this.f127491e;
            if (yVar != null) {
                aVar.c(2, yVar.a());
                this.f127491e.a(aVar);
            }
            aVar.b(3, this.f127492f);
            x xVar = this.f127493g;
            if (xVar != null) {
                aVar.c(4, xVar.a());
                this.f127493g.a(aVar);
            }
            String str = this.f127494h;
            if (str != null) {
                aVar.a(5, str);
            }
            String str2 = this.f127495i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            String str3 = this.f127496j;
            if (str3 != null) {
                aVar.a(7, str3);
            }
            String str4 = this.f127497k;
            if (str4 != null) {
                aVar.a(8, str4);
            }
            aVar.a(9, 8, this.f127498l);
            String str5 = this.f127499m;
            if (str5 != null) {
                aVar.a(10, str5);
            }
            String str6 = this.f127500n;
            if (str6 != null) {
                aVar.a(11, str6);
            }
            a0 a0Var = this.f127501o;
            if (a0Var != null) {
                aVar.c(12, a0Var.a());
                this.f127501o.a(aVar);
            }
            aVar.a(13, 8, this.f127502p);
            String str7 = this.f127503q;
            if (str7 != null) {
                aVar.a(14, str7);
            }
            vb vbVar = this.f127504r;
            if (vbVar != null) {
                aVar.c(15, vbVar.a());
                this.f127504r.a(aVar);
            }
            aVar.a(16, this.f127505s);
            String str8 = this.f127506t;
            if (str8 != null) {
                aVar.a(17, str8);
            }
            w wVar = this.f127507u;
            if (wVar != null) {
                aVar.c(19, wVar.a());
                this.f127507u.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            y yVar2 = this.f127491e;
            if (yVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, yVar2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127492f);
            x xVar2 = this.f127493g;
            if (xVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(4, xVar2.a());
            }
            String str9 = this.f127494h;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f127495i;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str10);
            }
            String str11 = this.f127496j;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str11);
            }
            String str12 = this.f127497k;
            if (str12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str12);
            }
            int a16 = b16 + com.tencent.luggage.wxa.gr.a.a(9, 8, this.f127498l);
            String str13 = this.f127499m;
            if (str13 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(10, str13);
            }
            String str14 = this.f127500n;
            if (str14 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(11, str14);
            }
            a0 a0Var2 = this.f127501o;
            if (a0Var2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(12, a0Var2.a());
            }
            int a17 = a16 + com.tencent.luggage.wxa.gr.a.a(13, 8, this.f127502p);
            String str15 = this.f127503q;
            if (str15 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(14, str15);
            }
            vb vbVar2 = this.f127504r;
            if (vbVar2 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.c(15, vbVar2.a());
            }
            int a18 = a17 + com.tencent.luggage.wxa.gr.a.a(16, this.f127505s);
            String str16 = this.f127506t;
            if (str16 != null) {
                a18 += com.tencent.luggage.wxa.gr.a.a(17, str16);
            }
            w wVar2 = this.f127507u;
            if (wVar2 != null) {
                return a18 + com.tencent.luggage.wxa.gr.a.c(19, wVar2.a());
            }
            return a18;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127498l.clear();
            this.f127502p.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a19 = com.tencent.luggage.wxa.fn.b.a(aVar2); a19 > 0; a19 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a19)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        da daVar = (da) objArr[1];
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
                    daVar.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    y yVar3 = new y();
                    if (bArr3 != null && bArr3.length > 0) {
                        yVar3.a(bArr3);
                    }
                    daVar.f127491e = yVar3;
                }
                return 0;
            case 3:
                daVar.f127492f = aVar3.f(intValue);
                return 0;
            case 4:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    x xVar3 = new x();
                    if (bArr4 != null && bArr4.length > 0) {
                        xVar3.a(bArr4);
                    }
                    daVar.f127493g = xVar3;
                }
                return 0;
            case 5:
                daVar.f127494h = aVar3.i(intValue);
                return 0;
            case 6:
                daVar.f127495i = aVar3.i(intValue);
                return 0;
            case 7:
                daVar.f127496j = aVar3.i(intValue);
                return 0;
            case 8:
                daVar.f127497k = aVar3.i(intValue);
                return 0;
            case 9:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    z zVar = new z();
                    if (bArr5 != null && bArr5.length > 0) {
                        zVar.a(bArr5);
                    }
                    daVar.f127498l.add(zVar);
                }
                return 0;
            case 10:
                daVar.f127499m = aVar3.i(intValue);
                return 0;
            case 11:
                daVar.f127500n = aVar3.i(intValue);
                return 0;
            case 12:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr6 = (byte[]) h26.get(i27);
                    a0 a0Var3 = new a0();
                    if (bArr6 != null && bArr6.length > 0) {
                        a0Var3.a(bArr6);
                    }
                    daVar.f127501o = a0Var3;
                }
                return 0;
            case 13:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr7 = (byte[]) h27.get(i28);
                    a0 a0Var4 = new a0();
                    if (bArr7 != null && bArr7.length > 0) {
                        a0Var4.a(bArr7);
                    }
                    daVar.f127502p.add(a0Var4);
                }
                return 0;
            case 14:
                daVar.f127503q = aVar3.i(intValue);
                return 0;
            case 15:
                LinkedList h28 = aVar3.h(intValue);
                int size7 = h28.size();
                for (int i29 = 0; i29 < size7; i29++) {
                    byte[] bArr8 = (byte[]) h28.get(i29);
                    vb vbVar3 = new vb();
                    if (bArr8 != null && bArr8.length > 0) {
                        vbVar3.a(bArr8);
                    }
                    daVar.f127504r = vbVar3;
                }
                return 0;
            case 16:
                daVar.f127505s = aVar3.a(intValue);
                return 0;
            case 17:
                daVar.f127506t = aVar3.i(intValue);
                return 0;
            case 18:
            default:
                return -1;
            case 19:
                LinkedList h29 = aVar3.h(intValue);
                int size8 = h29.size();
                for (int i36 = 0; i36 < size8; i36++) {
                    byte[] bArr9 = (byte[]) h29.get(i36);
                    w wVar3 = new w();
                    if (bArr9 != null && bArr9.length > 0) {
                        wVar3.a(bArr9);
                    }
                    daVar.f127507u = wVar3;
                }
                return 0;
        }
    }
}
