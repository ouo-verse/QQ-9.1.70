package com.tencent.mobileqq.vasgift.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThreadManager {

    /* renamed from: a, reason: collision with root package name */
    static ThreadImpl f311988a = new ThreadImpl();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f311989b = false;

    /* renamed from: c, reason: collision with root package name */
    public static c f311990c = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class TaskProxy implements Runnable, Comparable<TaskProxy> {

        /* renamed from: d, reason: collision with root package name */
        int f311991d;

        /* renamed from: e, reason: collision with root package name */
        Runnable f311992e;

        /* renamed from: f, reason: collision with root package name */
        StackTraceElement[] f311993f;

        TaskProxy(int i3, Runnable runnable) {
            this.f311991d = i3;
            this.f311992e = runnable;
            if (ThreadManager.f311989b) {
                this.f311993f = new Throwable().getStackTrace();
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(TaskProxy taskProxy) {
            return this.f311991d - taskProxy.f311991d;
        }

        void h() {
            if (this.f311993f != null) {
                Log.e("taskproxy_log", "one task has consumed too long time:\n" + (this.f311993f[3].getClassName() + "(line " + this.f311993f[3].getLineNumber() + "):" + this.f311993f[3].getMethodName()));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            this.f311992e.run();
            if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class ThreadImpl {

        /* renamed from: a, reason: collision with root package name */
        private int f311994a;

        /* renamed from: c, reason: collision with root package name */
        private Handler f311996c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadPoolExecutor f311997d;

        /* renamed from: g, reason: collision with root package name */
        private boolean f312000g;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<Integer, Handler> f311995b = new ConcurrentHashMap<>();

        /* renamed from: e, reason: collision with root package name */
        private ConcurrentHashMap<Object, Runnable> f311998e = new ConcurrentHashMap<>();

        /* renamed from: f, reason: collision with root package name */
        private ConcurrentHashMap<String, b> f311999f = new ConcurrentHashMap<>();

        ThreadImpl() {
            this.f311994a = 2;
            this.f312000g = false;
            this.f312000g = true;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("basetimer");
            baseHandlerThread.start();
            this.f311996c = new Handler(baseHandlerThread.getLooper());
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors > 0) {
                this.f311994a = availableProcessors;
            }
            Log.v("threadimpl_log", "thread pool size " + this.f311994a);
            int i3 = this.f311994a;
            this.f311997d = new BaseThreadPoolExecutor(i3, i3, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
            h();
            Log.v("threadimpl_log", "thread create ok");
        }

        private void h() {
            this.f311996c.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vasgift.utils.ThreadManager.ThreadImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("threadimpl_log", "idle check begin...");
                    Iterator it = ThreadImpl.this.f311999f.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (((b) entry.getValue()).a()) {
                            ((b) entry.getValue()).d();
                            it.remove();
                            Log.e("threadimpl_log", "remove handler thread: " + ((String) entry.getKey()));
                        }
                    }
                    ThreadImpl.this.f311996c.postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                }
            }, MiniBoxNoticeInfo.MIN_5);
        }

        void e(final Runnable runnable, long j3, boolean z16, String str) {
            b bVar;
            if (runnable == null) {
                return;
            }
            if (str == null) {
                int i3 = 10;
                if (j3 > 0) {
                    final TaskProxy taskProxy = new TaskProxy(10, runnable);
                    Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.vasgift.utils.ThreadManager.ThreadImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ThreadImpl.this.f311998e.remove(runnable);
                            ThreadImpl.this.f311997d.execute(taskProxy);
                        }
                    };
                    this.f311998e.put(runnable, runnable2);
                    this.f311996c.postDelayed(runnable2, j3);
                    return;
                }
                ThreadPoolExecutor threadPoolExecutor = this.f311997d;
                if (z16) {
                    i3 = 0;
                }
                threadPoolExecutor.execute(new TaskProxy(i3, runnable));
                return;
            }
            if (this.f311999f.containsKey(str)) {
                bVar = this.f311999f.get(str);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.f311999f.put(str, bVar);
                Log.v("threadimpl_log", "create new thread: " + str);
            }
            if (j3 > 0) {
                bVar.c(runnable, j3);
            } else {
                bVar.b(runnable, z16);
            }
        }

        void f(c cVar, Runnable runnable, long j3, boolean z16) {
            if (runnable == null) {
                return;
            }
            if (cVar == null) {
                cVar = ThreadManager.f311990c;
            }
            Handler handler = this.f311995b.get(Integer.valueOf(cVar.hashCode()));
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
                this.f311995b.put(Integer.valueOf(cVar.hashCode()), handler);
            }
            if (j3 > 0) {
                handler.postDelayed(runnable, j3);
            } else if (z16) {
                handler.postAtFrontOfQueue(runnable);
            } else {
                handler.post(runnable);
            }
        }

        void g(c cVar, Runnable runnable) {
            Handler handler;
            if (runnable != null && (handler = this.f311995b.get(Integer.valueOf(cVar.hashCode()))) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements c {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: b, reason: collision with root package name */
        Handler f312004b;

        /* renamed from: c, reason: collision with root package name */
        HandlerThread f312005c;

        /* renamed from: a, reason: collision with root package name */
        long f312003a = 0;

        /* renamed from: d, reason: collision with root package name */
        boolean f312006d = true;

        b(String str) {
            if (!TextUtils.isEmpty(str)) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
                this.f312005c = baseHandlerThread;
                baseHandlerThread.start();
                this.f312004b = new Handler(this.f312005c.getLooper());
                return;
            }
            throw new RuntimeException("Handle ID empty!");
        }

        boolean a() {
            if (this.f312006d && System.currentTimeMillis() - this.f312003a > MiniBoxNoticeInfo.MIN_5) {
                return true;
            }
            return false;
        }

        public void b(Runnable runnable, boolean z16) {
            this.f312003a = System.currentTimeMillis();
            if (z16) {
                this.f312004b.postAtFrontOfQueue(runnable);
            } else {
                this.f312004b.post(runnable);
            }
        }

        public void c(Runnable runnable, long j3) {
            this.f312003a = System.currentTimeMillis() + j3;
            this.f312004b.postDelayed(runnable, j3);
        }

        void d() {
            if (this.f312005c.isAlive()) {
                this.f312005c.quit();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    public static void a(Runnable runnable) {
        f311988a.f(f311990c, runnable, 0L, false);
    }

    public static void b(Runnable runnable, long j3) {
        f311988a.f(f311990c, runnable, j3, false);
    }

    public static void c(Runnable runnable, boolean z16) {
        f311988a.e(runnable, 0L, z16, null);
    }

    public static void d(Runnable runnable) {
        f311988a.g(f311990c, runnable);
    }
}
