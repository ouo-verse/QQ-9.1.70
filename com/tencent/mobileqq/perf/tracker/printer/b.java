package com.tencent.mobileqq.perf.tracker.printer;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0007*\u0001\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/printer/b;", "", "", "a", "com/tencent/mobileqq/perf/tracker/printer/b$a", "b", "Lcom/tencent/mobileqq/perf/tracker/printer/b$a;", "sceneChangedCallback", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f258267a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a sceneChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/perf/tracker/printer/b$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "stage", "", "delay", "", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityResumed", "onActivityPaused", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "Landroidx/fragment/app/Fragment;", "fragment", "onQFragmentResumed", "onQFragmentPaused", "onQFragmentDestroy", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            com.tencent.mobileqq.perf.log.a.c("SM", "onActivityDestroyed, scene is " + activity.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            com.tencent.mobileqq.perf.log.a.c("SM", "onActivityPaused, scene is " + activity.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            com.tencent.mobileqq.perf.log.a.c("SM", "onActivityResumed, scene is " + activity.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                com.tencent.mobileqq.perf.log.a.c("SM", "onProcessBackground");
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                com.tencent.mobileqq.perf.log.a.c("SM", "onProcessForeground");
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentDestroy(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            com.tencent.mobileqq.perf.log.a.c("SM", "onQFragmentDestroy, scene is " + fragment.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentPaused(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            com.tencent.mobileqq.perf.log.a.c("SM", "onQFragmentPaused, scene is " + fragment.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentResumed(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            com.tencent.mobileqq.perf.log.a.c("SM", "onQFragmentResumed, scene is " + fragment.getClass().getName());
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceEnd(@NotNull String stage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) stage);
                return;
            }
            Intrinsics.checkNotNullParameter(stage, "stage");
            com.tencent.mobileqq.perf.log.a.c("SM", "traceEnd, scene is " + stage);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, stage, Boolean.valueOf(delay));
                return;
            }
            Intrinsics.checkNotNullParameter(stage, "stage");
            com.tencent.mobileqq.perf.log.a.c("SM", "traceStart, scene is " + stage);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f258267a = new b();
            sceneChangedCallback = new a();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            SceneTracker.f258213d.l(sceneChangedCallback);
        }
    }
}
