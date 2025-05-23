package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class fd extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public xb f127632d;

    /* renamed from: e, reason: collision with root package name */
    public String f127633e;

    /* renamed from: f, reason: collision with root package name */
    public String f127634f;

    /* renamed from: g, reason: collision with root package name */
    public String f127635g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            xb xbVar = this.f127632d;
            if (xbVar != null) {
                aVar.c(1, xbVar.a());
                this.f127632d.a(aVar);
            }
            String str = this.f127633e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127634f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127635g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            xb xbVar2 = this.f127632d;
            if (xbVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, xbVar2.a());
            }
            String str4 = this.f127633e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127634f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f127635g;
            if (str6 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(4, str6);
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
        fd fdVar = (fd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    fdVar.f127635g = aVar3.i(intValue);
                    return 0;
                }
                fdVar.f127634f = aVar3.i(intValue);
                return 0;
            }
            fdVar.f127633e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            xb xbVar3 = new xb();
            if (bArr != null && bArr.length > 0) {
                xbVar3.a(bArr);
            }
            fdVar.f127632d = xbVar3;
        }
        return 0;
    }
}
