package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model;

import com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsReq;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsRsp;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSearchListLogic extends ListRequestLogic<QPlusSearchTalentsReq, QPlusSearchTalentsRsp> {
    public QPPromoteReceiverSearchListLogic(QPlusSearchTalentsReq qPlusSearchTalentsReq) {
        super("trpc.ecom.talent_search_svr.TalentSearchSvr/SearchTalents", qPlusSearchTalentsReq, new QPlusSearchTalentsRsp(null, null, 0, 7, null));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic
    public final String getCookieKey() {
        return "attach_info";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic
    public final boolean parsePageIsEnd(e eVar) {
        Object obj = this.nextCookieMark;
        String str = obj instanceof String ? (String) obj : null;
        if (!eVar.g("end", false) && str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }
}
