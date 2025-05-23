package kd2;

import android.app.Activity;
import android.os.Build;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.perf.tool.AppInfoUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.RMonitor;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue;
import com.tencent.rmonitor.custom.ICustomDataEditorForIssue;
import com.tencent.rmonitor.metrics.looper.UIRefreshWatcher;
import com.tencent.util.AppSetting;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004\u00a8\u0006\u0016"}, d2 = {"Lkd2/d;", "", "", "b", "", "e", "g", "", "pluginName", "d", "c", "i", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "l", "o", "j", h.F, "k", DomainData.DOMAIN_NAME, "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f412061a = new d();

    d() {
    }

    @JvmStatic
    public static final int b() {
        long j3 = com.tencent.mobileqq.startup.a.f289673n;
        if (j3 <= 0) {
            return 0;
        }
        if (j3 <= 300) {
            return 1;
        }
        if (j3 <= 1000) {
            return 2;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, String str2, ICustomDataEditorForIssue iCustomDataEditorForIssue) {
        iCustomDataEditorForIssue.putUserData("BranchName", AppSetting.getBranchName());
        iCustomDataEditorForIssue.putUserData("JavaHeap", String.valueOf(com.tencent.cache.api.memory.a.f98606b.a().e()));
        com.tencent.mobileqq.perf.terrible.b bVar = com.tencent.mobileqq.perf.terrible.b.f258047a;
        iCustomDataEditorForIssue.putUserData("LastOneSecondGcCount", String.valueOf(bVar.x()));
        iCustomDataEditorForIssue.putUserData("LastOneSecondLogCount", String.valueOf(bVar.y()));
        iCustomDataEditorForIssue.putUserData("isDebugApk", String.valueOf(AppInfoUtil.f258158a.a()));
        iCustomDataEditorForIssue.putUserData("dex2oatStatus", String.valueOf(b()));
    }

    public static /* synthetic */ void m(d dVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        dVar.l(z16);
    }

    public final void c(@NotNull String pluginName) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        RMonitor.pauseMonitor(pluginName);
    }

    public final void d(@NotNull String pluginName) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        RMonitor.resumeMonitor(pluginName);
    }

    public final void e() {
        QLog.d("QQRMonitorUtils", 1, "setRMonitorProperty start");
        e.h(false);
        RMonitor.setForkDumpModeOnly(true);
        RMonitor.addProperty(217, new ICustomDataCollectorForIssue() { // from class: kd2.c
            @Override // com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue
            public final void collectCustomData(String str, String str2, ICustomDataEditorForIssue iCustomDataEditorForIssue) {
                d.f(str, str2, iCustomDataEditorForIssue);
            }
        });
        QLog.d("QQRMonitorUtils", 1, "setRMonitorProperty completed");
    }

    public final void g() {
        i();
        m(this, false, 1, null);
        h();
        k();
        o();
        j();
        n();
    }

    public final void h() {
        if (MobileQQ.sProcessId == 1) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_BIG_BITMAP");
            RMonitor.startMonitor(BuglyMonitorName.MEMORY_BIG_BITMAP);
            RMonitor.addProperty(210, new ad2.a());
        }
    }

    public final void i() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            UIRefreshWatcher.e().onStart(topActivity);
        }
        QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_DROP_FRAME");
        RMonitor.startMonitor(BuglyMonitorName.FLUENCY_METRIC);
        RMonitor.addProperty(203, new bd2.a());
    }

    public final void j() {
        List listOf;
        boolean z16 = false;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{4, 2, 7});
        if (!AppSetting.isPublicVersion() && !zc2.a.a("FD_LOCAL_START")) {
            z16 = true;
        }
        if (!listOf.contains(Integer.valueOf(MobileQQ.sProcessId)) && !z16) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_FD_LEAK");
            RMonitor.startMonitor(BuglyMonitorName.FD_ANALYZE);
            RMonitor.addProperty(208, new cd2.a());
        }
    }

    public final void k() {
        if (MobileQQ.sProcessId != 4) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_LEAK_INSPECTOR");
            RMonitor.startMonitor(BuglyMonitorName.MEMORY_JAVA_LEAK);
            RMonitor.addProperty(201, new gd2.e());
        }
    }

    public final void l(boolean force) {
        if (SceneTracker.j() || force) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_LOOPER");
            RMonitor.startMonitor(BuglyMonitorName.LOOPER_STACK);
            RMonitor.addProperty(205, new hd2.c());
        }
    }

    public final void n() {
        if (MobileQQ.sProcessId != 4) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MEMORY_JAVA_PEAK");
            RMonitor.startMonitor(BuglyMonitorName.MEMORY_JAVA_CEILING);
            RMonitor.addProperty(202, new id2.a());
        }
    }

    public final void o() {
        List listOf;
        if (Build.VERSION.SDK_INT < 28) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_NAT_MEM fail, below android 9");
            return;
        }
        boolean z16 = false;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{4, 2, 7});
        if (!AppSetting.isPublicVersion() && !zc2.a.a("NATIVE_LOCAL_START")) {
            z16 = true;
        }
        if (!listOf.contains(Integer.valueOf(MobileQQ.sProcessId)) && !z16) {
            QLog.i("QQRMonitorUtils", 1, "startRMonitors, start RMonitor.MODE_NAT_MEM");
            RMonitor.startMonitor(BuglyMonitorName.NATIVE_MEMORY_ANALYZE);
            RMonitor.addProperty(209, new jd2.a());
        }
    }
}
