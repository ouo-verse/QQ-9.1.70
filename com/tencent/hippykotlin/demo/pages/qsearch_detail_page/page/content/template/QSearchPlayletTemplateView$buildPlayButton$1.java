package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPlaylet;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonView;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchBlueButtonViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateView$buildPlayButton$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchPlaylet $contentData;
    public final /* synthetic */ QSearchPlayletTemplateView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchPlayletTemplateView$buildPlayButton$1(QSearchPlaylet qSearchPlaylet, QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        super(1);
        this.$contentData = qSearchPlaylet;
        this.$ctx = qSearchPlayletTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final QSearchButton qSearchButton = this.$contentData.playButton;
        if (qSearchButton != null) {
            final QSearchPlayletTemplateView qSearchPlayletTemplateView = this.$ctx;
            QSearchBlueButtonViewKt.QSearchBlueButton(viewContainer2, new Function1<QSearchBlueButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildPlayButton$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(QSearchBlueButtonView qSearchBlueButtonView) {
                    QSearchBlueButtonView qSearchBlueButtonView2 = qSearchBlueButtonView;
                    final QSearchButton qSearchButton2 = QSearchButton.this;
                    final QSearchPlayletTemplateView qSearchPlayletTemplateView2 = qSearchPlayletTemplateView;
                    qSearchBlueButtonView2.attr(new Function1<QSearchBlueButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildPlayButton$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(QSearchBlueButtonAttr qSearchBlueButtonAttr) {
                            QSearchBlueButtonAttr qSearchBlueButtonAttr2 = qSearchBlueButtonAttr;
                            qSearchBlueButtonAttr2.text = QSearchButton.this.title;
                            qSearchBlueButtonAttr2.alignSelfFlexStart();
                            QSearchReportInfo qSearchReportInfo = QSearchButton.this.reportInfo;
                            if (qSearchReportInfo != null) {
                                EcommerceExtKt.vr$default(qSearchBlueButtonAttr2, null, qSearchReportInfo.eid, TemplateItemsKt.getReportParams(qSearchReportInfo, qSearchPlayletTemplateView2.getTemplateCardReportInfo()), null, String.valueOf(qSearchReportInfo.hashCode()), true, 9);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final QSearchPlayletTemplateView qSearchPlayletTemplateView3 = qSearchPlayletTemplateView;
                    final QSearchButton qSearchButton3 = QSearchButton.this;
                    qSearchBlueButtonView2.event(new Function1<QSearchBlueButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildPlayButton$1$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(QSearchBlueButtonEvent qSearchBlueButtonEvent) {
                            final QSearchPlayletTemplateView qSearchPlayletTemplateView4 = QSearchPlayletTemplateView.this;
                            final QSearchButton qSearchButton4 = qSearchButton3;
                            qSearchBlueButtonEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildPlayButton.1.1.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    QSearchPlayletTemplateView.this.doJump(qSearchButton4.jumpLink, null);
                                    return Unit.INSTANCE;
                                }
                            });
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
