package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import java.util.Map;

/* loaded from: classes31.dex */
public final class ProductDetailReporter {
    public static final ProductDetailReporter INSTANCE = new ProductDetailReporter();

    public final void reportDetailPageDuration(IReportParamsBuilder iReportParamsBuilder) {
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            ECDetailPageReportParamsBuilder addContentId = eCDetailPageReportParamsBuilder.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addActivityType().addActivityId().addPageStateType().addProgramId().addRoomId().addSourceFrom().addContentId();
            Map<Object, Object> map = addContentId.paramsMap;
            Utils utils = Utils.INSTANCE;
            map.put("duration", Long.valueOf(utils.currentBridgeModule().currentTimeStamp() - addContentId.startTime));
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_duration", "[ProductDetailReporter] reportDetailPageDuration, event cod = qstore_prd_detail_pg_duration, data = "), utils);
        }
    }

    public final void reportDetailPageExpDepth(IReportParamsBuilder iReportParamsBuilder) {
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            ECDetailPageReportParamsBuilder addContentId = eCDetailPageReportParamsBuilder.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addActivityType().addActivityId().addPageStateType().addProgramId().addRoomId().addSourceFrom().addContentId();
            addContentId.paramsMap.put("depth", Integer.valueOf(addContentId.expDepth));
            Utils utils = Utils.INSTANCE;
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_browse_depth", "[ProductDetailReporter] reportDetailPageExpDepth, event cod = qstore_prd_detail_pg_browse_depth, data = "), utils);
        }
    }
}
