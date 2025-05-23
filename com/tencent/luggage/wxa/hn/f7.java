package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f7 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127617e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public String f127618f;

    /* renamed from: g, reason: collision with root package name */
    public String f127619g;

    /* renamed from: h, reason: collision with root package name */
    public String f127620h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f127621i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f127622j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f127623k;

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
            aVar.a(3, 8, this.f127617e);
            String str = this.f127618f;
            if (str != null) {
                aVar.a(4, str);
            }
            String str2 = this.f127619g;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f127620h;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            aVar.a(8, this.f127621i);
            aVar.a(9, this.f127622j);
            aVar.a(10, this.f127623k);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127617e);
            String str4 = this.f127618f;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str4);
            }
            String str5 = this.f127619g;
            if (str5 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str5);
            }
            String str6 = this.f127620h;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str6);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(8, this.f127621i) + com.tencent.luggage.wxa.gr.a.a(9, this.f127622j) + com.tencent.luggage.wxa.gr.a.a(10, this.f127623k);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127617e.clear();
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
        f7 f7Var = (f7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr2 != null && bArr2.length > 0) {
                        h0Var3.a(bArr2);
                    }
                    f7Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
            case 7:
            default:
                return -1;
            case 3:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    g7 g7Var = new g7();
                    if (bArr3 != null && bArr3.length > 0) {
                        g7Var.a(bArr3);
                    }
                    f7Var.f127617e.add(g7Var);
                }
                return 0;
            case 4:
                f7Var.f127618f = aVar3.i(intValue);
                return 0;
            case 5:
                f7Var.f127619g = aVar3.i(intValue);
                return 0;
            case 6:
                f7Var.f127620h = aVar3.i(intValue);
                return 0;
            case 8:
                f7Var.f127621i = aVar3.a(intValue);
                return 0;
            case 9:
                f7Var.f127622j = aVar3.a(intValue);
                return 0;
            case 10:
                f7Var.f127623k = aVar3.a(intValue);
                return 0;
        }
    }
}
