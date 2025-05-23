package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ce extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127420e;

    /* renamed from: f, reason: collision with root package name */
    public String f127421f;

    /* renamed from: g, reason: collision with root package name */
    public int f127422g;

    /* renamed from: h, reason: collision with root package name */
    public int f127423h;

    /* renamed from: i, reason: collision with root package name */
    public int f127424i;

    /* renamed from: j, reason: collision with root package name */
    public int f127425j;

    /* renamed from: k, reason: collision with root package name */
    public String f127426k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(1, h0Var.a());
                this.f128743d.a(aVar);
            }
            String str = this.f127420e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127421f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127422g);
            aVar.b(5, this.f127423h);
            aVar.b(6, this.f127424i);
            aVar.b(7, this.f127425j);
            String str3 = this.f127426k;
            if (str3 != null) {
                aVar.a(8, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            String str4 = this.f127420e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127421f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127422g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127423h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127424i) + com.tencent.luggage.wxa.gr.a.b(7, this.f127425j);
            String str6 = this.f127426k;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(8, str6);
            }
            return b16;
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
        ce ceVar = (ce) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    ceVar.f128743d = h0Var3;
                }
                return 0;
            case 2:
                ceVar.f127420e = aVar3.i(intValue);
                return 0;
            case 3:
                ceVar.f127421f = aVar3.i(intValue);
                return 0;
            case 4:
                ceVar.f127422g = aVar3.f(intValue);
                return 0;
            case 5:
                ceVar.f127423h = aVar3.f(intValue);
                return 0;
            case 6:
                ceVar.f127424i = aVar3.f(intValue);
                return 0;
            case 7:
                ceVar.f127425j = aVar3.f(intValue);
                return 0;
            case 8:
                ceVar.f127426k = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
