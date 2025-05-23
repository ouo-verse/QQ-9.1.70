package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ForwardFeedReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ForwardFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ForwardFeedRequest extends QZoneBaseRequest<ForwardFeedReq, ForwardFeedRsp> {
    public final Map<String, String> extendInfo;
    public final int from;
    public final String reason;
    public final UnionID unionId;
    public final boolean withCmt;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ForwardFeedRsp decodeBusiRsp(byte[] bArr) {
        return (ForwardFeedRsp) i.b(new ForwardFeedRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ForwardFeedReq getBusiReq() {
        return new ForwardFeedReq(null, this.unionId, this.extendInfo, this.reason, this.withCmt, this.from);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.ForwardFeed";
    }

    public ForwardFeedRequest(StCommonExt stCommonExt, UnionID unionID, Map<String, String> map, String str, boolean z16, int i3) {
        super(null, 1, null);
        this.unionId = unionID;
        this.extendInfo = map;
        this.reason = str;
        this.withCmt = z16;
        this.from = i3;
    }
}
