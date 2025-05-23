package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetMsgRedDotReq;
import UserGrowth.stGetMsgRedDotRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGetMsgRedDotRequest extends g<stGetMsgRedDotRsp> {
    private static final String CMD_STRING = "GetMsgRedDot";

    public WSGetMsgRedDotRequest() {
        super(CMD_STRING);
        this.req = new stGetMsgRedDotReq();
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetMsgRedDotRsp> getRspClass() {
        return stGetMsgRedDotRsp.class;
    }
}
