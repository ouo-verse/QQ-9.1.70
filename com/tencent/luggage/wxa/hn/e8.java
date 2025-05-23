package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e8 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public b8 f127557e;

    /* renamed from: f, reason: collision with root package name */
    public int f127558f;

    /* renamed from: g, reason: collision with root package name */
    public String f127559g;

    /* renamed from: h, reason: collision with root package name */
    public int f127560h;

    /* renamed from: i, reason: collision with root package name */
    public String f127561i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            b8 b8Var = this.f127557e;
            if (b8Var != null) {
                aVar.c(1, b8Var.a());
                this.f127557e.a(aVar);
            }
            aVar.b(2, this.f127558f);
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(3, h0Var.a());
                this.f128743d.a(aVar);
            }
            String str = this.f127559g;
            if (str != null) {
                aVar.a(4, str);
            }
            aVar.b(5, this.f127560h);
            String str2 = this.f127561i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            b8 b8Var2 = this.f127557e;
            if (b8Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, b8Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127558f);
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(3, h0Var2.a());
            }
            String str3 = this.f127559g;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str3);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127560h);
            String str4 = this.f127561i;
            if (str4 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.a(6, str4);
            }
            return b17;
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
        e8 e8Var = (e8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    b8 b8Var3 = new b8();
                    if (bArr != null && bArr.length > 0) {
                        b8Var3.a(bArr);
                    }
                    e8Var.f127557e = b8Var3;
                }
                return 0;
            case 2:
                e8Var.f127558f = aVar3.f(intValue);
                return 0;
            case 3:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    h0 h0Var3 = new h0();
                    if (bArr2 != null && bArr2.length > 0) {
                        h0Var3.a(bArr2);
                    }
                    e8Var.f128743d = h0Var3;
                }
                return 0;
            case 4:
                e8Var.f127559g = aVar3.i(intValue);
                return 0;
            case 5:
                e8Var.f127560h = aVar3.f(intValue);
                return 0;
            case 6:
                e8Var.f127561i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
