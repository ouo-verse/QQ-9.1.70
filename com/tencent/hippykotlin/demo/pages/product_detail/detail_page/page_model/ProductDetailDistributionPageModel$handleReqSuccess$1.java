package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.UtilsKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Category;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailDistributionViewModel;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionPageModel$handleReqSuccess$1 extends Lambda implements Function1<ProductDetailDistributionInfo, Unit> {
    public final /* synthetic */ ProductDetailDistributionPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailDistributionPageModel$handleReqSuccess$1(ProductDetailDistributionPageModel productDetailDistributionPageModel) {
        super(1);
        this.this$0 = productDetailDistributionPageModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ProductDetailDistributionInfo productDetailDistributionInfo) {
        String str;
        Product product;
        Category category;
        ProductDetailDistributionPageModel productDetailDistributionPageModel = this.this$0;
        productDetailDistributionPageModel.pageState$delegate.setValue(productDetailDistributionPageModel, ProductDetailDistributionPageModel.$$delegatedProperties[0], ProductDetailPageState.COMPLETED);
        g pageData = c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        ProductDetailDistributionViewModel productDetailDistributionViewModel = this.this$0.detailViewModel;
        productDetailDistributionViewModel.height$delegate.setValue(productDetailDistributionViewModel, ProductDetailDistributionViewModel.$$delegatedProperties[0], Float.valueOf((pageData.l() - pageData.getNavigationBarHeight()) - 80.0f));
        ProductDetailDistributionPageModel productDetailDistributionPageModel2 = this.this$0;
        productDetailDistributionPageModel2.getClass();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[ProductDetailDistributionPageModel] [initReportParams] params = ");
        m3.append(productDetailDistributionPageModel2.params);
        utils.logToNative(m3.toString());
        IReportParamsBuilder reportParams = productDetailDistributionPageModel2.getReportParams();
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = reportParams instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) reportParams : null;
        if (eCDetailPageReportParamsBuilder != null) {
            ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
            ProductDetailDistributionInfo detailInfo = ProductDetailDistributionRepository.cache.getDetailInfo(productDetailDistributionPageModel2.spuId);
            if (detailInfo == null || (product = detailInfo.detail.product) == null || (category = product.category) == null || (str = category.firstCatId) == null) {
                str = "";
            }
            Intrinsics.areEqual(UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "is_select"), "1");
            eCDetailPageReportParamsBuilder.pgStateType = productDetailDistributionPageModel2.isHalf ? 1 : 2;
            eCDetailPageReportParamsBuilder.contentId = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "little_world_feed_id");
            eCDetailPageReportParamsBuilder.sellerId = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "seller_id");
            eCDetailPageReportParamsBuilder.shopId = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "shop_id");
            eCDetailPageReportParamsBuilder.spuId = productDetailDistributionPageModel2.spuId;
            eCDetailPageReportParamsBuilder.role = 1;
            eCDetailPageReportParamsBuilder.priSortId = str;
            eCDetailPageReportParamsBuilder.sourceFrom = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "source_from");
            eCDetailPageReportParamsBuilder.roomId = String.valueOf(productDetailDistributionPageModel2.params.n("live_room_id"));
            UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "product_type");
            eCDetailPageReportParamsBuilder.activityId = productDetailDistributionPageModel2.params.q("active_id", "");
            eCDetailPageReportParamsBuilder.activityState = 0;
            eCDetailPageReportParamsBuilder.programId = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "qqlive_session_id");
            eCDetailPageReportParamsBuilder.activityType = 0;
            UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "request_id");
            UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, QCircleLpReportDc05507.KEY_SEAL_TRANSFER);
            eCDetailPageReportParamsBuilder.adClickId = UtilsKt.getValueFromParams(productDetailDistributionPageModel2.params, "qz_gdt");
        }
        return Unit.INSTANCE;
    }
}
