package com.tencent.luggage.wxa.ka;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.Thread;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    public static volatile s f131876c;

    /* renamed from: d, reason: collision with root package name */
    public static com.tencent.luggage.wxa.la.b f131877d;

    /* renamed from: e, reason: collision with root package name */
    public static final HandlerThread f131878e;

    /* renamed from: a, reason: collision with root package name */
    public Handler f131879a = new Handler(f131878e.getLooper());

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f131880b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.la.b {

        /* renamed from: a, reason: collision with root package name */
        public int f131881a = 3;

        /* renamed from: b, reason: collision with root package name */
        public HandlerThread f131882b = a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ka.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ThreadFactoryC6372a implements ThreadFactory {

            /* renamed from: a, reason: collision with root package name */
            public int f131883a = 0;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ka.s$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6373a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f131885a;

                public RunnableC6373a(Runnable runnable) {
                    this.f131885a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    ThreadLocal threadLocal = (ThreadLocal) new com.tencent.luggage.wxa.sa.a(Looper.class, "sThreadLocal").a();
                    if (threadLocal != null && threadLocal.get() == null) {
                        com.tencent.luggage.wxa.ta.c.a("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
                        threadLocal.set(a.this.f131882b.getLooper());
                    } else {
                        com.tencent.luggage.wxa.ta.c.a("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                    }
                    this.f131885a.run();
                }
            }

            public ThreadFactoryC6372a() {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("IPCThreadPool#Thread-");
                int i3 = this.f131883a;
                this.f131883a = i3 + 1;
                sb5.append(i3);
                String sb6 = sb5.toString();
                BaseThread baseThread = new BaseThread(new RunnableC6373a(runnable), sb6);
                com.tencent.luggage.wxa.ta.c.c("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", sb6);
                return baseThread;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b extends BaseScheduledThreadPoolExecutor {

            /* renamed from: a, reason: collision with root package name */
            public final Set f131887a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ka.s$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6374a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Runnable f131889a;

                public RunnableC6374a(Runnable runnable) {
                    this.f131889a = runnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        s sVar = s.f131876c;
                        this.f131889a.run();
                    } catch (Throwable th5) {
                        try {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                            if (uncaughtExceptionHandler == null) {
                                uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                            }
                            if (uncaughtExceptionHandler != null) {
                                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th5);
                            }
                            throw th5;
                        } catch (Throwable th6) {
                            s sVar2 = s.f131876c;
                            throw th6;
                        }
                    }
                }
            }

            public b(int i3, ThreadFactory threadFactory) {
                super(i3, threadFactory);
                this.f131887a = Collections.synchronizedSet(new HashSet());
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
            public void afterExecute(Runnable runnable, Throwable th5) {
                super.afterExecute(runnable, th5);
                this.f131887a.remove(runnable);
                com.tencent.luggage.wxa.ta.c.c("IPC.ExecutorServiceCreatorImpl", "afterExecute " + runnable, new Object[0]);
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
            public void beforeExecute(Thread thread, Runnable runnable) {
                super.beforeExecute(thread, runnable);
                this.f131887a.add(runnable);
                com.tencent.luggage.wxa.ta.c.c("IPC.ExecutorServiceCreatorImpl", "beforeExecute " + runnable, new Object[0]);
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                super.execute(new RunnableC6374a(runnable));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements RejectedExecutionHandler {
            public c() {
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                com.tencent.luggage.wxa.ta.c.e("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", runnable);
            }
        }

        public final HandlerThread a() {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("IPCThreadPool#InnerWorkerThread-" + hashCode());
            baseHandlerThread.start();
            com.tencent.luggage.wxa.ta.c.c("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", Integer.valueOf(baseHandlerThread.hashCode()));
            return baseHandlerThread;
        }

        @Override // com.tencent.luggage.wxa.la.b
        public ExecutorService create() {
            b bVar = new b(this.f131881a, new ThreadFactoryC6372a());
            bVar.setMaximumPoolSize((int) (this.f131881a * 1.5d));
            bVar.setRejectedExecutionHandler(new c());
            return bVar;
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("IPCThreadPool#WorkerThread");
        f131878e = baseHandlerThread;
        baseHandlerThread.start();
    }

    public s() {
        if (f131877d == null) {
            f131877d = new a();
        }
        this.f131880b = f131877d.create();
        com.tencent.luggage.wxa.ta.c.c("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
    }

    public static Handler a() {
        return new Handler(f131878e.getLooper());
    }

    public static s b() {
        if (f131876c == null) {
            synchronized (s.class) {
                if (f131876c == null) {
                    f131876c = new s();
                }
            }
        }
        return f131876c;
    }

    public static boolean a(Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        b().f131880b.submit(runnable);
        if (!(b().f131880b instanceof ThreadPoolExecutor)) {
            return true;
        }
        Iterator<Runnable> it = ((ThreadPoolExecutor) b().f131880b).getQueue().iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ta.c.c("IPC.IPCThreadPool", "tasks is queue " + it.next(), new Object[0]);
        }
        return true;
    }

    public static boolean a(Runnable runnable) {
        return a(runnable, "unknown");
    }
}
