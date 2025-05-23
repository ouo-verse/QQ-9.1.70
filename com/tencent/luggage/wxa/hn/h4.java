package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h4 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f127746e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127747f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public lf f127748g;

    /* renamed from: h, reason: collision with root package name */
    public String f127749h;

    /* renamed from: i, reason: collision with root package name */
    public int f127750i;

    /* renamed from: j, reason: collision with root package name */
    public String f127751j;

    /* renamed from: k, reason: collision with root package name */
    public String f127752k;

    /* renamed from: l, reason: collision with root package name */
    public String f127753l;

    /* renamed from: m, reason: collision with root package name */
    public String f127754m;

    /* renamed from: n, reason: collision with root package name */
    public int f127755n;

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
            wd wdVar = this.f127746e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f127746e.a(aVar);
            }
            aVar.a(3, 8, this.f127747f);
            lf lfVar = this.f127748g;
            if (lfVar != null) {
                aVar.c(4, lfVar.a());
                this.f127748g.a(aVar);
            }
            String str = this.f127749h;
            if (str != null) {
                aVar.a(5, str);
            }
            aVar.b(6, this.f127750i);
            String str2 = this.f127751j;
            if (str2 != null) {
                aVar.a(7, str2);
            }
            String str3 = this.f127752k;
            if (str3 != null) {
                aVar.a(8, str3);
            }
            String str4 = this.f127753l;
            if (str4 != null) {
                aVar.a(9, str4);
            }
            String str5 = this.f127754m;
            if (str5 != null) {
                aVar.a(10, str5);
            }
            aVar.b(11, this.f127755n);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f127746e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127747f);
            lf lfVar2 = this.f127748g;
            if (lfVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(4, lfVar2.a());
            }
            String str6 = this.f127749h;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(6, this.f127750i);
            String str7 = this.f127751j;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str7);
            }
            String str8 = this.f127752k;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str8);
            }
            String str9 = this.f127753l;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str9);
            }
            String str10 = this.f127754m;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(10, str10);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(11, this.f127755n);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127747f.clear();
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
        h4 h4Var = (h4) objArr[1];
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
                    h4Var.f128743d = h0Var3;
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
                    h4Var.f127746e = wdVar3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    lf lfVar3 = new lf();
                    if (bArr4 != null && bArr4.length > 0) {
                        lfVar3.a(bArr4);
                    }
                    h4Var.f127747f.add(lfVar3);
                }
                return 0;
            case 4:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    lf lfVar4 = new lf();
                    if (bArr5 != null && bArr5.length > 0) {
                        lfVar4.a(bArr5);
                    }
                    h4Var.f127748g = lfVar4;
                }
                return 0;
            case 5:
                h4Var.f127749h = aVar3.i(intValue);
                return 0;
            case 6:
                h4Var.f127750i = aVar3.f(intValue);
                return 0;
            case 7:
                h4Var.f127751j = aVar3.i(intValue);
                return 0;
            case 8:
                h4Var.f127752k = aVar3.i(intValue);
                return 0;
            case 9:
                h4Var.f127753l = aVar3.i(intValue);
                return 0;
            case 10:
                h4Var.f127754m = aVar3.i(intValue);
                return 0;
            case 11:
                h4Var.f127755n = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
