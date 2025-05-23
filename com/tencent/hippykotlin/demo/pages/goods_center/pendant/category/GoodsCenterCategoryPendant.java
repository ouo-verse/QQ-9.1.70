package com.tencent.hippykotlin.demo.pages.goods_center.pendant.category;

import com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterAllCategoryView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterCategoryPendant extends GoodsCenterPendantView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterEvent access$getEvent(GoodsCenterCategoryPendant goodsCenterCategoryPendant) {
        return (GoodsCenterEvent) goodsCenterCategoryPendant.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendantAttr");
        final GoodsCenterCategoryPendantAttr goodsCenterCategoryPendantAttr = (GoodsCenterCategoryPendantAttr) attr;
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendantViewModel");
        final GoodsCenterCategoryPendantViewModel goodsCenterCategoryPendantViewModel = (GoodsCenterCategoryPendantViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterCategoryPendantAttr goodsCenterCategoryPendantAttr2 = GoodsCenterCategoryPendantAttr.this;
                final GoodsCenterCategoryPendantViewModel goodsCenterCategoryPendantViewModel2 = goodsCenterCategoryPendantViewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        Attr.absolutePosition$default(mVar2, ((Number) GoodsCenterCategoryPendantAttr.this.top$delegate.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 4, null);
                        mVar2.mo141height(mVar2.getPagerData().l());
                        mVar2.m152visibility(goodsCenterCategoryPendantViewModel2.getShowAllCategory());
                        return Unit.INSTANCE;
                    }
                });
                final GoodsCenterCategoryPendantViewModel goodsCenterCategoryPendantViewModel3 = goodsCenterCategoryPendantViewModel;
                final GoodsCenterCategoryPendant goodsCenterCategoryPendant = this;
                viewContainer2.addChild(new GoodsCenterAllCategoryView(), new Function1<GoodsCenterAllCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterAllCategoryView goodsCenterAllCategoryView) {
                        GoodsCenterAllCategoryView goodsCenterAllCategoryView2 = goodsCenterAllCategoryView;
                        final GoodsCenterCategoryPendantViewModel goodsCenterCategoryPendantViewModel4 = GoodsCenterCategoryPendantViewModel.this;
                        goodsCenterAllCategoryView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                                goodsCenterCardAttr.viewModel = GoodsCenterCategoryPendantViewModel.this;
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterCategoryPendant goodsCenterCategoryPendant2 = goodsCenterCategoryPendant;
                        goodsCenterAllCategoryView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                                final GoodsCenterCategoryPendant goodsCenterCategoryPendant3 = GoodsCenterCategoryPendant.this;
                                goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendant.body.1.2.2.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(String str, Object obj) {
                                        GoodsCenterCategoryPendant.access$getEvent(GoodsCenterCategoryPendant.this).onFireEvent(str, obj);
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

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterCategoryPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterEvent createEvent() {
        return new GoodsCenterEvent();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterCategoryPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterEvent();
    }
}
