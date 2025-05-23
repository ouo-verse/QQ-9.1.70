package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class hf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127803d;

    /* renamed from: e, reason: collision with root package name */
    public int f127804e;

    /* renamed from: f, reason: collision with root package name */
    public int f127805f;

    /* renamed from: g, reason: collision with root package name */
    public int f127806g;

    /* renamed from: h, reason: collision with root package name */
    public int f127807h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127803d);
            aVar.b(2, this.f127804e);
            aVar.b(3, this.f127805f);
            aVar.b(5, this.f127806g);
            aVar.b(6, this.f127807h);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127803d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f127804e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127805f) + com.tencent.luggage.wxa.gr.a.b(5, this.f127806g) + com.tencent.luggage.wxa.gr.a.b(6, this.f127807h);
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
        hf hfVar = (hf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 5) {
                        if (intValue != 6) {
                            return -1;
                        }
                        hfVar.f127807h = aVar3.f(intValue);
                        return 0;
                    }
                    hfVar.f127806g = aVar3.f(intValue);
                    return 0;
                }
                hfVar.f127805f = aVar3.f(intValue);
                return 0;
            }
            hfVar.f127804e = aVar3.f(intValue);
            return 0;
        }
        hfVar.f127803d = aVar3.f(intValue);
        return 0;
    }
}
