package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPlanDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import kotlin.Pair;

/* loaded from: classes31.dex */
public final class QPOrderDetailDetailInfoCardViewModel implements IQPOrderDetailCardViewModel {
    public final QPlusGetPromotionDetailRsp info;

    public QPOrderDetailDetailInfoCardViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        this.info = qPlusGetPromotionDetailRsp;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailDetailInfoCardView();
    }

    public final Pair<String, String>[] infoList() {
        String str;
        String str2;
        String str3;
        String str4;
        QPlusPlanDetail qPlusPlanDetail;
        String str5;
        QPlusPlanDetail qPlusPlanDetail2;
        QPlusPlanDetail qPlusPlanDetail3;
        QPlusPlanDetail qPlusPlanDetail4;
        QPlusPlanDetail qPlusPlanDetail5;
        QPlusPlanDetail qPlusPlanDetail6;
        QPlusPlanDetail qPlusPlanDetail7;
        Pair<String, String>[] pairArr = new Pair[7];
        QPlusPromotionDetail qPlusPromotionDetail = this.info.promotionDetail;
        String str6 = null;
        pairArr[0] = new Pair<>("\u521b\u5efa\u65f6\u95f4", String.valueOf((qPlusPromotionDetail == null || (qPlusPlanDetail7 = qPlusPromotionDetail.planDetail) == null) ? null : qPlusPlanDetail7.startTime));
        QPlusPromotionDetail qPlusPromotionDetail2 = this.info.promotionDetail;
        if (qPlusPromotionDetail2 != null && (qPlusPlanDetail6 = qPlusPromotionDetail2.planDetail) != null) {
            str6 = qPlusPlanDetail6.endTime;
        }
        pairArr[1] = new Pair<>("\u7ed3\u675f\u65f6\u95f4", String.valueOf(str6));
        QPlusPromotionDetail qPlusPromotionDetail3 = this.info.promotionDetail;
        String str7 = "";
        if (qPlusPromotionDetail3 == null || (qPlusPlanDetail5 = qPlusPromotionDetail3.planDetail) == null || (str = qPlusPlanDetail5.expectCovers) == null) {
            str = "";
        }
        pairArr[2] = new Pair<>("\u671f\u671b\u8986\u76d6\u4eba\u6570", str);
        QPlusPromotionDetail qPlusPromotionDetail4 = this.info.promotionDetail;
        if (qPlusPromotionDetail4 == null || (qPlusPlanDetail4 = qPlusPromotionDetail4.planDetail) == null || (str2 = qPlusPlanDetail4.improveText) == null) {
            str2 = "";
        }
        pairArr[3] = new Pair<>("\u4f18\u5148\u63d0\u5347\u76ee\u6807", str2);
        QPlusPromotionDetail qPlusPromotionDetail5 = this.info.promotionDetail;
        if (qPlusPromotionDetail5 == null || (qPlusPlanDetail3 = qPlusPromotionDetail5.planDetail) == null || (str3 = qPlusPlanDetail3.audienceText) == null) {
            str3 = "";
        }
        pairArr[4] = new Pair<>("\u63a8\u5e7f\u65b9\u5f0f", str3);
        QPlusPromotionDetail qPlusPromotionDetail6 = this.info.promotionDetail;
        if (qPlusPromotionDetail6 == null || (qPlusPlanDetail2 = qPlusPromotionDetail6.planDetail) == null || (str4 = qPlusPlanDetail2.timeText) == null) {
            str4 = "";
        }
        pairArr[5] = new Pair<>("\u63a8\u5e7f\u65f6\u957f", str4);
        QPlusPromotionDetail qPlusPromotionDetail7 = this.info.promotionDetail;
        if (qPlusPromotionDetail7 != null && (qPlusPlanDetail = qPlusPromotionDetail7.planDetail) != null && (str5 = qPlusPlanDetail.planId) != null) {
            str7 = str5;
        }
        pairArr[6] = new Pair<>("\u8ba2\u5355\u7f16\u53f7", str7);
        return pairArr;
    }
}
