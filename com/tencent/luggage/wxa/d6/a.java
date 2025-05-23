package com.tencent.luggage.wxa.d6;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f124084d;

    /* renamed from: e, reason: collision with root package name */
    public String f124085e;

    public a a(String str) {
        this.f124084d = str;
        return this;
    }

    public a b(String str) {
        this.f124085e = str;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f124084d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f124085e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f124084d;
            int a16 = str3 != null ? 0 + com.tencent.luggage.wxa.gr.a.a(1, str3) : 0;
            String str4 = this.f124085e;
            return str4 != null ? a16 + com.tencent.luggage.wxa.gr.a.a(2, str4) : a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a17 = com.tencent.luggage.wxa.fn.b.a(aVar2); a17 > 0; a17 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a17)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        a aVar4 = (a) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue == 1) {
            aVar4.f124084d = aVar3.i(intValue);
            return 0;
        }
        if (intValue != 2) {
            return -1;
        }
        aVar4.f124085e = aVar3.i(intValue);
        return 0;
    }
}
