package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f129120e;

    /* renamed from: f, reason: collision with root package name */
    public l1 f129121f;

    /* renamed from: g, reason: collision with root package name */
    public int f129122g;

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
            wd wdVar = this.f129120e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f129120e.a(aVar);
            }
            l1 l1Var = this.f129121f;
            if (l1Var != null) {
                aVar.c(3, l1Var.a());
                this.f129121f.a(aVar);
            }
            aVar.b(4, this.f129122g);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f129120e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            l1 l1Var2 = this.f129121f;
            if (l1Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, l1Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f129122g);
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
        z3 z3Var = (z3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    z3Var.f129122g = aVar3.f(intValue);
                    return 0;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    l1 l1Var3 = new l1();
                    if (bArr != null && bArr.length > 0) {
                        l1Var3.a(bArr);
                    }
                    z3Var.f129121f = l1Var3;
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr2 = (byte[]) h17.get(i18);
                wd wdVar3 = new wd();
                if (bArr2 != null && bArr2.length > 0) {
                    wdVar3.a(bArr2);
                }
                z3Var.f129120e = wdVar3;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr3 = (byte[]) h18.get(i19);
            h0 h0Var3 = new h0();
            if (bArr3 != null && bArr3.length > 0) {
                h0Var3.a(bArr3);
            }
            z3Var.f128743d = h0Var3;
        }
        return 0;
    }
}
