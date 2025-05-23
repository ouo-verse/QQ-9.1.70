package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f36533a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final int f36534c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f36535d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f36536e;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f36537b = new ExecutorC0256a(0);

    /* compiled from: P */
    /* renamed from: com.huawei.hmf.tasks.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class ExecutorC0256a implements Executor {
        ExecutorC0256a() {
        }

        /* synthetic */ ExecutorC0256a(byte b16) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f36534c = availableProcessors;
        f36535d = availableProcessors + 1;
        f36536e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(f36535d, f36536e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }

    public static Executor b() {
        return f36533a.f36537b;
    }
}
