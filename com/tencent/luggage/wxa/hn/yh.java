package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class yh extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f129106d;

    /* renamed from: e, reason: collision with root package name */
    public String f129107e;

    /* renamed from: f, reason: collision with root package name */
    public int f129108f;

    /* renamed from: g, reason: collision with root package name */
    public String f129109g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f129106d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f129106d.a(aVar);
            }
            String str = this.f129107e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f129108f);
            String str2 = this.f129109g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f129106d;
            if (phVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
            }
            String str3 = this.f129107e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f129108f);
            String str4 = this.f129109g;
            if (str4 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(4, str4);
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
        yh yhVar = (yh) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    yhVar.f129109g = aVar3.i(intValue);
                    return 0;
                }
                yhVar.f129108f = aVar3.f(intValue);
                return 0;
            }
            yhVar.f129107e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            ph phVar3 = new ph();
            if (bArr != null && bArr.length > 0) {
                phVar3.a(bArr);
            }
            yhVar.f129106d = phVar3;
        }
        return 0;
    }
}
