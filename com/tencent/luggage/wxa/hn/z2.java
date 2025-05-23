package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z2 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f129119e = new LinkedList();

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
            aVar.a(2, 1, this.f129119e);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 1, this.f129119e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f129119e.clear();
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
        z2 z2Var = (z2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            z2Var.f129119e.add(aVar3.i(intValue));
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr2 = (byte[]) h16.get(i17);
            h0 h0Var3 = new h0();
            if (bArr2 != null && bArr2.length > 0) {
                h0Var3.a(bArr2);
            }
            z2Var.f128743d = h0Var3;
        }
        return 0;
    }
}
