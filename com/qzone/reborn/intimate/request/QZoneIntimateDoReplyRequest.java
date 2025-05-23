package com.qzone.reborn.intimate.request;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj.a;
import qzone.QZIntimateSpaceWriter$StDoReplyReq;
import qzone.QZIntimateSpaceWriter$StDoReplyRsp;
import qzone.QZoneBaseMeta$StFeedCellCommon;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B/\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateDoReplyRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqzone/QZIntimateSpaceWriter$StDoReplyReq;", "mDoReplyReq", "Lqzone/QZIntimateSpaceWriter$StDoReplyReq;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "spaceId", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "", "actionType", "<init>", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;Ljava/lang/String;Lcom/qzone/proxy/feedcomponent/model/Comment;Lcom/qzone/proxy/feedcomponent/model/Reply;I)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateDoReplyRequest extends QZoneIntimateBaseRequest {
    public static final int ACTION_TYPE_ADD = 1;
    public static final int ACTION_TYPE_DELETE = 0;
    public static final int ACTION_TYPE_DELETE_FOR_MASTER_FEED = 2;
    public static final String TAG = "QZoneIntimateDoReplyRequest";
    private QZIntimateSpaceWriter$StDoReplyReq mDoReplyReq;

    public QZoneIntimateDoReplyRequest(BusinessFeedData feedData, String spaceId, Comment comment, Reply reply, int i3) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        QZIntimateSpaceWriter$StDoReplyReq qZIntimateSpaceWriter$StDoReplyReq = new QZIntimateSpaceWriter$StDoReplyReq();
        this.mDoReplyReq = qZIntimateSpaceWriter$StDoReplyReq;
        qZIntimateSpaceWriter$StDoReplyReq.reply_type.set(i3);
        this.mDoReplyReq.feed.setHasFlag(true);
        this.mDoReplyReq.feed.cell_common.setHasFlag(true);
        QZoneBaseMeta$StFeedCellCommon qZoneBaseMeta$StFeedCellCommon = this.mDoReplyReq.feed.cell_common;
        a aVar = a.f423008a;
        qZoneBaseMeta$StFeedCellCommon.set(aVar.k(feedData.getFeedCommInfo()));
        this.mDoReplyReq.feed.cell_space_info.setHasFlag(true);
        this.mDoReplyReq.feed.cell_space_info.space_id.set(spaceId);
        this.mDoReplyReq.feed.cell_user_info.setHasFlag(true);
        this.mDoReplyReq.feed.cell_user_info.user.set(aVar.n(feedData.getUser()));
        this.mDoReplyReq.comment.set(aVar.j(comment));
        this.mDoReplyReq.reply.set(aVar.m(reply));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceWriter$StDoReplyRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceWriter$StDoReplyRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String getCmd() {
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.DoReply";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mDoReplyReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mDoReplyReq.toByteArray()");
        return byteArray;
    }
}
