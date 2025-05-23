package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButton;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailShopPageModel$handleReqSuccess$1 extends Lambda implements Function2<ProductDetailInfo, ProductDetailInfoType, Unit> {
    public final /* synthetic */ int $reqType;
    public final /* synthetic */ ProductDetailShopPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailShopPageModel$handleReqSuccess$1(ProductDetailShopPageModel productDetailShopPageModel, int i3) {
        super(2);
        this.this$0 = productDetailShopPageModel;
        this.$reqType = i3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ProductDetailInfo productDetailInfo, ProductDetailInfoType productDetailInfoType) {
        ProductDetailButtonItem[] productDetailButtonItemArr;
        Object last;
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailButton productDetailButton;
        ArrayList<ProductDetailButtonItem> arrayList;
        ProductDetailInfo productDetailInfo2 = productDetailInfo;
        ProductDetailInfoType productDetailInfoType2 = productDetailInfoType;
        ProductDetailShopPageModel productDetailShopPageModel = this.this$0;
        boolean z16 = false;
        productDetailShopPageModel.pageState$delegate.setValue(productDetailShopPageModel, ProductDetailShopPageModel.$$delegatedProperties[0], ProductDetailPageState.COMPLETED);
        if (this.$reqType == 2 && productDetailInfoType2 == ProductDetailInfoType.DETAIL && this.this$0.buyNow) {
            if (productDetailInfo2 == null || (productDetailProductCardRsp = productDetailInfo2.detail) == null || (productDetailButton = productDetailProductCardRsp.button) == null || (arrayList = productDetailButton.buttonItem) == null) {
                productDetailButtonItemArr = null;
            } else {
                Object[] array = arrayList.toArray(new ProductDetailButtonItem[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                productDetailButtonItemArr = (ProductDetailButtonItem[]) array;
            }
            if (productDetailButtonItemArr != null && productDetailButtonItemArr.length == 3) {
                z16 = true;
            }
            if (z16) {
                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                last = ArraysKt___ArraysKt.last(productDetailButtonItemArr);
                BridgeModule.openPage$default(currentBridgeModule, ((ProductDetailButtonItem) last).jumpUrl, false, null, null, 30);
            }
        }
        return Unit.INSTANCE;
    }
}
