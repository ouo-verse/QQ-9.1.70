package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k9 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128015e;

    /* renamed from: f, reason: collision with root package name */
    public String f128016f;

    /* renamed from: g, reason: collision with root package name */
    public int f128017g;

    /* renamed from: h, reason: collision with root package name */
    public int f128018h;

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
            String str = this.f128015e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128016f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128017g);
            aVar.b(5, this.f128018h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str3 = this.f128015e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            String str4 = this.f128016f;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128017g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128018h);
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
        k9 k9Var = (k9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        k9Var.f128018h = aVar3.f(intValue);
                        return 0;
                    }
                    k9Var.f128017g = aVar3.f(intValue);
                    return 0;
                }
                k9Var.f128016f = aVar3.i(intValue);
                return 0;
            }
            k9Var.f128015e = aVar3.i(intValue);
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
            k9Var.f128671d = g0Var3;
        }
        return 0;
    }
}
