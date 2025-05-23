package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneRemoveSpecialCareRequest extends QZoneBaseRequest<RemoveSpecialReq, RemoveSpecialRsp> {
    public final List<StUser> users;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final RemoveSpecialRsp decodeBusiRsp(byte[] bArr) {
        return (RemoveSpecialRsp) i.b(new RemoveSpecialRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final RemoveSpecialReq getBusiReq() {
        return new RemoveSpecialReq(null, this.users);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.RemoveSpecial";
    }

    public QzoneRemoveSpecialCareRequest(StCommonExt stCommonExt, List<StUser> list) {
        super(null, 1, null);
        this.users = list;
    }
}
