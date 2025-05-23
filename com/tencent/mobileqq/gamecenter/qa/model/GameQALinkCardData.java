package com.tencent.mobileqq.gamecenter.qa.model;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b$\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001JB\u007f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\u0016\u00a2\u0006\u0004\bG\u0010HJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\nH\u00c6\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\nH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0016H\u00c6\u0003J\u0099\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\b\b\u0002\u0010 \u001a\u00020\u00122\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\r2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u0016H\u00c6\u0001J\t\u0010%\u001a\u00020\nH\u00d6\u0001J\t\u0010&\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010)\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010'H\u00d6\u0003R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u00102R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b4\u00105R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00106\u001a\u0004\b;\u00108R\u001f\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\b=\u0010>R\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b?\u0010>R\u0017\u0010 \u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b \u0010@\u001a\u0004\bA\u0010BR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006\u00a2\u0006\f\n\u0004\b!\u0010<\u001a\u0004\bC\u0010>R\u0017\u0010\"\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\"\u00106\u001a\u0004\bD\u00108R\u0017\u0010#\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b#\u0010E\u001a\u0004\b#\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/gamecenter/qa/model/LinkType;", "component1", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefInfo;", "component2", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQuestionUserInfo;", "component3", "", "component4", "", "component5", "component6", "", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameStrategyPic;", "component7", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameStrategyVideo;", "component8", "", "component9", "component10", "component11", "", "component12", "linkType", "linkRefInfo", ITVKPlayerEventListener.KEY_USER_INFO, "createTs", "title", "content", s4.c.PICS, "videos", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "url", "isSelf", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/gamecenter/qa/model/LinkType;", "getLinkType", "()Lcom/tencent/mobileqq/gamecenter/qa/model/LinkType;", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefInfo;", "getLinkRefInfo", "()Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefInfo;", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQuestionUserInfo;", "getUserInfo", "()Lcom/tencent/mobileqq/gamecenter/qa/model/GameQuestionUserInfo;", "J", "getCreateTs", "()J", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "Ljava/util/List;", "getPics", "()Ljava/util/List;", "getVideos", "I", "getLikeCount", "()I", "getTags", "getUrl", "Z", "()Z", "<init>", "(Lcom/tencent/mobileqq/gamecenter/qa/model/LinkType;Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefInfo;Lcom/tencent/mobileqq/gamecenter/qa/model/GameQuestionUserInfo;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/util/List;Ljava/lang/String;Z)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GameQALinkCardData implements Serializable {
    private static final long serialVersionUID = 1;

    @NotNull
    private final String content;
    private final long createTs;
    private final boolean isSelf;
    private final int likeCount;

    @Nullable
    private final GameQALinkRefInfo linkRefInfo;

    @NotNull
    private final LinkType linkType;

    @Nullable
    private final List<GameStrategyPic> pics;

    @NotNull
    private final List<String> tags;

    @NotNull
    private String title;

    @NotNull
    private final String url;

    @NotNull
    private final GameQuestionUserInfo userInfo;

    @Nullable
    private final List<GameStrategyVideo> videos;

    /* JADX WARN: Multi-variable type inference failed */
    public GameQALinkCardData(@NotNull LinkType linkType, @Nullable GameQALinkRefInfo gameQALinkRefInfo, @NotNull GameQuestionUserInfo userInfo, long j3, @NotNull String title, @NotNull String content, @Nullable List<? extends GameStrategyPic> list, @Nullable List<? extends GameStrategyVideo> list2, int i3, @NotNull List<String> tags, @NotNull String url, boolean z16) {
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(url, "url");
        this.linkType = linkType;
        this.linkRefInfo = gameQALinkRefInfo;
        this.userInfo = userInfo;
        this.createTs = j3;
        this.title = title;
        this.content = content;
        this.pics = list;
        this.videos = list2;
        this.likeCount = i3;
        this.tags = tags;
        this.url = url;
        this.isSelf = z16;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final LinkType getLinkType() {
        return this.linkType;
    }

    @NotNull
    public final List<String> component10() {
        return this.tags;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsSelf() {
        return this.isSelf;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GameQALinkRefInfo getLinkRefInfo() {
        return this.linkRefInfo;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final GameQuestionUserInfo getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreateTs() {
        return this.createTs;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<GameStrategyPic> component7() {
        return this.pics;
    }

    @Nullable
    public final List<GameStrategyVideo> component8() {
        return this.videos;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final GameQALinkCardData copy(@NotNull LinkType linkType, @Nullable GameQALinkRefInfo linkRefInfo, @NotNull GameQuestionUserInfo userInfo, long createTs, @NotNull String title, @NotNull String content, @Nullable List<? extends GameStrategyPic> pics, @Nullable List<? extends GameStrategyVideo> videos, int likeCount, @NotNull List<String> tags, @NotNull String url, boolean isSelf) {
        Intrinsics.checkNotNullParameter(linkType, "linkType");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(url, "url");
        return new GameQALinkCardData(linkType, linkRefInfo, userInfo, createTs, title, content, pics, videos, likeCount, tags, url, isSelf);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameQALinkCardData)) {
            return false;
        }
        GameQALinkCardData gameQALinkCardData = (GameQALinkCardData) other;
        if (this.linkType == gameQALinkCardData.linkType && Intrinsics.areEqual(this.linkRefInfo, gameQALinkCardData.linkRefInfo) && Intrinsics.areEqual(this.userInfo, gameQALinkCardData.userInfo) && this.createTs == gameQALinkCardData.createTs && Intrinsics.areEqual(this.title, gameQALinkCardData.title) && Intrinsics.areEqual(this.content, gameQALinkCardData.content) && Intrinsics.areEqual(this.pics, gameQALinkCardData.pics) && Intrinsics.areEqual(this.videos, gameQALinkCardData.videos) && this.likeCount == gameQALinkCardData.likeCount && Intrinsics.areEqual(this.tags, gameQALinkCardData.tags) && Intrinsics.areEqual(this.url, gameQALinkCardData.url) && this.isSelf == gameQALinkCardData.isSelf) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getCreateTs() {
        return this.createTs;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final GameQALinkRefInfo getLinkRefInfo() {
        return this.linkRefInfo;
    }

    @NotNull
    public final LinkType getLinkType() {
        return this.linkType;
    }

    @Nullable
    public final List<GameStrategyPic> getPics() {
        return this.pics;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final GameQuestionUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Nullable
    public final List<GameStrategyVideo> getVideos() {
        return this.videos;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.linkType.hashCode() * 31;
        GameQALinkRefInfo gameQALinkRefInfo = this.linkRefInfo;
        int i3 = 0;
        if (gameQALinkRefInfo == null) {
            hashCode = 0;
        } else {
            hashCode = gameQALinkRefInfo.hashCode();
        }
        int hashCode4 = (((((((((hashCode3 + hashCode) * 31) + this.userInfo.hashCode()) * 31) + androidx.fragment.app.a.a(this.createTs)) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<GameStrategyPic> list = this.pics;
        if (list == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list.hashCode();
        }
        int i16 = (hashCode4 + hashCode2) * 31;
        List<GameStrategyVideo> list2 = this.videos;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int hashCode5 = (((((((i16 + i3) * 31) + this.likeCount) * 31) + this.tags.hashCode()) * 31) + this.url.hashCode()) * 31;
        boolean z16 = this.isSelf;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return hashCode5 + i17;
    }

    public final boolean isSelf() {
        return this.isSelf;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        return "GameQALinkCardData(linkType=" + this.linkType + ", linkRefInfo=" + this.linkRefInfo + ", userInfo=" + this.userInfo + ", createTs=" + this.createTs + ", title=" + this.title + ", content=" + this.content + ", pics=" + this.pics + ", videos=" + this.videos + ", likeCount=" + this.likeCount + ", tags=" + this.tags + ", url=" + this.url + ", isSelf=" + this.isSelf + ")";
    }
}
