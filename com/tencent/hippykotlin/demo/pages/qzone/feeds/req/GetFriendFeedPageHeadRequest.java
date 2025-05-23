package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class GetFriendFeedPageHeadRequest extends QZoneBaseRequest<GetFriendFeedPageHeadReq, GetFriendFeedPageHeadRsp> {
    public String traceId;

    public GetFriendFeedPageHeadRequest(StCommonExt stCommonExt, String str) {
        super(str);
        this.traceId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFriendFeedPageHeadRsp decodeBusiRsp(byte[] bArr) {
        return (GetFriendFeedPageHeadRsp) i.b(new GetFriendFeedPageHeadRsp(null, null, false, null, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFriendFeedPageHeadReq getBusiReq() {
        return new GetFriendFeedPageHeadReq(null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetFriendFeedPageHead";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final String getTraceId() {
        return this.traceId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final void setTraceId(String str) {
        this.traceId = str;
    }
}
