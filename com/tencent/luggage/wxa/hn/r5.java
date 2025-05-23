package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f128575e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128576f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public String f128577g;

    /* renamed from: h, reason: collision with root package name */
    public String f128578h;

    /* renamed from: i, reason: collision with root package name */
    public String f128579i;

    /* renamed from: j, reason: collision with root package name */
    public String f128580j;

    /* renamed from: k, reason: collision with root package name */
    public String f128581k;

    /* renamed from: l, reason: collision with root package name */
    public i f128582l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128583m;

    /* renamed from: n, reason: collision with root package name */
    public String f128584n;

    /* renamed from: o, reason: collision with root package name */
    public pb f128585o;

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
            c5 c5Var = this.f128575e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f128575e.a(aVar);
            }
            aVar.a(3, 8, this.f128576f);
            String str = this.f128577g;
            if (str != null) {
                aVar.a(4, str);
            }
            String str2 = this.f128578h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f128579i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            String str4 = this.f128580j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f128581k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            i iVar = this.f128582l;
            if (iVar != null) {
                aVar.c(9, iVar.a());
                this.f128582l.a(aVar);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128583m;
            if (cVar != null) {
                aVar.a(10, cVar);
            }
            String str6 = this.f128584n;
            if (str6 != null) {
                aVar.a(11, str6);
            }
            pb pbVar = this.f128585o;
            if (pbVar != null) {
                aVar.c(12, pbVar.a());
                this.f128585o.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            c5 c5Var2 = this.f128575e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128576f);
            String str7 = this.f128577g;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f128578h;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            String str9 = this.f128579i;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str9);
            }
            String str10 = this.f128580j;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str10);
            }
            String str11 = this.f128581k;
            if (str11 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(8, str11);
            }
            i iVar2 = this.f128582l;
            if (iVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(9, iVar2.a());
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128583m;
            if (cVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(10, cVar2);
            }
            String str12 = this.f128584n;
            if (str12 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(11, str12);
            }
            pb pbVar2 = this.f128585o;
            if (pbVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(12, pbVar2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128576f.clear();
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
        r5 r5Var = (r5) objArr[1];
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
                    r5Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    c5 c5Var3 = new c5();
                    if (bArr3 != null && bArr3.length > 0) {
                        c5Var3.a(bArr3);
                    }
                    r5Var.f128575e = c5Var3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    m9 m9Var = new m9();
                    if (bArr4 != null && bArr4.length > 0) {
                        m9Var.a(bArr4);
                    }
                    r5Var.f128576f.add(m9Var);
                }
                return 0;
            case 4:
                r5Var.f128577g = aVar3.i(intValue);
                return 0;
            case 5:
                r5Var.f128578h = aVar3.i(intValue);
                return 0;
            case 6:
                r5Var.f128579i = aVar3.i(intValue);
                return 0;
            case 7:
                r5Var.f128580j = aVar3.i(intValue);
                return 0;
            case 8:
                r5Var.f128581k = aVar3.i(intValue);
                return 0;
            case 9:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    i iVar3 = new i();
                    if (bArr5 != null && bArr5.length > 0) {
                        iVar3.a(bArr5);
                    }
                    r5Var.f128582l = iVar3;
                }
                return 0;
            case 10:
                r5Var.f128583m = aVar3.b(intValue);
                return 0;
            case 11:
                r5Var.f128584n = aVar3.i(intValue);
                return 0;
            case 12:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr6 = (byte[]) h26.get(i27);
                    pb pbVar3 = new pb();
                    if (bArr6 != null && bArr6.length > 0) {
                        pbVar3.a(bArr6);
                    }
                    r5Var.f128585o = pbVar3;
                }
                return 0;
            default:
                return -1;
        }
    }
}
