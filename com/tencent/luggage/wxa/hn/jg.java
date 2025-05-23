package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class jg extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127961d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127962e;

    /* renamed from: f, reason: collision with root package name */
    public String f127963f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127961d);
            com.tencent.luggage.wxa.fn.c cVar = this.f127962e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            String str = this.f127963f;
            if (str != null) {
                aVar.a(3, str);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127961d) + 0;
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127962e;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, cVar2);
            }
            String str2 = this.f127963f;
            if (str2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(3, str2);
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
        jg jgVar = (jg) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                jgVar.f127963f = aVar3.i(intValue);
                return 0;
            }
            jgVar.f127962e = aVar3.b(intValue);
            return 0;
        }
        jgVar.f127961d = aVar3.f(intValue);
        return 0;
    }
}
