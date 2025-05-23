package com.tencent.bugly.common.reporter.upload;

import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.data.ReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/FileUploadCallback;", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "callback", "(Lcom/tencent/bugly/common/reporter/data/ReportData;Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;)V", "getCallback", "()Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "getReportData", "()Lcom/tencent/bugly/common/reporter/data/ReportData;", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "contentLength", "onSuccess", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class FileUploadCallback implements IReporter.ReportCallback {

    @Nullable
    private final IReporter.ReportCallback callback;

    @NotNull
    private final ReportData reportData;

    public FileUploadCallback(@NotNull ReportData reportData, @Nullable IReporter.ReportCallback reportCallback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.reportData = reportData;
        this.callback = reportCallback;
    }

    @Nullable
    public final IReporter.ReportCallback getCallback() {
        return this.callback;
    }

    @NotNull
    public final ReportData getReportData() {
        return this.reportData;
    }

    @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
    public void onCached() {
        IReporter.ReportCallback.DefaultImpls.onCached(this);
    }

    @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
    public void onFailure(int errorCode, @NotNull String errorMsg, int dbId, int contentLength) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        IReporter.ReportCallback reportCallback = this.callback;
        if (reportCallback != null) {
            reportCallback.onFailure(errorCode, errorMsg, dbId, contentLength);
        }
        this.reportData.checkAndDelFiles(false);
    }

    @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
    public void onSuccess(int dbId, int contentLength) {
        IReporter.ReportCallback reportCallback = this.callback;
        if (reportCallback != null) {
            reportCallback.onSuccess(dbId, contentLength);
        }
        this.reportData.checkAndDelFiles(true);
    }
}
