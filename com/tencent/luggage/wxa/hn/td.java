package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class td extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public qd f128760d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128761e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            qd qdVar = this.f128760d;
            if (qdVar != null) {
                aVar.c(1, qdVar.a());
                this.f128760d.a(aVar);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128761e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            qd qdVar2 = this.f128760d;
            if (qdVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, qdVar2.a());
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128761e;
            if (cVar2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(2, cVar2);
            }
            return i16;
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
        td tdVar = (td) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            tdVar.f128761e = aVar3.b(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            qd qdVar3 = new qd();
            if (bArr != null && bArr.length > 0) {
                qdVar3.a(bArr);
            }
            tdVar.f128760d = qdVar3;
        }
        return 0;
    }
}
