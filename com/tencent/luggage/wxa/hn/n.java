package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128224d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public String f128225e;

    /* renamed from: f, reason: collision with root package name */
    public String f128226f;

    /* renamed from: g, reason: collision with root package name */
    public String f128227g;

    /* renamed from: h, reason: collision with root package name */
    public String f128228h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128224d);
            String str = this.f128225e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128226f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128227g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f128228h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128224d) + 0;
            String str5 = this.f128225e;
            if (str5 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128226f;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            String str7 = this.f128227g;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f128228h;
            if (str8 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128224d.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        n nVar = (n) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        nVar.f128228h = aVar3.i(intValue);
                        return 0;
                    }
                    nVar.f128227g = aVar3.i(intValue);
                    return 0;
                }
                nVar.f128226f = aVar3.i(intValue);
                return 0;
            }
            nVar.f128225e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i16 = 0; i16 < size; i16++) {
            byte[] bArr2 = (byte[]) h16.get(i16);
            o oVar = new o();
            if (bArr2 != null && bArr2.length > 0) {
                oVar.a(bArr2);
            }
            nVar.f128224d.add(oVar);
        }
        return 0;
    }
}
