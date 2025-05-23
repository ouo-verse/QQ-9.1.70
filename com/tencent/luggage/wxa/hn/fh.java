package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class fh extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127643e;

    /* renamed from: f, reason: collision with root package name */
    public String f127644f;

    /* renamed from: g, reason: collision with root package name */
    public int f127645g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127646h;

    /* renamed from: i, reason: collision with root package name */
    public String f127647i;

    /* renamed from: j, reason: collision with root package name */
    public int f127648j;

    /* renamed from: k, reason: collision with root package name */
    public int f127649k;

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
            String str = this.f127643e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127644f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127645g);
            com.tencent.luggage.wxa.fn.c cVar = this.f127646h;
            if (cVar != null) {
                aVar.a(5, cVar);
            }
            String str3 = this.f127647i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            aVar.b(7, this.f127648j);
            aVar.b(8, this.f127649k);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str4 = this.f127643e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127644f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127645g);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127646h;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, cVar2);
            }
            String str6 = this.f127647i;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str6);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f127648j) + com.tencent.luggage.wxa.gr.a.b(8, this.f127649k);
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
        fh fhVar = (fh) objArr[1];
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
                    fhVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                fhVar.f127643e = aVar3.i(intValue);
                return 0;
            case 3:
                fhVar.f127644f = aVar3.i(intValue);
                return 0;
            case 4:
                fhVar.f127645g = aVar3.f(intValue);
                return 0;
            case 5:
                fhVar.f127646h = aVar3.b(intValue);
                return 0;
            case 6:
                fhVar.f127647i = aVar3.i(intValue);
                return 0;
            case 7:
                fhVar.f127648j = aVar3.f(intValue);
                return 0;
            case 8:
                fhVar.f127649k = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
