package gd2;

import androidx.fragment.app.Fragment;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.rmonitor.RMonitor;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakInspector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lgd2/g;", "", "", "a", "leakObj", "b", "Lgd2/e;", "Lgd2/e;", "listener", "gd2/g$a", "c", "Lgd2/g$a;", "sceneCallback", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f401968a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e listener = new e();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a sceneCallback = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"gd2/g$a", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "Landroidx/fragment/app/Fragment;", "fragment", "", "onQFragmentDestroy", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends com.tencent.mobileqq.perf.tracker.callback.a {
        a() {
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a
        public void onQFragmentDestroy(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            if (RMonitor.isInitOk() && PluginController.f365404b.f(BuglyMonitorName.MEMORY_JAVA_LEAK)) {
                g.f401968a.b(fragment);
            }
        }
    }

    g() {
    }

    public final void a() {
        SceneTracker.f258213d.l(sceneCallback);
    }

    public final void b(@NotNull Object leakObj) {
        Intrinsics.checkNotNullParameter(leakObj, "leakObj");
        if (RMonitor.isInitOk()) {
            MemoryLeakInspector.l(leakObj, listener);
        }
    }
}
