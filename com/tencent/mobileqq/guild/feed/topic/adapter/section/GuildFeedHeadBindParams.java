package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\nBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0003\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJE\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/a;", "", "", "nickName", "feedRole", "", "feedRoleColor", "channelTopFlagText", "channelTopFlagTextColorRes", "channelTopFlagBgColor", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "b", "g", "c", "I", tl.h.F, "()I", "d", "e", "f", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.topic.adapter.section.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedHeadBindParams {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedRole;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int feedRoleColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelTopFlagText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelTopFlagTextColorRes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelTopFlagBgColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/a$a;", "", "", "nickName", "feedRole", "", "feedRoleColor", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/a;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.adapter.section.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedHeadBindParams a(@NotNull String nickName, @NotNull String feedRole, int feedRoleColor) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(feedRole, "feedRole");
            return new GuildFeedHeadBindParams(nickName, feedRole, feedRoleColor, null, 0, null, 56, null);
        }

        Companion() {
        }
    }

    public GuildFeedHeadBindParams(@NotNull String nickName, @NotNull String feedRole, @ColorInt int i3, @NotNull String channelTopFlagText, @ColorRes int i16, @NotNull String channelTopFlagBgColor) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(feedRole, "feedRole");
        Intrinsics.checkNotNullParameter(channelTopFlagText, "channelTopFlagText");
        Intrinsics.checkNotNullParameter(channelTopFlagBgColor, "channelTopFlagBgColor");
        this.nickName = nickName;
        this.feedRole = feedRole;
        this.feedRoleColor = i3;
        this.channelTopFlagText = channelTopFlagText;
        this.channelTopFlagTextColorRes = i16;
        this.channelTopFlagBgColor = channelTopFlagBgColor;
    }

    public static /* synthetic */ GuildFeedHeadBindParams b(GuildFeedHeadBindParams guildFeedHeadBindParams, String str, String str2, int i3, String str3, int i16, String str4, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = guildFeedHeadBindParams.nickName;
        }
        if ((i17 & 2) != 0) {
            str2 = guildFeedHeadBindParams.feedRole;
        }
        String str5 = str2;
        if ((i17 & 4) != 0) {
            i3 = guildFeedHeadBindParams.feedRoleColor;
        }
        int i18 = i3;
        if ((i17 & 8) != 0) {
            str3 = guildFeedHeadBindParams.channelTopFlagText;
        }
        String str6 = str3;
        if ((i17 & 16) != 0) {
            i16 = guildFeedHeadBindParams.channelTopFlagTextColorRes;
        }
        int i19 = i16;
        if ((i17 & 32) != 0) {
            str4 = guildFeedHeadBindParams.channelTopFlagBgColor;
        }
        return guildFeedHeadBindParams.a(str, str5, i18, str6, i19, str4);
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedHeadBindParams c(@NotNull String str, @NotNull String str2, int i3) {
        return INSTANCE.a(str, str2, i3);
    }

    @NotNull
    public final GuildFeedHeadBindParams a(@NotNull String nickName, @NotNull String feedRole, @ColorInt int feedRoleColor, @NotNull String channelTopFlagText, @ColorRes int channelTopFlagTextColorRes, @NotNull String channelTopFlagBgColor) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(feedRole, "feedRole");
        Intrinsics.checkNotNullParameter(channelTopFlagText, "channelTopFlagText");
        Intrinsics.checkNotNullParameter(channelTopFlagBgColor, "channelTopFlagBgColor");
        return new GuildFeedHeadBindParams(nickName, feedRole, feedRoleColor, channelTopFlagText, channelTopFlagTextColorRes, channelTopFlagBgColor);
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getChannelTopFlagBgColor() {
        return this.channelTopFlagBgColor;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getChannelTopFlagText() {
        return this.channelTopFlagText;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedHeadBindParams)) {
            return false;
        }
        GuildFeedHeadBindParams guildFeedHeadBindParams = (GuildFeedHeadBindParams) other;
        if (Intrinsics.areEqual(this.nickName, guildFeedHeadBindParams.nickName) && Intrinsics.areEqual(this.feedRole, guildFeedHeadBindParams.feedRole) && this.feedRoleColor == guildFeedHeadBindParams.feedRoleColor && Intrinsics.areEqual(this.channelTopFlagText, guildFeedHeadBindParams.channelTopFlagText) && this.channelTopFlagTextColorRes == guildFeedHeadBindParams.channelTopFlagTextColorRes && Intrinsics.areEqual(this.channelTopFlagBgColor, guildFeedHeadBindParams.channelTopFlagBgColor)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getChannelTopFlagTextColorRes() {
        return this.channelTopFlagTextColorRes;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getFeedRole() {
        return this.feedRole;
    }

    /* renamed from: h, reason: from getter */
    public final int getFeedRoleColor() {
        return this.feedRoleColor;
    }

    public int hashCode() {
        return (((((((((this.nickName.hashCode() * 31) + this.feedRole.hashCode()) * 31) + this.feedRoleColor) * 31) + this.channelTopFlagText.hashCode()) * 31) + this.channelTopFlagTextColorRes) * 31) + this.channelTopFlagBgColor.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public String toString() {
        return "GuildFeedHeadBindParams(nickName=" + this.nickName + ", feedRole=" + this.feedRole + ", feedRoleColor=" + this.feedRoleColor + ", channelTopFlagText=" + this.channelTopFlagText + ", channelTopFlagTextColorRes=" + this.channelTopFlagTextColorRes + ", channelTopFlagBgColor=" + this.channelTopFlagBgColor + ")";
    }

    public /* synthetic */ GuildFeedHeadBindParams(String str, String str2, int i3, String str3, int i16, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? -1 : i3, (i17 & 8) == 0 ? str3 : "", (i17 & 16) != 0 ? R.color.qui_common_feedback_error : i16, (i17 & 32) != 0 ? TipsElementData.DEFAULT_COLOR : str4);
    }
}
