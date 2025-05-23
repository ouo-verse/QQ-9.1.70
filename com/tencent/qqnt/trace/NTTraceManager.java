package com.tencent.qqnt.trace;

import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.business.performance.report.sample.ISceneSample;
import com.tencent.richframework.tracer.RFWTraceStream;
import com.tencent.richframework.tracer.RFWTraceStreamResult;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J8\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u001bJ\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0012\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u001fH\u0016R'\u0010-\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b+\u0010,R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\"\u0010:\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00105R\u001b\u0010?\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b=\u00107R\u001b\u0010@\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010>\u001a\u0004\b4\u00107\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/trace/NTTraceManager;", "Lcom/tencent/richframework/tracer/RFWTraceStream$IStreamResultHandler;", "Lcom/tencent/richframework/argus/business/performance/report/sample/ISceneSample;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "Lcom/tencent/richframework/tracer/RFWTraceStreamResult;", "streamResult", "", "i", "", "year", "month", "day", WidgetCacheWeatherData.HOUR, "minute", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "", "e", "", tl.h.F, "l", "onStreamFinish", "checkCanReport", "j", "Lcom/tencent/qqnt/trace/BuildType;", "buildType", "k", "Lkotlin/Function1;", "cb", "b", "f", "", "getCanLanKey", "", "getMeetStrategies", "isTargetType", "key", "", "getSampleSize", "Ljava/util/HashSet;", "Lcom/tencent/qqnt/trace/q;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getAllReport", "()Ljava/util/HashSet;", "allReport", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getPendingStreamResult", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "pendingStreamResult", "d", "Z", "getHasStarted", "()Z", "setHasStarted", "(Z)V", "hasStarted", "hasInitSample", "isSampled", "g", "Lkotlin/Lazy;", "forceReport", "allowReportToBeacon", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class NTTraceManager extends ISceneSample implements RFWTraceStream.IStreamResultHandler, IRFWSampleManager, IRFWSampleMeetStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTTraceManager f362318a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<q> allReport;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<RFWTraceStreamResult> pendingStreamResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasStarted;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitSample;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isSampled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy forceReport;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy allowReportToBeacon;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f362318a = new NTTraceManager();
        allReport = new HashSet<>();
        pendingStreamResult = new CopyOnWriteArrayList<>();
        lazy = LazyKt__LazyJVMKt.lazy(NTTraceManager$forceReport$2.INSTANCE);
        forceReport = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(NTTraceManager$allowReportToBeacon$2.INSTANCE);
        allowReportToBeacon = lazy2;
    }

    NTTraceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RFWTraceStreamResult streamResult, Function1 cb5) {
        String joinToString$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(streamResult, "$streamResult");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        String streamName = streamResult.getStreamName();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(streamResult.getCostMap().keySet(), "_", null, null, 0, null, null, 62, null);
        String str = streamName + "_" + joinToString$default;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("KEY_MESSAGE_REPORT_TIME" + str, -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong > 0) {
            if (currentTimeMillis - decodeLong > 14400000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                cb5.invoke(Boolean.FALSE);
                return;
            }
        }
        from.encodeLong("KEY_MESSAGE_REPORT_TIME" + str, currentTimeMillis);
        cb5.invoke(Boolean.TRUE);
    }

    private final boolean d() {
        return ((Boolean) allowReportToBeacon.getValue()).booleanValue();
    }

    private final long e(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        if (year != 0 || month != 0 || day != 0) {
            calendar.set(1, year);
            calendar.set(2, month);
            calendar.set(5, day);
        }
        calendar.set(11, hour);
        calendar.set(12, minute);
        calendar.set(13, second);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private final boolean g() {
        return ((Boolean) forceReport.getValue()).booleanValue();
    }

    private final boolean i(RFWTraceStreamResult streamResult) {
        if (g() || isSampled || hitSample(streamResult.getStreamName())) {
            return true;
        }
        return false;
    }

    public final void b(@NotNull final RFWTraceStreamResult streamResult, @NotNull final Function1<? super Boolean, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) streamResult, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.trace.p
            @Override // java.lang.Runnable
            public final void run() {
                NTTraceManager.c(RFWTraceStreamResult.this, cb5);
            }
        }, 32, null, false);
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        long j3 = 60;
        return (int) (((((System.currentTimeMillis() - e(1970, 0, 1, 0, 0, 0)) / 1000) / j3) / j3) / 24);
    }

    @Override // com.tencent.richframework.argus.business.performance.report.sample.ISceneSample
    @NotNull
    public String getCanLanKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "nt_trace_manager_scene_sample";
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    @NotNull
    public List<IRFWSampleMeetStrategy> getMeetStrategies() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 14, (Object) this);
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    public float getSampleSize(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this, (Object) key)).floatValue();
        }
        return getSampleSize(key, 0.0f);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        r rVar = r.f362387a;
        rVar.findStream("MESSAGE_PAGE").tagNode("APP_LAUNCH");
        rVar.findStream("MESSAGE_PAGE").addStreamResultHandler(this);
        rVar.findStream("AIO_PAGE").addStreamResultHandler(this);
        rVar.findStream("GALLERY_PAGE").addStreamResultHandler(this);
        rVar.findStream("PROFILE_PAGE").addStreamResultHandler(this);
        rVar.findStream("CONTACT_PAGE").addStreamResultHandler(this);
        rVar.findStream("CLICK_PUSH_MSG").addStreamResultHandler(this);
        rVar.findStream("MSF_MSG_PUSH").addStreamResultHandler(new h());
        HashSet<q> hashSet = allReport;
        hashSet.add(new o());
        hashSet.add(new m());
        hashSet.add(new n());
        hashSet.add(new l());
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    public boolean hitSample(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        return IRFWSampleManager.DefaultImpls.hitSample(this, str);
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    /* renamed from: isTargetType */
    public boolean getIsTargetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    public final void j(@NotNull final RFWTraceStreamResult streamResult, boolean checkCanReport) {
        AppRuntime peekAppRuntime;
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, streamResult, Boolean.valueOf(checkCanReport));
            return;
        }
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        try {
            if (!hasStarted) {
                pendingStreamResult.add(streamResult);
                return;
            }
            QLog.i("NTTraceManager", 1, streamResult.toString());
            if (!d() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return;
            }
            long longAccountUin = peekAppRuntime.getLongAccountUin();
            if (longAccountUin <= 0) {
                return;
            }
            Iterator<T> it = allReport.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((q) obj).isTargetType()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            q qVar = (q) obj;
            if (qVar == null) {
                return;
            }
            if (!hasInitSample) {
                if (f() % qVar.a() == longAccountUin % qVar.a()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                isSampled = z16;
                hasInitSample = true;
            }
            if (!i(streamResult)) {
                QLog.w("NTTraceManager", 1, "isNotSampled streamName:" + streamResult.getStreamName());
                return;
            }
            if (!g() && checkCanReport) {
                b(streamResult, new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.trace.NTTraceManager$onStreamFinish$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RFWTraceStreamResult.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, z17);
                            return;
                        }
                        if (z17) {
                            return;
                        }
                        QLog.w("NTTraceManager", 1, "can't Report streamName:" + RFWTraceStreamResult.this.getStreamName());
                    }
                });
            }
            QLog.w("NTTraceManager", 1, "start Report streamName:" + streamResult.getStreamName());
            k(qVar.getBuildType(), streamResult);
        } catch (Exception e16) {
            QLog.e("NTTraceManager", 1, e16, new Object[0]);
        }
    }

    public final void k(@NotNull BuildType buildType, @NotNull RFWTraceStreamResult streamResult) {
        String str;
        int mapCapacity;
        int mapCapacity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) buildType, (Object) streamResult);
            return;
        }
        Intrinsics.checkNotNullParameter(buildType, "buildType");
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Map<String, Long> costMap = streamResult.getCostMap();
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(costMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator<T> it = costMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), String.valueOf(((Number) entry.getValue()).longValue()));
        }
        hashMap.putAll(linkedHashMap);
        Map<String, Object> extraParam = streamResult.getExtraParam();
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(extraParam.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity2);
        Iterator<T> it5 = extraParam.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it5.next();
            linkedHashMap2.put(entry2.getKey(), entry2.getValue().toString());
        }
        hashMap.putAll(linkedHashMap2);
        hashMap.put("source", streamResult.getStreamName());
        hashMap.put("app_type", String.valueOf(buildType.getValue()));
        QQBeaconReport.reportWithAppKey("0AND05CMPBA8DUEM", str, "qq_part_performance_report", hashMap);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!hasStarted) {
            hasStarted = true;
            for (RFWTraceStreamResult it : pendingStreamResult) {
                NTTraceManager nTTraceManager = f362318a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                nTTraceManager.onStreamFinish(it);
            }
        }
    }

    @Override // com.tencent.richframework.tracer.RFWTraceStream.IStreamResultHandler
    public void onStreamFinish(@NotNull RFWTraceStreamResult streamResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) streamResult);
            return;
        }
        Intrinsics.checkNotNullParameter(streamResult, "streamResult");
        if (Intrinsics.areEqual(streamResult.getStreamName(), "CLICK_PUSH_MSG")) {
            j(streamResult, false);
        } else {
            j(streamResult, true);
        }
    }
}
