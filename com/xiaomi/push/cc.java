package com.xiaomi.push;

import android.content.Context;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cc {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f388376a = new BaseThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a(Context context) {
    }
}
