package com.tencent.beacon.a.b;

import android.support.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class l implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f77626a = new AtomicInteger(1);

    public String a() {
        return "beacon-thread-" + this.f77626a.getAndIncrement();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        try {
            return new BaseThread(runnable, a());
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.a(e16);
            return null;
        } catch (OutOfMemoryError unused) {
            com.tencent.beacon.base.util.c.b("[task] memory not enough, create thread failed.", new Object[0]);
            return null;
        }
    }
}
