package com.tencent.mobileqq.vas.tianshu;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "getTraceInfoOfLastClick", "", "setTraceInfoOfLastClick", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface ITianshuWebManager extends IVasManager {
    @NotNull
    String getTraceInfoOfLastClick();

    void setTraceInfoOfLastClick(@NotNull String traceInfo);
}
