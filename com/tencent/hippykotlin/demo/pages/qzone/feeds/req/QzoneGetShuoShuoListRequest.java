package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneGetShuoShuoListRequest extends QZoneBaseRequest<GetShuoshuoListReq, GetShuoshuoListRsp> {
    public String attachInfo;
    public StCommonExt ext;
    public String hostUid;
    public String hostUin;

    public /* synthetic */ QzoneGetShuoShuoListRequest(String str, String str2) {
        this(null, "", str, str2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final boolean checkFinish(GetShuoshuoListRsp getShuoshuoListRsp) {
        return !getShuoshuoListRsp.hasMore;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetShuoshuoListReq getBusiReq() {
        return new GetShuoshuoListReq(this.ext, this.hostUid, this.hostUin, this.attachInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_reader.FeedsReader.GetShuoshuoList";
    }

    public QzoneGetShuoShuoListRequest(StCommonExt stCommonExt, String str, String str2, String str3) {
        super(null, 1, 0 == true ? 1 : 0);
        this.ext = stCommonExt;
        this.hostUid = str;
        this.hostUin = str2;
        this.attachInfo = str3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final GetShuoshuoListRsp decodeBusiRsp(byte[] bArr) {
        return (GetShuoshuoListRsp) i.b(new GetShuoshuoListRsp(null, null, null, false, 0, null, 63, null), bArr);
    }
}
