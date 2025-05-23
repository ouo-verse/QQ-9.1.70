package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class m implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final m f118996a = new m();

    m() {
    }

    public static Callable a() {
        return f118996a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.HARDWARE;
        return str;
    }
}
