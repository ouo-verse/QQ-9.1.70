package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127981d;

    /* renamed from: e, reason: collision with root package name */
    public String f127982e;

    /* renamed from: f, reason: collision with root package name */
    public String f127983f;

    /* renamed from: g, reason: collision with root package name */
    public int f127984g;

    /* renamed from: h, reason: collision with root package name */
    public String f127985h;

    /* renamed from: i, reason: collision with root package name */
    public String f127986i;

    /* renamed from: j, reason: collision with root package name */
    public String f127987j;

    /* renamed from: k, reason: collision with root package name */
    public String f127988k;

    /* renamed from: l, reason: collision with root package name */
    public String f127989l;

    /* renamed from: m, reason: collision with root package name */
    public String f127990m;

    /* renamed from: n, reason: collision with root package name */
    public String f127991n;

    /* renamed from: o, reason: collision with root package name */
    public int f127992o;

    /* renamed from: p, reason: collision with root package name */
    public int f127993p;

    /* renamed from: q, reason: collision with root package name */
    public int f127994q;

    /* renamed from: r, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127995r;

    /* renamed from: s, reason: collision with root package name */
    public LinkedList f127996s = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127981d);
            String str = this.f127982e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127983f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127984g);
            String str3 = this.f127985h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127986i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f127987j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            String str6 = this.f127988k;
            if (str6 != null) {
                aVar.a(8, str6);
            }
            String str7 = this.f127989l;
            if (str7 != null) {
                aVar.a(10, str7);
            }
            String str8 = this.f127990m;
            if (str8 != null) {
                aVar.a(11, str8);
            }
            String str9 = this.f127991n;
            if (str9 != null) {
                aVar.a(12, str9);
            }
            aVar.b(13, this.f127992o);
            aVar.b(14, this.f127993p);
            aVar.b(15, this.f127994q);
            com.tencent.luggage.wxa.fn.c cVar = this.f127995r;
            if (cVar != null) {
                aVar.a(16, cVar);
            }
            aVar.a(17, 8, this.f127996s);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127981d) + 0;
            String str10 = this.f127982e;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str10);
            }
            String str11 = this.f127983f;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str11);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127984g);
            String str12 = this.f127985h;
            if (str12 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, str12);
            }
            String str13 = this.f127986i;
            if (str13 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(6, str13);
            }
            String str14 = this.f127987j;
            if (str14 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(7, str14);
            }
            String str15 = this.f127988k;
            if (str15 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(8, str15);
            }
            String str16 = this.f127989l;
            if (str16 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(10, str16);
            }
            String str17 = this.f127990m;
            if (str17 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str17);
            }
            String str18 = this.f127991n;
            if (str18 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(12, str18);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(13, this.f127992o) + com.tencent.luggage.wxa.gr.a.b(14, this.f127993p) + com.tencent.luggage.wxa.gr.a.b(15, this.f127994q);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127995r;
            if (cVar2 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(16, cVar2);
            }
            return b18 + com.tencent.luggage.wxa.gr.a.a(17, 8, this.f127996s);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127996s.clear();
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
        k2 k2Var = (k2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                k2Var.f127981d = aVar3.f(intValue);
                return 0;
            case 2:
                k2Var.f127982e = aVar3.i(intValue);
                return 0;
            case 3:
                k2Var.f127983f = aVar3.i(intValue);
                return 0;
            case 4:
                k2Var.f127984g = aVar3.f(intValue);
                return 0;
            case 5:
                k2Var.f127985h = aVar3.i(intValue);
                return 0;
            case 6:
                k2Var.f127986i = aVar3.i(intValue);
                return 0;
            case 7:
                k2Var.f127987j = aVar3.i(intValue);
                return 0;
            case 8:
                k2Var.f127988k = aVar3.i(intValue);
                return 0;
            case 9:
            default:
                return -1;
            case 10:
                k2Var.f127989l = aVar3.i(intValue);
                return 0;
            case 11:
                k2Var.f127990m = aVar3.i(intValue);
                return 0;
            case 12:
                k2Var.f127991n = aVar3.i(intValue);
                return 0;
            case 13:
                k2Var.f127992o = aVar3.f(intValue);
                return 0;
            case 14:
                k2Var.f127993p = aVar3.f(intValue);
                return 0;
            case 15:
                k2Var.f127994q = aVar3.f(intValue);
                return 0;
            case 16:
                k2Var.f127995r = aVar3.b(intValue);
                return 0;
            case 17:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    s4 s4Var = new s4();
                    if (bArr2 != null && bArr2.length > 0) {
                        s4Var.a(bArr2);
                    }
                    k2Var.f127996s.add(s4Var);
                }
                return 0;
        }
    }
}
