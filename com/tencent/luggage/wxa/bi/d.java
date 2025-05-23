package com.tencent.luggage.wxa.bi;

import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static final com.tencent.luggage.wxa.ic.g a(com.tencent.luggage.wxa.z7.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar instanceof AppBrandInvokeContext) {
            com.tencent.luggage.wxa.xd.d e16 = ((AppBrandInvokeContext) cVar).e();
            if (e16 instanceof com.tencent.luggage.wxa.ic.d) {
                com.tencent.luggage.wxa.ic.g runtime = ((com.tencent.luggage.wxa.ic.d) e16).getRuntime();
                Intrinsics.checkNotNullExpressionValue(runtime, "component.runtime");
                return runtime;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
