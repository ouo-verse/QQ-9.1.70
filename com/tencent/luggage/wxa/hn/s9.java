package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s9 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128672e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128673f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public String f128674g;

    /* renamed from: h, reason: collision with root package name */
    public String f128675h;

    /* renamed from: i, reason: collision with root package name */
    public String f128676i;

    /* renamed from: j, reason: collision with root package name */
    public String f128677j;

    /* renamed from: k, reason: collision with root package name */
    public String f128678k;

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
            String str = this.f128672e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 2, this.f128673f);
            String str2 = this.f128674g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128675h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128676i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f128677j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            String str6 = this.f128678k;
            if (str6 != null) {
                aVar.a(8, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str7 = this.f128672e;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str7);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 2, this.f128673f);
            String str8 = this.f128674g;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            String str9 = this.f128675h;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f128676i;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str10);
            }
            String str11 = this.f128677j;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str11);
            }
            String str12 = this.f128678k;
            if (str12 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(8, str12);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128673f.clear();
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
        s9 s9Var = (s9) objArr[1];
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
                    s9Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                s9Var.f128672e = aVar3.i(intValue);
                return 0;
            case 3:
                s9Var.f128673f.add(Integer.valueOf(aVar3.f(intValue)));
                return 0;
            case 4:
                s9Var.f128674g = aVar3.i(intValue);
                return 0;
            case 5:
                s9Var.f128675h = aVar3.i(intValue);
                return 0;
            case 6:
                s9Var.f128676i = aVar3.i(intValue);
                return 0;
            case 7:
                s9Var.f128677j = aVar3.i(intValue);
                return 0;
            case 8:
                s9Var.f128678k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
