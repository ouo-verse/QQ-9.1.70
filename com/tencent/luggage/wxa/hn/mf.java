package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class mf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128209d;

    /* renamed from: e, reason: collision with root package name */
    public int f128210e;

    /* renamed from: f, reason: collision with root package name */
    public int f128211f;

    /* renamed from: g, reason: collision with root package name */
    public int f128212g;

    /* renamed from: h, reason: collision with root package name */
    public int f128213h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128209d);
            aVar.b(2, this.f128210e);
            aVar.b(3, this.f128211f);
            aVar.b(4, this.f128212g);
            aVar.b(5, this.f128213h);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f128209d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128210e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128211f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128212g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128213h);
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
        mf mfVar = (mf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        mfVar.f128213h = aVar3.f(intValue);
                        return 0;
                    }
                    mfVar.f128212g = aVar3.f(intValue);
                    return 0;
                }
                mfVar.f128211f = aVar3.f(intValue);
                return 0;
            }
            mfVar.f128210e = aVar3.f(intValue);
            return 0;
        }
        mfVar.f128209d = aVar3.f(intValue);
        return 0;
    }
}
