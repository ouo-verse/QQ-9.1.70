package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128598d;

    /* renamed from: e, reason: collision with root package name */
    public String f128599e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128598d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128599e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128598d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            String str4 = this.f128599e;
            if (str4 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            return i16;
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
        r9 r9Var = (r9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            r9Var.f128599e = aVar3.i(intValue);
            return 0;
        }
        r9Var.f128598d = aVar3.i(intValue);
        return 0;
    }
}
