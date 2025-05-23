package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f5 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127606d;

    /* renamed from: e, reason: collision with root package name */
    public int f127607e;

    /* renamed from: f, reason: collision with root package name */
    public int f127608f;

    /* renamed from: g, reason: collision with root package name */
    public int f127609g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127606d);
            aVar.b(2, this.f127607e);
            aVar.b(3, this.f127608f);
            aVar.b(4, this.f127609g);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127606d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f127607e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127608f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127609g);
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
        f5 f5Var = (f5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    f5Var.f127609g = aVar3.f(intValue);
                    return 0;
                }
                f5Var.f127608f = aVar3.f(intValue);
                return 0;
            }
            f5Var.f127607e = aVar3.f(intValue);
            return 0;
        }
        f5Var.f127606d = aVar3.f(intValue);
        return 0;
    }
}
