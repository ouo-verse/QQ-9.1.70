package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* renamed from: com.tencent.luggage.wxa.hn.if, reason: invalid class name */
/* loaded from: classes8.dex */
public class Cif extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127901d;

    /* renamed from: e, reason: collision with root package name */
    public long f127902e;

    /* renamed from: f, reason: collision with root package name */
    public int f127903f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127901d);
            aVar.a(2, this.f127902e);
            aVar.b(3, this.f127903f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127901d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, this.f127902e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127903f);
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
        Cif cif = (Cif) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                cif.f127903f = aVar3.f(intValue);
                return 0;
            }
            cif.f127902e = aVar3.g(intValue);
            return 0;
        }
        cif.f127901d = aVar3.f(intValue);
        return 0;
    }
}
