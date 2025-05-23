package com.tencent.luggage.wxa.n3;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f135239a = new p0();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tn.f0 f135240b;

    /* renamed from: c, reason: collision with root package name */
    public static int f135241c;

    static {
        com.tencent.luggage.wxa.tn.f0 c16 = com.tencent.luggage.wxa.tn.f0.c("Luggage.WxaStatusStore", 2);
        Intrinsics.checkNotNullExpressionValue(c16, "getMMKV(TAG, MultiProcessMMKV.MULTI_PROCESS_MODE)");
        f135240b = c16;
    }

    public final void a(int i3) {
        f135241c = i3;
    }

    public final void a(long j3) {
        f135240b.putLong("reportUin", j3).commit();
    }
}
