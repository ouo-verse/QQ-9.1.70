package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCommentKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReplyKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ForwardFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.AddReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteCommentRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DeleteReplyRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.DoLikeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.UnLikeRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.AddCommentRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.AddReplyRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.DeleteCommentRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.DeleteReplyRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.DoLikeRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.ForwardFeedRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.UnlikeRequest;
import com.tencent.kuikly.core.log.KLog;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ.\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\fJ&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ.\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\fJ4\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fJJ\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020#0\fJ\b\u0010$\u001a\u00020\u0018H\u0016J4\u0010%\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020&0\f\u00a8\u0006("}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedWriteService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "addComment", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "isPrivate", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddCommentRsp;", "addReply", "reply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/AddReplyRsp;", "deleteComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteCommentRsp;", "deleteReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DeleteReplyRsp;", "doLike", "likeKey", "", "likeType", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/LikeType;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/DoLikeRsp;", "forwardFeed", "extendInfo", "", "reason", "withCmt", "from", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ForwardFeedRsp;", "getLogTag", "unlike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/UnLikeRsp;", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedWriteService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneFeedWriteService";

    public final void addComment(CommonUnionID unionId, CommonComment comment, boolean isPrivate, DataCallback<AddCommentRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "addComment");
        if (unionId == null) {
            return;
        }
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new AddCommentRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), isPrivate), dataCallback, null, 4, null);
    }

    public final void addReply(CommonUnionID unionId, CommonComment comment, CommonReply reply, DataCallback<AddReplyRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "addReply");
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new AddReplyRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), CommonReplyKt.toPb(reply)), dataCallback, null, 4, null);
    }

    public final void deleteComment(CommonUnionID unionId, CommonComment comment, DataCallback<DeleteCommentRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteComment");
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new DeleteCommentRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment)), dataCallback, null, 4, null);
    }

    public final void deleteReply(CommonUnionID unionId, CommonComment comment, CommonReply reply, DataCallback<DeleteReplyRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteReply");
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new DeleteReplyRequest(null, CommonUnionIDKt.toPb(unionId), CommonCommentKt.toPb(comment), CommonReplyKt.toPb(reply)), dataCallback, null, 4, null);
    }

    public final void doLike(CommonUnionID unionId, String likeKey, int likeType, DataCallback<DoLikeRsp> dataCallback) {
        if (unionId != null && likeKey != null) {
            KLog.INSTANCE.i(TAG, "start do like, unionId: " + unionId + ", likeKey: " + likeKey + ", likeType: " + likeType);
            QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new DoLikeRequest(likeKey, CommonUnionIDKt.toPb(unionId), likeType), dataCallback, null, 4, null);
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doLike error, unionId: ");
        sb5.append(unionId);
        sb5.append(", likeKey: ");
        sb5.append(likeKey);
        sb5.append(", likeType: ");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, likeType, kLog, TAG);
    }

    public final void forwardFeed(CommonUnionID unionId, Map<String, String> extendInfo, String reason, boolean withCmt, int from, DataCallback<ForwardFeedRsp> dataCallback) {
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new ForwardFeedRequest(null, CommonUnionIDKt.toPb(unionId), extendInfo, reason, withCmt, from), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public final void unlike(CommonUnionID unionId, String likeKey, int likeType, DataCallback<UnLikeRsp> dataCallback) {
        if (unionId != null && likeKey != null) {
            KLog.INSTANCE.i(TAG, "start unlike, unionId: " + unionId + ", likeKey: " + likeKey + ", likeType: " + likeType);
            QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new UnlikeRequest(likeKey, CommonUnionIDKt.toPb(unionId), likeType), dataCallback, null, 4, null);
            return;
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unlike error, unionId: ");
        sb5.append(unionId);
        sb5.append(", likeKey: ");
        sb5.append(likeKey);
        sb5.append(", likeType: ");
        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(sb5, likeType, kLog, TAG);
    }

    public static /* synthetic */ void addComment$default(QzoneFeedWriteService qzoneFeedWriteService, CommonUnionID commonUnionID, CommonComment commonComment, boolean z16, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        qzoneFeedWriteService.addComment(commonUnionID, commonComment, z16, dataCallback);
    }
}
