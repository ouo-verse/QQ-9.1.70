package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailEmptyDataView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailEmptyDataViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailLineChartView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailInteractiveView extends IQPOrderDetailCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final Function1 access$button(QPOrderDetailInteractiveView qPOrderDetailInteractiveView, String str, boolean z16, Function0 function0) {
        qPOrderDetailInteractiveView.getClass();
        return new QPOrderDetailInteractiveView$button$1(z16, function0, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveViewModel");
        final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel = (QPOrderDetailInteractiveViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u4e92\u52a8\u6570\u636e\u5c06\u5728\u6b21\u65e5\u66f4\u65b0");
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.alignSelfFlexStart();
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginTop(16.0f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                ceVar2.color(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u89c2\u770b\u65f6\u957f\u5206\u5e03");
                                ceVar2.marginLeft(16.0f);
                                ceVar2.alignSelfFlexStart();
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.marginTop(16.0f);
                                ceVar2.marginBottom(3.5f);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                ceVar2.color(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                if (!(QPOrderDetailInteractiveViewModel.this.getInteractDist()[0].length == 0)) {
                    Pair<Float, String>[] pairArr = QPOrderDetailInteractiveViewModel.this.getInteractDist()[0];
                    ArrayList arrayList = new ArrayList(pairArr.length);
                    for (Pair<Float, String> pair : pairArr) {
                        arrayList.add(Float.valueOf(pair.getFirst().floatValue() / 100.0f));
                    }
                    Object[] array = arrayList.toArray(new Float[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    Float[] fArr = (Float[]) array;
                    Pair<Float, String>[] pairArr2 = QPOrderDetailInteractiveViewModel.this.getInteractDist()[0];
                    ArrayList arrayList2 = new ArrayList(pairArr2.length);
                    for (Pair<Float, String> pair2 : pairArr2) {
                        arrayList2.add(pair2.getSecond());
                    }
                    Object[] array2 = arrayList2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    viewContainer2.addChild(new QPDetailLineChartView(fArr, (String[]) array2), new Function1<QPDetailLineChartView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.6
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(QPDetailLineChartView qPDetailLineChartView) {
                            qPDetailLineChartView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.6.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(k kVar) {
                                    k kVar2 = kVar;
                                    kVar2.marginTop(16.0f);
                                    kVar2.size(kVar2.getPagerData().m() - 48.0f, 170.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    this.getClass();
                    new QPOrderDetailInteractiveView$hintLabel$1("\u89c2\u770b\u7528\u6237\u5360\u6bd4").invoke(viewContainer2);
                } else {
                    QPDetailEmptyDataViewKt.QPDetailEmptyDataViewFun(viewContainer2, new Function1<QPDetailEmptyDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.7
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(QPDetailEmptyDataView qPDetailEmptyDataView) {
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (QPOrderDetailInteractiveViewModel.this.shouldShowInteractive()) {
                    cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.8
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(TextView textView) {
                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.8.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ce ceVar) {
                                    h hVar;
                                    ce ceVar2 = ceVar;
                                    ceVar2.text("\u4e92\u52a8\u65f6\u95f4\u5206\u5e03");
                                    ceVar2.marginLeft(16.0f);
                                    ceVar2.alignSelfFlexStart();
                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                    ceVar2.marginTop(16.0f);
                                    ceVar2.marginBottom(3.5f);
                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                    ceVar2.color(hVar);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final QPOrderDetailInteractiveView qPOrderDetailInteractiveView = this;
                    final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel2 = QPOrderDetailInteractiveViewModel.this;
                    qPOrderDetailInteractiveView.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$buttonsRow$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel3 = QPOrderDetailInteractiveViewModel.this;
                            final QPOrderDetailInteractiveView qPOrderDetailInteractiveView2 = qPOrderDetailInteractiveView;
                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$buttonsRow$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.justifyContentFlexStart();
                                            tVar2.alignSelfFlexStart();
                                            tVar2.marginLeft(8.0f);
                                            tVar2.marginTop(16.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel4 = QPOrderDetailInteractiveViewModel.this;
                                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Integer.valueOf(QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag());
                                        }
                                    };
                                    final QPOrderDetailInteractiveView qPOrderDetailInteractiveView3 = qPOrderDetailInteractiveView2;
                                    final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel5 = QPOrderDetailInteractiveViewModel.this;
                                    BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                            BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                            QPOrderDetailInteractiveView qPOrderDetailInteractiveView4 = QPOrderDetailInteractiveView.this;
                                            boolean z16 = qPOrderDetailInteractiveViewModel5.getCurrentInteractiveTag() == 1;
                                            final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel6 = qPOrderDetailInteractiveViewModel5;
                                            ((QPOrderDetailInteractiveView$button$1) QPOrderDetailInteractiveView.access$button(qPOrderDetailInteractiveView4, "\u70b9\u8d5e", z16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.3.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    QPOrderDetailInteractiveViewModel.this.setCurrentInteractiveTag(1);
                                                    return Unit.INSTANCE;
                                                }
                                            })).invoke(bindDirectivesView2);
                                            QPOrderDetailInteractiveView qPOrderDetailInteractiveView5 = QPOrderDetailInteractiveView.this;
                                            boolean z17 = qPOrderDetailInteractiveViewModel5.getCurrentInteractiveTag() == 2;
                                            final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel7 = qPOrderDetailInteractiveViewModel5;
                                            ((QPOrderDetailInteractiveView$button$1) QPOrderDetailInteractiveView.access$button(qPOrderDetailInteractiveView5, "\u5173\u6ce8", z17, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.3.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    QPOrderDetailInteractiveViewModel.this.setCurrentInteractiveTag(2);
                                                    return Unit.INSTANCE;
                                                }
                                            })).invoke(bindDirectivesView2);
                                            QPOrderDetailInteractiveView qPOrderDetailInteractiveView6 = QPOrderDetailInteractiveView.this;
                                            boolean z18 = qPOrderDetailInteractiveViewModel5.getCurrentInteractiveTag() == 3;
                                            final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel8 = qPOrderDetailInteractiveViewModel5;
                                            ((QPOrderDetailInteractiveView$button$1) QPOrderDetailInteractiveView.access$button(qPOrderDetailInteractiveView6, "\u5206\u4eab", z18, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.buttonsRow.1.1.3.3
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    QPOrderDetailInteractiveViewModel.this.setCurrentInteractiveTag(3);
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
                    final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel3 = QPOrderDetailInteractiveViewModel.this;
                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.9
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag());
                        }
                    };
                    final QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel4 = QPOrderDetailInteractiveViewModel.this;
                    final QPOrderDetailInteractiveView qPOrderDetailInteractiveView2 = this;
                    BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView$body$1.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(BindDirectivesView bindDirectivesView) {
                            BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                            if (!(QPOrderDetailInteractiveViewModel.this.getInteractDist()[QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag()].length == 0)) {
                                Pair<Float, String>[] pairArr3 = QPOrderDetailInteractiveViewModel.this.getInteractDist()[QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag()];
                                ArrayList arrayList3 = new ArrayList(pairArr3.length);
                                for (Pair<Float, String> pair3 : pairArr3) {
                                    arrayList3.add(Float.valueOf(pair3.getFirst().floatValue() / 100.0f));
                                }
                                Object[] array3 = arrayList3.toArray(new Float[0]);
                                Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                Float[] fArr2 = (Float[]) array3;
                                Pair<Float, String>[] pairArr4 = QPOrderDetailInteractiveViewModel.this.getInteractDist()[QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag()];
                                ArrayList arrayList4 = new ArrayList(pairArr4.length);
                                for (Pair<Float, String> pair4 : pairArr4) {
                                    arrayList4.add(pair4.getSecond());
                                }
                                Object[] array4 = arrayList4.toArray(new String[0]);
                                Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                bindDirectivesView2.addChild(new QPDetailLineChartView(fArr2, (String[]) array4), new Function1<QPDetailLineChartView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.10.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPDetailLineChartView qPDetailLineChartView) {
                                        qPDetailLineChartView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.10.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(k kVar) {
                                                k kVar2 = kVar;
                                                kVar2.marginTop(16.0f);
                                                kVar2.size(kVar2.getPagerData().m() - 48.0f, 170.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                QPOrderDetailInteractiveView qPOrderDetailInteractiveView3 = qPOrderDetailInteractiveView2;
                                String m3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), new String[]{"\u70b9\u8d5e", "\u5173\u6ce8", "\u5206\u4eab"}[QPOrderDetailInteractiveViewModel.this.getCurrentInteractiveTag() - 1], "\u7528\u6237\u5360\u6bd4");
                                int i3 = QPOrderDetailInteractiveView.$r8$clinit;
                                qPOrderDetailInteractiveView3.getClass();
                                new QPOrderDetailInteractiveView$hintLabel$1(m3).invoke(bindDirectivesView2);
                            } else {
                                QPDetailEmptyDataViewKt.QPDetailEmptyDataViewFun(bindDirectivesView2, new Function1<QPDetailEmptyDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveView.body.1.10.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailEmptyDataView qPDetailEmptyDataView) {
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }
}
