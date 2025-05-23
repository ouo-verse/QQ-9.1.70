package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.logic;

import com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryPlansReq;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusQueryPlansRsp;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OrderListLogic extends ListRequestLogic<QPlusQueryPlansReq, QPlusQueryPlansRsp> {
    public OrderListLogic(QPlusQueryPlansReq qPlusQueryPlansReq) {
        super("trpc.ecom.qplus_deliver_access_svr.QplusAccessSvr/QueryPlans", qPlusQueryPlansReq, new QPlusQueryPlansRsp(null, null, 3, null));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic
    public final boolean parsePageIsEnd(e eVar) {
        Object obj = this.nextCookieMark;
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            return str.length() == 0;
        }
        return true;
    }
}
