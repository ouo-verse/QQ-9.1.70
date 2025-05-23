package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class he extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f127801d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127802e = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f127801d);
            aVar.a(2, 8, this.f127802e);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(1, 8, this.f127801d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127802e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127801d.clear();
            this.f127802e.clear();
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
        he heVar = (he) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr2 = (byte[]) h16.get(i16);
                b6 b6Var = new b6();
                if (bArr2 != null && bArr2.length > 0) {
                    b6Var.a(bArr2);
                }
                heVar.f127802e.add(b6Var);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i17 = 0; i17 < size2; i17++) {
            byte[] bArr3 = (byte[]) h17.get(i17);
            p7 p7Var = new p7();
            if (bArr3 != null && bArr3.length > 0) {
                p7Var.a(bArr3);
            }
            heVar.f127801d.add(p7Var);
        }
        return 0;
    }
}
