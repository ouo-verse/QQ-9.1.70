package com.tencent.rmonitor.pagelaunch;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewTreeObserver;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, com.tencent.rmonitor.pagelaunch.a> f365802a;

    /* renamed from: b, reason: collision with root package name */
    private c f365803b;

    /* compiled from: P */
    /* renamed from: com.tencent.rmonitor.pagelaunch.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class ViewTreeObserverOnWindowFocusChangeListenerC9750b implements ViewTreeObserver.OnWindowFocusChangeListener {

        /* renamed from: d, reason: collision with root package name */
        private final int f365804d;

        public ViewTreeObserverOnWindowFocusChangeListenerC9750b(int i3) {
            this.f365804d = i3;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z16) {
            com.tencent.rmonitor.pagelaunch.a aVar = (com.tencent.rmonitor.pagelaunch.a) b.this.f365802a.get(Integer.valueOf(this.f365804d));
            if (z16 && aVar != null && aVar.f365798e == 0) {
                aVar.f365798e = SystemClock.uptimeMillis();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class c extends f {
        c() {
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onBackground() {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(b.this.f365802a);
            b.this.f365802a.clear();
            PageLaunchReporter.e(concurrentHashMap);
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onCreate(@NotNull Activity activity) {
            Integer valueOf = Integer.valueOf(activity.hashCode());
            if (b.this.f365802a.contains(valueOf)) {
                b.this.f365802a.remove(valueOf);
            }
            com.tencent.rmonitor.pagelaunch.a aVar = new com.tencent.rmonitor.pagelaunch.a(activity);
            aVar.f365796c = SystemClock.uptimeMillis();
            aVar.f365797d = System.currentTimeMillis();
            b.this.f365802a.put(valueOf, aVar);
            try {
                ViewTreeObserverOnWindowFocusChangeListenerC9750b viewTreeObserverOnWindowFocusChangeListenerC9750b = new ViewTreeObserverOnWindowFocusChangeListenerC9750b(valueOf.intValue());
                aVar.f365800g = viewTreeObserverOnWindowFocusChangeListenerC9750b;
                activity.getWindow().getDecorView().getViewTreeObserver().addOnWindowFocusChangeListener(viewTreeObserverOnWindowFocusChangeListenerC9750b);
            } catch (Throwable th5) {
                Logger.f365497g.b("PageLaunchMonitor", "addOnWindowFocusChangeListener", th5);
            }
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onStop(@NotNull Activity activity) {
            com.tencent.rmonitor.pagelaunch.a aVar = (com.tencent.rmonitor.pagelaunch.a) b.this.f365802a.get(Integer.valueOf(activity.hashCode()));
            if (aVar != null && aVar.f365800g != null) {
                try {
                    activity.getWindow().getDecorView().getViewTreeObserver().removeOnWindowFocusChangeListener(aVar.f365800g);
                    aVar.f365800g = null;
                } catch (Throwable th5) {
                    Logger.f365497g.b("PageLaunchMonitor", "removeOnWindowFocusChangeListener", th5);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final b f365807a = new b();
    }

    public static b b() {
        return d.f365807a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        LifecycleCallback.r(this.f365803b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        LifecycleCallback.s(this.f365803b);
    }

    b() {
        this.f365802a = new ConcurrentHashMap<>();
        this.f365803b = new c();
    }
}
