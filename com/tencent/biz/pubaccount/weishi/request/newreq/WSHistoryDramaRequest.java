package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetHistoryDramaReq;
import UserGrowth.stGetHistoryDramaRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSHistoryDramaRequest extends g<stGetHistoryDramaRsp> {
    private static final String CMD_STRING = "GetHistoryDrama";

    public WSHistoryDramaRequest(String str, String str2) {
        super(CMD_STRING);
        stGetHistoryDramaReq stgethistorydramareq = new stGetHistoryDramaReq();
        stgethistorydramareq.personID = str;
        stgethistorydramareq.attachInfo = str2;
        this.req = stgethistorydramareq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetHistoryDramaRsp> getRspClass() {
        return stGetHistoryDramaRsp.class;
    }
}
