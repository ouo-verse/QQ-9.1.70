package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class p implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final p f118999a = new p();

    p() {
    }

    public static Callable a() {
        return f118999a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String str;
        str = Build.BOARD;
        return str;
    }
}
