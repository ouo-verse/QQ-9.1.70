package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStUser implements ISSOReqModel, ISSORspModel<QPlusCirStUser> {
    public final QPlusCirStIconInfo icon;
    public final String nick;
    public final String uin;

    public QPlusCirStUser(String str, String str2, QPlusCirStIconInfo qPlusCirStIconInfo) {
        this.uin = str;
        this.nick = str2;
        this.icon = qPlusCirStIconInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("uin", this.uin);
        eVar.v("nick", this.nick);
        QPlusCirStIconInfo qPlusCirStIconInfo = this.icon;
        if (qPlusCirStIconInfo != null) {
            eVar.v("icon", qPlusCirStIconInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStUser decode(e eVar) {
        String q16 = eVar.q("uin", "");
        String q17 = eVar.q("nick", "");
        e m3 = eVar.m("icon");
        return new QPlusCirStUser(q16, q17, m3 != null ? new QPlusCirStIconInfo(m3.q("iconUrl", "")) : null);
    }
}
