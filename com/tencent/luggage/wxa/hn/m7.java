package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128159d;

    /* renamed from: e, reason: collision with root package name */
    public String f128160e;

    /* renamed from: f, reason: collision with root package name */
    public int f128161f;

    /* renamed from: g, reason: collision with root package name */
    public int f128162g;

    /* renamed from: h, reason: collision with root package name */
    public String f128163h;

    /* renamed from: i, reason: collision with root package name */
    public String f128164i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f128165j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f128166k;

    /* renamed from: l, reason: collision with root package name */
    public int f128167l;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128159d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128160e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128161f);
            aVar.b(4, this.f128162g);
            String str3 = this.f128163h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128164i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            aVar.a(20, this.f128165j);
            aVar.a(21, this.f128166k);
            aVar.b(22, this.f128167l);
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f128159d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            String str6 = this.f128160e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128161f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128162g);
            String str7 = this.f128163h;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str7);
            }
            String str8 = this.f128164i;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(20, this.f128165j) + com.tencent.luggage.wxa.gr.a.a(21, this.f128166k) + com.tencent.luggage.wxa.gr.a.b(22, this.f128167l);
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
        m7 m7Var = (m7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                m7Var.f128159d = aVar3.i(intValue);
                return 0;
            case 2:
                m7Var.f128160e = aVar3.i(intValue);
                return 0;
            case 3:
                m7Var.f128161f = aVar3.f(intValue);
                return 0;
            case 4:
                m7Var.f128162g = aVar3.f(intValue);
                return 0;
            case 5:
                m7Var.f128163h = aVar3.i(intValue);
                return 0;
            case 6:
                m7Var.f128164i = aVar3.i(intValue);
                return 0;
            default:
                switch (intValue) {
                    case 20:
                        m7Var.f128165j = aVar3.a(intValue);
                        return 0;
                    case 21:
                        m7Var.f128166k = aVar3.a(intValue);
                        return 0;
                    case 22:
                        m7Var.f128167l = aVar3.f(intValue);
                        return 0;
                    default:
                        return -1;
                }
        }
    }
}
