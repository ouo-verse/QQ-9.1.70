package com.tencent.local_edit.andserver.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f119873b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f119874c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f119875a = ProxyExecutors.newCachedThreadPool();

    b() {
        f119874c = new Handler(Looper.getMainLooper());
    }

    public static b b() {
        if (f119873b == null) {
            synchronized (b.class) {
                if (f119873b == null) {
                    f119873b = new b();
                }
            }
        }
        return f119873b;
    }

    public void a(Runnable runnable) {
        this.f119875a.execute(runnable);
    }

    public void c(Runnable runnable) {
        f119874c.post(runnable);
    }
}
