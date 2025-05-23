package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127909d;

    /* renamed from: e, reason: collision with root package name */
    public int f127910e;

    /* renamed from: f, reason: collision with root package name */
    public String f127911f;

    /* renamed from: g, reason: collision with root package name */
    public String f127912g;

    /* renamed from: h, reason: collision with root package name */
    public String f127913h;

    /* renamed from: i, reason: collision with root package name */
    public String f127914i;

    /* renamed from: j, reason: collision with root package name */
    public int f127915j;

    /* renamed from: k, reason: collision with root package name */
    public String f127916k;

    /* renamed from: l, reason: collision with root package name */
    public String f127917l;

    /* renamed from: m, reason: collision with root package name */
    public String f127918m;

    /* renamed from: n, reason: collision with root package name */
    public String f127919n;

    /* renamed from: o, reason: collision with root package name */
    public String f127920o;

    /* renamed from: p, reason: collision with root package name */
    public String f127921p;

    /* renamed from: q, reason: collision with root package name */
    public x4 f127922q;

    /* renamed from: r, reason: collision with root package name */
    public q f127923r;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127909d);
            aVar.b(2, this.f127910e);
            String str = this.f127911f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f127912g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127913h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127914i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            aVar.b(7, this.f127915j);
            String str5 = this.f127916k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            String str6 = this.f127917l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            String str7 = this.f127918m;
            if (str7 != null) {
                aVar.a(10, str7);
            }
            String str8 = this.f127919n;
            if (str8 != null) {
                aVar.a(11, str8);
            }
            String str9 = this.f127920o;
            if (str9 != null) {
                aVar.a(12, str9);
            }
            String str10 = this.f127921p;
            if (str10 != null) {
                aVar.a(13, str10);
            }
            x4 x4Var = this.f127922q;
            if (x4Var != null) {
                aVar.c(20, x4Var.a());
                this.f127922q.a(aVar);
            }
            q qVar = this.f127923r;
            if (qVar != null) {
                aVar.c(21, qVar.a());
                this.f127923r.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127909d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f127910e);
            String str11 = this.f127911f;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str11);
            }
            String str12 = this.f127912g;
            if (str12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str12);
            }
            String str13 = this.f127913h;
            if (str13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str13);
            }
            String str14 = this.f127914i;
            if (str14 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str14);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f127915j);
            String str15 = this.f127916k;
            if (str15 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(8, str15);
            }
            String str16 = this.f127917l;
            if (str16 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str16);
            }
            String str17 = this.f127918m;
            if (str17 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(10, str17);
            }
            String str18 = this.f127919n;
            if (str18 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str18);
            }
            String str19 = this.f127920o;
            if (str19 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str19);
            }
            String str20 = this.f127921p;
            if (str20 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(13, str20);
            }
            x4 x4Var2 = this.f127922q;
            if (x4Var2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.c(20, x4Var2.a());
            }
            q qVar2 = this.f127923r;
            if (qVar2 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.c(21, qVar2.a());
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
        j jVar = (j) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 20) {
            if (intValue != 21) {
                switch (intValue) {
                    case 1:
                        jVar.f127909d = aVar3.f(intValue);
                        return 0;
                    case 2:
                        jVar.f127910e = aVar3.f(intValue);
                        return 0;
                    case 3:
                        jVar.f127911f = aVar3.i(intValue);
                        return 0;
                    case 4:
                        jVar.f127912g = aVar3.i(intValue);
                        return 0;
                    case 5:
                        jVar.f127913h = aVar3.i(intValue);
                        return 0;
                    case 6:
                        jVar.f127914i = aVar3.i(intValue);
                        return 0;
                    case 7:
                        jVar.f127915j = aVar3.f(intValue);
                        return 0;
                    case 8:
                        jVar.f127916k = aVar3.i(intValue);
                        return 0;
                    case 9:
                        jVar.f127917l = aVar3.i(intValue);
                        return 0;
                    case 10:
                        jVar.f127918m = aVar3.i(intValue);
                        return 0;
                    case 11:
                        jVar.f127919n = aVar3.i(intValue);
                        return 0;
                    case 12:
                        jVar.f127920o = aVar3.i(intValue);
                        return 0;
                    case 13:
                        jVar.f127921p = aVar3.i(intValue);
                        return 0;
                    default:
                        return -1;
                }
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr = (byte[]) h16.get(i16);
                q qVar3 = new q();
                if (bArr != null && bArr.length > 0) {
                    qVar3.a(bArr);
                }
                jVar.f127923r = qVar3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i17 = 0; i17 < size2; i17++) {
            byte[] bArr2 = (byte[]) h17.get(i17);
            x4 x4Var3 = new x4();
            if (bArr2 != null && bArr2.length > 0) {
                x4Var3.a(bArr2);
            }
            jVar.f127922q = x4Var3;
        }
        return 0;
    }
}
