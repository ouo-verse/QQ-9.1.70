package ga3;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    static volatile Executor f401672a;

    q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        if (f401672a == null) {
            synchronized (q.class) {
                if (f401672a == null) {
                    BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(4, 4, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
                    f401672a = baseThreadPoolExecutor;
                }
            }
        }
        return f401672a;
    }
}
