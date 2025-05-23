package com.tencent.luggage.wxa.d6;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f124110d;

    /* renamed from: e, reason: collision with root package name */
    public int f124111e;

    /* renamed from: f, reason: collision with root package name */
    public int f124112f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f124110d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f124111e);
            aVar.b(3, this.f124112f);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f124110d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f124111e) + com.tencent.luggage.wxa.gr.a.b(3, this.f124112f);
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
        d dVar = (d) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                dVar.f124112f = aVar3.f(intValue);
                return 0;
            }
            dVar.f124111e = aVar3.f(intValue);
            return 0;
        }
        dVar.f124110d = aVar3.i(intValue);
        return 0;
    }
}
