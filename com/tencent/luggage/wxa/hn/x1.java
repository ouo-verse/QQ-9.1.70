package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128986d;

    /* renamed from: e, reason: collision with root package name */
    public int f128987e;

    /* renamed from: f, reason: collision with root package name */
    public int f128988f;

    /* renamed from: g, reason: collision with root package name */
    public String f128989g;

    /* renamed from: h, reason: collision with root package name */
    public String f128990h;

    /* renamed from: i, reason: collision with root package name */
    public String f128991i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128986d);
            aVar.b(2, this.f128987e);
            aVar.b(3, this.f128988f);
            String str = this.f128989g;
            if (str != null) {
                aVar.a(4, str);
            }
            String str2 = this.f128990h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f128991i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128986d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128987e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128988f);
            String str4 = this.f128989g;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str4);
            }
            String str5 = this.f128990h;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str5);
            }
            String str6 = this.f128991i;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str6);
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
        x1 x1Var = (x1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                x1Var.f128986d = aVar3.f(intValue);
                return 0;
            case 2:
                x1Var.f128987e = aVar3.f(intValue);
                return 0;
            case 3:
                x1Var.f128988f = aVar3.f(intValue);
                return 0;
            case 4:
                x1Var.f128989g = aVar3.i(intValue);
                return 0;
            case 5:
                x1Var.f128990h = aVar3.i(intValue);
                return 0;
            case 6:
                x1Var.f128991i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
