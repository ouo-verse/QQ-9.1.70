package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public n1 f127313d;

    /* renamed from: e, reason: collision with root package name */
    public n1 f127314e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            n1 n1Var = this.f127313d;
            if (n1Var != null) {
                aVar.c(1, n1Var.a());
                this.f127313d.a(aVar);
            }
            n1 n1Var2 = this.f127314e;
            if (n1Var2 != null) {
                aVar.c(2, n1Var2.a());
                this.f127314e.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            n1 n1Var3 = this.f127313d;
            if (n1Var3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, n1Var3.a());
            }
            n1 n1Var4 = this.f127314e;
            if (n1Var4 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(2, n1Var4.a());
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
        b bVar = (b) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                n1 n1Var5 = new n1();
                if (bArr != null && bArr.length > 0) {
                    n1Var5.a(bArr);
                }
                bVar.f127314e = n1Var5;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            n1 n1Var6 = new n1();
            if (bArr2 != null && bArr2.length > 0) {
                n1Var6.a(bArr2);
            }
            bVar.f127313d = n1Var6;
        }
        return 0;
    }
}
