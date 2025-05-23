package com.tencent.bugly.common.reporter.upload;

import android.net.http.Headers;
import android.text.TextUtils;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.reporter.upload.UploadEncrypt;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ4\u0010\t\u001a\u00020\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\rH\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/JsonUploadRunnable;", "Lcom/tencent/bugly/common/reporter/upload/ReporterUpload;", "url", "Ljava/net/URL;", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "callback", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "(Ljava/net/URL;Lcom/tencent/bugly/common/reporter/data/ReportData;Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;)V", "buildHeader", "", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "encryptKey", Const.BUNDLE_KEY_REQUEST, JobDbManager.TBL_UPLOAD, "", Headers.CONN_DIRECTIVE, "Ljava/net/HttpURLConnection;", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class JsonUploadRunnable extends ReporterUpload {

    @NotNull
    public static final String TAG = "RMonitor_report_Json";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonUploadRunnable(@NotNull URL url, @NotNull ReportData reportData, @Nullable IReporter.ReportCallback reportCallback) {
        super(url, reportData, reportCallback);
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
    }

    private final void buildHeader(HashMap<String, String> headers, String encryptKey) {
        headers.put("Content-Encoding", "gzip, encrypt");
        if (getReportData().getReportType() == 1) {
            headers.put("Content-Type", "application/json");
        }
        headers.put("X-ENCRYPTION-KEY", encryptKey);
        headers.put("X-ENCRYPTION-VERSION", UploadEncrypt.INSTANCE.getEncryptVersion());
    }

    private final int upload(HttpURLConnection connection, String encryptKey) {
        if (connection != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    String jSONObject = getReportData().getParams().toString();
                    Intrinsics.checkExpressionValueIsNotNull(jSONObject, "reportData.params.toString()");
                    Charset forName = Charset.forName("utf-8");
                    Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                    if (jSONObject != null) {
                        byte[] bytes = jSONObject.getBytes(forName);
                        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.finish();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(gZIPOutputStream, null);
                        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                        try {
                            UploadEncrypt.Companion companion = UploadEncrypt.INSTANCE;
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            Intrinsics.checkExpressionValueIsNotNull(byteArray, "byteOutputStream.toByteArray()");
                            dataOutputStream.write(companion.doUploadEncrypt(byteArray, encryptKey));
                            int size = dataOutputStream.size();
                            CloseableKt.closeFinally(dataOutputStream, null);
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            dealResp(readResp(TAG, connection), connection.getResponseCode(), size);
                            return size;
                        } finally {
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(byteArrayOutputStream, th5);
                    throw th6;
                }
            }
        } else {
            return 0;
        }
    }

    @Override // com.tencent.bugly.common.reporter.upload.BaseUpload
    public void request() {
        String str = "";
        if (whetherBlock()) {
            IReporter.ReportCallback callback = getCallback();
            if (callback != null) {
                callback.onSuccess(getReportData().getDbId(), 0);
                return;
            }
            return;
        }
        if (!NetworkWatcher.INSTANCE.isNetworkConnectedRealtime()) {
            IReporter.ReportCallback callback2 = getCallback();
            if (callback2 != null) {
                callback2.onFailure(602, "network not available", getReportData().getDbId(), 0);
                return;
            }
            return;
        }
        PluginLinkDataProxy.getInstance().collectPluginLinkData(getReportData().getParams());
        HashMap<String, String> hashMap = new HashMap<>();
        String createEncryptKey = UploadEncrypt.INSTANCE.createEncryptKey();
        buildHeader(hashMap, createEncryptKey);
        if (Logger.verbos) {
            Object opt = getReportData().getParams().opt(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
            String eventName = getReportData().getEventName();
            if (TextUtils.isEmpty(eventName)) {
                eventName = getReportData().getParams().optString("sub_type");
                Intrinsics.checkExpressionValueIsNotNull(eventName, "reportData.params.optString(\"sub_type\")");
            }
            Logger.f365497g.v(TAG, "url: " + getUrl() + ", eventName: " + eventName + ", client_identify: " + opt);
        }
        HttpURLConnection connectionBuilder = connectionBuilder(hashMap, getReportData().getReportStrategy().getConnectTimeout(), getReportData().getReportStrategy().getReadTimeout());
        try {
            try {
                try {
                    try {
                        upload(connectionBuilder, createEncryptKey);
                        if (connectionBuilder == null) {
                            return;
                        }
                    } catch (Throwable th5) {
                        Logger.f365497g.e(TAG, getReportData().getEventName(), th5.toString());
                        IReporter.ReportCallback callback3 = getCallback();
                        if (callback3 != null) {
                            String message = th5.getMessage();
                            if (message != null) {
                                str = message;
                            }
                            callback3.onFailure(700, str, getReportData().getDbId(), 0);
                        }
                        if (connectionBuilder == null) {
                            return;
                        }
                    }
                } catch (Exception e16) {
                    Logger.f365497g.e(TAG, getReportData().getEventName(), e16.toString());
                    IReporter.ReportCallback callback4 = getCallback();
                    if (callback4 != null) {
                        String message2 = e16.getMessage();
                        if (message2 != null) {
                            str = message2;
                        }
                        callback4.onFailure(603, str, getReportData().getDbId(), 0);
                    }
                    if (connectionBuilder == null) {
                        return;
                    }
                }
            } catch (OutOfMemoryError unused) {
                IReporter.ReportCallback callback5 = getCallback();
                if (callback5 != null) {
                    callback5.onFailure(600, "OutOfMemoryError", getReportData().getDbId(), 0);
                }
                if (connectionBuilder == null) {
                    return;
                }
            }
            connectionBuilder.disconnect();
        } catch (Throwable th6) {
            if (connectionBuilder != null) {
                connectionBuilder.disconnect();
            }
            throw th6;
        }
    }
}
