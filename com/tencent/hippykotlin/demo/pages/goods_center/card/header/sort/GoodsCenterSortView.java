package com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterOrderBy;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSortView extends ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$changeFilterPanelVisibility(GoodsCenterSortView goodsCenterSortView) {
        ((GoodsCenterEvent) goodsCenterSortView.getEvent()).onFireEvent("change_filter_panel_visibility", null);
        KLog.INSTANCE.i("GoodsCenterSortView", "GoodsCenterSortView isFilterPanelVisibility [changeFilterPanelVisibility]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollGoodsCenterPageToTop(GoodsCenterSortView goodsCenterSortView) {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterSortView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel");
        IGoodsCenterPageModel iGoodsCenterPageModel = ((GoodsCenterSortViewModel) viewModel).pageModel;
        if (iGoodsCenterPageModel != null) {
            iGoodsCenterPageModel.scrollToCeiling(true, false, 0.5f);
        }
        KLog.INSTANCE.i("GoodsCenterSortView", "GoodsCenterSortView isFilterPanelVisibility [scrollGoodsCenterPageToTop]");
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final GoodsCenterSortViewModel safeGetVm = safeGetVm();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), 36.0f);
                        mVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(mVar2).getForegroundColor());
                        a.C5863a.a(mVar2, 0.0f, 16.0f, 0.0f, 0.0f, 13, null);
                        mVar2.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterSortViewModel goodsCenterSortViewModel = GoodsCenterSortViewModel.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GoodsCenterSortViewModel.this.getSortByList();
                    }
                };
                final GoodsCenterSortViewModel goodsCenterSortViewModel2 = GoodsCenterSortViewModel.this;
                final GoodsCenterSortView goodsCenterSortView = this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        if (GoodsCenterSortViewModel.this.getSortByList().isEmpty()) {
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.m140flex(1.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else {
                            final GoodsCenterSortViewModel goodsCenterSortViewModel3 = GoodsCenterSortViewModel.this;
                            final GoodsCenterSortView goodsCenterSortView2 = goodsCenterSortView;
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.m140flex(1.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.allCenter();
                                            tVar2.justifyContentSpaceBetween();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    int size = GoodsCenterSortViewModel.this.getSortByList().size();
                                    for (final int i3 = 0; i3 < size; i3++) {
                                        final GoodsCenterOrderBy goodsCenterOrderBy = GoodsCenterSortViewModel.this.getSortByList().get(i3);
                                        final GoodsCenterSortView goodsCenterSortView3 = goodsCenterSortView2;
                                        int i16 = GoodsCenterSortView.$r8$clinit;
                                        goodsCenterSortView3.getClass();
                                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$createOrderByItemView$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                final GoodsCenterSortViewModel safeGetVm2 = GoodsCenterSortView.this.safeGetVm();
                                                final int i17 = i3;
                                                final GoodsCenterSortView goodsCenterSortView4 = GoodsCenterSortView.this;
                                                final GoodsCenterOrderBy goodsCenterOrderBy2 = goodsCenterOrderBy;
                                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView$createOrderByItemView$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(36.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterSortViewModel goodsCenterSortViewModel4 = GoodsCenterSortViewModel.this;
                                                        final int i18 = i17;
                                                        final GoodsCenterSortView goodsCenterSortView5 = goodsCenterSortView4;
                                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(u uVar) {
                                                                final GoodsCenterSortViewModel goodsCenterSortViewModel5 = GoodsCenterSortViewModel.this;
                                                                final int i19 = i18;
                                                                final GoodsCenterSortView goodsCenterSortView6 = goodsCenterSortView5;
                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        GoodsCenterSortViewModel goodsCenterSortViewModel6 = GoodsCenterSortViewModel.this;
                                                                        int i26 = i19;
                                                                        goodsCenterSortViewModel6.getClass();
                                                                        boolean z16 = false;
                                                                        if ((i26 >= 0 && i26 < goodsCenterSortViewModel6.getSortByList().size()) && !goodsCenterSortViewModel6.getSortByList().get(i26).disabled) {
                                                                            if (goodsCenterSortViewModel6.getSortByList().get(i26).getCurIsSelected()) {
                                                                                if (goodsCenterSortViewModel6.getSortByList().get(i26).getSortable()) {
                                                                                    GoodsCenterOrderBy goodsCenterOrderBy3 = goodsCenterSortViewModel6.getSortByList().get(i26);
                                                                                    goodsCenterOrderBy3.setCurOrderByType((goodsCenterOrderBy3.getCurOrderByType() == 0 || goodsCenterOrderBy3.getCurOrderByType() == 1) ? 2 : 1);
                                                                                }
                                                                            } else {
                                                                                int size2 = goodsCenterSortViewModel6.getSortByList().size();
                                                                                for (int i27 = 0; i27 < size2; i27++) {
                                                                                    GoodsCenterOrderBy goodsCenterOrderBy4 = goodsCenterSortViewModel6.getSortByList().get(i27);
                                                                                    if (i27 == i26) {
                                                                                        goodsCenterOrderBy4.setCurIsSelected(true);
                                                                                        goodsCenterOrderBy4.setCurOrderByType(goodsCenterOrderBy4.defaultOrderByType);
                                                                                    } else {
                                                                                        goodsCenterOrderBy4.setCurIsSelected(false);
                                                                                        goodsCenterOrderBy4.setCurOrderByType(0);
                                                                                    }
                                                                                }
                                                                            }
                                                                            z16 = true;
                                                                        }
                                                                        if (z16) {
                                                                            int i28 = i19;
                                                                            GoodsCenterOrderBy goodsCenterOrderBy5 = GoodsCenterSortViewModel.this.getSortByList().get(i19);
                                                                            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("dimension", i28);
                                                                            if (goodsCenterOrderBy5 != null && goodsCenterOrderBy5.getSortable()) {
                                                                                m3.t("dimension_rank", goodsCenterOrderBy5.getCurOrderByType());
                                                                            }
                                                                            e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, WadlProxyConsts.CHANNEL));
                                                                            Iterator<String> c16 = m3.c();
                                                                            while (c16.hasNext()) {
                                                                                String next = c16.next();
                                                                                m16.v(next, m3.p(next));
                                                                            }
                                                                            Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_goods_dimension_choose", m16);
                                                                            GoodsCenterSortView.access$updateProductList(goodsCenterSortView6, GoodsCenterSortViewModel.this.getSortByList().get(i19));
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterOrderBy goodsCenterOrderBy3 = goodsCenterOrderBy2;
                                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.3
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return Boolean.valueOf(GoodsCenterOrderBy.this.getCurIsSelected());
                                                            }
                                                        };
                                                        final GoodsCenterOrderBy goodsCenterOrderBy4 = goodsCenterOrderBy2;
                                                        BindDirectivesViewKt.a(vVar4, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                                final GoodsCenterOrderBy goodsCenterOrderBy5 = GoodsCenterOrderBy.this;
                                                                cg.a(bindDirectivesView3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final GoodsCenterOrderBy goodsCenterOrderBy6 = GoodsCenterOrderBy.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.4.1.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                long j3;
                                                                                ce ceVar2 = ceVar;
                                                                                GoodsCenterOrderBy goodsCenterOrderBy7 = GoodsCenterOrderBy.this;
                                                                                boolean z16 = goodsCenterOrderBy7.disabled;
                                                                                if (z16) {
                                                                                    j3 = 2154194534L;
                                                                                } else if (z16 || !goodsCenterOrderBy7.getCurIsSelected()) {
                                                                                    GoodsCenterOrderBy goodsCenterOrderBy8 = GoodsCenterOrderBy.this;
                                                                                    j3 = (goodsCenterOrderBy8.disabled || goodsCenterOrderBy8.getCurIsSelected()) ? 4278190080L : 4284900966L;
                                                                                } else {
                                                                                    j3 = 4294914928L;
                                                                                }
                                                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                                ceVar2.fontWeight400();
                                                                                ceVar2.value(GoodsCenterOrderBy.this.name).textAlignCenter();
                                                                                ceVar2.color(j3);
                                                                                ceVar2.alignSelfCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GoodsCenterOrderBy goodsCenterOrderBy5 = goodsCenterOrderBy2;
                                                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.5
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return Boolean.valueOf(GoodsCenterOrderBy.this.getSortable());
                                                            }
                                                        };
                                                        final GoodsCenterOrderBy goodsCenterOrderBy6 = goodsCenterOrderBy2;
                                                        ConditionViewKt.c(vVar4, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.6
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView) {
                                                                final GoodsCenterOrderBy goodsCenterOrderBy7 = GoodsCenterOrderBy.this;
                                                                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.6.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return Integer.valueOf(GoodsCenterOrderBy.this.getCurOrderByType());
                                                                    }
                                                                };
                                                                final GoodsCenterOrderBy goodsCenterOrderBy8 = GoodsCenterOrderBy.this;
                                                                BindDirectivesViewKt.a(conditionView, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.6.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                                                        final GoodsCenterOrderBy goodsCenterOrderBy9 = GoodsCenterOrderBy.this;
                                                                        ah.a(bindDirectivesView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.6.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final String str;
                                                                                ImageView imageView2 = imageView;
                                                                                int curOrderByType = GoodsCenterOrderBy.this.getCurOrderByType();
                                                                                if (curOrderByType == 0) {
                                                                                    str = "qecommerce_skin_icon_general_scroll_secondary";
                                                                                } else if (curOrderByType == 1) {
                                                                                    str = "qecommerce_skin_icon_general_scroll_selected_up";
                                                                                } else if (curOrderByType != 2) {
                                                                                    str = "";
                                                                                } else {
                                                                                    str = "qecommerce_skin_icon_general_scroll_selected_down";
                                                                                }
                                                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.createOrderByItemView.1.1.6.2.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        b.a.b(afVar2, str, false, 2, null);
                                                                                        afVar2.mo153width(16.0f).mo141height(16.0f);
                                                                                        afVar2.marginLeft(4.0f);
                                                                                        afVar2.alignSelfCenter();
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
                                        }.invoke(vVar2);
                                    }
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.2.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(1.0f);
                                                    tVar2.mo141height(12.0f);
                                                    tVar2.mo113backgroundColor(h.INSTANCE.e());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final GoodsCenterSortView goodsCenterSortView3 = goodsCenterSortView;
                            final GoodsCenterSortViewModel goodsCenterSortViewModel4 = GoodsCenterSortViewModel.this;
                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.mo141height(36.0f);
                                            a.C5863a.a(tVar2, 0.0f, 0.0f, 0.0f, 16.0f, 7, null);
                                            tVar2.flexDirectionRow();
                                            tVar2.m133alignSelf(FlexAlign.CENTER);
                                            tVar2.alignItemsCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final GoodsCenterSortView goodsCenterSortView4 = GoodsCenterSortView.this;
                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final GoodsCenterSortView goodsCenterSortView5 = GoodsCenterSortView.this;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("dimension", 4);
                                                    e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, c.f117352a, WadlProxyConsts.CHANNEL));
                                                    Iterator<String> c16 = m3.c();
                                                    while (c16.hasNext()) {
                                                        String next = c16.next();
                                                        m16.v(next, m3.p(next));
                                                    }
                                                    Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_goods_dimension_choose", m16);
                                                    GoodsCenterSortView.access$scrollGoodsCenterPageToTop(GoodsCenterSortView.this);
                                                    GoodsCenterSortView.access$changeFilterPanelVisibility(GoodsCenterSortView.this);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final GoodsCenterSortViewModel goodsCenterSortViewModel5 = goodsCenterSortViewModel4;
                                    Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Boolean.valueOf(GoodsCenterSortViewModel.this.isFilterBtnSelected());
                                        }
                                    };
                                    final GoodsCenterSortViewModel goodsCenterSortViewModel6 = goodsCenterSortViewModel4;
                                    BindDirectivesViewKt.a(vVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(BindDirectivesView bindDirectivesView3) {
                                            BindDirectivesView bindDirectivesView4 = bindDirectivesView3;
                                            final GoodsCenterSortViewModel goodsCenterSortViewModel7 = GoodsCenterSortViewModel.this;
                                            cg.a(bindDirectivesView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final GoodsCenterSortViewModel goodsCenterSortViewModel8 = GoodsCenterSortViewModel.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.4.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                            ceVar2.fontWeight400();
                                                            ceVar2.color(GoodsCenterSortViewModel.this.isFilterBtnSelected() ? 4294914928L : 4284900966L);
                                                            ceVar2.value("\u7b5b\u9009").textAlignCenter();
                                                            c.a.a(ceVar2, 0.0f, 19.0f, 0.0f, 4.0f, 5, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final GoodsCenterSortViewModel goodsCenterSortViewModel8 = GoodsCenterSortViewModel.this;
                                            ah.a(bindDirectivesView4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final String str;
                                                    ImageView imageView2 = imageView;
                                                    if (GoodsCenterSortViewModel.this.isFilterBtnSelected()) {
                                                        str = "qecommerce_skin_icon_general_filter_red";
                                                    } else {
                                                        str = "qecommerce_skin_icon_general_filter_secondary";
                                                    }
                                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView.body.1.4.3.4.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            b.a.b(afVar2, str, false, 2, null);
                                                            afVar2.mo153width(16.0f);
                                                            afVar2.mo141height(16.0f);
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
                        }
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

    /* JADX WARN: Multi-variable type inference failed */
    public final GoodsCenterSortViewModel safeGetVm() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        if (viewModel instanceof GoodsCenterSortViewModel) {
            return (GoodsCenterSortViewModel) viewModel;
        }
        ((GoodsCenterCardAttr) getAttr()).viewModel = new GoodsCenterSortViewModel(null);
        IGoodsCenterCardViewModel viewModel2 = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel");
        return (GoodsCenterSortViewModel) viewModel2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        d layoutFrame;
        super.viewDidLayout();
        FlexNode flexNode = ((GoodsCenterCardAttr) getAttr()).getFlexNode();
        float y16 = (flexNode == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? 0.0f : layoutFrame.getY();
        if (y16 > 0.0f) {
            IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel");
            ((GoodsCenterSortViewModel) viewModel).cardYOffset = (y16 - 36.0f) - 8.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updateProductList(GoodsCenterSortView goodsCenterSortView, GoodsCenterOrderBy goodsCenterOrderBy) {
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) goodsCenterSortView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel");
        GoodsCenterSortViewModel goodsCenterSortViewModel = (GoodsCenterSortViewModel) viewModel;
        IGoodsCenterPageModel iGoodsCenterPageModel = goodsCenterSortViewModel.pageModel;
        if (iGoodsCenterPageModel == null || (goodsCenterSelectProductsReq = iGoodsCenterPageModel.pageDataFilterParams()) == null) {
            goodsCenterSelectProductsReq = new GoodsCenterSelectProductsReq(null, null, null, null, 0, null, null, null, 0L, 511, null);
        }
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq2 = goodsCenterSelectProductsReq;
        IGoodsCenterPageModel iGoodsCenterPageModel2 = goodsCenterSortViewModel.pageModel;
        if (iGoodsCenterPageModel2 != null) {
            iGoodsCenterPageModel2.refreshData(GoodsCenterSelectProductsReq.copy$default(goodsCenterSelectProductsReq2, null, null, null, goodsCenterOrderBy.f114199id, goodsCenterOrderBy.getCurOrderByType(), null, 487));
        }
        KLog.INSTANCE.i("GoodsCenterSortView", "GoodsCenterSortView [updateProductList] orderBy = " + goodsCenterOrderBy + ", currentOrderByType = " + goodsCenterOrderBy.getCurOrderByType());
    }
}
