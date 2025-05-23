package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetUpdateFeedReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetUpdateFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneGetUpdateFeedRequest extends QZoneBaseRequest<GetUpdateFeedReq, GetUpdateFeedRsp> {
    public String attachInfo;
    public String clientKey;
    public UnionID unionId;

    public /* synthetic */ QzoneGetUpdateFeedRequest(UnionID unionID, String str, String str2, int i3) {
        this((i3 & 1) != 0 ? null : unionID, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetUpdateFeedRsp decodeBusiRsp(byte[] bArr) {
        return (GetUpdateFeedRsp) i.b(new GetUpdateFeedRsp(null, null, 0, null, false, 31, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetUpdateFeedReq getBusiReq() {
        return new GetUpdateFeedReq(null, this.unionId, this.clientKey, this.attachInfo, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetUpdateFeed";
    }

    public QzoneGetUpdateFeedRequest(UnionID unionID, String str, String str2) {
        super(null, 1, 0 == true ? 1 : 0);
        this.unionId = unionID;
        this.clientKey = str;
        this.attachInfo = str2;
    }
}
