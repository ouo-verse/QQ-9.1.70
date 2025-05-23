package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f128730e;

    /* renamed from: f, reason: collision with root package name */
    public String f128731f;

    /* renamed from: g, reason: collision with root package name */
    public String f128732g;

    /* renamed from: h, reason: collision with root package name */
    public String f128733h;

    /* renamed from: i, reason: collision with root package name */
    public String f128734i;

    /* renamed from: j, reason: collision with root package name */
    public int f128735j;

    /* renamed from: k, reason: collision with root package name */
    public String f128736k;

    /* renamed from: l, reason: collision with root package name */
    public String f128737l;

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
            c5 c5Var = this.f128730e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f128730e.a(aVar);
            }
            String str = this.f128731f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f128732g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128733h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128734i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            aVar.b(7, this.f128735j);
            String str5 = this.f128736k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            String str6 = this.f128737l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            c5 c5Var2 = this.f128730e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            String str7 = this.f128731f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f128732g;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            String str9 = this.f128733h;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f128734i;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(6, str10);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128735j);
            String str11 = this.f128736k;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str11);
            }
            String str12 = this.f128737l;
            if (str12 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(9, str12);
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
        t5 t5Var = (t5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    t5Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    c5 c5Var3 = new c5();
                    if (bArr2 != null && bArr2.length > 0) {
                        c5Var3.a(bArr2);
                    }
                    t5Var.f128730e = c5Var3;
                }
                return 0;
            case 3:
                t5Var.f128731f = aVar3.i(intValue);
                return 0;
            case 4:
                t5Var.f128732g = aVar3.i(intValue);
                return 0;
            case 5:
                t5Var.f128733h = aVar3.i(intValue);
                return 0;
            case 6:
                t5Var.f128734i = aVar3.i(intValue);
                return 0;
            case 7:
                t5Var.f128735j = aVar3.f(intValue);
                return 0;
            case 8:
                t5Var.f128736k = aVar3.i(intValue);
                return 0;
            case 9:
                t5Var.f128737l = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
