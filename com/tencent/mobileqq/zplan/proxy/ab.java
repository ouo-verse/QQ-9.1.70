package com.tencent.mobileqq.zplan.proxy;

import android.os.Process;
import com.tencent.mobileqq.perf.raftkit.a;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.processkiller.ProcessMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaEnterUEModApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00032\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/ab;", "Lzx4/s;", "", "b", "c", "d", "", "isZPlanEnable", "isEmpty", "e", "a", "Lcom/tencent/mobileqq/zootopia/api/a;", "Lcom/tencent/mobileqq/zootopia/api/a;", "getUeModprocessor", "()Lcom/tencent/mobileqq/zootopia/api/a;", "setUeModprocessor", "(Lcom/tencent/mobileqq/zootopia/api/a;)V", "ueModprocessor", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ab implements zx4.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.a ueModprocessor = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/proxy/ab$b", "Lcom/tencent/mobileqq/processkiller/ProcessMonitor$a;", "", "a", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ProcessMonitor.a {
        b() {
        }

        @Override // com.tencent.mobileqq.processkiller.ProcessMonitor.a
        public void a() {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).stopZPlanEngine();
        }

        @Override // com.tencent.mobileqq.processkiller.ProcessMonitor.a
        public boolean b() {
            return !ZPlanServiceHelper.I.Q();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/proxy/ab$c", "Lcom/tencent/mobileqq/perf/raftkit/a$a;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements a.InterfaceC8210a {
        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/proxy/ab$d", "Lcom/tencent/mobileqq/zootopia/api/a;", "", "mapId", "", "mapName", "", "doEnterUEMap", "doExitUEMap", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.a {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.a
        public void doEnterUEMap(int mapId, String mapName) {
            Intrinsics.checkNotNullParameter(mapName, "mapName");
            PerfReportUtil.j(mapId, mapName);
        }

        @Override // com.tencent.mobileqq.zootopia.api.a
        public void doExitUEMap(int mapId, String mapName) {
            Intrinsics.checkNotNullParameter(mapName, "mapName");
        }
    }

    @Override // zx4.s
    public void a() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).saveLastZPlanUsingTimeStamp(System.currentTimeMillis());
    }

    @Override // zx4.s
    public void b() {
        QLog.i("[zplan]_ZPlanUECommonProxy", 2, "reportZPlanProcessStart FeatureFlag.zPlan true, " + Process.myPid());
        com.tencent.mobileqq.perf.report.a.f258012a = true;
        PerfFeature.a(PerfFeature.CustomFlag.ZPlanProcess);
        if (!t74.h.b()) {
            QLog.i("[zplan]_ZPlanUECommonProxy", 2, "reportZPlanProcessStart traceStart, " + Process.myPid());
            SceneTracker.f258213d.traceStart("zplan_service", true);
        }
        if (t74.h.a("com.tencent.mobileqq:zplan")) {
            ((IZootopiaEnterUEModApi) QRoute.api(IZootopiaEnterUEModApi.class)).registerEnterMapProcessor(this.ueModprocessor);
        }
        com.tencent.mobileqq.perf.raftkit.a.f257948a.a(new c());
    }

    @Override // zx4.s
    public void c() {
        QLog.i("[zplan]_ZPlanUECommonProxy", 2, "reportZPlanProcessEnd FeatureFlag.zPlan false , " + Process.myPid());
        com.tencent.mobileqq.perf.report.a.f258012a = false;
        PerfFeature.d(PerfFeature.CustomFlag.ZPlanProcess);
        if (!t74.h.b()) {
            QLog.i("[zplan]_ZPlanUECommonProxy", 2, "reportZPlanProcessStart traceEnd, " + Process.myPid());
            SceneTracker.f258213d.traceEnd("zplan_service");
        }
        if (t74.h.a("com.tencent.mobileqq:zplan")) {
            ((IZootopiaEnterUEModApi) QRoute.api(IZootopiaEnterUEModApi.class)).unRegisterEnterMapProcessor(this.ueModprocessor);
        }
    }

    @Override // zx4.s
    public void d() {
        QLog.i("[zplan]_ZPlanUECommonProxy", 2, "reportZPlanProcessQuit FeatureFlag.zPlan, " + Process.myPid());
        if (t74.h.b()) {
            PerfReportUtil.m();
        }
    }

    @Override // zx4.s
    public void e(boolean isEmpty) {
        QLog.d("[zplan]_ZPlanUECommonProxy", 1, "Report Empty: ", Boolean.valueOf(isEmpty));
        if (t74.h.b() || ZPlanFeatureSwitch.f369852a.f3()) {
            ProcessMonitor processMonitor = ProcessMonitor.f259724d;
            if (!processMonitor.e()) {
                processMonitor.j(new b());
            }
            processMonitor.g(isEmpty);
        }
    }

    @Override // zx4.s
    public boolean isZPlanEnable() {
        QLog.i("[zplan]_ZPlanUECommonProxy", 1, "isZPlanEnable isPublicVersion");
        return uk3.g.f439121a.i();
    }
}
