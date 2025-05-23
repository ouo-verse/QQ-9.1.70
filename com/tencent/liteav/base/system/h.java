package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class h implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final h f118991a = new h();

    h() {
    }

    public static Callable a() {
        return f118991a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String[] strArr;
        strArr = Build.SUPPORTED_ABIS;
        return strArr;
    }
}
