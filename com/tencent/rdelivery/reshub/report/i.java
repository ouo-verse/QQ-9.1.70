package com.tencent.rdelivery.reshub.report;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "Lcom/tencent/rdelivery/reshub/report/j;", "a", "Ljava/util/List;", "STAGE_REPORT_INFOS", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final List<StageReportInfo> f364576a;

    static {
        List<StageReportInfo> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new StageReportInfo[]{new StageReportInfo(0, 1, "rscfg"), new StageReportInfo(2, 4, "dl_diff"), new StageReportInfo(5, 7, "dl_total"), new StageReportInfo(12, 14, "dl_comp"), new StageReportInfo(15, 16, "comp_unz"), new StageReportInfo(10, 11, "decrypt"), new StageReportInfo(8, 9, "unz")});
        f364576a = listOf;
    }
}
