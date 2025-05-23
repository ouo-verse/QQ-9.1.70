package com.tencent.luggage.wxa.u;

import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f141966a = {v.b("isom"), v.b("iso2"), v.b("iso3"), v.b("iso4"), v.b("iso5"), v.b("iso6"), v.b("avc1"), v.b("hvc1"), v.b("hev1"), v.b("mp41"), v.b("mp42"), v.b("3g2a"), v.b("3g2b"), v.b("3gr6"), v.b("3gs6"), v.b("3ge6"), v.b("3gg6"), v.b("M4V "), v.b("M4A "), v.b("f4v "), v.b("kddi"), v.b("M4VP"), v.b("qt  "), v.b("MSNV")};

    public static boolean a(com.tencent.luggage.wxa.q.e eVar) {
        return a(eVar, true);
    }

    public static boolean b(com.tencent.luggage.wxa.q.e eVar) {
        return a(eVar, false);
    }

    public static boolean a(com.tencent.luggage.wxa.q.e eVar, boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        long length = eVar.getLength();
        long j3 = -1;
        if (length == -1 || length > 4096) {
            length = 4096;
        }
        int i16 = (int) length;
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(64);
        int i17 = 0;
        boolean z19 = false;
        while (i17 < i16) {
            lVar.c(8);
            eVar.b(lVar.f135088a, 0, 8);
            long s16 = lVar.s();
            int f16 = lVar.f();
            if (s16 == 1) {
                eVar.b(lVar.f135088a, 8, 8);
                lVar.d(16);
                i3 = 16;
                s16 = lVar.v();
            } else {
                if (s16 == 0) {
                    long length2 = eVar.getLength();
                    if (length2 != j3) {
                        s16 = 8 + (length2 - eVar.getPosition());
                    }
                }
                i3 = 8;
            }
            long j16 = i3;
            if (s16 < j16) {
                return false;
            }
            i17 += i3;
            if (f16 != a.C) {
                if (f16 == a.L || f16 == a.N) {
                    z17 = true;
                    z18 = true;
                    break;
                }
                if ((i17 + s16) - j16 >= i16) {
                    break;
                }
                int i18 = (int) (s16 - j16);
                i17 += i18;
                if (f16 == a.f141791b) {
                    if (i18 < 8) {
                        return false;
                    }
                    lVar.c(i18);
                    eVar.b(lVar.f135088a, 0, i18);
                    int i19 = i18 / 4;
                    int i26 = 0;
                    while (true) {
                        if (i26 >= i19) {
                            break;
                        }
                        if (i26 == 1) {
                            lVar.f(4);
                        } else if (a(lVar.f())) {
                            z19 = true;
                            break;
                        }
                        i26++;
                    }
                    if (!z19) {
                        return false;
                    }
                } else if (i18 != 0) {
                    eVar.a(i18);
                }
                j3 = -1;
            }
        }
        z17 = true;
        z18 = false;
        if (z19 && z16 == z18) {
            return z17;
        }
        return false;
    }

    public static boolean a(int i3) {
        if ((i3 >>> 8) == v.b("3gp")) {
            return true;
        }
        for (int i16 : f141966a) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }
}
