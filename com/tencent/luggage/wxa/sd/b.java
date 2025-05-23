package com.tencent.luggage.wxa.sd;

import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static final boolean a(com.tencent.luggage.wxa.z7.c cVar) {
        v vVar;
        boolean z16;
        com.tencent.luggage.wxa.qc.c c06;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        com.tencent.luggage.wxa.xd.d e16 = cVar.e();
        com.tencent.luggage.wxa.qc.b bVar = null;
        if (e16 instanceof v) {
            vVar = (v) e16;
        } else {
            vVar = null;
        }
        if (vVar == null) {
            w.b("MicroMsg.AppBrandInvokeContextExt", "isPageInForeground, pageView is null");
            return false;
        }
        boolean M0 = vVar.M0();
        com.tencent.luggage.wxa.qc.b bVar2 = com.tencent.luggage.wxa.qc.b.FOREGROUND;
        g runtime = vVar.getRuntime();
        if (runtime != null && (c06 = runtime.c0()) != null) {
            bVar = c06.b();
        }
        if (bVar2 == bVar) {
            z16 = true;
        } else {
            z16 = false;
        }
        w.d("MicroMsg.AppBrandInvokeContextExt", "isPageInForeground, isPageInForeground: " + M0 + ", isRuntimeInForeground: " + z16);
        if (!M0 || !z16) {
            return false;
        }
        return true;
    }
}
