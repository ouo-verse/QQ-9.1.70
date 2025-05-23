package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class lc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128074d;

    /* renamed from: e, reason: collision with root package name */
    public String f128075e;

    /* renamed from: f, reason: collision with root package name */
    public String f128076f;

    /* renamed from: g, reason: collision with root package name */
    public String f128077g;

    /* renamed from: h, reason: collision with root package name */
    public int f128078h;

    /* renamed from: i, reason: collision with root package name */
    public float f128079i;

    /* renamed from: j, reason: collision with root package name */
    public float f128080j;

    /* renamed from: k, reason: collision with root package name */
    public String f128081k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128074d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128075e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128076f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f128077g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            aVar.b(5, this.f128078h);
            aVar.a(6, this.f128079i);
            aVar.a(7, this.f128080j);
            String str5 = this.f128081k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            String str6 = this.f128074d;
            if (str6 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str6);
            }
            String str7 = this.f128075e;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str7);
            }
            String str8 = this.f128076f;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str8);
            }
            String str9 = this.f128077g;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str9);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128078h) + com.tencent.luggage.wxa.gr.a.a(6, this.f128079i) + com.tencent.luggage.wxa.gr.a.a(7, this.f128080j);
            String str10 = this.f128081k;
            if (str10 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(8, str10);
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
        lc lcVar = (lc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                lcVar.f128074d = aVar3.i(intValue);
                return 0;
            case 2:
                lcVar.f128075e = aVar3.i(intValue);
                return 0;
            case 3:
                lcVar.f128076f = aVar3.i(intValue);
                return 0;
            case 4:
                lcVar.f128077g = aVar3.i(intValue);
                return 0;
            case 5:
                lcVar.f128078h = aVar3.f(intValue);
                return 0;
            case 6:
                lcVar.f128079i = aVar3.d(intValue);
                return 0;
            case 7:
                lcVar.f128080j = aVar3.d(intValue);
                return 0;
            case 8:
                lcVar.f128081k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
