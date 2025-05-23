package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data;

import com.tencent.hippykotlin.demo.pages.base.ECCategoryAttr;
import com.tencent.hippykotlin.demo.pages.base.ECCategoryEvent;
import com.tencent.hippykotlin.demo.pages.base.ECCategoryView;
import com.tencent.hippykotlin.demo.pages.base.common.ECNumberHelper;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.sep_line.QPlusTrafficHomeCardSepLineViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusAccessHomeDataView extends QPlusTrafficHomeCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPlusTrafficCardHomeViewModel viewModel = ((QPlusTrafficHomeCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataViewModel");
        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel = (QPlusTrafficHomeDataViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                QPlusTrafficHomeCardSepLineViewKt.CardSepLineView(viewContainer2, new Function1<QPlusTrafficHomeCardSepLineView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusTrafficHomeCardSepLineView qPlusTrafficHomeCardSepLineView) {
                        qPlusTrafficHomeCardSepLineView.attr(new Function1<k, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(k kVar) {
                                kVar.marginTop(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel2 = QPlusTrafficHomeDataViewModel.this;
                final QPlusAccessHomeDataView qPlusAccessHomeDataView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel3 = QPlusTrafficHomeDataViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.paddingRight(16.0f);
                                tVar2.mo153width(tVar2.getPagerData().m());
                                if (QPlusTrafficHomeDataViewModel.this.getUiState() != QPlusTrafficUIState.LOADING) {
                                    tVar2.paddingLeft(16.0f);
                                }
                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel4 = QPlusTrafficHomeDataViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(QPlusTrafficHomeDataViewModel.this.getUiState() == QPlusTrafficUIState.COMPLETED || QPlusTrafficHomeDataViewModel.this.getUiState() == QPlusTrafficUIState.FAILURE);
                            }
                        };
                        final QPlusAccessHomeDataView qPlusAccessHomeDataView2 = qPlusAccessHomeDataView;
                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel5 = QPlusTrafficHomeDataViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                QPlusAccessHomeDataView qPlusAccessHomeDataView3 = QPlusAccessHomeDataView.this;
                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel6 = qPlusTrafficHomeDataViewModel5;
                                int i3 = QPlusAccessHomeDataView.$r8$clinit;
                                qPlusAccessHomeDataView3.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithTabView$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel7 = QPlusTrafficHomeDataViewModel.this;
                                        viewContainer3.addChild(new ECCategoryView(), new Function1<ECCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithTabView$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECCategoryView eCCategoryView) {
                                                ECCategoryView eCCategoryView2 = eCCategoryView;
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel8 = QPlusTrafficHomeDataViewModel.this;
                                                eCCategoryView2.attr(new Function1<ECCategoryAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithTabView.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECCategoryAttr eCCategoryAttr) {
                                                        ECCategoryAttr eCCategoryAttr2 = eCCategoryAttr;
                                                        eCCategoryAttr2.marginTop(16.0f).marginLeft(-8.0f);
                                                        eCCategoryAttr2.itemStyle.fontSize = 15.0f;
                                                        eCCategoryAttr2.mo153width(QPlusTrafficHomeDataViewModel.this.categoryTitles.size() * 82.0f).mo141height(32.0f);
                                                        eCCategoryAttr2.itemTitles = QPlusTrafficHomeDataViewModel.this.categoryTitles;
                                                        eCCategoryAttr2.indicatorStyle.color = IPagerIdKtxKt.getSkinColor(eCCategoryAttr2).tokenColor("qecommerce_skin_color_icon_primary", false);
                                                        eCCategoryAttr2.indicatorPosition(0.0f);
                                                        eCCategoryAttr2.indicatorAnimation = true;
                                                        eCCategoryAttr2.switchAutoMoveIndicator = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel9 = QPlusTrafficHomeDataViewModel.this;
                                                eCCategoryView2.event(new Function1<ECCategoryEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithTabView.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECCategoryEvent eCCategoryEvent) {
                                                        ECCategoryEvent eCCategoryEvent2 = eCCategoryEvent;
                                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel10 = QPlusTrafficHomeDataViewModel.this;
                                                        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithTabView.1.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Integer num) {
                                                                QPlusTrafficHomeDataViewModel.this.selectTabIndex(num.intValue());
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        eCCategoryEvent2.getClass();
                                                        eCCategoryEvent2.registerEvent("clickCategorySwitch", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECCategoryEvent$clickCategorySwitch$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                Function1<Integer, Unit> function12 = function1;
                                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                                function12.invoke((Integer) obj);
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
                                }.invoke(conditionView2);
                                final QPlusAccessHomeDataView qPlusAccessHomeDataView4 = QPlusAccessHomeDataView.this;
                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel7 = qPlusTrafficHomeDataViewModel5;
                                qPlusAccessHomeDataView4.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDateTypeView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel8 = QPlusTrafficHomeDataViewModel.this;
                                        final QPlusAccessHomeDataView qPlusAccessHomeDataView5 = qPlusAccessHomeDataView4;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDateTypeView$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeView.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginTop(16.0f);
                                                        tVar2.flexDirection(FlexDirection.ROW);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel9 = QPlusTrafficHomeDataViewModel.this;
                                                Function0<c<QPlusTrafficHomeDataDateTitle>> function02 = new Function0<c<QPlusTrafficHomeDataDateTitle>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeView.1.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final c<QPlusTrafficHomeDataDateTitle> invoke() {
                                                        return QPlusTrafficHomeDataViewModel.this.getDateTitles();
                                                    }
                                                };
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel10 = QPlusTrafficHomeDataViewModel.this;
                                                final QPlusAccessHomeDataView qPlusAccessHomeDataView6 = qPlusAccessHomeDataView5;
                                                LoopDirectivesViewKt.a(vVar4, function02, new Function2<LoopDirectivesView<QPlusTrafficHomeDataDateTitle>, QPlusTrafficHomeDataDateTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeView.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<QPlusTrafficHomeDataDateTitle> loopDirectivesView, QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle) {
                                                        final QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle2 = qPlusTrafficHomeDataDateTitle;
                                                        final int indexOf = QPlusTrafficHomeDataViewModel.this.getDateTitles().indexOf(qPlusTrafficHomeDataDateTitle2);
                                                        QPlusAccessHomeDataView qPlusAccessHomeDataView7 = qPlusAccessHomeDataView6;
                                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel11 = QPlusTrafficHomeDataViewModel.this;
                                                        int i16 = QPlusAccessHomeDataView.$r8$clinit;
                                                        qPlusAccessHomeDataView7.getClass();
                                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDateTypeItemView$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                                final QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle3 = QPlusTrafficHomeDataDateTitle.this;
                                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel12 = qPlusTrafficHomeDataViewModel11;
                                                                final int i17 = indexOf;
                                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDateTypeItemView$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        final QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle4 = QPlusTrafficHomeDataDateTitle.this;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeItemView.1.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirection(FlexDirection.COLUMN);
                                                                                tVar2.justifyContent(FlexJustifyContent.FLEX_START);
                                                                                tVar2.alignItems(FlexAlign.CENTER);
                                                                                tVar2.marginRight(8.0f);
                                                                                tVar2.borderRadius(6.0f);
                                                                                tVar2.padding(4.0f, 8.0f, 4.0f, 8.0f);
                                                                                QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle5 = QPlusTrafficHomeDataDateTitle.this;
                                                                                if (((Boolean) qPlusTrafficHomeDataDateTitle5.isSelect$delegate.getValue(qPlusTrafficHomeDataDateTitle5, QPlusTrafficHomeDataDateTitle.$$delegatedProperties[0])).booleanValue()) {
                                                                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_tag_selected", false, 2, null);
                                                                                } else {
                                                                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_tag_normal", false, 2, null);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel13 = qPlusTrafficHomeDataViewModel12;
                                                                        final int i18 = i17;
                                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeItemView.1.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel14 = QPlusTrafficHomeDataViewModel.this;
                                                                                final int i19 = i18;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeItemView.1.1.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel15 = QPlusTrafficHomeDataViewModel.this;
                                                                                        qPlusTrafficHomeDataViewModel15.selectOverviewData(qPlusTrafficHomeDataViewModel15.selectTabIndex, i19);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle5 = QPlusTrafficHomeDataDateTitle.this;
                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeItemView.1.1.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle6 = QPlusTrafficHomeDataDateTitle.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDateTypeItemView.1.1.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        h hVar;
                                                                                        h hVar2;
                                                                                        ce ceVar2 = ceVar;
                                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                        ceVar2.text((String) QPlusTrafficHomeDataDateTitle.this.title$delegate.getValue());
                                                                                        QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle7 = QPlusTrafficHomeDataDateTitle.this;
                                                                                        if (((Boolean) qPlusTrafficHomeDataDateTitle7.isSelect$delegate.getValue(qPlusTrafficHomeDataDateTitle7, QPlusTrafficHomeDataDateTitle.$$delegatedProperties[0])).booleanValue()) {
                                                                                            ceVar2.fontWeightBold();
                                                                                            hVar2 = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                                                            ceVar2.color(hVar2);
                                                                                        } else {
                                                                                            ceVar2.fontWeightNormal();
                                                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                                            ceVar2.color(hVar);
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
                                                        }.invoke(loopDirectivesView);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView2);
                                final QPlusAccessHomeDataView qPlusAccessHomeDataView5 = QPlusAccessHomeDataView.this;
                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel8 = qPlusTrafficHomeDataViewModel5;
                                qPlusAccessHomeDataView5.getClass();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDataCountView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final float m3 = QPlusAccessHomeDataView.this.getPagerData().m() - 32;
                                        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel9 = qPlusTrafficHomeDataViewModel8;
                                        final QPlusAccessHomeDataView qPlusAccessHomeDataView6 = QPlusAccessHomeDataView.this;
                                        cn.a(viewContainer3, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDataCountView$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cm cmVar) {
                                                cm cmVar2 = cmVar;
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel10 = QPlusTrafficHomeDataViewModel.this;
                                                final float f16 = m3;
                                                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountView.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ck ckVar) {
                                                        h hVar;
                                                        ck ckVar2 = ckVar;
                                                        ckVar2.marginTop(16.0f).marginBottom(16.0f);
                                                        QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel11 = QPlusTrafficHomeDataViewModel.this;
                                                        ReadWriteProperty readWriteProperty = qPlusTrafficHomeDataViewModel11.columnCount$delegate;
                                                        KProperty<?>[] kPropertyArr = QPlusTrafficHomeDataViewModel.$$delegatedProperties;
                                                        ckVar2.h(((Number) readWriteProperty.getValue(qPlusTrafficHomeDataViewModel11, kPropertyArr[2])).intValue());
                                                        ckVar2.w(f16);
                                                        QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel12 = QPlusTrafficHomeDataViewModel.this;
                                                        ckVar2.mo141height(((Number) qPlusTrafficHomeDataViewModel12.overviewHeight$delegate.getValue(qPlusTrafficHomeDataViewModel12, kPropertyArr[3])).floatValue());
                                                        ScrollerAttr.bouncesEnable$default(ckVar2, false, false, 2, null);
                                                        ckVar2.showScrollerIndicator(false);
                                                        hVar = IPagerIdKtxKt.getSkinColor(ckVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                        ckVar2.mo113backgroundColor(hVar);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel11 = QPlusTrafficHomeDataViewModel.this;
                                                Function0<c<QPlusIndex>> function02 = new Function0<c<QPlusIndex>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountView.1.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final c<QPlusIndex> invoke() {
                                                        return QPlusTrafficHomeDataViewModel.this.getOverviewData();
                                                    }
                                                };
                                                final QPlusAccessHomeDataView qPlusAccessHomeDataView7 = qPlusAccessHomeDataView6;
                                                final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel12 = QPlusTrafficHomeDataViewModel.this;
                                                final float f17 = m3;
                                                LoopDirectivesViewKt.a(cmVar2, function02, new Function2<LoopDirectivesView<QPlusIndex>, QPlusIndex, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountView.1.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(LoopDirectivesView<QPlusIndex> loopDirectivesView, QPlusIndex qPlusIndex) {
                                                        final com.tencent.kuikly.core.base.w wVar;
                                                        LoopDirectivesView<QPlusIndex> loopDirectivesView2 = loopDirectivesView;
                                                        final QPlusIndex qPlusIndex2 = qPlusIndex;
                                                        QPlusAccessHomeDataView qPlusAccessHomeDataView8 = QPlusAccessHomeDataView.this;
                                                        QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel13 = qPlusTrafficHomeDataViewModel12;
                                                        float f18 = f17;
                                                        int i16 = qPlusTrafficHomeDataViewModel13.selectTabOverviewCount;
                                                        if (i16 > 4) {
                                                            wVar = new com.tencent.kuikly.core.base.w(f18 / 3, 45.0f);
                                                        } else {
                                                            wVar = new com.tencent.kuikly.core.base.w(f18 / i16, 45.0f);
                                                        }
                                                        int i17 = QPlusAccessHomeDataView.$r8$clinit;
                                                        qPlusAccessHomeDataView8.getClass();
                                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDataCountItemView$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ViewContainer<?, ?> viewContainer4) {
                                                                final com.tencent.kuikly.core.base.w wVar2 = com.tencent.kuikly.core.base.w.this;
                                                                final QPlusIndex qPlusIndex3 = qPlusIndex2;
                                                                w.a(viewContainer4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithDataCountItemView$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        final com.tencent.kuikly.core.base.w wVar3 = com.tencent.kuikly.core.base.w.this;
                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountItemView.1.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                h hVar;
                                                                                t tVar2 = tVar;
                                                                                tVar2.flexDirection(FlexDirection.COLUMN);
                                                                                tVar2.alignItems(FlexAlign.CENTER);
                                                                                tVar2.size(com.tencent.kuikly.core.base.w.this.getWidth(), com.tencent.kuikly.core.base.w.this.getHeight());
                                                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                                                                tVar2.mo113backgroundColor(hVar);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPlusIndex qPlusIndex4 = qPlusIndex3;
                                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountItemView.1.1.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QPlusIndex qPlusIndex5 = QPlusIndex.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountItemView.1.1.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ce.fontSize$default(ceVar2, 20.0f, null, 2, null).fontWeight700();
                                                                                        ceVar2.fontFamily("Qvideo Digit");
                                                                                        ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false));
                                                                                        int i18 = QPlusIndex.this.cnt;
                                                                                        if (i18 >= 0) {
                                                                                            ceVar2.text(ECNumberHelper.formatString$default(i18, 1, 4));
                                                                                        } else {
                                                                                            ceVar2.text("--");
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final QPlusIndex qPlusIndex5 = qPlusIndex3;
                                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountItemView.1.1.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                final QPlusIndex qPlusIndex6 = QPlusIndex.this;
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithDataCountItemView.1.1.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        h hVar;
                                                                                        ce ceVar2 = ceVar;
                                                                                        if (!ceVar2.getPagerData().getIsIOS()) {
                                                                                            ceVar2.marginTop(4.0f);
                                                                                        }
                                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeight400();
                                                                                        ceVar2.fontFamily("PingFang SC");
                                                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                                                                        ceVar2.color(hVar);
                                                                                        ceVar2.text(QPlusIndex.this.indexName);
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
                                                        }.invoke(loopDirectivesView2);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(conditionView2);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusAccessHomeDataView qPlusAccessHomeDataView3 = qPlusAccessHomeDataView;
                        ConditionViewKt.a(vVar2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                QPlusAccessHomeDataView qPlusAccessHomeDataView4 = QPlusAccessHomeDataView.this;
                                int i3 = QPlusAccessHomeDataView.$r8$clinit;
                                qPlusAccessHomeDataView4.getClass();
                                QPlusAccessHomeDataView$bodyWithSkeletonView$1.INSTANCE.invoke(conditionView);
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
