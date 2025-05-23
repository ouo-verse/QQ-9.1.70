package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public int f128558e;

    /* renamed from: f, reason: collision with root package name */
    public String f128559f;

    /* renamed from: g, reason: collision with root package name */
    public int f128560g;

    /* renamed from: h, reason: collision with root package name */
    public String f128561h;

    /* renamed from: i, reason: collision with root package name */
    public l7 f128562i;

    /* renamed from: k, reason: collision with root package name */
    public String f128564k;

    /* renamed from: l, reason: collision with root package name */
    public String f128565l;

    /* renamed from: m, reason: collision with root package name */
    public int f128566m;

    /* renamed from: n, reason: collision with root package name */
    public String f128567n;

    /* renamed from: o, reason: collision with root package name */
    public String f128568o;

    /* renamed from: p, reason: collision with root package name */
    public String f128569p;

    /* renamed from: q, reason: collision with root package name */
    public String f128570q;

    /* renamed from: j, reason: collision with root package name */
    public LinkedList f128563j = new LinkedList();

    /* renamed from: r, reason: collision with root package name */
    public LinkedList f128571r = new LinkedList();

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
            aVar.b(2, this.f128558e);
            String str = this.f128559f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.b(4, this.f128560g);
            String str2 = this.f128561h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            l7 l7Var = this.f128562i;
            if (l7Var != null) {
                aVar.c(6, l7Var.a());
                this.f128562i.a(aVar);
            }
            aVar.a(7, 8, this.f128563j);
            String str3 = this.f128564k;
            if (str3 != null) {
                aVar.a(8, str3);
            }
            String str4 = this.f128565l;
            if (str4 != null) {
                aVar.a(9, str4);
            }
            aVar.b(10, this.f128566m);
            String str5 = this.f128567n;
            if (str5 != null) {
                aVar.a(11, str5);
            }
            String str6 = this.f128568o;
            if (str6 != null) {
                aVar.a(12, str6);
            }
            String str7 = this.f128569p;
            if (str7 != null) {
                aVar.a(13, str7);
            }
            String str8 = this.f128570q;
            if (str8 != null) {
                aVar.a(14, str8);
            }
            aVar.a(16, 8, this.f128571r);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128558e);
            String str9 = this.f128559f;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128560g);
            String str10 = this.f128561h;
            if (str10 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, str10);
            }
            l7 l7Var2 = this.f128562i;
            if (l7Var2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.c(6, l7Var2.a());
            }
            int a16 = b17 + com.tencent.luggage.wxa.gr.a.a(7, 8, this.f128563j);
            String str11 = this.f128564k;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str11);
            }
            String str12 = this.f128565l;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str12);
            }
            int b18 = a16 + com.tencent.luggage.wxa.gr.a.b(10, this.f128566m);
            String str13 = this.f128567n;
            if (str13 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(11, str13);
            }
            String str14 = this.f128568o;
            if (str14 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(12, str14);
            }
            String str15 = this.f128569p;
            if (str15 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(13, str15);
            }
            String str16 = this.f128570q;
            if (str16 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(14, str16);
            }
            return b18 + com.tencent.luggage.wxa.gr.a.a(16, 8, this.f128571r);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128563j.clear();
            this.f128571r.clear();
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
        r3 r3Var = (r3) objArr[1];
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
                    r3Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                r3Var.f128558e = aVar3.f(intValue);
                return 0;
            case 3:
                r3Var.f128559f = aVar3.i(intValue);
                return 0;
            case 4:
                r3Var.f128560g = aVar3.f(intValue);
                return 0;
            case 5:
                r3Var.f128561h = aVar3.i(intValue);
                return 0;
            case 6:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    l7 l7Var3 = new l7();
                    if (bArr3 != null && bArr3.length > 0) {
                        l7Var3.a(bArr3);
                    }
                    r3Var.f128562i = l7Var3;
                }
                return 0;
            case 7:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    w6 w6Var = new w6();
                    if (bArr4 != null && bArr4.length > 0) {
                        w6Var.a(bArr4);
                    }
                    r3Var.f128563j.add(w6Var);
                }
                return 0;
            case 8:
                r3Var.f128564k = aVar3.i(intValue);
                return 0;
            case 9:
                r3Var.f128565l = aVar3.i(intValue);
                return 0;
            case 10:
                r3Var.f128566m = aVar3.f(intValue);
                return 0;
            case 11:
                r3Var.f128567n = aVar3.i(intValue);
                return 0;
            case 12:
                r3Var.f128568o = aVar3.i(intValue);
                return 0;
            case 13:
                r3Var.f128569p = aVar3.i(intValue);
                return 0;
            case 14:
                r3Var.f128570q = aVar3.i(intValue);
                return 0;
            case 15:
            default:
                return -1;
            case 16:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    wf wfVar = new wf();
                    if (bArr5 != null && bArr5.length > 0) {
                        wfVar.a(bArr5);
                    }
                    r3Var.f128571r.add(wfVar);
                }
                return 0;
        }
    }
}
