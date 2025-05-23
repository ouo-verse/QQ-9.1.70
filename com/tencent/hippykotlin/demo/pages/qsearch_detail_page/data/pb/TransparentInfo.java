package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TransparentInfo implements ISSOReqModel, ISSORspModel<TransparentInfo> {
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final TransparentInfo decode(e eVar) {
        return new TransparentInfo();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        return new e();
    }
}
