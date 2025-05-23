package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ValidateQAReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ValidateQARsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneValidateQARequest extends QZoneBaseRequest<ValidateQAReq, ValidateQARsp> {
    public String hostUin;

    /* renamed from: qa, reason: collision with root package name */
    public QzoneRightQuestion f114300qa;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ValidateQARsp decodeBusiRsp(byte[] bArr) {
        return (ValidateQARsp) i.b(new ValidateQARsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final ValidateQAReq getBusiReq() {
        return new ValidateQAReq(null, "", this.hostUin, this.f114300qa);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.feeds_writer.FeedsWriter.ValidateQA";
    }

    public QzoneValidateQARequest(StCommonExt stCommonExt, String str, String str2, QzoneRightQuestion qzoneRightQuestion) {
        super(null, 1, null);
        this.hostUin = str2;
        this.f114300qa = qzoneRightQuestion;
    }
}
