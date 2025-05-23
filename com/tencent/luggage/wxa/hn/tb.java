package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class tb extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128750e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128751f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public String f128752g;

    /* renamed from: h, reason: collision with root package name */
    public String f128753h;

    /* renamed from: i, reason: collision with root package name */
    public String f128754i;

    /* renamed from: j, reason: collision with root package name */
    public String f128755j;

    /* renamed from: k, reason: collision with root package name */
    public String f128756k;

    /* renamed from: l, reason: collision with root package name */
    public String f128757l;

    /* renamed from: m, reason: collision with root package name */
    public String f128758m;

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
            String str = this.f128750e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 2, this.f128751f);
            String str2 = this.f128752g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128753h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128754i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f128755j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            String str6 = this.f128756k;
            if (str6 != null) {
                aVar.a(8, str6);
            }
            String str7 = this.f128757l;
            if (str7 != null) {
                aVar.a(9, str7);
            }
            String str8 = this.f128758m;
            if (str8 != null) {
                aVar.a(10, str8);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str9 = this.f128750e;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str9);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 2, this.f128751f);
            String str10 = this.f128752g;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f128753h;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f128754i;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str12);
            }
            String str13 = this.f128755j;
            if (str13 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str13);
            }
            String str14 = this.f128756k;
            if (str14 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str14);
            }
            String str15 = this.f128757l;
            if (str15 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str15);
            }
            String str16 = this.f128758m;
            if (str16 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(10, str16);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128751f.clear();
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
        tb tbVar = (tb) objArr[1];
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
                    tbVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                tbVar.f128750e = aVar3.i(intValue);
                return 0;
            case 3:
                tbVar.f128751f.add(Integer.valueOf(aVar3.f(intValue)));
                return 0;
            case 4:
                tbVar.f128752g = aVar3.i(intValue);
                return 0;
            case 5:
                tbVar.f128753h = aVar3.i(intValue);
                return 0;
            case 6:
                tbVar.f128754i = aVar3.i(intValue);
                return 0;
            case 7:
                tbVar.f128755j = aVar3.i(intValue);
                return 0;
            case 8:
                tbVar.f128756k = aVar3.i(intValue);
                return 0;
            case 9:
                tbVar.f128757l = aVar3.i(intValue);
                return 0;
            case 10:
                tbVar.f128758m = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
