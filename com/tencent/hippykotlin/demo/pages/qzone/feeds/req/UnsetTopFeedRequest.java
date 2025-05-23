package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.UnsetTopFeedReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.UnsetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UnsetTopFeedRequest extends QZoneBaseRequest<UnsetTopFeedReq, UnsetTopFeedRsp> {
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final UnsetTopFeedRsp decodeBusiRsp(byte[] bArr) {
        return (UnsetTopFeedRsp) i.b(new UnsetTopFeedRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final UnsetTopFeedReq getBusiReq() {
        return new UnsetTopFeedReq(null, this.unionId);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.UnsetTopFeed";
    }

    public UnsetTopFeedRequest(StCommonExt stCommonExt, UnionID unionID) {
        super(null, 1, 0 == true ? 1 : 0);
        this.unionId = unionID;
    }
}
