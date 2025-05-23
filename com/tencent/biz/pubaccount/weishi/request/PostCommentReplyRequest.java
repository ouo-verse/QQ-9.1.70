package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stPostCommentReplyV2Req;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class PostCommentReplyRequest extends g<stPostCommentReplyV2Rsp> {
    private static final String CMD_STRING = "PostCommentReplyV2";

    public PostCommentReplyRequest(stSimpleMetaFeed stsimplemetafeed, stSimpleMetaComment stsimplemetacomment, stSimpleMetaReply stsimplemetareply, ArrayList<String> arrayList) {
        super(CMD_STRING, 10003);
        this.req = new stPostCommentReplyV2Req(stsimplemetafeed.f25129id, stsimplemetacomment.f25128id, stsimplemetareply, arrayList == null ? new ArrayList<>() : arrayList);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stPostCommentReplyV2Rsp> getRspClass() {
        return stPostCommentReplyV2Rsp.class;
    }
}
