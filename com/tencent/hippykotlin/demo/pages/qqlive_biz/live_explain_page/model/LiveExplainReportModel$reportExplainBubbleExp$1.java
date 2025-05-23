package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainReportModel$reportExplainBubbleExp$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ int $enterTime;
    public final /* synthetic */ LiveExplainReportModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveExplainReportModel$reportExplainBubbleExp$1(int i3, LiveExplainReportModel liveExplainReportModel) {
        super(1);
        this.$enterTime = i3;
        this.this$0 = liveExplainReportModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        Intrinsics.checkNotNull(eVar2);
        LiveExplainReportModel.access$reportDT(this.this$0, "ds_live_goods_card_exp", new e().t("exp_time", ((int) eVar2.h("time")) - this.$enterTime));
        return Unit.INSTANCE;
    }
}
