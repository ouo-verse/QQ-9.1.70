package com.tencent.mobileqq.activity.selectable;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u001a*\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u001a*\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u000e"}, d2 = {"Landroid/view/View;", "target", "", "pg", "", "", "params", "", "c", "d", "pgId", "elementId", "a", "b", "base_proj_nt_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {
    public static final void a(String pgId, String elementId, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(params, "params");
        params.put("dt_eid", elementId);
        params.put("dt_pgid", pgId);
        VideoReport.reportEvent("dt_clck", params);
    }

    public static final void b(String pgId, String elementId, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(params, "params");
        params.put("dt_eid", elementId);
        params.put("dt_pgid", pgId);
        VideoReport.reportEvent("dt_imp", params);
    }

    public static final void c(View target, String pg5, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pg5, "pg");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.setPageId(target, pg5);
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_PGIN);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) params));
        VideoReport.reportPgIn(target);
    }

    public static final void d(View target, String pg5, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pg5, "pg");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.setPageId(target, pg5);
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_PGOUT);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) params));
        VideoReport.reportPgOut(target);
    }
}
