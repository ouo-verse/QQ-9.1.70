package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneLayerDeleteCommentRequest extends QZoneBaseRequest<DeleteCommentReq, DeleteCommentRsp> {
    public StComment comment;
    public final OverlayInfo overlayInfo;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteCommentRsp decodeBusiRsp(byte[] bArr) {
        return (DeleteCommentRsp) i.b(new DeleteCommentRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteCommentReq getBusiReq() {
        return new DeleteCommentReq(null, this.unionId, this.comment, this.overlayInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.DeleteCommentOverlay";
    }

    public QzoneLayerDeleteCommentRequest(StCommonExt stCommonExt, UnionID unionID, StComment stComment, OverlayInfo overlayInfo) {
        super(null, 1, null);
        this.unionId = unionID;
        this.comment = stComment;
        this.overlayInfo = overlayInfo;
    }
}
