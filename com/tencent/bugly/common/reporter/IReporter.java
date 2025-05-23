package com.tencent.bugly.common.reporter;

import com.tencent.bugly.common.reporter.data.ReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/bugly/common/reporter/IReporter;", "", "reportNow", "", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "callback", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "ReportCallback", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface IReporter {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean reportNow$default(IReporter iReporter, ReportData reportData, ReportCallback reportCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    reportCallback = null;
                }
                return iReporter.reportNow(reportData, reportCallback);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportNow");
        }
    }

    boolean reportNow(@NotNull ReportData reportData, @Nullable ReportCallback callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "", "onCached", "", "onFailure", "errorCode", "", "errorMsg", "", "dbId", "contentLength", "onSuccess", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public interface ReportCallback {
        void onCached();

        void onFailure(int errorCode, @NotNull String errorMsg, int dbId, int contentLength);

        void onSuccess(int dbId, int contentLength);

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
        /* loaded from: classes5.dex */
        public static final class DefaultImpls {
            public static void onCached(ReportCallback reportCallback) {
            }
        }
    }
}
