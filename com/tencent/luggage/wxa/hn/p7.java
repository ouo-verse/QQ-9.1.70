package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128416d;

    /* renamed from: e, reason: collision with root package name */
    public String f128417e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128416d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128417e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128416d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            String str4 = this.f128417e;
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
        p7 p7Var = (p7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            p7Var.f128417e = aVar3.i(intValue);
            return 0;
        }
        p7Var.f128416d = aVar3.i(intValue);
        return 0;
    }
}
