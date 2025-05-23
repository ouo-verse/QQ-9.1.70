package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final k f118994a = new k();

    k() {
    }

    public static Callable a() {
        return f118994a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.BRAND;
        return str;
    }
}
