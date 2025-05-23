package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRecommendView$couponRowView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailDistributionRecommendView $ctx;
    public final /* synthetic */ ProductDetailDistributionRecommendViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailDistributionRecommendView$couponRowView$1(ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel, ProductDetailDistributionRecommendView productDetailDistributionRecommendView) {
        super(1);
        this.$viewModel = productDetailDistributionRecommendViewModel;
        this.$ctx = productDetailDistributionRecommendView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel = this.$viewModel;
        final ProductDetailDistributionRecommendView productDetailDistributionRecommendView = this.$ctx;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$couponRowView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.couponRowView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        c.a.a(tVar2, 8.0f, 8.0f, 0.0f, 8.0f, 4, null);
                        tVar2.mo141height(16.0f);
                        tVar2.overflow(true);
                        tVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                ProductDetailLabelInfo[] couponList = ProductDetailDistributionRecommendViewModel.this.couponList();
                ProductDetailDistributionRecommendView productDetailDistributionRecommendView2 = productDetailDistributionRecommendView;
                for (ProductDetailLabelInfo productDetailLabelInfo : couponList) {
                    ProductDetailDistributionRecommendView.access$couponView(productDetailDistributionRecommendView2, productDetailLabelInfo).invoke(vVar2);
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
