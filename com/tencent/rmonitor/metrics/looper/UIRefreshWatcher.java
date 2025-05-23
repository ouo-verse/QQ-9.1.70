package com.tencent.rmonitor.metrics.looper;

import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.view.ViewTreeObserver;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@RequiresApi(api = 16)
/* loaded from: classes25.dex */
public final class UIRefreshWatcher extends com.tencent.rmonitor.common.lifecycle.f implements ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: f, reason: collision with root package name */
    private boolean f365766f = false;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<b> f365765e = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<Integer, WeakReference<Activity>> f365764d = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final UIRefreshWatcher f365767a = new UIRefreshWatcher();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface b {
        void a();
    }

    protected UIRefreshWatcher() {
    }

    public static UIRefreshWatcher e() {
        return a.f365767a;
    }

    protected void a(Activity activity) {
        if (activity != null && !this.f365765e.isEmpty()) {
            int hashCode = activity.hashCode();
            if (this.f365764d.get(Integer.valueOf(hashCode)) != null) {
                return;
            }
            this.f365764d.put(Integer.valueOf(hashCode), new WeakReference<>(activity));
            try {
                activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(this);
            } catch (Throwable th5) {
                Logger.f365497g.b("RMonitor_looper_UIRefreshTracer", "addOnDrawListener", th5);
            }
        }
    }

    public void f(b bVar) {
        Activity activity;
        if (bVar != null && !this.f365765e.contains(bVar)) {
            this.f365765e.add(bVar);
            WeakReference<Activity> f16 = LifecycleCallback.G.f();
            if (f16 == null) {
                activity = null;
            } else {
                activity = f16.get();
            }
            a(activity);
            if (!this.f365766f) {
                LifecycleCallback.r(this);
                this.f365766f = true;
            }
            Logger.f365497g.d("RMonitor_looper_UIRefreshTracer", "register, listener: ", bVar.toString());
        }
    }

    protected void g(Activity activity) {
        if (activity != null && !this.f365764d.isEmpty()) {
            if (this.f365764d.remove(Integer.valueOf(activity.hashCode())) == null) {
                return;
            }
            h(activity);
        }
    }

    protected void h(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_looper_UIRefreshTracer", "removeOnDrawListenerInner", th5);
        }
    }

    public void i(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f365765e.remove(bVar);
        if (this.f365765e.isEmpty()) {
            ThreadManager.runInMainThread(this, 1000L);
        }
        Logger.f365497g.d("RMonitor_looper_UIRefreshTracer", "unRegister, listener: ", bVar.toString());
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    public void onDestroy(@NotNull Activity activity) {
        g(activity);
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        try {
            Iterator<b> it = this.f365765e.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    public void onStart(@NotNull Activity activity) {
        a(activity);
    }

    @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
    public void onStop(@NotNull Activity activity) {
        g(activity);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f365765e.isEmpty()) {
            return;
        }
        if (this.f365766f) {
            LifecycleCallback.s(this);
            this.f365766f = false;
        }
        Iterator<Map.Entry<Integer, WeakReference<Activity>>> it = this.f365764d.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<Activity> value = it.next().getValue();
            if (value != null) {
                h(value.get());
            }
        }
        this.f365764d.clear();
    }
}
