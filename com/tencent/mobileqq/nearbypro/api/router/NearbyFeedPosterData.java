package com.tencent.mobileqq.nearbypro.api.router;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nBg\u0012\f\b\u0002\u0010\r\u001a\u00060\u0004j\u0002`\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001b\u0010\r\u001a\u00060\u0004j\u0002`\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u000e\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "a", "I", "()I", "appId", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "userId", "c", "d", "feedId", "feedFallbackImage", "e", "feedTitle", "f", "g", "userAvatar", "i", "userNickname", "themeId", "Lcom/tencent/mobileqq/nearbypro/api/router/b$a;", "feedAddress", "Lcom/tencent/mobileqq/nearbypro/api/router/b$a;", "()Lcom/tencent/mobileqq/nearbypro/api/router/b$a;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/nearbypro/api/router/b$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.api.router.b, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class NearbyFeedPosterData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedFallbackImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userAvatar;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String userNickname;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String themeId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/b$a;", "", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.api.router.b$a */
    /* loaded from: classes15.dex */
    public static final /* data */ class a {
    }

    public NearbyFeedPosterData() {
        this(0, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    @Nullable
    public final a b() {
        return null;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeedFallbackImage() {
        return this.feedFallbackImage;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getFeedTitle() {
        return this.feedTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NearbyFeedPosterData)) {
            return false;
        }
        NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) other;
        if (this.appId == nearbyFeedPosterData.appId && Intrinsics.areEqual(this.userId, nearbyFeedPosterData.userId) && Intrinsics.areEqual(this.feedId, nearbyFeedPosterData.feedId) && Intrinsics.areEqual(this.feedFallbackImage, nearbyFeedPosterData.feedFallbackImage) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.feedTitle, nearbyFeedPosterData.feedTitle) && Intrinsics.areEqual(this.userAvatar, nearbyFeedPosterData.userAvatar) && Intrinsics.areEqual(this.userNickname, nearbyFeedPosterData.userNickname) && Intrinsics.areEqual(this.themeId, nearbyFeedPosterData.themeId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getThemeId() {
        return this.themeId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((((((((((((((this.appId * 31) + this.userId.hashCode()) * 31) + this.feedId.hashCode()) * 31) + this.feedFallbackImage.hashCode()) * 31) + 0) * 31) + this.feedTitle.hashCode()) * 31) + this.userAvatar.hashCode()) * 31) + this.userNickname.hashCode()) * 31) + this.themeId.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getUserNickname() {
        return this.userNickname;
    }

    @NotNull
    public String toString() {
        return "NearbyFeedPosterData(appId=" + this.appId + ", userId=" + this.userId + ", feedId=" + this.feedId + ", feedFallbackImage=" + this.feedFallbackImage + ", feedAddress=" + ((Object) null) + ", feedTitle=" + this.feedTitle + ", userAvatar=" + this.userAvatar + ", userNickname=" + this.userNickname + ", themeId=" + this.themeId + ")";
    }

    public NearbyFeedPosterData(int i3, @NotNull String userId, @NotNull String feedId, @NotNull String feedFallbackImage, @Nullable a aVar, @NotNull String feedTitle, @NotNull String userAvatar, @NotNull String userNickname, @NotNull String themeId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(feedFallbackImage, "feedFallbackImage");
        Intrinsics.checkNotNullParameter(feedTitle, "feedTitle");
        Intrinsics.checkNotNullParameter(userAvatar, "userAvatar");
        Intrinsics.checkNotNullParameter(userNickname, "userNickname");
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        this.appId = i3;
        this.userId = userId;
        this.feedId = feedId;
        this.feedFallbackImage = feedFallbackImage;
        this.feedTitle = feedTitle;
        this.userAvatar = userAvatar;
        this.userNickname = userNickname;
        this.themeId = themeId;
    }

    public /* synthetic */ NearbyFeedPosterData(int i3, String str, String str2, String str3, a aVar, String str4, String str5, String str6, String str7, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 2 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? null : aVar, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? "" : str5, (i16 & 128) != 0 ? "" : str6, (i16 & 256) == 0 ? str7 : "");
    }
}
