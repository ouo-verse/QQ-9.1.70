package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ue extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128842d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128843e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128844f = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128842d;
            if (str != null) {
                aVar.a(1, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128843e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            aVar.a(3, 8, this.f128844f);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128842d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128843e;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, cVar2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128844f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128844f.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        ue ueVar = (ue) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    re reVar = new re();
                    if (bArr2 != null && bArr2.length > 0) {
                        reVar.a(bArr2);
                    }
                    ueVar.f128844f.add(reVar);
                }
                return 0;
            }
            ueVar.f128843e = aVar3.b(intValue);
            return 0;
        }
        ueVar.f128842d = aVar3.i(intValue);
        return 0;
    }
}
