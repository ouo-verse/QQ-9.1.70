package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAgeView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitAreaView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.subViews.QPOrderDetailPortraitSexView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailEmptyDataView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailEmptyDataViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPortraitView extends IQPOrderDetailCardView {
    public static final Function1 access$button(QPOrderDetailPortraitView qPOrderDetailPortraitView, String str, boolean z16, Function0 function0) {
        qPOrderDetailPortraitView.getClass();
        return new QPOrderDetailPortraitView$button$1(function0, str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitViewModel");
        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel = (QPOrderDetailPortraitViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.marginTop(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u89c2\u4f17\u753b\u50cf\u5c06\u5728\u6b21\u65e5\u66f4\u65b0");
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.alignSelfFlexStart();
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginBottom(16.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                ceVar2.color(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailPortraitView qPOrderDetailPortraitView = QPOrderDetailPortraitView.this;
                final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel2 = qPOrderDetailPortraitViewModel;
                qPOrderDetailPortraitView.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$buttonsRow$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel3 = QPOrderDetailPortraitViewModel.this;
                        final QPOrderDetailPortraitView qPOrderDetailPortraitView2 = qPOrderDetailPortraitView;
                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$buttonsRow$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentFlexStart();
                                        tVar2.alignSelfFlexStart();
                                        tVar2.marginLeft(8.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel4 = QPOrderDetailPortraitViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Integer.valueOf(QPOrderDetailPortraitViewModel.this.getCurrentPortraitViewIndex());
                                    }
                                };
                                final QPOrderDetailPortraitView qPOrderDetailPortraitView3 = qPOrderDetailPortraitView2;
                                final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel5 = QPOrderDetailPortraitViewModel.this;
                                BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        QPOrderDetailPortraitView qPOrderDetailPortraitView4 = QPOrderDetailPortraitView.this;
                                        boolean z16 = qPOrderDetailPortraitViewModel5.getCurrentPortraitViewIndex() == 0;
                                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel6 = qPOrderDetailPortraitViewModel5;
                                        ((QPOrderDetailPortraitView$button$1) QPOrderDetailPortraitView.access$button(qPOrderDetailPortraitView4, "\u5e74\u9f84", z16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.3.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                QPOrderDetailPortraitViewModel.this.setCurrentPortraitViewIndex(0);
                                                return Unit.INSTANCE;
                                            }
                                        })).invoke(bindDirectivesView2);
                                        QPOrderDetailPortraitView qPOrderDetailPortraitView5 = QPOrderDetailPortraitView.this;
                                        boolean z17 = qPOrderDetailPortraitViewModel5.getCurrentPortraitViewIndex() == 1;
                                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel7 = qPOrderDetailPortraitViewModel5;
                                        ((QPOrderDetailPortraitView$button$1) QPOrderDetailPortraitView.access$button(qPOrderDetailPortraitView5, "\u6027\u522b", z17, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.3.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                QPOrderDetailPortraitViewModel.this.setCurrentPortraitViewIndex(1);
                                                return Unit.INSTANCE;
                                            }
                                        })).invoke(bindDirectivesView2);
                                        QPOrderDetailPortraitView qPOrderDetailPortraitView6 = QPOrderDetailPortraitView.this;
                                        boolean z18 = qPOrderDetailPortraitViewModel5.getCurrentPortraitViewIndex() == 2;
                                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel8 = qPOrderDetailPortraitViewModel5;
                                        ((QPOrderDetailPortraitView$button$1) QPOrderDetailPortraitView.access$button(qPOrderDetailPortraitView6, "\u5730\u533a", z18, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.buttonsRow.1.1.3.3
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                QPOrderDetailPortraitViewModel.this.setCurrentPortraitViewIndex(2);
                                                return Unit.INSTANCE;
                                            }
                                        })).invoke(bindDirectivesView2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(viewContainer2);
                final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel3 = qPOrderDetailPortraitViewModel;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(QPOrderDetailPortraitViewModel.this.getCurrentPortraitViewIndex());
                    }
                };
                final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel4 = qPOrderDetailPortraitViewModel;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel5 = QPOrderDetailPortraitViewModel.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPOrderDetailPortraitViewModel.this.getCurrentPortraitViewIndex() == 0);
                            }
                        };
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel6 = QPOrderDetailPortraitViewModel.this;
                        ConditionViewKt.c(bindDirectivesView2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel7 = QPOrderDetailPortraitViewModel.this;
                                if (qPOrderDetailPortraitViewModel7.ageShouldShow) {
                                    Pair<String, Float>[] pairArr = qPOrderDetailPortraitViewModel7.audienceInfoList[qPOrderDetailPortraitViewModel7.getCurrentPortraitViewIndex()];
                                    conditionView2.addChild(new QPOrderDetailPortraitAgeView(pairArr), new Function1<QPOrderDetailPortraitAgeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPOrderDetailPortraitAgeView qPOrderDetailPortraitAgeView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    QPDetailEmptyDataViewKt.QPDetailEmptyDataViewFun(conditionView2, new Function1<QPDetailEmptyDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPDetailEmptyDataView qPDetailEmptyDataView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel7 = QPOrderDetailPortraitViewModel.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPOrderDetailPortraitViewModel.this.getCurrentPortraitViewIndex() == 1);
                            }
                        };
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel8 = QPOrderDetailPortraitViewModel.this;
                        ConditionViewKt.b(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel9 = QPOrderDetailPortraitViewModel.this;
                                if (qPOrderDetailPortraitViewModel9.genderShouldShow) {
                                    Pair<String, Float>[] pairArr = qPOrderDetailPortraitViewModel9.audienceInfoList[qPOrderDetailPortraitViewModel9.getCurrentPortraitViewIndex()];
                                    conditionView2.addChild(new QPOrderDetailPortraitSexView(pairArr), new Function1<QPOrderDetailPortraitSexView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPOrderDetailPortraitSexView qPOrderDetailPortraitSexView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    QPDetailEmptyDataViewKt.QPDetailEmptyDataViewFun(conditionView2, new Function1<QPDetailEmptyDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPDetailEmptyDataView qPDetailEmptyDataView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel9 = QPOrderDetailPortraitViewModel.this;
                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPOrderDetailPortraitViewModel.this.getCurrentPortraitViewIndex() == 2);
                            }
                        };
                        final QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel10 = QPOrderDetailPortraitViewModel.this;
                        ConditionViewKt.b(bindDirectivesView2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                QPOrderDetailPortraitViewModel qPOrderDetailPortraitViewModel11 = QPOrderDetailPortraitViewModel.this;
                                if (qPOrderDetailPortraitViewModel11.areaShouldShow) {
                                    conditionView2.addChild(new QPOrderDetailPortraitAreaView(qPOrderDetailPortraitViewModel11), new Function1<QPOrderDetailPortraitAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.6.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPOrderDetailPortraitAreaView qPOrderDetailPortraitAreaView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    QPDetailEmptyDataViewKt.QPDetailEmptyDataViewFun(conditionView2, new Function1<QPDetailEmptyDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitView.body.1.4.6.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPDetailEmptyDataView qPDetailEmptyDataView) {
                                            return Unit.INSTANCE;
                                        }
                                    });
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
}
