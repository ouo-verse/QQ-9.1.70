package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPlusPromotionDetail implements ISSOReqModel, ISSORspModel<QPlusPromotionDetail> {
    public final QPlusCommodityData commodityData;
    public final QPlusContentDetail contentDetail;
    public final QPlusInteractData interactData;
    public final QPlusPayDetail payDetail;
    public final QPlusPlanDetail planDetail;
    public final QPlusProgress progress;

    public QPlusPromotionDetail(QPlusContentDetail qPlusContentDetail, QPlusPayDetail qPlusPayDetail, QPlusPlanDetail qPlusPlanDetail, QPlusProgress qPlusProgress, QPlusInteractData qPlusInteractData, QPlusCommodityData qPlusCommodityData) {
        this.contentDetail = qPlusContentDetail;
        this.payDetail = qPlusPayDetail;
        this.planDetail = qPlusPlanDetail;
        this.progress = qPlusProgress;
        this.interactData = qPlusInteractData;
        this.commodityData = qPlusCommodityData;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusContentDetail qPlusContentDetail = this.contentDetail;
        if (qPlusContentDetail != null) {
            eVar.v("content_detail", qPlusContentDetail.encode());
        }
        QPlusPayDetail qPlusPayDetail = this.payDetail;
        if (qPlusPayDetail != null) {
            eVar.v("pay_detail", qPlusPayDetail.encode());
        }
        QPlusPlanDetail qPlusPlanDetail = this.planDetail;
        if (qPlusPlanDetail != null) {
            eVar.v("plan_detail", qPlusPlanDetail.encode());
        }
        QPlusProgress qPlusProgress = this.progress;
        if (qPlusProgress != null) {
            eVar.v("progress", qPlusProgress.encode());
        }
        QPlusInteractData qPlusInteractData = this.interactData;
        if (qPlusInteractData != null) {
            eVar.v("interact_data", qPlusInteractData.encode());
        }
        QPlusCommodityData qPlusCommodityData = this.commodityData;
        if (qPlusCommodityData != null) {
            eVar.v("commodity_data", qPlusCommodityData.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPromotionDetail decode(e eVar) {
        QPlusInteractData qPlusInteractData;
        ArrayList arrayList;
        e m3 = eVar.m("content_detail");
        QPlusContentDetail qPlusContentDetail = m3 != null ? new QPlusContentDetail(m3.k("content_type", 0), m3.q("content_id", ""), m3.q("title", ""), m3.q("icon", ""), m3.q("creator_id", ""), m3.q("creator_nick", ""), m3.q("date", "")) : null;
        e m16 = eVar.m("pay_detail");
        QPlusPayDetail qPlusPayDetail = m16 != null ? new QPlusPayDetail(m16.k("payed_amount", 0), m16.k("cost_amount", 0), m16.k("refund_amount", 0)) : null;
        e m17 = eVar.m("plan_detail");
        QPlusPlanDetail qPlusPlanDetail = m17 != null ? new QPlusPlanDetail(m17.q("plan_id", ""), m17.q("start_time", ""), m17.q("end_time", ""), m17.q("expect_covers", ""), m17.q("improve_text", ""), m17.q("audience_text", ""), m17.q("time_text", ""), m17.q("status_text", "")) : null;
        e m18 = eVar.m("progress");
        QPlusProgress qPlusProgress = m18 != null ? new QPlusProgress(m18.k("expect_covers", 0), m18.k("actual_covers", 0), m18.k("percent", 0)) : null;
        e m19 = eVar.m("interact_data");
        if (m19 != null) {
            b l3 = m19.l("indexs");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        arrayList.add(new QPlusIndex(eVar2.q("index_name", ""), eVar2.k("cnt", 0)));
                    }
                }
            } else {
                arrayList = null;
            }
            e m26 = m19.m("audience_dist");
            QPlusAudienceDist decode = m26 != null ? new QPlusAudienceDist(null, null, null).decode(m26) : null;
            e m27 = m19.m("interact_dist");
            qPlusInteractData = new QPlusInteractData(arrayList, decode, m27 != null ? new QPlusInteractDist(null, null, null, null, null).decode(m27) : null);
        } else {
            qPlusInteractData = null;
        }
        e m28 = eVar.m("commodity_data");
        return new QPlusPromotionDetail(qPlusContentDetail, qPlusPayDetail, qPlusPlanDetail, qPlusProgress, qPlusInteractData, m28 != null ? new QPlusCommodityData(m28.k("click_num", 0), m28.k("sales_num", 0), m28.k("sales_amount", 0)) : null);
    }
}
