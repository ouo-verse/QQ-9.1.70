package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127393d;

    /* renamed from: e, reason: collision with root package name */
    public e9 f127394e;

    /* renamed from: f, reason: collision with root package name */
    public e9 f127395f;

    /* renamed from: g, reason: collision with root package name */
    public e9 f127396g;

    /* renamed from: h, reason: collision with root package name */
    public e9 f127397h;

    /* renamed from: i, reason: collision with root package name */
    public e9 f127398i;

    /* renamed from: j, reason: collision with root package name */
    public e9 f127399j;

    /* renamed from: k, reason: collision with root package name */
    public e9 f127400k;

    /* renamed from: l, reason: collision with root package name */
    public e9 f127401l;

    /* renamed from: m, reason: collision with root package name */
    public e9 f127402m;

    /* renamed from: n, reason: collision with root package name */
    public e9 f127403n;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127393d);
            e9 e9Var = this.f127394e;
            if (e9Var != null) {
                aVar.c(2, e9Var.a());
                this.f127394e.a(aVar);
            }
            e9 e9Var2 = this.f127395f;
            if (e9Var2 != null) {
                aVar.c(3, e9Var2.a());
                this.f127395f.a(aVar);
            }
            e9 e9Var3 = this.f127396g;
            if (e9Var3 != null) {
                aVar.c(4, e9Var3.a());
                this.f127396g.a(aVar);
            }
            e9 e9Var4 = this.f127397h;
            if (e9Var4 != null) {
                aVar.c(5, e9Var4.a());
                this.f127397h.a(aVar);
            }
            e9 e9Var5 = this.f127398i;
            if (e9Var5 != null) {
                aVar.c(6, e9Var5.a());
                this.f127398i.a(aVar);
            }
            e9 e9Var6 = this.f127399j;
            if (e9Var6 != null) {
                aVar.c(7, e9Var6.a());
                this.f127399j.a(aVar);
            }
            e9 e9Var7 = this.f127400k;
            if (e9Var7 != null) {
                aVar.c(8, e9Var7.a());
                this.f127400k.a(aVar);
            }
            e9 e9Var8 = this.f127401l;
            if (e9Var8 != null) {
                aVar.c(9, e9Var8.a());
                this.f127401l.a(aVar);
            }
            e9 e9Var9 = this.f127402m;
            if (e9Var9 != null) {
                aVar.c(10, e9Var9.a());
                this.f127402m.a(aVar);
            }
            e9 e9Var10 = this.f127403n;
            if (e9Var10 != null) {
                aVar.c(11, e9Var10.a());
                this.f127403n.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f127393d) + 0;
            e9 e9Var11 = this.f127394e;
            if (e9Var11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(2, e9Var11.a());
            }
            e9 e9Var12 = this.f127395f;
            if (e9Var12 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(3, e9Var12.a());
            }
            e9 e9Var13 = this.f127396g;
            if (e9Var13 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(4, e9Var13.a());
            }
            e9 e9Var14 = this.f127397h;
            if (e9Var14 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(5, e9Var14.a());
            }
            e9 e9Var15 = this.f127398i;
            if (e9Var15 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(6, e9Var15.a());
            }
            e9 e9Var16 = this.f127399j;
            if (e9Var16 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(7, e9Var16.a());
            }
            e9 e9Var17 = this.f127400k;
            if (e9Var17 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(8, e9Var17.a());
            }
            e9 e9Var18 = this.f127401l;
            if (e9Var18 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(9, e9Var18.a());
            }
            e9 e9Var19 = this.f127402m;
            if (e9Var19 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(10, e9Var19.a());
            }
            e9 e9Var20 = this.f127403n;
            if (e9Var20 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(11, e9Var20.a());
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
        c8 c8Var = (c8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                c8Var.f127393d = aVar3.f(intValue);
                return 0;
            case 2:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr = (byte[]) h16.get(i16);
                    e9 e9Var21 = new e9();
                    if (bArr != null && bArr.length > 0) {
                        e9Var21.a(bArr);
                    }
                    c8Var.f127394e = e9Var21;
                }
                return 0;
            case 3:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    byte[] bArr2 = (byte[]) h17.get(i17);
                    e9 e9Var22 = new e9();
                    if (bArr2 != null && bArr2.length > 0) {
                        e9Var22.a(bArr2);
                    }
                    c8Var.f127395f = e9Var22;
                }
                return 0;
            case 4:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i18 = 0; i18 < size3; i18++) {
                    byte[] bArr3 = (byte[]) h18.get(i18);
                    e9 e9Var23 = new e9();
                    if (bArr3 != null && bArr3.length > 0) {
                        e9Var23.a(bArr3);
                    }
                    c8Var.f127396g = e9Var23;
                }
                return 0;
            case 5:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i19 = 0; i19 < size4; i19++) {
                    byte[] bArr4 = (byte[]) h19.get(i19);
                    e9 e9Var24 = new e9();
                    if (bArr4 != null && bArr4.length > 0) {
                        e9Var24.a(bArr4);
                    }
                    c8Var.f127397h = e9Var24;
                }
                return 0;
            case 6:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i26 = 0; i26 < size5; i26++) {
                    byte[] bArr5 = (byte[]) h26.get(i26);
                    e9 e9Var25 = new e9();
                    if (bArr5 != null && bArr5.length > 0) {
                        e9Var25.a(bArr5);
                    }
                    c8Var.f127398i = e9Var25;
                }
                return 0;
            case 7:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i27 = 0; i27 < size6; i27++) {
                    byte[] bArr6 = (byte[]) h27.get(i27);
                    e9 e9Var26 = new e9();
                    if (bArr6 != null && bArr6.length > 0) {
                        e9Var26.a(bArr6);
                    }
                    c8Var.f127399j = e9Var26;
                }
                return 0;
            case 8:
                LinkedList h28 = aVar3.h(intValue);
                int size7 = h28.size();
                for (int i28 = 0; i28 < size7; i28++) {
                    byte[] bArr7 = (byte[]) h28.get(i28);
                    e9 e9Var27 = new e9();
                    if (bArr7 != null && bArr7.length > 0) {
                        e9Var27.a(bArr7);
                    }
                    c8Var.f127400k = e9Var27;
                }
                return 0;
            case 9:
                LinkedList h29 = aVar3.h(intValue);
                int size8 = h29.size();
                for (int i29 = 0; i29 < size8; i29++) {
                    byte[] bArr8 = (byte[]) h29.get(i29);
                    e9 e9Var28 = new e9();
                    if (bArr8 != null && bArr8.length > 0) {
                        e9Var28.a(bArr8);
                    }
                    c8Var.f127401l = e9Var28;
                }
                return 0;
            case 10:
                LinkedList h36 = aVar3.h(intValue);
                int size9 = h36.size();
                for (int i36 = 0; i36 < size9; i36++) {
                    byte[] bArr9 = (byte[]) h36.get(i36);
                    e9 e9Var29 = new e9();
                    if (bArr9 != null && bArr9.length > 0) {
                        e9Var29.a(bArr9);
                    }
                    c8Var.f127402m = e9Var29;
                }
                return 0;
            case 11:
                LinkedList h37 = aVar3.h(intValue);
                int size10 = h37.size();
                for (int i37 = 0; i37 < size10; i37++) {
                    byte[] bArr10 = (byte[]) h37.get(i37);
                    e9 e9Var30 = new e9();
                    if (bArr10 != null && bArr10.length > 0) {
                        e9Var30.a(bArr10);
                    }
                    c8Var.f127403n = e9Var30;
                }
                return 0;
            default:
                return -1;
        }
    }
}
