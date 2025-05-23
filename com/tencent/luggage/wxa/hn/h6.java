package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h6 extends s8 {
    public boolean A;

    /* renamed from: e, reason: collision with root package name */
    public String f127761e;

    /* renamed from: f, reason: collision with root package name */
    public vd f127762f;

    /* renamed from: g, reason: collision with root package name */
    public int f127763g;

    /* renamed from: h, reason: collision with root package name */
    public gg f127764h;

    /* renamed from: i, reason: collision with root package name */
    public xe f127765i;

    /* renamed from: j, reason: collision with root package name */
    public li f127766j;

    /* renamed from: k, reason: collision with root package name */
    public vf f127767k;

    /* renamed from: l, reason: collision with root package name */
    public hg f127768l;

    /* renamed from: m, reason: collision with root package name */
    public int f127769m;

    /* renamed from: n, reason: collision with root package name */
    public String f127770n;

    /* renamed from: o, reason: collision with root package name */
    public String f127771o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f127772p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f127773q;

    /* renamed from: r, reason: collision with root package name */
    public ig f127774r;

    /* renamed from: s, reason: collision with root package name */
    public b7 f127775s;

    /* renamed from: t, reason: collision with root package name */
    public String f127776t;

    /* renamed from: u, reason: collision with root package name */
    public k1 f127777u;

    /* renamed from: v, reason: collision with root package name */
    public ag f127778v;

    /* renamed from: w, reason: collision with root package name */
    public int f127779w;

    /* renamed from: x, reason: collision with root package name */
    public String f127780x;

    /* renamed from: y, reason: collision with root package name */
    public g6 f127781y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f127782z;

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
            String str = this.f127761e;
            if (str != null) {
                aVar.a(2, str);
            }
            vd vdVar = this.f127762f;
            if (vdVar != null) {
                aVar.c(3, vdVar.a());
                this.f127762f.a(aVar);
            }
            aVar.b(4, this.f127763g);
            gg ggVar = this.f127764h;
            if (ggVar != null) {
                aVar.c(5, ggVar.a());
                this.f127764h.a(aVar);
            }
            xe xeVar = this.f127765i;
            if (xeVar != null) {
                aVar.c(6, xeVar.a());
                this.f127765i.a(aVar);
            }
            li liVar = this.f127766j;
            if (liVar != null) {
                aVar.c(7, liVar.a());
                this.f127766j.a(aVar);
            }
            vf vfVar = this.f127767k;
            if (vfVar != null) {
                aVar.c(8, vfVar.a());
                this.f127767k.a(aVar);
            }
            hg hgVar = this.f127768l;
            if (hgVar != null) {
                aVar.c(9, hgVar.a());
                this.f127768l.a(aVar);
            }
            aVar.b(10, this.f127769m);
            String str2 = this.f127770n;
            if (str2 != null) {
                aVar.a(11, str2);
            }
            String str3 = this.f127771o;
            if (str3 != null) {
                aVar.a(12, str3);
            }
            aVar.a(13, this.f127772p);
            aVar.a(14, this.f127773q);
            ig igVar = this.f127774r;
            if (igVar != null) {
                aVar.c(15, igVar.a());
                this.f127774r.a(aVar);
            }
            b7 b7Var = this.f127775s;
            if (b7Var != null) {
                aVar.c(16, b7Var.a());
                this.f127775s.a(aVar);
            }
            String str4 = this.f127776t;
            if (str4 != null) {
                aVar.a(17, str4);
            }
            k1 k1Var = this.f127777u;
            if (k1Var != null) {
                aVar.c(18, k1Var.a());
                this.f127777u.a(aVar);
            }
            ag agVar = this.f127778v;
            if (agVar != null) {
                aVar.c(19, agVar.a());
                this.f127778v.a(aVar);
            }
            aVar.b(20, this.f127779w);
            String str5 = this.f127780x;
            if (str5 != null) {
                aVar.a(22, str5);
            }
            g6 g6Var = this.f127781y;
            if (g6Var != null) {
                aVar.c(23, g6Var.a());
                this.f127781y.a(aVar);
            }
            aVar.a(24, this.f127782z);
            aVar.a(25, this.A);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a()) + 0;
            }
            String str6 = this.f127761e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            vd vdVar2 = this.f127762f;
            if (vdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, vdVar2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127763g);
            gg ggVar2 = this.f127764h;
            if (ggVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(5, ggVar2.a());
            }
            xe xeVar2 = this.f127765i;
            if (xeVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(6, xeVar2.a());
            }
            li liVar2 = this.f127766j;
            if (liVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(7, liVar2.a());
            }
            vf vfVar2 = this.f127767k;
            if (vfVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(8, vfVar2.a());
            }
            hg hgVar2 = this.f127768l;
            if (hgVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(9, hgVar2.a());
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(10, this.f127769m);
            String str7 = this.f127770n;
            if (str7 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str7);
            }
            String str8 = this.f127771o;
            if (str8 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str8);
            }
            int a16 = b17 + com.tencent.luggage.wxa.gr.a.a(13, this.f127772p) + com.tencent.luggage.wxa.gr.a.a(14, this.f127773q);
            ig igVar2 = this.f127774r;
            if (igVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(15, igVar2.a());
            }
            b7 b7Var2 = this.f127775s;
            if (b7Var2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(16, b7Var2.a());
            }
            String str9 = this.f127776t;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(17, str9);
            }
            k1 k1Var2 = this.f127777u;
            if (k1Var2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(18, k1Var2.a());
            }
            ag agVar2 = this.f127778v;
            if (agVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(19, agVar2.a());
            }
            int b18 = a16 + com.tencent.luggage.wxa.gr.a.b(20, this.f127779w);
            String str10 = this.f127780x;
            if (str10 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(22, str10);
            }
            g6 g6Var2 = this.f127781y;
            if (g6Var2 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.c(23, g6Var2.a());
            }
            return b18 + com.tencent.luggage.wxa.gr.a.a(24, this.f127782z) + com.tencent.luggage.wxa.gr.a.a(25, this.A);
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
        h6 h6Var = (h6) objArr[1];
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
                    h6Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                h6Var.f127761e = aVar3.i(intValue);
                return 0;
            case 3:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    vd vdVar3 = new vd();
                    if (bArr2 != null && bArr2.length > 0) {
                        vdVar3.a(bArr2);
                    }
                    h6Var.f127762f = vdVar3;
                }
                return 0;
            case 4:
                h6Var.f127763g = aVar3.f(intValue);
                return 0;
            case 5:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    gg ggVar3 = new gg();
                    if (bArr3 != null && bArr3.length > 0) {
                        ggVar3.a(bArr3);
                    }
                    h6Var.f127764h = ggVar3;
                }
                return 0;
            case 6:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    xe xeVar3 = new xe();
                    if (bArr4 != null && bArr4.length > 0) {
                        xeVar3.a(bArr4);
                    }
                    h6Var.f127765i = xeVar3;
                }
                return 0;
            case 7:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr5 = (byte[]) h26.get(i27);
                    li liVar3 = new li();
                    if (bArr5 != null && bArr5.length > 0) {
                        liVar3.a(bArr5);
                    }
                    h6Var.f127766j = liVar3;
                }
                return 0;
            case 8:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr6 = (byte[]) h27.get(i28);
                    vf vfVar3 = new vf();
                    if (bArr6 != null && bArr6.length > 0) {
                        vfVar3.a(bArr6);
                    }
                    h6Var.f127767k = vfVar3;
                }
                return 0;
            case 9:
                LinkedList h28 = aVar3.h(intValue);
                int size7 = h28.size();
                for (int i29 = 0; i29 < size7; i29++) {
                    byte[] bArr7 = (byte[]) h28.get(i29);
                    hg hgVar3 = new hg();
                    if (bArr7 != null && bArr7.length > 0) {
                        hgVar3.a(bArr7);
                    }
                    h6Var.f127768l = hgVar3;
                }
                return 0;
            case 10:
                h6Var.f127769m = aVar3.f(intValue);
                return 0;
            case 11:
                h6Var.f127770n = aVar3.i(intValue);
                return 0;
            case 12:
                h6Var.f127771o = aVar3.i(intValue);
                return 0;
            case 13:
                h6Var.f127772p = aVar3.a(intValue);
                return 0;
            case 14:
                h6Var.f127773q = aVar3.a(intValue);
                return 0;
            case 15:
                LinkedList h29 = aVar3.h(intValue);
                int size8 = h29.size();
                for (int i36 = 0; i36 < size8; i36++) {
                    byte[] bArr8 = (byte[]) h29.get(i36);
                    ig igVar3 = new ig();
                    if (bArr8 != null && bArr8.length > 0) {
                        igVar3.a(bArr8);
                    }
                    h6Var.f127774r = igVar3;
                }
                return 0;
            case 16:
                LinkedList h36 = aVar3.h(intValue);
                int size9 = h36.size();
                for (int i37 = 0; i37 < size9; i37++) {
                    byte[] bArr9 = (byte[]) h36.get(i37);
                    b7 b7Var3 = new b7();
                    if (bArr9 != null && bArr9.length > 0) {
                        b7Var3.a(bArr9);
                    }
                    h6Var.f127775s = b7Var3;
                }
                return 0;
            case 17:
                h6Var.f127776t = aVar3.i(intValue);
                return 0;
            case 18:
                LinkedList h37 = aVar3.h(intValue);
                int size10 = h37.size();
                for (int i38 = 0; i38 < size10; i38++) {
                    byte[] bArr10 = (byte[]) h37.get(i38);
                    k1 k1Var3 = new k1();
                    if (bArr10 != null && bArr10.length > 0) {
                        k1Var3.a(bArr10);
                    }
                    h6Var.f127777u = k1Var3;
                }
                return 0;
            case 19:
                LinkedList h38 = aVar3.h(intValue);
                int size11 = h38.size();
                for (int i39 = 0; i39 < size11; i39++) {
                    byte[] bArr11 = (byte[]) h38.get(i39);
                    ag agVar3 = new ag();
                    if (bArr11 != null && bArr11.length > 0) {
                        agVar3.a(bArr11);
                    }
                    h6Var.f127778v = agVar3;
                }
                return 0;
            case 20:
                h6Var.f127779w = aVar3.f(intValue);
                return 0;
            case 21:
            default:
                return -1;
            case 22:
                h6Var.f127780x = aVar3.i(intValue);
                return 0;
            case 23:
                LinkedList h39 = aVar3.h(intValue);
                int size12 = h39.size();
                for (int i46 = 0; i46 < size12; i46++) {
                    byte[] bArr12 = (byte[]) h39.get(i46);
                    g6 g6Var3 = new g6();
                    if (bArr12 != null && bArr12.length > 0) {
                        g6Var3.a(bArr12);
                    }
                    h6Var.f127781y = g6Var3;
                }
                return 0;
            case 24:
                h6Var.f127782z = aVar3.a(intValue);
                return 0;
            case 25:
                h6Var.A = aVar3.a(intValue);
                return 0;
        }
    }
}
