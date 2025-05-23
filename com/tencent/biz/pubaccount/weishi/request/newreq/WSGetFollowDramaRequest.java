package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetFollowedDramasReq;
import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGetFollowDramaRequest extends g<stGetFollowedDramasRsp> {
    private static final String CMD_STRING = "GetFollowedDramas";

    public WSGetFollowDramaRequest(String str) {
        super(CMD_STRING);
        stGetFollowedDramasReq stgetfolloweddramasreq = new stGetFollowedDramasReq();
        stgetfolloweddramasreq.attachInfo = str == null ? "" : str;
        this.req = stgetfolloweddramasreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetFollowedDramasRsp> getRspClass() {
        return stGetFollowedDramasRsp.class;
    }
}
