package com.tencent.luggage.wxa.m7;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.WxaNativeCrashTest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements com.tencent.luggage.wxa.vi.b {
    @Override // com.tencent.luggage.wxa.vi.b
    public String a(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return "Test Native Crash";
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public boolean c(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        return true;
    }

    @Override // com.tencent.luggage.wxa.vi.b
    public void b(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        WxaNativeCrashTest.crashForTest();
    }
}
