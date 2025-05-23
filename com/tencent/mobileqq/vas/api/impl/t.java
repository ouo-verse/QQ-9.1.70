package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.impl.t;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/t;", "", "Landroid/content/Context;", "context", "", "b", "Landroid/app/Application;", "application", "Lkotlin/Function0;", "", "callback", "c", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class t {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/t$a;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "", "onActivityCreated", "onActivityResumed", "onActivityPaused", "onActivitySaveInstanceState", "onActivityDestroyed", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"com/tencent/mobileqq/vas/api/impl/t$b", "Lcom/tencent/mobileqq/vas/api/impl/t$a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onActivityStarted", "onActivityStopped", "d", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getFlag", "()Ljava/util/concurrent/atomic/AtomicInteger;", "flag", "", "e", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "", "f", "Ljava/lang/String;", "getLastActivityName", "()Ljava/lang/String;", "setLastActivityName", "(Ljava/lang/String;)V", "lastActivityName", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AtomicInteger flag = new AtomicInteger(0);

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean enable = true;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String lastActivityName = "";

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Application f308630i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f308631m;

        b(Application application, Function0<Unit> function0) {
            this.f308630i = application;
            this.f308631m = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(t this$0, Application application, b this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(application, "$application");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.b(application)) {
                VasLogReporter.INSTANCE.getAppIcon().reportLow("MobileQQ foreground");
            } else {
                this$1.b();
            }
        }

        public final void b() {
            Function0<Unit> function0 = this.f308631m;
            Application application = this.f308630i;
            synchronized (t.class) {
                this.enable = false;
                function0.invoke();
                application.unregisterActivityLifecycleCallbacks(this);
                VasLogReporter.INSTANCE.getAppIcon().reportLow("callback and unregister");
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void d() {
            if (VasToggle.BUG_102399939.isEnable(true)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final t tVar = t.this;
                final Application application = this.f308630i;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.b.e(t.this, application, this);
                    }
                });
                return;
            }
            b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!this.enable) {
                return;
            }
            String thisActivityName = activity.getClass().getName();
            VasLogReporter.INSTANCE.getAppIcon().reportLow("onActivityStarted " + thisActivityName);
            this.flag.incrementAndGet();
            Intrinsics.checkNotNullExpressionValue(thisActivityName, "thisActivityName");
            this.lastActivityName = thisActivityName;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!this.enable) {
                return;
            }
            String name = activity.getClass().getName();
            VasLogReporter.INSTANCE.getAppIcon().reportLow("onActivityStopped " + name);
            this.flag.decrementAndGet();
            if (this.flag.get() < 0) {
                d();
            } else if (this.flag.get() == 0 && Intrinsics.areEqual(name, this.lastActivityName)) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(Context context) {
        List<ActivityManager.RunningTaskInfo> list;
        ComponentName componentName;
        boolean z16;
        ComponentName componentName2;
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        try {
            list = activityManager.getRunningTasks(1);
        } catch (SecurityException unused) {
            list = null;
        }
        if (list != null && list.size() >= 1) {
            try {
                componentName2 = list.get(0).topActivity;
                Intrinsics.checkNotNull(componentName2);
                if (!Intrinsics.areEqual(componentName2.getPackageName(), MobileQQ.PACKAGE_NAME)) {
                    VasLogReporter.INSTANCE.getAppIcon().reportLow("not " + MobileQQ.PACKAGE_NAME);
                    return false;
                }
            } catch (Exception e16) {
                VasLogReporter.INSTANCE.getAppIcon().reportLow(String.valueOf(e16.getMessage()));
            }
            if (Build.VERSION.SDK_INT >= 29) {
                z16 = list.get(0).isRunning;
                if (!z16) {
                    VasLogReporter.INSTANCE.getAppIcon().reportLow("not running");
                    return false;
                }
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Intrinsics.areEqual(runningAppProcessInfo.processName, MobileQQ.PACKAGE_NAME) && runningAppProcessInfo.importance != 100) {
                        VasLogReporter.INSTANCE.getAppIcon().reportLow("not foreground importance[" + runningAppProcessInfo.importance + "]");
                        return false;
                    }
                }
            }
            VasLogReportProxy appIcon = VasLogReporter.INSTANCE.getAppIcon();
            componentName = list.get(0).topActivity;
            Intrinsics.checkNotNull(componentName);
            String className = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "runningTaskInfos[0].topActivity!!.className");
            appIcon.reportLow(className);
            return true;
        }
        return false;
    }

    public final void c(@NotNull Application application, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(callback, "callback");
        application.registerActivityLifecycleCallbacks(new b(application, callback));
    }
}
