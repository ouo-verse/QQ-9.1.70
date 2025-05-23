package com.tencent.bugly.common.reporter.upload;

import android.content.Context;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.BuildConfigWrapper;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.ProcessUtil;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J \u0010 \u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/UploadProxy;", "Lcom/tencent/bugly/common/reporter/IReporter;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mAppId", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "checkAttrBeforeReport", "", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "getContext", "getFileUploadUrl", AdMetricTag.Report.TYPE, "", "getJsonUploadUrl", "getMD5Params", "reportFile", "url", "callback", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "reportForVersion1", "reportJson", "reportNow", "", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class UploadProxy implements IReporter {

    @Nullable
    private String mAppId;

    @Nullable
    private Context mContext;

    public UploadProxy(@Nullable Context context, @Nullable String str) {
        this.mContext = context;
        this.mAppId = str;
    }

    private final void checkAttrBeforeReport(ReportData reportData) {
        if (reportData.getParams().has(ReportDataBuilder.KEY_ATTRIBUTES)) {
            Context context = getContext();
            JSONObject jSONObject = reportData.getParams().getJSONObject(ReportDataBuilder.KEY_ATTRIBUTES);
            if (!jSONObject.has("process_name")) {
                jSONObject.put("process_name", ProcessUtil.INSTANCE.getCurrentProcessName(context));
            }
            if (!jSONObject.has(ReportDataBuilder.KEY_64_BIT_FLAG) && context != null) {
                jSONObject.put(ReportDataBuilder.KEY_64_BIT_FLAG, ProcessUtil.INSTANCE.is64BitProcess(context));
            }
        }
    }

    private final Context getContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        return ContextUtil.getGlobalContext();
    }

    private final void reportForVersion1(ReportData reportData, IReporter.ReportCallback callback) {
        boolean z16;
        if (reportData.getUploadFilePath().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            reportJson(reportData, getJsonUploadUrl(reportData.getReportType()) + getMD5Params(reportData), callback);
            return;
        }
        reportFile(reportData, getFileUploadUrl(reportData.getReportType()) + getMD5Params(reportData), callback);
    }

    @NotNull
    public final String getFileUploadUrl(int reportType) {
        if (reportType == 1) {
            return BuildConfigWrapper.getDomain() + "/v1/" + this.mAppId + "/upload-file";
        }
        return "";
    }

    @NotNull
    public final String getJsonUploadUrl(int reportType) {
        if (reportType == 1) {
            return BuildConfigWrapper.getDomain() + "/v1/" + this.mAppId + "/upload-json";
        }
        return "";
    }

    @Nullable
    public final String getMAppId() {
        return this.mAppId;
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final String getMD5Params(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        return "?timestamp=" + System.currentTimeMillis() + "&nonce=" + reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY, "clientidnull");
    }

    public final void reportFile(@NotNull ReportData reportData, @NotNull String url, @Nullable IReporter.ReportCallback callback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        Intrinsics.checkParameterIsNotNull(url, "url");
        new FileUploadRunnable(new URL(url), reportData, new FileUploadCallback(reportData, callback)).request();
    }

    public final void reportJson(@NotNull ReportData reportData, @NotNull String url, @Nullable IReporter.ReportCallback callback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        Intrinsics.checkParameterIsNotNull(url, "url");
        new JsonUploadRunnable(new URL(url), reportData, new FileUploadCallback(reportData, callback)).request();
    }

    @Override // com.tencent.bugly.common.reporter.IReporter
    public boolean reportNow(@NotNull ReportData reportData, @Nullable IReporter.ReportCallback callback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        try {
            checkAttrBeforeReport(reportData);
            if (reportData.getReportType() != 1) {
                return false;
            }
            reportForVersion1(reportData, callback);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public final void setMAppId(@Nullable String str) {
        this.mAppId = str;
    }

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }
}
