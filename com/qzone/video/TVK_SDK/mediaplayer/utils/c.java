package com.qzone.video.TVK_SDK.mediaplayer.utils;

import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f59891a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f59892b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f59893c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f59894d;

    /* renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f59895e;

    /* renamed from: f, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f59896f;

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadPoolExecutor f59897g;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f59898d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "AsyncTask #" + this.f59898d.getAndIncrement());
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f59891a = availableProcessors;
        int i3 = availableProcessors + 1;
        f59892b = i3;
        int i16 = (availableProcessors * 2) + 1;
        f59893c = i16;
        f59894d = null;
        a aVar = new a();
        f59895e = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f59896f = linkedBlockingQueue;
        f59897g = new BaseThreadPoolExecutor(i3, i16, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }
}
