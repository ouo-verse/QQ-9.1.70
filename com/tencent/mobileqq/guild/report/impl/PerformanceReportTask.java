package com.tencent.mobileqq.guild.report.impl;

import android.os.SystemClock;
import android.util.Log;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u001a\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u001c\u0010!\u001a\u00020\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u001fH\u0016J#\u0010$\u001a\u00020\u00012\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\"\"\u00020\u0002H\u0016\u00a2\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u00020\u0001H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010.R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010)R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010)R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00101R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010)R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00101R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010)R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00101R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00108R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00108\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "", "traceIdParam", "", "init", "", "hasReported", "getTraceId", "eventCode", "setEventCode", "source", "setEnterFrom", "", QCircleWeakNetReporter.KEY_COST, "setTimeCost", "stageCode", "setStageCode", "appChannel", "setAppChannel", "realTime", "setRealTime", "key", "value", "setParam", "", "setExtra", QzoneIPCModule.RESULT_CODE, "setResultCode", "resultMsg", "setResultMsg", "", "extraInfo", "setExtras", "", "retainKeys", "duplicate", "([Ljava/lang/String;)Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "report", "toString", com.heytap.mcssdk.a.a.f36102l, "Ljava/lang/String;", "clientName", "traceId", "Ljava/util/concurrent/ConcurrentHashMap;", "params", "Ljava/util/concurrent/ConcurrentHashMap;", "extras", "startTime", "J", "originTime", "Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportTask$LastReportTime;", "lastReportTime", "Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportTask$LastReportTime;", "timeCost", "isRealTime", "Z", "isReported", "forceReport", "getForceReport", "()Z", "setForceReport", "(Z)V", "Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportClient;", "b", "()Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportClient;", "reportClient", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "LastReportTime", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PerformanceReportTask implements IPerformanceReportTask {
    private String appChannel;
    private final String appKey;
    private final String clientName;
    private String eventCode;
    private ConcurrentHashMap<String, Object> extras;
    private boolean forceReport;
    private boolean isRealTime;
    private boolean isReported;
    private LastReportTime lastReportTime;
    private long originTime;
    private ConcurrentHashMap<String, String> params;
    private long resultCode;
    private String resultMsg;
    private String source;
    private String stageCode;
    private long startTime;
    private long timeCost;
    private String traceId;

    public PerformanceReportTask(String appKey, String clientName) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        this.appKey = appKey;
        this.clientName = clientName;
        this.eventCode = "";
        this.stageCode = "";
        this.startTime = SystemClock.uptimeMillis();
        this.originTime = SystemClock.uptimeMillis();
        this.source = "";
        this.appChannel = "";
        this.resultMsg = "";
        this.timeCost = -1L;
        this.isRealTime = QLog.isDebugVersion();
    }

    private final PerformanceReportClient b() {
        return c.b(c.f232031a, this.clientName, null, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public IPerformanceReportTask duplicate(String... retainKeys) {
        boolean contains;
        boolean contains2;
        Intrinsics.checkNotNullParameter(retainKeys, "retainKeys");
        PerformanceReportTask performanceReportTask = new PerformanceReportTask(this.appKey, this.clientName);
        String str = this.traceId;
        ConcurrentHashMap<String, Object> concurrentHashMap = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("traceId");
            str = null;
        }
        performanceReportTask.traceId = str;
        performanceReportTask.eventCode = this.eventCode;
        performanceReportTask.appChannel = this.appChannel;
        performanceReportTask.source = this.source;
        performanceReportTask.originTime = this.originTime;
        LastReportTime lastReportTime = this.lastReportTime;
        if (lastReportTime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastReportTime");
            lastReportTime = null;
        }
        performanceReportTask.lastReportTime = lastReportTime;
        performanceReportTask.params = new ConcurrentHashMap<>();
        performanceReportTask.extras = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.params;
        if (concurrentHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            concurrentHashMap2 = null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap3 = performanceReportTask.params;
        if (concurrentHashMap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            concurrentHashMap3 = null;
        }
        for (Map.Entry<String, String> entry : concurrentHashMap2.entrySet()) {
            contains2 = ArraysKt___ArraysKt.contains(retainKeys, entry.getKey());
            if (contains2) {
                concurrentHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        ConcurrentHashMap<String, Object> concurrentHashMap4 = this.extras;
        if (concurrentHashMap4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap4 = null;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap5 = performanceReportTask.extras;
        if (concurrentHashMap5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap5 = null;
        }
        for (Map.Entry<String, Object> entry2 : concurrentHashMap4.entrySet()) {
            contains = ArraysKt___ArraysKt.contains(retainKeys, entry2.getKey());
            if (contains) {
                concurrentHashMap5.put(entry2.getKey(), entry2.getValue());
            }
        }
        ConcurrentHashMap<String, Object> concurrentHashMap6 = performanceReportTask.extras;
        if (concurrentHashMap6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
        } else {
            concurrentHashMap = concurrentHashMap6;
        }
        concurrentHashMap.put("bg_count", Integer.valueOf(com.tencent.mobileqq.guild.c.f214816a.c()));
        return performanceReportTask;
    }

    public final boolean getForceReport() {
        return this.forceReport;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public String getTraceId() {
        String str = this.traceId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("traceId");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    /* renamed from: hasReported, reason: from getter */
    public boolean getIsReported() {
        return this.isReported;
    }

    public final void init(String traceIdParam) {
        Intrinsics.checkNotNullParameter(traceIdParam, "traceIdParam");
        this.traceId = traceIdParam;
        this.params = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.extras = concurrentHashMap;
        concurrentHashMap.put("bg_count", Integer.valueOf(com.tencent.mobileqq.guild.c.f214816a.c()));
        this.lastReportTime = new LastReportTime(this.originTime);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public IPerformanceReportTask report() {
        if (this.isReported) {
            Logger logger = Logger.f235387a;
            IllegalStateException illegalStateException = new IllegalStateException();
            Logger.b bVar = new Logger.b();
            String str = "report: " + this.eventCode + " -> already reported";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(PerformanceReportApiImpl.LOG_TAG, 1, (String) it.next(), illegalStateException);
            }
            return this;
        }
        if (this.eventCode.length() == 0) {
            Logger logger2 = Logger.f235387a;
            IllegalStateException illegalStateException2 = new IllegalStateException();
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("report: eventCode is empty");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e(PerformanceReportApiImpl.LOG_TAG, 1, (String) it5.next(), illegalStateException2);
            }
            s.e(PerformanceReportApiImpl.LOG_TAG, "report: eventCode -> eventCode is empty, task = (" + this + ")", new IllegalStateException());
            return this;
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        LastReportTime lastReportTime = this.lastReportTime;
        if (lastReportTime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastReportTime");
            lastReportTime = null;
        }
        final long time = uptimeMillis - lastReportTime.getTime();
        LastReportTime lastReportTime2 = this.lastReportTime;
        if (lastReportTime2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastReportTime");
            lastReportTime2 = null;
        }
        lastReportTime2.setTime(uptimeMillis);
        if (this.timeCost < 0) {
            this.timeCost = uptimeMillis - this.startTime;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = this.extras;
        if (concurrentHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap = null;
        }
        concurrentHashMap.put("report_bg_count", Integer.valueOf(com.tencent.mobileqq.guild.c.f214816a.c()));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        final String str2 = currentAccountUin == null ? d.f247921x : currentAccountUin;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.report.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceReportTask.c(PerformanceReportTask.this, uptimeMillis, time, str2);
            }
        });
        this.isReported = true;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public /* bridge */ /* synthetic */ IPerformanceReportTask setExtras(Map map) {
        return setExtras((Map<String, ? extends Object>) map);
    }

    public final void setForceReport(boolean z16) {
        this.forceReport = z16;
    }

    public static final void c(PerformanceReportTask this$0, long j3, long j16, String uin) {
        String b16;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (!this$0.forceReport && !this$0.b().f(this$0.eventCode)) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(PerformanceReportApiImpl.LOG_TAG, "report: " + this$0.eventCode + " -> not sampled");
                return;
            }
            return;
        }
        Pair[] pairArr = new Pair[14];
        String str = this$0.traceId;
        ConcurrentHashMap<String, String> concurrentHashMap = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("traceId");
            str = null;
        }
        pairArr[0] = TuplesKt.to("trace_id", str);
        pairArr[1] = TuplesKt.to("stage_code", this$0.stageCode);
        pairArr[2] = TuplesKt.to("result_code", String.valueOf(this$0.resultCode));
        pairArr[3] = TuplesKt.to("result_msg", this$0.resultMsg);
        pairArr[4] = TuplesKt.to("time_cost", String.valueOf(this$0.timeCost));
        pairArr[5] = TuplesKt.to("report_create_time", String.valueOf(this$0.startTime));
        pairArr[6] = TuplesKt.to("report_time", String.valueOf(j3));
        pairArr[7] = TuplesKt.to("source", this$0.source);
        pairArr[8] = TuplesKt.to("app_channel", this$0.appChannel);
        ConcurrentHashMap<String, Object> concurrentHashMap2 = this$0.extras;
        if (concurrentHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap2 = null;
        }
        b16 = PerformanceReportApiImplKt.b(concurrentHashMap2);
        pairArr[9] = TuplesKt.to("json_extras", b16);
        pairArr[10] = TuplesKt.to("build_type", PerformanceReportApiImpl.INSTANCE.c());
        pairArr[11] = TuplesKt.to("stage_time", String.valueOf(j16));
        pairArr[12] = TuplesKt.to("time_cost_total", String.valueOf(j3 - this$0.originTime));
        pairArr[13] = TuplesKt.to("report_origin_time", String.valueOf(this$0.originTime));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        ConcurrentHashMap<String, String> concurrentHashMap3 = this$0.params;
        if (concurrentHashMap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        } else {
            concurrentHashMap = concurrentHashMap3;
        }
        mutableMapOf.putAll(concurrentHashMap);
        Logger.f235387a.d().a(PerformanceReportApiImpl.LOG_TAG, 1, "report eventCode:" + this$0.eventCode + " param:" + new Gson().toJson(mutableMapOf));
        QQBeaconReport.reportWithAppKey(this$0.appKey, uin, this$0.eventCode, this$0.resultCode == 0, mutableMapOf, this$0.isRealTime);
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setAppChannel(String appChannel) {
        Intrinsics.checkNotNullParameter(appChannel, "appChannel");
        this.appChannel = appChannel;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setEnterFrom(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setEventCode(String eventCode) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        this.eventCode = eventCode;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setExtra(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.extras;
        if (concurrentHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap = null;
        }
        if (value == null) {
            value = Unit.INSTANCE;
        }
        concurrentHashMap.put(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setExtras(Map<String, ? extends Object> extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        ConcurrentHashMap<String, Object> concurrentHashMap = this.extras;
        if (concurrentHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
            concurrentHashMap = null;
        }
        concurrentHashMap.putAll(extraInfo);
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setParam(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ConcurrentHashMap<String, String> concurrentHashMap = this.params;
        if (concurrentHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            concurrentHashMap = null;
        }
        concurrentHashMap.put(key, value);
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setRealTime(boolean realTime) {
        this.isRealTime = realTime;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setResultCode(long r16) {
        this.resultCode = r16;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setResultMsg(String resultMsg) {
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        this.resultMsg = resultMsg;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setStageCode(String stageCode) {
        Intrinsics.checkNotNullParameter(stageCode, "stageCode");
        this.stageCode = stageCode;
        return this;
    }

    @Override // com.tencent.mobileqq.guild.report.IPerformanceReportTask
    public PerformanceReportTask setTimeCost(long r16) {
        this.timeCost = r16;
        return this;
    }

    public String toString() {
        String str = this.appKey;
        String str2 = this.clientName;
        String str3 = this.traceId;
        ConcurrentHashMap<String, Object> concurrentHashMap = null;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("traceId");
            str3 = null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.params;
        if (concurrentHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            concurrentHashMap2 = null;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap3 = this.extras;
        if (concurrentHashMap3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extras");
        } else {
            concurrentHashMap = concurrentHashMap3;
        }
        return "PerformanceReportTask(appKey='" + str + "', clientName='" + str2 + "', traceId='" + str3 + "', params=" + concurrentHashMap2 + ", extras=" + concurrentHashMap + ", eventCode='" + this.eventCode + "', stageCode='" + this.stageCode + "', startTime=" + this.startTime + ", source='" + this.source + "', appChannel='" + this.appChannel + "', resultCode=" + this.resultCode + ", resultMsg='" + this.resultMsg + "', timeCost=" + this.timeCost + ", isRealTime=" + this.isRealTime + ", isReported=" + this.isReported + ")";
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/report/impl/PerformanceReportTask$LastReportTime;", "Ljava/io/Serializable;", "time", "", "(J)V", "getTime", "()J", "setTime", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class LastReportTime implements Serializable {
        private long time;

        public LastReportTime(long j3) {
            this.time = j3;
        }

        /* renamed from: component1, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        public final LastReportTime copy(long time) {
            return new LastReportTime(time);
        }

        public final long getTime() {
            return this.time;
        }

        public int hashCode() {
            return b.a(this.time);
        }

        public final void setTime(long j3) {
            this.time = j3;
        }

        public String toString() {
            return "LastReportTime(time=" + this.time + ")";
        }

        public static /* synthetic */ LastReportTime copy$default(LastReportTime lastReportTime, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = lastReportTime.time;
            }
            return lastReportTime.copy(j3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LastReportTime) && this.time == ((LastReportTime) other).time;
        }
    }

    public static /* synthetic */ void init$default(PerformanceReportTask performanceReportTask, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
        performanceReportTask.init(str);
    }
}
