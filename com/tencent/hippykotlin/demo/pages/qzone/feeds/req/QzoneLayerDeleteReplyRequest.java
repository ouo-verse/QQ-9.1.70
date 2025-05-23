package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.OverlayInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QzoneLayerDeleteReplyRequest extends QZoneBaseRequest<DeleteReplyReq, DeleteReplyRsp> {
    public StComment comment;
    public final OverlayInfo overlayInfo;
    public StReply reply;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteReplyRsp decodeBusiRsp(byte[] bArr) {
        return (DeleteReplyRsp) i.b(new DeleteReplyRsp(null, 1, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final DeleteReplyReq getBusiReq() {
        return new DeleteReplyReq(null, this.unionId, this.comment, this.reply, this.overlayInfo);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.DeleteReplyOverlay";
    }

    public QzoneLayerDeleteReplyRequest(StCommonExt stCommonExt, UnionID unionID, StComment stComment, StReply stReply, OverlayInfo overlayInfo) {
        super(null, 1, null);
        this.unionId = unionID;
        this.comment = stComment;
        this.reply = stReply;
        this.overlayInfo = overlayInfo;
    }
}
