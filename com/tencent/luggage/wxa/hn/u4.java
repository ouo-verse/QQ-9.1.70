package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u4 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public long f128806d;

    /* renamed from: e, reason: collision with root package name */
    public String f128807e;

    /* renamed from: f, reason: collision with root package name */
    public String f128808f;

    /* renamed from: g, reason: collision with root package name */
    public String f128809g;

    /* renamed from: h, reason: collision with root package name */
    public int f128810h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128811i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128812j;

    /* renamed from: k, reason: collision with root package name */
    public long f128813k;

    /* renamed from: l, reason: collision with root package name */
    public long f128814l;

    /* renamed from: m, reason: collision with root package name */
    public long f128815m;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f128806d);
            String str = this.f128807e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128808f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128809g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f128810h);
            com.tencent.luggage.wxa.fn.c cVar = this.f128811i;
            if (cVar != null) {
                aVar.a(6, cVar);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128812j;
            if (cVar2 != null) {
                aVar.a(7, cVar2);
            }
            aVar.a(8, this.f128813k);
            aVar.a(9, this.f128814l);
            aVar.a(10, this.f128815m);
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f128806d) + 0;
            String str4 = this.f128807e;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f128808f;
            if (str5 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f128809g;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128810h);
            com.tencent.luggage.wxa.fn.c cVar3 = this.f128811i;
            if (cVar3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, cVar3);
            }
            com.tencent.luggage.wxa.fn.c cVar4 = this.f128812j;
            if (cVar4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, cVar4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(8, this.f128813k) + com.tencent.luggage.wxa.gr.a.a(9, this.f128814l) + com.tencent.luggage.wxa.gr.a.a(10, this.f128815m);
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
        u4 u4Var = (u4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                u4Var.f128806d = aVar3.g(intValue);
                return 0;
            case 2:
                u4Var.f128807e = aVar3.i(intValue);
                return 0;
            case 3:
                u4Var.f128808f = aVar3.i(intValue);
                return 0;
            case 4:
                u4Var.f128809g = aVar3.i(intValue);
                return 0;
            case 5:
                u4Var.f128810h = aVar3.f(intValue);
                return 0;
            case 6:
                u4Var.f128811i = aVar3.b(intValue);
                return 0;
            case 7:
                u4Var.f128812j = aVar3.b(intValue);
                return 0;
            case 8:
                u4Var.f128813k = aVar3.g(intValue);
                return 0;
            case 9:
                u4Var.f128814l = aVar3.g(intValue);
                return 0;
            case 10:
                u4Var.f128815m = aVar3.g(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
