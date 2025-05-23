package com.tencent.rmonitor.looper;

import android.app.Application;
import com.tencent.ark.ark;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.data.g;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.db.e;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.LooperMeta;
import com.tencent.rmonitor.base.plugin.listener.ILooperListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.sla.AttaEvent;
import com.tencent.rmonitor.sla.AttaEventReporter;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0006`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rmonitor/looper/LooperReport;", "", "Lcom/tencent/rmonitor/looper/c;", "monitorInfo", "", h.F, "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "d", "b", "", "f", "g", "a", "c", "e", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "longLagMap", "<init>", "()V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LooperReport {

    /* renamed from: b, reason: collision with root package name */
    public static final LooperReport f365654b = new LooperReport();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Long, ReportData> longLagMap = new HashMap<>(20);

    LooperReport() {
    }

    private final ReportData a(MonitorInfo monitorInfo) {
        JSONObject jSONObject;
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
        makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.INSTANCE.c(BaseInfo.app));
        makeAttributes.put("time_cost", monitorInfo.getDuration());
        makeAttributes.put("stage", monitorInfo.getScene());
        makeAttributes.put("stack_interval", monitorInfo.getLagParam().f365686d);
        makeAttributes.put("start_time", monitorInfo.getLastStackRequestTime());
        makeAttributes.put("monitored_thread_name", monitorInfo.getThreadName());
        makeAttributes.put("app_in_foreground", monitorInfo.getIsAppInForeground());
        makeAttributes.put("detect_strategy", monitorInfo.getLagParam().f365688f);
        s04.b.j().c(false, monitorInfo.getScene(), makeAttributes);
        s04.b.j().g(makeAttributes);
        JSONObject json = GcInfoStatHelper.getInstance().toJSON(monitorInfo.getLastStackRequestTime() - 1000, monitorInfo.getLastStackRequestTime() + monitorInfo.getDuration());
        if (json != null) {
            makeAttributes.put(ReportDataBuilder.KEY_GC_INFO, json);
        }
        if (makeAttributes.has(ReportDataBuilder.KEY_BIZ_EXTEND_INFO)) {
            jSONObject = makeAttributes.getJSONObject(ReportDataBuilder.KEY_BIZ_EXTEND_INFO);
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("detect_strategy", monitorInfo.getLagParam().f365688f);
        makeAttributes.put(ReportDataBuilder.KEY_BIZ_EXTEND_INFO, jSONObject);
        Application application = BaseInfo.app;
        UserMeta userMeta = BaseInfo.userMeta;
        JSONObject params = ReportDataBuilder.makeParam(application, "looper", BuglyMonitorName.LOOPER_STACK, userMeta);
        params.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
        long lastStackRequestTime = monitorInfo.getLastStackRequestTime() + monitorInfo.getDuration();
        params.put(ReportDataBuilder.KEY_EVENT_TIME_IN_MS, lastStackRequestTime);
        params.put("event_time", lastStackRequestTime / 1000);
        String str = userMeta.uin;
        Intrinsics.checkExpressionValueIsNotNull(params, "params");
        ReportData reportData = new ReportData(str, 1, "Looper single", params);
        reportData.setShouldRecordLinkData(true);
        if (monitorInfo.c()) {
            FileUtil.Companion companion = FileUtil.INSTANCE;
            String l3 = companion.l("rmonitor_trace", ark.ARKMETADATA_JSON);
            File file = new File(companion.j(), l3);
            companion.p(file.getAbsolutePath(), String.valueOf(monitorInfo.getFullStack()), false);
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
            reportData.addFile(absolutePath, true, true);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("file_stacks", l3);
            params.put(ReportDataBuilder.KEY_BODY, jSONObject2);
        } else {
            params.put(ReportDataBuilder.KEY_BODY, monitorInfo.getFullStack());
        }
        return reportData;
    }

    private final void b(final ReportData reportData) {
        long j3;
        if (reportData.getDbId() == 0) {
            j3 = 1000;
        } else {
            j3 = 200;
        }
        ThreadManager.INSTANCE.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.looper.LooperReport$cancelCachedReportData$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.rmonitor.base.db.d dVar;
                com.tencent.rmonitor.base.db.c dbHandler;
                if (ReportData.this.getDbId() > 0 && (dVar = BaseInfo.dbHelper) != null && (dbHandler = dVar.getDbHandler()) != null) {
                    dbHandler.o(com.tencent.rmonitor.base.db.table.c.INSTANCE.a(), ReportData.this.getDbId(), DBDataStatus.SENT.getValue());
                }
                if (Logger.debug) {
                    String optString = ReportData.this.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
                    Logger.f365497g.d("RMonitor_lag_report", "deal cached report data, clientIdentify: " + optString);
                }
            }
        }, j3);
    }

    private final boolean c(MonitorInfo monitorInfo) {
        boolean z16;
        m a16 = a.f365658a.a(BuglyMonitorName.LOOPER_STACK);
        if (!(a16 instanceof g)) {
            a16 = null;
        }
        g gVar = (g) a16;
        if (gVar == null || !gVar.c()) {
            return true;
        }
        long duration = monitorInfo.getDuration();
        if (duration > gVar.e()) {
            Logger.f365497g.i("RMonitor_lag_report", "not valid sample for " + duration + " exceed " + gVar.e());
            return false;
        }
        int collectStackMsgCount = monitorInfo.getCollectStackMsgCount();
        long j3 = monitorInfo.getLagParam().f365686d;
        long j16 = collectStackMsgCount;
        long j17 = duration - (j3 * j16);
        long d16 = (j16 * gVar.d()) + j3;
        if (collectStackMsgCount < gVar.f() && j17 > d16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Logger.f365497g.i("RMonitor_lag_report", "not valid sample for {totalCost: " + duration + ", sliceCount: " + collectStackMsgCount + ", stackInterval: " + j3 + ", delay: " + j17 + ", delayLimit: " + d16 + '}');
        }
        return z16;
    }

    private final void d(MonitorInfo monitorInfo, ReportData reportData) {
        if (monitorInfo.getIsDetectedLongLag()) {
            HashMap<Long, ReportData> hashMap = longLagMap;
            if (hashMap.size() >= 20) {
                hashMap.clear();
            }
            hashMap.put(Long.valueOf(monitorInfo.getLastStackRequestTime()), reportData);
            reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_NEXT_LAUNCH);
            if (Logger.verbos) {
                String optString = reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
                Logger.f365497g.v("RMonitor_lag_report", "record unfinished long lag clientIdentify, duration: " + monitorInfo.getDuration() + ", requestTime: " + monitorInfo.getLastStackRequestTime() + ", clientIdentify: " + optString);
                return;
            }
            return;
        }
        if (monitorInfo.getDuration() >= 5000) {
            ReportData remove = longLagMap.remove(Long.valueOf(monitorInfo.getLastStackRequestTime()));
            if (remove != null) {
                b(remove);
            }
            if (Logger.verbos) {
                String optString2 = reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
                Logger.f365497g.v("RMonitor_lag_report", "deal finished long lag clientIdentify, duration: " + monitorInfo.getDuration() + ", requestTime: " + monitorInfo.getLastStackRequestTime() + ", clientIdentify: " + optString2);
            }
        }
    }

    private final boolean f(MonitorInfo monitorInfo) {
        ReportData a16 = a(monitorInfo);
        d(monitorInfo, a16);
        if (c(monitorInfo)) {
            return g(a16, monitorInfo);
        }
        new e().insertReportDataToCacheAsSend(a16);
        return false;
    }

    private final boolean g(ReportData reportData, MonitorInfo monitorInfo) {
        try {
            LooperMeta looperMeta = new LooperMeta(reportData.getParams(), monitorInfo.getThreadId(), monitorInfo.getThreadName());
            Iterator<T> it = i04.a.looperListener.c().iterator();
            while (it.hasNext()) {
                ((ILooperListener) it.next()).onBeforeReport(looperMeta);
            }
            if (PluginController.f365404b.e(BuglyMonitorName.LOOPER_STACK)) {
                IReporter.DefaultImpls.reportNow$default(ReporterMachine.f365411g, reportData, null, 2, null);
                return true;
            }
            if (!Logger.verbos) {
                return true;
            }
            Logger.f365497g.v("RMonitor_lag_report", "miss report for sampling. [ThreadName: " + monitorInfo.getThreadName() + ", CostInMs: " + monitorInfo.getDuration() + ", Scene: " + monitorInfo.getScene() + ", Foreground: " + monitorInfo.getIsAppInForeground() + ']');
            return true;
        } catch (Throwable th5) {
            Logger.f365497g.w("RMonitor_lag_report", "looper data may be error, " + th5.getMessage());
            return false;
        }
    }

    private final void h(MonitorInfo monitorInfo) {
        int i3;
        if (!com.tencent.rmonitor.sla.e.b().c("RMLooperStackCollectStack")) {
            return;
        }
        AttaEvent attaEvent = new AttaEvent("RMLooperStackCollectStack");
        double e16 = monitorInfo.e();
        attaEvent.a0(String.valueOf(e16));
        long f16 = monitorInfo.f();
        attaEvent.b0(String.valueOf(f16));
        attaEvent.g0(String.valueOf(monitorInfo.getCollectStackMsgCount()));
        attaEvent.h0(String.valueOf(monitorInfo.getDuration()));
        attaEvent.S((int) monitorInfo.getDuration());
        if (monitorInfo.getFullStack() == null) {
            attaEvent.i0("0");
        } else {
            attaEvent.i0("1");
        }
        PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
        String oSVersion = privacyInformation.getOSVersion();
        Intrinsics.checkExpressionValueIsNotNull(oSVersion, "PrivacyInformation.getInstance().osVersion");
        attaEvent.j0(oSVersion);
        PrivacyInformation privacyInformation2 = PrivacyInformation.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(privacyInformation2, "PrivacyInformation.getInstance()");
        String manufacture = privacyInformation2.getManufacture();
        Intrinsics.checkExpressionValueIsNotNull(manufacture, "PrivacyInformation.getInstance().manufacture");
        attaEvent.k0(manufacture);
        PrivacyInformation privacyInformation3 = PrivacyInformation.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(privacyInformation3, "PrivacyInformation.getInstance()");
        String model = privacyInformation3.getModel();
        Intrinsics.checkExpressionValueIsNotNull(model, "PrivacyInformation.getInstance().model");
        attaEvent.l0(model);
        attaEvent.m0(String.valueOf(monitorInfo.getQuickTraceFlag()));
        if ((e16 / 1000) + f16 > 20) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        attaEvent.T(i3);
        AttaEventReporter.INSTANCE.a().c(attaEvent);
    }

    public final boolean e(@NotNull MonitorInfo monitorInfo) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        if (monitorInfo.getFullStack() != null) {
            z16 = f(monitorInfo);
        } else {
            z16 = false;
        }
        h(monitorInfo);
        return z16;
    }
}
