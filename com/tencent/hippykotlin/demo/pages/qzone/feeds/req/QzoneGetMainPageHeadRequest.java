package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* loaded from: classes33.dex */
public final class QzoneGetMainPageHeadRequest extends QZoneBaseRequest<GetMainPageHeadReq, GetMainPageHeadRsp> {
    public String hostUin;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageHeadRsp decodeBusiRsp(byte[] bArr) {
        return (GetMainPageHeadRsp) i.b(new GetMainPageHeadRsp(null, null, null, null, null, null, false, null, null, 511, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetMainPageHeadReq getBusiReq() {
        return new GetMainPageHeadReq(null, "", this.hostUin);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetMainPageHead";
    }

    public QzoneGetMainPageHeadRequest(StCommonExt stCommonExt, String str, String str2) {
        super(null, 1, null);
        this.hostUin = str2;
    }
}
