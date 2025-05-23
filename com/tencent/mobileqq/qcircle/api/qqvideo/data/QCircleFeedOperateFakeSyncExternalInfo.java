package com.tencent.mobileqq.qcircle.api.qqvideo.data;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/qqvideo/data/QCircleFeedOperateFakeSyncInfo;", "Ljava/io/Serializable;", "", "toString", "", "eventType", "I", "getEventType", "()I", "setEventType", "(I)V", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_UGCKEY, "getUgcKey", "setUgcKey", "clientKey", "getClientKey", "setClientKey", WSAutoShowCommentParams.KEY_COMMENT_ID, "getCommentId", "setCommentId", WSAutoShowCommentParams.KEY_REPLY_ID, "getReplyId", "setReplyId", "", "isLike", "Z", "()Z", "setLike", "(Z)V", "content", "getContent", "setContent", IProfileProtocolConst.PARAM_TARGET_UIN, "getTargetUin", "setTargetUin", "targetNick", "getTargetNick", "setTargetNick", "<init>", "()V", "Companion", "a", "qcircle-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qcircle.api.qqvideo.data.QCircleFeedOperateFakeSyncInfo, reason: from toString */
/* loaded from: classes16.dex */
public final class QCircleFeedOperateFakeSyncExternalInfo implements Serializable {
    public static final int EVENT_TYPE_COMMENT_ADD = 4;
    public static final int EVENT_TYPE_COMMENT_DELETE = 5;
    public static final int EVENT_TYPE_COMMENT_LIKE = 2;
    public static final int EVENT_TYPE_DELETE = 8;
    public static final int EVENT_TYPE_LIKE = 1;
    public static final int EVENT_TYPE_REPLY_ADD = 6;
    public static final int EVENT_TYPE_REPLY_DELETE = 7;
    public static final int EVENT_TYPE_REPLY_LIKE = 3;
    public static final int EVENT_TYPE_SHARE = 9;
    private int eventType;
    private boolean isLike;

    @NotNull
    private String feedId = "";

    @NotNull
    private String ugcKey = "";

    @NotNull
    private String clientKey = "";

    @NotNull
    private String commentId = "";

    @NotNull
    private String replyId = "";

    @NotNull
    private String content = "";

    @NotNull
    private String targetUin = "";

    @NotNull
    private String targetNick = "";

    @NotNull
    public final String getClientKey() {
        return this.clientKey;
    }

    @NotNull
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getEventType() {
        return this.eventType;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getReplyId() {
        return this.replyId;
    }

    @NotNull
    public final String getTargetNick() {
        return this.targetNick;
    }

    @NotNull
    public final String getTargetUin() {
        return this.targetUin;
    }

    @NotNull
    public final String getUgcKey() {
        return this.ugcKey;
    }

    /* renamed from: isLike, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    public final void setClientKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientKey = str;
    }

    public final void setCommentId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentId = str;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setEventType(int i3) {
        this.eventType = i3;
    }

    public final void setFeedId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void setLike(boolean z16) {
        this.isLike = z16;
    }

    public final void setReplyId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyId = str;
    }

    public final void setTargetNick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetNick = str;
    }

    public final void setTargetUin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetUin = str;
    }

    public final void setUgcKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ugcKey = str;
    }

    @NotNull
    public String toString() {
        return "QCircleFeedOperateFakeSyncExternalInfo(eventType=" + this.eventType + ", feedId='" + this.feedId + "', ugcKey='" + this.ugcKey + "', clientKey='" + this.clientKey + "', commentId='" + this.commentId + "', replyId='" + this.replyId + "', content='" + this.content + "', targetUin='" + this.targetUin + "', targetNick='" + this.targetNick + "', isLike=" + this.isLike + ')';
    }
}
