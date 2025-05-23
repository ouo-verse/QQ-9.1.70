package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.weiyun.poi.PoiDbManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchDistrict implements ISSOReqModel, ISSORspModel<UnifySearchDistrict> {
    public final int cityId;
    public final String name;

    public UnifySearchDistrict() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchDistrict decode(e eVar) {
        return new UnifySearchDistrict(eVar.q("name", ""), eVar.k(PoiDbManager.COL_POI_CITY_ID, 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("name", this.name);
        eVar.t(PoiDbManager.COL_POI_CITY_ID, this.cityId);
        return eVar;
    }

    public UnifySearchDistrict(String str, int i3) {
        this.name = str;
        this.cityId = i3;
    }

    public /* synthetic */ UnifySearchDistrict(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }
}
