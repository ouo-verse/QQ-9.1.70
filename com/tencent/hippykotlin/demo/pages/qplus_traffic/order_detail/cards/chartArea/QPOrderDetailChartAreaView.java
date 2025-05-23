package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailChartAreaView extends IQPOrderDetailCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaViewModel");
        final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel = (QPOrderDetailChartAreaViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 8.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel2 = QPOrderDetailChartAreaViewModel.this;
                final QPOrderDetailChartAreaView qPOrderDetailChartAreaView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel3 = QPOrderDetailChartAreaViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(QPOrderDetailChartAreaViewModel.this.getSubPageIndex());
                            }
                        };
                        final QPOrderDetailChartAreaView qPOrderDetailChartAreaView2 = qPOrderDetailChartAreaView;
                        final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel4 = QPOrderDetailChartAreaViewModel.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                QPOrderDetailChartAreaView qPOrderDetailChartAreaView3 = QPOrderDetailChartAreaView.this;
                                final boolean z16 = qPOrderDetailChartAreaViewModel4.getSubPageIndex() == 0;
                                final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel5 = qPOrderDetailChartAreaViewModel4;
                                final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.3.3.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QPOrderDetailChartAreaViewModel.this.handleTabClick(0);
                                        return Unit.INSTANCE;
                                    }
                                };
                                int i3 = QPOrderDetailChartAreaView.$r8$clinit;
                                qPOrderDetailChartAreaView3.getClass();
                                final String str = "\u4e92\u52a8\u6570\u636e";
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$tabItem$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final Function0<Unit> function03 = function02;
                                        final String str2 = str;
                                        final boolean z17 = z16;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$tabItem$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.justifyContentFlexStart();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.paddingTop(16.0f);
                                                        tVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Function0<Unit> function04 = function03;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final Function0<Unit> function05 = function04;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function05.invoke();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str3 = str2;
                                                final boolean z18 = z17;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str4 = str3;
                                                        final boolean z19 = z18;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str4);
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                if (z19) {
                                                                    ceVar2.fontWeightBold();
                                                                } else {
                                                                    ceVar2.fontWeight400();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final boolean z19 = z17;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        final boolean z26 = z19;
                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h hVar;
                                                                t tVar2 = tVar;
                                                                tVar2.size(20.0f, 3.0f);
                                                                tVar2.marginTop(4.0f);
                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                tVar2.mo113backgroundColor(hVar);
                                                                tVar2.m152visibility(z26);
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
                                }.invoke(bindDirectivesView2);
                                QPOrderDetailChartAreaView qPOrderDetailChartAreaView4 = QPOrderDetailChartAreaView.this;
                                final boolean z17 = qPOrderDetailChartAreaViewModel4.getSubPageIndex() == 1;
                                final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel6 = qPOrderDetailChartAreaViewModel4;
                                final Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.body.1.3.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QPOrderDetailChartAreaViewModel.this.handleTabClick(1);
                                        return Unit.INSTANCE;
                                    }
                                };
                                qPOrderDetailChartAreaView4.getClass();
                                final String str2 = "\u89c2\u4f17\u753b\u50cf";
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$tabItem$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final Function0<Unit> function032 = function03;
                                        final String str22 = str2;
                                        final boolean z172 = z17;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$tabItem$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.justifyContentFlexStart();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.paddingTop(16.0f);
                                                        tVar2.marginLeft(16.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Function0<Unit> function04 = function032;
                                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final Function0<Unit> function05 = function04;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function05.invoke();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str3 = str22;
                                                final boolean z18 = z172;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str4 = str3;
                                                        final boolean z19 = z18;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                h hVar;
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str4);
                                                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                if (z19) {
                                                                    ceVar2.fontWeightBold();
                                                                } else {
                                                                    ceVar2.fontWeight400();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final boolean z19 = z172;
                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        final boolean z26 = z19;
                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView.tabItem.1.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                h hVar;
                                                                t tVar2 = tVar;
                                                                tVar2.size(20.0f, 3.0f);
                                                                tVar2.marginTop(4.0f);
                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                tVar2.mo113backgroundColor(hVar);
                                                                tVar2.m152visibility(z26);
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
                                }.invoke(bindDirectivesView2);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel3 = QPOrderDetailChartAreaViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel4 = QPOrderDetailChartAreaViewModel.this;
                        return (IQPOrderDetailCardViewModel) qPOrderDetailChartAreaViewModel4.currentSubPageViewModel$delegate.getValue(qPOrderDetailChartAreaViewModel4, QPOrderDetailChartAreaViewModel.$$delegatedProperties[1]);
                    }
                };
                final QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel4 = QPOrderDetailChartAreaViewModel.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        QPOrderDetailChartAreaViewModel qPOrderDetailChartAreaViewModel5 = QPOrderDetailChartAreaViewModel.this;
                        final IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel = (IQPOrderDetailCardViewModel) qPOrderDetailChartAreaViewModel5.currentSubPageViewModel$delegate.getValue(qPOrderDetailChartAreaViewModel5, QPOrderDetailChartAreaViewModel.$$delegatedProperties[1]);
                        bindDirectivesView.addChild(iQPOrderDetailCardViewModel.getCardView(), new Function1<IQPOrderDetailCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1$5$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(IQPOrderDetailCardView iQPOrderDetailCardView) {
                                final IQPOrderDetailCardViewModel iQPOrderDetailCardViewModel2 = IQPOrderDetailCardViewModel.this;
                                iQPOrderDetailCardView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaView$body$1$5$1$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                        qPOrderDetailCardAttr.viewModel = IQPOrderDetailCardViewModel.this;
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
}
