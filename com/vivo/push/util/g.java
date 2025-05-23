package com.vivo.push.util;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final int f387898a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f387899b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f387900c;

    /* renamed from: d, reason: collision with root package name */
    private static ExecutorService f387901d;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f387898a = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f387899b = max;
        int i3 = (availableProcessors * 2) + 1;
        f387900c = i3;
        f387901d = new BaseThreadPoolExecutor(max, i3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static ExecutorService a() {
        return f387901d;
    }
}
