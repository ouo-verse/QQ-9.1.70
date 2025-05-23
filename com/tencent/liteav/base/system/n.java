package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class n implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final n f118997a = new n();

    n() {
    }

    public static Callable a() {
        return f118997a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.VERSION.RELEASE;
        return str;
    }
}
