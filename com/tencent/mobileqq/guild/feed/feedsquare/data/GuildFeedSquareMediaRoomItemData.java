package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0002\t\u000eBG\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u000e\u0010\u0014R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "coverUrl", "I", "f", "()I", "themeType", "e", "channelMemberCount", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k$b;", "Ljava/util/List;", "g", "()Ljava/util/List;", "userList", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;)V", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.k, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildFeedSquareMediaRoomItemData {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String coverUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int themeType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelMemberCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<User> userList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IAudioChannelMemberInfos;", "channelMemberInfo", "", "a", "info", "", "c", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k$b;", "d", "b", "guildId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k;", "e", "DEFAULT_SCREEN_SHARE_BG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.k$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(IAudioChannelMemberInfos channelMemberInfo) {
            IGProAVChannelConfig aVChannelConfig;
            ArrayList<IGProGuildThemeInfo> themeList;
            boolean isBlank;
            boolean z16;
            if (channelMemberInfo != null && (aVChannelConfig = channelMemberInfo.getAVChannelConfig()) != null && (themeList = aVChannelConfig.getThemeList()) != null) {
                for (IGProGuildThemeInfo iGProGuildThemeInfo : themeList) {
                    int themeType = iGProGuildThemeInfo.getThemeType();
                    if (themeType != 2 && themeType != 4 && themeType != 6) {
                        if (themeType == 7) {
                            ArrayList<IGProBusinessNode> businessList = channelMemberInfo.getAVChannelConfig().getBusinessList();
                            Intrinsics.checkNotNullExpressionValue(businessList, "channelMemberInfo.avChannelConfig.businessList");
                            for (IGProBusinessNode iGProBusinessNode : businessList) {
                                if (iGProBusinessNode.getNodeType() == 2) {
                                    String screenPic = iGProBusinessNode.getScreenShareInfo().getScreenPic();
                                    if (screenPic.length() == 0) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if (z16) {
                                        return "https://downv6.qq.com/innovate/guild/cover_info/active_channel_screen.png";
                                    }
                                    return screenPic;
                                }
                            }
                        }
                    } else {
                        String themeBgImg = iGProGuildThemeInfo.getThemeBgImg();
                        isBlank = StringsKt__StringsJVMKt.isBlank(themeBgImg);
                        if (isBlank) {
                            return iGProGuildThemeInfo.getThemeIcon();
                        }
                        return themeBgImg;
                    }
                }
                return null;
            }
            return null;
        }

        private final String b(IAudioChannelMemberInfos channelMemberInfo) {
            ArrayList<IGProGuildThemeInfo> arrayList;
            IGProAVChannelConfig aVChannelConfig;
            if (channelMemberInfo != null && (aVChannelConfig = channelMemberInfo.getAVChannelConfig()) != null) {
                arrayList = aVChannelConfig.getThemeList();
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                return "";
            }
            for (IGProGuildThemeInfo iGProGuildThemeInfo : arrayList) {
                if (iGProGuildThemeInfo.getThemeType() == 7) {
                    if (channelMemberInfo.getScreenShareUserInfo() != null) {
                        String sessionId = iGProGuildThemeInfo.getSessionId();
                        Intrinsics.checkNotNullExpressionValue(sessionId, "theme.sessionId");
                        return sessionId;
                    }
                } else {
                    String sessionId2 = iGProGuildThemeInfo.getSessionId();
                    Intrinsics.checkNotNullExpressionValue(sessionId2, "theme.sessionId");
                    return sessionId2;
                }
            }
            return "";
        }

        private final int c(IAudioChannelMemberInfos info) {
            ArrayList<IGProGuildThemeInfo> arrayList;
            IGProAVChannelConfig aVChannelConfig;
            if (info != null && (aVChannelConfig = info.getAVChannelConfig()) != null) {
                arrayList = aVChannelConfig.getThemeList();
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                return 0;
            }
            for (IGProGuildThemeInfo iGProGuildThemeInfo : arrayList) {
                if (iGProGuildThemeInfo.getThemeType() == 7) {
                    if (info.getScreenShareUserInfo() != null) {
                        return iGProGuildThemeInfo.getThemeType();
                    }
                } else {
                    return iGProGuildThemeInfo.getThemeType();
                }
            }
            return 0;
        }

        private final List<User> d(IAudioChannelMemberInfos channelMemberInfo) {
            List<IGProUserInfo> userList;
            boolean z16;
            ArrayList arrayList = new ArrayList();
            if (channelMemberInfo != null && (userList = channelMemberInfo.getUserList()) != null) {
                for (IGProUserInfo iGProUserInfo : userList) {
                    String tinyId = iGProUserInfo.getTinyId();
                    boolean z17 = false;
                    if (tinyId != null && tinyId.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        if (iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserDevState().getMicState() == 2) {
                            z17 = true;
                        }
                        String tinyId2 = iGProUserInfo.getTinyId();
                        Intrinsics.checkNotNullExpressionValue(tinyId2, "it.tinyId");
                        String avatarMeta = iGProUserInfo.getAvatarMeta();
                        Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                        arrayList.add(new User(tinyId2, avatarMeta, z17));
                    }
                }
            }
            return arrayList;
        }

        @JvmStatic
        @NotNull
        public final GuildFeedSquareMediaRoomItemData e(@NotNull String guildId, @Nullable IAudioChannelMemberInfos channelMemberInfo) {
            String str;
            int i3;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (channelMemberInfo != null) {
                str = channelMemberInfo.getChannleId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String str2 = str;
            String a16 = a(channelMemberInfo);
            int c16 = c(channelMemberInfo);
            if (channelMemberInfo != null) {
                i3 = channelMemberInfo.getChannelMemberCount();
            } else {
                i3 = 0;
            }
            return new GuildFeedSquareMediaRoomItemData(guildId, str2, a16, c16, i3, d(channelMemberInfo), b(channelMemberInfo));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "avatarMeta", "c", "Z", "()Z", "isMicOpening", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.k$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class User {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tinyId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String avatarMeta;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMicOpening;

        public User(@NotNull String tinyId, @NotNull String avatarMeta, boolean z16) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
            this.tinyId = tinyId;
            this.avatarMeta = avatarMeta;
            this.isMicOpening = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAvatarMeta() {
            return this.avatarMeta;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsMicOpening() {
            return this.isMicOpening;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof User)) {
                return false;
            }
            User user = (User) other;
            if (Intrinsics.areEqual(this.tinyId, user.tinyId) && Intrinsics.areEqual(this.avatarMeta, user.avatarMeta) && this.isMicOpening == user.isMicOpening) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.tinyId.hashCode() * 31) + this.avatarMeta.hashCode()) * 31;
            boolean z16 = this.isMicOpening;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "User(tinyId=" + this.tinyId + ", avatarMeta=" + this.avatarMeta + ", isMicOpening=" + this.isMicOpening + ")";
        }
    }

    public GuildFeedSquareMediaRoomItemData(@NotNull String guildId, @NotNull String channelId, @Nullable String str, int i3, int i16, @NotNull List<User> userList, @NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.coverUrl = str;
        this.themeType = i3;
        this.channelMemberCount = i16;
        this.userList = userList;
        this.sessionId = sessionId;
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedSquareMediaRoomItemData h(@NotNull String str, @Nullable IAudioChannelMemberInfos iAudioChannelMemberInfos) {
        return INSTANCE.e(str, iAudioChannelMemberInfos);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final int getChannelMemberCount() {
        return this.channelMemberCount;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildFeedSquareMediaRoomItemData)) {
            return false;
        }
        GuildFeedSquareMediaRoomItemData guildFeedSquareMediaRoomItemData = (GuildFeedSquareMediaRoomItemData) other;
        if (Intrinsics.areEqual(this.guildId, guildFeedSquareMediaRoomItemData.guildId) && Intrinsics.areEqual(this.channelId, guildFeedSquareMediaRoomItemData.channelId) && Intrinsics.areEqual(this.coverUrl, guildFeedSquareMediaRoomItemData.coverUrl) && this.themeType == guildFeedSquareMediaRoomItemData.themeType && this.channelMemberCount == guildFeedSquareMediaRoomItemData.channelMemberCount && Intrinsics.areEqual(this.userList, guildFeedSquareMediaRoomItemData.userList) && Intrinsics.areEqual(this.sessionId, guildFeedSquareMediaRoomItemData.sessionId)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getThemeType() {
        return this.themeType;
    }

    @NotNull
    public final List<User> g() {
        return this.userList;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31;
        String str = this.coverUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((((hashCode2 + hashCode) * 31) + this.themeType) * 31) + this.channelMemberCount) * 31) + this.userList.hashCode()) * 31) + this.sessionId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedSquareMediaRoomItemData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", coverUrl=" + this.coverUrl + ", themeType=" + this.themeType + ", channelMemberCount=" + this.channelMemberCount + ", userList=" + this.userList + ", sessionId=" + this.sessionId + ")";
    }
}
