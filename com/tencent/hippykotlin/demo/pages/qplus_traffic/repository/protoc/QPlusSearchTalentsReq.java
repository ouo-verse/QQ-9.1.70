package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusSearchTalentsReq implements ISSOReqModel, ISSORspModel<QPlusSearchTalentsReq> {
    public final String attachInfo;
    public final String word;

    public QPlusSearchTalentsReq(String str, String str2) {
        this.word = str;
        this.attachInfo = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusSearchTalentsReq decode(e eVar) {
        return new QPlusSearchTalentsReq(eVar.q("word", ""), eVar.q("attach_info", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("word", this.word);
        eVar.v("attach_info", this.attachInfo);
        return eVar;
    }
}
