package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.cache.ProductDetailDistributionCache;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRepository {
    public static final ProductDetailDistributionRepository INSTANCE = new ProductDetailDistributionRepository();
    public static final ProductDetailDistributionCache cache = new ProductDetailDistributionCache();

    public final ProductDetailDistributionInfo getProductInfoCache(String str) {
        return cache.getDetailInfo(str);
    }

    public final void reqProductFullInfo(final String str, final Function1<? super ProductDetailDistributionInfo, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        final Function1<SellerProductCardRsp, Unit> function12 = new Function1<SellerProductCardRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqProductFullInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SellerProductCardRsp sellerProductCardRsp) {
                ProductDetailDistributionCache productDetailDistributionCache = ProductDetailDistributionRepository.cache;
                productDetailDistributionCache.updateDetailCache(str, sellerProductCardRsp);
                if (productDetailDistributionCache.commentCaches.containsKey(productDetailDistributionCache.cacheKey(str))) {
                    function1.invoke(productDetailDistributionCache.getDetailInfo(str));
                }
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<SellerProductCardRsp> iSSOModelFactory = SellerProductCardRsp.Factory;
        Function3<SellerProductCardRsp, Integer, String, Unit> function3 = new Function3<SellerProductCardRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqProductInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(SellerProductCardRsp sellerProductCardRsp, Integer num, String str2) {
                SellerProductCardRsp sellerProductCardRsp2 = sellerProductCardRsp;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0) {
                    function12.invoke(sellerProductCardRsp2);
                } else {
                    function2.invoke(Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        };
        Utils utils = Utils.INSTANCE;
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("spu_id", str, WadlProxyConsts.CHANNEL, 0);
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailBySeller", m3, false, networkUtils$requestWithCmd$2);
        final Function1<ProductReviewGetsRsp, Unit> function13 = new Function1<ProductReviewGetsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqProductFullInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductReviewGetsRsp productReviewGetsRsp) {
                ProductDetailDistributionCache productDetailDistributionCache = ProductDetailDistributionRepository.cache;
                productDetailDistributionCache.updateCommentCache(str, productReviewGetsRsp);
                if (productDetailDistributionCache.detailCaches.containsKey(productDetailDistributionCache.cacheKey(str))) {
                    function1.invoke(productDetailDistributionCache.getDetailInfo(str));
                }
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqProductFullInfo$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                num.intValue();
                ProductDetailDistributionCache productDetailDistributionCache = ProductDetailDistributionRepository.cache;
                productDetailDistributionCache.updateCommentCache(str, new ProductReviewGetsRsp(true, 7));
                if (productDetailDistributionCache.detailCaches.containsKey(productDetailDistributionCache.cacheKey(str))) {
                    function1.invoke(productDetailDistributionCache.getDetailInfo(str));
                }
                return Unit.INSTANCE;
            }
        };
        ISSOModelFactory<ProductReviewGetsRsp> iSSOModelFactory2 = ProductReviewGetsRsp.Factory;
        Function3<ProductReviewGetsRsp, Integer, String, Unit> function32 = new Function3<ProductReviewGetsRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository$reqProductFirstComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ProductReviewGetsRsp productReviewGetsRsp, Integer num, String str2) {
                ProductReviewGetsRsp productReviewGetsRsp2 = productReviewGetsRsp;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0) {
                    function13.invoke(productReviewGetsRsp2);
                } else {
                    function22.invoke(Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule2 = utils.currentBridgeModule();
        e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m(ReportDataBuilder.KEY_PRODUCT_ID, str, "sort_type", 5);
        m16.v("cookie", "");
        m16.t(WadlProxyConsts.CHANNEL, 0);
        currentBridgeModule2.ssoRequest("trpc.ecom.qshop_product_review_read.QshopProductReviewRead/Gets", m16, false, new NetworkUtils$requestWithCmd$2(iSSOModelFactory2, function32));
    }
}
