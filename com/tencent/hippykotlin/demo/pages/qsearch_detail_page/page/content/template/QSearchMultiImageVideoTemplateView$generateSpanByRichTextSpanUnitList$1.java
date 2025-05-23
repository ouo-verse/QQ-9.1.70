package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchText;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.cf;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1 extends Lambda implements Function1<RichTextView, Unit> {
    public final /* synthetic */ QSearchText $content;
    public final /* synthetic */ QSearchMultiImageVideoTemplateView $ctx;
    public final /* synthetic */ List<RichTextSpanUnit> $spanList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1(List<RichTextSpanUnit> list, QSearchText qSearchText, QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView) {
        super(1);
        this.$spanList = list;
        this.$content = qSearchText;
        this.$ctx = qSearchMultiImageVideoTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(RichTextView richTextView) {
        RichTextView richTextView2 = richTextView;
        final Ref.IntRef intRef = new Ref.IntRef();
        List<RichTextSpanUnit> list = this.$spanList;
        final QSearchText qSearchText = this.$content;
        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView = this.$ctx;
        for (final RichTextSpanUnit richTextSpanUnit : list) {
            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(cf cfVar) {
                    cf cfVar2 = cfVar;
                    String substring = QSearchText.this.text.substring(intRef.element, richTextSpanUnit.start);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    cfVar2.text(substring);
                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                    final QSearchText qSearchText2 = QSearchText.this;
                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = qSearchMultiImageVideoTemplateView;
                    cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            QSearchJump qSearchJump = QSearchText.this.jumpLink;
                            if (qSearchJump != null) {
                                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(qSearchMultiImageVideoTemplateView2, qSearchJump);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(cf cfVar) {
                    cf cfVar2 = cfVar;
                    String str = QSearchText.this.text;
                    RichTextSpanUnit richTextSpanUnit2 = richTextSpanUnit;
                    String substring = str.substring(richTextSpanUnit2.start, richTextSpanUnit2.end);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    cfVar2.text(substring);
                    cfVar2.color(richTextSpanUnit.color);
                    final RichTextSpanUnit richTextSpanUnit3 = richTextSpanUnit;
                    if (richTextSpanUnit3.jump != null) {
                        final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = qSearchMultiImageVideoTemplateView;
                        final QSearchText qSearchText2 = QSearchText.this;
                        cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1$1$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                Map mapOf;
                                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(QSearchMultiImageVideoTemplateView.this, richTextSpanUnit3.jump);
                                QSearchReportInfo qSearchReportInfo = qSearchText2.reportInfo;
                                e reportParams = qSearchReportInfo != null ? TemplateItemsKt.getReportParams(qSearchReportInfo, QSearchMultiImageVideoTemplateView.this.getTemplateCardReportInfo()) : null;
                                if (reportParams != null) {
                                    RichTextSpanUnit richTextSpanUnit4 = richTextSpanUnit3;
                                    QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = QSearchMultiImageVideoTemplateView.this;
                                    QSearchMultiImageVideoTemplateView.Companion.getClass();
                                    QSearchReportInfo qSearchReportInfo2 = richTextSpanUnit4.reportInfo;
                                    if (qSearchReportInfo2 != null) {
                                        try {
                                            e eVar = new e(qSearchReportInfo2.reportInfo);
                                            for (String str2 : eVar.b()) {
                                                reportParams.v(str2, eVar.q(str2, ""));
                                            }
                                        } catch (Exception unused) {
                                            KLog.INSTANCE.e("QSearchMultiImageVideoTemplateView", "convert reportInfo json error");
                                        }
                                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("user_source", c.f117352a.g().getPageData().n().p("user_source")));
                                        e m3 = reportParams.m("cur_pg");
                                        if (m3 == null) {
                                            m3 = new e();
                                        }
                                        for (Map.Entry entry : mapOf.entrySet()) {
                                            m3.v((String) entry.getKey(), (String) entry.getValue());
                                        }
                                        reportParams.v("cur_pg", m3);
                                        QSearchMultiImageVideoTemplateView.access$reportClickDtEvent(qSearchMultiImageVideoTemplateView3, qSearchReportInfo2.eid, reportParams);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    return Unit.INSTANCE;
                }
            });
            intRef.element = richTextSpanUnit.end;
        }
        if (intRef.element < this.$content.text.length()) {
            final QSearchText qSearchText2 = this.$content;
            final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView2 = this.$ctx;
            RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView$generateSpanByRichTextSpanUnitList$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(cf cfVar) {
                    cf cfVar2 = cfVar;
                    String substring = QSearchText.this.text.substring(intRef.element);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    cfVar2.text(substring);
                    cfVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                    final QSearchText qSearchText3 = QSearchText.this;
                    final QSearchMultiImageVideoTemplateView qSearchMultiImageVideoTemplateView3 = qSearchMultiImageVideoTemplateView2;
                    cfVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchMultiImageVideoTemplateView.generateSpanByRichTextSpanUnitList.1.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            QSearchJump qSearchJump = QSearchText.this.jumpLink;
                            if (qSearchJump != null) {
                                QSearchMultiImageVideoTemplateView.access$jumpWithFeedPbToken(qSearchMultiImageVideoTemplateView3, qSearchJump);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
