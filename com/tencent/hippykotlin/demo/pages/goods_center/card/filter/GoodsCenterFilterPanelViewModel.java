package com.tencent.hippykotlin.demo.pages.goods_center.card.filter;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterOption;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageData;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.luggage.wxa.xd.d1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public class GoodsCenterFilterPanelViewModel implements IGoodsCenterCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterFilterPanelViewModel.class, "currentFilterCondList", "getCurrentFilterCondList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterFilterPanelViewModel.class, "currentRangeFilterList", "getCurrentRangeFilterList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public ArrayList<GoodsCenterFilterCond> _condFilterOriginStatusList;
    public ArrayList<GoodsCenterRangeCond> _rangeFilterOriginStatusList;
    public final ReadWriteProperty currentFilterCondList$delegate;
    public final ReadWriteProperty currentRangeFilterList$delegate;
    public final IGoodsCenterPageData pageModel;
    public boolean shouldResetCurCondFilterList;
    public boolean shouldResetCurRangeFilterList;

    public GoodsCenterFilterPanelViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterFilterPanelView();
    }

    public final c<GoodsCenterFilterCond> getCurrentFilterCondList() {
        return (c) this.currentFilterCondList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final c<GoodsCenterRangeCond> getCurrentRangeFilterList() {
        return (c) this.currentRangeFilterList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final List<GoodsCenterFilterCond> getReqFilterCondList() {
        ArrayList arrayList = new ArrayList();
        Iterator<GoodsCenterFilterCond> it = getCurrentFilterCondList().iterator();
        while (it.hasNext()) {
            GoodsCenterFilterCond next = it.next();
            ArrayList arrayList2 = new ArrayList();
            for (GoodsCenterFilterOption goodsCenterFilterOption : next.options) {
                if (goodsCenterFilterOption.isSelected()) {
                    arrayList2.add(goodsCenterFilterOption);
                }
            }
            arrayList.add(GoodsCenterFilterCond.copy$default(next, arrayList2, 11));
        }
        return arrayList;
    }

    public final List<GoodsCenterRangeCond> getReqRangeCondList() {
        ArrayList arrayList = new ArrayList();
        int size = getCurrentRangeFilterList().size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                GoodsCenterRangeCond goodsCenterRangeCond = getCurrentRangeFilterList().get(i3);
                long j3 = goodsCenterRangeCond.lower;
                boolean z16 = j3 != -1;
                long j16 = goodsCenterRangeCond.upper;
                boolean z17 = j16 != -1;
                if (z16 && z17) {
                    long min = Math.min(j3, goodsCenterRangeCond.maxLimit);
                    goodsCenterRangeCond.lower = min;
                    goodsCenterRangeCond.lower = Math.max(min, goodsCenterRangeCond.minLimit);
                    long min2 = Math.min(goodsCenterRangeCond.upper, goodsCenterRangeCond.maxLimit);
                    goodsCenterRangeCond.upper = min2;
                    long max = Math.max(min2, goodsCenterRangeCond.minLimit);
                    goodsCenterRangeCond.upper = max;
                    long j17 = goodsCenterRangeCond.lower;
                    if (j17 > max) {
                        goodsCenterRangeCond.lower = max;
                        goodsCenterRangeCond.upper = j17;
                    }
                    arrayList.add(GoodsCenterRangeCond.copy$default(goodsCenterRangeCond, 0L, 0L, 1023));
                } else if (z16) {
                    long min3 = Math.min(j3, goodsCenterRangeCond.maxLimit);
                    goodsCenterRangeCond.lower = min3;
                    goodsCenterRangeCond.lower = Math.max(min3, goodsCenterRangeCond.minLimit);
                    arrayList.add(GoodsCenterRangeCond.copy$default(goodsCenterRangeCond, 0L, goodsCenterRangeCond.maxLimit, 1007));
                } else if (z17) {
                    long min4 = Math.min(j16, goodsCenterRangeCond.maxLimit);
                    goodsCenterRangeCond.upper = min4;
                    goodsCenterRangeCond.upper = Math.max(min4, goodsCenterRangeCond.minLimit);
                    arrayList.add(GoodsCenterRangeCond.copy$default(goodsCenterRangeCond, goodsCenterRangeCond.minLimit, 0L, 1019));
                }
                i3++;
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(getCurrentRangeFilterList());
                this.currentRangeFilterList$delegate.setValue(this, $$delegatedProperties[1], new c(TypeIntrinsics.asMutableList(arrayList2), null, null, 6, null));
                KLog.INSTANCE.i("GoodsCenterFilterPanelViewModel", "GoodsCenterFilterPanelViewModel [getReqRangeCondList] reqRangeList = " + arrayList);
                return arrayList;
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }

    public GoodsCenterFilterPanelViewModel(IGoodsCenterPageData iGoodsCenterPageData) {
        this.pageModel = iGoodsCenterPageData;
        this.currentFilterCondList$delegate = c01.c.b();
        this.currentRangeFilterList$delegate = c01.c.b();
        this._condFilterOriginStatusList = new ArrayList<>();
        this._rangeFilterOriginStatusList = new ArrayList<>();
        this.shouldResetCurCondFilterList = true;
        this.shouldResetCurRangeFilterList = true;
    }

    public final GoodsCenterEventFilter resetFilterData() {
        this.shouldResetCurCondFilterList = true;
        this.shouldResetCurRangeFilterList = true;
        return new GoodsCenterEventFilter(null, null);
    }

    public final void refreshData(GoodsCenterEventFilter goodsCenterEventFilter) {
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq;
        IGoodsCenterPageData iGoodsCenterPageData = this.pageModel;
        if (iGoodsCenterPageData == null || (goodsCenterSelectProductsReq = iGoodsCenterPageData.pageDataFilterParams()) == null) {
            goodsCenterSelectProductsReq = new GoodsCenterSelectProductsReq(null, null, null, null, 0, null, null, null, 0L, 511, null);
        }
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq2 = goodsCenterSelectProductsReq;
        IGoodsCenterPageData iGoodsCenterPageData2 = this.pageModel;
        if (iGoodsCenterPageData2 != null) {
            iGoodsCenterPageData2.refreshData(GoodsCenterSelectProductsReq.copy$default(goodsCenterSelectProductsReq2, null, goodsCenterEventFilter.filterCondList, null, null, 0, goodsCenterEventFilter.rangeFilterCondList, d1.CTRL_INDEX));
        }
    }

    public /* synthetic */ GoodsCenterFilterPanelViewModel(IGoodsCenterPageData iGoodsCenterPageData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
