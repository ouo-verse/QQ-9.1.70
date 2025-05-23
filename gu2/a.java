package gu2;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.Foreground;
import mqq.app.QActivityLifecycleCallbacks;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends hv2.b {
    public a() {
        Foreground.addActivityLifeCallback(new C10396a(this));
    }

    @Override // hv2.b
    public Activity a() {
        return ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getTopActivity();
    }

    /* compiled from: P */
    /* renamed from: gu2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C10396a implements QActivityLifecycleCallbacks {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<a> f403358d;

        public C10396a(a aVar) {
            this.f403358d = new WeakReference<>(aVar);
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            a aVar = this.f403358d.get();
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            a aVar = this.f403358d.get();
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
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
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
