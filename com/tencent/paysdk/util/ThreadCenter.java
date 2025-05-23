package com.tencent.paysdk.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
/* loaded from: classes22.dex */
public class ThreadCenter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static ThreadImpl f342064a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f342065b;

    /* renamed from: c, reason: collision with root package name */
    public static c f342066c;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TaskProxy implements Runnable, Comparable<TaskProxy> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f342067d;

        /* renamed from: e, reason: collision with root package name */
        Runnable f342068e;

        /* renamed from: f, reason: collision with root package name */
        StackTraceElement[] f342069f;

        public TaskProxy(int i3, Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) runnable);
                return;
            }
            this.f342067d = i3;
            this.f342068e = runnable;
            if (ThreadCenter.f342065b) {
                this.f342069f = new Throwable().getStackTrace();
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(TaskProxy taskProxy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) taskProxy)).intValue();
            }
            return this.f342067d - taskProxy.f342067d;
        }

        void h() {
            if (this.f342069f != null) {
                Log.e("taskproxy_log", "one task has consumed too long time:\n" + (this.f342069f[3].getClassName() + "(line " + this.f342069f[3].getLineNumber() + "):" + this.f342069f[3].getMethodName()));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f342068e.run();
            if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class ThreadImpl {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f342070a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<Integer, Handler> f342071b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f342072c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadPoolExecutor f342073d;

        /* renamed from: e, reason: collision with root package name */
        private ConcurrentHashMap<Object, Runnable> f342074e;

        /* renamed from: f, reason: collision with root package name */
        private ConcurrentHashMap<String, b> f342075f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f342076g;

        public ThreadImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f342070a = 2;
            this.f342071b = new ConcurrentHashMap<>();
            this.f342074e = new ConcurrentHashMap<>();
            this.f342075f = new ConcurrentHashMap<>();
            this.f342076g = false;
            this.f342076g = true;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("basetimer");
            baseHandlerThread.start();
            this.f342072c = new Handler(baseHandlerThread.getLooper());
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors > 0) {
                this.f342070a = availableProcessors;
            }
            Log.v("threadimpl_log", "thread pool size " + this.f342070a);
            int i3 = this.f342070a;
            this.f342073d = new BaseThreadPoolExecutor(i3, i3, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
            h();
            Log.v("threadimpl_log", "thread create ok");
        }

        private void h() {
            this.f342072c.postDelayed(new Runnable() { // from class: com.tencent.paysdk.util.ThreadCenter.ThreadImpl.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThreadImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Log.i("threadimpl_log", "idle check begin...");
                    Iterator it = ThreadImpl.this.f342075f.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (((b) entry.getValue()).a()) {
                            ((b) entry.getValue()).d();
                            it.remove();
                            Log.e("threadimpl_log", "remove handler thread: " + ((String) entry.getKey()));
                        }
                    }
                    ThreadImpl.this.f342072c.postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                }
            }, MiniBoxNoticeInfo.MIN_5);
        }

        public void e(Runnable runnable, long j3, boolean z16, String str) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(j3), Boolean.valueOf(z16), str);
                return;
            }
            if (runnable == null) {
                return;
            }
            if (str == null) {
                if (j3 > 0) {
                    Runnable runnable2 = new Runnable(runnable, new TaskProxy(10, runnable)) { // from class: com.tencent.paysdk.util.ThreadCenter.ThreadImpl.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Runnable f342077d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TaskProxy f342078e;

                        {
                            this.f342077d = runnable;
                            this.f342078e = r9;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ThreadImpl.this, runnable, r9);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                ThreadImpl.this.f342074e.remove(this.f342077d);
                                ThreadImpl.this.f342073d.execute(this.f342078e);
                            }
                        }
                    };
                    this.f342074e.put(runnable, runnable2);
                    this.f342072c.postDelayed(runnable2, j3);
                    return;
                } else {
                    ThreadPoolExecutor threadPoolExecutor = this.f342073d;
                    if (!z16) {
                        i3 = 10;
                    }
                    threadPoolExecutor.execute(new TaskProxy(i3, runnable));
                    return;
                }
            }
            if (this.f342075f.containsKey(str)) {
                bVar = this.f342075f.get(str);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.f342075f.put(str, bVar);
                Log.v("threadimpl_log", "create new thread: " + str);
            }
            if (j3 > 0) {
                bVar.c(runnable, j3);
            } else {
                bVar.b(runnable, z16);
            }
        }

        public void f(c cVar, Runnable runnable, long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cVar, runnable, Long.valueOf(j3), Boolean.valueOf(z16));
                return;
            }
            if (runnable == null) {
                return;
            }
            if (cVar == null) {
                cVar = ThreadCenter.f342066c;
            }
            Handler handler = this.f342071b.get(Integer.valueOf(cVar.hashCode()));
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
                this.f342071b.put(Integer.valueOf(cVar.hashCode()), handler);
            }
            if (j3 > 0) {
                handler.postDelayed(runnable, j3);
            } else if (z16) {
                handler.postAtFrontOfQueue(runnable);
            } else {
                handler.post(runnable);
            }
        }

        public void g(c cVar, Runnable runnable) {
            Handler handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar, (Object) runnable);
            } else if (runnable != null && (handler = this.f342071b.get(Integer.valueOf(cVar.hashCode()))) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f342079a;

        /* renamed from: b, reason: collision with root package name */
        Handler f342080b;

        /* renamed from: c, reason: collision with root package name */
        HandlerThread f342081c;

        /* renamed from: d, reason: collision with root package name */
        boolean f342082d;

        public b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f342079a = 0L;
            this.f342082d = true;
            if (!TextUtils.isEmpty(str)) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
                this.f342081c = baseHandlerThread;
                baseHandlerThread.start();
                this.f342080b = new Handler(this.f342081c.getLooper());
                return;
            }
            throw new RuntimeException("Handle ID empty!");
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.f342082d && System.currentTimeMillis() - this.f342079a > MiniBoxNoticeInfo.MIN_5) {
                return true;
            }
            return false;
        }

        public void b(Runnable runnable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, runnable, Boolean.valueOf(z16));
                return;
            }
            this.f342079a = System.currentTimeMillis();
            if (z16) {
                this.f342080b.postAtFrontOfQueue(runnable);
            } else {
                this.f342080b.post(runnable);
            }
        }

        public void c(Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, runnable, Long.valueOf(j3));
            } else {
                this.f342079a = System.currentTimeMillis() + j3;
                this.f342080b.postDelayed(runnable, j3);
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else if (this.f342081c.isAlive()) {
                this.f342081c.quit();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f342064a = new ThreadImpl();
        f342065b = false;
        f342066c = new a();
    }

    public static void a(Runnable runnable) {
        f342064a.f(f342066c, runnable, 0L, false);
    }

    public static void b(c cVar, Runnable runnable, long j3) {
        f342064a.f(cVar, runnable, j3, false);
    }

    public static void c(Runnable runnable) {
        f342064a.e(runnable, 0L, false, null);
    }

    public static void d(Runnable runnable) {
        f342064a.g(f342066c, runnable);
    }
}
