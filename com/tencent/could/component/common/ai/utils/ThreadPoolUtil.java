package com.tencent.could.component.common.ai.utils;

import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ThreadPoolUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f100020a;

    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final ThreadPoolUtil f100021a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14467);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100021a = new ThreadPoolUtil();
            }
        }
    }

    public ThreadPoolUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    public static ThreadPoolUtil getInstance() {
        return a.f100021a;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f100020a = new BaseThreadPoolExecutor(8, 64, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

    public void addWork(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else if (!this.f100020a.isShutdown()) {
            this.f100020a.execute(runnable);
        } else {
            Log.e("ThreadPoolUtil", "Thread Pool is ready shutdown!");
        }
    }

    public void showDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.f100020a.isShutdown()) {
                return;
            }
            this.f100020a.shutdown();
        }
    }

    public void waitThreadTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                Log.e("ThreadPoolUtil", "Want wait thread in main thread!");
                return;
            }
            try {
                LockMethodProxy.sleep(500L);
            } catch (InterruptedException unused) {
                Log.e("ThreadPoolUtil", "InterruptedException in sleep thread!");
            }
        }
    }
}
