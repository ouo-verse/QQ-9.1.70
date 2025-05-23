package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p8 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public o6 f128418e;

    /* renamed from: f, reason: collision with root package name */
    public String f128419f;

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
            o6 o6Var = this.f128418e;
            if (o6Var != null) {
                aVar.c(2, o6Var.a());
                this.f128418e.a(aVar);
            }
            String str = this.f128419f;
            if (str != null) {
                aVar.a(3, str);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            o6 o6Var2 = this.f128418e;
            if (o6Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, o6Var2.a());
            }
            String str2 = this.f128419f;
            if (str2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(3, str2);
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
        p8 p8Var = (p8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                p8Var.f128419f = aVar3.i(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                o6 o6Var3 = new o6();
                if (bArr != null && bArr.length > 0) {
                    o6Var3.a(bArr);
                }
                p8Var.f128418e = o6Var3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            g0 g0Var3 = new g0();
            if (bArr2 != null && bArr2.length > 0) {
                g0Var3.a(bArr2);
            }
            p8Var.f128671d = g0Var3;
        }
        return 0;
    }
}
