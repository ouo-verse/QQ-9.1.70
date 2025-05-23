package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127999e;

    /* renamed from: f, reason: collision with root package name */
    public String f128000f;

    /* renamed from: g, reason: collision with root package name */
    public String f128001g;

    /* renamed from: h, reason: collision with root package name */
    public String f128002h;

    /* renamed from: i, reason: collision with root package name */
    public String f128003i;

    /* renamed from: j, reason: collision with root package name */
    public String f128004j;

    /* renamed from: k, reason: collision with root package name */
    public String f128005k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128006l;

    /* renamed from: m, reason: collision with root package name */
    public int f128007m;

    /* renamed from: n, reason: collision with root package name */
    public LinkedList f128008n = new LinkedList();

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
            String str = this.f127999e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128000f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128001g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f128002h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f128003i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            String str6 = this.f128004j;
            if (str6 != null) {
                aVar.a(7, str6);
            }
            String str7 = this.f128005k;
            if (str7 != null) {
                aVar.a(8, str7);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128006l;
            if (cVar != null) {
                aVar.a(9, cVar);
            }
            aVar.b(10, this.f128007m);
            aVar.a(11, 8, this.f128008n);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str8 = this.f127999e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            String str9 = this.f128000f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            String str10 = this.f128001g;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f128002h;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f128003i;
            if (str12 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(6, str12);
            }
            String str13 = this.f128004j;
            if (str13 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(7, str13);
            }
            String str14 = this.f128005k;
            if (str14 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(8, str14);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128006l;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(9, cVar2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(10, this.f128007m) + com.tencent.luggage.wxa.gr.a.a(11, 8, this.f128008n);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128008n.clear();
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
        k5 k5Var = (k5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr2 != null && bArr2.length > 0) {
                        g0Var3.a(bArr2);
                    }
                    k5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                k5Var.f127999e = aVar3.i(intValue);
                return 0;
            case 3:
                k5Var.f128000f = aVar3.i(intValue);
                return 0;
            case 4:
                k5Var.f128001g = aVar3.i(intValue);
                return 0;
            case 5:
                k5Var.f128002h = aVar3.i(intValue);
                return 0;
            case 6:
                k5Var.f128003i = aVar3.i(intValue);
                return 0;
            case 7:
                k5Var.f128004j = aVar3.i(intValue);
                return 0;
            case 8:
                k5Var.f128005k = aVar3.i(intValue);
                return 0;
            case 9:
                k5Var.f128006l = aVar3.b(intValue);
                return 0;
            case 10:
                k5Var.f128007m = aVar3.f(intValue);
                return 0;
            case 11:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    a6 a6Var = new a6();
                    if (bArr3 != null && bArr3.length > 0) {
                        a6Var.a(bArr3);
                    }
                    k5Var.f128008n.add(a6Var);
                }
                return 0;
            default:
                return -1;
        }
    }
}
