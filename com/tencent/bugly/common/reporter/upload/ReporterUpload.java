package com.tencent.bugly.common.reporter.upload;

import android.net.http.Headers;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.utils.FileUtil;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J%\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/ReporterUpload;", "Lcom/tencent/bugly/common/reporter/upload/QAPMUpload;", "url", "Ljava/net/URL;", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "callback", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "(Ljava/net/URL;Lcom/tencent/bugly/common/reporter/data/ReportData;Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;)V", "getCallback", "()Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "getReportData", "()Lcom/tencent/bugly/common/reporter/data/ReportData;", "dealEntranceResponse", "", "resp", "", "dealResp", AdMetricTag.RESPONSE_CODE, "", "contentLength", "(Ljava/lang/String;II)Lkotlin/Unit;", "getRetCode", "isSucceeded", "", "readResp", "tag", Headers.CONN_DIRECTIVE, "Ljava/net/HttpURLConnection;", "whetherBlock", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public abstract class ReporterUpload extends QAPMUpload {
    public static final int BUFFER_SIZE = 8192;
    public static final int STATUS_0 = 0;
    public static final int STATUS_JSON_ERROR = -1;

    @NotNull
    public static final String TAG = "Bugly_RUpload";

    @Nullable
    private final IReporter.ReportCallback callback;

    @NotNull
    private final ReportData reportData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReporterUpload(@NotNull URL url, @NotNull ReportData reportData, @Nullable IReporter.ReportCallback reportCallback) {
        super(url);
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.reportData = reportData;
        this.callback = reportCallback;
    }

    private final void dealEntranceResponse(String resp) {
        try {
            EntranceResponseProcessor.onEntranceResponse(this.reportData.getParams().optString(ReportDataBuilder.KEY_BASE_TYPE, ""), this.reportData.getParams().optString("sub_type", ""), new JSONObject(resp));
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, th5 + ": response parameter json error in deal resp.");
        }
    }

    private final int getRetCode(String resp) {
        try {
            return new JSONObject(resp).getInt("code");
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, th5 + ": response parameter json error in get ret code.");
            return -1;
        }
    }

    @Nullable
    public final Unit dealResp(@NotNull String resp, int responseCode, int contentLength) {
        Intrinsics.checkParameterIsNotNull(resp, "resp");
        if (isSucceeded(resp)) {
            dealEntranceResponse(resp);
            IReporter.ReportCallback reportCallback = this.callback;
            if (reportCallback == null) {
                return null;
            }
            reportCallback.onSuccess(this.reportData.getDbId(), contentLength);
            return Unit.INSTANCE;
        }
        IReporter.ReportCallback reportCallback2 = this.callback;
        if (reportCallback2 == null) {
            return null;
        }
        reportCallback2.onFailure(responseCode, resp, this.reportData.getDbId(), contentLength);
        return Unit.INSTANCE;
    }

    @Nullable
    public final IReporter.ReportCallback getCallback() {
        return this.callback;
    }

    @NotNull
    public final ReportData getReportData() {
        return this.reportData;
    }

    public final boolean isSucceeded(@NotNull String resp) {
        Intrinsics.checkParameterIsNotNull(resp, "resp");
        if (TextUtils.isEmpty(resp) || getRetCode(resp) == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String readResp(@NotNull String tag, @NotNull HttpURLConnection connection) {
        InputStream inputStream;
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        if (connection.getResponseCode() >= 400) {
            inputStream = connection.getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }
        String readStream = FileUtil.INSTANCE.readStream(new BufferedInputStream(inputStream), 8192);
        if (connection.getResponseCode() != 200) {
            Logger.f365497g.w(tag, "responseCode:" + connection.getResponseCode() + " resp: " + readStream);
        }
        return readStream;
    }

    public final boolean whetherBlock() {
        try {
            return EntranceResponseProcessor.whetherBlockReport(this.reportData.getParams().optString(ReportDataBuilder.KEY_BASE_TYPE, ""), this.reportData.getParams().optString("sub_type", ""));
        } catch (Throwable unused) {
            return false;
        }
    }
}
