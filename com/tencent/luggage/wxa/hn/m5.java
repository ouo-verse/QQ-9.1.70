package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m5 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128148d;

    /* renamed from: e, reason: collision with root package name */
    public String f128149e;

    /* renamed from: f, reason: collision with root package name */
    public String f128150f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128151g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public int f128152h;

    /* renamed from: i, reason: collision with root package name */
    public int f128153i;

    /* renamed from: j, reason: collision with root package name */
    public String f128154j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128148d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128149e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128150f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            aVar.a(4, 1, this.f128151g);
            aVar.b(5, this.f128152h);
            aVar.b(6, this.f128153i);
            String str4 = this.f128154j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f128148d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            String str6 = this.f128149e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f128150f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f128151g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128152h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128153i);
            String str8 = this.f128154j;
            if (str8 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(7, str8);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128151g.clear();
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
        m5 m5Var = (m5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                m5Var.f128148d = aVar3.i(intValue);
                return 0;
            case 2:
                m5Var.f128149e = aVar3.i(intValue);
                return 0;
            case 3:
                m5Var.f128150f = aVar3.i(intValue);
                return 0;
            case 4:
                m5Var.f128151g.add(aVar3.i(intValue));
                return 0;
            case 5:
                m5Var.f128152h = aVar3.f(intValue);
                return 0;
            case 6:
                m5Var.f128153i = aVar3.f(intValue);
                return 0;
            case 7:
                m5Var.f128154j = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
