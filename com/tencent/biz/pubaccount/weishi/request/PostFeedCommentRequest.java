package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stPostFeedCommentV2Req;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class PostFeedCommentRequest extends g<stPostFeedCommentV2Rsp> {
    private static final String CMD_STRING = "PostFeedCommentV2";

    public PostFeedCommentRequest(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, ArrayList<String> arrayList) {
        super(CMD_STRING, 10003);
        this.req = new stPostFeedCommentV2Req(stsimplemetafeed.f25129id, stsimplemetacomment, new ArrayList(), 0, arrayList == null ? new ArrayList<>() : arrayList);
        x.l("WsCommentBusiness", "stPostFeedCommentV2Req:" + this.req.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stPostFeedCommentV2Rsp> getRspClass() {
        return stPostFeedCommentV2Rsp.class;
    }
}
