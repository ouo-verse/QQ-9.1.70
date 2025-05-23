package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiImageVideoTemplateView$Companion$setupJumpEvent$1 extends Lambda implements Function1<Event, Unit> {
    public final /* synthetic */ QSearchMultiImageVideoTemplateView $ctx;
    public final /* synthetic */ QSearchJump $jumpLink;
    public final /* synthetic */ QSearchTemplateReportInfo $reportInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchMultiImageVideoTemplateView$Companion$setupJumpEvent$1(QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView, QSearchJump qSearchJump, QSearchTemplateReportInfo qSearchTemplateReportInfo) {
        super(1);
        this.$ctx = qSearchMultiImageVideoTemplateView;
        this.$jumpLink = qSearchJump;
        this.$reportInfo = qSearchTemplateReportInfo;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Event event) {
        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView = this.$ctx;
        final QSearchJump qSearchJump = this.$jumpLink;
        final QSearchTemplateReportInfo qSearchTemplateReportInfo = this.$reportInfo;
        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$Companion$setupJumpEvent$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, qSearchJump);
                QSearchTemplateReportInfo qSearchTemplateReportInfo2 = qSearchTemplateReportInfo;
                if (qSearchTemplateReportInfo2 != null) {
                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = QSearchMultiImageVideoTemplateView.this;
                    QSearchMultiImageVideoTemplateView.access$reportClickDtEvent(qSearchMultiImageVideoTemplateView2, qSearchTemplateReportInfo2.eid, qSearchTemplateReportInfo2.getReportParams(qSearchMultiImageVideoTemplateView2.getTemplateCardReportInfo()));
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
