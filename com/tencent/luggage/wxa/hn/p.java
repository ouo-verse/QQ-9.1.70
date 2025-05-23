package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128386d;

    /* renamed from: e, reason: collision with root package name */
    public long f128387e;

    /* renamed from: f, reason: collision with root package name */
    public String f128388f;

    /* renamed from: g, reason: collision with root package name */
    public int f128389g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128386d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, this.f128387e);
            String str2 = this.f128388f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128389g);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128386d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f128387e);
            String str4 = this.f128388f;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128389g);
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
        p pVar = (p) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    pVar.f128389g = aVar3.f(intValue);
                    return 0;
                }
                pVar.f128388f = aVar3.i(intValue);
                return 0;
            }
            pVar.f128387e = aVar3.g(intValue);
            return 0;
        }
        pVar.f128386d = aVar3.i(intValue);
        return 0;
    }
}
