package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c7 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127389e;

    /* renamed from: f, reason: collision with root package name */
    public int f127390f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f127391g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public int f127392h;

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
            String str = this.f127389e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f127390f);
            aVar.a(4, 1, this.f127391g);
            aVar.b(5, this.f127392h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str2 = this.f127389e;
            if (str2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127390f) + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f127391g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127392h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127391g.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        c7 c7Var = (c7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        c7Var.f127392h = aVar3.f(intValue);
                        return 0;
                    }
                    c7Var.f127391g.add(aVar3.i(intValue));
                    return 0;
                }
                c7Var.f127390f = aVar3.f(intValue);
                return 0;
            }
            c7Var.f127389e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr2 = (byte[]) h16.get(i17);
            g0 g0Var3 = new g0();
            if (bArr2 != null && bArr2.length > 0) {
                g0Var3.a(bArr2);
            }
            c7Var.f128671d = g0Var3;
        }
        return 0;
    }
}
