package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127681d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127682e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public String f127683f;

    /* renamed from: g, reason: collision with root package name */
    public String f127684g;

    /* renamed from: h, reason: collision with root package name */
    public String f127685h;

    /* renamed from: i, reason: collision with root package name */
    public String f127686i;

    /* renamed from: j, reason: collision with root package name */
    public int f127687j;

    /* renamed from: k, reason: collision with root package name */
    public int f127688k;

    /* renamed from: l, reason: collision with root package name */
    public String f127689l;

    /* renamed from: m, reason: collision with root package name */
    public String f127690m;

    /* renamed from: n, reason: collision with root package name */
    public String f127691n;

    /* renamed from: o, reason: collision with root package name */
    public int f127692o;

    /* renamed from: p, reason: collision with root package name */
    public int f127693p;

    /* renamed from: q, reason: collision with root package name */
    public String f127694q;

    /* renamed from: r, reason: collision with root package name */
    public String f127695r;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127681d);
            aVar.a(2, 8, this.f127682e);
            String str = this.f127683f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f127684g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127685h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127686i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            aVar.b(7, this.f127687j);
            aVar.b(8, this.f127688k);
            String str5 = this.f127689l;
            if (str5 != null) {
                aVar.a(9, str5);
            }
            String str6 = this.f127690m;
            if (str6 != null) {
                aVar.a(10, str6);
            }
            String str7 = this.f127691n;
            if (str7 != null) {
                aVar.a(11, str7);
            }
            aVar.b(12, this.f127692o);
            aVar.b(13, this.f127693p);
            String str8 = this.f127694q;
            if (str8 != null) {
                aVar.a(14, str8);
            }
            String str9 = this.f127695r;
            if (str9 != null) {
                aVar.a(15, str9);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127681d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127682e);
            String str10 = this.f127683f;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str10);
            }
            String str11 = this.f127684g;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str11);
            }
            String str12 = this.f127685h;
            if (str12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str12);
            }
            String str13 = this.f127686i;
            if (str13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str13);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f127687j) + com.tencent.luggage.wxa.gr.a.b(8, this.f127688k);
            String str14 = this.f127689l;
            if (str14 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str14);
            }
            String str15 = this.f127690m;
            if (str15 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(10, str15);
            }
            String str16 = this.f127691n;
            if (str16 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str16);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(12, this.f127692o) + com.tencent.luggage.wxa.gr.a.b(13, this.f127693p);
            String str17 = this.f127694q;
            if (str17 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(14, str17);
            }
            String str18 = this.f127695r;
            if (str18 != null) {
                return b18 + com.tencent.luggage.wxa.gr.a.a(15, str18);
            }
            return b18;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127682e.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        g8 g8Var = (g8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                g8Var.f127681d = aVar3.f(intValue);
                return 0;
            case 2:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    h8 h8Var = new h8();
                    if (bArr2 != null && bArr2.length > 0) {
                        h8Var.a(bArr2);
                    }
                    g8Var.f127682e.add(h8Var);
                }
                return 0;
            case 3:
                g8Var.f127683f = aVar3.i(intValue);
                return 0;
            case 4:
                g8Var.f127684g = aVar3.i(intValue);
                return 0;
            case 5:
                g8Var.f127685h = aVar3.i(intValue);
                return 0;
            case 6:
                g8Var.f127686i = aVar3.i(intValue);
                return 0;
            case 7:
                g8Var.f127687j = aVar3.f(intValue);
                return 0;
            case 8:
                g8Var.f127688k = aVar3.f(intValue);
                return 0;
            case 9:
                g8Var.f127689l = aVar3.i(intValue);
                return 0;
            case 10:
                g8Var.f127690m = aVar3.i(intValue);
                return 0;
            case 11:
                g8Var.f127691n = aVar3.i(intValue);
                return 0;
            case 12:
                g8Var.f127692o = aVar3.f(intValue);
                return 0;
            case 13:
                g8Var.f127693p = aVar3.f(intValue);
                return 0;
            case 14:
                g8Var.f127694q = aVar3.i(intValue);
                return 0;
            case 15:
                g8Var.f127695r = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
