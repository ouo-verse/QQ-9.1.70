package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.IQPOrderDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.QPOrderDetailChartAreaViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.pageHeader.QPOrderDetailPageHeaderViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailViewModel implements IQPOrderDetailViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailViewModel.class, "cards", "getCards()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty cards$delegate;
    public ArrayList<IQPOrderDetailCardViewModel> cardsList;

    public QPOrderDetailViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        ArrayList<IQPOrderDetailCardViewModel> arrayListOf;
        this.cardsList = new ArrayList<>();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPOrderDetailPageHeaderViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailCommodityInfoViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailPaymentDetailsCardViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailDetailInfoCardViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailPromotionDataViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailInteractiveDataViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailCommodityDataViewModel(qPlusGetPromotionDetailRsp), new QPOrderDetailChartAreaViewModel(qPlusGetPromotionDetailRsp));
        this.cardsList = arrayListOf;
        this.cards$delegate = c.b();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.IQPOrderDetailViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<IQPOrderDetailCardViewModel> detailCardsViewModel() {
        ReadWriteProperty readWriteProperty = this.cards$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        ((com.tencent.kuikly.core.reactive.collection.c) readWriteProperty.getValue(this, kPropertyArr[0])).addAll(this.cardsList);
        return (com.tencent.kuikly.core.reactive.collection.c) this.cards$delegate.getValue(this, kPropertyArr[0]);
    }
}
