package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l3 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128057d;

    /* renamed from: e, reason: collision with root package name */
    public String f128058e;

    /* renamed from: f, reason: collision with root package name */
    public int f128059f;

    /* renamed from: g, reason: collision with root package name */
    public int f128060g;

    /* renamed from: h, reason: collision with root package name */
    public String f128061h;

    /* renamed from: i, reason: collision with root package name */
    public String f128062i;

    /* renamed from: j, reason: collision with root package name */
    public String f128063j;

    /* renamed from: k, reason: collision with root package name */
    public String f128064k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128057d);
            String str = this.f128058e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f128059f);
            aVar.b(4, this.f128060g);
            String str2 = this.f128061h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f128062i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            String str4 = this.f128063j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f128064k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128057d) + 0;
            String str6 = this.f128058e;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128059f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128060g);
            String str7 = this.f128061h;
            if (str7 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, str7);
            }
            String str8 = this.f128062i;
            if (str8 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            String str9 = this.f128063j;
            if (str9 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(7, str9);
            }
            String str10 = this.f128064k;
            if (str10 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.a(8, str10);
            }
            return b17;
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
        l3 l3Var = (l3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                l3Var.f128057d = aVar3.f(intValue);
                return 0;
            case 2:
                l3Var.f128058e = aVar3.i(intValue);
                return 0;
            case 3:
                l3Var.f128059f = aVar3.f(intValue);
                return 0;
            case 4:
                l3Var.f128060g = aVar3.f(intValue);
                return 0;
            case 5:
                l3Var.f128061h = aVar3.i(intValue);
                return 0;
            case 6:
                l3Var.f128062i = aVar3.i(intValue);
                return 0;
            case 7:
                l3Var.f128063j = aVar3.i(intValue);
                return 0;
            case 8:
                l3Var.f128064k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
