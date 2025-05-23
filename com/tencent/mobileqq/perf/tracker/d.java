package com.tencent.mobileqq.perf.tracker;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tracker.a;
import com.tencent.mobileqq.perf.tracker.api.ICpuMonitorApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0014R\u001a\u0010\u0018\u001a\u00020\u00138\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/d;", "Lcom/tencent/mobileqq/perf/tracker/a;", "Lcom/tencent/mobileqq/perf/tracker/d$a;", "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "cpuUsagePercent", "", "threadCount", "B", "tk", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "trackerData", "w", "b", "v", "Lcom/tencent/mobileqq/perf/config/plugin/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/perf/config/plugin/a;", "k", "()Lcom/tencent/mobileqq/perf/config/plugin/a;", "trackerConfig", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends com.tencent.mobileqq.perf.tracker.a<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final d f258240l;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.config.plugin.a trackerConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b&\u0010\u000eR\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b(\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/d$a;", "Lcom/tencent/mobileqq/perf/tracker/a$a;", "", "recycle", "", "cpuUsagePercent", "", "threadCount", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "p", "()F", "v", "(F)V", "startCpuUsagePercent", DomainData.DOMAIN_NAME, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "w", "(I)V", "startThreadCount", "o", "setLoopCount", "loopCount", "r", "setTotalCpuUsagePercent", "totalCpuUsagePercent", ReportConstant.COSTREPORT_PREFIX, "setTotalThreadCount", "totalThreadCount", "k", "t", "endCpuUsagePercent", "l", "u", "endThreadCount", "setMaxCpuUsagePercent", "maxCpuUsagePercent", "setMaxThreadCount", "maxThreadCount", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends a.AbstractC8214a {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private float startCpuUsagePercent;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private int startThreadCount;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int loopCount;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private float totalCpuUsagePercent;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private int totalThreadCount;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private float endCpuUsagePercent;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private int endThreadCount;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private float maxCpuUsagePercent;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private int maxThreadCount;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final float k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.endCpuUsagePercent;
        }

        public final int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.endThreadCount;
        }

        public final int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.loopCount;
        }

        public final float n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
            }
            return this.maxCpuUsagePercent;
        }

        public final int o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            return this.maxThreadCount;
        }

        public final float p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.startCpuUsagePercent;
        }

        public final int q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.startThreadCount;
        }

        public final float r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.totalCpuUsagePercent;
        }

        @Override // com.tencent.mobileqq.perf.tracker.a.AbstractC8214a, com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this);
                return;
            }
            super.recycle();
            this.startCpuUsagePercent = 0.0f;
            this.startThreadCount = 0;
            this.loopCount = 0;
            this.totalCpuUsagePercent = 0.0f;
            this.totalThreadCount = 0;
            this.endCpuUsagePercent = 0.0f;
            this.endThreadCount = 0;
        }

        public final int s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.totalThreadCount;
        }

        public final void t(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            } else {
                this.endCpuUsagePercent = f16;
            }
        }

        public final void u(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, i3);
            } else {
                this.endThreadCount = i3;
            }
        }

        public final void v(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                this.startCpuUsagePercent = f16;
            }
        }

        public final void w(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.startThreadCount = i3;
            }
        }

        public final void x(float cpuUsagePercent, int threadCount) {
            float coerceAtLeast;
            int coerceAtLeast2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, this, Float.valueOf(cpuUsagePercent), Integer.valueOf(threadCount));
                return;
            }
            this.totalThreadCount += threadCount;
            this.totalCpuUsagePercent += cpuUsagePercent;
            this.loopCount++;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(cpuUsagePercent, this.maxCpuUsagePercent);
            this.maxCpuUsagePercent = coerceAtLeast;
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(threadCount, this.maxThreadCount);
            this.maxThreadCount = coerceAtLeast2;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        d dVar = new d();
        f258240l = dVar;
        trackerConfig = QQPerfConfigLoader.f257603a.b().a();
        if (dVar.z()) {
            SceneTracker.f258213d.l(dVar.i());
            dVar.y();
            com.tencent.mobileqq.perf.log.a.a(PreDownloadConstants.RPORT_KEY_CPU, "CpuTracker init success");
            return;
        }
        com.tencent.mobileqq.perf.log.a.a(PreDownloadConstants.RPORT_KEY_CPU, "CpuTracker not init");
    }

    d() {
        super(a.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(a tk5) {
        String str;
        if (q()) {
            HashMap hashMap = new HashMap(30);
            hashMap.put("stage", tk5.c());
            hashMap.put("nestStage", tk5.b());
            hashMap.put("fromStage", tk5.a());
            hashMap.put("model", DeviceInfoMonitor.getModel());
            hashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
            if (tk5.e()) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put("firstTrack", str);
            hashMap.put("startCpuUsagePercent", String.valueOf(tk5.p()));
            hashMap.put("startThreadCount", String.valueOf(tk5.q()));
            hashMap.put("endCpuUsagePercent", String.valueOf(tk5.k()));
            hashMap.put("endThreadCount", String.valueOf(tk5.l()));
            if (tk5.m() > 0) {
                hashMap.put("avgCpuUsagePercent", String.valueOf(tk5.r() / tk5.m()));
                hashMap.put("avgThreadCount", String.valueOf(tk5.s() / tk5.m()));
            }
            hashMap.put("maxCpuUsagePercent", String.valueOf(tk5.n()));
            hashMap.put("maxThreadCount", String.valueOf(tk5.o()));
            hashMap.put("processName", MobileQQ.processName);
            PerfReportUtil.h("actSceneCpu", hashMap);
            s(f() + 1);
            t(g() + 1);
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("perf_cpu_report_next_count", f());
        }
        synchronized (j()) {
            d dVar = f258240l;
            if (!dVar.m().contains(tk5)) {
                dVar.h().recycle(tk5);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean B(float cpuUsagePercent, int threadCount) {
        boolean z16;
        synchronized (j()) {
            Iterator<a> it = f258240l.j().values().iterator();
            while (it.hasNext()) {
                it.next().x(cpuUsagePercent, threadCount);
            }
            if (f258240l.j().size() > 0) {
                if (SceneTracker.j()) {
                    z16 = true;
                }
            }
            z16 = false;
        }
        return z16;
    }

    private final float x() {
        float h16 = CpuUtil.h(CpuUtil.f258160a, 0, 1, null);
        com.tencent.mobileqq.perf.log.a.a(PreDownloadConstants.RPORT_KEY_CPU, "cpuUsage is " + h16);
        return h16;
    }

    private final void y() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("perf_cpu_report_yesterday_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong - currentTimeMillis > 86400000) {
            from.encodeLong("perf_cpu_report_yesterday_time", currentTimeMillis);
            from.encodeInt("perf_cpu_report_next_count", 0);
        } else {
            s(from.decodeInt("perf_cpu_report_next_count", 0));
        }
    }

    private final boolean z() {
        boolean z16 = false;
        if (Build.VERSION.SDK_INT <= 25) {
            return false;
        }
        if (Math.random() < k().sampleRatio) {
            z16 = true;
        }
        com.tencent.mobileqq.perf.log.a.a(PreDownloadConstants.RPORT_KEY_CPU, "CpuTracker isWhetherStart : " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.perf.tracker.a
    protected void b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        float x16 = x();
        if (x16 == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((ICpuMonitorApi) QRoute.api(ICpuMonitorApi.class)).startCpuMonitor(Float.valueOf(x16));
        if (B(x16, Thread.activeCount())) {
            o();
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.a
    @NotNull
    protected com.tencent.mobileqq.perf.config.plugin.a k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.perf.config.plugin.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return trackerConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.perf.tracker.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull a trackerData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) trackerData);
            return;
        }
        Intrinsics.checkNotNullParameter(trackerData, "trackerData");
        float x16 = x();
        if (x16 == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        trackerData.t(x16);
        int activeCount = Thread.activeCount();
        trackerData.u(activeCount);
        trackerData.x(x16, activeCount);
        if (B(x16, activeCount)) {
            o();
        }
        com.tencent.mobileqq.perf.log.a.a(PreDownloadConstants.RPORT_KEY_CPU, trackerData.c() + " cpu: " + trackerData.p() + " -> " + trackerData.k() + ", threadCount: " + trackerData.q() + " -> " + trackerData.l() + ", loopCount : " + trackerData.m() + ", maxCpuUsagePercent : " + trackerData.n() + ", maxThreadCount: " + trackerData.o());
        A(trackerData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.perf.tracker.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull a trackerData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) trackerData);
            return;
        }
        Intrinsics.checkNotNullParameter(trackerData, "trackerData");
        float x16 = x();
        if (x16 == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        trackerData.v(x16);
        int activeCount = Thread.activeCount();
        trackerData.w(activeCount);
        if (B(x16, activeCount)) {
            o();
        }
    }
}
