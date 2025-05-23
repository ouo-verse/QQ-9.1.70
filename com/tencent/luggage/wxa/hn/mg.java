package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class mg extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128214d;

    /* renamed from: e, reason: collision with root package name */
    public String f128215e;

    /* renamed from: f, reason: collision with root package name */
    public String f128216f;

    /* renamed from: g, reason: collision with root package name */
    public String f128217g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128214d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128215e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128216f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f128217g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f128214d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            String str6 = this.f128215e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f128216f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f128217g;
            if (str8 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            return i16;
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
        mg mgVar = (mg) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    mgVar.f128217g = aVar3.i(intValue);
                    return 0;
                }
                mgVar.f128216f = aVar3.i(intValue);
                return 0;
            }
            mgVar.f128215e = aVar3.i(intValue);
            return 0;
        }
        mgVar.f128214d = aVar3.i(intValue);
        return 0;
    }
}
