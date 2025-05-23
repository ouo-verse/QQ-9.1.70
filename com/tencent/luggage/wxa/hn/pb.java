package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class pb extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f128430d;

    /* renamed from: e, reason: collision with root package name */
    public String f128431e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f128430d);
            String str = this.f128431e;
            if (str != null) {
                aVar.a(2, str);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f128430d) + 0;
            String str2 = this.f128431e;
            if (str2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(2, str2);
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
        pb pbVar = (pb) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            pbVar.f128431e = aVar3.i(intValue);
            return 0;
        }
        pbVar.f128430d = aVar3.a(intValue);
        return 0;
    }
}
