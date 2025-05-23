package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class rd extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128615e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public String f128616f;

    /* renamed from: g, reason: collision with root package name */
    public String f128617g;

    /* renamed from: h, reason: collision with root package name */
    public String f128618h;

    /* renamed from: i, reason: collision with root package name */
    public String f128619i;

    /* renamed from: j, reason: collision with root package name */
    public String f128620j;

    /* renamed from: k, reason: collision with root package name */
    public int f128621k;

    /* renamed from: l, reason: collision with root package name */
    public String f128622l;

    /* renamed from: m, reason: collision with root package name */
    public String f128623m;

    /* renamed from: n, reason: collision with root package name */
    public String f128624n;

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
            aVar.a(2, 8, this.f128615e);
            String str = this.f128616f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f128617g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128618h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f128619i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f128620j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            aVar.b(8, this.f128621k);
            String str6 = this.f128622l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            String str7 = this.f128623m;
            if (str7 != null) {
                aVar.a(10, str7);
            }
            String str8 = this.f128624n;
            if (str8 != null) {
                aVar.a(11, str8);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128615e);
            String str9 = this.f128616f;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            String str10 = this.f128617g;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f128618h;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f128619i;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str12);
            }
            String str13 = this.f128620j;
            if (str13 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str13);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(8, this.f128621k);
            String str14 = this.f128622l;
            if (str14 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str14);
            }
            String str15 = this.f128623m;
            if (str15 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(10, str15);
            }
            String str16 = this.f128624n;
            if (str16 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(11, str16);
            }
            return b16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128615e.clear();
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
        rd rdVar = (rd) objArr[1];
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
                    rdVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    qd qdVar = new qd();
                    if (bArr3 != null && bArr3.length > 0) {
                        qdVar.a(bArr3);
                    }
                    rdVar.f128615e.add(qdVar);
                }
                return 0;
            case 3:
                rdVar.f128616f = aVar3.i(intValue);
                return 0;
            case 4:
                rdVar.f128617g = aVar3.i(intValue);
                return 0;
            case 5:
                rdVar.f128618h = aVar3.i(intValue);
                return 0;
            case 6:
                rdVar.f128619i = aVar3.i(intValue);
                return 0;
            case 7:
                rdVar.f128620j = aVar3.i(intValue);
                return 0;
            case 8:
                rdVar.f128621k = aVar3.f(intValue);
                return 0;
            case 9:
                rdVar.f128622l = aVar3.i(intValue);
                return 0;
            case 10:
                rdVar.f128623m = aVar3.i(intValue);
                return 0;
            case 11:
                rdVar.f128624n = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
