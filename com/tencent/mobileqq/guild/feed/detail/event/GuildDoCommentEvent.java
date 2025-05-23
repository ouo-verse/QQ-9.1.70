package com.tencent.mobileqq.guild.feed.detail.event;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u00ad\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u001bJ\b\u00103\u001a\u00020\u0003H\u0016R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010)R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001f\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "content", "", WadlProxyConsts.CREATE_TIME, "", "feedId", "feedCreateTime", "guildId", "channelId", "posterId", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "isComment", "", "commentID", "commentCreateTime", "replyTargetID", "commentPosterID", "replyTargetUserID", "mOriginalPic", "businessType", "", "mReportMap", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "fromList", "(Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;Z)V", "getBusinessType", "()I", "getChannelId", "()Ljava/lang/String;", "getCommentCreateTime", "()J", "getCommentID", "getCommentPosterID", "getContent", "getCreateTime", "getFeedCreateTime", "getFeedId", "getFromList", "()Z", "getGuildId", "getLocalMediaInfos", "()Ljava/util/ArrayList;", "getMOriginalPic", "getMReportMap", "()Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "getPosterId", "getReplyTargetID", "getReplyTargetUserID", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.tencent.mobileqq.guild.feed.detail.event.GuildFeedCommentEvent, reason: from toString */
/* loaded from: classes13.dex */
public final class GuildDoCommentEvent extends SimpleBaseEvent {
    private final int businessType;

    @NotNull
    private final String channelId;
    private final long commentCreateTime;

    @NotNull
    private final String commentID;

    @NotNull
    private final String commentPosterID;

    /* renamed from: content, reason: from kotlin metadata and from toString */
    @NotNull
    private final String mContent;
    private final long createTime;
    private final long feedCreateTime;

    @NotNull
    private final String feedId;
    private final boolean fromList;

    @NotNull
    private final String guildId;
    private final boolean isComment;

    @NotNull
    private final ArrayList<LocalMediaInfo> localMediaInfos;
    private final boolean mOriginalPic;

    @NotNull
    private final GuildFeedReportSourceInfo mReportMap;

    @NotNull
    private final String posterId;

    @NotNull
    private final String replyTargetID;

    @NotNull
    private final String replyTargetUserID;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, null, 0L, null, null, null, false, 0, mReportMap, false, 196096, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final long getCommentCreateTime() {
        return this.commentCreateTime;
    }

    @NotNull
    public final String getCommentID() {
        return this.commentID;
    }

    @NotNull
    public final String getCommentPosterID() {
        return this.commentPosterID;
    }

    @NotNull
    /* renamed from: getContent, reason: from getter */
    public final String getMContent() {
        return this.mContent;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getFeedCreateTime() {
        return this.feedCreateTime;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final boolean getFromList() {
        return this.fromList;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> getLocalMediaInfos() {
        return this.localMediaInfos;
    }

    public final boolean getMOriginalPic() {
        return this.mOriginalPic;
    }

    @NotNull
    public final GuildFeedReportSourceInfo getMReportMap() {
        return this.mReportMap;
    }

    @NotNull
    public final String getPosterId() {
        return this.posterId;
    }

    @NotNull
    public final String getReplyTargetID() {
        return this.replyTargetID;
    }

    @NotNull
    public final String getReplyTargetUserID() {
        return this.replyTargetUserID;
    }

    /* renamed from: isComment, reason: from getter */
    public final boolean getIsComment() {
        return this.isComment;
    }

    @NotNull
    public String toString() {
        return "GuildDoCommentEvent(mContent='" + this.mContent + "')";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, null, null, null, false, 0, mReportMap, false, 194560, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, replyTargetID, null, null, false, 0, mReportMap, false, 192512, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull String commentPosterID, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, replyTargetID, commentPosterID, null, false, 0, mReportMap, false, 188416, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(commentPosterID, "commentPosterID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull String commentPosterID, @NotNull String replyTargetUserID, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, replyTargetID, commentPosterID, replyTargetUserID, false, 0, mReportMap, false, 180224, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(commentPosterID, "commentPosterID");
        Intrinsics.checkNotNullParameter(replyTargetUserID, "replyTargetUserID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull String commentPosterID, @NotNull String replyTargetUserID, boolean z17, int i3, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, replyTargetID, commentPosterID, replyTargetUserID, z17, i3, mReportMap, false, 131072, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(commentPosterID, "commentPosterID");
        Intrinsics.checkNotNullParameter(replyTargetUserID, "replyTargetUserID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull String commentPosterID, @NotNull String replyTargetUserID, boolean z17, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, j17, replyTargetID, commentPosterID, replyTargetUserID, z17, 0, mReportMap, false, 163840, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(commentPosterID, "commentPosterID");
        Intrinsics.checkNotNullParameter(replyTargetUserID, "replyTargetUserID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, @NotNull GuildFeedReportSourceInfo mReportMap) {
        this(content, j3, feedId, j16, guildId, channelId, posterId, localMediaInfos, z16, commentID, 0L, null, null, null, false, 0, mReportMap, false, 195584, null);
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
    }

    public /* synthetic */ GuildDoCommentEvent(String str, long j3, String str2, long j16, String str3, String str4, String str5, ArrayList arrayList, boolean z16, String str6, long j17, String str7, String str8, String str9, boolean z17, int i3, GuildFeedReportSourceInfo guildFeedReportSourceInfo, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, str2, j16, str3, str4, str5, arrayList, z16, (i16 & 512) != 0 ? "" : str6, (i16 & 1024) != 0 ? 0L : j17, (i16 & 2048) != 0 ? "" : str7, (i16 & 4096) != 0 ? "" : str8, (i16 & 8192) != 0 ? "" : str9, (i16 & 16384) != 0 ? false : z17, (32768 & i16) != 0 ? 0 : i3, guildFeedReportSourceInfo, (i16 & 131072) != 0 ? false : z18);
    }

    @JvmOverloads
    public GuildDoCommentEvent(@NotNull String content, long j3, @NotNull String feedId, long j16, @NotNull String guildId, @NotNull String channelId, @NotNull String posterId, @NotNull ArrayList<LocalMediaInfo> localMediaInfos, boolean z16, @NotNull String commentID, long j17, @NotNull String replyTargetID, @NotNull String commentPosterID, @NotNull String replyTargetUserID, boolean z17, int i3, @NotNull GuildFeedReportSourceInfo mReportMap, boolean z18) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(posterId, "posterId");
        Intrinsics.checkNotNullParameter(localMediaInfos, "localMediaInfos");
        Intrinsics.checkNotNullParameter(commentID, "commentID");
        Intrinsics.checkNotNullParameter(replyTargetID, "replyTargetID");
        Intrinsics.checkNotNullParameter(commentPosterID, "commentPosterID");
        Intrinsics.checkNotNullParameter(replyTargetUserID, "replyTargetUserID");
        Intrinsics.checkNotNullParameter(mReportMap, "mReportMap");
        this.mContent = content;
        this.createTime = j3;
        this.feedId = feedId;
        this.feedCreateTime = j16;
        this.guildId = guildId;
        this.channelId = channelId;
        this.posterId = posterId;
        this.localMediaInfos = localMediaInfos;
        this.isComment = z16;
        this.commentID = commentID;
        this.commentCreateTime = j17;
        this.replyTargetID = replyTargetID;
        this.commentPosterID = commentPosterID;
        this.replyTargetUserID = replyTargetUserID;
        this.mOriginalPic = z17;
        this.businessType = i3;
        this.mReportMap = mReportMap;
        this.fromList = z18;
    }
}
