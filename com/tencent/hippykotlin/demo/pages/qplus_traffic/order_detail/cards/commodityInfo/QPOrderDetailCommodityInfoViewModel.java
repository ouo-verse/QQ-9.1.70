package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;

/* loaded from: classes31.dex */
public final class QPOrderDetailCommodityInfoViewModel implements IQPOrderDetailCardViewModel {
    public final QPlusGetPromotionDetailRsp info;

    public QPOrderDetailCommodityInfoViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        this.info = qPlusGetPromotionDetailRsp;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailCommodityInfoView();
    }
}
