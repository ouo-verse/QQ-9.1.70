package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f129069e;

    /* renamed from: f, reason: collision with root package name */
    public int f129070f;

    /* renamed from: g, reason: collision with root package name */
    public gf f129071g;

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
            String str = this.f129069e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f129070f);
            gf gfVar = this.f129071g;
            if (gfVar != null) {
                aVar.c(4, gfVar.a());
                this.f129071g.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str2 = this.f129069e;
            if (str2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f129070f);
            gf gfVar2 = this.f129071g;
            if (gfVar2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(4, gfVar2.a());
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
        y5 y5Var = (y5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    LinkedList h16 = aVar3.h(intValue);
                    int size = h16.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        byte[] bArr = (byte[]) h16.get(i17);
                        gf gfVar3 = new gf();
                        if (bArr != null && bArr.length > 0) {
                            gfVar3.a(bArr);
                        }
                        y5Var.f129071g = gfVar3;
                    }
                    return 0;
                }
                y5Var.f129070f = aVar3.f(intValue);
                return 0;
            }
            y5Var.f129069e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            g0 g0Var3 = new g0();
            if (bArr2 != null && bArr2.length > 0) {
                g0Var3.a(bArr2);
            }
            y5Var.f128671d = g0Var3;
        }
        return 0;
    }
}
