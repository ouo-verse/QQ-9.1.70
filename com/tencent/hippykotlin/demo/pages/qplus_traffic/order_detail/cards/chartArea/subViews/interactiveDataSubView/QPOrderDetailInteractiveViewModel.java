package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusContentDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusInteractData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusInteractDist;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusTimeDist;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailInteractiveViewModel implements IQPOrderDetailCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailInteractiveViewModel.class, "currentInteractiveTag", "getCurrentInteractiveTag()I", 0)};
    public final ReadWriteProperty currentInteractiveTag$delegate;
    public final QPlusGetPromotionDetailRsp info;
    public final Lazy interactDist$delegate;
    public final QPlusInteractDist tableInfo;

    public QPOrderDetailInteractiveViewModel(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
        Lazy lazy;
        QPlusInteractData qPlusInteractData;
        this.info = qPlusGetPromotionDetailRsp;
        QPlusPromotionDetail qPlusPromotionDetail = qPlusGetPromotionDetailRsp.promotionDetail;
        this.tableInfo = (qPlusPromotionDetail == null || (qPlusInteractData = qPlusPromotionDetail.interactData) == null) ? null : qPlusInteractData.interactDist;
        this.currentInteractiveTag$delegate = c.a(1);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Pair<? extends Float, ? extends String>[][]>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.chartArea.subViews.interactiveDataSubView.QPOrderDetailInteractiveViewModel$interactDist$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Pair<? extends Float, ? extends String>[][] invoke() {
                Pair<? extends Float, ? extends String>[][] pairArr = new Pair[4];
                QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel = QPOrderDetailInteractiveViewModel.this;
                QPlusInteractDist qPlusInteractDist = qPOrderDetailInteractiveViewModel.tableInfo;
                pairArr[0] = QPOrderDetailInteractiveViewModel.access$genDistArray(qPOrderDetailInteractiveViewModel, qPlusInteractDist != null ? qPlusInteractDist.viewDist : null);
                QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel2 = QPOrderDetailInteractiveViewModel.this;
                QPlusInteractDist qPlusInteractDist2 = qPOrderDetailInteractiveViewModel2.tableInfo;
                pairArr[1] = QPOrderDetailInteractiveViewModel.access$genDistArray(qPOrderDetailInteractiveViewModel2, qPlusInteractDist2 != null ? qPlusInteractDist2.favorDist : null);
                QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel3 = QPOrderDetailInteractiveViewModel.this;
                QPlusInteractDist qPlusInteractDist3 = qPOrderDetailInteractiveViewModel3.tableInfo;
                pairArr[2] = QPOrderDetailInteractiveViewModel.access$genDistArray(qPOrderDetailInteractiveViewModel3, qPlusInteractDist3 != null ? qPlusInteractDist3.followDist : null);
                QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel4 = QPOrderDetailInteractiveViewModel.this;
                QPlusInteractDist qPlusInteractDist4 = qPOrderDetailInteractiveViewModel4.tableInfo;
                pairArr[3] = QPOrderDetailInteractiveViewModel.access$genDistArray(qPOrderDetailInteractiveViewModel4, qPlusInteractDist4 != null ? qPlusInteractDist4.shareDist : null);
                return pairArr;
            }
        });
        this.interactDist$delegate = lazy;
    }

    public static final Pair[] access$genDistArray(QPOrderDetailInteractiveViewModel qPOrderDetailInteractiveViewModel, ArrayList arrayList) {
        int collectionSizeOrDefault;
        qPOrderDetailInteractiveViewModel.getClass();
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList3.add(Boolean.valueOf(arrayList2.add(new Pair(Float.valueOf(r1.percent), ((QPlusTimeDist) it.next()).timeAt))));
            }
        }
        Object[] array = arrayList2.toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Pair[]) array;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel
    public final IQPOrderDetailCardView getCardView() {
        return new QPOrderDetailInteractiveView();
    }

    public final int getCurrentInteractiveTag() {
        return ((Number) this.currentInteractiveTag$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final Pair<Float, String>[][] getInteractDist() {
        return (Pair[][]) this.interactDist$delegate.getValue();
    }

    public final void setCurrentInteractiveTag(int i3) {
        this.currentInteractiveTag$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public final boolean shouldShowInteractive() {
        QPlusContentDetail qPlusContentDetail;
        QPlusPromotionDetail qPlusPromotionDetail = this.info.promotionDetail;
        return !((qPlusPromotionDetail == null || (qPlusContentDetail = qPlusPromotionDetail.contentDetail) == null || qPlusContentDetail.contentType != 2) ? false : true);
    }
}
