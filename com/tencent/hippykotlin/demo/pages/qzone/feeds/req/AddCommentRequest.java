package com.tencent.hippykotlin.demo.pages.qzone.feeds.req;

import c45.i;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentReq;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCommonExt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class AddCommentRequest extends QZoneBaseRequest<AddCommentReq, AddCommentRsp> {
    public StComment comment;
    public boolean isPrivate;
    public UnionID unionId;

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final AddCommentRsp decodeBusiRsp(byte[] bArr) {
        return (AddCommentRsp) i.b(new AddCommentRsp(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest
    public final AddCommentReq getBusiReq() {
        return new AddCommentReq(null, this.unionId, this.comment, this.isPrivate, null, 16, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "QzoneV4Service.trpc.qzone.interaction_writer.InteractionWriter.AddComment";
    }

    public AddCommentRequest(StCommonExt stCommonExt, UnionID unionID, StComment stComment, boolean z16) {
        super(null, 1, null);
        this.unionId = unionID;
        this.comment = stComment;
        this.isPrivate = z16;
    }
}
