package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class bd extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public yb f127355d;

    /* renamed from: e, reason: collision with root package name */
    public int f127356e;

    /* renamed from: f, reason: collision with root package name */
    public int f127357f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            yb ybVar = this.f127355d;
            if (ybVar != null) {
                aVar.c(1, ybVar.a());
                this.f127355d.a(aVar);
            }
            aVar.b(2, this.f127356e);
            aVar.b(3, this.f127357f);
            return 0;
        }
        if (i3 == 1) {
            yb ybVar2 = this.f127355d;
            if (ybVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, ybVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127356e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127357f);
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
        bd bdVar = (bd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                bdVar.f127357f = aVar3.f(intValue);
                return 0;
            }
            bdVar.f127356e = aVar3.f(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            yb ybVar3 = new yb();
            if (bArr != null && bArr.length > 0) {
                ybVar3.a(bArr);
            }
            bdVar.f127355d = ybVar3;
        }
        return 0;
    }
}
