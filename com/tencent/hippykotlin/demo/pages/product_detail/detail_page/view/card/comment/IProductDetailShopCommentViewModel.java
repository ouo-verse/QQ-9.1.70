package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.comment;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewReviewDetail;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public interface IProductDetailShopCommentViewModel {
    String cardFrameChangeEventName();

    ArrayList<ProductReviewReviewDetail> commentAllItems();

    String commentCountText();

    void handleTapCard();

    String reviewContent(ProductReviewReviewDetail productReviewReviewDetail);

    int scoreStars(ProductReviewReviewDetail productReviewReviewDetail);
}
