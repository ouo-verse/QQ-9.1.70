package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;

/* loaded from: classes31.dex */
public final class QPOrderDetailPaymentDetailsCardViewModel implements IQPOrderDetailCardViewModel {
    public final QPlusGetPromotionDetailRsp info;

    public QPOrderDetailPaymentDetailsCardViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        this.info = qPlusGetPromotionDetailRsp;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailPaymentDetailsCardView();
    }
}
