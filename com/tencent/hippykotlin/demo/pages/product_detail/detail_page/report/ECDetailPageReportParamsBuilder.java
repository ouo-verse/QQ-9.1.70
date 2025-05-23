package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes31.dex */
public final class ECDetailPageReportParamsBuilder implements IReportParamsBuilder {
    public int activityState;
    public int activityType;
    public int expDepth;
    public long startTime;
    public int pgStateType = 2;
    public String contentId = "";
    public String sellerId = "";
    public String shopId = "";
    public String spuId = "";
    public int role = 1;
    public String priSortId = "";
    public String sourceFrom = "-100";
    public String roomId = "";
    public String activityId = "";
    public String programId = "";
    public String adClickId = "";
    public Map<Object, Object> paramsMap = new LinkedHashMap();

    public ECDetailPageReportParamsBuilder() {
        addUin();
    }

    public final ECDetailPageReportParamsBuilder addActivityId() {
        this.paramsMap.put("activity_id", this.activityId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addActivityType() {
        this.paramsMap.put("activity_type", Integer.valueOf(this.activityType));
        return this;
    }

    public final ECDetailPageReportParamsBuilder addBuiId() {
        this.paramsMap.put("bus_id", c.f117352a.k(BridgeManager.f117344a.u()).getPageData().n().p(WadlProxyConsts.CHANNEL));
        return this;
    }

    public final ECDetailPageReportParamsBuilder addContentId() {
        this.paramsMap.put("content_id", this.contentId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addPageStateType() {
        this.paramsMap.put(QAdVrReportParams.ParamKey.PG_TYPE, String.valueOf(this.pgStateType));
        return this;
    }

    public final ECDetailPageReportParamsBuilder addPriSortId() {
        this.paramsMap.put("pri_sort_id", this.priSortId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addProgramId() {
        this.paramsMap.put("program_id", this.programId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addRole() {
        this.paramsMap.put("role", Integer.valueOf(this.role));
        return this;
    }

    public final ECDetailPageReportParamsBuilder addRoomId() {
        this.paramsMap.put(AudienceReportConst.ROOM_ID, this.roomId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addSellerId() {
        this.paramsMap.put("seller_id", this.sellerId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addShopId() {
        this.paramsMap.put("shop_id", this.shopId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addSourceFrom() {
        this.paramsMap.put("source_from", this.sourceFrom);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addSpuId() {
        this.paramsMap.put("spu_id", this.spuId);
        return this;
    }

    public final ECDetailPageReportParamsBuilder addUin() {
        this.paramsMap.put("uin", Utils.INSTANCE.currentBridgeModule().getCurrentAccount());
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Object, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Object, java.lang.Object>] */
    public final e buildParamsJson() {
        e eVar = new e();
        for (Object obj : this.paramsMap.keySet()) {
            String obj2 = obj.toString();
            Object obj3 = this.paramsMap.get(obj);
            if (obj3 == null) {
                obj3 = "";
            }
            eVar.v(obj2, obj3);
        }
        return eVar;
    }
}
