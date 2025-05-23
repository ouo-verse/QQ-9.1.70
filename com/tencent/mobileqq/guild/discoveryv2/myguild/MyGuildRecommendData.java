package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001b\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0000J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u001a\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b \u0010\rR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "", "other", "", "equals", "", "hashCode", "a", "", "toString", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "guildId", "b", "c", "channelId", "f", "joinGuildSig", "d", PhotoCategorySummaryInfo.AVATAR_URL, "i", "title", "description", "g", "officialIconUrl", "", tl.h.F, "Ljava/util/List;", "()Ljava/util/List;", "tagList", "j", "traceId", "Z", "k", "()Z", "l", "(Z)V", "isGuest", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.aa, reason: from toString */
/* loaded from: classes13.dex */
public final class MyGuildRecommendData extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildSig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String description;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String officialIconUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> tagList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isGuest;

    public MyGuildRecommendData(@NotNull String guildId, @NotNull String channelId, @NotNull String joinGuildSig, @NotNull String avatarUrl, @NotNull String title, @NotNull String description, @NotNull String officialIconUrl, @NotNull List<String> tagList, @NotNull String traceId, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(officialIconUrl, "officialIconUrl");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.joinGuildSig = joinGuildSig;
        this.avatarUrl = avatarUrl;
        this.title = title;
        this.description = description;
        this.officialIconUrl = officialIconUrl;
        this.tagList = tagList;
        this.traceId = traceId;
        this.isGuest = z16;
    }

    @NotNull
    public final MyGuildRecommendData a() {
        return new MyGuildRecommendData(this.guildId, this.channelId, this.joinGuildSig, this.avatarUrl, this.title, this.description, this.officialIconUrl, this.tagList, this.traceId, this.isGuest);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MyGuildRecommendData.class, cls) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendData");
        MyGuildRecommendData myGuildRecommendData = (MyGuildRecommendData) other;
        if (Intrinsics.areEqual(this.guildId, myGuildRecommendData.guildId) && Intrinsics.areEqual(this.channelId, myGuildRecommendData.channelId) && Intrinsics.areEqual(this.avatarUrl, myGuildRecommendData.avatarUrl) && Intrinsics.areEqual(this.title, myGuildRecommendData.title) && Intrinsics.areEqual(this.description, myGuildRecommendData.description) && Intrinsics.areEqual(this.officialIconUrl, myGuildRecommendData.officialIconUrl) && Intrinsics.areEqual(this.tagList, myGuildRecommendData.tagList) && this.isGuest == myGuildRecommendData.isGuest) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getOfficialIconUrl() {
        return this.officialIconUrl;
    }

    @NotNull
    public final List<String> h() {
        return this.tagList;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public int hashCode() {
        return (((((((((((((((super.hashCode() * 31) + this.guildId.hashCode()) * 31) + this.channelId.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.officialIconUrl.hashCode()) * 31) + this.tagList.hashCode()) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isGuest);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsGuest() {
        return this.isGuest;
    }

    public final void l(boolean z16) {
        this.isGuest = z16;
    }

    @NotNull
    public String toString() {
        return "MyGuildRecommendData(guildId='" + this.guildId + "', channelId='" + this.channelId + "', joinGuildSig='" + this.joinGuildSig + "', avatarUrl='" + this.avatarUrl + "', title='" + this.title + "', description='" + this.description + "', officialIconUrl='" + this.officialIconUrl + "', tagList=" + this.tagList + ", traceId='" + this.traceId + "', isGuest=" + this.isGuest + ")";
    }
}
