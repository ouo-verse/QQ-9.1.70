package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128345d;

    /* renamed from: e, reason: collision with root package name */
    public p9 f128346e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128345d;
            if (str != null) {
                aVar.a(1, str);
            }
            p9 p9Var = this.f128346e;
            if (p9Var != null) {
                aVar.c(2, p9Var.a());
                this.f128346e.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128345d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            p9 p9Var2 = this.f128346e;
            if (p9Var2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(2, p9Var2.a());
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
        o9 o9Var = (o9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                p9 p9Var3 = new p9();
                if (bArr != null && bArr.length > 0) {
                    p9Var3.a(bArr);
                }
                o9Var.f128346e = p9Var3;
            }
            return 0;
        }
        o9Var.f128345d = aVar3.i(intValue);
        return 0;
    }
}
