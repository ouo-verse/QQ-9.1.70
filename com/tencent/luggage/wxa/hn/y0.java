package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y0 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f129051e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f129052f;

    /* renamed from: g, reason: collision with root package name */
    public String f129053g;

    /* renamed from: h, reason: collision with root package name */
    public String f129054h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f129055i;

    /* renamed from: j, reason: collision with root package name */
    public String f129056j;

    /* renamed from: k, reason: collision with root package name */
    public String f129057k;

    /* renamed from: l, reason: collision with root package name */
    public String f129058l;

    /* renamed from: m, reason: collision with root package name */
    public String f129059m;

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
            wd wdVar = this.f129051e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f129051e.a(aVar);
            }
            aVar.a(3, this.f129052f);
            String str = this.f129053g;
            if (str != null) {
                aVar.a(4, str);
            }
            String str2 = this.f129054h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            aVar.a(6, this.f129055i);
            String str3 = this.f129056j;
            if (str3 != null) {
                aVar.a(7, str3);
            }
            String str4 = this.f129057k;
            if (str4 != null) {
                aVar.a(8, str4);
            }
            String str5 = this.f129058l;
            if (str5 != null) {
                aVar.a(9, str5);
            }
            String str6 = this.f129059m;
            if (str6 != null) {
                aVar.a(10, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f129051e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, this.f129052f);
            String str7 = this.f129053g;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f129054h;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            int a17 = a16 + com.tencent.luggage.wxa.gr.a.a(6, this.f129055i);
            String str9 = this.f129056j;
            if (str9 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(7, str9);
            }
            String str10 = this.f129057k;
            if (str10 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(8, str10);
            }
            String str11 = this.f129058l;
            if (str11 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(9, str11);
            }
            String str12 = this.f129059m;
            if (str12 != null) {
                return a17 + com.tencent.luggage.wxa.gr.a.a(10, str12);
            }
            return a17;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        y0 y0Var = (y0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    y0Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    wd wdVar3 = new wd();
                    if (bArr2 != null && bArr2.length > 0) {
                        wdVar3.a(bArr2);
                    }
                    y0Var.f129051e = wdVar3;
                }
                return 0;
            case 3:
                y0Var.f129052f = aVar3.a(intValue);
                return 0;
            case 4:
                y0Var.f129053g = aVar3.i(intValue);
                return 0;
            case 5:
                y0Var.f129054h = aVar3.i(intValue);
                return 0;
            case 6:
                y0Var.f129055i = aVar3.a(intValue);
                return 0;
            case 7:
                y0Var.f129056j = aVar3.i(intValue);
                return 0;
            case 8:
                y0Var.f129057k = aVar3.i(intValue);
                return 0;
            case 9:
                y0Var.f129058l = aVar3.i(intValue);
                return 0;
            case 10:
                y0Var.f129059m = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
