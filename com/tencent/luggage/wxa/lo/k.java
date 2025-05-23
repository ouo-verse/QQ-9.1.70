package com.tencent.luggage.wxa.lo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import androidx.arch.core.util.Function;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f133734c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f133735d = false;

    /* renamed from: e, reason: collision with root package name */
    public static final WeakHashMap f133736e = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    public WindowInsets f133737a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f133738b = new HashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Function {
        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(Activity activity) {
            if (k.f133735d) {
                k.b(activity);
                return null;
            }
            return null;
        }
    }

    public k(Activity activity) {
        activity.runOnUiThread(new c(activity));
    }

    public final WindowInsets c() {
        WindowInsets windowInsets;
        synchronized (this) {
            windowInsets = this.f133737a;
        }
        return windowInsets;
    }

    public static k b(Activity activity) {
        return a(activity, true);
    }

    public void b(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (onApplyWindowInsetsListener == null) {
            return;
        }
        synchronized (this.f133738b) {
            this.f133738b.remove(onApplyWindowInsetsListener);
        }
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new b(new a()));
        f133734c.set(true);
    }

    public static WindowInsets a(Activity activity) {
        if (f133735d) {
            k a16 = a(activity, false);
            if (a16 == null) {
                return null;
            }
            return a16.c();
        }
        return activity.getWindow().getDecorView().getRootWindowInsets();
    }

    public static k a(Activity activity, boolean z16) {
        k kVar;
        WeakHashMap weakHashMap = f133736e;
        synchronized (weakHashMap) {
            kVar = (k) weakHashMap.get(activity);
            if (kVar == null && z16) {
                kVar = new k(activity);
                weakHashMap.put(activity, kVar);
                if (!f133734c.get() && activity.getApplication() != null) {
                    a(activity.getApplication());
                }
            }
        }
        return kVar;
    }

    public void a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (onApplyWindowInsetsListener == null) {
            return;
        }
        synchronized (this.f133738b) {
            this.f133738b.add(onApplyWindowInsetsListener);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f133740a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements View.OnApplyWindowInsetsListener {
            public a() {
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                LinkedList linkedList;
                synchronized (k.this) {
                    k.this.f133737a = new WindowInsets(windowInsets);
                }
                synchronized (k.this.f133738b) {
                    linkedList = new LinkedList(k.this.f133738b);
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((View.OnApplyWindowInsetsListener) it.next()).onApplyWindowInsets(view, windowInsets);
                }
                return view.onApplyWindowInsets(windowInsets);
            }
        }

        public c(Activity activity) {
            this.f133740a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            View decorView = this.f133740a.getWindow().getDecorView();
            if (decorView == null) {
                return;
            }
            decorView.setOnApplyWindowInsetsListener(new a());
            Activity activity = this.f133740a;
            Application application = activity.getApplication();
            if (application == null) {
                return;
            }
            application.registerActivityLifecycleCallbacks(new b(activity, decorView, application));
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Application.ActivityLifecycleCallbacks {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Activity f133743a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f133744b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Application f133745c;

            public b(Activity activity, View view, Application application) {
                this.f133743a = activity;
                this.f133744b = view;
                this.f133745c = application;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (this.f133743a == activity) {
                    this.f133744b.setOnApplyWindowInsetsListener(null);
                    this.f133745c.unregisterActivityLifecycleCallbacks(this);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f133739a;

        public b(Function function) {
            this.f133739a = function;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f133739a.apply(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            k kVar;
            synchronized (k.f133736e) {
                kVar = (k) k.f133736e.remove(activity);
            }
            if (kVar != null) {
                synchronized (kVar.f133738b) {
                    kVar.f133738b.clear();
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.f133739a.apply(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
