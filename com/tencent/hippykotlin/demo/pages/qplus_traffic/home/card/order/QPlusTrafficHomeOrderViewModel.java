package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.logic.OrderListLogic;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPlanItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryPlansReq;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryPlansRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeOrderViewModel implements IQPlusTrafficCardHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeOrderViewModel.class, "uiState", "getUiState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPlusTrafficHomeOrderViewModel.class, "orderItem", "getOrderItem()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty uiState$delegate = c.a(QPlusTrafficUIState.LOADING);
    public final ReadWriteProperty orderItem$delegate = c.b();

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel
    public final QPlusTrafficHomeCardView getCardView() {
        return new QPlusTrafficHomeOrderView();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPlusPlanItem> getOrderItem() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.orderItem$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final QPlusTrafficUIState getUiState() {
        return (QPlusTrafficUIState) this.uiState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void refresh() {
        QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
        QPlusQueryPlansReq qPlusQueryPlansReq = new QPlusQueryPlansReq(null, "");
        final Function1<ArrayList<QPlusPlanItem>, Unit> function1 = new Function1<ArrayList<QPlusPlanItem>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderViewModel$handleReqSuccess$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ArrayList<QPlusPlanItem> arrayList) {
                ArrayList<QPlusPlanItem> arrayList2 = arrayList;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("order list success, [count:");
                m3.append(arrayList2 != null ? arrayList2.size() : 0);
                m3.append(']');
                kLog.i("QPlus_Home", m3.toString());
                QPlusTrafficHomeOrderViewModel.this.getOrderItem().clear();
                if (arrayList2 != null) {
                    QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel = QPlusTrafficHomeOrderViewModel.this;
                    int i3 = 0;
                    for (Object obj : arrayList2) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        QPlusPlanItem qPlusPlanItem = (QPlusPlanItem) obj;
                        if (i3 < 5) {
                            qPlusTrafficHomeOrderViewModel.getOrderItem().add(qPlusPlanItem);
                        }
                        i3 = i16;
                    }
                }
                QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel2 = QPlusTrafficHomeOrderViewModel.this;
                qPlusTrafficHomeOrderViewModel2.uiState$delegate.setValue(qPlusTrafficHomeOrderViewModel2, QPlusTrafficHomeOrderViewModel.$$delegatedProperties[0], QPlusTrafficUIState.COMPLETED);
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderViewModel$handleReqFailure$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel = QPlusTrafficHomeOrderViewModel.this;
                qPlusTrafficHomeOrderViewModel.uiState$delegate.setValue(qPlusTrafficHomeOrderViewModel, QPlusTrafficHomeOrderViewModel.$$delegatedProperties[0], QPlusTrafficUIState.FAILURE);
                return Unit.INSTANCE;
            }
        };
        new OrderListLogic(qPlusQueryPlansReq).reqFirstPage(new Function1<QPlusQueryPlansRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOrderList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusQueryPlansRsp qPlusQueryPlansRsp) {
                function1.invoke(qPlusQueryPlansRsp.planItems);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOrderList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                function2.invoke(Integer.valueOf(intValue), str);
                return Unit.INSTANCE;
            }
        });
    }
}
