package com.tencent.mobileqq.lightquic;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.lightquic.api.ILightQUICLogListener;
import com.tencent.lightquic.api.LightQUICSDKMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/lightquic/QQLightQUICLogReporter;", "Lcom/tencent/lightquic/api/ILightQUICLogListener;", "()V", "APPKEY", "", "LIGHT_QUIC_SWITCH_ID", "PARAM_ACCOUNT_UIN", "SESSION_REPORT_CODE", "SESSION_SAMPLE", "STREAM_REPORT_CODE", "STREAM_SAMPLE", "isDebugVersion", "", "()Z", "isInitialized", "isSwitchOn", "reportTypeCodes", "", "", "reportTypeSamples", "init", "", "jsonToMap", "jsonStr", "onLog", "level", "message", "onReport", AdMetricTag.Report.TYPE, "reportJson", "shouldReport", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQLightQUICLogReporter implements ILightQUICLogListener {
    private static final String APPKEY = "0AND05WHEN2NOTPG";
    public static final QQLightQUICLogReporter INSTANCE = new QQLightQUICLogReporter();
    private static final String LIGHT_QUIC_SWITCH_ID = "102471";
    private static final String PARAM_ACCOUNT_UIN = "account_uin";
    private static final String SESSION_REPORT_CODE = "light_quic_type_session";
    private static final String SESSION_SAMPLE = "session_sample";
    private static final String STREAM_REPORT_CODE = "light_quic_type_stream";
    private static final String STREAM_SAMPLE = "stream_sample";
    private static volatile boolean isInitialized;
    private static final Map<Integer, String> reportTypeCodes;
    private static final Map<Integer, String> reportTypeSamples;

    static {
        Map<Integer, String> mutableMapOf;
        Map<Integer, String> mutableMapOf2;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(0, SESSION_REPORT_CODE), TuplesKt.to(1, STREAM_REPORT_CODE));
        reportTypeCodes = mutableMapOf;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(0, SESSION_SAMPLE), TuplesKt.to(1, STREAM_SAMPLE));
        reportTypeSamples = mutableMapOf2;
    }

    QQLightQUICLogReporter() {
    }

    private final boolean isDebugVersion() {
        return false;
    }

    private final boolean isSwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(LIGHT_QUIC_SWITCH_ID, false);
    }

    private final Map<String, String> jsonToMap(String jsonStr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(jsonStr);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object opt = jSONObject.opt(key);
            if (opt != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, opt.toString());
            }
        }
        return linkedHashMap;
    }

    private final boolean shouldReport(int reportType) {
        if (!isSwitchOn()) {
            return false;
        }
        try {
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(LIGHT_QUIC_SWITCH_ID, new byte[0]);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(loadRawConfig, UTF_8));
            String str = reportTypeSamples.get(Integer.valueOf(reportType));
            if (str == null) {
                return false;
            }
            double optDouble = jSONObject.optDouble(str, 0.0d);
            double random = Math.random();
            if (isDebugVersion()) {
                QLog.d(ILightQUICApi.TAG, 4, str + " is " + optDouble + ", random is " + random);
            }
            return random <= optDouble;
        } catch (Exception e16) {
            if (isDebugVersion()) {
                throw new IllegalStateException(e16);
            }
            return false;
        }
    }

    public final void init() {
        if (isInitialized) {
            return;
        }
        try {
            LightQUICSDKMgr.INSTANCE.setLogListener(isDebugVersion() ? -1 : 0, this);
            QLog.i(ILightQUICApi.TAG, 1, "init.");
            isInitialized = true;
        } catch (Throwable th5) {
            QLog.e(ILightQUICApi.TAG, 1, "setLogListener err, " + th5.getMessage());
        }
    }

    @Override // com.tencent.lightquic.api.ILightQUICLogListener
    public void onLog(int level, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (level == 1) {
            QLog.w(ILightQUICApi.TAG, 1, message);
        } else if (level >= 2) {
            QLog.e(ILightQUICApi.TAG, 1, message);
        } else if (QLog.isColorLevel()) {
            QLog.i(ILightQUICApi.TAG, 2, message);
        }
    }

    @Override // com.tencent.lightquic.api.ILightQUICLogListener
    public void onReport(int reportType, String reportJson) {
        String currentAccountUin;
        Intrinsics.checkNotNullParameter(reportJson, "reportJson");
        if (!shouldReport(reportType)) {
            if (isDebugVersion()) {
                QLog.d(ILightQUICApi.TAG, 1, "onReport, ignore, " + isSwitchOn());
                return;
            }
            return;
        }
        String str = reportTypeCodes.get(Integer.valueOf(reportType));
        if (str == null) {
            return;
        }
        try {
            Map<String, String> jsonToMap = jsonToMap(reportJson);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (currentAccountUin = peekAppRuntime.getCurrentAccountUin()) != null) {
                jsonToMap.put(PARAM_ACCOUNT_UIN, currentAccountUin);
            }
            if (isDebugVersion()) {
                QLog.d(ILightQUICApi.TAG, 4, "+++++[\u706f\u5854\u4e0a\u62a5][code]+++++[" + str + "]");
            }
            BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey("0AND05WHEN2NOTPG").withCode(str).withParams(jsonToMap).build());
        } catch (Exception e16) {
            QLog.e(ILightQUICApi.TAG, 1, "jsonToMap err, " + e16.getMessage());
        }
    }
}
