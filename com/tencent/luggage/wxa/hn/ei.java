package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ei extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127581d;

    /* renamed from: e, reason: collision with root package name */
    public String f127582e;

    /* renamed from: f, reason: collision with root package name */
    public String f127583f;

    /* renamed from: g, reason: collision with root package name */
    public String f127584g;

    /* renamed from: h, reason: collision with root package name */
    public int f127585h;

    /* renamed from: i, reason: collision with root package name */
    public int f127586i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127581d);
            String str = this.f127582e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127583f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127584g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f127585h);
            aVar.b(6, this.f127586i);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127581d) + 0;
            String str4 = this.f127582e;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127583f;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f127584g;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127585h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127586i);
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
        ei eiVar = (ei) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                eiVar.f127581d = aVar3.f(intValue);
                return 0;
            case 2:
                eiVar.f127582e = aVar3.i(intValue);
                return 0;
            case 3:
                eiVar.f127583f = aVar3.i(intValue);
                return 0;
            case 4:
                eiVar.f127584g = aVar3.i(intValue);
                return 0;
            case 5:
                eiVar.f127585h = aVar3.f(intValue);
                return 0;
            case 6:
                eiVar.f127586i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
