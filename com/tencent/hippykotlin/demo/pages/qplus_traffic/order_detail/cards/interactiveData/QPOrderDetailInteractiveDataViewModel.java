package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusInteractData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailInteractiveDataViewModel implements IQPOrderDetailCardViewModel {
    public final QPlusGetPromotionDetailRsp info;

    public QPOrderDetailInteractiveDataViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        this.info = qPlusGetPromotionDetailRsp;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailInteractiveDataView();
    }

    public final Pair<String, Integer>[] infoList() {
        ArrayList<QPlusIndex> arrayList;
        QPlusPromotionDetail qPlusPromotionDetail = this.info.promotionDetail;
        QPlusInteractData qPlusInteractData = qPlusPromotionDetail != null ? qPlusPromotionDetail.interactData : null;
        ArrayList arrayList2 = new ArrayList();
        if (qPlusInteractData != null && (arrayList = qPlusInteractData.indexs) != null) {
            for (QPlusIndex qPlusIndex : arrayList) {
                arrayList2.add(new Pair(qPlusIndex.indexName, Integer.valueOf(qPlusIndex.cnt)));
            }
        }
        Object[] array = arrayList2.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Pair[]) array;
    }

    public final boolean shouldShow() {
        return !(infoList().length == 0);
    }
}
