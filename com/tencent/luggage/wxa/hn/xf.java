package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class xf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f129041d;

    /* renamed from: e, reason: collision with root package name */
    public String f129042e;

    /* renamed from: f, reason: collision with root package name */
    public String f129043f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f129044g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f129041d);
            String str = this.f129042e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f129043f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.a(4, this.f129044g);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f129041d) + 0;
            String str3 = this.f129042e;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            String str4 = this.f129043f;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(4, this.f129044g);
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
        xf xfVar = (xf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    xfVar.f129044g = aVar3.a(intValue);
                    return 0;
                }
                xfVar.f129043f = aVar3.i(intValue);
                return 0;
            }
            xfVar.f129042e = aVar3.i(intValue);
            return 0;
        }
        xfVar.f129041d = aVar3.f(intValue);
        return 0;
    }
}
