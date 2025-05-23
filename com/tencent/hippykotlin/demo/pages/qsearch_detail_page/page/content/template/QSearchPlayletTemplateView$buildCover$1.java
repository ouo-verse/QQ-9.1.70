package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPlaylet;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.TemplateItemsKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateView$buildCover$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchPlaylet $contentData;
    public final /* synthetic */ QSearchPlayletTemplateView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchPlayletTemplateView$buildCover$1(QSearchPlaylet qSearchPlaylet, QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        super(1);
        this.$contentData = qSearchPlaylet;
        this.$ctx = qSearchPlayletTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final QSearchPlaylet qSearchPlaylet = this.$contentData;
        final QSearchPlayletTemplateView qSearchPlayletTemplateView = this.$ctx;
        ah.a(viewContainer, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildCover$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ImageView imageView) {
                ImageView imageView2 = imageView;
                final QSearchPlaylet qSearchPlaylet2 = QSearchPlaylet.this;
                final QSearchPlayletTemplateView qSearchPlayletTemplateView2 = qSearchPlayletTemplateView;
                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildCover.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(af afVar) {
                        String str;
                        QSearchReportInfo qSearchReportInfo;
                        af afVar2 = afVar;
                        QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                        afVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_secondary"));
                        QSearchPicture qSearchPicture = QSearchPlaylet.this.mainPic;
                        if (qSearchPicture == null || (str = qSearchPicture.picLink) == null) {
                            str = "";
                        }
                        b.a.b(afVar2, str, false, 2, null);
                        afVar2.mo153width(125.0f);
                        afVar2.mo141height(167.0f);
                        afVar2.p();
                        afVar2.borderRadius(4.0f);
                        QSearchPicture qSearchPicture2 = QSearchPlaylet.this.mainPic;
                        if (qSearchPicture2 != null && (qSearchReportInfo = qSearchPicture2.reportInfo) != null) {
                            EcommerceExtKt.vr$default(afVar2, null, qSearchReportInfo.eid, TemplateItemsKt.getReportParams(qSearchReportInfo, qSearchPlayletTemplateView2.getTemplateCardReportInfo()), null, String.valueOf(qSearchReportInfo.hashCode()), true, 9);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final QSearchPlayletTemplateView qSearchPlayletTemplateView3 = qSearchPlayletTemplateView;
                final QSearchPlaylet qSearchPlaylet3 = QSearchPlaylet.this;
                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildCover.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageEvent imageEvent) {
                        final QSearchPlayletTemplateView qSearchPlayletTemplateView4 = QSearchPlayletTemplateView.this;
                        final QSearchPlaylet qSearchPlaylet4 = qSearchPlaylet3;
                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView.buildCover.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                QSearchPlayletTemplateView qSearchPlayletTemplateView5 = QSearchPlayletTemplateView.this;
                                QSearchPicture qSearchPicture = qSearchPlaylet4.mainPic;
                                qSearchPlayletTemplateView5.doJump(qSearchPicture != null ? qSearchPicture.jumpLink : null, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
