package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareActionData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailShareProductDetailRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$requestAndShare$1", f = "ProductDetailShopViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ProductDetailShopViewModel$requestAndShare$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ int $action;
    public final /* synthetic */ ShareActionData $actionData;
    public final /* synthetic */ ProductDetailShopViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailShopViewModel$requestAndShare$1(int i3, ProductDetailShopViewModel productDetailShopViewModel, ShareActionData shareActionData, Continuation<? super ProductDetailShopViewModel$requestAndShare$1> continuation) {
        super(2, continuation);
        this.$action = i3;
        this.this$0 = productDetailShopViewModel;
        this.$actionData = shareActionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductDetailShopViewModel$requestAndShare$1(this.$action, this.this$0, this.$actionData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((ProductDetailShopViewModel$requestAndShare$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        final int i3 = this.$action;
        int i16 = 2;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 9) {
                    i16 = 4;
                } else if (i3 == 10) {
                    i16 = 3;
                } else if (i3 != 72 && i3 != 73) {
                    i16 = 0;
                }
            }
            ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
            String str = this.this$0.spuId;
            final ShareActionData shareActionData = this.$actionData;
            final Function1<ProductDetailShareProductDetailRsp, Unit> function1 = new Function1<ProductDetailShareProductDetailRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$requestAndShare$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp) {
                    List mutableListOf;
                    ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp2 = productDetailShareProductDetailRsp;
                    String str2 = productDetailShareProductDetailRsp2.share_info;
                    String str3 = productDetailShareProductDetailRsp2.title;
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(productDetailShareProductDetailRsp2.pic_url);
                    ShareContentData shareContentData = new ShareContentData(0, str2, str3, productDetailShareProductDetailRsp2.desc, mutableListOf, productDetailShareProductDetailRsp2.jump_url, null, 0, 0, 4033);
                    Utils utils = Utils.INSTANCE;
                    ShareModule shareModule = utils.shareModule(utils.currentBridgeModule().getPagerId());
                    int i17 = i3;
                    shareModule.doShareAction(i17, shareActionData, shareContentData, new Function1<Integer, Unit>(i17) { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel.requestAndShare.1.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num) {
                            int intValue = num.intValue();
                            if (intValue != 1 && intValue != 0) {
                                Utils utils2 = Utils.INSTANCE;
                                utils2.bridgeModule(utils2.currentBridgeModule().getPagerId()).toast(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
                            }
                            return Unit.INSTANCE;
                        }

                        {
                            super(1);
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
            final AnonymousClass2 anonymousClass2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$requestAndShare$1.2
                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                    num.intValue();
                    return Unit.INSTANCE;
                }
            };
            NetworkUtils networkUtils = NetworkUtils.INSTANCE;
            ISSOModelFactory<ProductDetailShareProductDetailRsp> iSSOModelFactory = ProductDetailShareProductDetailRsp.Factory;
            Function3<ProductDetailShareProductDetailRsp, Integer, String, Unit> function3 = new Function3<ProductDetailShareProductDetailRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqShareProductInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp, Integer num, String str2) {
                    ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp2 = productDetailShareProductDetailRsp;
                    int intValue = num.intValue();
                    String str3 = str2;
                    if (intValue == 0) {
                        function1.invoke(productDetailShareProductDetailRsp2);
                    } else {
                        anonymousClass2.invoke(Integer.valueOf(intValue), str3);
                    }
                    return Unit.INSTANCE;
                }
            };
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("spu_id", str, "type", i16);
            m3.v("app", "com.tencent.eccommerce");
            m3.v("view", "eccommerce");
            m3.v("ver", "0.0.0.11");
            NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
            int i17 = BridgeModule.$r8$clinit;
            currentBridgeModule.ssoRequest("trpc.ecom.qq_shop_detail_svr.ProductCard/ShareProductDetail", m3, false, networkUtils$requestWithCmd$2);
            return Unit.INSTANCE;
        }
        i16 = 1;
        ProductDetailShopRepository productDetailShopRepository2 = ProductDetailShopRepository.INSTANCE;
        String str2 = this.this$0.spuId;
        final ShareActionData shareActionData2 = this.$actionData;
        final Function1<? super ProductDetailShareProductDetailRsp, Unit> function12 = new Function1<ProductDetailShareProductDetailRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$requestAndShare$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp) {
                List mutableListOf;
                ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp2 = productDetailShareProductDetailRsp;
                String str22 = productDetailShareProductDetailRsp2.share_info;
                String str3 = productDetailShareProductDetailRsp2.title;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(productDetailShareProductDetailRsp2.pic_url);
                ShareContentData shareContentData = new ShareContentData(0, str22, str3, productDetailShareProductDetailRsp2.desc, mutableListOf, productDetailShareProductDetailRsp2.jump_url, null, 0, 0, 4033);
                Utils utils = Utils.INSTANCE;
                ShareModule shareModule = utils.shareModule(utils.currentBridgeModule().getPagerId());
                int i172 = i3;
                shareModule.doShareAction(i172, shareActionData2, shareContentData, new Function1<Integer, Unit>(i172) { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel.requestAndShare.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Integer num) {
                        int intValue = num.intValue();
                        if (intValue != 1 && intValue != 0) {
                            Utils utils2 = Utils.INSTANCE;
                            utils2.bridgeModule(utils2.currentBridgeModule().getPagerId()).toast(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
                        }
                        return Unit.INSTANCE;
                    }

                    {
                        super(1);
                    }
                });
                return Unit.INSTANCE;
            }
        };
        final Function2<? super Integer, ? super String, Unit> anonymousClass22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel$requestAndShare$1.2
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str22) {
                num.intValue();
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils2 = NetworkUtils.INSTANCE;
        ISSOModelFactory<ProductDetailShareProductDetailRsp> iSSOModelFactory2 = ProductDetailShareProductDetailRsp.Factory;
        Function3<ProductDetailShareProductDetailRsp, Integer, String, Unit> function32 = new Function3<ProductDetailShareProductDetailRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository$reqShareProductInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp, Integer num, String str22) {
                ProductDetailShareProductDetailRsp productDetailShareProductDetailRsp2 = productDetailShareProductDetailRsp;
                int intValue = num.intValue();
                String str3 = str22;
                if (intValue == 0) {
                    function12.invoke(productDetailShareProductDetailRsp2);
                } else {
                    anonymousClass22.invoke(Integer.valueOf(intValue), str3);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
        e m36 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("spu_id", str2, "type", i16);
        m36.v("app", "com.tencent.eccommerce");
        m36.v("view", "eccommerce");
        m36.v("ver", "0.0.0.11");
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$22 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory2, function32);
        int i172 = BridgeModule.$r8$clinit;
        currentBridgeModule2.ssoRequest("trpc.ecom.qq_shop_detail_svr.ProductCard/ShareProductDetail", m36, false, networkUtils$requestWithCmd$22);
        return Unit.INSTANCE;
    }
}
