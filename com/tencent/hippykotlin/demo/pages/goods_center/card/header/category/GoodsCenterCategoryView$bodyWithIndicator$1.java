package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterCategoryView$bodyWithIndicator$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ GoodsCenterCategoryViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterCategoryView$bodyWithIndicator$1(GoodsCenterCategoryViewModel goodsCenterCategoryViewModel) {
        super(1);
        this.$viewModel = goodsCenterCategoryViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel = this.$viewModel;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$bodyWithIndicator$1.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(GoodsCenterCategoryViewModel.this.getSelectedIndex());
            }
        };
        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel2 = this.$viewModel;
        BindDirectivesViewKt.a(viewContainer, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView$bodyWithIndicator$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel3 = GoodsCenterCategoryViewModel.this;
                w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithIndicator.1.2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final GoodsCenterCategoryViewModel goodsCenterCategoryViewModel4 = GoodsCenterCategoryViewModel.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryView.bodyWithIndicator.1.2.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                GoodsCenterCategoryViewModel goodsCenterCategoryViewModel5 = GoodsCenterCategoryViewModel.this;
                                Attr.absolutePosition$default(tVar2, 0.0f, ((Number) goodsCenterCategoryViewModel5.indicatorFrameX$delegate.getValue(goodsCenterCategoryViewModel5, GoodsCenterCategoryViewModel.$$delegatedProperties[3])).floatValue(), 0.0f, 0.0f, 9, null);
                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getPrimaryTextColor());
                                tVar2.mo153width(20.0f).mo141height(3.0f).borderRadius(1.0f);
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
}
