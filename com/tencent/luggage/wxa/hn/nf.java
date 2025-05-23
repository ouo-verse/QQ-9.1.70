package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class nf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f128299d;

    /* renamed from: e, reason: collision with root package name */
    public String f128300e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128301f;

    /* renamed from: g, reason: collision with root package name */
    public int f128302g;

    /* renamed from: h, reason: collision with root package name */
    public int f128303h;

    /* renamed from: i, reason: collision with root package name */
    public int f128304i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f128305j;

    /* renamed from: k, reason: collision with root package name */
    public int f128306k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f128299d);
            String str = this.f128300e;
            if (str != null) {
                aVar.a(2, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128301f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            aVar.b(4, this.f128302g);
            aVar.b(5, this.f128303h);
            aVar.b(6, this.f128304i);
            aVar.a(9, this.f128305j);
            aVar.b(10, this.f128306k);
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f128299d) + 0;
            String str2 = this.f128300e;
            if (str2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128301f;
            if (cVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, cVar2);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128302g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128303h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128304i) + com.tencent.luggage.wxa.gr.a.a(9, this.f128305j) + com.tencent.luggage.wxa.gr.a.b(10, this.f128306k);
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
        nf nfVar = (nf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                nfVar.f128299d = aVar3.a(intValue);
                return 0;
            case 2:
                nfVar.f128300e = aVar3.i(intValue);
                return 0;
            case 3:
                nfVar.f128301f = aVar3.b(intValue);
                return 0;
            case 4:
                nfVar.f128302g = aVar3.f(intValue);
                return 0;
            case 5:
                nfVar.f128303h = aVar3.f(intValue);
                return 0;
            case 6:
                nfVar.f128304i = aVar3.f(intValue);
                return 0;
            case 7:
            case 8:
            default:
                return -1;
            case 9:
                nfVar.f128305j = aVar3.a(intValue);
                return 0;
            case 10:
                nfVar.f128306k = aVar3.f(intValue);
                return 0;
        }
    }
}
