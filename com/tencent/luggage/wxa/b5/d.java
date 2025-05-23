package com.tencent.luggage.wxa.b5;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static final l a(com.tencent.luggage.wxa.c5.e runtime) {
        String str;
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        int i3 = runtime.S().f130794f0;
        String appId = runtime.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "runtime.appId");
        int l06 = runtime.l0();
        boolean l3 = runtime.S().l();
        int i16 = runtime.S().I + 1000;
        String k3 = runtime.S().k();
        Intrinsics.checkNotNullExpressionValue(k3, "runtime.initConfig.wxaLaunchInstanceId");
        String str2 = runtime.S().G;
        Intrinsics.checkNotNullExpressionValue(str2, "runtime.initConfig.username");
        com.tencent.luggage.wxa.j4.d S = runtime.S();
        Intrinsics.checkNotNullExpressionValue(S, "runtime.initConfig");
        boolean z16 = runtime.S().f130795g0;
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            str = Log.getStackTraceString(new Throwable());
        } else {
            str = "debug use only";
        }
        String str3 = str;
        Intrinsics.checkNotNullExpressionValue(str3, "if (BuildInfo.DEBUG) {\n \u2026debug use only\"\n        }");
        return new l(i3, appId, l06, l3, i16, k3, str2, S, z16, str3);
    }
}
