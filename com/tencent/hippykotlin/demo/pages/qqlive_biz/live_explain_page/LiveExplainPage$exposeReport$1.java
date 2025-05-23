package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel;
import com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel$reportExplainBubbleExp$1;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class LiveExplainPage$exposeReport$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ LiveExplainPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveExplainPage$exposeReport$1(LiveExplainPage liveExplainPage) {
        super(1);
        this.this$0 = liveExplainPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        Intrinsics.checkNotNull(eVar2);
        int h16 = (int) eVar2.h("time");
        LiveExplainPageAttr liveExplainPageAttr = this.this$0.pageAttr;
        liveExplainPageAttr.explainViewExposeTime = h16;
        LiveExplainReportModel liveExplainReportModel = liveExplainPageAttr.reportModel;
        if (liveExplainReportModel != null) {
            Utils.INSTANCE.bridgeModule(liveExplainReportModel.pagerId).localServeTime(new LiveExplainReportModel$reportExplainBubbleExp$1(liveExplainPageAttr.enterRoomTime, liveExplainReportModel));
        }
        return Unit.INSTANCE;
    }
}
