package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128468d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public va f128469e;

    /* renamed from: f, reason: collision with root package name */
    public long f128470f;

    /* renamed from: g, reason: collision with root package name */
    public n f128471g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128468d);
            va vaVar = this.f128469e;
            if (vaVar != null) {
                aVar.c(2, vaVar.a());
                this.f128469e.a(aVar);
            }
            aVar.a(3, this.f128470f);
            n nVar = this.f128471g;
            if (nVar != null) {
                aVar.c(4, nVar.a());
                this.f128471g.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128468d) + 0;
            va vaVar2 = this.f128469e;
            if (vaVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(2, vaVar2.a());
            }
            int a17 = a16 + com.tencent.luggage.wxa.gr.a.a(3, this.f128470f);
            n nVar2 = this.f128471g;
            if (nVar2 != null) {
                return a17 + com.tencent.luggage.wxa.gr.a.c(4, nVar2.a());
            }
            return a17;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128468d.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a18 = com.tencent.luggage.wxa.fn.b.a(aVar2); a18 > 0; a18 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a18)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        q qVar = (q) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    LinkedList h16 = aVar3.h(intValue);
                    int size = h16.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        byte[] bArr2 = (byte[]) h16.get(i16);
                        n nVar3 = new n();
                        if (bArr2 != null && bArr2.length > 0) {
                            nVar3.a(bArr2);
                        }
                        qVar.f128471g = nVar3;
                    }
                    return 0;
                }
                qVar.f128470f = aVar3.g(intValue);
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i17 = 0; i17 < size2; i17++) {
                byte[] bArr3 = (byte[]) h17.get(i17);
                va vaVar3 = new va();
                if (bArr3 != null && bArr3.length > 0) {
                    vaVar3.a(bArr3);
                }
                qVar.f128469e = vaVar3;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i18 = 0; i18 < size3; i18++) {
            byte[] bArr4 = (byte[]) h18.get(i18);
            p pVar = new p();
            if (bArr4 != null && bArr4.length > 0) {
                pVar.a(bArr4);
            }
            qVar.f128468d.add(pVar);
        }
        return 0;
    }
}
