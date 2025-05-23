package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class xh extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f129047d;

    /* renamed from: e, reason: collision with root package name */
    public String f129048e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f129047d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f129047d.a(aVar);
            }
            String str = this.f129048e;
            if (str != null) {
                aVar.a(2, str);
            }
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f129047d;
            if (phVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
            }
            String str2 = this.f129048e;
            if (str2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(2, str2);
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
        xh xhVar = (xh) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            xhVar.f129048e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            ph phVar3 = new ph();
            if (bArr != null && bArr.length > 0) {
                phVar3.a(bArr);
            }
            xhVar.f129047d = phVar3;
        }
        return 0;
    }
}
