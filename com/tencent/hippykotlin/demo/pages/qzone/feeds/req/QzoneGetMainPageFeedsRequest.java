package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QzoneGetMainPageFeedsRequest extends QZoneBaseRequest<GetMainPageFeedsReq, GetMainPageFeedsRsp> {
    public String attachInfo;
    public StCommonExt ext;
    public String hostUid;
    public String hostUin;

    public /* synthetic */ QzoneGetMainPageFeedsRequest(String str, String str2) {
        this(null, "", str, str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetMainPageFeedsRsp getMainPageFeedsRsp) {
        return !getMainPageFeedsRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageFeedsReq getBusiReq() {
        return new GetMainPageFeedsReq(this.ext, this.hostUid, this.hostUin, this.attachInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetMainPageFeeds";
    }

    public QzoneGetMainPageFeedsRequest(StCommonExt stCommonExt, String str, String str2, String str3) {
        super(null, 1, null);
        this.ext = stCommonExt;
        this.hostUid = str;
        this.hostUin = str2;
        this.attachInfo = str3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageFeedsRsp decodeBusiRsp(byte[] bArr) {
        return (GetMainPageFeedsRsp) i.b(new GetMainPageFeedsRsp(null, null, null, false, null, null, 0, 127, null), bArr);
    }
}
