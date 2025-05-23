package com.tencent.tab.exp.sdk.impl;

import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes26.dex */
final class v implements jd4.a {

    /* renamed from: b, reason: collision with root package name */
    private static final int f374177b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f374178c;

    /* renamed from: d, reason: collision with root package name */
    private static final HandlerThread f374179d;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ExecutorService f374180a = ProxyExecutors.newFixedThreadPool(f374178c);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f374177b = availableProcessors;
        f374178c = (availableProcessors * 2) + 1;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TabDataRollHandlerThread");
        f374179d = baseHandlerThread;
        baseHandlerThread.start();
    }

    @Override // jd4.a
    public Looper a() {
        return f374179d.getLooper();
    }

    @Override // jd4.a
    public void execWorkTask(@NonNull Runnable runnable) {
        this.f374180a.execute(runnable);
    }
}
