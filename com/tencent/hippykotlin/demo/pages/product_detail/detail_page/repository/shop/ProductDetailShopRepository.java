package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailInfoType;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ExplainGetShopLiveStatusRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.cache.ProductDetailShopCache;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class ProductDetailShopRepository {
    public static final ProductDetailShopRepository INSTANCE = new ProductDetailShopRepository();
    public static final ProductDetailShopCache cache = new ProductDetailShopCache();

    public final ProductDetailInfo getProductInfoCache(String str) {
        return cache.getDetailInfo(str);
    }

    public final void reqBlindBoxProductFullInfo(String str, Function2<? super ProductDetailInfo, ? super ProductDetailInfoType, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        reqProductInfo(str, new ProductDetailShopRepository$reqBlindBoxProductFullInfo$1(str, function2), function22, true);
    }

    public final void reqLiveIconInfo(String str, long j3, final Function1<? super ExplainGetShopLiveStatusRsp, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        final Function1<ExplainGetShopLiveStatusRsp, Unit> function12 = new Function1<ExplainGetShopLiveStatusRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveIconInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp) {
                function1.invoke(explainGetShopLiveStatusRsp);
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveIconInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                function2.invoke(Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ExplainGetShopLiveStatusRsp> iSSOModelFactory = ExplainGetShopLiveStatusRsp.Factory;
        Function3<ExplainGetShopLiveStatusRsp, Integer, String, Unit> function3 = new Function3<ExplainGetShopLiveStatusRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp, Integer num, String str2) {
                ExplainGetShopLiveStatusRsp explainGetShopLiveStatusRsp2 = explainGetShopLiveStatusRsp;
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0) {
                    function12.invoke(explainGetShopLiveStatusRsp2);
                } else {
                    function22.invoke(Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("shop_id", "", "spu_id", str);
        m3.v("sku_id", "");
        m3.t(WadlProxyConsts.CHANNEL, 0);
        m3.u(AudienceReportConst.ROOM_ID, j3);
        m3.v("from", "500002");
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qqlive_window_read_svr.QqliveWindowReadSvr/GetGoodsLiveStatus", m3, false, networkUtils$requestWithCmd$2);
    }

    public final void reqLiveProductFullInfo(final String str, String str2, final Function2<? super ProductDetailInfo, ? super ProductDetailInfoType, Unit> function2, final Function2<? super Integer, ? super String, Unit> function22) {
        reqProductFirstComment(str, new Function1<ProductReviewGetsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveProductFullInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductReviewGetsRsp productReviewGetsRsp) {
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateCommentCache(str, productReviewGetsRsp);
                if (productDetailShopCache.detailCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.COMMENT);
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveProductFullInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str3) {
                num.intValue();
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateCommentCache(str, new ProductReviewGetsRsp(true, 7));
                if (productDetailShopCache.detailCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.COMMENT);
                }
                return Unit.INSTANCE;
            }
        });
        final Function1<ProductDetailProductCardRsp, Unit> function1 = new Function1<ProductDetailProductCardRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveProductFullInfo$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailProductCardRsp productDetailProductCardRsp) {
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateDetailCache(str, productDetailProductCardRsp);
                if (productDetailShopCache.commentCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.DETAIL);
                }
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ProductDetailProductCardRsp> iSSOModelFactory = ProductDetailProductCardRsp.Factory;
        Function3<ProductDetailProductCardRsp, Integer, String, Unit> function3 = new Function3<ProductDetailProductCardRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqLiveProductInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ProductDetailProductCardRsp productDetailProductCardRsp, Integer num, String str3) {
                ProductDetailProductCardRsp productDetailProductCardRsp2 = productDetailProductCardRsp;
                int intValue = num.intValue();
                String str4 = str3;
                if (intValue == 0) {
                    function1.invoke(productDetailProductCardRsp2);
                } else {
                    function22.invoke(Integer.valueOf(intValue), str4);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("shop_id", "", "spu_id", str);
        m3.t(WadlProxyConsts.CHANNEL, 0);
        m3.v("active_id", str2);
        m3.t("is_preload", 0);
        currentBridgeModule.ssoRequest("trpc.ecom.qq_shop_detail_svr.ProductCard/GetActiveProductDetailByBuyer", m3, false, new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3));
    }

    public final void reqProductFirstComment(String str, final Function1<? super ProductReviewGetsRsp, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ProductReviewGetsRsp> iSSOModelFactory = ProductReviewGetsRsp.Factory;
        Function3<ProductReviewGetsRsp, Integer, String, Unit> function3 = new Function3<ProductReviewGetsRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqProductFirstComment$1
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
                if (intValue == 0 && productReviewGetsRsp2 != null) {
                    function1.invoke(productReviewGetsRsp2);
                } else {
                    function2.invoke(Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m(ReportDataBuilder.KEY_PRODUCT_ID, str, "sort_type", 5);
        m3.v("cookie", "");
        m3.t(WadlProxyConsts.CHANNEL, 0);
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.qshop_product_review_read.QshopProductReviewRead/Gets", m3, false, networkUtils$requestWithCmd$2);
    }

    public final void reqProductFullInfo(final String str, final Function2<? super ProductDetailInfo, ? super ProductDetailInfoType, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        reqProductFirstComment(str, new Function1<ProductReviewGetsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqProductFullInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductReviewGetsRsp productReviewGetsRsp) {
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateCommentCache(str, productReviewGetsRsp);
                if (productDetailShopCache.detailCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.COMMENT);
                }
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqProductFullInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                num.intValue();
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateCommentCache(str, new ProductReviewGetsRsp(true, 7));
                if (productDetailShopCache.detailCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.COMMENT);
                }
                return Unit.INSTANCE;
            }
        });
        reqProductInfo(str, new Function1<ProductDetailProductCardRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqProductFullInfo$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailProductCardRsp productDetailProductCardRsp) {
                ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
                productDetailShopCache.updateDetailCache(str, productDetailProductCardRsp);
                if (productDetailShopCache.commentCaches.containsKey(str)) {
                    function2.invoke(productDetailShopCache.getDetailInfo(str), ProductDetailInfoType.DETAIL);
                }
                return Unit.INSTANCE;
            }
        }, function22, false);
    }

    public final void reqProductInfo(String str, final Function1 function1, final Function2 function2, boolean z16) {
        String str2;
        if (z16) {
            str2 = "trpc.ecom.mystery_boxes_info_reader.BoxInfoReader/GetProductDetailByBuyer";
        } else {
            str2 = "trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailByBuyer";
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<ProductDetailProductCardRsp> iSSOModelFactory = ProductDetailProductCardRsp.Factory;
        Function3<ProductDetailProductCardRsp, Integer, String, Unit> function3 = new Function3<ProductDetailProductCardRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqProductInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ProductDetailProductCardRsp productDetailProductCardRsp, Integer num, String str3) {
                ProductDetailProductCardRsp productDetailProductCardRsp2 = productDetailProductCardRsp;
                int intValue = num.intValue();
                String str4 = str3;
                if (intValue == 0 && productDetailProductCardRsp2 != null) {
                    function1.invoke(productDetailProductCardRsp2);
                } else {
                    function2.invoke(Integer.valueOf(intValue), str4);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("spu_id", str, "is_preload", 0);
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest(str2, m3, false, networkUtils$requestWithCmd$2);
    }
}
