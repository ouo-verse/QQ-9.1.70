package com.tencent.mobileqq.guild.setting.folder;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/folder/GuildFolderGuideConfig;", "", "guideImageUrlNight", "", "guideImageUrl", "guideImageShadow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGuideImageShadow", "()Ljava/lang/String;", "getGuideImageUrl", "getGuideImageUrlNight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class GuildFolderGuideConfig {

    @SerializedName("shadow")
    @NotNull
    private final String guideImageShadow;

    @SerializedName(MiniAppConst.MENU_STYLE_LIGHT)
    @NotNull
    private final String guideImageUrl;

    @SerializedName("night")
    @NotNull
    private final String guideImageUrlNight;

    public GuildFolderGuideConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GuildFolderGuideConfig copy$default(GuildFolderGuideConfig guildFolderGuideConfig, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guildFolderGuideConfig.guideImageUrlNight;
        }
        if ((i3 & 2) != 0) {
            str2 = guildFolderGuideConfig.guideImageUrl;
        }
        if ((i3 & 4) != 0) {
            str3 = guildFolderGuideConfig.guideImageShadow;
        }
        return guildFolderGuideConfig.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuideImageUrlNight() {
        return this.guideImageUrlNight;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getGuideImageShadow() {
        return this.guideImageShadow;
    }

    @NotNull
    public final GuildFolderGuideConfig copy(@NotNull String guideImageUrlNight, @NotNull String guideImageUrl, @NotNull String guideImageShadow) {
        Intrinsics.checkNotNullParameter(guideImageUrlNight, "guideImageUrlNight");
        Intrinsics.checkNotNullParameter(guideImageUrl, "guideImageUrl");
        Intrinsics.checkNotNullParameter(guideImageShadow, "guideImageShadow");
        return new GuildFolderGuideConfig(guideImageUrlNight, guideImageUrl, guideImageShadow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFolderGuideConfig)) {
            return false;
        }
        GuildFolderGuideConfig guildFolderGuideConfig = (GuildFolderGuideConfig) other;
        if (Intrinsics.areEqual(this.guideImageUrlNight, guildFolderGuideConfig.guideImageUrlNight) && Intrinsics.areEqual(this.guideImageUrl, guildFolderGuideConfig.guideImageUrl) && Intrinsics.areEqual(this.guideImageShadow, guildFolderGuideConfig.guideImageShadow)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getGuideImageShadow() {
        return this.guideImageShadow;
    }

    @NotNull
    public final String getGuideImageUrl() {
        return this.guideImageUrl;
    }

    @NotNull
    public final String getGuideImageUrlNight() {
        return this.guideImageUrlNight;
    }

    public int hashCode() {
        return (((this.guideImageUrlNight.hashCode() * 31) + this.guideImageUrl.hashCode()) * 31) + this.guideImageShadow.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFolderGuideConfig(guideImageUrlNight=" + this.guideImageUrlNight + ", guideImageUrl=" + this.guideImageUrl + ", guideImageShadow=" + this.guideImageShadow + ")";
    }

    public GuildFolderGuideConfig(@NotNull String guideImageUrlNight, @NotNull String guideImageUrl, @NotNull String guideImageShadow) {
        Intrinsics.checkNotNullParameter(guideImageUrlNight, "guideImageUrlNight");
        Intrinsics.checkNotNullParameter(guideImageUrl, "guideImageUrl");
        Intrinsics.checkNotNullParameter(guideImageShadow, "guideImageShadow");
        this.guideImageUrlNight = guideImageUrlNight;
        this.guideImageUrl = guideImageUrl;
        this.guideImageShadow = guideImageShadow;
    }

    public /* synthetic */ GuildFolderGuideConfig(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "http://downv6.qq.com/innovate/guild/sfeed/guide_folder_guide_night.png" : str, (i3 & 2) != 0 ? "https://downv6.qq.com/innovate/guild/sfeed/guide_folder_guide_normal.png" : str2, (i3 & 4) != 0 ? "https://downv6.qq.com/innovate/guild/sfeed/guide_folder_guide_shadow.png" : str3);
    }
}
