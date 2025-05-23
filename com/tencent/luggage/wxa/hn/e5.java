package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f127545e;

    /* renamed from: f, reason: collision with root package name */
    public int f127546f;

    /* renamed from: g, reason: collision with root package name */
    public int f127547g;

    /* renamed from: h, reason: collision with root package name */
    public int f127548h;

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
            c5 c5Var = this.f127545e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f127545e.a(aVar);
            }
            aVar.b(3, this.f127546f);
            aVar.b(4, this.f127547g);
            aVar.b(5, this.f127548h);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            c5 c5Var2 = this.f127545e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127546f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127547g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127548h);
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
        e5 e5Var = (e5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        e5Var.f127548h = aVar3.f(intValue);
                        return 0;
                    }
                    e5Var.f127547g = aVar3.f(intValue);
                    return 0;
                }
                e5Var.f127546f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                c5 c5Var3 = new c5();
                if (bArr != null && bArr.length > 0) {
                    c5Var3.a(bArr);
                }
                e5Var.f127545e = c5Var3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            h0 h0Var3 = new h0();
            if (bArr2 != null && bArr2.length > 0) {
                h0Var3.a(bArr2);
            }
            e5Var.f128743d = h0Var3;
        }
        return 0;
    }
}
