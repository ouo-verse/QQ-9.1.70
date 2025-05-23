package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f127247d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f127248e;

    /* renamed from: f, reason: collision with root package name */
    public int f127249f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f127250g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127251h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f127247d);
            aVar.a(2, this.f127248e);
            aVar.b(3, this.f127249f);
            aVar.a(4, this.f127250g);
            com.tencent.luggage.wxa.fn.c cVar = this.f127251h;
            if (cVar != null) {
                aVar.a(5, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f127247d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, this.f127248e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127249f) + com.tencent.luggage.wxa.gr.a.a(4, this.f127250g);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127251h;
            if (cVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(5, cVar2);
            }
            return a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a17 = com.tencent.luggage.wxa.fn.b.a(aVar2); a17 > 0; a17 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a17)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        a aVar4 = (a) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        aVar4.f127251h = aVar3.b(intValue);
                        return 0;
                    }
                    aVar4.f127250g = aVar3.a(intValue);
                    return 0;
                }
                aVar4.f127249f = aVar3.f(intValue);
                return 0;
            }
            aVar4.f127248e = aVar3.a(intValue);
            return 0;
        }
        aVar4.f127247d = aVar3.a(intValue);
        return 0;
    }
}
