package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.weiyun.poi.PoiDbManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchGeoInfo implements ISSOReqModel, ISSORspModel<UnifySearchGeoInfo> {
    public final int cityId;

    public UnifySearchGeoInfo(int i3) {
        this.cityId = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchGeoInfo decode(e eVar) {
        return new UnifySearchGeoInfo(eVar.k(PoiDbManager.COL_POI_CITY_ID, 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t(PoiDbManager.COL_POI_CITY_ID, this.cityId);
        return eVar;
    }
}
