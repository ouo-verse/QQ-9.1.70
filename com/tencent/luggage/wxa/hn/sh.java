package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class sh extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f128692d;

    /* renamed from: e, reason: collision with root package name */
    public int f128693e;

    /* renamed from: f, reason: collision with root package name */
    public int f128694f;

    /* renamed from: g, reason: collision with root package name */
    public int f128695g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f128696h;

    /* renamed from: i, reason: collision with root package name */
    public int f128697i;

    /* renamed from: j, reason: collision with root package name */
    public String f128698j;

    /* renamed from: k, reason: collision with root package name */
    public String f128699k;

    /* renamed from: l, reason: collision with root package name */
    public int f128700l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f128701m;

    /* renamed from: n, reason: collision with root package name */
    public String f128702n;

    /* renamed from: o, reason: collision with root package name */
    public int f128703o;

    /* renamed from: p, reason: collision with root package name */
    public String f128704p;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f128692d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f128692d.a(aVar);
            }
            aVar.b(2, this.f128693e);
            aVar.b(3, this.f128694f);
            aVar.b(4, this.f128695g);
            aVar.a(5, this.f128696h);
            aVar.b(6, this.f128697i);
            String str = this.f128698j;
            if (str != null) {
                aVar.a(7, str);
            }
            String str2 = this.f128699k;
            if (str2 != null) {
                aVar.a(8, str2);
            }
            aVar.b(9, this.f128700l);
            aVar.a(10, this.f128701m);
            String str3 = this.f128702n;
            if (str3 != null) {
                aVar.a(11, str3);
            }
            aVar.b(12, this.f128703o);
            String str4 = this.f128704p;
            if (str4 != null) {
                aVar.a(13, str4);
                return 0;
            }
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f128692d;
            if (phVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
            } else {
                i16 = 0;
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128693e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128694f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128695g) + com.tencent.luggage.wxa.gr.a.a(5, this.f128696h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128697i);
            String str5 = this.f128698j;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str5);
            }
            String str6 = this.f128699k;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str6);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(9, this.f128700l) + com.tencent.luggage.wxa.gr.a.a(10, this.f128701m);
            String str7 = this.f128702n;
            if (str7 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(11, str7);
            }
            int b18 = b17 + com.tencent.luggage.wxa.gr.a.b(12, this.f128703o);
            String str8 = this.f128704p;
            if (str8 != null) {
                return b18 + com.tencent.luggage.wxa.gr.a.a(13, str8);
            }
            return b18;
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
        sh shVar = (sh) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    ph phVar3 = new ph();
                    if (bArr != null && bArr.length > 0) {
                        phVar3.a(bArr);
                    }
                    shVar.f128692d = phVar3;
                }
                return 0;
            case 2:
                shVar.f128693e = aVar3.f(intValue);
                return 0;
            case 3:
                shVar.f128694f = aVar3.f(intValue);
                return 0;
            case 4:
                shVar.f128695g = aVar3.f(intValue);
                return 0;
            case 5:
                shVar.f128696h = aVar3.a(intValue);
                return 0;
            case 6:
                shVar.f128697i = aVar3.f(intValue);
                return 0;
            case 7:
                shVar.f128698j = aVar3.i(intValue);
                return 0;
            case 8:
                shVar.f128699k = aVar3.i(intValue);
                return 0;
            case 9:
                shVar.f128700l = aVar3.f(intValue);
                return 0;
            case 10:
                shVar.f128701m = aVar3.a(intValue);
                return 0;
            case 11:
                shVar.f128702n = aVar3.i(intValue);
                return 0;
            case 12:
                shVar.f128703o = aVar3.f(intValue);
                return 0;
            case 13:
                shVar.f128704p = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
