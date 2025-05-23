package bd2;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0006*\u0001\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lbd2/b;", "", "", "c", "", "scene", "a", "b", "Ljava/lang/String;", "lastScene", "bd2/b$a", "Lbd2/b$a;", "sceneChangedCallback", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f28286a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastScene = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a sceneChangedCallback = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"bd2/b$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "stage", "", "delay", "", "traceStart", "traceEnd", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onActivityResumed", "onActivityPaused", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "onFragmentResumed", "onFragmentPaused", "fragment", "onQFragmentResumed", "onQFragmentPaused", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        a() {
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b bVar = b.f28286a;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            bVar.b(name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            b bVar = b.f28286a;
            String name = activity.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
            bVar.a(name);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentPaused(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            b bVar = b.f28286a;
            String name = f16.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "f.javaClass.name");
            bVar.b(name);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            b bVar = b.f28286a;
            String name = f16.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "f.javaClass.name");
            bVar.a(name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentPaused(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            b bVar = b.f28286a;
            String name = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "fragment.javaClass.name");
            bVar.b(name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentResumed(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            b bVar = b.f28286a;
            String name = fragment.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "fragment.javaClass.name");
            bVar.a(name);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceEnd(@NotNull String stage) {
            Intrinsics.checkNotNullParameter(stage, "stage");
            b.f28286a.b(stage);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void traceStart(@NotNull String stage, boolean delay) {
            Intrinsics.checkNotNullParameter(stage, "stage");
            b.f28286a.a(stage);
        }
    }

    b() {
    }

    public final void a(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!Intrinsics.areEqual(lastScene, scene)) {
            b(lastScene);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQRMonitorDropFrameWrapper", 4, "beginScene by " + scene + ", lastScene is " + lastScene);
        }
        lastScene = scene;
        if (RMonitor.isInitOk()) {
            RMonitor.enterScene(scene);
        }
    }

    public final void b(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (QLog.isColorLevel()) {
            QLog.d("QQRMonitorDropFrameWrapper", 4, "endScene by " + scene);
        }
        if (RMonitor.isInitOk()) {
            RMonitor.exitScene(lastScene);
        }
    }

    public final void c() {
        SceneTracker.f258213d.l(sceneChangedCallback);
    }
}
