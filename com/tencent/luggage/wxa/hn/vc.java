package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class vc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128908d;

    /* renamed from: e, reason: collision with root package name */
    public String f128909e;

    /* renamed from: f, reason: collision with root package name */
    public String f128910f;

    /* renamed from: g, reason: collision with root package name */
    public long f128911g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128908d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128909e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128910f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            aVar.a(4, this.f128911g);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128908d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f128909e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128910f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(4, this.f128911g);
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
        vc vcVar = (vc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    vcVar.f128911g = aVar3.g(intValue);
                    return 0;
                }
                vcVar.f128910f = aVar3.i(intValue);
                return 0;
            }
            vcVar.f128909e = aVar3.i(intValue);
            return 0;
        }
        vcVar.f128908d = aVar3.i(intValue);
        return 0;
    }
}
