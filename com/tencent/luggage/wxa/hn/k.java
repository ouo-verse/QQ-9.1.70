package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127969d;

    /* renamed from: e, reason: collision with root package name */
    public int f127970e;

    /* renamed from: f, reason: collision with root package name */
    public int f127971f;

    /* renamed from: g, reason: collision with root package name */
    public String f127972g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127969d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127970e);
            aVar.b(3, this.f127971f);
            String str2 = this.f127972g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f127969d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127970e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127971f);
            String str4 = this.f127972g;
            if (str4 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(4, str4);
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
        k kVar = (k) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    kVar.f127972g = aVar3.i(intValue);
                    return 0;
                }
                kVar.f127971f = aVar3.f(intValue);
                return 0;
            }
            kVar.f127970e = aVar3.f(intValue);
            return 0;
        }
        kVar.f127969d = aVar3.i(intValue);
        return 0;
    }
}
