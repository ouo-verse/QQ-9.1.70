package com.tencent.mobileqq.guild.feed.detail.task;

import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 42\u00020\u0001:\u0003567B\u0007\u00a2\u0006\u0004\b3\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR(\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001b\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u001b\u0010\u0014\u0012\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\"\u00100\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010!\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult;", "", "", "uuid", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "commentID", "getCommentID", "setCommentID", "replyTargetID", "getReplyTargetID", "setReplyTargetID", "replyID", "getReplyID", "setReplyID", "", "type", "I", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "getStatus$annotations", "", "result", "J", "getResult", "()J", "setResult", "(J)V", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "jsonContent", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "getJsonContent", "()Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "setJsonContent", "(Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;)V", WadlProxyConsts.CREATE_TIME, "getCreateTime", "setCreateTime", "sequence", "getSequence", "setSequence", "<init>", "Companion", "a", "TaskStatus", "TaskType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentResult {
    public static final int FAIL = 3;
    public static final int PRIMARY = 1;
    public static final int SECOND = 2;
    public static final int SENDING = 1;
    public static final int SUCCESS = 2;
    private long createTime;
    private long result;
    private long sequence;
    private int status;
    private int type;

    @NotNull
    private String uuid = "";

    @NotNull
    private String commentID = "";

    @NotNull
    private String replyTargetID = "";

    @NotNull
    private String replyID = "";

    @NotNull
    private GuildFeedRichContentResultBean jsonContent = new GuildFeedRichContentResultBean();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult$TaskStatus;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes13.dex */
    public @interface TaskStatus {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult$TaskType;", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes13.dex */
    public @interface TaskType {
    }

    @NotNull
    public final String getCommentID() {
        return this.commentID;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final GuildFeedRichContentResultBean getJsonContent() {
        return this.jsonContent;
    }

    @NotNull
    public final String getReplyID() {
        return this.replyID;
    }

    @NotNull
    public final String getReplyTargetID() {
        return this.replyTargetID;
    }

    public final long getResult() {
        return this.result;
    }

    public final long getSequence() {
        return this.sequence;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public final void setCommentID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commentID = str;
    }

    public final void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public final void setJsonContent(@NotNull GuildFeedRichContentResultBean guildFeedRichContentResultBean) {
        Intrinsics.checkNotNullParameter(guildFeedRichContentResultBean, "<set-?>");
        this.jsonContent = guildFeedRichContentResultBean;
    }

    public final void setReplyID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyID = str;
    }

    public final void setReplyTargetID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.replyTargetID = str;
    }

    public final void setResult(long j3) {
        this.result = j3;
    }

    public final void setSequence(long j3) {
        this.sequence = j3;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    public static /* synthetic */ void getStatus$annotations() {
    }

    public static /* synthetic */ void getType$annotations() {
    }
}
