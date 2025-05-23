package com.tencent.luggage.wxa.tf;

import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static void a(String str, int i3) {
        a(str, i3, -1);
    }

    public static void a(String str, int i3, int i16) {
        w.d("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        ((com.tencent.luggage.wxa.zj.d) e.c(com.tencent.luggage.wxa.zj.d.class)).a(14837, str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static void a(String str) {
        w.d("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", str);
        ((com.tencent.luggage.wxa.zj.d) e.c(com.tencent.luggage.wxa.zj.d.class)).a(14838, str);
    }
}
