package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class o implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final o f118998a = new o();

    o() {
    }

    public static Callable a() {
        return f118998a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Integer valueOf;
        valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
        return valueOf;
    }
}
