package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteVisitReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneDeleteVisitRequest extends QZoneBaseRequest<DeleteVisitReq, DeleteVisitRsp> {
    public String hostUin;
    public int mod;
    public long vtime;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteVisitRsp decodeBusiRsp(byte[] bArr) {
        return (DeleteVisitRsp) i.b(new DeleteVisitRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteVisitReq getBusiReq() {
        return new DeleteVisitReq(null, "", this.hostUin, this.vtime, this.mod);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.DeleteVisit";
    }

    public QzoneDeleteVisitRequest(StCommonExt stCommonExt, String str, String str2, long j3, int i3) {
        super(null, 1, null);
        this.hostUin = str2;
        this.vtime = j3;
        this.mod = i3;
    }
}
