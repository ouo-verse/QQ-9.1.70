package com.tencent.luggage.wxa.d6;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f124119d;

    /* renamed from: e, reason: collision with root package name */
    public String f124120e;

    /* renamed from: f, reason: collision with root package name */
    public int f124121f;

    /* renamed from: g, reason: collision with root package name */
    public String f124122g;

    /* renamed from: h, reason: collision with root package name */
    public String f124123h;

    /* renamed from: i, reason: collision with root package name */
    public String f124124i;

    /* renamed from: j, reason: collision with root package name */
    public String f124125j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedList f124126k = new LinkedList();

    /* renamed from: l, reason: collision with root package name */
    public String f124127l;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f124119d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f124120e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f124121f);
            String str3 = this.f124122g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f124123h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f124124i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            String str6 = this.f124125j;
            if (str6 != null) {
                aVar.a(7, str6);
            }
            aVar.a(8, 1, this.f124126k);
            String str7 = this.f124127l;
            if (str7 != null) {
                aVar.a(9, str7);
            }
            return 0;
        }
        if (i3 == 1) {
            String str8 = this.f124119d;
            if (str8 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str8);
            }
            String str9 = this.f124120e;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str9);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f124121f);
            String str10 = this.f124122g;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f124123h;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f124124i;
            if (str12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str12);
            }
            String str13 = this.f124125j;
            if (str13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str13);
            }
            int a16 = b16 + com.tencent.luggage.wxa.gr.a.a(8, 1, this.f124126k);
            String str14 = this.f124127l;
            if (str14 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(9, str14);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f124126k.clear();
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
        f fVar = (f) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                fVar.f124119d = aVar3.i(intValue);
                return 0;
            case 2:
                fVar.f124120e = aVar3.i(intValue);
                return 0;
            case 3:
                fVar.f124121f = aVar3.f(intValue);
                return 0;
            case 4:
                fVar.f124122g = aVar3.i(intValue);
                return 0;
            case 5:
                fVar.f124123h = aVar3.i(intValue);
                return 0;
            case 6:
                fVar.f124124i = aVar3.i(intValue);
                return 0;
            case 7:
                fVar.f124125j = aVar3.i(intValue);
                return 0;
            case 8:
                fVar.f124126k.add(aVar3.i(intValue));
                return 0;
            case 9:
                fVar.f124127l = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
