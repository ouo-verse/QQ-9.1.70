package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u3 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public double f128802e;

    /* renamed from: f, reason: collision with root package name */
    public double f128803f;

    /* renamed from: g, reason: collision with root package name */
    public String f128804g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f128805h;

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
            aVar.a(2, this.f128802e);
            aVar.a(3, this.f128803f);
            String str = this.f128804g;
            if (str != null) {
                aVar.a(4, str);
            }
            aVar.a(5, this.f128805h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f128802e) + com.tencent.luggage.wxa.gr.a.a(3, this.f128803f);
            String str2 = this.f128804g;
            if (str2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str2);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(5, this.f128805h);
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        u3 u3Var = (u3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        u3Var.f128805h = aVar3.a(intValue);
                        return 0;
                    }
                    u3Var.f128804g = aVar3.i(intValue);
                    return 0;
                }
                u3Var.f128803f = aVar3.c(intValue);
                return 0;
            }
            u3Var.f128802e = aVar3.c(intValue);
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
            u3Var.f128671d = g0Var3;
        }
        return 0;
    }
}
