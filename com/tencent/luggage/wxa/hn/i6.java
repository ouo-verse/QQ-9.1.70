package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i6 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public d6 f127858e;

    /* renamed from: f, reason: collision with root package name */
    public z0 f127859f;

    /* renamed from: g, reason: collision with root package name */
    public he f127860g;

    /* renamed from: h, reason: collision with root package name */
    public z7 f127861h;

    /* renamed from: i, reason: collision with root package name */
    public a f127862i;

    /* renamed from: j, reason: collision with root package name */
    public j7 f127863j;

    /* renamed from: k, reason: collision with root package name */
    public String f127864k;

    /* renamed from: l, reason: collision with root package name */
    public String f127865l;

    /* renamed from: m, reason: collision with root package name */
    public String f127866m;

    /* renamed from: n, reason: collision with root package name */
    public eh f127867n;

    /* renamed from: o, reason: collision with root package name */
    public int f127868o;

    /* renamed from: p, reason: collision with root package name */
    public String f127869p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f127870q;

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
            d6 d6Var = this.f127858e;
            if (d6Var != null) {
                aVar.c(2, d6Var.a());
                this.f127858e.a(aVar);
            }
            z0 z0Var = this.f127859f;
            if (z0Var != null) {
                aVar.c(3, z0Var.a());
                this.f127859f.a(aVar);
            }
            he heVar = this.f127860g;
            if (heVar != null) {
                aVar.c(4, heVar.a());
                this.f127860g.a(aVar);
            }
            z7 z7Var = this.f127861h;
            if (z7Var != null) {
                aVar.c(5, z7Var.a());
                this.f127861h.a(aVar);
            }
            a aVar2 = this.f127862i;
            if (aVar2 != null) {
                aVar.c(6, aVar2.a());
                this.f127862i.a(aVar);
            }
            j7 j7Var = this.f127863j;
            if (j7Var != null) {
                aVar.c(7, j7Var.a());
                this.f127863j.a(aVar);
            }
            String str = this.f127864k;
            if (str != null) {
                aVar.a(8, str);
            }
            String str2 = this.f127865l;
            if (str2 != null) {
                aVar.a(9, str2);
            }
            String str3 = this.f127866m;
            if (str3 != null) {
                aVar.a(10, str3);
            }
            eh ehVar = this.f127867n;
            if (ehVar != null) {
                aVar.c(11, ehVar.a());
                this.f127867n.a(aVar);
            }
            aVar.b(12, this.f127868o);
            String str4 = this.f127869p;
            if (str4 != null) {
                aVar.a(13, str4);
            }
            aVar.a(14, this.f127870q);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a()) + 0;
            }
            d6 d6Var2 = this.f127858e;
            if (d6Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, d6Var2.a());
            }
            z0 z0Var2 = this.f127859f;
            if (z0Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, z0Var2.a());
            }
            he heVar2 = this.f127860g;
            if (heVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(4, heVar2.a());
            }
            z7 z7Var2 = this.f127861h;
            if (z7Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(5, z7Var2.a());
            }
            a aVar3 = this.f127862i;
            if (aVar3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(6, aVar3.a());
            }
            j7 j7Var2 = this.f127863j;
            if (j7Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(7, j7Var2.a());
            }
            String str5 = this.f127864k;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(8, str5);
            }
            String str6 = this.f127865l;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(9, str6);
            }
            String str7 = this.f127866m;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(10, str7);
            }
            eh ehVar2 = this.f127867n;
            if (ehVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(11, ehVar2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(12, this.f127868o);
            String str8 = this.f127869p;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(13, str8);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(14, this.f127870q);
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar4 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar4); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar4)) {
                if (!super.a(aVar4, this, a16)) {
                    aVar4.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar5 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        i6 i6Var = (i6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar5.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    i6Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar5.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    d6 d6Var3 = new d6();
                    if (bArr2 != null && bArr2.length > 0) {
                        d6Var3.a(bArr2);
                    }
                    i6Var.f127858e = d6Var3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar5.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    z0 z0Var3 = new z0();
                    if (bArr3 != null && bArr3.length > 0) {
                        z0Var3.a(bArr3);
                    }
                    i6Var.f127859f = z0Var3;
                }
                return 0;
            case 4:
                LinkedList h19 = aVar5.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    he heVar3 = new he();
                    if (bArr4 != null && bArr4.length > 0) {
                        heVar3.a(bArr4);
                    }
                    i6Var.f127860g = heVar3;
                }
                return 0;
            case 5:
                LinkedList h26 = aVar5.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr5 = (byte[]) h26.get(i27);
                    z7 z7Var3 = new z7();
                    if (bArr5 != null && bArr5.length > 0) {
                        z7Var3.a(bArr5);
                    }
                    i6Var.f127861h = z7Var3;
                }
                return 0;
            case 6:
                LinkedList h27 = aVar5.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr6 = (byte[]) h27.get(i28);
                    a aVar6 = new a();
                    if (bArr6 != null && bArr6.length > 0) {
                        aVar6.a(bArr6);
                    }
                    i6Var.f127862i = aVar6;
                }
                return 0;
            case 7:
                LinkedList h28 = aVar5.h(intValue);
                int size7 = h28.size();
                for (int i29 = 0; i29 < size7; i29++) {
                    byte[] bArr7 = (byte[]) h28.get(i29);
                    j7 j7Var3 = new j7();
                    if (bArr7 != null && bArr7.length > 0) {
                        j7Var3.a(bArr7);
                    }
                    i6Var.f127863j = j7Var3;
                }
                return 0;
            case 8:
                i6Var.f127864k = aVar5.i(intValue);
                return 0;
            case 9:
                i6Var.f127865l = aVar5.i(intValue);
                return 0;
            case 10:
                i6Var.f127866m = aVar5.i(intValue);
                return 0;
            case 11:
                LinkedList h29 = aVar5.h(intValue);
                int size8 = h29.size();
                for (int i36 = 0; i36 < size8; i36++) {
                    byte[] bArr8 = (byte[]) h29.get(i36);
                    eh ehVar3 = new eh();
                    if (bArr8 != null && bArr8.length > 0) {
                        ehVar3.a(bArr8);
                    }
                    i6Var.f127867n = ehVar3;
                }
                return 0;
            case 12:
                i6Var.f127868o = aVar5.f(intValue);
                return 0;
            case 13:
                i6Var.f127869p = aVar5.i(intValue);
                return 0;
            case 14:
                i6Var.f127870q = aVar5.a(intValue);
                return 0;
            default:
                return -1;
        }
    }
}
