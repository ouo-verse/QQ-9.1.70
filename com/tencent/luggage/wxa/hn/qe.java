package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class qe extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128525e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128526f;

    /* renamed from: g, reason: collision with root package name */
    public String f128527g;

    /* renamed from: h, reason: collision with root package name */
    public String f128528h;

    /* renamed from: i, reason: collision with root package name */
    public int f128529i;

    /* renamed from: j, reason: collision with root package name */
    public k1 f128530j;

    /* renamed from: k, reason: collision with root package name */
    public xe f128531k;

    /* renamed from: l, reason: collision with root package name */
    public String f128532l;

    /* renamed from: m, reason: collision with root package name */
    public String f128533m;

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
            String str = this.f128525e;
            if (str != null) {
                aVar.a(2, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128526f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            String str2 = this.f128527g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128528h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            aVar.b(6, this.f128529i);
            k1 k1Var = this.f128530j;
            if (k1Var != null) {
                aVar.c(7, k1Var.a());
                this.f128530j.a(aVar);
            }
            xe xeVar = this.f128531k;
            if (xeVar != null) {
                aVar.c(8, xeVar.a());
                this.f128531k.a(aVar);
            }
            String str4 = this.f128532l;
            if (str4 != null) {
                aVar.a(9, str4);
            }
            String str5 = this.f128533m;
            if (str5 != null) {
                aVar.a(10, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str6 = this.f128525e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128526f;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, cVar2);
            }
            String str7 = this.f128527g;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f128528h;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(6, this.f128529i);
            k1 k1Var2 = this.f128530j;
            if (k1Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(7, k1Var2.a());
            }
            xe xeVar2 = this.f128531k;
            if (xeVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(8, xeVar2.a());
            }
            String str9 = this.f128532l;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str9);
            }
            String str10 = this.f128533m;
            if (str10 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(10, str10);
            }
            return b16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        qe qeVar = (qe) objArr[1];
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
                    qeVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                qeVar.f128525e = aVar3.i(intValue);
                return 0;
            case 3:
                qeVar.f128526f = aVar3.b(intValue);
                return 0;
            case 4:
                qeVar.f128527g = aVar3.i(intValue);
                return 0;
            case 5:
                qeVar.f128528h = aVar3.i(intValue);
                return 0;
            case 6:
                qeVar.f128529i = aVar3.f(intValue);
                return 0;
            case 7:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    k1 k1Var3 = new k1();
                    if (bArr2 != null && bArr2.length > 0) {
                        k1Var3.a(bArr2);
                    }
                    qeVar.f128530j = k1Var3;
                }
                return 0;
            case 8:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    xe xeVar3 = new xe();
                    if (bArr3 != null && bArr3.length > 0) {
                        xeVar3.a(bArr3);
                    }
                    qeVar.f128531k = xeVar3;
                }
                return 0;
            case 9:
                qeVar.f128532l = aVar3.i(intValue);
                return 0;
            case 10:
                qeVar.f128533m = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
