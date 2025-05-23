package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127783d;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            ((com.tencent.luggage.wxa.mr.a) objArr[0]).b(1, this.f127783d);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127783d) + 0;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        h7 h7Var = (h7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            return -1;
        }
        h7Var.f127783d = aVar2.f(intValue);
        return 0;
    }
}
