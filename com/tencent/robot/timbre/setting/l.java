package com.tencent.robot.timbre.setting;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/timbre/setting/l;", "", "Landroid/view/View;", "target", "", "currentTimbre", "", "d", "e", "timbreId", "pickTimbreId", "b", "c", "initialSelectedTtsId", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f368635a = new l();

    l() {
    }

    public final void a(@NotNull View target, @NotNull String initialSelectedTtsId, @NotNull String timbreId) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(initialSelectedTtsId, "initialSelectedTtsId");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        VideoReport.setPageParams(target, "current_timbre", initialSelectedTtsId);
        VideoReport.setPageId(target, "pg_bas_select_timbre");
        VideoReport.setElementClickPolicy(target, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(target, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("eid", "em_bas_timbre_articles");
        hashMap.put("timbre_id", timbreId);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("clck", target, hashMap);
    }

    public final void b(@NotNull View target, @NotNull String timbreId, @NotNull String pickTimbreId) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        Intrinsics.checkNotNullParameter(pickTimbreId, "pickTimbreId");
        VideoReport.setPageId(target, "pg_bas_select_timbre");
        VideoReport.setPageParams(target, "current_timbre", pickTimbreId);
        VideoReport.setElementClickPolicy(target, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(target, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("eid", "em_bas_timbre_articles");
        hashMap.put("timbre_id", timbreId);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("imp", target, hashMap);
    }

    public final void c(@NotNull View target, @NotNull String timbreId, @NotNull String pickTimbreId) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        Intrinsics.checkNotNullParameter(pickTimbreId, "pickTimbreId");
        VideoReport.setPageId(target, "pg_bas_select_timbre");
        VideoReport.setPageParams(target, "current_timbre", pickTimbreId);
        VideoReport.setElementClickPolicy(target, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(target, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("eid", "em_bas_timbre_articles");
        hashMap.put("timbre_id", timbreId);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("imp_end", target, hashMap);
    }

    public final void d(@NotNull View target, @NotNull String currentTimbre) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(currentTimbre, "currentTimbre");
        VideoReport.setPageId(target, "pg_bas_select_timbre");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("current_timbre", currentTimbre);
        VideoReport.setPageParams(target, new PageParams(hashMap));
        VideoReport.reportPgIn(target, false);
    }

    public final void e(@NotNull View target, @NotNull String currentTimbre) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(currentTimbre, "currentTimbre");
        VideoReport.setPageId(target, "pg_bas_select_timbre");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("current_timbre", currentTimbre);
        VideoReport.setPageParams(target, new PageParams(hashMap));
        VideoReport.reportPgOut(target);
    }
}
