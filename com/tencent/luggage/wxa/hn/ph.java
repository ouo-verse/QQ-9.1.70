package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ph extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128459d;

    /* renamed from: e, reason: collision with root package name */
    public int f128460e;

    /* renamed from: f, reason: collision with root package name */
    public int f128461f;

    /* renamed from: g, reason: collision with root package name */
    public int f128462g;

    /* renamed from: h, reason: collision with root package name */
    public String f128463h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128459d);
            aVar.b(2, this.f128460e);
            aVar.b(3, this.f128461f);
            aVar.b(4, this.f128462g);
            String str = this.f128463h;
            if (str != null) {
                aVar.a(5, str);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128459d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128460e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128461f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128462g);
            String str2 = this.f128463h;
            if (str2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(5, str2);
            }
            return b16;
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
        ph phVar = (ph) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        phVar.f128463h = aVar3.i(intValue);
                        return 0;
                    }
                    phVar.f128462g = aVar3.f(intValue);
                    return 0;
                }
                phVar.f128461f = aVar3.f(intValue);
                return 0;
            }
            phVar.f128460e = aVar3.f(intValue);
            return 0;
        }
        phVar.f128459d = aVar3.f(intValue);
        return 0;
    }
}
