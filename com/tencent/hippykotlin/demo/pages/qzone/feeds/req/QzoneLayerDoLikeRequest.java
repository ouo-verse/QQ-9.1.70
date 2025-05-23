package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneLayerDoLikeRequest extends QZoneBaseRequest<DoLikeReq, DoLikeRsp> {
    public final String likeKey;
    public final OverlayInfo overlayInfo;
    public final UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DoLikeRsp decodeBusiRsp(byte[] bArr) {
        return (DoLikeRsp) i.b(new DoLikeRsp(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DoLikeReq getBusiReq() {
        return new DoLikeReq(null, this.likeKey, this.unionId, 1, this.overlayInfo, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.DoLikeOverlay";
    }

    public QzoneLayerDoLikeRequest(String str, UnionID unionID, OverlayInfo overlayInfo) {
        super(null, 1, null);
        this.likeKey = str;
        this.unionId = unionID;
        this.overlayInfo = overlayInfo;
    }
}
