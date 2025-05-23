package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127742e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public String f127743f;

    /* renamed from: g, reason: collision with root package name */
    public int f127744g;

    /* renamed from: h, reason: collision with root package name */
    public int f127745h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(1, h0Var.a());
                this.f128743d.a(aVar);
            }
            aVar.a(2, 8, this.f127742e);
            String str = this.f127743f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.b(4, this.f127744g);
            aVar.b(5, this.f127745h);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127742e);
            String str2 = this.f127743f;
            if (str2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str2);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127744g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127745h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127742e.clear();
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
        h3 h3Var = (h3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        h3Var.f127745h = aVar3.f(intValue);
                        return 0;
                    }
                    h3Var.f127744g = aVar3.f(intValue);
                    return 0;
                }
                h3Var.f127743f = aVar3.i(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                ea eaVar = new ea();
                if (bArr2 != null && bArr2.length > 0) {
                    eaVar.a(bArr2);
                }
                h3Var.f127742e.add(eaVar);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            h0 h0Var3 = new h0();
            if (bArr3 != null && bArr3.length > 0) {
                h0Var3.a(bArr3);
            }
            h3Var.f128743d = h0Var3;
        }
        return 0;
    }
}
