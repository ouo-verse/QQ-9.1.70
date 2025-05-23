package com.huawei.hms.push;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f37489a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f37490b = new BaseThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f37489a) {
            threadPoolExecutor = f37490b;
        }
        return threadPoolExecutor;
    }
}
