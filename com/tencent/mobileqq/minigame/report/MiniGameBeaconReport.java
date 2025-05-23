package com.tencent.mobileqq.minigame.report;

import android.os.Looper;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import cooperation.qzone.QUA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J(\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0007J8\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0007J$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameBeaconReport;", "", "()V", "BEACON_MAX_EVENT_NAME_LENGTH", "", "JANK_TRACE_TOP_RECORDS_COUNT", "MINI_GAME_BEACON_KEY", "", "init", "", "report", "eventCode", "params", "", "isRealTime", "", "isImmediatelyUpload", "reportSync", "reportToBeacon", AdMetricTag.EVENT_NAME, "reportMap", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameBeaconReport {
    private static final int BEACON_MAX_EVENT_NAME_LENGTH = 59;
    public static final MiniGameBeaconReport INSTANCE = new MiniGameBeaconReport();
    private static final int JANK_TRACE_TOP_RECORDS_COUNT = 20;
    private static final String MINI_GAME_BEACON_KEY = "00000ARN3S3S9UE8";

    static {
        init();
    }

    MiniGameBeaconReport() {
    }

    @JvmStatic
    public static final void init() {
        UserAction.registerTunnel(new TunnelInfo(MINI_GAME_BEACON_KEY, AppSetting.n(), "1000"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r4);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void report(String eventCode, Map<String, String> params) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Map map = null;
        map = null;
        if (params != null && mutableMap != null) {
            String qua3 = QUA.getQUA3();
            Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
            mutableMap.put("qua", qua3);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            String account = runtime != null ? runtime.getAccount() : null;
            if (account == null) {
                account = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(account, "BaseApplicationImpl.getA\u2026().runtime?.account ?: \"\"");
            }
            mutableMap.put("uid", account);
            mutableMap.put("perfLevel", String.valueOf(DeviceInfoUtils.getPerfLevel()));
            map = mutableMap;
        }
        ReportMethodProxy.onUserActionToTunnel(MINI_GAME_BEACON_KEY, eventCode, map, false, false);
    }

    public static /* synthetic */ void report$default(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        report(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$1(String eventCode, Map map, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        ReportMethodProxy.onUserActionToTunnel(MINI_GAME_BEACON_KEY, eventCode, map, z16, z17);
    }

    @JvmStatic
    public static final boolean reportSync(String eventCode, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        Intrinsics.checkNotNullParameter(params, "params");
        return ReportMethodProxy.onUserActionToTunnel(MINI_GAME_BEACON_KEY, eventCode, params, false, false);
    }

    @JvmStatic
    public static final void reportToBeacon(String eventName, Map<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        reportMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06A49O0PML4Z");
        VideoReport.reportEvent(eventName, reportMap);
    }

    public static /* synthetic */ void report$default(String str, Map map, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        report(str, map, z16, z17);
    }

    @JvmStatic
    public static final void report(final String eventCode, final Map<String, String> params, final boolean isRealTime, final boolean isImmediatelyUpload) {
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameBeaconReport.report$lambda$1(eventCode, params, isRealTime, isImmediatelyUpload);
                }
            }, 128, null, true);
        } else {
            ReportMethodProxy.onUserActionToTunnel(MINI_GAME_BEACON_KEY, eventCode, params, isRealTime, isImmediatelyUpload);
        }
    }
}
