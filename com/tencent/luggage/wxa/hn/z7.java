package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public boolean f129135d;

    /* renamed from: e, reason: collision with root package name */
    public String f129136e;

    /* renamed from: f, reason: collision with root package name */
    public String f129137f;

    /* renamed from: g, reason: collision with root package name */
    public int f129138g;

    /* renamed from: h, reason: collision with root package name */
    public int f129139h;

    /* renamed from: i, reason: collision with root package name */
    public String f129140i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f129141j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, this.f129135d);
            String str = this.f129136e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f129137f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f129138g);
            aVar.b(5, this.f129139h);
            String str3 = this.f129140i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            aVar.a(7, this.f129141j);
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f129135d) + 0;
            String str4 = this.f129136e;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f129137f;
            if (str5 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(4, this.f129138g) + com.tencent.luggage.wxa.gr.a.b(5, this.f129139h);
            String str6 = this.f129140i;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str6);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(7, this.f129141j);
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
        z7 z7Var = (z7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                z7Var.f129135d = aVar3.a(intValue);
                return 0;
            case 2:
                z7Var.f129136e = aVar3.i(intValue);
                return 0;
            case 3:
                z7Var.f129137f = aVar3.i(intValue);
                return 0;
            case 4:
                z7Var.f129138g = aVar3.f(intValue);
                return 0;
            case 5:
                z7Var.f129139h = aVar3.f(intValue);
                return 0;
            case 6:
                z7Var.f129140i = aVar3.i(intValue);
                return 0;
            case 7:
                z7Var.f129141j = aVar3.a(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
