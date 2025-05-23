package com.tencent.luggage.wxa.i0;

import android.util.Log;
import com.tencent.luggage.wxa.n0.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(long j3, l lVar, com.tencent.luggage.wxa.q.l[] lVarArr) {
        while (lVar.a() > 1) {
            int a16 = a(lVar);
            int a17 = a(lVar);
            if (a17 != -1 && a17 <= lVar.a()) {
                if (a(a16, a17, lVar)) {
                    lVar.f(8);
                    int q16 = lVar.q() & 31;
                    lVar.f(1);
                    int i3 = q16 * 3;
                    int c16 = lVar.c();
                    for (com.tencent.luggage.wxa.q.l lVar2 : lVarArr) {
                        lVar.e(c16);
                        lVar2.a(lVar, i3);
                        lVar2.a(j3, 1, i3, 0, null);
                    }
                    lVar.f(a17 - (i3 + 10));
                } else {
                    lVar.f(a17);
                }
            } else {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                lVar.e(lVar.d());
            }
        }
    }

    public static int a(l lVar) {
        int i3 = 0;
        while (lVar.a() != 0) {
            int q16 = lVar.q();
            i3 += q16;
            if (q16 != 255) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean a(int i3, int i16, l lVar) {
        if (i3 != 4 || i16 < 8) {
            return false;
        }
        int c16 = lVar.c();
        int q16 = lVar.q();
        int w3 = lVar.w();
        int f16 = lVar.f();
        int q17 = lVar.q();
        lVar.e(c16);
        return q16 == 181 && w3 == 49 && f16 == 1195456820 && q17 == 3;
    }
}
