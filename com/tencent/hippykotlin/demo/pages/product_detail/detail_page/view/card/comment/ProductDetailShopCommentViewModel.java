package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewRptData;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewTextData;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public final class ProductDetailShopCommentViewModel extends ProductDetailCommentViewModel {
    public final String frameChangeEventName = "comment_card_frame_change";
    public final ProductDetailInfo info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(getSpuId());
    public IReportParamsBuilder reportParams;
    public final String spuId;

    public ProductDetailShopCommentViewModel(String str, IReportParamsBuilder iReportParamsBuilder) {
        this.spuId = str;
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailCommentViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final String cardFrameChangeEventName() {
        return this.frameChangeEventName;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final ArrayList<ProductReviewReviewDetail> commentAllItems() {
        ProductReviewGetsRsp productReviewGetsRsp;
        ArrayList<ProductReviewReviewDetail> arrayList;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productReviewGetsRsp = productDetailInfo.comment) == null || (arrayList = productReviewGetsRsp.reviewDetail) == null) ? new ArrayList<>() : arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final String commentCountText() {
        ProductReviewGetsRsp productReviewGetsRsp;
        ProductDetailInfo productDetailInfo = this.info;
        int i3 = (productDetailInfo == null || (productReviewGetsRsp = productDetailInfo.comment) == null) ? 0 : productReviewGetsRsp.reviewCount;
        this.canJumpToList$delegate.setValue(this, ProductDetailCommentViewModel.$$delegatedProperties[0], Boolean.valueOf(i3 > 0));
        if (i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('\uff08');
            sb5.append(i3);
            sb5.append('\uff09');
            return sb5.toString();
        }
        return "\uff08\u6682\u65e0\u8bc4\u4ef7\uff09";
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopCommentView();
    }

    public final String getSpuId() {
        return this.spuId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final void handleTapCard() {
        Utils utils = Utils.INSTANCE;
        BridgeModule.openPage$default(utils.currentBridgeModule(), OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://ecommerce/open?target=39&spu_id="), this.spuId, "&src_type=internal&version=1"), false, null, null, 30);
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_comment_ck", "[ProductDetailReporter] reportCommentClk, event cod = qstore_prd_detail_pg_comment_ck, data = "), utils);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.ProductDetailCommentViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        ProductDetailInfo productDetailInfo = this.info;
        if (productDetailInfo == null) {
            return false;
        }
        ProductReviewGetsRsp productReviewGetsRsp = productDetailInfo.comment;
        return (productReviewGetsRsp != null ? productReviewGetsRsp.reviewDetail : null) != null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final String reviewContent(ProductReviewReviewDetail productReviewReviewDetail) {
        ArrayList<ProductReviewRptData> arrayList;
        ProductReviewRptData productReviewRptData;
        ProductReviewTextData productReviewTextData;
        String str;
        ArrayList<ProductReviewRptData> arrayList2 = productReviewReviewDetail.reviewContent;
        return ((arrayList2 != null && arrayList2.size() == 0) || (arrayList = productReviewReviewDetail.reviewContent) == null || (productReviewRptData = arrayList.get(0)) == null || (productReviewTextData = productReviewRptData.textData) == null || (str = productReviewTextData.content) == null) ? "\u8be5\u7528\u6237\u6ca1\u6709\u586b\u5199\u8bc4\u4ef7\u5185\u5bb9" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment.IProductDetailShopCommentViewModel
    public final int scoreStars(ProductReviewReviewDetail productReviewReviewDetail) {
        return productReviewReviewDetail.productQualityScore / 10;
    }
}
