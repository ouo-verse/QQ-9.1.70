package com.qq.e.comm.plugin.g.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.monitor.metric.i;
import com.tencent.ams.monitor.metric.k;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f39390a;

    /* renamed from: b, reason: collision with root package name */
    private k f39391b;

    /* renamed from: c, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f39392c;

    d() {
        e eVar = new e();
        GDTLogger.i("[MetricReporter][MetricService][constructor] config = " + eVar);
        try {
            k a16 = com.tencent.ams.monitor.metric.e.a(eVar);
            this.f39391b = a16;
            if (a16 == null) {
                GDTLogger.e("[MetricReporter][MetricService][constructor] error, service is null");
                return;
            }
            Context appContext = GDTADManager.getInstance().getAppContext();
            if (appContext == null) {
                GDTLogger.e("[MetricReporter][MetricService][constructor] context is null");
                return;
            }
            if (appContext instanceof Application) {
                a((Application) appContext);
            } else {
                GDTLogger.e("[MetricReporter][MetricService][constructor] context is not Application");
            }
            this.f39391b.setReportEnabled(new WeakReference<>(appContext), true);
        } catch (Throwable unused) {
            GDTLogger.e("[MetricReporter][MetricService][constructor] error in build service");
        }
    }

    private void a(Application application) {
        if (this.f39392c != null) {
            GDTLogger.e("[MetricReporter][MetricService][addLifeCycleCallback] has added ActivityLifecycleCallbacks");
            return;
        }
        a aVar = new a();
        this.f39392c = aVar;
        application.registerActivityLifecycleCallbacks(aVar);
    }

    public void b() {
        if (this.f39391b == null) {
            GDTLogger.e("[MetricReporter][MetricService][flush] error, mService is null");
            return;
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            GDTLogger.e("[MetricReporter][MetricService][flush] context is null");
        } else {
            this.f39391b.flush(new WeakReference<>(appContext));
        }
    }

    public static d a() {
        if (f39390a == null) {
            synchronized (d.class) {
                if (f39390a == null) {
                    f39390a = new d();
                }
            }
        }
        return f39390a;
    }

    public void a(i iVar) {
        if (iVar == null) {
            GDTLogger.e("[MetricReporter][MetricService][handle] metric is null");
            return;
        }
        CopyOnWriteArrayList<i> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(iVar);
        a(copyOnWriteArrayList);
    }

    private void a(CopyOnWriteArrayList<i> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            GDTLogger.e("[MetricReporter][MetricService][handle] metrics is null");
            return;
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            GDTLogger.e("[MetricReporter][MetricService][handle] context is null");
            return;
        }
        k kVar = this.f39391b;
        if (kVar == null) {
            GDTLogger.e("[MetricReporter][MetricService][handle] error, mService is null");
        } else {
            kVar.handle(new WeakReference<>(appContext), copyOnWriteArrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b, reason: collision with root package name */
        private int f39394b;

        a() {
            this.f39394b = 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            int i3 = this.f39394b + 1;
            this.f39394b = i3;
            if (i3 == 0) {
                GDTLogger.i("[MetricReporter][MetricService][AppLifecycleCallback] flush");
                d.this.b();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            int i3 = this.f39394b - 1;
            this.f39394b = i3;
            if (i3 == 0) {
                GDTLogger.i("[MetricReporter][MetricService][AppLifecycleCallback] flush");
                d.this.b();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
