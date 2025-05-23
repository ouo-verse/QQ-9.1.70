package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailInfoType;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.cache.ProductDetailShopCache;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailShopRepository$reqBlindBoxProductFullInfo$1 extends Lambda implements Function1<ProductDetailProductCardRsp, Unit> {
    public final /* synthetic */ String $spuId;
    public final /* synthetic */ Function2<ProductDetailInfo, ProductDetailInfoType, Unit> $successBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductDetailShopRepository$reqBlindBoxProductFullInfo$1(String str, Function2<? super ProductDetailInfo, ? super ProductDetailInfoType, Unit> function2) {
        super(1);
        this.$spuId = str;
        this.$successBlock = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ProductDetailProductCardRsp productDetailProductCardRsp) {
        ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
        productDetailShopCache.updateDetailCache(this.$spuId, productDetailProductCardRsp);
        this.$successBlock.invoke(productDetailShopCache.getDetailInfo(this.$spuId), ProductDetailInfoType.DETAIL);
        return Unit.INSTANCE;
    }
}
