package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusGetPromotionDetailRsp implements ISSOReqModel, ISSORspModel<QPlusGetPromotionDetailRsp> {
    public final QPlusPromotionDetail promotionDetail;

    public QPlusGetPromotionDetailRsp() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusGetPromotionDetailRsp decode(e eVar) {
        e m3 = eVar.m("promotion_detail");
        return new QPlusGetPromotionDetailRsp(m3 != null ? new QPlusPromotionDetail(null, null, null, null, null, null).decode(m3) : null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusPromotionDetail qPlusPromotionDetail = this.promotionDetail;
        if (qPlusPromotionDetail != null) {
            eVar.v("promotion_detail", qPlusPromotionDetail.encode());
        }
        return eVar;
    }

    public QPlusGetPromotionDetailRsp(QPlusPromotionDetail qPlusPromotionDetail) {
        this.promotionDetail = qPlusPromotionDetail;
    }

    public /* synthetic */ QPlusGetPromotionDetailRsp(QPlusPromotionDetail qPlusPromotionDetail, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
