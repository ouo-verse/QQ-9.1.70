package com.heytap.mcssdk.f;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f36201a = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private static Handler f36202b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f36201a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f36202b.post(runnable);
    }
}
