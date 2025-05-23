package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128958d;

    /* renamed from: e, reason: collision with root package name */
    public String f128959e;

    /* renamed from: f, reason: collision with root package name */
    public String f128960f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128958d);
            String str = this.f128959e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128960f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128958d) + 0;
            String str3 = this.f128959e;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            String str4 = this.f128960f;
            if (str4 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(3, str4);
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
        w7 w7Var = (w7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                w7Var.f128960f = aVar3.i(intValue);
                return 0;
            }
            w7Var.f128959e = aVar3.i(intValue);
            return 0;
        }
        w7Var.f128958d = aVar3.f(intValue);
        return 0;
    }
}
