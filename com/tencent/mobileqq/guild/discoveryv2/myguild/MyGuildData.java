package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", PhotoCategorySummaryInfo.AVATAR_URL, "e", "title", "d", "description", "Z", "f", "()Z", "isCreatedByMe", "officialIconUrl", "g", "isTop", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.j, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MyGuildData extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String description;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCreatedByMe;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String officialIconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isTop;

    public MyGuildData(@NotNull String guildId, @NotNull String avatarUrl, @NotNull String title, @NotNull String description, boolean z16, @NotNull String officialIconUrl, boolean z17) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(officialIconUrl, "officialIconUrl");
        this.guildId = guildId;
        this.avatarUrl = avatarUrl;
        this.title = title;
        this.description = description;
        this.isCreatedByMe = z16;
        this.officialIconUrl = officialIconUrl;
        this.isTop = z17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getOfficialIconUrl() {
        return this.officialIconUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyGuildData)) {
            return false;
        }
        MyGuildData myGuildData = (MyGuildData) other;
        if (Intrinsics.areEqual(this.guildId, myGuildData.guildId) && Intrinsics.areEqual(this.avatarUrl, myGuildData.avatarUrl) && Intrinsics.areEqual(this.title, myGuildData.title) && Intrinsics.areEqual(this.description, myGuildData.description) && this.isCreatedByMe == myGuildData.isCreatedByMe && Intrinsics.areEqual(this.officialIconUrl, myGuildData.officialIconUrl) && this.isTop == myGuildData.isTop) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsCreatedByMe() {
        return this.isCreatedByMe;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public int hashCode() {
        int hashCode = ((((((this.guildId.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        boolean z16 = this.isCreatedByMe;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.officialIconUrl.hashCode()) * 31;
        boolean z17 = this.isTop;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    @NotNull
    public String toString() {
        return "MyGuildData(guildId=" + this.guildId + ", avatarUrl=" + this.avatarUrl + ", title=" + this.title + ", description=" + this.description + ", isCreatedByMe=" + this.isCreatedByMe + ", officialIconUrl=" + this.officialIconUrl + ", isTop=" + this.isTop + ")";
    }
}
