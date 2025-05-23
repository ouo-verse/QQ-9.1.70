package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class DeleteFeedRequest extends QZoneBaseRequest<DeleteFeedReq, DeleteFeedRsp> {
    public List<Integer> delOpts;
    public final UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteFeedRsp decodeBusiRsp(byte[] bArr) {
        return (DeleteFeedRsp) i.b(new DeleteFeedRsp(null, 1, 0 == true ? 1 : 0), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteFeedReq getBusiReq() {
        return new DeleteFeedReq(null, this.unionId, null, this.delOpts, 5, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.DeleteFeed";
    }

    public DeleteFeedRequest(UnionID unionID, List<Integer> list) {
        super(null, 1, 0 == true ? 1 : 0);
        this.unionId = unionID;
        this.delOpts = list;
    }
}
