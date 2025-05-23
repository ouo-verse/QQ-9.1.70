package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i1 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127827e;

    /* renamed from: f, reason: collision with root package name */
    public String f127828f;

    /* renamed from: g, reason: collision with root package name */
    public int f127829g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127830h;

    /* renamed from: i, reason: collision with root package name */
    public LinkedList f127831i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public int f127832j;

    /* renamed from: k, reason: collision with root package name */
    public String f127833k;

    /* renamed from: l, reason: collision with root package name */
    public long f127834l;

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
            aVar.b(2, this.f127827e);
            String str = this.f127828f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.b(4, this.f127829g);
            com.tencent.luggage.wxa.fn.c cVar = this.f127830h;
            if (cVar != null) {
                aVar.a(5, cVar);
            }
            aVar.a(6, 8, this.f127831i);
            aVar.b(7, this.f127832j);
            String str2 = this.f127833k;
            if (str2 != null) {
                aVar.a(8, str2);
            }
            aVar.a(9, this.f127834l);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127827e);
            String str3 = this.f127828f;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str3);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127829g);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127830h;
            if (cVar2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, cVar2);
            }
            int a16 = b17 + com.tencent.luggage.wxa.gr.a.a(6, 8, this.f127831i) + com.tencent.luggage.wxa.gr.a.b(7, this.f127832j);
            String str4 = this.f127833k;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str4);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(9, this.f127834l);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127831i.clear();
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
        i1 i1Var = (i1) objArr[1];
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
                    i1Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                i1Var.f127827e = aVar3.f(intValue);
                return 0;
            case 3:
                i1Var.f127828f = aVar3.i(intValue);
                return 0;
            case 4:
                i1Var.f127829g = aVar3.f(intValue);
                return 0;
            case 5:
                i1Var.f127830h = aVar3.b(intValue);
                return 0;
            case 6:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    b2 b2Var = new b2();
                    if (bArr3 != null && bArr3.length > 0) {
                        b2Var.a(bArr3);
                    }
                    i1Var.f127831i.add(b2Var);
                }
                return 0;
            case 7:
                i1Var.f127832j = aVar3.f(intValue);
                return 0;
            case 8:
                i1Var.f127833k = aVar3.i(intValue);
                return 0;
            case 9:
                i1Var.f127834l = aVar3.g(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
