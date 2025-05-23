package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127731d;

    /* renamed from: e, reason: collision with root package name */
    public e9 f127732e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127731d);
            e9 e9Var = this.f127732e;
            if (e9Var != null) {
                aVar.c(2, e9Var.a());
                this.f127732e.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127731d) + 0;
            e9 e9Var2 = this.f127732e;
            if (e9Var2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(2, e9Var2.a());
            }
            return b16;
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
        h0 h0Var = (h0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr = (byte[]) h16.get(i16);
                e9 e9Var3 = new e9();
                if (bArr != null && bArr.length > 0) {
                    e9Var3.a(bArr);
                }
                h0Var.f127732e = e9Var3;
            }
            return 0;
        }
        h0Var.f127731d = aVar3.f(intValue);
        return 0;
    }
}
