package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127663d;

    /* renamed from: e, reason: collision with root package name */
    public int f127664e;

    /* renamed from: f, reason: collision with root package name */
    public int f127665f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127663d);
            aVar.b(2, this.f127664e);
            aVar.b(3, this.f127665f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127663d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f127664e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127665f);
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
        g2 g2Var = (g2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                g2Var.f127665f = aVar3.f(intValue);
                return 0;
            }
            g2Var.f127664e = aVar3.f(intValue);
            return 0;
        }
        g2Var.f127663d = aVar3.f(intValue);
        return 0;
    }
}
