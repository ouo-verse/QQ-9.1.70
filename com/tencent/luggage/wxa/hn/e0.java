package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127530d;

    /* renamed from: e, reason: collision with root package name */
    public int f127531e;

    /* renamed from: f, reason: collision with root package name */
    public t7 f127532f;

    /* renamed from: g, reason: collision with root package name */
    public String f127533g;

    /* renamed from: h, reason: collision with root package name */
    public String f127534h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127530d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127531e);
            t7 t7Var = this.f127532f;
            if (t7Var != null) {
                aVar.c(3, t7Var.a());
                this.f127532f.a(aVar);
            }
            String str2 = this.f127533g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127534h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f127530d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127531e);
            t7 t7Var2 = this.f127532f;
            if (t7Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(3, t7Var2.a());
            }
            String str5 = this.f127533g;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            String str6 = this.f127534h;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(5, str6);
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
        e0 e0Var = (e0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        e0Var.f127534h = aVar3.i(intValue);
                        return 0;
                    }
                    e0Var.f127533g = aVar3.i(intValue);
                    return 0;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    t7 t7Var3 = new t7();
                    if (bArr != null && bArr.length > 0) {
                        t7Var3.a(bArr);
                    }
                    e0Var.f127532f = t7Var3;
                }
                return 0;
            }
            e0Var.f127531e = aVar3.f(intValue);
            return 0;
        }
        e0Var.f127530d = aVar3.i(intValue);
        return 0;
    }
}
