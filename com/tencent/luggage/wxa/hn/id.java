package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class id extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public yb f127897d;

    /* renamed from: e, reason: collision with root package name */
    public zc f127898e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            yb ybVar = this.f127897d;
            if (ybVar != null) {
                aVar.c(1, ybVar.a());
                this.f127897d.a(aVar);
            }
            zc zcVar = this.f127898e;
            if (zcVar != null) {
                aVar.c(2, zcVar.a());
                this.f127898e.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            yb ybVar2 = this.f127897d;
            if (ybVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, ybVar2.a());
            }
            zc zcVar2 = this.f127898e;
            if (zcVar2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(2, zcVar2.a());
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
        id idVar = (id) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                zc zcVar3 = new zc();
                if (bArr != null && bArr.length > 0) {
                    zcVar3.a(bArr);
                }
                idVar.f127898e = zcVar3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            yb ybVar3 = new yb();
            if (bArr2 != null && bArr2.length > 0) {
                ybVar3.a(bArr2);
            }
            idVar.f127897d = ybVar3;
        }
        return 0;
    }
}
