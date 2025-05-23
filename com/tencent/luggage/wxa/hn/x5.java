package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f129007e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f129008f;

    /* renamed from: g, reason: collision with root package name */
    public m9 f129009g;

    /* renamed from: h, reason: collision with root package name */
    public String f129010h;

    /* renamed from: i, reason: collision with root package name */
    public String f129011i;

    /* renamed from: j, reason: collision with root package name */
    public p1 f129012j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f129013k;

    /* renamed from: l, reason: collision with root package name */
    public String f129014l;

    /* renamed from: m, reason: collision with root package name */
    public String f129015m;

    /* renamed from: n, reason: collision with root package name */
    public String f129016n;

    /* renamed from: o, reason: collision with root package name */
    public mb f129017o;

    /* renamed from: p, reason: collision with root package name */
    public i f129018p;

    /* renamed from: q, reason: collision with root package name */
    public pb f129019q;

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
            c5 c5Var = this.f129007e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f129007e.a(aVar);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f129008f;
            if (cVar != null) {
                aVar.a(3, cVar);
            }
            m9 m9Var = this.f129009g;
            if (m9Var != null) {
                aVar.c(4, m9Var.a());
                this.f129009g.a(aVar);
            }
            String str = this.f129010h;
            if (str != null) {
                aVar.a(5, str);
            }
            String str2 = this.f129011i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            p1 p1Var = this.f129012j;
            if (p1Var != null) {
                aVar.c(7, p1Var.a());
                this.f129012j.a(aVar);
            }
            aVar.a(8, this.f129013k);
            String str3 = this.f129014l;
            if (str3 != null) {
                aVar.a(9, str3);
            }
            String str4 = this.f129015m;
            if (str4 != null) {
                aVar.a(10, str4);
            }
            String str5 = this.f129016n;
            if (str5 != null) {
                aVar.a(11, str5);
            }
            mb mbVar = this.f129017o;
            if (mbVar != null) {
                aVar.c(12, mbVar.a());
                this.f129017o.a(aVar);
            }
            i iVar = this.f129018p;
            if (iVar != null) {
                aVar.c(13, iVar.a());
                this.f129018p.a(aVar);
            }
            pb pbVar = this.f129019q;
            if (pbVar != null) {
                aVar.c(15, pbVar.a());
                this.f129019q.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            c5 c5Var2 = this.f129007e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f129008f;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, cVar2);
            }
            m9 m9Var2 = this.f129009g;
            if (m9Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(4, m9Var2.a());
            }
            String str6 = this.f129010h;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            String str7 = this.f129011i;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(6, str7);
            }
            p1 p1Var2 = this.f129012j;
            if (p1Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(7, p1Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(8, this.f129013k);
            String str8 = this.f129014l;
            if (str8 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(9, str8);
            }
            String str9 = this.f129015m;
            if (str9 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(10, str9);
            }
            String str10 = this.f129016n;
            if (str10 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(11, str10);
            }
            mb mbVar2 = this.f129017o;
            if (mbVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(12, mbVar2.a());
            }
            i iVar2 = this.f129018p;
            if (iVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(13, iVar2.a());
            }
            pb pbVar2 = this.f129019q;
            if (pbVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(15, pbVar2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        x5 x5Var = (x5) objArr[1];
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
                    x5Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    c5 c5Var3 = new c5();
                    if (bArr2 != null && bArr2.length > 0) {
                        c5Var3.a(bArr2);
                    }
                    x5Var.f129007e = c5Var3;
                }
                return 0;
            case 3:
                x5Var.f129008f = aVar3.b(intValue);
                return 0;
            case 4:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    m9 m9Var3 = new m9();
                    if (bArr3 != null && bArr3.length > 0) {
                        m9Var3.a(bArr3);
                    }
                    x5Var.f129009g = m9Var3;
                }
                return 0;
            case 5:
                x5Var.f129010h = aVar3.i(intValue);
                return 0;
            case 6:
                x5Var.f129011i = aVar3.i(intValue);
                return 0;
            case 7:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    p1 p1Var3 = new p1();
                    if (bArr4 != null && bArr4.length > 0) {
                        p1Var3.a(bArr4);
                    }
                    x5Var.f129012j = p1Var3;
                }
                return 0;
            case 8:
                x5Var.f129013k = aVar3.a(intValue);
                return 0;
            case 9:
                x5Var.f129014l = aVar3.i(intValue);
                return 0;
            case 10:
                x5Var.f129015m = aVar3.i(intValue);
                return 0;
            case 11:
                x5Var.f129016n = aVar3.i(intValue);
                return 0;
            case 12:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr5 = (byte[]) h26.get(i27);
                    mb mbVar3 = new mb();
                    if (bArr5 != null && bArr5.length > 0) {
                        mbVar3.a(bArr5);
                    }
                    x5Var.f129017o = mbVar3;
                }
                return 0;
            case 13:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr6 = (byte[]) h27.get(i28);
                    i iVar3 = new i();
                    if (bArr6 != null && bArr6.length > 0) {
                        iVar3.a(bArr6);
                    }
                    x5Var.f129018p = iVar3;
                }
                return 0;
            case 14:
            default:
                return -1;
            case 15:
                LinkedList h28 = aVar3.h(intValue);
                int size7 = h28.size();
                for (int i29 = 0; i29 < size7; i29++) {
                    byte[] bArr7 = (byte[]) h28.get(i29);
                    pb pbVar3 = new pb();
                    if (bArr7 != null && bArr7.length > 0) {
                        pbVar3.a(bArr7);
                    }
                    x5Var.f129019q = pbVar3;
                }
                return 0;
        }
    }
}
