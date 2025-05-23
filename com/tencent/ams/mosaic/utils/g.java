package com.tencent.ams.mosaic.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ThreadPoolExecutor f71565a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59204);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f71565a = new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 2L, TimeUnit.SECONDS, new SynchronousQueue(), new c("MosaicImmediateThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final g f71566a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59208);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f71566a = new g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class c implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        private static final AtomicInteger f71567h;

        /* renamed from: d, reason: collision with root package name */
        private final ThreadGroup f71568d;

        /* renamed from: e, reason: collision with root package name */
        private final AtomicInteger f71569e;

        /* renamed from: f, reason: collision with root package name */
        private final String f71570f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59210);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f71567h = new AtomicInteger(1);
            }
        }

        public c(String str) {
            ThreadGroup threadGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f71569e = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f71568d = threadGroup;
            this.f71570f = (TextUtils.isEmpty(str) ? "MosaicPool" : str) + "-" + f71567h.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(this.f71568d, runnable, this.f71570f + this.f71569e.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 5) {
                baseThread.setPriority(5);
            }
            return baseThread;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ScheduledThreadPoolExecutor f71571a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59214);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            BaseScheduledThreadPoolExecutor baseScheduledThreadPoolExecutor = new BaseScheduledThreadPoolExecutor(10, new c("MosaicScheduledThreadPool"), new ThreadPoolExecutor.DiscardOldestPolicy());
            f71571a = baseScheduledThreadPoolExecutor;
            baseScheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
            baseScheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final g b() {
        return b.f71566a;
    }

    public ExecutorService a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return a.f71565a;
        }
        return (ExecutorService) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public ScheduledThreadPoolExecutor c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return d.f71571a;
        }
        return (ScheduledThreadPoolExecutor) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
