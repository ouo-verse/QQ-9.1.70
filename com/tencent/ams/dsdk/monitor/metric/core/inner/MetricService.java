package com.tencent.ams.dsdk.monitor.metric.core.inner;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.monitor.metric.e;
import com.tencent.ams.monitor.metric.i;
import com.tencent.ams.monitor.metric.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MetricService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MetricService";
    private static volatile MetricService sInstance;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    private k mService;

    MetricService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MetricServiceConfig metricServiceConfig = new MetricServiceConfig();
        DLog.i(TAG, "[constructor] config = " + metricServiceConfig);
        try {
            k a16 = e.a(metricServiceConfig);
            this.mService = a16;
            if (a16 == null) {
                DLog.e(TAG, "[constructor] error, service is null");
                return;
            }
            Context applicationContext = DKEngine.getApplicationContext();
            this.mService.setReportEnabled(new WeakReference<>(applicationContext), true);
            if (applicationContext instanceof Application) {
                addLifeCycleCallback((Application) applicationContext);
            } else {
                DLog.e(TAG, "[constructor] context is not Application");
            }
        } catch (Throwable unused) {
            DLog.e(TAG, "[constructor] error in build service");
        }
    }

    private void addLifeCycleCallback(Application application) {
        if (!DKConfiguration.getMetricReportConfig().enableMetricReportFlush) {
            DLog.i(TAG, "[addLifeCycleCallback] disable flush in activityLifecycleCallback");
        } else {
            if (this.mActivityLifecycleCallbacks != null) {
                DLog.e(TAG, "[addLifeCycleCallback] has added ActivityLifecycleCallbacks");
                return;
            }
            AppLifecycleCallback appLifecycleCallback = new AppLifecycleCallback(this, null);
            this.mActivityLifecycleCallbacks = appLifecycleCallback;
            application.registerActivityLifecycleCallbacks(appLifecycleCallback);
        }
    }

    public static MetricService getInstance() {
        if (sInstance == null) {
            synchronized (MetricService.class) {
                if (sInstance == null) {
                    sInstance = new MetricService();
                }
            }
        }
        return sInstance;
    }

    private void removeAppLifecycleCallbacks(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.mActivityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.mActivityLifecycleCallbacks = null;
        }
    }

    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mService == null) {
            DLog.e(TAG, "[flush] error, mService is null");
        } else {
            this.mService.flush(new WeakReference<>(DKEngine.getApplicationContext()));
        }
    }

    public void handle(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
        } else {
            if (iVar == null) {
                DLog.e(TAG, "[handle] metric is null");
                return;
            }
            CopyOnWriteArrayList<i> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(iVar);
            handle(copyOnWriteArrayList);
        }
    }

    public void shutDownSafely() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mService == null) {
            DLog.e(TAG, "[shutDownSafely] error, mService is null");
            return;
        }
        Context applicationContext = DKEngine.getApplicationContext();
        this.mService.a(new WeakReference<>(applicationContext));
        if (applicationContext instanceof Application) {
            removeAppLifecycleCallbacks((Application) applicationContext);
        } else {
            DLog.e(TAG, "[shutDownSafely] context is not Application");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class AppLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;
        private int mActivityCount;

        AppLifecycleCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mActivityCount = 0;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MetricService.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            int i3 = this.mActivityCount + 1;
            this.mActivityCount = i3;
            if (i3 == 0) {
                DLog.i(MetricService.TAG, "[AppLifecycleCallback] onActivityCreated flush");
                MetricService.this.flush();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                return;
            }
            int i3 = this.mActivityCount - 1;
            this.mActivityCount = i3;
            if (i3 == 0) {
                DLog.i(MetricService.TAG, "[AppLifecycleCallback] onActivityDestroyed flush");
                MetricService.this.flush();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
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
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            }
        }

        /* synthetic */ AppLifecycleCallback(MetricService metricService, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) metricService, (Object) anonymousClass1);
        }
    }

    private void handle(CopyOnWriteArrayList<i> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Context applicationContext = DKEngine.getApplicationContext();
            k kVar = this.mService;
            if (kVar == null) {
                DLog.e(TAG, "[handle] error, mService is null");
                return;
            } else {
                kVar.handle(new WeakReference<>(applicationContext), copyOnWriteArrayList);
                return;
            }
        }
        DLog.e(TAG, "[handle] metrics is null or empty");
    }
}
