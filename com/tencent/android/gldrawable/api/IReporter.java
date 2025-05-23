package com.tencent.android.gldrawable.api;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/gldrawable/api/IReporter;", "", "logE", "", ReportConstant.COSTREPORT_PREFIX, "", "e", "", "logI", "report", "event", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "statusMsg", "elapse", "", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface IReporter {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void report$default(IReporter iReporter, String str, String str2, String str3, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    j3 = 0;
                }
                iReporter.report(str, str2, str3, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: report");
        }
    }

    void logE(@NotNull String s16);

    void logE(@NotNull String s16, @NotNull Throwable e16);

    void logI(@NotNull String s16);

    void report(@NotNull String event, @NotNull String statusCode, @NotNull String statusMsg, long elapse);
}
