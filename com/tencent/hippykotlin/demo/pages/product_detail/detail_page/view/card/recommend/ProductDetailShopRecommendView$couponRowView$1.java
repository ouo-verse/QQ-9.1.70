package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailShopRecommendView$couponRowView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailShopRecommendView $ctx;
    public final /* synthetic */ ProductDetailShopRecommendViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailShopRecommendView$couponRowView$1(ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel, ProductDetailShopRecommendView productDetailShopRecommendView) {
        super(1);
        this.$viewModel = productDetailShopRecommendViewModel;
        this.$ctx = productDetailShopRecommendView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel = this.$viewModel;
        final ProductDetailShopRecommendView productDetailShopRecommendView = this.$ctx;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$couponRowView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.couponRowView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        c.a.a(tVar2, 0.0f, 8.0f, 8.0f, 8.0f, 1, null);
                        tVar2.mo141height(16.0f);
                        tVar2.overflow(true);
                        tVar2.flexWrap(FlexWrap.WRAP);
                        return Unit.INSTANCE;
                    }
                });
                ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel2 = ProductDetailShopRecommendViewModel.this;
                productDetailShopRecommendViewModel2.getClass();
                ArrayList<ProductDetailLabelInfo> arrayList = new ArrayList<>();
                ArrayList<ProductDetailLabelInfo> arrayList2 = productDetailShopRecommendViewModel2.info.prodTags;
                if (arrayList2 != null) {
                    arrayList = arrayList2;
                }
                ProductDetailShopRecommendView productDetailShopRecommendView2 = productDetailShopRecommendView;
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ProductDetailShopRecommendView.access$couponView(productDetailShopRecommendView2, (ProductDetailLabelInfo) it.next()).invoke(vVar2);
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
