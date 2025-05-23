package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class jd extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public xb f127956d;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            xb xbVar = this.f127956d;
            if (xbVar != null) {
                aVar.c(1, xbVar.a());
                this.f127956d.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            xb xbVar2 = this.f127956d;
            if (xbVar2 == null) {
                return 0;
            }
            return 0 + com.tencent.luggage.wxa.gr.a.c(1, xbVar2.a());
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
        jd jdVar = (jd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            return -1;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i16 = 0; i16 < size; i16++) {
            byte[] bArr = (byte[]) h16.get(i16);
            xb xbVar3 = new xb();
            if (bArr != null && bArr.length > 0) {
                xbVar3.a(bArr);
            }
            jdVar.f127956d = xbVar3;
        }
        return 0;
    }
}
