package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailPageModel$handleReqSuccess$1 extends Lambda implements Function2<ProductDetailInfo, ProductDetailInfoType, Unit> {
    public final /* synthetic */ BlindBoxProductDetailPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxProductDetailPageModel$handleReqSuccess$1(BlindBoxProductDetailPageModel blindBoxProductDetailPageModel) {
        super(2);
        this.this$0 = blindBoxProductDetailPageModel;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.IBlindBoxProductDetailBottomBarViewModel] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(ProductDetailInfo productDetailInfo, ProductDetailInfoType productDetailInfoType) {
        ProductDetailInfo productDetailInfo2 = productDetailInfo;
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxProductDetailPageModel success, productDetailInfo: ");
        m3.append(productDetailInfo2 != null ? productDetailInfo2.detail : null);
        utils.logToNative(m3.toString());
        this.this$0.bottomViewModel.setHeight(BlindBoxProductDetailBottomBar.bottomBarHeight$delegate.getValue().floatValue());
        BlindBoxProductDetailPageModel blindBoxProductDetailPageModel = this.this$0;
        blindBoxProductDetailPageModel.pageState$delegate.setValue(blindBoxProductDetailPageModel, BlindBoxProductDetailPageModel.$$delegatedProperties[0], ProductDetailPageState.COMPLETED);
        return Unit.INSTANCE;
    }
}
