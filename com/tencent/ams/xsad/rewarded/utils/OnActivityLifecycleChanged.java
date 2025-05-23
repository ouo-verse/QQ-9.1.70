package com.tencent.ams.xsad.rewarded.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OnActivityLifecycleChanged {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<c, OnActivityLifecycleChanged> f71853e;

    /* renamed from: a, reason: collision with root package name */
    private Application f71854a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f71855b;

    /* renamed from: c, reason: collision with root package name */
    private c f71856c;

    /* renamed from: d, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f71857d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ActivityLifecycle {
        public static final int CREATED = 1;
        public static final int DESTROYED = 6;
        public static final int PAUSED = 3;
        public static final int RESUMED = 4;
        public static final int STARTED = 2;
        public static final int STOPPED = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) OnActivityLifecycleChanged.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                OnActivityLifecycleChanged.this.b(activity, 1);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                OnActivityLifecycleChanged.this.b(activity, 6);
            } else {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                OnActivityLifecycleChanged.this.b(activity, 3);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                OnActivityLifecycleChanged.this.b(activity, 4);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                OnActivityLifecycleChanged.this.b(activity, 2);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                OnActivityLifecycleChanged.this.b(activity, 5);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }

        /* synthetic */ b(OnActivityLifecycleChanged onActivityLifecycleChanged, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onActivityLifecycleChanged, (Object) aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void b(@ActivityLifecycle int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71853e = new ConcurrentHashMap<>();
        }
    }

    OnActivityLifecycleChanged(Activity activity, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) cVar);
        } else {
            this.f71856c = cVar;
            d(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, @ActivityLifecycle int i3) {
        Activity activity2;
        WeakReference<Activity> weakReference = this.f71855b;
        if (weakReference == null) {
            activity2 = null;
        } else {
            activity2 = weakReference.get();
        }
        if (activity == activity2) {
            com.tencent.ams.xsad.rewarded.utils.c.c("OnActivityLifecycleChangedObserver", "notifyActivityLifecycleChanged, activity: " + activity + ", state: " + i3);
            c cVar = this.f71856c;
            if (cVar != null) {
                cVar.b(i3);
            }
            if (i3 == 6) {
                f();
            }
        }
    }

    public static synchronized boolean c(Context context, c cVar) {
        synchronized (OnActivityLifecycleChanged.class) {
            com.tencent.ams.xsad.rewarded.utils.c.c("OnActivityLifecycleChangedObserver", "register, context: " + context + ", listener: " + cVar);
            Activity c16 = g.c(context);
            if (c16 != null && cVar != null) {
                ConcurrentHashMap<c, OnActivityLifecycleChanged> concurrentHashMap = f71853e;
                if (concurrentHashMap.contains(cVar)) {
                    com.tencent.ams.xsad.rewarded.utils.c.e("OnActivityLifecycleChangedObserver", cVar + " has registered.");
                    return false;
                }
                concurrentHashMap.put(cVar, new OnActivityLifecycleChanged(c16, cVar));
                return true;
            }
            com.tencent.ams.xsad.rewarded.utils.c.e("OnActivityLifecycleChangedObserver", "activity or listener is null.");
            return false;
        }
    }

    private boolean d(Activity activity) {
        if (activity == null) {
            return false;
        }
        this.f71855b = new WeakReference<>(activity);
        Application application = activity.getApplication();
        if (application == null) {
            return false;
        }
        this.f71854a = application;
        b bVar = new b(this, null);
        this.f71857d = bVar;
        this.f71854a.registerActivityLifecycleCallbacks(bVar);
        return true;
    }

    public static synchronized boolean e(c cVar) {
        OnActivityLifecycleChanged remove;
        synchronized (OnActivityLifecycleChanged.class) {
            com.tencent.ams.xsad.rewarded.utils.c.c("OnActivityLifecycleChangedObserver", "unRegister, listener: " + cVar);
            if (cVar != null && (remove = f71853e.remove(cVar)) != null) {
                remove.f();
                return true;
            }
            return false;
        }
    }

    private synchronized void f() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        com.tencent.ams.xsad.rewarded.utils.c.c("OnActivityLifecycleChangedObserver", "unRegisterLifecycleListener, listener: " + this.f71856c);
        Application application = this.f71854a;
        if (application != null && (activityLifecycleCallbacks = this.f71857d) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        c cVar = this.f71856c;
        if (cVar != null) {
            f71853e.remove(cVar);
        }
        this.f71855b = null;
        this.f71857d = null;
        this.f71856c = null;
    }
}
