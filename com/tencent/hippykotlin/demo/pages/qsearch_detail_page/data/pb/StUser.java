package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StUser implements ISSOReqModel, ISSORspModel<StUser> {

    /* renamed from: id, reason: collision with root package name */
    public final String f114290id;
    public final String nick;

    public StUser(String str, String str2) {
        this.f114290id = str;
        this.nick = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StUser decode(e eVar) {
        return new StUser(eVar.q("id", ""), eVar.q("nick", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114290id);
        eVar.v("nick", this.nick);
        return eVar;
    }
}
