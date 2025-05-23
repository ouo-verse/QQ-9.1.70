package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class zc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f129147d;

    /* renamed from: e, reason: collision with root package name */
    public String f129148e;

    /* renamed from: f, reason: collision with root package name */
    public String f129149f;

    /* renamed from: g, reason: collision with root package name */
    public int f129150g;

    /* renamed from: h, reason: collision with root package name */
    public int f129151h;

    /* renamed from: i, reason: collision with root package name */
    public int f129152i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f129147d);
            String str = this.f129148e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f129149f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f129150g);
            aVar.b(5, this.f129151h);
            aVar.b(6, this.f129152i);
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f129147d) + 0;
            String str3 = this.f129148e;
            if (str3 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            String str4 = this.f129149f;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.b(4, this.f129150g) + com.tencent.luggage.wxa.gr.a.b(5, this.f129151h) + com.tencent.luggage.wxa.gr.a.b(6, this.f129152i);
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
        zc zcVar = (zc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                zcVar.f129147d = aVar3.a(intValue);
                return 0;
            case 2:
                zcVar.f129148e = aVar3.i(intValue);
                return 0;
            case 3:
                zcVar.f129149f = aVar3.i(intValue);
                return 0;
            case 4:
                zcVar.f129150g = aVar3.f(intValue);
                return 0;
            case 5:
                zcVar.f129151h = aVar3.f(intValue);
                return 0;
            case 6:
                zcVar.f129152i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
