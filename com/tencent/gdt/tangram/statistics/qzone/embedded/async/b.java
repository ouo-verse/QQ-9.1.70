package com.tencent.gdt.tangram.statistics.qzone.embedded.async;

/* compiled from: P */
/* loaded from: classes31.dex */
public class b {
    public static am0.b a(am0.a aVar) {
        boolean z16;
        int i3;
        int intValue;
        if (aVar == null) {
            return null;
        }
        Object[] d16 = aVar.d();
        int f16 = aVar.f();
        int i16 = 7;
        boolean z17 = true;
        int i17 = 0;
        if (f16 == 4) {
            if (aVar.e().feedType == 1) {
                intValue = ((Integer) d16[6]).intValue();
            } else if (d16.length > 7) {
                intValue = ((Integer) d16[7]).intValue();
            } else {
                z16 = false;
                i3 = 0;
            }
            i3 = intValue;
            z16 = false;
        } else if (f16 == 7) {
            int i18 = !((Boolean) d16[1]).booleanValue() ? 1 : 0;
            i16 = 5;
            i3 = ((Integer) d16[4]).intValue();
            z16 = false;
            i17 = i18;
        } else if (f16 == 20) {
            z16 = false;
            i3 = 0;
            i16 = 24;
        } else if (f16 != 37) {
            switch (f16) {
                case 39:
                    int i19 = ((Boolean) d16[4]).booleanValue() ? 37 : 6;
                    i3 = ((Integer) d16[2]).intValue();
                    i16 = i19;
                    z16 = false;
                    break;
                case 40:
                    i3 = ((Integer) d16[2]).intValue();
                    z16 = false;
                    i17 = 1;
                    break;
                case 41:
                    z16 = false;
                    i3 = 0;
                    i16 = 24;
                    i17 = 1;
                    break;
                default:
                    z16 = false;
                    i3 = 0;
                    i16 = 0;
                    z17 = false;
                    break;
            }
        } else {
            boolean booleanValue = ((Boolean) d16[1]).booleanValue();
            ((Long) d16[2]).longValue();
            ((Boolean) d16[3]).booleanValue();
            int i26 = !booleanValue ? 1 : 0;
            i16 = 2013;
            i3 = 0;
            i17 = i26;
            z16 = true;
        }
        if (!z17) {
            return null;
        }
        com.tencent.gdt.tangram.ad.qzone.embedded.a aVar2 = new com.tencent.gdt.tangram.ad.qzone.embedded.a(aVar.e());
        am0.b bVar = new am0.b();
        bVar.f(aVar2.f());
        bVar.e(aVar2.e());
        bVar.l(i16);
        bVar.n(i3);
        bVar.k(i17);
        bVar.m(z16);
        return bVar;
    }
}
