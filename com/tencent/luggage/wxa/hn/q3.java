package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q3 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f128480e;

    /* renamed from: f, reason: collision with root package name */
    public String f128481f;

    /* renamed from: g, reason: collision with root package name */
    public int f128482g;

    /* renamed from: h, reason: collision with root package name */
    public String f128483h;

    /* renamed from: i, reason: collision with root package name */
    public int f128484i;

    /* renamed from: j, reason: collision with root package name */
    public int f128485j;

    /* renamed from: k, reason: collision with root package name */
    public String f128486k;

    /* renamed from: l, reason: collision with root package name */
    public l7 f128487l;

    /* renamed from: m, reason: collision with root package name */
    public LinkedList f128488m = new LinkedList();

    /* renamed from: n, reason: collision with root package name */
    public int f128489n;

    /* renamed from: o, reason: collision with root package name */
    public String f128490o;

    /* renamed from: p, reason: collision with root package name */
    public String f128491p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f128492q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f128493r;

    /* renamed from: s, reason: collision with root package name */
    public int f128494s;

    /* renamed from: t, reason: collision with root package name */
    public k1 f128495t;

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
            aVar.b(2, this.f128480e);
            String str = this.f128481f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.b(4, this.f128482g);
            String str2 = this.f128483h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            aVar.b(6, this.f128484i);
            aVar.b(7, this.f128485j);
            String str3 = this.f128486k;
            if (str3 != null) {
                aVar.a(8, str3);
            }
            l7 l7Var = this.f128487l;
            if (l7Var != null) {
                aVar.c(10, l7Var.a());
                this.f128487l.a(aVar);
            }
            aVar.a(12, 8, this.f128488m);
            aVar.b(13, this.f128489n);
            String str4 = this.f128490o;
            if (str4 != null) {
                aVar.a(14, str4);
            }
            String str5 = this.f128491p;
            if (str5 != null) {
                aVar.a(15, str5);
            }
            aVar.a(16, this.f128492q);
            aVar.a(17, this.f128493r);
            aVar.b(18, this.f128494s);
            k1 k1Var = this.f128495t;
            if (k1Var != null) {
                aVar.c(19, k1Var.a());
                this.f128495t.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a()) + 0;
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128480e);
            String str6 = this.f128481f;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128482g);
            String str7 = this.f128483h;
            if (str7 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, str7);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(6, this.f128484i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128485j);
            String str8 = this.f128486k;
            if (str8 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(8, str8);
            }
            l7 l7Var2 = this.f128487l;
            if (l7Var2 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.c(10, l7Var2.a());
            }
            int a16 = b18 + com.tencent.luggage.wxa.gr.a.a(12, 8, this.f128488m) + com.tencent.luggage.wxa.gr.a.b(13, this.f128489n);
            String str9 = this.f128490o;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(14, str9);
            }
            String str10 = this.f128491p;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(15, str10);
            }
            int a17 = a16 + com.tencent.luggage.wxa.gr.a.a(16, this.f128492q) + com.tencent.luggage.wxa.gr.a.a(17, this.f128493r) + com.tencent.luggage.wxa.gr.a.b(18, this.f128494s);
            k1 k1Var2 = this.f128495t;
            if (k1Var2 != null) {
                return a17 + com.tencent.luggage.wxa.gr.a.c(19, k1Var2.a());
            }
            return a17;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128488m.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        q3 q3Var = (q3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr2 != null && bArr2.length > 0) {
                        g0Var3.a(bArr2);
                    }
                    q3Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                q3Var.f128480e = aVar3.f(intValue);
                return 0;
            case 3:
                q3Var.f128481f = aVar3.i(intValue);
                return 0;
            case 4:
                q3Var.f128482g = aVar3.f(intValue);
                return 0;
            case 5:
                q3Var.f128483h = aVar3.i(intValue);
                return 0;
            case 6:
                q3Var.f128484i = aVar3.f(intValue);
                return 0;
            case 7:
                q3Var.f128485j = aVar3.f(intValue);
                return 0;
            case 8:
                q3Var.f128486k = aVar3.i(intValue);
                return 0;
            case 9:
            case 11:
            default:
                return -1;
            case 10:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    l7 l7Var3 = new l7();
                    if (bArr3 != null && bArr3.length > 0) {
                        l7Var3.a(bArr3);
                    }
                    q3Var.f128487l = l7Var3;
                }
                return 0;
            case 12:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    x6 x6Var = new x6();
                    if (bArr4 != null && bArr4.length > 0) {
                        x6Var.a(bArr4);
                    }
                    q3Var.f128488m.add(x6Var);
                }
                return 0;
            case 13:
                q3Var.f128489n = aVar3.f(intValue);
                return 0;
            case 14:
                q3Var.f128490o = aVar3.i(intValue);
                return 0;
            case 15:
                q3Var.f128491p = aVar3.i(intValue);
                return 0;
            case 16:
                q3Var.f128492q = aVar3.a(intValue);
                return 0;
            case 17:
                q3Var.f128493r = aVar3.a(intValue);
                return 0;
            case 18:
                q3Var.f128494s = aVar3.f(intValue);
                return 0;
            case 19:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    k1 k1Var3 = new k1();
                    if (bArr5 != null && bArr5.length > 0) {
                        k1Var3.a(bArr5);
                    }
                    q3Var.f128495t = k1Var3;
                }
                return 0;
        }
    }
}
