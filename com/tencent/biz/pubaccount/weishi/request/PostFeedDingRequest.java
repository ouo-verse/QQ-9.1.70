package com.tencent.biz.pubaccount.weishi.request;

import NS_KING_INTERFACE.stPostFeedDingReq;
import NS_KING_INTERFACE.stPostFeedDingRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* loaded from: classes32.dex */
public class PostFeedDingRequest extends g<stPostFeedDingRsp> {
    private static final String CMD_STRING = "PostFeedDing";

    public PostFeedDingRequest(String str, int i3) {
        super(CMD_STRING);
        this.req = new stPostFeedDingReq(str, null, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stPostFeedDingRsp> getRspClass() {
        return stPostFeedDingRsp.class;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean isHeaderNeedExpABTestData() {
        return false;
    }
}
