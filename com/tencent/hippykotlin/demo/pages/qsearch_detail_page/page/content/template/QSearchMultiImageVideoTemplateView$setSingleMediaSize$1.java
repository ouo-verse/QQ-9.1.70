package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaAttr;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiImageVideoTemplateView$setSingleMediaSize$1 extends Lambda implements Function1<QSearchSingleMediaAttr, Unit> {
    public final /* synthetic */ QSearchMultiMediaInfo $singleMediaInfo;
    public final /* synthetic */ QSearchMultiImageVideoTemplateView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchMultiImageVideoTemplateView$setSingleMediaSize$1(QSearchMultiMediaInfo qSearchMultiMediaInfo, QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView) {
        super(1);
        this.$singleMediaInfo = qSearchMultiMediaInfo;
        this.this$0 = qSearchMultiImageVideoTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(QSearchSingleMediaAttr qSearchSingleMediaAttr) {
        QSearchSingleMediaAttr qSearchSingleMediaAttr2 = qSearchSingleMediaAttr;
        float f16 = this.$singleMediaInfo.ratio;
        QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView = this.this$0;
        QSearchTemplateReportInfo qSearchTemplateReportInfo = QSearchMultiImageVideoTemplateView.access$getAttr(qSearchMultiImageVideoTemplateView).getData().reportInfo;
        boolean z16 = (qSearchTemplateReportInfo != null && QSearchMultiImageVideoTemplateView.access$getBizId(qSearchMultiImageVideoTemplateView, qSearchTemplateReportInfo) == 21) && f16 < 0.33333334f;
        qSearchSingleMediaAttr2.mo153width(217.0f);
        qSearchSingleMediaAttr2.mo141height(z16 ? 289.0f : 217.0f / f16);
        qSearchSingleMediaAttr2.isShowAsThumbnail = z16;
        return Unit.INSTANCE;
    }
}
