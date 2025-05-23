package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class UnifySearchChannelConditonFilter implements ISSOReqModel, ISSORspModel<UnifySearchChannelConditonFilter> {
    public final int contentType;
    public final int rankType;

    public UnifySearchChannelConditonFilter(int i3, int i16) {
        this.rankType = i3;
        this.contentType = i16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final UnifySearchChannelConditonFilter decode(e eVar) {
        return new UnifySearchChannelConditonFilter(eVar.k("rank_type", 0), eVar.k("content_type", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("rank_type", this.rankType);
        eVar.t("content_type", this.contentType);
        return eVar;
    }
}
