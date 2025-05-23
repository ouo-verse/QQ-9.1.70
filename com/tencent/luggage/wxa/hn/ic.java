package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ic extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127891d;

    /* renamed from: e, reason: collision with root package name */
    public int f127892e;

    /* renamed from: f, reason: collision with root package name */
    public String f127893f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127894g;

    /* renamed from: h, reason: collision with root package name */
    public int f127895h;

    /* renamed from: i, reason: collision with root package name */
    public int f127896i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127891d);
            aVar.b(2, this.f127892e);
            String str = this.f127893f;
            if (str != null) {
                aVar.a(3, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f127894g;
            if (cVar != null) {
                aVar.a(4, cVar);
            }
            aVar.b(5, this.f127895h);
            aVar.b(6, this.f127896i);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127891d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f127892e);
            String str2 = this.f127893f;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str2);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127894g;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, cVar2);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127895h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127896i);
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
        ic icVar = (ic) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                icVar.f127891d = aVar3.f(intValue);
                return 0;
            case 2:
                icVar.f127892e = aVar3.f(intValue);
                return 0;
            case 3:
                icVar.f127893f = aVar3.i(intValue);
                return 0;
            case 4:
                icVar.f127894g = aVar3.b(intValue);
                return 0;
            case 5:
                icVar.f127895h = aVar3.f(intValue);
                return 0;
            case 6:
                icVar.f127896i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
