package com.tencent.qqlive.superplayer.tools.utils;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static ExecutorService f345491a = ProxyExecutors.newCachedThreadPool();

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledExecutorService f345492b = null;
}
