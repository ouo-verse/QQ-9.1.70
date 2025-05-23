package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128506d;

    /* renamed from: e, reason: collision with root package name */
    public int f128507e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128508f = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128506d);
            aVar.b(2, this.f128507e);
            aVar.a(3, 8, this.f128508f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f128506d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128507e) + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128508f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128508f.clear();
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
        q7 q7Var = (q7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    qa qaVar = new qa();
                    if (bArr2 != null && bArr2.length > 0) {
                        qaVar.a(bArr2);
                    }
                    q7Var.f128508f.add(qaVar);
                }
                return 0;
            }
            q7Var.f128507e = aVar3.f(intValue);
            return 0;
        }
        q7Var.f128506d = aVar3.f(intValue);
        return 0;
    }
}
