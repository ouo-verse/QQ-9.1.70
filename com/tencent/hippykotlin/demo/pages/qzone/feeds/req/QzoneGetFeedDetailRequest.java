package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedDetailReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedDetailRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneGetFeedDetailRequest extends QZoneBaseRequest<GetFeedDetailReq, GetFeedDetailRsp> {
    public String entryUrlSchema;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFeedDetailRsp decodeBusiRsp(byte[] bArr) {
        return (GetFeedDetailRsp) i.b(new GetFeedDetailRsp(null, null, null, false, 0, 31, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFeedDetailReq getBusiReq() {
        return new GetFeedDetailReq(null, this.unionId, null, null, null, this.entryUrlSchema, 29, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetFeedDetail";
    }

    public QzoneGetFeedDetailRequest(UnionID unionID, String str) {
        super(null, 1, null);
        this.unionId = unionID;
        this.entryUrlSchema = str;
    }
}
