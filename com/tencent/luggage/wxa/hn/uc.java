package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class uc extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128839d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128840e = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128839d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, 1, this.f128840e);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128839d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, 1, this.f128840e);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128840e.clear();
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
        uc ucVar = (uc) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            ucVar.f128840e.add(aVar3.i(intValue));
            return 0;
        }
        ucVar.f128839d = aVar3.i(intValue);
        return 0;
    }
}
