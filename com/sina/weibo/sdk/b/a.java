package com.sina.weibo.sdk.b;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {
    private static final int K;
    private static final int L;
    private static final int M;
    private static final Comparator<Runnable> O;
    ThreadPoolExecutor N;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        K = availableProcessors;
        L = availableProcessors + 1;
        M = (availableProcessors * 2) + 1;
        O = new Comparator<Runnable>() { // from class: com.sina.weibo.sdk.b.a.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
                return 0;
            }
        };
    }

    public a() {
        if (this.N == null) {
            this.N = new BaseThreadPoolExecutor(L, M, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, O));
        }
    }
}
