package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetPromotionDetailRsp;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPOrderDetailPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPOrderDetailPageModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0)};
    public QPlusGetPromotionDetailRsp orderDetailInfo;
    public final ReadWriteProperty pageState$delegate = c.a(QPlusTrafficUIState.LOADING);

    public QPOrderDetailPageModel(e eVar) {
        QPlusTrafficRepository.INSTANCE.reqOrderDetail(SchemeParamExtensionKt.schemePlanId(eVar), handleSuccessBlock(), handleErrorBlock());
    }

    public final Function2<Integer, String, Unit> handleErrorBlock() {
        return new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.page_model.QPOrderDetailPageModel$handleErrorBlock$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                QPOrderDetailPageModel qPOrderDetailPageModel = QPOrderDetailPageModel.this;
                qPOrderDetailPageModel.pageState$delegate.setValue(qPOrderDetailPageModel, QPOrderDetailPageModel.$$delegatedProperties[0], QPlusTrafficUIState.FAILURE);
                return Unit.INSTANCE;
            }
        };
    }

    public final Function1<QPlusGetPromotionDetailRsp, Unit> handleSuccessBlock() {
        return new Function1<QPlusGetPromotionDetailRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.page_model.QPOrderDetailPageModel$handleSuccessBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetPromotionDetailRsp qPlusGetPromotionDetailRsp) {
                QPOrderDetailPageModel qPOrderDetailPageModel = QPOrderDetailPageModel.this;
                qPOrderDetailPageModel.orderDetailInfo = qPlusGetPromotionDetailRsp;
                qPOrderDetailPageModel.pageState$delegate.setValue(qPOrderDetailPageModel, QPOrderDetailPageModel.$$delegatedProperties[0], QPlusTrafficUIState.COMPLETED);
                return Unit.INSTANCE;
            }
        };
    }
}
