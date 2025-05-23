package com.tencent.rmonitor.sla;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.GlobalConfig;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.upload.QAPMUpload;
import com.tencent.bugly.common.utils.StringUtil;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.raft.measure.report.ATTAReporter;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u0007B\u001d\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J$\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0006\u0010\u0016\u001a\u00020\u0015R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/rmonitor/sla/AttaEventReportTask;", "Lcom/tencent/bugly/common/reporter/upload/QAPMUpload;", "Ljava/lang/Runnable;", "", "Lcom/tencent/rmonitor/sla/c;", "eventList", "", "a", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "key", "value", "", "b", "", "timeInMillis", "d", "c", Const.BUNDLE_KEY_REQUEST, TencentLocation.RUN_MODE, "", "g", "Ljava/util/List;", "Ljava/net/URL;", "url", "<init>", "(Ljava/net/URL;Ljava/util/List;)V", "f", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AttaEventReportTask extends QAPMUpload implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<AttaEvent> eventList;

    /* renamed from: e, reason: collision with root package name */
    private static final SimpleDateFormat f365809e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttaEventReportTask(@NotNull URL url, @NotNull List<AttaEvent> eventList) {
        super(url);
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(eventList, "eventList");
        this.eventList = eventList;
    }

    private final String a(List<AttaEvent> eventList) {
        if (eventList.isEmpty()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(300);
        JSONArray jSONArray = new JSONArray();
        for (AttaEvent attaEvent : eventList) {
            sb5.setLength(0);
            b(sb5, "app_version", c(attaEvent.getAppVersion()));
            b(sb5, "app_name", c(attaEvent.getAppName()));
            b(sb5, "app_bundle_id", c(attaEvent.getAppBundleId()));
            b(sb5, "app_key", c(attaEvent.getAppKey()));
            b(sb5, AudienceReportConst.CLIENT_TYPE, attaEvent.getClientType());
            b(sb5, "user_id", c(attaEvent.getUserId()));
            b(sb5, "sdk_version", attaEvent.getSdkVersion());
            b(sb5, "event_code", attaEvent.getEventCode());
            b(sb5, "event_result", String.valueOf(attaEvent.getEventResult()));
            b(sb5, "event_time", d(attaEvent.getEventTime()));
            b(sb5, "event_cost", String.valueOf(attaEvent.getEventCost()));
            b(sb5, "error_code", String.valueOf(attaEvent.getErrorCode()));
            b(sb5, s4.c.UPLOAD_TIME, d(attaEvent.getUploadTime()));
            b(sb5, "device_id", c(attaEvent.getDeviceId()));
            b(sb5, "os_version", c(attaEvent.getOsVersion()));
            b(sb5, "manufacturer", c(attaEvent.getManufacturer()));
            b(sb5, "model", c(attaEvent.getModel()));
            b(sb5, "debug", String.valueOf(attaEvent.getDebug()));
            b(sb5, ReportDataBuilder.KEY_PRODUCT_ID, c(attaEvent.getProductId()));
            b(sb5, ReportDataBuilder.KEY_FULL_OS_VERSION, c(attaEvent.getFullOSVersion()));
            b(sb5, "param_0", c(attaEvent.getParam0()));
            b(sb5, "param_1", c(attaEvent.getParam1()));
            b(sb5, "param_2", c(attaEvent.getParam2()));
            b(sb5, "param_3", c(attaEvent.getParam3()));
            b(sb5, "param_4", c(attaEvent.getParam4()));
            b(sb5, "param_5", c(attaEvent.getParam5()));
            b(sb5, "param_6", c(attaEvent.getParam6()));
            b(sb5, "param_7", c(attaEvent.getParam7()));
            b(sb5, "param_8", c(attaEvent.getParam8()));
            b(sb5, "param_9", c(attaEvent.getParam9()));
            b(sb5, "param_10", c(attaEvent.getParam10()));
            b(sb5, "param_11", c(attaEvent.getParam11()));
            b(sb5, "param_12", c(attaEvent.getParam12()));
            b(sb5, "param_13", c(attaEvent.getParam13()));
            jSONArray.mo162put(sb5.toString());
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "08e00055686");
            jSONObject.put("token", "8666841551");
            jSONObject.put("type", "batch");
            jSONObject.put("version", "v1.0.0");
            jSONObject.put("datas", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e16) {
            Logger.f365497g.c("RMonitor_sla_AttaEventReportTask", e16);
            return null;
        }
    }

    private final void b(StringBuilder builder, String key, String value) {
        boolean z16;
        if (TextUtils.isEmpty(value)) {
            return;
        }
        if (builder.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            builder.append(key);
            builder.append(ContainerUtils.KEY_VALUE_DELIMITER);
            builder.append(value);
        } else {
            builder.append(ContainerUtils.FIELD_DELIMITER);
            builder.append(key);
            builder.append(ContainerUtils.KEY_VALUE_DELIMITER);
            builder.append(value);
        }
    }

    private final String c(String value) {
        String replace$default;
        if (value != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(value, "$", "\\$", false, 4, (Object) null);
            return StringUtil.encode(replace$default);
        }
        return "";
    }

    private final String d(long timeInMillis) {
        try {
            String format = f365809e.format(new Date(timeInMillis));
            Intrinsics.checkExpressionValueIsNotNull(format, "TIME_FORMAT.format(date)");
            return format;
        } catch (Throwable th5) {
            String valueOf = String.valueOf(timeInMillis);
            Logger logger = Logger.f365497g;
            String[] strArr = new String[3];
            strArr[0] = "RMonitor_sla_AttaEventReportTask";
            strArr[1] = "getFormatTime";
            String message = th5.getMessage();
            if (message == null) {
                Intrinsics.throwNpe();
            }
            strArr[2] = message;
            logger.e(strArr);
            return valueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0157, code lost:
    
        if (r4 != null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g() {
        boolean z16;
        boolean z17 = false;
        if (GlobalConfig.isInStandaloneMode()) {
            Logger.f365497g.w("RMonitor_sla_AttaEventReportTask", "report atta event fail for app in standalone mode.");
            return false;
        }
        if (this.eventList.isEmpty()) {
            Logger.f365497g.i("RMonitor_sla_AttaEventReportTask", "event list is empty");
            return false;
        }
        if (!NetworkWatcher.INSTANCE.isNetworkConnectedRealtime()) {
            Logger.f365497g.i("RMonitor_sla_AttaEventReportTask", "network not available");
            return false;
        }
        Logger logger = Logger.f365497g;
        logger.d("RMonitor_sla_AttaEventReportTask", "atta report url: " + getUrl());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put(ATTAReporter.ATTA_TYPE, ATTAReporter.BATCH_REPORT);
        HttpURLConnection connectionBuilder$default = QAPMUpload.connectionBuilder$default(this, hashMap, 0, 0, 6, null);
        if (connectionBuilder$default != null) {
            try {
                String a16 = a(this.eventList);
                logger.d("RMonitor_sla_AttaEventReportTask", "atta report data:" + a16);
                if (a16 != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(connectionBuilder$default.getOutputStream());
                    try {
                        Charset forName = Charset.forName("utf-8");
                        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                        byte[] bytes = a16.getBytes(forName);
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        dataOutputStream.write(bytes);
                        dataOutputStream.flush();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(dataOutputStream, null);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(connectionBuilder$default.getInputStream());
                        try {
                            String m3 = FileUtil.INSTANCE.m(bufferedInputStream, 8192);
                            CloseableKt.closeFinally(bufferedInputStream, null);
                            int responseCode = connectionBuilder$default.getResponseCode();
                            String headerField = connectionBuilder$default.getHeaderField("Content-Type");
                            if (responseCode == 200) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            logger.d("RMonitor_sla_AttaEventReportTask", "atta report respCode: " + responseCode + ", contentLen: " + a16.length() + ", contentType: " + headerField + ", body: " + m3);
                            z17 = z16;
                        } finally {
                        }
                    } finally {
                    }
                }
            } finally {
                try {
                    return z17;
                } finally {
                }
            }
        }
    }

    @Override // com.tencent.bugly.common.reporter.upload.BaseUpload
    public void request() {
        g();
    }

    @Override // java.lang.Runnable
    public void run() {
        g();
    }
}
