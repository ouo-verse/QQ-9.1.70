package com.tencent.mobileqq.guild.live.livemanager.anchor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\n\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/anchor/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkf4/a;", "a", "Lkf4/a;", "c", "()Lkf4/a;", "setGuildIDInfo", "(Lkf4/a;)V", "guildIDInfo", "b", "I", "d", "()I", "liveGameId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setLiveTitle", "(Ljava/lang/String;)V", "liveTitle", "setCoverUrl", "coverUrl", "setBackSchema", "backSchema", "f", "setShareSchema", "shareSchema", "<init>", "(Lkf4/a;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.livemanager.anchor.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GameLiveStartParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private kf4.a guildIDInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int liveGameId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String liveTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String coverUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String backSchema;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String shareSchema;

    public GameLiveStartParams(@NotNull kf4.a guildIDInfo, int i3, @NotNull String liveTitle, @NotNull String coverUrl, @NotNull String backSchema, @NotNull String shareSchema) {
        Intrinsics.checkNotNullParameter(guildIDInfo, "guildIDInfo");
        Intrinsics.checkNotNullParameter(liveTitle, "liveTitle");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(backSchema, "backSchema");
        Intrinsics.checkNotNullParameter(shareSchema, "shareSchema");
        this.guildIDInfo = guildIDInfo;
        this.liveGameId = i3;
        this.liveTitle = liveTitle;
        this.coverUrl = coverUrl;
        this.backSchema = backSchema;
        this.shareSchema = shareSchema;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBackSchema() {
        return this.backSchema;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final kf4.a getGuildIDInfo() {
        return this.guildIDInfo;
    }

    /* renamed from: d, reason: from getter */
    public final int getLiveGameId() {
        return this.liveGameId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLiveTitle() {
        return this.liveTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameLiveStartParams)) {
            return false;
        }
        GameLiveStartParams gameLiveStartParams = (GameLiveStartParams) other;
        if (Intrinsics.areEqual(this.guildIDInfo, gameLiveStartParams.guildIDInfo) && this.liveGameId == gameLiveStartParams.liveGameId && Intrinsics.areEqual(this.liveTitle, gameLiveStartParams.liveTitle) && Intrinsics.areEqual(this.coverUrl, gameLiveStartParams.coverUrl) && Intrinsics.areEqual(this.backSchema, gameLiveStartParams.backSchema) && Intrinsics.areEqual(this.shareSchema, gameLiveStartParams.shareSchema)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getShareSchema() {
        return this.shareSchema;
    }

    public int hashCode() {
        return (((((((((this.guildIDInfo.hashCode() * 31) + this.liveGameId) * 31) + this.liveTitle.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.backSchema.hashCode()) * 31) + this.shareSchema.hashCode();
    }

    @NotNull
    public String toString() {
        return "GameLiveStartParams(guildIDInfo=" + this.guildIDInfo + ", liveGameId=" + this.liveGameId + ", liveTitle=" + this.liveTitle + ", coverUrl=" + this.coverUrl + ", backSchema=" + this.backSchema + ", shareSchema=" + this.shareSchema + ")";
    }
}
