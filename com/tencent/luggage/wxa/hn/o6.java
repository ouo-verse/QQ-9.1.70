package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128328d;

    /* renamed from: e, reason: collision with root package name */
    public String f128329e;

    /* renamed from: f, reason: collision with root package name */
    public int f128330f;

    /* renamed from: g, reason: collision with root package name */
    public int f128331g;

    /* renamed from: h, reason: collision with root package name */
    public int f128332h;

    /* renamed from: i, reason: collision with root package name */
    public int f128333i;

    /* renamed from: j, reason: collision with root package name */
    public int f128334j;

    /* renamed from: k, reason: collision with root package name */
    public String f128335k;

    /* renamed from: l, reason: collision with root package name */
    public int f128336l;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128328d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128329e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128330f);
            aVar.b(4, this.f128331g);
            aVar.b(5, this.f128332h);
            aVar.b(6, this.f128333i);
            aVar.b(7, this.f128334j);
            String str3 = this.f128335k;
            if (str3 != null) {
                aVar.a(8, str3);
            }
            aVar.b(9, this.f128336l);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128328d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f128329e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128330f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128331g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128332h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128333i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128334j);
            String str6 = this.f128335k;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str6);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(9, this.f128336l);
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
        o6 o6Var = (o6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                o6Var.f128328d = aVar3.i(intValue);
                return 0;
            case 2:
                o6Var.f128329e = aVar3.i(intValue);
                return 0;
            case 3:
                o6Var.f128330f = aVar3.f(intValue);
                return 0;
            case 4:
                o6Var.f128331g = aVar3.f(intValue);
                return 0;
            case 5:
                o6Var.f128332h = aVar3.f(intValue);
                return 0;
            case 6:
                o6Var.f128333i = aVar3.f(intValue);
                return 0;
            case 7:
                o6Var.f128334j = aVar3.f(intValue);
                return 0;
            case 8:
                o6Var.f128335k = aVar3.i(intValue);
                return 0;
            case 9:
                o6Var.f128336l = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
