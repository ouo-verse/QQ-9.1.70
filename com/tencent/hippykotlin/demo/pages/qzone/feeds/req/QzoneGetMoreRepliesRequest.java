package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetRepliesReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetRepliesRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneGetMoreRepliesRequest extends QZoneBaseRequest<GetRepliesReq, GetRepliesRsp> {
    public String commentAttachInfo;
    public StComment curComment;
    public int pageSize;
    public String replyAttachInfo;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetRepliesRsp getRepliesRsp) {
        return !getRepliesRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetRepliesRsp decodeBusiRsp(byte[] bArr) {
        return (GetRepliesRsp) i.b(new GetRepliesRsp(null, 0, null, false, null, 31, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetRepliesReq getBusiReq() {
        return new GetRepliesReq(null, this.unionId, this.commentAttachInfo, this.curComment, this.pageSize, this.replyAttachInfo, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetReplies";
    }

    public QzoneGetMoreRepliesRequest(UnionID unionID, String str, StComment stComment, String str2, int i3) {
        super(null, 1, null);
        this.unionId = unionID;
        this.commentAttachInfo = str;
        this.curComment = stComment;
        this.replyAttachInfo = str2;
        this.pageSize = i3;
    }
}
