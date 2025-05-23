package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f128882e;

    /* renamed from: f, reason: collision with root package name */
    public String f128883f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128884g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public String f128885h;

    /* renamed from: i, reason: collision with root package name */
    public String f128886i;

    /* renamed from: j, reason: collision with root package name */
    public String f128887j;

    /* renamed from: k, reason: collision with root package name */
    public String f128888k;

    /* renamed from: l, reason: collision with root package name */
    public String f128889l;

    /* renamed from: m, reason: collision with root package name */
    public int f128890m;

    /* renamed from: n, reason: collision with root package name */
    public String f128891n;

    /* renamed from: o, reason: collision with root package name */
    public String f128892o;

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
            c5 c5Var = this.f128882e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f128882e.a(aVar);
            }
            String str = this.f128883f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.a(4, 8, this.f128884g);
            String str2 = this.f128885h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f128886i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            String str4 = this.f128887j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f128888k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            String str6 = this.f128889l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            aVar.b(10, this.f128890m);
            String str7 = this.f128891n;
            if (str7 != null) {
                aVar.a(11, str7);
            }
            String str8 = this.f128892o;
            if (str8 != null) {
                aVar.a(12, str8);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            c5 c5Var2 = this.f128882e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            String str9 = this.f128883f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(4, 8, this.f128884g);
            String str10 = this.f128885h;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str10);
            }
            String str11 = this.f128886i;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str11);
            }
            String str12 = this.f128887j;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str12);
            }
            String str13 = this.f128888k;
            if (str13 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str13);
            }
            String str14 = this.f128889l;
            if (str14 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str14);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(10, this.f128890m);
            String str15 = this.f128891n;
            if (str15 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(11, str15);
            }
            String str16 = this.f128892o;
            if (str16 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(12, str16);
            }
            return b16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128884g.clear();
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
        v5 v5Var = (v5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr2 != null && bArr2.length > 0) {
                        h0Var3.a(bArr2);
                    }
                    v5Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    c5 c5Var3 = new c5();
                    if (bArr3 != null && bArr3.length > 0) {
                        c5Var3.a(bArr3);
                    }
                    v5Var.f128882e = c5Var3;
                }
                return 0;
            case 3:
                v5Var.f128883f = aVar3.i(intValue);
                return 0;
            case 4:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    m9 m9Var = new m9();
                    if (bArr4 != null && bArr4.length > 0) {
                        m9Var.a(bArr4);
                    }
                    v5Var.f128884g.add(m9Var);
                }
                return 0;
            case 5:
                v5Var.f128885h = aVar3.i(intValue);
                return 0;
            case 6:
                v5Var.f128886i = aVar3.i(intValue);
                return 0;
            case 7:
                v5Var.f128887j = aVar3.i(intValue);
                return 0;
            case 8:
                v5Var.f128888k = aVar3.i(intValue);
                return 0;
            case 9:
                v5Var.f128889l = aVar3.i(intValue);
                return 0;
            case 10:
                v5Var.f128890m = aVar3.f(intValue);
                return 0;
            case 11:
                v5Var.f128891n = aVar3.i(intValue);
                return 0;
            case 12:
                v5Var.f128892o = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
