package com.tencent.mobileqq.guild.media.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* loaded from: classes14.dex */
public class FloatWindowPermissionHandler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f228792a;

    /* renamed from: b, reason: collision with root package name */
    private a f228793b;

    /* renamed from: c, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f228794c = new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(final Activity activity) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Activity g16 = FloatWindowPermissionHandler.this.g();
                    if (g16 == null || (activity != null && TextUtils.equals(g16.getClass().getName(), activity.getClass().getName()))) {
                        FloatWindowPermissionHandler.this.n();
                        if (FloatWindowPermissionHandler.this.f228793b == null) {
                            return;
                        }
                        FloatWindowPermissionHandler.this.f228793b.a(((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext()));
                        FloatWindowPermissionHandler.this.f228793b = null;
                        return;
                    }
                    QLog.i("FloatWindowPermissionHa", 1, "[run] skip by not cur act, act:" + g16 + ", activity:" + activity);
                    FloatWindowPermissionHandler.this.f228793b = null;
                }
            });
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
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
    };

    /* loaded from: classes14.dex */
    public interface a {
        void a(boolean z16);
    }

    public FloatWindowPermissionHandler(Activity activity) {
        this.f228792a = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Activity g() {
        WeakReference<Activity> weakReference = this.f228792a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void h() {
        BaseApplication.getContext().registerActivityLifecycleCallbacks(this.f228794c);
    }

    private void m(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        h();
        IQQFloatingPermission iQQFloatingPermission = (IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class);
        if (activity == null) {
            activity = QBaseActivity.sTopActivity;
        }
        iQQFloatingPermission.enterPermissionRequestDialogCustom(activity, R.string.f140040cw, R.string.f140030cv, R.string.f1493111y, R.string.f145890sp, onClickListener2, onClickListener, onDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this.f228794c);
    }

    public boolean e() {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
    }

    public void f() {
        n();
        this.f228793b = null;
    }

    public boolean i() {
        return k(null, null);
    }

    public boolean j(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
        if (!checkPermission) {
            m(g(), onClickListener, onClickListener2, onDismissListener);
        }
        return checkPermission;
    }

    public boolean k(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
        if (!checkPermission) {
            m(g(), onClickListener, null, onDismissListener);
        }
        return checkPermission;
    }

    public void l(a aVar) {
        this.f228793b = aVar;
    }
}
