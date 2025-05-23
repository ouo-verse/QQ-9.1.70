package com.tencent.hippykotlin.demo.pages.goods_center.card.order;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectionCenter;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterTodayTurnover;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterOrderView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderViewModel");
        final GoodsCenterOrderViewModel goodsCenterOrderViewModel = (GoodsCenterOrderViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.keepAlive(true);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(224.0f);
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterOrderViewModel goodsCenterOrderViewModel2 = GoodsCenterOrderViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.justifyContentFlexStart();
                                tVar2.margin(48.0f, 16.0f, 12.0f, 16.0f);
                                tVar2.borderRadius(8.0f);
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel3 = GoodsCenterOrderViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoodsCenterOrderViewModel.this.getRsp();
                            }
                        };
                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel4 = GoodsCenterOrderViewModel.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                final GoodsCenterOrderViewModel goodsCenterOrderViewModel5 = GoodsCenterOrderViewModel.this;
                                bindDirectivesView2.addChild(new GoodsCenterOrderTurnoverView(), new Function1<GoodsCenterOrderTurnoverView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterOrderTurnoverView goodsCenterOrderTurnoverView) {
                                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel6 = GoodsCenterOrderViewModel.this;
                                        goodsCenterOrderTurnoverView.attr(new Function1<GoodsCenterOrderTurnoverAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr) {
                                                GoodsCenterTodayTurnover goodsCenterTodayTurnover;
                                                GoodsCenterTodayTurnover goodsCenterTodayTurnover2;
                                                GoodsCenterOrderTurnoverAttr goodsCenterOrderTurnoverAttr2 = goodsCenterOrderTurnoverAttr;
                                                GoodsCenterSelectProductsRsp rsp = GoodsCenterOrderViewModel.this.getRsp();
                                                Icon icon = null;
                                                goodsCenterOrderTurnoverAttr2.turnovers = (rsp == null || (goodsCenterTodayTurnover2 = rsp.turnover) == null) ? null : goodsCenterTodayTurnover2.turnoverInfos;
                                                GoodsCenterSelectProductsRsp rsp2 = GoodsCenterOrderViewModel.this.getRsp();
                                                if (rsp2 != null && (goodsCenterTodayTurnover = rsp2.turnover) != null) {
                                                    icon = goodsCenterTodayTurnover.detailButton;
                                                }
                                                goodsCenterOrderTurnoverAttr2.moreBtn = icon;
                                                goodsCenterOrderTurnoverAttr2.viewModel = GoodsCenterOrderViewModel.this;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(0.5f);
                                                tVar2.marginLeft(12.0f).marginRight(12.0f);
                                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getDividerColor());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterOrderViewModel goodsCenterOrderViewModel6 = GoodsCenterOrderViewModel.this;
                                bindDirectivesView2.addChild(new GoodsCenterOrderNavigationView(), new Function1<GoodsCenterOrderNavigationView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterOrderNavigationView goodsCenterOrderNavigationView) {
                                        final GoodsCenterOrderViewModel goodsCenterOrderViewModel7 = GoodsCenterOrderViewModel.this;
                                        goodsCenterOrderNavigationView.attr(new Function1<GoodsCenterOrderNavigationAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GoodsCenterOrderNavigationAttr goodsCenterOrderNavigationAttr) {
                                                GoodsCenterSelectionCenter goodsCenterSelectionCenter;
                                                GoodsCenterOrderNavigationAttr goodsCenterOrderNavigationAttr2 = goodsCenterOrderNavigationAttr;
                                                GoodsCenterSelectProductsRsp rsp = GoodsCenterOrderViewModel.this.getRsp();
                                                goodsCenterOrderNavigationAttr2.navButtons = (rsp == null || (goodsCenterSelectionCenter = rsp.navigation) == null) ? null : goodsCenterSelectionCenter.buttons;
                                                goodsCenterOrderNavigationAttr2.viewModel = GoodsCenterOrderViewModel.this;
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
                final GoodsCenterOrderViewModel goodsCenterOrderViewModel3 = GoodsCenterOrderViewModel.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GoodsCenterSelectProductsRsp rsp = GoodsCenterOrderViewModel.this.getRsp();
                        return Boolean.valueOf((rsp != null ? rsp.turnover : null) == null);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new GoodsCenterSkeletonView(), new Function1<GoodsCenterSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(GoodsCenterSkeletonView goodsCenterSkeletonView) {
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
        return new GoodsCenterCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
