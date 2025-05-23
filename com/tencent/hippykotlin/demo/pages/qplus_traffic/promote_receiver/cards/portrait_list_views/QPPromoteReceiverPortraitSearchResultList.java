package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views;

import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterAttr;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterEvent;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterKt;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverPortraitSearchItemCard;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views.QPPromoteReceiverSearchItemCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitSearchResultList extends ComposeView<k, l> {
    public final QPPromoteReceiverPortraitPageModel viewModel;

    public QPPromoteReceiverPortraitSearchResultList(QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel) {
        this.viewModel = qPPromoteReceiverPortraitPageModel;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList = QPPromoteReceiverPortraitSearchResultList.this;
                ar.a(viewContainer, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList2 = QPPromoteReceiverPortraitSearchResultList.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                AttrExtKt.backgroundColorToken(aoVar2, "qecommerce_skin_color_bg_default");
                                aoVar2.showScrollerIndicator(false);
                                if (QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList().size() > 0) {
                                    if (QPPromoteReceiverPortraitSearchResultList.this.viewModel.getNeedSearchResultFooter()) {
                                        aoVar2.mo141height((QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList().size() * 56.0f) + 50.0f);
                                    } else {
                                        aoVar2.mo141height(QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList().size() * 56.0f);
                                    }
                                } else if (QPPromoteReceiverPortraitSearchResultList.this.viewModel.getNeedSearchResultFooter()) {
                                    aoVar2.mo141height(58.0f);
                                } else {
                                    aoVar2.mo141height(100.0f);
                                }
                                aoVar2.m143maxHeight(aoVar2.getPagerData().l() * 0.8f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList3 = QPPromoteReceiverPortraitSearchResultList.this;
                        Function0<c<QPPromoteReceiverPortraitListItem>> function0 = new Function0<c<QPPromoteReceiverPortraitListItem>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<QPPromoteReceiverPortraitListItem> invoke() {
                                return QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList();
                            }
                        };
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList4 = QPPromoteReceiverPortraitSearchResultList.this;
                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<QPPromoteReceiverPortraitListItem>, QPPromoteReceiverPortraitListItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<QPPromoteReceiverPortraitListItem> loopDirectivesView, QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
                                final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem2 = qPPromoteReceiverPortraitListItem;
                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList5 = QPPromoteReceiverPortraitSearchResultList.this;
                                loopDirectivesView.addChild(new QPPromoteReceiverPortraitSearchItemCard(), new Function1<QPPromoteReceiverPortraitSearchItemCard, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPPromoteReceiverPortraitSearchItemCard qPPromoteReceiverPortraitSearchItemCard) {
                                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList6 = QPPromoteReceiverPortraitSearchResultList.this;
                                        final QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem3 = qPPromoteReceiverPortraitListItem2;
                                        qPPromoteReceiverPortraitSearchItemCard.attr(new Function1<QPPromoteReceiverSearchItemCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr) {
                                                QPPromoteReceiverSearchItemCardAttr qPPromoteReceiverSearchItemCardAttr2 = qPPromoteReceiverSearchItemCardAttr;
                                                qPPromoteReceiverSearchItemCardAttr2.mo153width(qPPromoteReceiverSearchItemCardAttr2.getPagerData().m());
                                                qPPromoteReceiverSearchItemCardAttr2.viewModel = QPPromoteReceiverPortraitSearchResultList.this.viewModel;
                                                qPPromoteReceiverSearchItemCardAttr2.item(qPPromoteReceiverPortraitListItem3);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList5 = QPPromoteReceiverPortraitSearchResultList.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPPromoteReceiverPortraitSearchResultList.this.viewModel.getNeedSearchResultFooter());
                            }
                        };
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList6 = QPPromoteReceiverPortraitSearchResultList.this;
                        ConditionViewKt.c(aqVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList7 = QPPromoteReceiverPortraitSearchResultList.this;
                                ECRefreshFooterKt.ECRefreshFooter(conditionView, new Function1<ECRefreshFooter, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECRefreshFooter eCRefreshFooter) {
                                        ECRefreshFooter eCRefreshFooter2 = eCRefreshFooter;
                                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList8 = QPPromoteReceiverPortraitSearchResultList.this;
                                        eCRefreshFooter2.attr(new Function1<ECRefreshFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECRefreshFooterAttr eCRefreshFooterAttr) {
                                                ECRefreshFooterAttr eCRefreshFooterAttr2 = eCRefreshFooterAttr;
                                                eCRefreshFooterAttr2.marginTop(8.0f);
                                                eCRefreshFooterAttr2.setPreloadDistance(30.0f);
                                                eCRefreshFooterAttr2.mo153width(eCRefreshFooterAttr2.getPagerData().m());
                                                eCRefreshFooterAttr2.mo141height(64.0f);
                                                QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = QPPromoteReceiverPortraitSearchResultList.this.viewModel;
                                                eCRefreshFooterAttr2.setFooterRefreshState((FooterRefreshState) qPPromoteReceiverPortraitPageModel.searchResultState$delegate.getValue(qPPromoteReceiverPortraitPageModel, QPPromoteReceiverPortraitPageModel.$$delegatedProperties[6]));
                                                eCRefreshFooterAttr2.footerNoMoreText = "\u6ca1\u6709\u66f4\u591a\u4e86\uff5e";
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList9 = QPPromoteReceiverPortraitSearchResultList.this;
                                        eCRefreshFooter2.event(new Function1<ECRefreshFooterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECRefreshFooterEvent eCRefreshFooterEvent) {
                                                ECRefreshFooterEvent eCRefreshFooterEvent2 = eCRefreshFooterEvent;
                                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList10 = QPPromoteReceiverPortraitSearchResultList.this;
                                                eCRefreshFooterEvent2.onRefreshingHandlerFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5.1.2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        QPPromoteReceiverPortraitSearchResultList.this.viewModel.loadMore();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList11 = QPPromoteReceiverPortraitSearchResultList.this;
                                                eCRefreshFooterEvent2.refreshStateDidChangeHandlerFn = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.5.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                        QPPromoteReceiverPortraitSearchResultList.this.viewModel.setSearchResultState(footerRefreshState);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList7 = QPPromoteReceiverPortraitSearchResultList.this;
                        ConditionViewKt.a(aqVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList8 = QPPromoteReceiverPortraitSearchResultList.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList();
                                    }
                                };
                                final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList9 = QPPromoteReceiverPortraitSearchResultList.this;
                                BindDirectivesViewKt.a(conditionView, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final QPPromoteReceiverPortraitSearchResultList qPPromoteReceiverPortraitSearchResultList10 = QPPromoteReceiverPortraitSearchResultList.this;
                                        ConditionViewKt.c(bindDirectivesView, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.2.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Boolean.valueOf(QPPromoteReceiverPortraitSearchResultList.this.viewModel.getShowItemList().size() == 0);
                                            }
                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ConditionView conditionView2) {
                                                cg.a(conditionView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views.QPPromoteReceiverPortraitSearchResultList.body.1.1.6.2.2.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginTop(38.0f);
                                                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                ceVar2.textAlignCenter();
                                                                ceVar2.text("\u65e0\u7ed3\u679c");
                                                                ceVar2.fontWeight500();
                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
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
                                });
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
