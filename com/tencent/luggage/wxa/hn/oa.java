package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class oa extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128347e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public ra f128348f;

    /* renamed from: g, reason: collision with root package name */
    public String f128349g;

    /* renamed from: h, reason: collision with root package name */
    public String f128350h;

    /* renamed from: i, reason: collision with root package name */
    public int f128351i;

    /* renamed from: j, reason: collision with root package name */
    public int f128352j;

    /* renamed from: k, reason: collision with root package name */
    public int f128353k;

    /* renamed from: l, reason: collision with root package name */
    public int f128354l;

    /* renamed from: m, reason: collision with root package name */
    public int f128355m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128356n;

    /* renamed from: o, reason: collision with root package name */
    public int f128357o;

    /* renamed from: p, reason: collision with root package name */
    public String f128358p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f128359q;

    /* renamed from: r, reason: collision with root package name */
    public String f128360r;

    /* renamed from: s, reason: collision with root package name */
    public String f128361s;

    /* renamed from: t, reason: collision with root package name */
    public int f128362t;

    /* renamed from: u, reason: collision with root package name */
    public pa f128363u;

    /* renamed from: v, reason: collision with root package name */
    public int f128364v;

    /* renamed from: w, reason: collision with root package name */
    public String f128365w;

    /* renamed from: x, reason: collision with root package name */
    public int f128366x;

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
            aVar.a(2, 8, this.f128347e);
            ra raVar = this.f128348f;
            if (raVar != null) {
                aVar.c(3, raVar.a());
                this.f128348f.a(aVar);
            }
            String str = this.f128349g;
            if (str != null) {
                aVar.a(4, str);
            }
            String str2 = this.f128350h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            aVar.b(6, this.f128351i);
            aVar.b(9, this.f128352j);
            aVar.b(10, this.f128353k);
            aVar.b(11, this.f128354l);
            aVar.b(15, this.f128355m);
            com.tencent.luggage.wxa.fn.c cVar = this.f128356n;
            if (cVar != null) {
                aVar.a(16, cVar);
            }
            aVar.b(17, this.f128357o);
            String str3 = this.f128358p;
            if (str3 != null) {
                aVar.a(18, str3);
            }
            aVar.a(19, this.f128359q);
            String str4 = this.f128360r;
            if (str4 != null) {
                aVar.a(20, str4);
            }
            String str5 = this.f128361s;
            if (str5 != null) {
                aVar.a(21, str5);
            }
            aVar.b(22, this.f128362t);
            pa paVar = this.f128363u;
            if (paVar != null) {
                aVar.c(23, paVar.a());
                this.f128363u.a(aVar);
            }
            aVar.b(24, this.f128364v);
            String str6 = this.f128365w;
            if (str6 != null) {
                aVar.a(25, str6);
            }
            aVar.b(27, this.f128366x);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128347e);
            ra raVar2 = this.f128348f;
            if (raVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(3, raVar2.a());
            }
            String str7 = this.f128349g;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f128350h;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(6, this.f128351i) + com.tencent.luggage.wxa.gr.a.b(9, this.f128352j) + com.tencent.luggage.wxa.gr.a.b(10, this.f128353k) + com.tencent.luggage.wxa.gr.a.b(11, this.f128354l) + com.tencent.luggage.wxa.gr.a.b(15, this.f128355m);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128356n;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(16, cVar2);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(17, this.f128357o);
            String str9 = this.f128358p;
            if (str9 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(18, str9);
            }
            int a17 = b17 + com.tencent.luggage.wxa.gr.a.a(19, this.f128359q);
            String str10 = this.f128360r;
            if (str10 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(20, str10);
            }
            String str11 = this.f128361s;
            if (str11 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(21, str11);
            }
            int b18 = a17 + com.tencent.luggage.wxa.gr.a.b(22, this.f128362t);
            pa paVar2 = this.f128363u;
            if (paVar2 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.c(23, paVar2.a());
            }
            int b19 = b18 + com.tencent.luggage.wxa.gr.a.b(24, this.f128364v);
            String str12 = this.f128365w;
            if (str12 != null) {
                b19 += com.tencent.luggage.wxa.gr.a.a(25, str12);
            }
            return b19 + com.tencent.luggage.wxa.gr.a.b(27, this.f128366x);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128347e.clear();
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
        oa oaVar = (oa) objArr[1];
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
                    oaVar.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    ma maVar = new ma();
                    if (bArr3 != null && bArr3.length > 0) {
                        maVar.a(bArr3);
                    }
                    oaVar.f128347e.add(maVar);
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    ra raVar3 = new ra();
                    if (bArr4 != null && bArr4.length > 0) {
                        raVar3.a(bArr4);
                    }
                    oaVar.f128348f = raVar3;
                }
                return 0;
            case 4:
                oaVar.f128349g = aVar3.i(intValue);
                return 0;
            case 5:
                oaVar.f128350h = aVar3.i(intValue);
                return 0;
            case 6:
                oaVar.f128351i = aVar3.f(intValue);
                return 0;
            case 7:
            case 8:
            case 12:
            case 13:
            case 14:
            case 26:
            default:
                return -1;
            case 9:
                oaVar.f128352j = aVar3.f(intValue);
                return 0;
            case 10:
                oaVar.f128353k = aVar3.f(intValue);
                return 0;
            case 11:
                oaVar.f128354l = aVar3.f(intValue);
                return 0;
            case 15:
                oaVar.f128355m = aVar3.f(intValue);
                return 0;
            case 16:
                oaVar.f128356n = aVar3.b(intValue);
                return 0;
            case 17:
                oaVar.f128357o = aVar3.f(intValue);
                return 0;
            case 18:
                oaVar.f128358p = aVar3.i(intValue);
                return 0;
            case 19:
                oaVar.f128359q = aVar3.a(intValue);
                return 0;
            case 20:
                oaVar.f128360r = aVar3.i(intValue);
                return 0;
            case 21:
                oaVar.f128361s = aVar3.i(intValue);
                return 0;
            case 22:
                oaVar.f128362t = aVar3.f(intValue);
                return 0;
            case 23:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    pa paVar3 = new pa();
                    if (bArr5 != null && bArr5.length > 0) {
                        paVar3.a(bArr5);
                    }
                    oaVar.f128363u = paVar3;
                }
                return 0;
            case 24:
                oaVar.f128364v = aVar3.f(intValue);
                return 0;
            case 25:
                oaVar.f128365w = aVar3.i(intValue);
                return 0;
            case 27:
                oaVar.f128366x = aVar3.f(intValue);
                return 0;
        }
    }
}
