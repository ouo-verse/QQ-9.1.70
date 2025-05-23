package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f129112d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f129113e = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            com.tencent.luggage.wxa.fn.c cVar = this.f129112d;
            if (cVar != null) {
                aVar.a(1, cVar);
            }
            aVar.a(2, 6, this.f129113e);
            return 0;
        }
        if (i3 == 1) {
            com.tencent.luggage.wxa.fn.c cVar2 = this.f129112d;
            if (cVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, cVar2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 6, this.f129113e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f129113e.clear();
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
        z0 z0Var = (z0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            z0Var.f129113e.add(aVar3.b(intValue));
            return 0;
        }
        z0Var.f129112d = aVar3.b(intValue);
        return 0;
    }
}
