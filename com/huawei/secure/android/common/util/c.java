package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f38040a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f38040a.post(runnable);
    }
}
