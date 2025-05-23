package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128102d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public int f128103e;

    /* renamed from: f, reason: collision with root package name */
    public int f128104f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f128105g;

    /* renamed from: h, reason: collision with root package name */
    public int f128106h;

    /* renamed from: i, reason: collision with root package name */
    public String f128107i;

    /* renamed from: j, reason: collision with root package name */
    public int f128108j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f128109k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f128110l;

    /* renamed from: m, reason: collision with root package name */
    public int f128111m;

    /* renamed from: n, reason: collision with root package name */
    public String f128112n;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128102d);
            aVar.b(2, this.f128103e);
            aVar.b(3, this.f128104f);
            aVar.a(4, this.f128105g);
            aVar.b(5, this.f128106h);
            String str = this.f128107i;
            if (str != null) {
                aVar.a(6, str);
            }
            aVar.b(7, this.f128108j);
            aVar.a(8, this.f128109k);
            aVar.a(9, this.f128110l);
            aVar.b(10, this.f128111m);
            String str2 = this.f128112n;
            if (str2 != null) {
                aVar.a(11, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128102d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f128103e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128104f) + com.tencent.luggage.wxa.gr.a.a(4, this.f128105g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128106h);
            String str3 = this.f128107i;
            if (str3 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str3);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128108j) + com.tencent.luggage.wxa.gr.a.a(8, this.f128109k) + com.tencent.luggage.wxa.gr.a.a(9, this.f128110l) + com.tencent.luggage.wxa.gr.a.b(10, this.f128111m);
            String str4 = this.f128112n;
            if (str4 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(11, str4);
            }
            return b16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128102d.clear();
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
        m1 m1Var = (m1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    f8 f8Var = new f8();
                    if (bArr2 != null && bArr2.length > 0) {
                        f8Var.a(bArr2);
                    }
                    m1Var.f128102d.add(f8Var);
                }
                return 0;
            case 2:
                m1Var.f128103e = aVar3.f(intValue);
                return 0;
            case 3:
                m1Var.f128104f = aVar3.f(intValue);
                return 0;
            case 4:
                m1Var.f128105g = aVar3.a(intValue);
                return 0;
            case 5:
                m1Var.f128106h = aVar3.f(intValue);
                return 0;
            case 6:
                m1Var.f128107i = aVar3.i(intValue);
                return 0;
            case 7:
                m1Var.f128108j = aVar3.f(intValue);
                return 0;
            case 8:
                m1Var.f128109k = aVar3.a(intValue);
                return 0;
            case 9:
                m1Var.f128110l = aVar3.a(intValue);
                return 0;
            case 10:
                m1Var.f128111m = aVar3.f(intValue);
                return 0;
            case 11:
                m1Var.f128112n = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
