package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetFirstPageMsgListReq;
import UserGrowth.stGetFirstPageMsgListRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* loaded from: classes32.dex */
public class WSMsgPageRequest extends g<stGetFirstPageMsgListRsp> {
    private static final String CMD_STRING = "GetFirstPageMsgList";

    public WSMsgPageRequest(String str) {
        super(CMD_STRING);
        this.req = new stGetFirstPageMsgListReq(str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetFirstPageMsgListRsp> getRspClass() {
        return stGetFirstPageMsgListRsp.class;
    }
}
