package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class vd extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128912d;

    /* renamed from: e, reason: collision with root package name */
    public int f128913e;

    /* renamed from: f, reason: collision with root package name */
    public int f128914f;

    /* renamed from: g, reason: collision with root package name */
    public String f128915g;

    /* renamed from: h, reason: collision with root package name */
    public int f128916h;

    /* renamed from: i, reason: collision with root package name */
    public int f128917i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128912d);
            aVar.b(2, this.f128913e);
            aVar.b(3, this.f128914f);
            String str = this.f128915g;
            if (str != null) {
                aVar.a(4, str);
            }
            aVar.b(5, this.f128916h);
            aVar.b(6, this.f128917i);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128912d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128913e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128914f);
            String str2 = this.f128915g;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str2);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128916h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128917i);
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
        vd vdVar = (vd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                vdVar.f128912d = aVar3.f(intValue);
                return 0;
            case 2:
                vdVar.f128913e = aVar3.f(intValue);
                return 0;
            case 3:
                vdVar.f128914f = aVar3.f(intValue);
                return 0;
            case 4:
                vdVar.f128915g = aVar3.i(intValue);
                return 0;
            case 5:
                vdVar.f128916h = aVar3.f(intValue);
                return 0;
            case 6:
                vdVar.f128917i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
