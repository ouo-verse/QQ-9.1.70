package com.tencent.luggage.wxa.cc;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f123463a = ProxyExecutors.newSingleThreadScheduledExecutor();

    @Override // com.tencent.luggage.wxa.cc.b
    public Future a(Runnable runnable, long j3, long j16) {
        return this.f123463a.scheduleWithFixedDelay(runnable, j3, j16, TimeUnit.MILLISECONDS);
    }
}
