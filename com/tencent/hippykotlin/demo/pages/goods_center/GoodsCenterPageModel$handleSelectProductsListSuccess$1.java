package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.protoc.MsgBox;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.collection.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GoodsCenterPageModel$handleSelectProductsListSuccess$1 extends Lambda implements Function1<GoodsCenterSelectProductsRsp, Unit> {
    public final /* synthetic */ boolean $isLoadMore;
    public final /* synthetic */ GoodsCenterPageModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsCenterPageModel$handleSelectProductsListSuccess$1(GoodsCenterPageModel goodsCenterPageModel, boolean z16) {
        super(1);
        this.this$0 = goodsCenterPageModel;
        this.$isLoadMore = z16;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp) {
        int i3;
        GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp2 = goodsCenterSelectProductsRsp;
        KLog.INSTANCE.i("GoodsCenterPageModel", "[handleSelectProductsListSuccess] rspModel = " + goodsCenterSelectProductsRsp2);
        this.this$0.getClass();
        MsgBox msgBox = goodsCenterSelectProductsRsp2.msgBox;
        if (msgBox != null) {
            Utils.INSTANCE.currentBridgeModule().callNativeMethod("signAlert", msgBox.encode(), null);
        }
        GoodsCenterOrderViewModel goodsCenterOrderViewModel = this.this$0.orderViewModel;
        KProperty<Object>[] kPropertyArr = GoodsCenterOrderViewModel.$$delegatedProperties;
        goodsCenterOrderViewModel.updateRsp(goodsCenterSelectProductsRsp2, false);
        this.this$0.headerViewModel.updateRsp(goodsCenterSelectProductsRsp2);
        GoodsCenterPageModel goodsCenterPageModel = this.this$0;
        goodsCenterPageModel.processProductList(goodsCenterSelectProductsRsp2.productList, goodsCenterPageModel.filterPanelViewModel.getReqFilterCondList(), this.this$0.filterPanelViewModel.getReqRangeCondList());
        GoodsCenterPageModel goodsCenterPageModel2 = this.this$0;
        ArrayList<GoodsCenterProductInfo> arrayList = goodsCenterSelectProductsRsp2.productList;
        if (!(arrayList != null && arrayList.isEmpty()) || this.$isLoadMore) {
            i3 = goodsCenterSelectProductsRsp2.isEnd ? 7 : 1;
        } else {
            i3 = 4;
        }
        goodsCenterPageModel2.refreshState$enumunboxing$(i3);
        ArrayList<GoodsCenterRangeCond> arrayList2 = goodsCenterSelectProductsRsp2.rangeCond;
        if (arrayList2 != null) {
            GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel = this.this$0.filterPanelViewModel;
            goodsCenterFilterPendantViewModel._rangeFilterOriginStatusList.clear();
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                goodsCenterFilterPendantViewModel._rangeFilterOriginStatusList.add(GoodsCenterRangeCond.copy$default((GoodsCenterRangeCond) it.next(), 0L, 0L, 1023));
            }
            if (goodsCenterFilterPendantViewModel.shouldResetCurRangeFilterList) {
                Intrinsics.checkNotNull(arrayList2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond>");
                goodsCenterFilterPendantViewModel.currentRangeFilterList$delegate.setValue(goodsCenterFilterPendantViewModel, GoodsCenterFilterPanelViewModel.$$delegatedProperties[1], new c(TypeIntrinsics.asMutableList(arrayList2), null, null, 6, null));
                goodsCenterFilterPendantViewModel.shouldResetCurRangeFilterList = false;
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterFilterPanelViewModel [updateRangeCond] rangeCondFilterList = ");
            m3.append(goodsCenterFilterPendantViewModel.getCurrentRangeFilterList());
            kLog.i("GoodsCenterFilterPanelViewModel", m3.toString());
        }
        ArrayList<GoodsCenterFilterCond> arrayList3 = goodsCenterSelectProductsRsp2.filterCondList;
        if (arrayList3 != null) {
            GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel2 = this.this$0.filterPanelViewModel;
            goodsCenterFilterPendantViewModel2.getClass();
            goodsCenterFilterPendantViewModel2._condFilterOriginStatusList = new ArrayList<>();
            Iterator<T> it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                goodsCenterFilterPendantViewModel2._condFilterOriginStatusList.add(GoodsCenterFilterCond.copy$default((GoodsCenterFilterCond) it5.next(), null, 15));
            }
            if (goodsCenterFilterPendantViewModel2.shouldResetCurCondFilterList) {
                Intrinsics.checkNotNull(arrayList3, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond>");
                goodsCenterFilterPendantViewModel2.currentFilterCondList$delegate.setValue(goodsCenterFilterPendantViewModel2, GoodsCenterFilterPanelViewModel.$$delegatedProperties[0], new c(TypeIntrinsics.asMutableList(arrayList3), null, null, 6, null));
                goodsCenterFilterPendantViewModel2.shouldResetCurCondFilterList = false;
            }
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterFilterPanelViewModel [updateFilterCond] filterCondList = ");
            m16.append(goodsCenterFilterPendantViewModel2.getCurrentFilterCondList());
            kLog2.i("GoodsCenterFilterPanelViewModel", m16.toString());
        }
        this.this$0.reportShowPageCostTime$enumunboxing$(2);
        return Unit.INSTANCE;
    }
}
