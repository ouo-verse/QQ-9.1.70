package com.tencent.mobileqq.qqlive.utils;

import android.os.Handler;
import android.os.HandlerThread;
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
/* loaded from: classes17.dex */
public class ThreadCenter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static ThreadImpl f273427a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f273428b;

    /* renamed from: c, reason: collision with root package name */
    public static c f273429c;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class TaskProxy implements Runnable, Comparable<TaskProxy> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f273430d;

        /* renamed from: e, reason: collision with root package name */
        Runnable f273431e;

        /* renamed from: f, reason: collision with root package name */
        StackTraceElement[] f273432f;

        TaskProxy(int i3, Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) runnable);
                return;
            }
            this.f273430d = i3;
            this.f273431e = runnable;
            if (ThreadCenter.f273428b) {
                this.f273432f = new Throwable().getStackTrace();
            }
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(TaskProxy taskProxy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) taskProxy)).intValue();
            }
            return this.f273430d - taskProxy.f273430d;
        }

        void h() {
            if (this.f273432f != null) {
                Log.e("taskproxy_log", "one task has consumed too long time:\n" + (this.f273432f[3].getClassName() + "(line " + this.f273432f[3].getLineNumber() + "):" + this.f273432f[3].getMethodName()));
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
            this.f273431e.run();
            if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private static class ThreadImpl {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f273433a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<Integer, Handler> f273434b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f273435c;

        /* renamed from: d, reason: collision with root package name */
        private ThreadPoolExecutor f273436d;

        /* renamed from: e, reason: collision with root package name */
        private ConcurrentHashMap<Object, Runnable> f273437e;

        /* renamed from: f, reason: collision with root package name */
        private ConcurrentHashMap<String, b> f273438f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f273439g;

        ThreadImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f273433a = 2;
            this.f273434b = new ConcurrentHashMap<>();
            this.f273437e = new ConcurrentHashMap<>();
            this.f273438f = new ConcurrentHashMap<>();
            this.f273439g = false;
            this.f273439g = true;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("basetimer");
            baseHandlerThread.start();
            this.f273435c = new Handler(baseHandlerThread.getLooper());
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors > 0) {
                this.f273433a = availableProcessors;
            }
            Log.v("threadimpl_log", "thread pool size " + this.f273433a);
            int i3 = this.f273433a;
            this.f273436d = new BaseThreadPoolExecutor(i3, i3, 10L, TimeUnit.SECONDS, new PriorityBlockingQueue(30));
            g();
            Log.v("threadimpl_log", "thread create ok");
        }

        private void g() {
            this.f273435c.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.utils.ThreadCenter.ThreadImpl.2
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
                    Iterator it = ThreadImpl.this.f273438f.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (((b) entry.getValue()).a()) {
                            ((b) entry.getValue()).d();
                            it.remove();
                            Log.e("threadimpl_log", "remove handler thread: " + ((String) entry.getKey()));
                        }
                    }
                    ThreadImpl.this.f273435c.postDelayed(this, MiniBoxNoticeInfo.MIN_5);
                }
            }, MiniBoxNoticeInfo.MIN_5);
        }

        void e(Runnable runnable, long j3, boolean z16, String str) {
            b bVar;
            if (runnable == null) {
                return;
            }
            if (str == null) {
                int i3 = 10;
                if (j3 > 0) {
                    Runnable runnable2 = new Runnable(runnable, new TaskProxy(10, runnable)) { // from class: com.tencent.mobileqq.qqlive.utils.ThreadCenter.ThreadImpl.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Runnable f273440d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TaskProxy f273441e;

                        {
                            this.f273440d = runnable;
                            this.f273441e = r9;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, ThreadImpl.this, runnable, r9);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                ThreadImpl.this.f273437e.remove(this.f273440d);
                                ThreadImpl.this.f273436d.execute(this.f273441e);
                            }
                        }
                    };
                    this.f273437e.put(runnable, runnable2);
                    this.f273435c.postDelayed(runnable2, j3);
                    return;
                } else {
                    ThreadPoolExecutor threadPoolExecutor = this.f273436d;
                    if (z16) {
                        i3 = 0;
                    }
                    threadPoolExecutor.execute(new TaskProxy(i3, runnable));
                    return;
                }
            }
            if (this.f273438f.containsKey(str)) {
                bVar = this.f273438f.get(str);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.f273438f.put(str, bVar);
                Log.v("threadimpl_log", "create new thread: " + str);
            }
            if (j3 > 0) {
                bVar.c(runnable, j3);
            } else {
                bVar.b(runnable, z16);
            }
        }

        void f(Runnable runnable, String str) {
            if (runnable == null) {
                return;
            }
            if (str == null) {
                for (Object obj : this.f273437e.keySet()) {
                    if (obj == runnable) {
                        this.f273435c.removeCallbacks(this.f273437e.get(obj));
                        this.f273437e.remove(obj);
                        Log.w("threadimpl_log", "remove delay task in thread pool ok!");
                        return;
                    }
                }
                for (Runnable runnable2 : this.f273436d.getQueue()) {
                    if (((TaskProxy) runnable2).f273431e == runnable) {
                        this.f273436d.getQueue().remove(runnable2);
                        Log.w("threadimpl_log", "remove task in thread pool ok!");
                        return;
                    }
                }
                Log.e("threadimpl_log", "remove task in thread pool fail, no such task");
                return;
            }
            b bVar = this.f273438f.get(str);
            if (bVar != null) {
                bVar.e(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
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
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f273442a;

        /* renamed from: b, reason: collision with root package name */
        Handler f273443b;

        /* renamed from: c, reason: collision with root package name */
        HandlerThread f273444c;

        /* renamed from: d, reason: collision with root package name */
        boolean f273445d;

        b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f273442a = 0L;
            this.f273445d = true;
            if (!TextUtils.isEmpty(str)) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
                this.f273444c = baseHandlerThread;
                baseHandlerThread.start();
                this.f273443b = new Handler(this.f273444c.getLooper());
                return;
            }
            throw new RuntimeException("Handle ID empty!");
        }

        boolean a() {
            if (this.f273445d && System.currentTimeMillis() - this.f273442a > MiniBoxNoticeInfo.MIN_5) {
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
            this.f273442a = System.currentTimeMillis();
            if (z16) {
                this.f273443b.postAtFrontOfQueue(runnable);
            } else {
                this.f273443b.post(runnable);
            }
        }

        public void c(Runnable runnable, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, runnable, Long.valueOf(j3));
            } else {
                this.f273442a = System.currentTimeMillis() + j3;
                this.f273443b.postDelayed(runnable, j3);
            }
        }

        void d() {
            if (this.f273444c.isAlive()) {
                this.f273444c.quit();
            }
        }

        public void e(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            } else {
                this.f273443b.removeCallbacks(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f273427a = new ThreadImpl();
        f273428b = false;
        f273429c = new a();
    }

    public static void a(Runnable runnable, int i3) {
        f273427a.e(runnable, i3, false, null);
    }

    public static void b(Runnable runnable) {
        f273427a.f(runnable, null);
    }
}
