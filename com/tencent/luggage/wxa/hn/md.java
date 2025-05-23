package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class md extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public yb f128204d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128205e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public int f128206f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            yb ybVar = this.f128204d;
            if (ybVar != null) {
                aVar.c(1, ybVar.a());
                this.f128204d.a(aVar);
            }
            aVar.a(2, 8, this.f128205e);
            aVar.b(3, this.f128206f);
            return 0;
        }
        if (i3 == 1) {
            yb ybVar2 = this.f128204d;
            if (ybVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, ybVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128205e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128206f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128205e.clear();
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
        md mdVar = (md) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                mdVar.f128206f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                ic icVar = new ic();
                if (bArr2 != null && bArr2.length > 0) {
                    icVar.a(bArr2);
                }
                mdVar.f128205e.add(icVar);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            yb ybVar3 = new yb();
            if (bArr3 != null && bArr3.length > 0) {
                ybVar3.a(bArr3);
            }
            mdVar.f128204d = ybVar3;
        }
        return 0;
    }
}
