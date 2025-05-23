package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q4 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128496d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128497e = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128496d);
            aVar.a(2, 1, this.f128497e);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128496d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, 1, this.f128497e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128496d.clear();
            this.f128497e.clear();
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
        q4 q4Var = (q4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            q4Var.f128497e.add(aVar3.i(intValue));
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i16 = 0; i16 < size; i16++) {
            byte[] bArr2 = (byte[]) h16.get(i16);
            n6 n6Var = new n6();
            if (bArr2 != null && bArr2.length > 0) {
                n6Var.a(bArr2);
            }
            q4Var.f128496d.add(n6Var);
        }
        return 0;
    }
}
