package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsByTimeReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsByTimeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QzoneGetMainPageFeedsByTimeRequest extends QZoneBaseRequest<GetMainPageFeedsByTimeReq, GetMainPageFeedsByTimeRsp> {
    public String attachInfo;
    public int directType;
    public long feedTime;
    public String hostUin;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetMainPageFeedsByTimeRsp getMainPageFeedsByTimeRsp) {
        return !getMainPageFeedsByTimeRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageFeedsByTimeRsp decodeBusiRsp(byte[] bArr) {
        return (GetMainPageFeedsByTimeRsp) i.b(new GetMainPageFeedsByTimeRsp(null, null, null, false, 15, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageFeedsByTimeReq getBusiReq() {
        return new GetMainPageFeedsByTimeReq(null, "", this.hostUin, this.feedTime, this.directType, this.attachInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetMainPageFeedsByTime";
    }

    public QzoneGetMainPageFeedsByTimeRequest(StCommonExt stCommonExt, String str, String str2, long j3, int i3, String str3) {
        super(null, 1, null);
        this.hostUin = str2;
        this.feedTime = j3;
        this.directType = i3;
        this.attachInfo = str3;
    }
}
