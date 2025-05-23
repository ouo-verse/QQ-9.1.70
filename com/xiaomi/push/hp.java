package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hp {

    /* renamed from: a, reason: collision with root package name */
    private static int f389373a = Integer.MAX_VALUE;

    public static void a(hn hnVar, byte b16) {
        b(hnVar, b16, f389373a);
    }

    public static void b(hn hnVar, byte b16, int i3) {
        if (i3 > 0) {
            int i16 = 0;
            switch (b16) {
                case 2:
                    hnVar.y();
                    return;
                case 3:
                    hnVar.a();
                    return;
                case 4:
                    hnVar.b();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    hnVar.l();
                    return;
                case 8:
                    hnVar.c();
                    return;
                case 10:
                    hnVar.d();
                    return;
                case 11:
                    hnVar.k();
                    return;
                case 12:
                    hnVar.i();
                    while (true) {
                        byte b17 = hnVar.e().f388941b;
                        if (b17 == 0) {
                            hnVar.D();
                            return;
                        } else {
                            b(hnVar, b17, i3 - 1);
                            hnVar.E();
                        }
                    }
                case 13:
                    gd g16 = hnVar.g();
                    while (i16 < g16.f388950c) {
                        int i17 = i3 - 1;
                        b(hnVar, g16.f388948a, i17);
                        b(hnVar, g16.f388949b, i17);
                        i16++;
                    }
                    hnVar.F();
                    return;
                case 14:
                    hr h16 = hnVar.h();
                    while (i16 < h16.f389375b) {
                        b(hnVar, h16.f389374a, i3 - 1);
                        i16++;
                    }
                    hnVar.H();
                    return;
                case 15:
                    gc f16 = hnVar.f();
                    while (i16 < f16.f388947b) {
                        b(hnVar, f16.f388946a, i3 - 1);
                        i16++;
                    }
                    hnVar.G();
                    return;
            }
        } else {
            throw new hu("Maximum skip depth exceeded");
        }
    }
}
