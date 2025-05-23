package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stFollowReq;
import UserGrowth.stFollowRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ChangeFollowRequest extends g<stFollowRsp> {
    private static final String CMD_STRING = "Follow";

    public ChangeFollowRequest(String str, int i3) {
        super(CMD_STRING);
        this.req = new stFollowReq(str, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stFollowRsp> getRspClass() {
        return stFollowRsp.class;
    }
}
