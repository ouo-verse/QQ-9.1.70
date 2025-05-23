package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class vf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128919d;

    /* renamed from: e, reason: collision with root package name */
    public int f128920e;

    /* renamed from: f, reason: collision with root package name */
    public String f128921f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128919d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f128920e);
            String str2 = this.f128921f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128919d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128920e);
            String str4 = this.f128921f;
            if (str4 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(3, str4);
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
        vf vfVar = (vf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                vfVar.f128921f = aVar3.i(intValue);
                return 0;
            }
            vfVar.f128920e = aVar3.f(intValue);
            return 0;
        }
        vfVar.f128919d = aVar3.i(intValue);
        return 0;
    }
}
