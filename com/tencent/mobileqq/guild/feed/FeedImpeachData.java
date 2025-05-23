package com.tencent.mobileqq.guild.feed;

import NS_COMM.COMM;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B/\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0002H\u00c6\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/FeedImpeachData;", "Ljava/io/Serializable;", "", "getFeedContentId", "", "getFeedReportScene", "component1", "component2", "component3", "component4", "impeachType", "feedId", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getImpeachType", "()I", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "getCommentId", "getReplyId", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class FeedImpeachData implements Serializable {
    public static final int IMPEACH_TYPE_COMMENT = 1;
    public static final int IMPEACH_TYPE_FEED = 0;
    public static final int IMPEACH_TYPE_PROFILE = 3;
    public static final int IMPEACH_TYPE_REPLY = 2;

    @NotNull
    private final String commentId;

    @NotNull
    private final String feedId;
    private final int impeachType;

    @NotNull
    private final String replyId;

    public FeedImpeachData() {
        this(0, null, null, null, 15, null);
    }

    public static /* synthetic */ FeedImpeachData copy$default(FeedImpeachData feedImpeachData, int i3, String str, String str2, String str3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = feedImpeachData.impeachType;
        }
        if ((i16 & 2) != 0) {
            str = feedImpeachData.feedId;
        }
        if ((i16 & 4) != 0) {
            str2 = feedImpeachData.commentId;
        }
        if ((i16 & 8) != 0) {
            str3 = feedImpeachData.replyId;
        }
        return feedImpeachData.copy(i3, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getImpeachType() {
        return this.impeachType;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getReplyId() {
        return this.replyId;
    }

    @NotNull
    public final FeedImpeachData copy(int impeachType, @NotNull String feedId, @NotNull String commentId, @NotNull String replyId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        return new FeedImpeachData(impeachType, feedId, commentId, replyId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedImpeachData)) {
            return false;
        }
        FeedImpeachData feedImpeachData = (FeedImpeachData) other;
        if (this.impeachType == feedImpeachData.impeachType && Intrinsics.areEqual(this.feedId, feedImpeachData.feedId) && Intrinsics.areEqual(this.commentId, feedImpeachData.commentId) && Intrinsics.areEqual(this.replyId, feedImpeachData.replyId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    public final String getFeedContentId() {
        int i3 = this.impeachType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "";
                }
                return "feedid=" + this.feedId + "|commentid=" + this.commentId + "|replyid=" + this.replyId;
            }
            return "feedid=" + this.feedId + "|commentid=" + this.commentId;
        }
        return "feedid=" + this.feedId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final int getFeedReportScene() {
        int i3 = this.impeachType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return COMM.mini_app_api;
                }
                return COMM.mini_app_operation_admin;
            }
            return 10125;
        }
        return 10124;
    }

    public final int getImpeachType() {
        return this.impeachType;
    }

    @NotNull
    public final String getReplyId() {
        return this.replyId;
    }

    public int hashCode() {
        return (((((this.impeachType * 31) + this.feedId.hashCode()) * 31) + this.commentId.hashCode()) * 31) + this.replyId.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedImpeachData(impeachType=" + this.impeachType + ", feedId=" + this.feedId + ", commentId=" + this.commentId + ", replyId=" + this.replyId + ')';
    }

    public FeedImpeachData(int i3, @NotNull String feedId, @NotNull String commentId, @NotNull String replyId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        this.impeachType = i3;
        this.feedId = feedId;
        this.commentId = commentId;
        this.replyId = replyId;
    }

    public /* synthetic */ FeedImpeachData(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3);
    }
}
