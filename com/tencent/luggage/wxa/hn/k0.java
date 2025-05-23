package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k0 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127973e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127974f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public int f127975g;

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
            aVar.b(2, this.f127973e);
            aVar.a(3, 8, this.f127974f);
            aVar.b(4, this.f127975g);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127973e) + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127974f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127975g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127974f.clear();
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
        k0 k0Var = (k0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    k0Var.f127975g = aVar3.f(intValue);
                    return 0;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    k3 k3Var = new k3();
                    if (bArr2 != null && bArr2.length > 0) {
                        k3Var.a(bArr2);
                    }
                    k0Var.f127974f.add(k3Var);
                }
                return 0;
            }
            k0Var.f127973e = aVar3.f(intValue);
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            g0 g0Var3 = new g0();
            if (bArr3 != null && bArr3.length > 0) {
                g0Var3.a(bArr3);
            }
            k0Var.f128671d = g0Var3;
        }
        return 0;
    }
}
