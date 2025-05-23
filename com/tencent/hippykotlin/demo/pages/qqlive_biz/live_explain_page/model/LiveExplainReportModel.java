package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveExplainReportModel {
    public ExplainBubbleInfo bubbleInfo;
    public final int isHRC;
    public e pageDataParams;
    public String pagerId;

    public LiveExplainReportModel(String str, e eVar, int i3) {
        this.pagerId = str;
        this.pageDataParams = eVar;
        this.isHRC = i3;
    }

    public static final void access$reportDT(LiveExplainReportModel liveExplainReportModel, String str, e eVar) {
        liveExplainReportModel.getClass();
        e eVar2 = new e();
        eVar2.t("params_report_is_hrc", liveExplainReportModel.isHRC);
        eVar2.t("bus_id", 8);
        eVar2.u("viewer_uin", liveExplainReportModel.pageDataParams.n("viewer_uin"));
        eVar2.u("author_uin", liveExplainReportModel.pageDataParams.n("author_uin"));
        eVar2.u(AudienceReportConst.ROOM_ID, liveExplainReportModel.pageDataParams.n("roomID"));
        eVar2.v("program_id", liveExplainReportModel.pageDataParams.p("program_id"));
        eVar2.t("live_type", liveExplainReportModel.pageDataParams.j("live_type") == 1 ? 2 : 1);
        if (liveExplainReportModel.getBubbleInfo().reportInfo != null) {
            e eVar3 = liveExplainReportModel.getBubbleInfo().reportInfo;
            Intrinsics.checkNotNull(eVar3);
            Iterator<String> c16 = eVar3.c();
            while (c16.hasNext()) {
                String next = c16.next();
                e eVar4 = liveExplainReportModel.getBubbleInfo().reportInfo;
                Intrinsics.checkNotNull(eVar4);
                eVar2.v(next, eVar4.p(next));
            }
        }
        Iterator<String> c17 = eVar.c();
        while (c17.hasNext()) {
            String next2 = c17.next();
            eVar2.v(next2, eVar.p(next2));
        }
        Utils.INSTANCE.bridgeModule(liveExplainReportModel.pagerId).reportDT(str, eVar2);
    }

    public final ExplainBubbleInfo getBubbleInfo() {
        ExplainBubbleInfo explainBubbleInfo = this.bubbleInfo;
        if (explainBubbleInfo != null) {
            return explainBubbleInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bubbleInfo");
        return null;
    }

    public final void reportExplainBubbleExpDuration(final int i3) {
        Utils.INSTANCE.bridgeModule(this.pagerId).localServeTime(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model.LiveExplainReportModel$reportExplainBubbleExpDuration$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                Intrinsics.checkNotNull(eVar2);
                LiveExplainReportModel.access$reportDT(this, "ds_live_goods_card_exp_duration", new e().t("duration", ((int) eVar2.h("time")) - i3));
                return Unit.INSTANCE;
            }
        });
    }

    public final e vrBindParams(ExplainBubbleInfo explainBubbleInfo) {
        e eVar = new e();
        eVar.t("params_report_is_hrc", this.isHRC);
        if ((explainBubbleInfo != null ? explainBubbleInfo.reportInfo : null) != null) {
            e eVar2 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar2);
            eVar.v("qqlive_commodity_name", eVar2.p("product_name"));
            e eVar3 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar3);
            eVar.v("qqlive_commodity_price", eVar3.p("product_price"));
            e eVar4 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar4);
            eVar.v("qqlive_product_point_words", eVar4.p("product_point_words"));
            e eVar5 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar5);
            eVar.v("qqlive_product_state", eVar5.p("product_state"));
            e eVar6 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar6);
            eVar.v("qqlive_item_id", eVar6.p(ReportDataBuilder.KEY_PRODUCT_ID));
            e eVar7 = explainBubbleInfo.reportInfo;
            Intrinsics.checkNotNull(eVar7);
            eVar.v("qqlive_product_type", eVar7.p("product_type"));
            eVar.t("qqlive_activity_product", explainBubbleInfo.activity != null ? 1 : 0);
            ExplainActivity explainActivity = explainBubbleInfo.activity;
            if (explainActivity != null) {
                Intrinsics.checkNotNull(explainActivity);
                eVar.t("qqlive_activity_status", explainActivity.status);
            }
        }
        return eVar;
    }
}
