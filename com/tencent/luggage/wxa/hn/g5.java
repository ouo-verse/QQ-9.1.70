package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127667e;

    /* renamed from: f, reason: collision with root package name */
    public String f127668f;

    /* renamed from: h, reason: collision with root package name */
    public String f127670h;

    /* renamed from: i, reason: collision with root package name */
    public String f127671i;

    /* renamed from: j, reason: collision with root package name */
    public String f127672j;

    /* renamed from: k, reason: collision with root package name */
    public String f127673k;

    /* renamed from: l, reason: collision with root package name */
    public int f127674l;

    /* renamed from: m, reason: collision with root package name */
    public String f127675m;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f127669g = new LinkedList();

    /* renamed from: n, reason: collision with root package name */
    public LinkedList f127676n = new LinkedList();

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
            String str = this.f127667e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127668f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.a(4, 1, this.f127669g);
            String str3 = this.f127670h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127671i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f127672j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            String str6 = this.f127673k;
            if (str6 != null) {
                aVar.a(8, str6);
            }
            aVar.b(9, this.f127674l);
            String str7 = this.f127675m;
            if (str7 != null) {
                aVar.a(10, str7);
            }
            aVar.a(11, 1, this.f127676n);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str8 = this.f127667e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            String str9 = this.f127668f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f127669g);
            String str10 = this.f127670h;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str10);
            }
            String str11 = this.f127671i;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str11);
            }
            String str12 = this.f127672j;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str12);
            }
            String str13 = this.f127673k;
            if (str13 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str13);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(9, this.f127674l);
            String str14 = this.f127675m;
            if (str14 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(10, str14);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(11, 1, this.f127676n);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127669g.clear();
            this.f127676n.clear();
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
        g5 g5Var = (g5) objArr[1];
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
                    g5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                g5Var.f127667e = aVar3.i(intValue);
                return 0;
            case 3:
                g5Var.f127668f = aVar3.i(intValue);
                return 0;
            case 4:
                g5Var.f127669g.add(aVar3.i(intValue));
                return 0;
            case 5:
                g5Var.f127670h = aVar3.i(intValue);
                return 0;
            case 6:
                g5Var.f127671i = aVar3.i(intValue);
                return 0;
            case 7:
                g5Var.f127672j = aVar3.i(intValue);
                return 0;
            case 8:
                g5Var.f127673k = aVar3.i(intValue);
                return 0;
            case 9:
                g5Var.f127674l = aVar3.f(intValue);
                return 0;
            case 10:
                g5Var.f127675m = aVar3.i(intValue);
                return 0;
            case 11:
                g5Var.f127676n.add(aVar3.i(intValue));
                return 0;
            default:
                return -1;
        }
    }
}
