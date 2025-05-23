package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s7 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public ta f128669e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128670f = new LinkedList();

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
            ta taVar = this.f128669e;
            if (taVar != null) {
                aVar.c(2, taVar.a());
                this.f128669e.a(aVar);
            }
            aVar.a(3, 8, this.f128670f);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            ta taVar2 = this.f128669e;
            if (taVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, taVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128670f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128670f.clear();
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
        s7 s7Var = (s7) objArr[1];
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
                    ta taVar3 = new ta();
                    if (bArr2 != null && bArr2.length > 0) {
                        taVar3.a(bArr2);
                    }
                    s7Var.f128670f.add(taVar3);
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr3 = (byte[]) h17.get(i18);
                ta taVar4 = new ta();
                if (bArr3 != null && bArr3.length > 0) {
                    taVar4.a(bArr3);
                }
                s7Var.f128669e = taVar4;
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
            s7Var.f128743d = h0Var3;
        }
        return 0;
    }
}
