package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j4 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f127939e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127940f = new LinkedList();

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
            wd wdVar = this.f127939e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f127939e.a(aVar);
            }
            aVar.a(3, 8, this.f127940f);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f127939e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127940f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127940f.clear();
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
        j4 j4Var = (j4) objArr[1];
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
                    eg egVar = new eg();
                    if (bArr2 != null && bArr2.length > 0) {
                        egVar.a(bArr2);
                    }
                    j4Var.f127940f.add(egVar);
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr3 = (byte[]) h17.get(i18);
                wd wdVar3 = new wd();
                if (bArr3 != null && bArr3.length > 0) {
                    wdVar3.a(bArr3);
                }
                j4Var.f127939e = wdVar3;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr4 = (byte[]) h18.get(i19);
            h0 h0Var3 = new h0();
            if (bArr4 != null && bArr4.length > 0) {
                h0Var3.a(bArr4);
            }
            j4Var.f128743d = h0Var3;
        }
        return 0;
    }
}
