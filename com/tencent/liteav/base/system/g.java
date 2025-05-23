package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class g implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final g f118990a = new g();

    g() {
    }

    public static Callable a() {
        return f118990a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String a16;
        a16 = q.a(LiteavSystemInfo.sAppPackageName.a());
        return a16;
    }
}
