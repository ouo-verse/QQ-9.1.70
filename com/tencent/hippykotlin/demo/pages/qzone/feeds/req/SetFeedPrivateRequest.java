package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetFeedPrivateReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetFeedPrivateRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class SetFeedPrivateRequest extends QZoneBaseRequest<SetFeedPrivateReq, SetFeedPrivateRsp> {
    public final UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final SetFeedPrivateRsp decodeBusiRsp(byte[] bArr) {
        return (SetFeedPrivateRsp) i.b(new SetFeedPrivateRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final SetFeedPrivateReq getBusiReq() {
        return new SetFeedPrivateReq(null, this.unionId, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.SetFeedPrivate";
    }

    public SetFeedPrivateRequest(UnionID unionID) {
        super(null, 1, 0 == true ? 1 : 0);
        this.unionId = unionID;
    }
}
