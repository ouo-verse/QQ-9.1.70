package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ni extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128310d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f128311e;

    /* renamed from: f, reason: collision with root package name */
    public int f128312f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128310d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, this.f128311e);
            aVar.b(3, this.f128312f);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128310d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f128311e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128312f);
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
        ni niVar = (ni) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                niVar.f128312f = aVar3.f(intValue);
                return 0;
            }
            niVar.f128311e = aVar3.a(intValue);
            return 0;
        }
        niVar.f128310d = aVar3.i(intValue);
        return 0;
    }
}
