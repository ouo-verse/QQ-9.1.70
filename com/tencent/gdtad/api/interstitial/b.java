package com.tencent.gdtad.api.interstitial;

import com.tencent.gdtad.log.GdtLog;

/* compiled from: P */
/* loaded from: classes6.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f108633a = false;

    b() {
    }

    public static int a(int i3) {
        if (i3 != -8) {
            if (i3 != -7) {
                if (i3 != -6) {
                    if (i3 != -2) {
                        if (i3 != 0) {
                            return 1;
                        }
                        return 0;
                    }
                    return 3;
                }
                return 6;
            }
            return 13;
        }
        return 207;
    }

    public static void b() {
        GdtLog.i("GdtArkUtil", String.format("init %b", Boolean.valueOf(f108633a)));
        if (f108633a) {
            return;
        }
        synchronized (b.class) {
            if (f108633a) {
                return;
            }
            f108633a = true;
            l91.a.c(true);
            l91.a.a();
        }
    }
}
