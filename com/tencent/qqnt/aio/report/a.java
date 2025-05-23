package com.tencent.qqnt.aio.report;

import com.tencent.aio.api.perf.a;
import com.tencent.aio.monitor.PerfFrameCollector;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.report.AIOEnterPerfConfig;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/report/a;", "Lcom/tencent/aio/api/perf/a;", "", "rate", "", "b", "Lcom/tencent/aio/api/perf/a$b;", "perfData", "", "g", "d", "e", "a", "isExit", "f", "Z", "enableReport", "reportOnce", "c", "hasReport", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements com.tencent.aio.api.perf.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableReport;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean reportOnce;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isExit;

    public a() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        AIOEnterPerfConfig.Companion companion = AIOEnterPerfConfig.INSTANCE;
        if (companion.a().e() && b(companion.a().k())) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.enableReport = z16;
        this.reportOnce = companion.a().h();
        boolean decodeBool = QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeBool("enable_aio_frame_perf", false);
        PerfFrameCollector perfFrameCollector = PerfFrameCollector.H;
        if (!companion.a().f() && !decodeBool) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!companion.a().g() && !decodeBool) {
            z18 = false;
        }
        perfFrameCollector.g(new PerfFrameCollector.a(z17, z18));
        if (QLog.isColorLevel()) {
            QLog.d("AIOEnterPerfReport", 2, "enableReport: " + z16 + ", rate: " + companion.a().k());
        }
    }

    private final boolean b(double rate) {
        if (RandomKt.Random(1).nextInt(0, 10000) / 10000.0d < rate) {
            return true;
        }
        return false;
    }

    private final boolean d(a.b perfData) {
        if (perfData.b().size() >= AIOEnterPerfConfig.INSTANCE.a().b() && perfData.c().get(2).longValue() <= r1.a().d() && perfData.c().get(3).longValue() <= r1.a().c()) {
            return false;
        }
        return true;
    }

    private final void g(a.b perfData) {
        Map mapOf;
        if (!b(AIOEnterPerfConfig.INSTANCE.a().i())) {
            return;
        }
        MemoryUtil memoryUtil = MemoryUtil.f258173a;
        long j3 = 1000;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QCircleWeakNetReporter.KEY_COST, String.valueOf(perfData.a())), TuplesKt.to("frameCount", String.valueOf(perfData.b().size())), TuplesKt.to("gcCount", String.valueOf(perfData.c().get(0).longValue())), TuplesKt.to("gcTime", String.valueOf(perfData.c().get(1).longValue())), TuplesKt.to("gcBlockCount", String.valueOf(perfData.c().get(2).longValue())), TuplesKt.to("gcBlockTime", String.valueOf(perfData.c().get(3).longValue())), TuplesKt.to("isExit", String.valueOf(this.isExit)), TuplesKt.to("allocMem", String.valueOf(memoryUtil.f() / j3)), TuplesKt.to("maxMem", String.valueOf(memoryUtil.h() / j3)));
        QQBeaconReport.report(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "aio_enter_perf", mapOf);
        if (QLog.isColorLevel()) {
            QLog.d("AIOEnterPerfReport", 2, mapOf);
        }
        this.hasReport = true;
    }

    @Override // com.tencent.aio.api.perf.a
    public void a(@NotNull a.b perfData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) perfData);
            return;
        }
        Intrinsics.checkNotNullParameter(perfData, "perfData");
        if (this.enableReport) {
            if (this.hasReport && this.reportOnce) {
                return;
            }
            AIOEnterPerfConfig.Companion companion = AIOEnterPerfConfig.INSTANCE;
            if ((companion.a().j() && d(perfData)) || !companion.a().j()) {
                g(perfData);
            }
        }
    }

    @Override // com.tencent.aio.api.perf.a
    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            a.C0622a.b(this, j3);
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.enableReport;
    }

    public final void f(boolean isExit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isExit);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOEnterPerfReport", 2, "onStartAnim: " + isExit);
        }
        this.isExit = isExit;
        PerfFrameCollector.H.c(this);
    }
}
