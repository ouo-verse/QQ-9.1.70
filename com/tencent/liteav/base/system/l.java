package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final l f118995a = new l();

    l() {
    }

    public static Callable a() {
        return f118995a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.MANUFACTURER;
        return str;
    }
}
