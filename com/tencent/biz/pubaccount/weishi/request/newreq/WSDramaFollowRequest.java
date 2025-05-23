package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stUpdateFollowDramaReq;
import UserGrowth.stUpdateFollowDramaRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaFollowRequest extends g<stUpdateFollowDramaRsp> {
    private static final String CMD_STRING = "UpdateFollowDrama";

    public WSDramaFollowRequest(String str, int i3) {
        super(CMD_STRING);
        this.req = new stUpdateFollowDramaReq(str, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stUpdateFollowDramaRsp> getRspClass() {
        return stUpdateFollowDramaRsp.class;
    }
}
