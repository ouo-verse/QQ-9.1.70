package com.tencent.hippykotlin.demo.pages.goods_center.card.header;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ScrollParams;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterHeaderView extends GoodsCenterCardView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeaderView.class, "offsetY", "getOffsetY()F", 0)};
    public final ReadWriteProperty offsetY$delegate = c.a(Float.valueOf(-0.5f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterEvent access$getEvent(GoodsCenterHeaderView goodsCenterHeaderView) {
        return (GoodsCenterEvent) goodsCenterHeaderView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel");
        final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = (GoodsCenterHeaderViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.keepAlive(true);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo141height(80.0f);
                        mVar2.flexDirectionColumn().justifyContentFlexStart();
                        mVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(mVar2).getForegroundColor());
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel2 = GoodsCenterHeaderViewModel.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ArrayList<GoodsCenterCategory> categoryList = GoodsCenterHeaderViewModel.this.categoryViewModel.getCategoryList();
                        return Boolean.valueOf(categoryList != null && categoryList.size() == 0);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new GoodsCenterHeaderSkeletonView(), new Function1<GoodsCenterHeaderSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(GoodsCenterHeaderSkeletonView goodsCenterHeaderSkeletonView) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel3 = GoodsCenterHeaderViewModel.this;
                final GoodsCenterHeaderView goodsCenterHeaderView = this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel4 = GoodsCenterHeaderViewModel.this;
                        final GoodsCenterHeaderView goodsCenterHeaderView2 = goodsCenterHeaderView;
                        conditionView2.addChild(new GoodsCenterCategoryView(), new Function1<GoodsCenterCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterCategoryView goodsCenterCategoryView) {
                                GoodsCenterCategoryView goodsCenterCategoryView2 = goodsCenterCategoryView;
                                final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel5 = GoodsCenterHeaderViewModel.this;
                                goodsCenterCategoryView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                                        goodsCenterCardAttr.viewModel = GoodsCenterHeaderViewModel.this.categoryViewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterHeaderView goodsCenterHeaderView3 = goodsCenterHeaderView2;
                                goodsCenterCategoryView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                                        final GoodsCenterHeaderView goodsCenterHeaderView4 = GoodsCenterHeaderView.this;
                                        goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.1.2.1
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(String str, Object obj) {
                                                GoodsCenterHeaderView.access$getEvent(GoodsCenterHeaderView.this).onFireEvent(str, obj);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel5 = GoodsCenterHeaderViewModel.this;
                        final GoodsCenterHeaderView goodsCenterHeaderView3 = goodsCenterHeaderView;
                        conditionView2.addChild(new GoodsCenterSortView(), new Function1<GoodsCenterSortView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterSortView goodsCenterSortView) {
                                GoodsCenterSortView goodsCenterSortView2 = goodsCenterSortView;
                                final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel6 = GoodsCenterHeaderViewModel.this;
                                goodsCenterSortView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                                        goodsCenterCardAttr.viewModel = GoodsCenterHeaderViewModel.this.sortViewModel;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GoodsCenterHeaderView goodsCenterHeaderView4 = goodsCenterHeaderView3;
                                goodsCenterSortView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                                        final GoodsCenterHeaderView goodsCenterHeaderView5 = GoodsCenterHeaderView.this;
                                        goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView.body.1.4.2.2.1
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(String str, Object obj) {
                                                GoodsCenterHeaderView.access$getEvent(GoodsCenterHeaderView.this).onFireEvent(str, obj);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void layoutFrameDidChanged(d dVar) {
        super.layoutFrameDidChanged(dVar);
        if (dVar.getY() > 0.0f) {
            IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel");
            GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = (GoodsCenterHeaderViewModel) viewModel;
            goodsCenterHeaderViewModel.cardFrameY$delegate.setValue(goodsCenterHeaderViewModel, GoodsCenterHeaderViewModel.$$delegatedProperties[0], Float.valueOf(dVar.getY()));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        float offsetY;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel");
        GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = (GoodsCenterHeaderViewModel) viewModel;
        if (goodsCenterHeaderViewModel.isSearching()) {
            offsetY = scrollParams.getOffsetY();
        } else {
            offsetY = scrollParams.getOffsetY() > goodsCenterHeaderViewModel.getCardFrameY() ? scrollParams.getOffsetY() - goodsCenterHeaderViewModel.getCardFrameY() : 0.0f;
        }
        this.offsetY$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(offsetY));
        updateHeaderTopStatus(Float.valueOf(scrollParams.getOffsetY()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateHeaderTopStatus(Float f16) {
        boolean z16;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel");
        GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = (GoodsCenterHeaderViewModel) viewModel;
        if (!goodsCenterHeaderViewModel.isSearching() && !((Boolean) goodsCenterHeaderViewModel.isAddProductState$delegate.getValue(goodsCenterHeaderViewModel, GoodsCenterHeaderViewModel.$$delegatedProperties[2])).booleanValue()) {
            z16 = false;
            if (f16 == null) {
            }
            goodsCenterHeaderViewModel.isHeaderOnTop$delegate.setValue(goodsCenterHeaderViewModel, GoodsCenterHeaderViewModel.$$delegatedProperties[3], Boolean.valueOf(z16));
            goodsCenterHeaderViewModel.categoryViewModel.isHeaderOnTop = z16;
        }
        z16 = true;
        goodsCenterHeaderViewModel.isHeaderOnTop$delegate.setValue(goodsCenterHeaderViewModel, GoodsCenterHeaderViewModel.$$delegatedProperties[3], Boolean.valueOf(z16));
        goodsCenterHeaderViewModel.categoryViewModel.isHeaderOnTop = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel");
        final GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = (GoodsCenterHeaderViewModel) viewModel;
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$viewDidLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(GoodsCenterHeaderViewModel.this.isSearching());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$viewDidLayout$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GoodsCenterHeaderView.this.updateHeaderTopStatus(null);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$viewDidLayout$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(GoodsCenterHeaderViewModel.this.isHeaderOnTop());
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderView$viewDidLayout$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                GoodsCenterHeaderViewModel goodsCenterHeaderViewModel2 = GoodsCenterHeaderViewModel.this;
                if (goodsCenterHeaderViewModel2.showAllCategoryAfterScroll && goodsCenterHeaderViewModel2.isHeaderOnTop()) {
                    GoodsCenterHeaderViewModel goodsCenterHeaderViewModel3 = GoodsCenterHeaderViewModel.this;
                    goodsCenterHeaderViewModel3.categoryViewModel.setShowAllCategory(goodsCenterHeaderViewModel3.isHeaderOnTop());
                    GoodsCenterHeaderViewModel.this.showAllCategoryAfterScroll = false;
                }
                GoodsCenterHeaderView.access$getEvent(this).onFireEvent("change_ceiling_state", Boolean.valueOf(GoodsCenterHeaderViewModel.this.isHeaderOnTop()));
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "KRHoverView";
    }
}
