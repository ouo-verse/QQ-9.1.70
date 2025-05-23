package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w4 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128939d;

    /* renamed from: e, reason: collision with root package name */
    public long f128940e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128941f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128939d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, this.f128940e);
            com.tencent.luggage.wxa.fn.c cVar = this.f128941f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128939d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f128940e);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128941f;
            if (cVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(3, cVar2);
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
        w4 w4Var = (w4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                w4Var.f128941f = aVar3.b(intValue);
                return 0;
            }
            w4Var.f128940e = aVar3.g(intValue);
            return 0;
        }
        w4Var.f128939d = aVar3.i(intValue);
        return 0;
    }
}
