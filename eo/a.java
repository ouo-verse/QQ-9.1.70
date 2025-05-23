package eo;

import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import kotlin.Metadata;
import lg.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Leo/a;", "", "", "pageId", "", "durationInMillis", QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "", "e", "subActionType", "d", "c", "actionType", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396875a = new a();

    a() {
    }

    public final void a(int actionType, int subActionType) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = actionType;
        lpReportInfo_pf00064.subactionType = subActionType;
        lpReportInfo_pf00064.reserves = 2;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false);
    }

    public final void b(int actionType, int subActionType) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = actionType;
        lpReportInfo_pf00064.subactionType = subActionType;
        lpReportInfo_pf00064.reserves = 1;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false);
    }

    public final void e(int pageId, long durationInMillis, int feedCount) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = pageId;
        lpReportInfo_pf00064.subactionType = 1;
        lpReportInfo_pf00064.reserves3 = String.valueOf((durationInMillis + 500) / 1000);
        lpReportInfo_pf00064.reserves4 = String.valueOf(feedCount);
        lpReportInfo_pf00064.reserves5 = String.valueOf(System.currentTimeMillis());
        lpReportInfo_pf00064.reserves7 = g.f414459a.c();
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false);
    }

    public final void c(int subActionType) {
        a(gdt_analysis_event.EVENT_MOTIVE_CLOSE, subActionType);
    }

    public final void d(int subActionType) {
        b(gdt_analysis_event.EVENT_MOTIVE_CLOSE, subActionType);
    }
}
