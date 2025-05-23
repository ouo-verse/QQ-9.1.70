package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128770d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f128771e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f128772f;

    /* renamed from: g, reason: collision with root package name */
    public int f128773g;

    /* renamed from: h, reason: collision with root package name */
    public int f128774h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f128775i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f128776j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f128777k;

    /* renamed from: l, reason: collision with root package name */
    public String f128778l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f128779m;

    /* renamed from: n, reason: collision with root package name */
    public int f128780n;

    /* renamed from: o, reason: collision with root package name */
    public float f128781o;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128770d);
            aVar.a(2, this.f128771e);
            aVar.a(3, this.f128772f);
            aVar.b(4, this.f128773g);
            aVar.b(5, this.f128774h);
            aVar.a(6, this.f128775i);
            aVar.a(7, this.f128776j);
            aVar.a(8, this.f128777k);
            String str = this.f128778l;
            if (str != null) {
                aVar.a(9, str);
            }
            aVar.a(10, this.f128779m);
            aVar.b(11, this.f128780n);
            aVar.a(12, this.f128781o);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128770d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, this.f128771e) + com.tencent.luggage.wxa.gr.a.a(3, this.f128772f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128773g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128774h) + com.tencent.luggage.wxa.gr.a.a(6, this.f128775i) + com.tencent.luggage.wxa.gr.a.a(7, this.f128776j) + com.tencent.luggage.wxa.gr.a.a(8, this.f128777k);
            String str2 = this.f128778l;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str2);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(10, this.f128779m) + com.tencent.luggage.wxa.gr.a.b(11, this.f128780n) + com.tencent.luggage.wxa.gr.a.a(12, this.f128781o);
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
        u0 u0Var = (u0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                u0Var.f128770d = aVar3.f(intValue);
                return 0;
            case 2:
                u0Var.f128771e = aVar3.a(intValue);
                return 0;
            case 3:
                u0Var.f128772f = aVar3.a(intValue);
                return 0;
            case 4:
                u0Var.f128773g = aVar3.f(intValue);
                return 0;
            case 5:
                u0Var.f128774h = aVar3.f(intValue);
                return 0;
            case 6:
                u0Var.f128775i = aVar3.a(intValue);
                return 0;
            case 7:
                u0Var.f128776j = aVar3.a(intValue);
                return 0;
            case 8:
                u0Var.f128777k = aVar3.a(intValue);
                return 0;
            case 9:
                u0Var.f128778l = aVar3.i(intValue);
                return 0;
            case 10:
                u0Var.f128779m = aVar3.a(intValue);
                return 0;
            case 11:
                u0Var.f128780n = aVar3.f(intValue);
                return 0;
            case 12:
                u0Var.f128781o = aVar3.d(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
