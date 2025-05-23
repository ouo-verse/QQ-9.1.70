package com.tencent.mobileqq.perf.metric;

import android.app.Activity;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.bugly.common.looper.FrameManager;
import com.tencent.bugly.common.looper.IFrame;
import com.tencent.mobileqq.perf.metric.config.ScrollHitchConfig;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u001a\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR<\u0010\u0016\u001a*\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00130\u0011j\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/perf/metric/a;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, h.F, "k", "l", "i", "onScrollChanged", "", "e", "Z", "mIsEnable", "f", "mIsScrolling", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "hasAddedListenerActivities", "Lcom/tencent/mobileqq/perf/metric/ScrollHitchRateMonitor;", "Lcom/tencent/mobileqq/perf/metric/ScrollHitchRateMonitor;", "hitchRateMonitor", "com/tencent/mobileqq/perf/metric/a$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/perf/metric/a$b;", "sceneChangedCallback", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements ViewTreeObserver.OnScrollChangedListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f257803d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsEnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsScrolling;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, WeakReference<Activity>> hasAddedListenerActivities;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ScrollHitchRateMonitor hitchRateMonitor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b sceneChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/perf/metric/a$a", "Lcom/tencent/bugly/common/looper/IFrame;", "", "frameTimeNanos", "", "doFrame", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.metric.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8205a implements IFrame {
        static IPatchRedirector $redirector_;

        C8205a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.bugly.common.looper.IFrame
        public void doFrame(long frameTimeNanos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
                if (scrollHitchRateMonitor != null) {
                    scrollHitchRateMonitor.c(frameTimeNanos, a.mIsScrolling);
                }
                a.mIsScrolling = false;
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, frameTimeNanos);
        }

        @Override // com.tencent.bugly.common.looper.IFrame
        public boolean isOpen() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.mIsEnable;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/perf/metric/a$b", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessBackground", "onProcessForeground", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityStarted", "onActivityStopped", "onActivityDestroyed", "", "stage", "", "delay", "traceStart", "traceEnd", "onActivityResumed", "onActivityPaused", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "onFragmentResumed", "onFragmentPaused", "fragment", "onQFragmentResumed", "onQFragmentPaused", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        b() {
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
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                a.f257803d.k(activity);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.i(activity.getClass().getName());
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.h(activity.getClass().getName());
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                a.f257803d.h(activity);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                a.f257803d.k(activity);
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) fm5, (Object) f16);
                return;
            }
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.i(f16.getClass().getName());
            }
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) fm5, (Object) f16);
                return;
            }
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.h(f16.getClass().getName());
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.mIsEnable = false;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                a.mIsEnable = true;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentPaused(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.i(fragment.getClass().getName());
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentResumed(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) fragment);
                return;
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.h(fragment.getClass().getName());
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceEnd(@NotNull String stage) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) stage);
                return;
            }
            Intrinsics.checkNotNullParameter(stage, "stage");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.i(stage);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, stage, Boolean.valueOf(delay));
                return;
            }
            Intrinsics.checkNotNullParameter(stage, "stage");
            ScrollHitchRateMonitor scrollHitchRateMonitor = a.hitchRateMonitor;
            if (scrollHitchRateMonitor != null) {
                scrollHitchRateMonitor.h(stage);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f257803d = new a();
        hasAddedListenerActivities = new HashMap<>();
        sceneChangedCallback = new b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Activity activity) {
        int hashCode = activity.hashCode();
        HashMap<Integer, WeakReference<Activity>> hashMap = hasAddedListenerActivities;
        if (hashMap.get(Integer.valueOf(hashCode)) != null) {
            return;
        }
        hashMap.put(Integer.valueOf(hashCode), new WeakReference<>(activity));
        try {
            activity.getWindow().getDecorView().getViewTreeObserver().addOnScrollChangedListener(this);
        } catch (Throwable th5) {
            QLog.e("ScrollHitchRate", 1, "addOnScrollListener", th5);
        }
    }

    private final void j() {
        FrameManager.INSTANCE.register(new C8205a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity) {
        HashMap<Integer, WeakReference<Activity>> hashMap = hasAddedListenerActivities;
        if (hashMap.isEmpty() || hashMap.remove(Integer.valueOf(activity.hashCode())) == null) {
            return;
        }
        l(activity);
    }

    private final void l(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().getViewTreeObserver().removeOnScrollChangedListener(this);
        } catch (Throwable th5) {
            QLog.e("ScrollHitchRate", 1, "removeOnScrollListenerInner", th5);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        if (AppSetting.isPublicVersion() && !ScrollHitchConfig.INSTANCE.a().a()) {
            return;
        }
        hitchRateMonitor = new ScrollHitchRateMonitor();
        mIsEnable = Foreground.isCurrentProcessForeground();
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            f257803d.h(topActivity);
        } else {
            topActivity = null;
        }
        QLog.d("ScrollHitchRate", 1, "init isEnable:" + mIsEnable + ", top:" + topActivity);
        SceneTracker.f258213d.l(sceneChangedCallback);
        j();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        mIsScrolling = true;
        ScrollHitchRateMonitor scrollHitchRateMonitor = hitchRateMonitor;
        if (scrollHitchRateMonitor != null) {
            scrollHitchRateMonitor.f();
        }
    }
}
