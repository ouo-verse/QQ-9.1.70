package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedsReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GetFriendFeedsRequest extends QZoneBaseRequest<GetFeedsReq, GetFeedsRsp> {
    public a advReqExtend;
    public String attachInfo;
    public StCommonExt ext;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetFeedsRsp getFeedsRsp) {
        return !getFeedsRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFeedsReq getBusiReq() {
        return new GetFeedsReq(this.ext, this.attachInfo, this.advReqExtend);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetFriendFeeds";
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetFeedsRsp decodeBusiRsp(byte[] bArr) {
        return (GetFeedsRsp) i.b(new GetFeedsRsp(null, null, null, false, 0, 31, null), bArr);
    }

    public GetFriendFeedsRequest(StCommonExt stCommonExt, String str, a aVar) {
        super(null, 1, null);
        this.ext = stCommonExt;
        this.attachInfo = str;
        this.advReqExtend = aVar;
    }
}
