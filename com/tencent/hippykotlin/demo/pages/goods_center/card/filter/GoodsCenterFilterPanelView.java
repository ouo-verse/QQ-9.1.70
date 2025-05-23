package com.tencent.hippykotlin.demo.pages.goods_center.card.filter;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.report.GoodsCenterReporter;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageData;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.luggage.wxa.xd.d1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterFilterPanelView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$changeFilterPanelVisibility(GoodsCenterFilterPanelView goodsCenterFilterPanelView) {
        ((GoodsCenterEvent) goodsCenterFilterPanelView.getEvent()).onFireEvent("change_filter_panel_visibility", Boolean.FALSE);
        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("GoodsCenterFilterPanelView [sendEventToCloseFilterPanel] isVisible = ", false, KLog.INSTANCE, "GoodsCenterFilterPanelView");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final GoodsCenterFilterPanelViewModel access$safeGetVm(GoodsCenterFilterPanelView goodsCenterFilterPanelView) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterFilterPanelView.getAttr()).getViewModel();
        if (viewModel instanceof GoodsCenterFilterPanelViewModel) {
            return (GoodsCenterFilterPanelViewModel) viewModel;
        }
        ((GoodsCenterCardAttr) goodsCenterFilterPanelView.getAttr()).viewModel = new GoodsCenterFilterPanelViewModel(null);
        IGoodsCenterCardViewModel viewModel2 = ((GoodsCenterCardAttr) goodsCenterFilterPanelView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelViewModel");
        return (GoodsCenterFilterPanelViewModel) viewModel2;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterFilterPanelView goodsCenterFilterPanelView = GoodsCenterFilterPanelView.this;
                final GoodsCenterFilterPanelViewModel access$safeGetVm = GoodsCenterFilterPanelView.access$safeGetVm(goodsCenterFilterPanelView);
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                tVar2.borderRadius(0.0f, 0.0f, 8.0f, 8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel = GoodsCenterFilterPanelViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoodsCenterFilterPanelViewModel.this.getCurrentRangeFilterList();
                            }
                        };
                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel2 = GoodsCenterFilterPanelViewModel.this;
                        BindDirectivesViewKt.a(vVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                Iterator<GoodsCenterRangeCond> it = GoodsCenterFilterPanelViewModel.this.getCurrentRangeFilterList().iterator();
                                while (it.hasNext()) {
                                    final GoodsCenterRangeCond next = it.next();
                                    bindDirectivesView2.addChild(new GoodsCenterRangeFilterView(), new Function1<GoodsCenterRangeFilterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1$1$4$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GoodsCenterRangeFilterView goodsCenterRangeFilterView) {
                                            final GoodsCenterRangeCond goodsCenterRangeCond = GoodsCenterRangeCond.this;
                                            goodsCenterRangeFilterView.attr(new Function1<GoodsCenterRangerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1$1$4$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(GoodsCenterRangerAttr goodsCenterRangerAttr) {
                                                    GoodsCenterRangerAttr goodsCenterRangerAttr2 = goodsCenterRangerAttr;
                                                    goodsCenterRangerAttr2.rangeCond$delegate.setValue(goodsCenterRangerAttr2, GoodsCenterRangerAttr.$$delegatedProperties[0], GoodsCenterRangeCond.this);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel3 = GoodsCenterFilterPanelViewModel.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GoodsCenterFilterPanelViewModel.this.getCurrentFilterCondList();
                            }
                        };
                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel4 = GoodsCenterFilterPanelViewModel.this;
                        BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                Iterator<GoodsCenterFilterCond> it = GoodsCenterFilterPanelViewModel.this.getCurrentFilterCondList().iterator();
                                while (it.hasNext()) {
                                    final GoodsCenterFilterCond next = it.next();
                                    bindDirectivesView2.addChild(new GoodsCenterFilterView(), new Function1<GoodsCenterFilterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1$1$6$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GoodsCenterFilterView goodsCenterFilterView) {
                                            final GoodsCenterFilterCond goodsCenterFilterCond = GoodsCenterFilterCond.this;
                                            goodsCenterFilterView.attr(new Function1<GoodsCenterFilterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView$body$1$1$6$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(GoodsCenterFilterAttr goodsCenterFilterAttr) {
                                                    goodsCenterFilterAttr.filterCondViewModel = new GoodsCenterFilterViewMode(GoodsCenterFilterCond.this);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel5 = GoodsCenterFilterPanelViewModel.this;
                        final GoodsCenterFilterPanelView goodsCenterFilterPanelView2 = goodsCenterFilterPanelView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(40.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.margin(32.0f, 16.0f, 16.0f, 16.0f);
                                        tVar2.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel6 = GoodsCenterFilterPanelViewModel.this;
                                final GoodsCenterFilterPanelView goodsCenterFilterPanelView3 = goodsCenterFilterPanelView2;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.borderRadius(4.0f);
                                                tVar2.marginRight(6.0f);
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_secondary_red_normal", false);
                                                tVar2.mo113backgroundColor(hVar);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel7 = GoodsCenterFilterPanelViewModel.this;
                                        final GoodsCenterFilterPanelView goodsCenterFilterPanelView4 = goodsCenterFilterPanelView3;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel8 = GoodsCenterFilterPanelViewModel.this;
                                                final GoodsCenterFilterPanelView goodsCenterFilterPanelView5 = goodsCenterFilterPanelView4;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel9 = GoodsCenterFilterPanelViewModel.this;
                                                        goodsCenterFilterPanelViewModel9.refreshData(goodsCenterFilterPanelViewModel9.resetFilterData());
                                                        GoodsCenterFilterPanelView.access$changeFilterPanelVisibility(goodsCenterFilterPanelView5);
                                                        ((GoodsCenterEvent) goodsCenterFilterPanelView5.getEvent()).onFireEvent("filter_status_changed", Boolean.valueOf(false));
                                                        Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        h hVar;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u53d6\u6d88");
                                                        ceVar2.fontWeightBold();
                                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                                        ceVar2.color(hVar);
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel7 = GoodsCenterFilterPanelViewModel.this;
                                final GoodsCenterFilterPanelView goodsCenterFilterPanelView4 = goodsCenterFilterPanelView2;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                h hVar2;
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.borderRadius(4.0f);
                                                Direction direction = Direction.TO_RIGHT;
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient01_normal", false);
                                                hVar2 = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_btn_gradient02_normal", false);
                                                tVar2.mo135backgroundLinearGradient(direction, new j(hVar, 0.0f), new j(hVar2, 1.0f));
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel8 = GoodsCenterFilterPanelViewModel.this;
                                        final GoodsCenterFilterPanelView goodsCenterFilterPanelView5 = goodsCenterFilterPanelView4;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel9 = GoodsCenterFilterPanelViewModel.this;
                                                final GoodsCenterFilterPanelView goodsCenterFilterPanelView6 = goodsCenterFilterPanelView5;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq;
                                                        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq2;
                                                        GoodsCenterFilterPanelViewModel goodsCenterFilterPanelViewModel10 = GoodsCenterFilterPanelViewModel.this;
                                                        IGoodsCenterPageData iGoodsCenterPageData = goodsCenterFilterPanelViewModel10.pageModel;
                                                        if (iGoodsCenterPageData == null || (goodsCenterSelectProductsReq = iGoodsCenterPageData.pageDataFilterParams()) == null) {
                                                            goodsCenterSelectProductsReq = new GoodsCenterSelectProductsReq(null, null, null, null, 0, null, null, null, 0L, 511, null);
                                                        }
                                                        GoodsCenterReporter goodsCenterReporter = GoodsCenterReporter.INSTANCE;
                                                        GoodsCenterCategory goodsCenterCategory = goodsCenterSelectProductsReq.cat;
                                                        Integer valueOf = goodsCenterCategory != null ? Integer.valueOf(goodsCenterCategory.goodsType) : null;
                                                        GoodsCenterCategory goodsCenterCategory2 = goodsCenterSelectProductsReq.cat;
                                                        Long valueOf2 = goodsCenterCategory2 != null ? Long.valueOf(goodsCenterCategory2.f114195id) : null;
                                                        c<GoodsCenterFilterCond> currentFilterCondList = goodsCenterFilterPanelViewModel10.getCurrentFilterCondList();
                                                        c<GoodsCenterRangeCond> currentRangeFilterList = goodsCenterFilterPanelViewModel10.getCurrentRangeFilterList();
                                                        e eVar = new e();
                                                        eVar.t("goods_type", valueOf != null ? valueOf.intValue() : 0);
                                                        eVar.u("pri_sort_id", valueOf2 != null ? valueOf2.longValue() : 0L);
                                                        eVar.v("filters", goodsCenterReporter.getReportFilterList(currentFilterCondList, currentRangeFilterList));
                                                        goodsCenterReporter.reportDT("xuanpin_goods_filter_pro", eVar);
                                                        List<GoodsCenterFilterCond> reqFilterCondList = goodsCenterFilterPanelViewModel10.getReqFilterCondList();
                                                        List<GoodsCenterRangeCond> reqRangeCondList = goodsCenterFilterPanelViewModel10.getReqRangeCondList();
                                                        IGoodsCenterPageData iGoodsCenterPageData2 = goodsCenterFilterPanelViewModel10.pageModel;
                                                        if (iGoodsCenterPageData2 == null || (goodsCenterSelectProductsReq2 = iGoodsCenterPageData2.pageDataFilterParams()) == null) {
                                                            goodsCenterSelectProductsReq2 = new GoodsCenterSelectProductsReq(null, null, null, null, 0, null, null, null, 0L, 511, null);
                                                        }
                                                        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq3 = goodsCenterSelectProductsReq2;
                                                        IGoodsCenterPageData iGoodsCenterPageData3 = goodsCenterFilterPanelViewModel10.pageModel;
                                                        if (iGoodsCenterPageData3 != null) {
                                                            iGoodsCenterPageData3.refreshData(GoodsCenterSelectProductsReq.copy$default(goodsCenterSelectProductsReq3, null, reqFilterCondList, null, null, 0, reqRangeCondList, d1.CTRL_INDEX));
                                                        }
                                                        GoodsCenterFilterPanelView.access$changeFilterPanelVisibility(goodsCenterFilterPanelView6);
                                                        ((GoodsCenterEvent) goodsCenterFilterPanelView6.getEvent()).onFireEvent("filter_status_changed", Boolean.valueOf(true));
                                                        Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView.body.1.1.7.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text("\u9009\u597d\u4e86");
                                                        ceVar2.fontWeightBold();
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
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
        return new GoodsCenterCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
