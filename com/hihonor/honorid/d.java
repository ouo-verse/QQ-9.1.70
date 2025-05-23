package com.hihonor.honorid;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d implements c {

    /* renamed from: b, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f36326b = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    private static final int f36327c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f36328d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f36329e;

    /* renamed from: f, reason: collision with root package name */
    private static d f36330f;

    /* renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f36331a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f36327c = availableProcessors;
        f36328d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f36329e = (availableProcessors * 2) + 1;
    }

    d() {
        new Handler(Looper.getMainLooper());
        this.f36331a = new BaseThreadPoolExecutor(f36328d, f36329e, 30L, TimeUnit.SECONDS, f36326b);
    }

    public static d a() {
        d dVar;
        synchronized (d.class) {
            if (f36330f == null) {
                f36330f = new d();
            }
            dVar = f36330f;
        }
        return dVar;
    }

    @Override // com.hihonor.honorid.c
    public void execute(Runnable runnable) {
        this.f36331a.execute(runnable);
    }
}
