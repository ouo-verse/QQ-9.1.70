package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SearchBar;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchDoubleColumnTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchDoubleListItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.util.QSearchTemplateUtilKt;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchDoubleColumnTemplateView extends QSearchBaseTemplateView<QSearchDoubleColumnTemplateModel, QSearchDoubleColumnTemplateAttr, QSearchDoubleColumnTemplateEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchDoubleColumnTemplateAttr access$getAttr(QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView) {
        return (QSearchDoubleColumnTemplateAttr) qSearchDoubleColumnTemplateView.getAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchBaseTemplateView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView = QSearchDoubleColumnTemplateView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildContent$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        if (QSearchDoubleColumnTemplateView.access$getAttr(QSearchDoubleColumnTemplateView.this).getData().layoutInfo.showDivider) {
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildContent.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildContent.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo141height(0.5f);
                                            tVar2.absolutePositionAllZero();
                                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView2 = QSearchDoubleColumnTemplateView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildContent.1.1.2
                            {
                                super(1);
                            }

                            /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchDoubleListItemModel>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildContent.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.paddingTop(12.0f);
                                        tVar2.paddingBottom(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView3 = QSearchDoubleColumnTemplateView.this;
                                QSearchTemplateUtilKt.buildTitlePart(qSearchDoubleColumnTemplateView3, QSearchDoubleColumnTemplateView.access$getAttr(qSearchDoubleColumnTemplateView3).getData()).invoke(vVar4);
                                ?? r06 = QSearchDoubleColumnTemplateView.access$getAttr(QSearchDoubleColumnTemplateView.this).getData().items;
                                final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView4 = QSearchDoubleColumnTemplateView.this;
                                Iterator it = r06.iterator();
                                final int i3 = 0;
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    int i16 = i3 + 1;
                                    if (i3 < 0) {
                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                    }
                                    final QSearchDoubleListItemModel qSearchDoubleListItemModel = (QSearchDoubleListItemModel) next;
                                    qSearchDoubleColumnTemplateView4.getClass();
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildLineItem$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final QSearchDoubleListItemModel qSearchDoubleListItemModel2 = QSearchDoubleListItemModel.this;
                                            final int i17 = i3;
                                            final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView5 = qSearchDoubleColumnTemplateView4;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildLineItem$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchListItemModel>, java.util.ArrayList] */
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    final int i18 = i17;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildLineItem.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionRow();
                                                            if (i18 > 0) {
                                                                tVar2.paddingTop(8.0f);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    ?? r07 = QSearchDoubleListItemModel.this.items;
                                                    final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView6 = qSearchDoubleColumnTemplateView5;
                                                    Iterator it5 = r07.iterator();
                                                    final int i19 = 0;
                                                    while (it5.hasNext()) {
                                                        Object next2 = it5.next();
                                                        int i26 = i19 + 1;
                                                        if (i19 < 0) {
                                                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                        }
                                                        final QSearchListItemModel qSearchListItemModel = (QSearchListItemModel) next2;
                                                        int i27 = QSearchDoubleColumnTemplateView.$r8$clinit;
                                                        qSearchDoubleColumnTemplateView6.getClass();
                                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildItem$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                                final int i28 = i19;
                                                                final QSearchListItemModel qSearchListItemModel2 = qSearchListItemModel;
                                                                final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView7 = qSearchDoubleColumnTemplateView6;
                                                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView$buildItem$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar7) {
                                                                        v vVar8 = vVar7;
                                                                        final int i29 = i28;
                                                                        final QSearchListItemModel qSearchListItemModel3 = qSearchListItemModel2;
                                                                        final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView8 = qSearchDoubleColumnTemplateView7;
                                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildItem.1.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.paddingLeft(10.0f).paddingRight(10.0f);
                                                                                tVar2.mo141height(FontModuleExtKt.qqTextViewLineHeightScale() * 32.0f);
                                                                                QUISkinColor qUISkinColor = QUISkinColor.INSTANCE;
                                                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                                                                tVar2.borderRadius(4.0f);
                                                                                tVar2.m140flex(1.0f);
                                                                                if (i29 % 2 == 1) {
                                                                                    tVar2.marginLeft(8.0f);
                                                                                }
                                                                                QSearchTemplateReportInfo qSearchTemplateReportInfo = qSearchListItemModel3.reportInfo;
                                                                                if (qSearchTemplateReportInfo != null) {
                                                                                    EcommerceExtKt.vr$default(tVar2, null, qSearchTemplateReportInfo.eid, qSearchTemplateReportInfo.getReportParams(qSearchDoubleColumnTemplateView8.getTemplateCardReportInfo()), null, String.valueOf(qSearchTemplateReportInfo.hashCode()), true, 9);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchListItemModel qSearchListItemModel4 = qSearchListItemModel2;
                                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildItem.1.1.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QSearchListItemModel qSearchListItemModel5 = QSearchListItemModel.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildItem.1.1.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.m140flex(1.0f);
                                                                                        ceVar2.lines(1);
                                                                                        ceVar2.textOverFlowTail();
                                                                                        ceVar2.text(QSearchListItemModel.this.title);
                                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_link"));
                                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                        ceVar2.lineHeight(FontModuleExtKt.qqTextViewLineHeightScale() * 32.0f);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QSearchListItemModel qSearchListItemModel5 = qSearchListItemModel2;
                                                                        final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView9 = qSearchDoubleColumnTemplateView7;
                                                                        vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildItem.1.1.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final u uVar2 = uVar;
                                                                                final QSearchListItemModel qSearchListItemModel6 = QSearchListItemModel.this;
                                                                                final QSearchDoubleColumnTemplateView qSearchDoubleColumnTemplateView10 = qSearchDoubleColumnTemplateView9;
                                                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchDoubleColumnTemplateView.buildItem.1.1.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        SearchBar b16;
                                                                                        QSearchJump qSearchJump = QSearchListItemModel.this.jumpInfo;
                                                                                        if (qSearchJump != null) {
                                                                                            QSearchUtilKt.allInOneJump$default(qSearchJump, uVar2.getPager(), QSearchDoubleColumnTemplateView.access$getAttr(qSearchDoubleColumnTemplateView10).tabData.tabMask, 44);
                                                                                        } else {
                                                                                            b pager = uVar2.getPager();
                                                                                            QSearchDetailPage qSearchDetailPage = pager instanceof QSearchDetailPage ? (QSearchDetailPage) pager : null;
                                                                                            if (qSearchDetailPage != null) {
                                                                                                String str = QSearchListItemModel.this.title;
                                                                                                qSearchDetailPage.searchText(str, 12);
                                                                                                aa<SearchBar> aaVar = qSearchDetailPage.searchBarRef;
                                                                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                                                    b16.setText(str);
                                                                                                }
                                                                                            }
                                                                                        }
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
                                                        }.invoke(vVar6);
                                                        i19 = i26;
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(vVar4);
                                    i3 = i16;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchDoubleColumnTemplateAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchDoubleColumnTemplateEvent();
    }
}
