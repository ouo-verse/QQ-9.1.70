package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public v f128925d;

    /* renamed from: e, reason: collision with root package name */
    public o2 f128926e;

    /* renamed from: f, reason: collision with root package name */
    public String f128927f;

    /* renamed from: g, reason: collision with root package name */
    public String f128928g;

    /* renamed from: h, reason: collision with root package name */
    public String f128929h;

    /* renamed from: i, reason: collision with root package name */
    public r9 f128930i;

    /* renamed from: j, reason: collision with root package name */
    public d0 f128931j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            v vVar = this.f128925d;
            if (vVar != null) {
                aVar.c(1, vVar.a());
                this.f128925d.a(aVar);
            }
            o2 o2Var = this.f128926e;
            if (o2Var != null) {
                aVar.c(2, o2Var.a());
                this.f128926e.a(aVar);
            }
            String str = this.f128927f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f128928g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f128929h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            r9 r9Var = this.f128930i;
            if (r9Var != null) {
                aVar.c(6, r9Var.a());
                this.f128930i.a(aVar);
            }
            d0 d0Var = this.f128931j;
            if (d0Var != null) {
                aVar.c(7, d0Var.a());
                this.f128931j.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            v vVar2 = this.f128925d;
            if (vVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, vVar2.a());
            }
            o2 o2Var2 = this.f128926e;
            if (o2Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, o2Var2.a());
            }
            String str4 = this.f128927f;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            String str5 = this.f128928g;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            String str6 = this.f128929h;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            r9 r9Var2 = this.f128930i;
            if (r9Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(6, r9Var2.a());
            }
            d0 d0Var2 = this.f128931j;
            if (d0Var2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(7, d0Var2.a());
            }
            return i16;
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
        w wVar = (w) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    v vVar3 = new v();
                    if (bArr != null && bArr.length > 0) {
                        vVar3.a(bArr);
                    }
                    wVar.f128925d = vVar3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    o2 o2Var3 = new o2();
                    if (bArr2 != null && bArr2.length > 0) {
                        o2Var3.a(bArr2);
                    }
                    wVar.f128926e = o2Var3;
                }
                return 0;
            case 3:
                wVar.f128927f = aVar3.i(intValue);
                return 0;
            case 4:
                wVar.f128928g = aVar3.i(intValue);
                return 0;
            case 5:
                wVar.f128929h = aVar3.i(intValue);
                return 0;
            case 6:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    r9 r9Var3 = new r9();
                    if (bArr3 != null && bArr3.length > 0) {
                        r9Var3.a(bArr3);
                    }
                    wVar.f128930i = r9Var3;
                }
                return 0;
            case 7:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    d0 d0Var3 = new d0();
                    if (bArr4 != null && bArr4.length > 0) {
                        d0Var3.a(bArr4);
                    }
                    wVar.f128931j = d0Var3;
                }
                return 0;
            default:
                return -1;
        }
    }
}
