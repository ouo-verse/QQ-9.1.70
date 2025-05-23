package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ta extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128746d;

    /* renamed from: e, reason: collision with root package name */
    public rh f128747e;

    /* renamed from: f, reason: collision with root package name */
    public String f128748f;

    /* renamed from: g, reason: collision with root package name */
    public int f128749g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128746d;
            if (str != null) {
                aVar.a(1, str);
            }
            rh rhVar = this.f128747e;
            if (rhVar != null) {
                aVar.c(2, rhVar.a());
                this.f128747e.a(aVar);
            }
            String str2 = this.f128748f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128749g);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128746d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            rh rhVar2 = this.f128747e;
            if (rhVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, rhVar2.a());
            }
            String str4 = this.f128748f;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128749g);
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
        ta taVar = (ta) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    taVar.f128749g = aVar3.f(intValue);
                    return 0;
                }
                taVar.f128748f = aVar3.i(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                rh rhVar3 = new rh();
                if (bArr != null && bArr.length > 0) {
                    rhVar3.a(bArr);
                }
                taVar.f128747e = rhVar3;
            }
            return 0;
        }
        taVar.f128746d = aVar3.i(intValue);
        return 0;
    }
}
