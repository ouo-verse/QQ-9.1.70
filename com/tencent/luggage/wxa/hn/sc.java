package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class sc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128685d = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            ((com.tencent.luggage.wxa.mr.a) objArr[0]).a(1, 8, this.f128685d);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128685d) + 0;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128685d.clear();
            com.tencent.luggage.wxa.hr.a aVar = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar)) {
                if (!super.a(aVar, this, a16)) {
                    aVar.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar2 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        sc scVar = (sc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            return -1;
        }
        LinkedList h16 = aVar2.h(intValue);
        int size = h16.size();
        for (int i16 = 0; i16 < size; i16++) {
            byte[] bArr2 = (byte[]) h16.get(i16);
            ic icVar = new ic();
            if (bArr2 != null && bArr2.length > 0) {
                icVar.a(bArr2);
            }
            scVar.f128685d.add(icVar);
        }
        return 0;
    }
}
