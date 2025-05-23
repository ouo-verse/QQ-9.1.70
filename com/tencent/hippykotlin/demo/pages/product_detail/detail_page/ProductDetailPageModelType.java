package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.BlindBoxProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public enum ProductDetailPageModelType {
    /* JADX INFO: Fake field, exist only in values array */
    SHOP(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$Companion$isThePageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            e eVar2 = eVar;
            return Boolean.valueOf(SchemeParamExtensionKt.schemeBizType(eVar2) == 2 && !SchemeParamExtensionKt.schemeIsDistributor(eVar2));
        }
    }, new Function1<g, ProductDetailShopPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$Companion$newPageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final ProductDetailShopPageModel invoke(g gVar) {
            return new ProductDetailShopPageModel(gVar.n());
        }
    }),
    /* JADX INFO: Fake field, exist only in values array */
    BlindBox(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.BlindBoxProductDetailPageModel$Companion$isThePageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            e eVar2 = eVar;
            Utils.INSTANCE.logToNative("BlindBoxProductDetailPageModel isThePageModelFun params: " + eVar2);
            return Boolean.valueOf(SchemeParamExtensionKt.schemeBizType(eVar2) == 3 && !SchemeParamExtensionKt.schemeIsDistributor(eVar2));
        }
    }, new Function1<g, BlindBoxProductDetailPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.BlindBoxProductDetailPageModel$Companion$newPageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final BlindBoxProductDetailPageModel invoke(g gVar) {
            g gVar2 = gVar;
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxProductDetailPageModel newPageModelFun pageData.userData: ");
            m3.append(PageDataExtKt.getUserData(gVar2));
            utils.logToNative(m3.toString());
            return new BlindBoxProductDetailPageModel(gVar2.n(), PageDataExtKt.getUserData(gVar2));
        }
    }),
    /* JADX INFO: Fake field, exist only in values array */
    DISTRIBUTION(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$Companion$isThePageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            return Boolean.valueOf(SchemeParamExtensionKt.schemeIsDistributor(eVar));
        }
    }, new Function1<g, ProductDetailDistributionPageModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$Companion$newPageModelFun$1
        @Override // kotlin.jvm.functions.Function1
        public final ProductDetailDistributionPageModel invoke(g gVar) {
            return new ProductDetailDistributionPageModel(gVar.n());
        }
    });

    public final Function1<e, Boolean> isThePageModelBlock;
    public final Function1<g, IProductDetailPageModel> newPageModelBlock;

    static {
        ProductDetailShopPageModel.Companion.getClass();
        BlindBoxProductDetailPageModel.Companion.getClass();
        ProductDetailDistributionPageModel.Companion.getClass();
    }

    ProductDetailPageModelType(Function1 function1, Function1 function12) {
        this.isThePageModelBlock = function1;
        this.newPageModelBlock = function12;
    }
}
