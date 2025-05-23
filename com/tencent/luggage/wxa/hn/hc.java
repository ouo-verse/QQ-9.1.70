package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class hc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127796d;

    /* renamed from: e, reason: collision with root package name */
    public String f127797e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127798f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127796d);
            String str = this.f127797e;
            if (str != null) {
                aVar.a(2, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f127798f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127796d) + 0;
            String str2 = this.f127797e;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127798f;
            if (cVar2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(3, cVar2);
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
        hc hcVar = (hc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                hcVar.f127798f = aVar3.b(intValue);
                return 0;
            }
            hcVar.f127797e = aVar3.i(intValue);
            return 0;
        }
        hcVar.f127796d = aVar3.f(intValue);
        return 0;
    }
}
