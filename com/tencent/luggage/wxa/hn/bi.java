package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class bi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f127369d;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f127369d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f127369d.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f127369d;
            if (phVar2 == null) {
                return 0;
            }
            return 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
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
        bi biVar = (bi) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            return -1;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i16 = 0; i16 < size; i16++) {
            byte[] bArr = (byte[]) h16.get(i16);
            ph phVar3 = new ph();
            if (bArr != null && bArr.length > 0) {
                phVar3.a(bArr);
            }
            biVar.f127369d = phVar3;
        }
        return 0;
    }
}
