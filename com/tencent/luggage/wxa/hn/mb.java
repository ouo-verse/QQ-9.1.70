package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class mb extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128194d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f128195e;

    /* renamed from: f, reason: collision with root package name */
    public int f128196f;

    /* renamed from: g, reason: collision with root package name */
    public int f128197g;

    /* renamed from: h, reason: collision with root package name */
    public String f128198h;

    /* renamed from: i, reason: collision with root package name */
    public String f128199i;

    /* renamed from: j, reason: collision with root package name */
    public String f128200j;

    /* renamed from: k, reason: collision with root package name */
    public String f128201k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128194d);
            aVar.a(2, this.f128195e);
            aVar.b(3, this.f128196f);
            aVar.b(4, this.f128197g);
            String str = this.f128198h;
            if (str != null) {
                aVar.a(5, str);
            }
            String str2 = this.f128199i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            String str3 = this.f128200j;
            if (str3 != null) {
                aVar.a(7, str3);
            }
            String str4 = this.f128201k;
            if (str4 != null) {
                aVar.a(8, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            int a16 = com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128194d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, this.f128195e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128196f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128197g);
            String str5 = this.f128198h;
            if (str5 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str5);
            }
            String str6 = this.f128199i;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str6);
            }
            String str7 = this.f128200j;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str7);
            }
            String str8 = this.f128201k;
            if (str8 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(8, str8);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128194d.clear();
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
        mb mbVar = (mb) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    nb nbVar = new nb();
                    if (bArr2 != null && bArr2.length > 0) {
                        nbVar.a(bArr2);
                    }
                    mbVar.f128194d.add(nbVar);
                }
                return 0;
            case 2:
                mbVar.f128195e = aVar3.a(intValue);
                return 0;
            case 3:
                mbVar.f128196f = aVar3.f(intValue);
                return 0;
            case 4:
                mbVar.f128197g = aVar3.f(intValue);
                return 0;
            case 5:
                mbVar.f128198h = aVar3.i(intValue);
                return 0;
            case 6:
                mbVar.f128199i = aVar3.i(intValue);
                return 0;
            case 7:
                mbVar.f128200j = aVar3.i(intValue);
                return 0;
            case 8:
                mbVar.f128201k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
