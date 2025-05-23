package com.tencent.luggage.wxa.d6;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f124086d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f124087e;

    /* renamed from: f, reason: collision with root package name */
    public String f124088f;

    /* renamed from: g, reason: collision with root package name */
    public String f124089g;

    /* renamed from: h, reason: collision with root package name */
    public int f124090h;

    /* renamed from: j, reason: collision with root package name */
    public int f124092j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f124093k;

    /* renamed from: m, reason: collision with root package name */
    public long f124095m;

    /* renamed from: o, reason: collision with root package name */
    public String f124097o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f124098p;

    /* renamed from: q, reason: collision with root package name */
    public int f124099q;

    /* renamed from: r, reason: collision with root package name */
    public String f124100r;

    /* renamed from: t, reason: collision with root package name */
    public int f124102t;

    /* renamed from: u, reason: collision with root package name */
    public int f124103u;

    /* renamed from: i, reason: collision with root package name */
    public LinkedList f124091i = new LinkedList();

    /* renamed from: l, reason: collision with root package name */
    public int f124094l = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f124096n = 0;

    /* renamed from: s, reason: collision with root package name */
    public boolean f124101s = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f124104v = false;

    /* renamed from: w, reason: collision with root package name */
    public int f124105w = -1;

    /* renamed from: x, reason: collision with root package name */
    public int f124106x = -1;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f124086d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.a(2, this.f124087e);
            String str2 = this.f124088f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f124089g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f124090h);
            aVar.a(6, 8, this.f124091i);
            aVar.b(7, this.f124092j);
            aVar.a(8, this.f124093k);
            aVar.b(9, this.f124094l);
            aVar.a(10, this.f124095m);
            aVar.b(11, this.f124096n);
            String str4 = this.f124097o;
            if (str4 != null) {
                aVar.a(12, str4);
            }
            aVar.a(13, this.f124098p);
            aVar.b(14, this.f124099q);
            String str5 = this.f124100r;
            if (str5 != null) {
                aVar.a(15, str5);
            }
            aVar.a(16, this.f124101s);
            aVar.b(17, this.f124102t);
            aVar.b(18, this.f124103u);
            aVar.a(19, this.f124104v);
            aVar.b(20, this.f124105w);
            aVar.b(21, this.f124106x);
            return 0;
        }
        if (i3 == 1) {
            String str6 = this.f124086d;
            if (str6 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.a(1, str6) + 0;
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f124087e);
            String str7 = this.f124088f;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f124089g;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(5, this.f124090h) + com.tencent.luggage.wxa.gr.a.a(6, 8, this.f124091i) + com.tencent.luggage.wxa.gr.a.b(7, this.f124092j) + com.tencent.luggage.wxa.gr.a.a(8, this.f124093k) + com.tencent.luggage.wxa.gr.a.b(9, this.f124094l) + com.tencent.luggage.wxa.gr.a.a(10, this.f124095m) + com.tencent.luggage.wxa.gr.a.b(11, this.f124096n);
            String str9 = this.f124097o;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(12, str9);
            }
            int a17 = b16 + com.tencent.luggage.wxa.gr.a.a(13, this.f124098p) + com.tencent.luggage.wxa.gr.a.b(14, this.f124099q);
            String str10 = this.f124100r;
            if (str10 != null) {
                a17 += com.tencent.luggage.wxa.gr.a.a(15, str10);
            }
            return a17 + com.tencent.luggage.wxa.gr.a.a(16, this.f124101s) + com.tencent.luggage.wxa.gr.a.b(17, this.f124102t) + com.tencent.luggage.wxa.gr.a.b(18, this.f124103u) + com.tencent.luggage.wxa.gr.a.a(19, this.f124104v) + com.tencent.luggage.wxa.gr.a.b(20, this.f124105w) + com.tencent.luggage.wxa.gr.a.b(21, this.f124106x);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f124091i.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a18 = com.tencent.luggage.wxa.fn.b.a(aVar2); a18 > 0; a18 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a18)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        b bVar = (b) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                bVar.f124086d = aVar3.i(intValue);
                return 0;
            case 2:
                bVar.f124087e = aVar3.a(intValue);
                return 0;
            case 3:
                bVar.f124088f = aVar3.i(intValue);
                return 0;
            case 4:
                bVar.f124089g = aVar3.i(intValue);
                return 0;
            case 5:
                bVar.f124090h = aVar3.f(intValue);
                return 0;
            case 6:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    a aVar4 = new a();
                    if (bArr2 != null && bArr2.length > 0) {
                        aVar4.a(bArr2);
                    }
                    bVar.f124091i.add(aVar4);
                }
                return 0;
            case 7:
                bVar.f124092j = aVar3.f(intValue);
                return 0;
            case 8:
                bVar.f124093k = aVar3.a(intValue);
                return 0;
            case 9:
                bVar.f124094l = aVar3.f(intValue);
                return 0;
            case 10:
                bVar.f124095m = aVar3.g(intValue);
                return 0;
            case 11:
                bVar.f124096n = aVar3.f(intValue);
                return 0;
            case 12:
                bVar.f124097o = aVar3.i(intValue);
                return 0;
            case 13:
                bVar.f124098p = aVar3.a(intValue);
                return 0;
            case 14:
                bVar.f124099q = aVar3.f(intValue);
                return 0;
            case 15:
                bVar.f124100r = aVar3.i(intValue);
                return 0;
            case 16:
                bVar.f124101s = aVar3.a(intValue);
                return 0;
            case 17:
                bVar.f124102t = aVar3.f(intValue);
                return 0;
            case 18:
                bVar.f124103u = aVar3.f(intValue);
                return 0;
            case 19:
                bVar.f124104v = aVar3.a(intValue);
                return 0;
            case 20:
                bVar.f124105w = aVar3.f(intValue);
                return 0;
            case 21:
                bVar.f124106x = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
