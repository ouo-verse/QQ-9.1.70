package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class bf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127359d;

    /* renamed from: e, reason: collision with root package name */
    public int f127360e;

    /* renamed from: f, reason: collision with root package name */
    public int f127361f;

    /* renamed from: g, reason: collision with root package name */
    public String f127362g;

    /* renamed from: h, reason: collision with root package name */
    public String f127363h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127359d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127360e);
            aVar.b(3, this.f127361f);
            String str2 = this.f127362g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127363h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f127359d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127360e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127361f);
            String str5 = this.f127362g;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            String str6 = this.f127363h;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(5, str6);
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
        bf bfVar = (bf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        bfVar.f127363h = aVar3.i(intValue);
                        return 0;
                    }
                    bfVar.f127362g = aVar3.i(intValue);
                    return 0;
                }
                bfVar.f127361f = aVar3.f(intValue);
                return 0;
            }
            bfVar.f127360e = aVar3.f(intValue);
            return 0;
        }
        bfVar.f127359d = aVar3.i(intValue);
        return 0;
    }
}
