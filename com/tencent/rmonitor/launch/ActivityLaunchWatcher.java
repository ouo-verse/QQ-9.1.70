package com.tencent.rmonitor.launch;

import android.app.Activity;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes25.dex */
public class ActivityLaunchWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<Integer, a> f365577a = new HashMap<>(10);

    /* renamed from: b, reason: collision with root package name */
    private final OnLaunchCompleteListener f365578b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @RequiresApi(api = 18)
    /* loaded from: classes25.dex */
    public class MyListener implements ViewTreeObserver.OnWindowFocusChangeListener, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final a f365579d;

        /* renamed from: e, reason: collision with root package name */
        private long f365580e = 0;

        /* renamed from: f, reason: collision with root package name */
        private long f365581f = 0;

        public MyListener(a aVar) {
            this.f365579d = aVar;
        }

        private void a(String str) {
            if (Logger.debug) {
                Logger.f365497g.d("RMonitor_launch_ActivityLaunchWatcher", str + ", activity: " + this.f365579d.f365583b.get());
            }
        }

        private void e() {
            if (this.f365579d.f365584c) {
                long j3 = this.f365580e;
                if (j3 == 0) {
                    j3 = this.f365581f;
                }
                if (j3 == 0) {
                    j3 = SystemClock.uptimeMillis();
                }
                this.f365579d.a(j3);
                ActivityLaunchWatcher.this.f(this.f365579d);
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (this.f365579d.f365585d) {
                a("onDraw");
                this.f365579d.f365585d = false;
                this.f365581f = SystemClock.uptimeMillis();
                ThreadManager.runInMainThread(this, 1000L);
            }
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z16) {
            if (z16 && this.f365579d.f365584c) {
                a("onWindowFocusChanged");
                this.f365580e = SystemClock.uptimeMillis();
                e();
                ThreadManager.cancelFromMainThread(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a(TencentLocation.RUN_MODE);
            e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnLaunchCompleteListener {
        void onActivityLaunchComplete(a aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f365582a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<Activity> f365583b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f365584c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f365585d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f365586e = true;

        /* renamed from: f, reason: collision with root package name */
        public long f365587f = 0;

        /* renamed from: g, reason: collision with root package name */
        public long f365588g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f365589h = 0;

        /* renamed from: i, reason: collision with root package name */
        public long f365590i = 0;

        /* renamed from: j, reason: collision with root package name */
        public long f365591j = 0;

        /* renamed from: k, reason: collision with root package name */
        public MyListener f365592k = null;

        public a(Activity activity) {
            this.f365583b = new WeakReference<>(activity);
            this.f365582a = activity.getClass().getName();
        }

        public void a(long j3) {
            this.f365584c = false;
            this.f365585d = false;
            if (this.f365586e) {
                this.f365586e = false;
                long j16 = this.f365590i;
                if (j16 != 0) {
                    this.f365587f = j3 - j16;
                    return;
                }
                return;
            }
            long j17 = this.f365591j;
            if (j17 != 0) {
                this.f365589h++;
                this.f365588g += j3 - j17;
            }
        }

        public void b() {
            this.f365591j = SystemClock.uptimeMillis();
            this.f365584c = true;
            this.f365585d = true;
        }

        public String toString() {
            return "{name: " + this.f365582a + ", firstLaunchCostInMs: " + this.f365587f + ", launchCountExcludeFirstTime: " + this.f365589h + ", launchCostExcludeFirstTimeInMs: " + this.f365588g + "}";
        }
    }

    public ActivityLaunchWatcher(OnLaunchCompleteListener onLaunchCompleteListener) {
        this.f365578b = onLaunchCompleteListener;
    }

    private void d(@NotNull Activity activity, @NotNull a aVar) {
        if (aVar.f365592k == null) {
            try {
                MyListener myListener = new MyListener(aVar);
                aVar.f365592k = myListener;
                View decorView = activity.getWindow().getDecorView();
                decorView.getViewTreeObserver().addOnWindowFocusChangeListener(myListener);
                decorView.getViewTreeObserver().addOnDrawListener(myListener);
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_launch_ActivityLaunchWatcher", "addListener", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(a aVar) {
        OnLaunchCompleteListener onLaunchCompleteListener = this.f365578b;
        if (onLaunchCompleteListener != null) {
            onLaunchCompleteListener.onActivityLaunchComplete(aVar);
        }
    }

    @NotNull
    private a g(@NotNull Activity activity) {
        int hashCode = activity.hashCode();
        a aVar = this.f365577a.get(Integer.valueOf(hashCode));
        if (aVar == null) {
            a aVar2 = new a(activity);
            this.f365577a.put(Integer.valueOf(hashCode), aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(@NotNull Activity activity, @NotNull a aVar) {
        MyListener myListener = aVar.f365592k;
        if (myListener != null) {
            try {
                aVar.f365592k = null;
                View decorView = activity.getWindow().getDecorView();
                decorView.getViewTreeObserver().removeOnWindowFocusChangeListener(myListener);
                decorView.getViewTreeObserver().removeOnDrawListener(myListener);
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_launch_ActivityLaunchWatcher", "removeListener", th5);
            }
        }
    }

    public void destroy() {
        Logger.f365497g.d("RMonitor_launch_ActivityLaunchWatcher", "destroy begin");
        ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.launch.ActivityLaunchWatcher.1
            @Override // java.lang.Runnable
            public void run() {
                for (a aVar : ActivityLaunchWatcher.this.f365577a.values()) {
                    Activity activity = aVar.f365583b.get();
                    if (activity != null) {
                        ActivityLaunchWatcher.this.i(activity, aVar);
                    }
                }
                ActivityLaunchWatcher.this.f365577a.clear();
                Logger.f365497g.d("RMonitor_launch_ActivityLaunchWatcher", "destroy end");
            }
        }, 0L);
    }

    protected a e(@NotNull Activity activity) {
        return this.f365577a.get(Integer.valueOf(activity.hashCode()));
    }

    protected a h(@NotNull Activity activity) {
        return this.f365577a.remove(Integer.valueOf(activity.hashCode()));
    }

    public void onActivityCreate(@NotNull Activity activity) {
        a g16 = g(activity);
        g16.f365590i = SystemClock.uptimeMillis();
        g16.f365586e = true;
    }

    public void onActivityDestroy(@NotNull Activity activity) {
        a h16 = h(activity);
        if (h16 != null) {
            i(activity, h16);
        }
    }

    public void onActivityResume(@NotNull Activity activity) {
        a e16 = e(activity);
        if (e16 != null) {
            e16.b();
            d(activity, e16);
        }
    }
}
