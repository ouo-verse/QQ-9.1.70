package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ze extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f129155d;

    /* renamed from: e, reason: collision with root package name */
    public int f129156e;

    /* renamed from: f, reason: collision with root package name */
    public String f129157f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f129155d);
            aVar.b(2, this.f129156e);
            String str = this.f129157f;
            if (str != null) {
                aVar.a(3, str);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f129155d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f129156e);
            String str2 = this.f129157f;
            if (str2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(3, str2);
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
        ze zeVar = (ze) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                zeVar.f129157f = aVar3.i(intValue);
                return 0;
            }
            zeVar.f129156e = aVar3.f(intValue);
            return 0;
        }
        zeVar.f129155d = aVar3.f(intValue);
        return 0;
    }
}
