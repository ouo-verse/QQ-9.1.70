package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127835d;

    /* renamed from: e, reason: collision with root package name */
    public String f127836e;

    /* renamed from: f, reason: collision with root package name */
    public String f127837f;

    /* renamed from: g, reason: collision with root package name */
    public String f127838g;

    /* renamed from: h, reason: collision with root package name */
    public String f127839h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127840i;

    /* renamed from: j, reason: collision with root package name */
    public String f127841j;

    /* renamed from: k, reason: collision with root package name */
    public int f127842k;

    /* renamed from: l, reason: collision with root package name */
    public int f127843l;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127835d);
            String str = this.f127836e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127837f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127838g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f127839h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f127840i;
            if (cVar != null) {
                aVar.a(6, cVar);
            }
            String str5 = this.f127841j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            aVar.b(8, this.f127842k);
            aVar.b(9, this.f127843l);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127835d) + 0;
            String str6 = this.f127836e;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f127837f;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f127838g;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            String str9 = this.f127839h;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127840i;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, cVar2);
            }
            String str10 = this.f127841j;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str10);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(8, this.f127842k) + com.tencent.luggage.wxa.gr.a.b(9, this.f127843l);
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
        i2 i2Var = (i2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                i2Var.f127835d = aVar3.f(intValue);
                return 0;
            case 2:
                i2Var.f127836e = aVar3.i(intValue);
                return 0;
            case 3:
                i2Var.f127837f = aVar3.i(intValue);
                return 0;
            case 4:
                i2Var.f127838g = aVar3.i(intValue);
                return 0;
            case 5:
                i2Var.f127839h = aVar3.i(intValue);
                return 0;
            case 6:
                i2Var.f127840i = aVar3.b(intValue);
                return 0;
            case 7:
                i2Var.f127841j = aVar3.i(intValue);
                return 0;
            case 8:
                i2Var.f127842k = aVar3.f(intValue);
                return 0;
            case 9:
                i2Var.f127843l = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
