package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ApplyVisitReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ApplyVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneApplyVisitRequest extends QZoneBaseRequest<ApplyVisitReq, ApplyVisitRsp> {
    public String hostUin;

    /* renamed from: msg, reason: collision with root package name */
    public String f114299msg;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ApplyVisitRsp decodeBusiRsp(byte[] bArr) {
        return (ApplyVisitRsp) i.b(new ApplyVisitRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ApplyVisitReq getBusiReq() {
        return new ApplyVisitReq(null, "", this.hostUin, this.f114299msg);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.ApplyVisit";
    }

    public QzoneApplyVisitRequest(StCommonExt stCommonExt, String str, String str2, String str3) {
        super(null, 1, null);
        this.hostUin = str2;
        this.f114299msg = str3;
    }
}
