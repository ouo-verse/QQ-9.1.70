package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n4 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f128257e;

    /* renamed from: h, reason: collision with root package name */
    public int f128260h;

    /* renamed from: j, reason: collision with root package name */
    public l1 f128262j;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128258f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128259g = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    public LinkedList f128261i = new LinkedList();

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
            wd wdVar = this.f128257e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f128257e.a(aVar);
            }
            aVar.a(3, 8, this.f128258f);
            aVar.a(4, 8, this.f128259g);
            aVar.b(5, this.f128260h);
            aVar.a(6, 8, this.f128261i);
            l1 l1Var = this.f128262j;
            if (l1Var != null) {
                aVar.c(7, l1Var.a());
                this.f128262j.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f128257e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128258f) + com.tencent.luggage.wxa.gr.a.a(4, 8, this.f128259g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128260h) + com.tencent.luggage.wxa.gr.a.a(6, 8, this.f128261i);
            l1 l1Var2 = this.f128262j;
            if (l1Var2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(7, l1Var2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128258f.clear();
            this.f128259g.clear();
            this.f128261i.clear();
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
        n4 n4Var = (n4) objArr[1];
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
                    n4Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    wd wdVar3 = new wd();
                    if (bArr3 != null && bArr3.length > 0) {
                        wdVar3.a(bArr3);
                    }
                    n4Var.f128257e = wdVar3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    ke keVar = new ke();
                    if (bArr4 != null && bArr4.length > 0) {
                        keVar.a(bArr4);
                    }
                    n4Var.f128258f.add(keVar);
                }
                return 0;
            case 4:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr5 = (byte[]) h19.get(i26);
                    ke keVar2 = new ke();
                    if (bArr5 != null && bArr5.length > 0) {
                        keVar2.a(bArr5);
                    }
                    n4Var.f128259g.add(keVar2);
                }
                return 0;
            case 5:
                n4Var.f128260h = aVar3.f(intValue);
                return 0;
            case 6:
                LinkedList h26 = aVar3.h(intValue);
                int size5 = h26.size();
                for (int i27 = 0; i27 < size5; i27++) {
                    byte[] bArr6 = (byte[]) h26.get(i27);
                    ke keVar3 = new ke();
                    if (bArr6 != null && bArr6.length > 0) {
                        keVar3.a(bArr6);
                    }
                    n4Var.f128261i.add(keVar3);
                }
                return 0;
            case 7:
                LinkedList h27 = aVar3.h(intValue);
                int size6 = h27.size();
                for (int i28 = 0; i28 < size6; i28++) {
                    byte[] bArr7 = (byte[]) h27.get(i28);
                    l1 l1Var3 = new l1();
                    if (bArr7 != null && bArr7.length > 0) {
                        l1Var3.a(bArr7);
                    }
                    n4Var.f128262j = l1Var3;
                }
                return 0;
            default:
                return -1;
        }
    }
}
