package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f4 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public mf f127601e;

    /* renamed from: f, reason: collision with root package name */
    public nf f127602f;

    /* renamed from: g, reason: collision with root package name */
    public kf f127603g;

    /* renamed from: h, reason: collision with root package name */
    public mi f127604h;

    /* renamed from: i, reason: collision with root package name */
    public oi f127605i;

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
            mf mfVar = this.f127601e;
            if (mfVar != null) {
                aVar.c(2, mfVar.a());
                this.f127601e.a(aVar);
            }
            nf nfVar = this.f127602f;
            if (nfVar != null) {
                aVar.c(3, nfVar.a());
                this.f127602f.a(aVar);
            }
            kf kfVar = this.f127603g;
            if (kfVar != null) {
                aVar.c(4, kfVar.a());
                this.f127603g.a(aVar);
            }
            mi miVar = this.f127604h;
            if (miVar != null) {
                aVar.c(5, miVar.a());
                this.f127604h.a(aVar);
            }
            oi oiVar = this.f127605i;
            if (oiVar != null) {
                aVar.c(6, oiVar.a());
                this.f127605i.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            mf mfVar2 = this.f127601e;
            if (mfVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, mfVar2.a());
            }
            nf nfVar2 = this.f127602f;
            if (nfVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, nfVar2.a());
            }
            kf kfVar2 = this.f127603g;
            if (kfVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(4, kfVar2.a());
            }
            mi miVar2 = this.f127604h;
            if (miVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(5, miVar2.a());
            }
            oi oiVar2 = this.f127605i;
            if (oiVar2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(6, oiVar2.a());
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
        f4 f4Var = (f4) objArr[1];
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
                    f4Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    mf mfVar3 = new mf();
                    if (bArr2 != null && bArr2.length > 0) {
                        mfVar3.a(bArr2);
                    }
                    f4Var.f127601e = mfVar3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    nf nfVar3 = new nf();
                    if (bArr3 != null && bArr3.length > 0) {
                        nfVar3.a(bArr3);
                    }
                    f4Var.f127602f = nfVar3;
                }
                return 0;
            case 4:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    kf kfVar3 = new kf();
                    if (bArr4 != null && bArr4.length > 0) {
                        kfVar3.a(bArr4);
                    }
                    f4Var.f127603g = kfVar3;
                }
                return 0;
            case 5:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr5 = (byte[]) h26.get(i27);
                    mi miVar3 = new mi();
                    if (bArr5 != null && bArr5.length > 0) {
                        miVar3.a(bArr5);
                    }
                    f4Var.f127604h = miVar3;
                }
                return 0;
            case 6:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr6 = (byte[]) h27.get(i28);
                    oi oiVar3 = new oi();
                    if (bArr6 != null && bArr6.length > 0) {
                        oiVar3.a(bArr6);
                    }
                    f4Var.f127605i = oiVar3;
                }
                return 0;
            default:
                return -1;
        }
    }
}
