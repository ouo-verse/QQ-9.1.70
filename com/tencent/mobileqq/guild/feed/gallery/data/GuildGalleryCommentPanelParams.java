package com.tencent.mobileqq.guild.feed.gallery.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001a\u0010(\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001a\u0010+\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "Ljava/io/Serializable;", "()V", "channelId", "", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "createdTime", "", "getCreatedTime", "()J", "setCreatedTime", "(J)V", "feedId", "getFeedId", "setFeedId", "guildId", "getGuildId", "setGuildId", "immersiveSource", "getImmersiveSource", "setImmersiveSource", "isAllowComment", "", "()Z", "setAllowComment", "(Z)V", "isPosterSelf", "setPosterSelf", "joinGuildSig", "getJoinGuildSig", "setJoinGuildSig", "lastModifiedTime", "getLastModifiedTime", "setLastModifiedTime", "posterId", "getPosterId", "setPosterId", "traceId", "getTraceId", "setTraceId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildGalleryCommentPanelParams implements Serializable {
    private int commentCount;
    private long createdTime;
    private int immersiveSource;
    private long lastModifiedTime;

    @NotNull
    private String feedId = "";

    @NotNull
    private String guildId = "";

    @NotNull
    private String channelId = "";

    @NotNull
    private String joinGuildSig = "";

    @NotNull
    private String posterId = "";

    @NotNull
    private String traceId = "";
    private boolean isAllowComment = true;
    private boolean isPosterSelf = true;

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getImmersiveSource() {
        return this.immersiveSource;
    }

    @NotNull
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    @NotNull
    public final String getPosterId() {
        return this.posterId;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: isAllowComment, reason: from getter */
    public final boolean getIsAllowComment() {
        return this.isAllowComment;
    }

    /* renamed from: isPosterSelf, reason: from getter */
    public final boolean getIsPosterSelf() {
        return this.isPosterSelf;
    }

    public final void setAllowComment(boolean z16) {
        this.isAllowComment = z16;
    }

    public final void setChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void setCommentCount(int i3) {
        this.commentCount = i3;
    }

    public final void setCreatedTime(long j3) {
        this.createdTime = j3;
    }

    public final void setFeedId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void setGuildId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void setImmersiveSource(int i3) {
        this.immersiveSource = i3;
    }

    public final void setJoinGuildSig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.joinGuildSig = str;
    }

    public final void setLastModifiedTime(long j3) {
        this.lastModifiedTime = j3;
    }

    public final void setPosterId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.posterId = str;
    }

    public final void setPosterSelf(boolean z16) {
        this.isPosterSelf = z16;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }
}
