package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetCommentReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneGetFeedDetailCommentRequest extends QZoneBaseRequest<GetCommentReq, GetCommentRsp> {
    public String attachInfo;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetCommentRsp getCommentRsp) {
        return !getCommentRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetCommentRsp decodeBusiRsp(byte[] bArr) {
        return (GetCommentRsp) i.b(new GetCommentRsp(null, null, false, null, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetCommentReq getBusiReq() {
        return new GetCommentReq(null, this.unionId, this.attachInfo, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetComment";
    }

    public QzoneGetFeedDetailCommentRequest(UnionID unionID, String str) {
        super(null, 1, null);
        this.unionId = unionID;
        this.attachInfo = str;
    }
}
