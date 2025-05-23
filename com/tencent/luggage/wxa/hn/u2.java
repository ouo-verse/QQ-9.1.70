package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128792d;

    /* renamed from: e, reason: collision with root package name */
    public String f128793e;

    /* renamed from: f, reason: collision with root package name */
    public String f128794f;

    /* renamed from: g, reason: collision with root package name */
    public int f128795g;

    /* renamed from: h, reason: collision with root package name */
    public int f128796h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f128797i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f128798j;

    /* renamed from: k, reason: collision with root package name */
    public r8 f128799k;

    /* renamed from: l, reason: collision with root package name */
    public String f128800l;

    /* renamed from: m, reason: collision with root package name */
    public String f128801m;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128792d);
            String str = this.f128793e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128794f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128795g);
            aVar.b(5, this.f128796h);
            aVar.a(6, this.f128797i);
            aVar.a(7, this.f128798j);
            r8 r8Var = this.f128799k;
            if (r8Var != null) {
                aVar.c(20, r8Var.a());
                this.f128799k.a(aVar);
            }
            String str3 = this.f128800l;
            if (str3 != null) {
                aVar.a(21, str3);
            }
            String str4 = this.f128801m;
            if (str4 != null) {
                aVar.a(22, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128792d) + 0;
            String str5 = this.f128793e;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128794f;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128795g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128796h) + com.tencent.luggage.wxa.gr.a.a(6, this.f128797i) + com.tencent.luggage.wxa.gr.a.a(7, this.f128798j);
            r8 r8Var2 = this.f128799k;
            if (r8Var2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.c(20, r8Var2.a());
            }
            String str7 = this.f128800l;
            if (str7 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(21, str7);
            }
            String str8 = this.f128801m;
            if (str8 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.a(22, str8);
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
        u2 u2Var = (u2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                u2Var.f128792d = aVar3.f(intValue);
                return 0;
            case 2:
                u2Var.f128793e = aVar3.i(intValue);
                return 0;
            case 3:
                u2Var.f128794f = aVar3.i(intValue);
                return 0;
            case 4:
                u2Var.f128795g = aVar3.f(intValue);
                return 0;
            case 5:
                u2Var.f128796h = aVar3.f(intValue);
                return 0;
            case 6:
                u2Var.f128797i = aVar3.a(intValue);
                return 0;
            case 7:
                u2Var.f128798j = aVar3.a(intValue);
                return 0;
            default:
                switch (intValue) {
                    case 20:
                        LinkedList h16 = aVar3.h(intValue);
                        int size = h16.size();
                        for (int i16 = 0; i16 < size; i16++) {
                            byte[] bArr = (byte[]) h16.get(i16);
                            r8 r8Var3 = new r8();
                            if (bArr != null && bArr.length > 0) {
                                r8Var3.a(bArr);
                            }
                            u2Var.f128799k = r8Var3;
                        }
                        return 0;
                    case 21:
                        u2Var.f128800l = aVar3.i(intValue);
                        return 0;
                    case 22:
                        u2Var.f128801m = aVar3.i(intValue);
                        return 0;
                    default:
                        return -1;
                }
        }
    }
}
