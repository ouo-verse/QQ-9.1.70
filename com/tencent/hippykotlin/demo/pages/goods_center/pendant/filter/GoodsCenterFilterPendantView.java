package com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter;

import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterFilterPendantView extends GoodsCenterPendantView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterPendantAttr access$getAttr(GoodsCenterFilterPendantView goodsCenterFilterPendantView) {
        return (GoodsCenterPendantAttr) goodsCenterFilterPendantView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterEvent access$getEvent(GoodsCenterFilterPendantView goodsCenterFilterPendantView) {
        return (GoodsCenterEvent) goodsCenterFilterPendantView.getEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterFilterPendantView goodsCenterFilterPendantView = GoodsCenterFilterPendantView.this;
                IGoodsCenterPendantViewModel viewModel = GoodsCenterFilterPendantView.access$getAttr(goodsCenterFilterPendantView).getViewModel();
                Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantViewModel");
                final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel = (GoodsCenterFilterPendantViewModel) viewModel;
                GoodsCenterPendantAttr access$getAttr = GoodsCenterFilterPendantView.access$getAttr(goodsCenterFilterPendantView);
                Intrinsics.checkNotNull(access$getAttr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantViewAttr");
                final float floatValue = ((Number) ((GoodsCenterFilterPendantViewAttr) access$getAttr).positionTop$delegate.getValue()).floatValue();
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        boolean z16 = false;
                        if (GoodsCenterFilterPendantViewModel.this.isFilterPanelVisibility()) {
                            GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel2 = GoodsCenterFilterPendantViewModel.this;
                            if (((Boolean) goodsCenterFilterPendantViewModel2.isCeilingOrSearchState$delegate.getValue(goodsCenterFilterPendantViewModel2, GoodsCenterFilterPendantViewModel.$$delegatedProperties[0])).booleanValue()) {
                                z16 = true;
                            }
                        }
                        mVar2.m152visibility(z16);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.m154zIndex(10);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f16 = floatValue;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(f16);
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel2 = goodsCenterFilterPendantViewModel;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel3 = GoodsCenterFilterPendantViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterFilterPendantViewModel.this.setFilterPanelVisibility(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel2 = GoodsCenterFilterPendantViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                u uVar2 = uVar;
                                final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel3 = GoodsCenterFilterPendantViewModel.this;
                                uVar2.pan(new Function1<PanGestureParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PanGestureParams panGestureParams) {
                                        GoodsCenterFilterPendantViewModel.this.setFilterPanelVisibility(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel4 = GoodsCenterFilterPendantViewModel.this;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        GoodsCenterFilterPendantViewModel.this.setFilterPanelVisibility(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(tVar2.getPagerData().l());
                                tVar2.backgroundColor(2147483648L);
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel3 = GoodsCenterFilterPendantViewModel.this;
                        final GoodsCenterFilterPendantView goodsCenterFilterPendantView2 = goodsCenterFilterPendantView;
                        vVar2.addChild(new GoodsCenterFilterPanelView(), new Function1<GoodsCenterFilterPanelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterFilterPanelView goodsCenterFilterPanelView) {
                                GoodsCenterFilterPanelView goodsCenterFilterPanelView2 = goodsCenterFilterPanelView;
                                final GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel4 = GoodsCenterFilterPendantViewModel.this;
                                goodsCenterFilterPanelView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                                        goodsCenterCardAttr.viewModel = GoodsCenterFilterPendantViewModel.this;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterFilterPendantView goodsCenterFilterPendantView3 = goodsCenterFilterPendantView2;
                                goodsCenterFilterPanelView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                                        final GoodsCenterFilterPendantView goodsCenterFilterPendantView4 = GoodsCenterFilterPendantView.this;
                                        goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView.body.1.3.3.2.1
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(String str, Object obj) {
                                                GoodsCenterFilterPendantView.access$getEvent(GoodsCenterFilterPendantView.this).onFireEvent(str, obj);
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
                ReactiveObserver.INSTANCE.b(Boolean.valueOf(goodsCenterFilterPendantViewModel.isFilterPanelVisibility()), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        bool.booleanValue();
                        GoodsCenterFilterPendantView.access$getEvent(GoodsCenterFilterPendantView.this).onFireEvent("filter_visibility_changed", Boolean.valueOf(goodsCenterFilterPendantViewModel.isFilterPanelVisibility()));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterFilterPendantViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterFilterPendantViewAttr();
    }
}
