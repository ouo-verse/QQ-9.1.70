package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class na extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128277e;

    /* renamed from: f, reason: collision with root package name */
    public int f128278f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128279g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public String f128280h;

    /* renamed from: i, reason: collision with root package name */
    public int f128281i;

    /* renamed from: j, reason: collision with root package name */
    public int f128282j;

    /* renamed from: k, reason: collision with root package name */
    public String f128283k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128284l;

    /* renamed from: m, reason: collision with root package name */
    public q7 f128285m;

    /* renamed from: n, reason: collision with root package name */
    public int f128286n;

    /* renamed from: o, reason: collision with root package name */
    public int f128287o;

    /* renamed from: p, reason: collision with root package name */
    public String f128288p;

    /* renamed from: q, reason: collision with root package name */
    public String f128289q;

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
            String str = this.f128277e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f128278f);
            aVar.a(4, 8, this.f128279g);
            String str2 = this.f128280h;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            aVar.b(7, this.f128281i);
            aVar.b(8, this.f128282j);
            String str3 = this.f128283k;
            if (str3 != null) {
                aVar.a(9, str3);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128284l;
            if (cVar != null) {
                aVar.a(10, cVar);
            }
            q7 q7Var = this.f128285m;
            if (q7Var != null) {
                aVar.c(11, q7Var.a());
                this.f128285m.a(aVar);
            }
            aVar.b(12, this.f128286n);
            aVar.b(13, this.f128287o);
            String str4 = this.f128288p;
            if (str4 != null) {
                aVar.a(14, str4);
            }
            String str5 = this.f128289q;
            if (str5 != null) {
                aVar.a(15, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a()) + 0;
            }
            String str6 = this.f128277e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128278f) + com.tencent.luggage.wxa.gr.a.a(4, 8, this.f128279g);
            String str7 = this.f128280h;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str7);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128281i) + com.tencent.luggage.wxa.gr.a.b(8, this.f128282j);
            String str8 = this.f128283k;
            if (str8 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str8);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128284l;
            if (cVar2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(10, cVar2);
            }
            q7 q7Var2 = this.f128285m;
            if (q7Var2 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.c(11, q7Var2.a());
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(12, this.f128286n) + com.tencent.luggage.wxa.gr.a.b(13, this.f128287o);
            String str9 = this.f128288p;
            if (str9 != null) {
                b18 += com.tencent.luggage.wxa.gr.a.a(14, str9);
            }
            String str10 = this.f128289q;
            if (str10 != null) {
                return b18 + com.tencent.luggage.wxa.gr.a.a(15, str10);
            }
            return b18;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128279g.clear();
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
        na naVar = (na) objArr[1];
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
                    naVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                naVar.f128277e = aVar3.i(intValue);
                return 0;
            case 3:
                naVar.f128278f = aVar3.f(intValue);
                return 0;
            case 4:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    ma maVar = new ma();
                    if (bArr3 != null && bArr3.length > 0) {
                        maVar.a(bArr3);
                    }
                    naVar.f128279g.add(maVar);
                }
                return 0;
            case 5:
            default:
                return -1;
            case 6:
                naVar.f128280h = aVar3.i(intValue);
                return 0;
            case 7:
                naVar.f128281i = aVar3.f(intValue);
                return 0;
            case 8:
                naVar.f128282j = aVar3.f(intValue);
                return 0;
            case 9:
                naVar.f128283k = aVar3.i(intValue);
                return 0;
            case 10:
                naVar.f128284l = aVar3.b(intValue);
                return 0;
            case 11:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    q7 q7Var3 = new q7();
                    if (bArr4 != null && bArr4.length > 0) {
                        q7Var3.a(bArr4);
                    }
                    naVar.f128285m = q7Var3;
                }
                return 0;
            case 12:
                naVar.f128286n = aVar3.f(intValue);
                return 0;
            case 13:
                naVar.f128287o = aVar3.f(intValue);
                return 0;
            case 14:
                naVar.f128288p = aVar3.i(intValue);
                return 0;
            case 15:
                naVar.f128289q = aVar3.i(intValue);
                return 0;
        }
    }
}
