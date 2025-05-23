package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class DoLikeRequest extends QZoneBaseRequest<DoLikeReq, DoLikeRsp> {
    public final String likeKey;
    public final int likeType;
    public final UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DoLikeRsp decodeBusiRsp(byte[] bArr) {
        return (DoLikeRsp) i.b(new DoLikeRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DoLikeReq getBusiReq() {
        return new DoLikeReq(null, this.likeKey, this.unionId, this.likeType, null, 17, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.DoLike";
    }

    public DoLikeRequest(String str, UnionID unionID, int i3) {
        super(null, 1, null);
        this.likeKey = str;
        this.unionId = unionID;
        this.likeType = i3;
    }
}
