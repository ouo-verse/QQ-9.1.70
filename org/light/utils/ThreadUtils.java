package org.light.utils;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ThreadUtils {
    public static ExecutorService service = ProxyExecutors.newSingleThreadExecutor();

    public static void executeTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        service.execute(runnable);
    }
}
