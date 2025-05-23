package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ie extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127899e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public i8 f127900f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            g0 g0Var = this.f128671d;
            if (g0Var != null) {
                aVar.c(1, g0Var.a());
                this.f128671d.a(aVar);
            }
            aVar.a(2, 8, this.f127899e);
            i8 i8Var = this.f127900f;
            if (i8Var != null) {
                aVar.c(3, i8Var.a());
                this.f127900f.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127899e);
            i8 i8Var2 = this.f127900f;
            if (i8Var2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(3, i8Var2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127899e.clear();
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
        ie ieVar = (ie) objArr[1];
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
                    i8 i8Var3 = new i8();
                    if (bArr2 != null && bArr2.length > 0) {
                        i8Var3.a(bArr2);
                    }
                    ieVar.f127900f = i8Var3;
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr3 = (byte[]) h17.get(i18);
                pe peVar = new pe();
                if (bArr3 != null && bArr3.length > 0) {
                    peVar.a(bArr3);
                }
                ieVar.f127899e.add(peVar);
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr4 = (byte[]) h18.get(i19);
            g0 g0Var3 = new g0();
            if (bArr4 != null && bArr4.length > 0) {
                g0Var3.a(bArr4);
            }
            ieVar.f128671d = g0Var3;
        }
        return 0;
    }
}
