package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128049d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public m1 f128050e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128049d);
            m1 m1Var = this.f128050e;
            if (m1Var != null) {
                aVar.c(2, m1Var.a());
                this.f128050e.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128049d) + 0;
            m1 m1Var2 = this.f128050e;
            if (m1Var2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(2, m1Var2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128049d.clear();
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
        l1 l1Var = (l1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr2 = (byte[]) h16.get(i16);
                m1 m1Var3 = new m1();
                if (bArr2 != null && bArr2.length > 0) {
                    m1Var3.a(bArr2);
                }
                l1Var.f128050e = m1Var3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i17 = 0; i17 < size2; i17++) {
            byte[] bArr3 = (byte[]) h17.get(i17);
            ke keVar = new ke();
            if (bArr3 != null && bArr3.length > 0) {
                keVar.a(bArr3);
            }
            l1Var.f128049d.add(keVar);
        }
        return 0;
    }
}
