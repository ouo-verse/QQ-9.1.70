package com.tencent.biz.pubaccount.weishi.request;

import NS_KING_INTERFACE.stPostCommentDingReq;
import NS_KING_INTERFACE.stPostCommentDingRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* loaded from: classes32.dex */
public class PostCommentDingRequest extends g<stPostCommentDingRsp> {
    private static final String CMD_STRING = "PostCommentDing";

    public PostCommentDingRequest(String str, String str2, int i3) {
        super(CMD_STRING, 10003);
        this.req = new stPostCommentDingReq(str, str2, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stPostCommentDingRsp> getRspClass() {
        return stPostCommentDingRsp.class;
    }
}
