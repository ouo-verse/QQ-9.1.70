package eu3;

import android.os.Looper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f397152a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f397153b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f397154c;

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadPoolExecutor f397155d;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(1, 1, 1L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: eu3.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread j3;
                j3 = f.j(runnable);
                return j3;
            }
        });
        f397152a = baseThreadPoolExecutor;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f397153b = availableProcessors;
        int max = Math.max(availableProcessors * 2, 5);
        f397154c = max;
        BaseThreadPoolExecutor baseThreadPoolExecutor2 = new BaseThreadPoolExecutor(max, max, 1L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: eu3.e
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread k3;
                k3 = f.k(runnable);
                return k3;
            }
        });
        f397155d = baseThreadPoolExecutor2;
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        baseThreadPoolExecutor2.allowCoreThreadTimeOut(true);
    }

    public static void c(Runnable runnable) {
        ThreadManager.getUIHandler().removeCallbacks(runnable);
    }

    public static void d(Runnable runnable, long j3) {
        ThreadManager.getSubThreadHandler().postDelayed(runnable, j3);
    }

    public static void e(Runnable runnable, long j3) {
        ThreadManager.getUIHandler().postDelayed(runnable, j3);
    }

    public static void f(Runnable runnable) {
        f397152a.execute(runnable);
    }

    public static void g(Runnable runnable) {
        ThreadManager.runIOTask(runnable);
    }

    public static void h(Runnable runnable) {
        f397155d.execute(runnable);
    }

    public static void i(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread j(Runnable runnable) {
        BaseThread baseThread = new BaseThread(runnable);
        baseThread.setName("mini-core");
        baseThread.setPriority(10);
        return baseThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread k(Runnable runnable) {
        BaseThread baseThread = new BaseThread(runnable);
        baseThread.setName("mini-init");
        baseThread.setPriority(10);
        return baseThread;
    }

    public static <T> Future<T> l(Callable<T> callable) {
        return f397155d.submit(callable);
    }
}
