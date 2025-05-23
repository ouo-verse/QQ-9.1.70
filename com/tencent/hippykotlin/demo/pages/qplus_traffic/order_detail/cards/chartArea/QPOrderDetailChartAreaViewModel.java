package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.portraitSubView.QPOrderDetailPortraitViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailChartAreaViewModel implements IQPOrderDetailCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailChartAreaViewModel.class, "subPageIndex", "getSubPageIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailChartAreaViewModel.class, "currentSubPageViewModel", "getCurrentSubPageViewModel()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/order_detail/cards/IQPOrderDetailCardViewModel;", 0)};
    public final ReadWriteProperty currentSubPageViewModel$delegate;
    public final ReadWriteProperty subPageIndex$delegate = c.a(0);
    public final IQPOrderDetailCardViewModel[] subViewsArray;

    public QPOrderDetailChartAreaViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel = new QPOrderDetailInteractiveViewModel(qPlusGetPromotionDetailRsp);
        this.subViewsArray = new IQPOrderDetailCardViewModel[]{qPOrderDetailInteractiveViewModel, new QPOrderDetailPortraitViewModel(qPlusGetPromotionDetailRsp)};
        this.currentSubPageViewModel$delegate = c.a(qPOrderDetailInteractiveViewModel);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailChartAreaView();
    }

    public final int getSubPageIndex() {
        return ((Number) this.subPageIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void handleTabClick(int i3) {
        ReadWriteProperty readWriteProperty = this.subPageIndex$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], Integer.valueOf(i3));
        this.currentSubPageViewModel$delegate.setValue(this, kPropertyArr[1], this.subViewsArray[getSubPageIndex()]);
    }
}
