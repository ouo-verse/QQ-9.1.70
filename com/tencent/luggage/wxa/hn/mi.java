package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class mi extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128218d;

    /* renamed from: e, reason: collision with root package name */
    public String f128219e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128220f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public String f128221g;

    /* renamed from: h, reason: collision with root package name */
    public int f128222h;

    /* renamed from: i, reason: collision with root package name */
    public String f128223i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128218d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128219e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.a(3, 8, this.f128220f);
            String str3 = this.f128221g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f128222h);
            String str4 = this.f128223i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f128218d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            String str6 = this.f128219e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128220f);
            String str7 = this.f128221g;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128222h);
            String str8 = this.f128223i;
            if (str8 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            return b16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128220f.clear();
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
        mi miVar = (mi) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                miVar.f128218d = aVar3.i(intValue);
                return 0;
            case 2:
                miVar.f128219e = aVar3.i(intValue);
                return 0;
            case 3:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    k7 k7Var = new k7();
                    if (bArr2 != null && bArr2.length > 0) {
                        k7Var.a(bArr2);
                    }
                    miVar.f128220f.add(k7Var);
                }
                return 0;
            case 4:
                miVar.f128221g = aVar3.i(intValue);
                return 0;
            case 5:
                miVar.f128222h = aVar3.f(intValue);
                return 0;
            case 6:
                miVar.f128223i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
