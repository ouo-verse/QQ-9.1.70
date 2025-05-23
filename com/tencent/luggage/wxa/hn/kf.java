package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class kf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f128036d;

    /* renamed from: e, reason: collision with root package name */
    public int f128037e;

    /* renamed from: f, reason: collision with root package name */
    public double f128038f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f128036d);
            aVar.b(2, this.f128037e);
            aVar.a(3, this.f128038f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(1, this.f128036d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128037e) + com.tencent.luggage.wxa.gr.a.a(3, this.f128038f);
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
        kf kfVar = (kf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                kfVar.f128038f = aVar3.c(intValue);
                return 0;
            }
            kfVar.f128037e = aVar3.f(intValue);
            return 0;
        }
        kfVar.f128036d = aVar3.a(intValue);
        return 0;
    }
}
