package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d8 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127485e;

    /* renamed from: f, reason: collision with root package name */
    public String f127486f;

    /* renamed from: g, reason: collision with root package name */
    public String f127487g;

    /* renamed from: h, reason: collision with root package name */
    public int f127488h;

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
            aVar.b(2, this.f127485e);
            String str = this.f127486f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f127487g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            aVar.b(5, this.f127488h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127485e);
            String str3 = this.f127486f;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str3);
            }
            String str4 = this.f127487g;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127488h);
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
        d8 d8Var = (d8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        d8Var.f127488h = aVar3.f(intValue);
                        return 0;
                    }
                    d8Var.f127487g = aVar3.i(intValue);
                    return 0;
                }
                d8Var.f127486f = aVar3.i(intValue);
                return 0;
            }
            d8Var.f127485e = aVar3.f(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            g0 g0Var3 = new g0();
            if (bArr != null && bArr.length > 0) {
                g0Var3.a(bArr);
            }
            d8Var.f128671d = g0Var3;
        }
        return 0;
    }
}
