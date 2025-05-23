package com.tencent.upgrade.monitor;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upgrade.util.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ActivityLifeCycleMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f383876a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f383877b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f383878c;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class LifecycleChecker implements LifecycleObserver {
        static IPatchRedirector $redirector_;

        LifecycleChecker() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivityLifeCycleMonitor.this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        void onAppBackground() {
            d.a("ActLifeCycleMonitor", "onAppBackground");
            ActivityLifeCycleMonitor.this.f383877b = true;
            ActivityLifeCycleMonitor.this.f();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        void onAppForeground() {
            d.a("ActLifeCycleMonitor", "onAppForeground");
            ActivityLifeCycleMonitor.this.f383877b = false;
            ActivityLifeCycleMonitor.this.e();
        }

        /* synthetic */ LifecycleChecker(ActivityLifeCycleMonitor activityLifeCycleMonitor, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activityLifeCycleMonitor, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final ActivityLifeCycleMonitor f383880a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10185);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f383880a = new ActivityLifeCycleMonitor(null);
            }
        }
    }

    /* synthetic */ ActivityLifeCycleMonitor(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
    }

    public static ActivityLifeCycleMonitor d() {
        return b.f383880a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        d.a("ActLifeCycleMonitor", "notifyAppEnter");
        Iterator<a> it = this.f383878c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        d.a("ActLifeCycleMonitor", "notifyAppLeave");
        Iterator<a> it = this.f383878c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @TargetApi(14)
    public synchronized void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.f383876a) {
                return;
            }
            this.f383876a = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.upgrade.monitor.ActivityLifeCycleMonitor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ActivityLifeCycleMonitor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleChecker(ActivityLifeCycleMonitor.this, null));
                    } catch (Exception e16) {
                        d.d("ActLifeCycleMonitor", "registerActivityLifecycleListener error", e16);
                    }
                }
            });
            d.a("ActLifeCycleMonitor", "registerActivityLifecycleListener");
        }
    }

    ActivityLifeCycleMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f383878c = new CopyOnWriteArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
