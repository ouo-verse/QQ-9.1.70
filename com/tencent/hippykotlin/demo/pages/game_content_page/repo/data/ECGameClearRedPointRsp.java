package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class ECGameClearRedPointRsp implements ISSOReqModel, ISSORspModel<ECGameClearRedPointRsp> {
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ECGameClearRedPointRsp decode(e eVar) {
        return new ECGameClearRedPointRsp();
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        return new e();
    }
}
