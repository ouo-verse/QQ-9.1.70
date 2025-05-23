package com.tencent.luggage.wxa.s2;

import com.tencent.luggage.wxa.ef.o;
import com.tencent.luggage.wxa.ef.p;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(g gVar, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        w.d("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged been called, flag = %d", Integer.valueOf(i3));
        if (gVar != null) {
            o oVar = (o) gVar.c(o.class);
            if (!(oVar instanceof p)) {
                w.f("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged, invalid location state manager");
                return;
            }
            p pVar = (p) oVar;
            if (((i3 >> 1) & 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((i3 & 1) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!pVar.p() && !z16) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (pVar.p() && (!z17 || !z16)) {
                z19 = true;
            } else {
                z19 = false;
            }
            w.d("WMPF.WMPFBackgroundRunningMonitor", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", Boolean.valueOf(z18), Boolean.valueOf(z19));
            if (z18 || z19) {
                pVar.n();
                pVar.a(gVar);
            }
        }
    }
}
