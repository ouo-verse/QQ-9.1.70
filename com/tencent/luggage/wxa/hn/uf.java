package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class uf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public tf f128845d;

    /* renamed from: e, reason: collision with root package name */
    public z0 f128846e;

    /* renamed from: f, reason: collision with root package name */
    public int f128847f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            tf tfVar = this.f128845d;
            if (tfVar != null) {
                aVar.c(1, tfVar.a());
                this.f128845d.a(aVar);
            }
            z0 z0Var = this.f128846e;
            if (z0Var != null) {
                aVar.c(2, z0Var.a());
                this.f128846e.a(aVar);
            }
            aVar.b(3, this.f128847f);
            return 0;
        }
        if (i3 == 1) {
            tf tfVar2 = this.f128845d;
            if (tfVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, tfVar2.a());
            }
            z0 z0Var2 = this.f128846e;
            if (z0Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, z0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128847f);
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
        uf ufVar = (uf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                ufVar.f128847f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                z0 z0Var3 = new z0();
                if (bArr != null && bArr.length > 0) {
                    z0Var3.a(bArr);
                }
                ufVar.f128846e = z0Var3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            tf tfVar3 = new tf();
            if (bArr2 != null && bArr2.length > 0) {
                tfVar3.a(bArr2);
            }
            ufVar.f128845d = tfVar3;
        }
        return 0;
    }
}
