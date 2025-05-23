package com.tencent.mobileqq.guild.live.livemanager.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LIVE_PROGRAM_READY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "", "str", "", "playerSceneId", "", "id", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getPlayerSceneId", "()I", "getStr", "LIVE", "LIVE_PROGRAM_READY", "GUILD_THIRD_APP_LOADING", "GUILD_DISCOVER_AD_CARD_VIDEO", "GUILD_NEW_USER_SHOW_ANIM", "GUILD_GUIDE_SHOW_ANIM", "DISCOVER_CARD", "DISCOVER_DETAIL_1_CARD", "DISCOVER_DETAIL_2_CARD", "DISCOVER_DETAIL_3_CARD", "DISCOVER_DETAIL_4_CARD", "DISCOVER_DETAIL_5_CARD", "DISCOVER_DETAIL_ERROR", "DISCOVER_SCREEN_SHARE", "TOP_CHANNEL_CARD", "VISITOR_LIVE_CARD", "INTEREST_LABEL_CARD", "Q_CIRCLE_LIVE_ITEM", "MEMBER_LIST", "ONLINE_MEMBER_DIALOG", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildLivePlayerTag {
    public static final GuildLivePlayerTag DISCOVER_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_1_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_2_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_3_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_4_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_5_CARD;
    public static final GuildLivePlayerTag DISCOVER_DETAIL_ERROR;
    public static final GuildLivePlayerTag DISCOVER_SCREEN_SHARE;
    public static final GuildLivePlayerTag GUILD_DISCOVER_AD_CARD_VIDEO;
    public static final GuildLivePlayerTag GUILD_GUIDE_SHOW_ANIM;
    public static final GuildLivePlayerTag GUILD_NEW_USER_SHOW_ANIM;
    public static final GuildLivePlayerTag GUILD_THIRD_APP_LOADING;
    public static final GuildLivePlayerTag INTEREST_LABEL_CARD;
    public static final GuildLivePlayerTag LIVE_PROGRAM_READY;
    public static final GuildLivePlayerTag MEMBER_LIST;
    public static final GuildLivePlayerTag ONLINE_MEMBER_DIALOG;
    public static final GuildLivePlayerTag Q_CIRCLE_LIVE_ITEM;
    public static final GuildLivePlayerTag TOP_CHANNEL_CARD;
    public static final GuildLivePlayerTag VISITOR_LIVE_CARD;

    @NotNull
    private String id;
    private final int playerSceneId;

    @NotNull
    private final String str;
    public static final GuildLivePlayerTag LIVE = new GuildLivePlayerTag("LIVE", 0, "player_tag_live", 125, null, 4, null);
    private static final /* synthetic */ GuildLivePlayerTag[] $VALUES = $values();

    private static final /* synthetic */ GuildLivePlayerTag[] $values() {
        return new GuildLivePlayerTag[]{LIVE, LIVE_PROGRAM_READY, GUILD_THIRD_APP_LOADING, GUILD_DISCOVER_AD_CARD_VIDEO, GUILD_NEW_USER_SHOW_ANIM, GUILD_GUIDE_SHOW_ANIM, DISCOVER_CARD, DISCOVER_DETAIL_1_CARD, DISCOVER_DETAIL_2_CARD, DISCOVER_DETAIL_3_CARD, DISCOVER_DETAIL_4_CARD, DISCOVER_DETAIL_5_CARD, DISCOVER_DETAIL_ERROR, DISCOVER_SCREEN_SHARE, TOP_CHANNEL_CARD, VISITOR_LIVE_CARD, INTEREST_LABEL_CARD, Q_CIRCLE_LIVE_ITEM, MEMBER_LIST, ONLINE_MEMBER_DIALOG};
    }

    static {
        String str = null;
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LIVE_PROGRAM_READY = new GuildLivePlayerTag("LIVE_PROGRAM_READY", 1, "player_tag_live_program_ready", 127, str, i3, defaultConstructorMarker);
        String str2 = null;
        int i16 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        GUILD_THIRD_APP_LOADING = new GuildLivePlayerTag("GUILD_THIRD_APP_LOADING", 2, "player_tag_guild_third_app_loading", 138, str2, i16, defaultConstructorMarker2);
        GUILD_DISCOVER_AD_CARD_VIDEO = new GuildLivePlayerTag("GUILD_DISCOVER_AD_CARD_VIDEO", 3, "player_tag_guild_discover_ad_card_video", 141, str, i3, defaultConstructorMarker);
        GUILD_NEW_USER_SHOW_ANIM = new GuildLivePlayerTag("GUILD_NEW_USER_SHOW_ANIM", 4, "player_tag_guild_new_user_show_anim", 144, str2, i16, defaultConstructorMarker2);
        GUILD_GUIDE_SHOW_ANIM = new GuildLivePlayerTag("GUILD_GUIDE_SHOW_ANIM", 5, "player_tag_guild_guide_show_anim", 145, str, i3, defaultConstructorMarker);
        int i17 = 121;
        DISCOVER_CARD = new GuildLivePlayerTag("DISCOVER_CARD", 6, "player_tag_discover", i17, str2, i16, defaultConstructorMarker2);
        int i18 = 121;
        DISCOVER_DETAIL_1_CARD = new GuildLivePlayerTag("DISCOVER_DETAIL_1_CARD", 7, "player_tag_discover_detail_1", i18, str, i3, defaultConstructorMarker);
        DISCOVER_DETAIL_2_CARD = new GuildLivePlayerTag("DISCOVER_DETAIL_2_CARD", 8, "player_tag_discover_detail_2", i17, str2, i16, defaultConstructorMarker2);
        DISCOVER_DETAIL_3_CARD = new GuildLivePlayerTag("DISCOVER_DETAIL_3_CARD", 9, "player_tag_discover_detail_3", i18, str, i3, defaultConstructorMarker);
        DISCOVER_DETAIL_4_CARD = new GuildLivePlayerTag("DISCOVER_DETAIL_4_CARD", 10, "player_tag_discover_detail_4", i17, str2, i16, defaultConstructorMarker2);
        DISCOVER_DETAIL_5_CARD = new GuildLivePlayerTag("DISCOVER_DETAIL_5_CARD", 11, "player_tag_discover_detail_5", i18, str, i3, defaultConstructorMarker);
        DISCOVER_DETAIL_ERROR = new GuildLivePlayerTag("DISCOVER_DETAIL_ERROR", 12, "player_tag_discover_detail_error", i17, str2, i16, defaultConstructorMarker2);
        DISCOVER_SCREEN_SHARE = new GuildLivePlayerTag("DISCOVER_SCREEN_SHARE", 13, "player_tag_discover_screen_share", i18, str, i3, defaultConstructorMarker);
        TOP_CHANNEL_CARD = new GuildLivePlayerTag("TOP_CHANNEL_CARD", 14, "player_tag_top_channel", 128, str2, i16, defaultConstructorMarker2);
        VISITOR_LIVE_CARD = new GuildLivePlayerTag("VISITOR_LIVE_CARD", 15, "player_tag_visitor_live", 131, str, i3, defaultConstructorMarker);
        INTEREST_LABEL_CARD = new GuildLivePlayerTag("INTEREST_LABEL_CARD", 16, "player_tag_interest_label", 133, str2, i16, defaultConstructorMarker2);
        Q_CIRCLE_LIVE_ITEM = new GuildLivePlayerTag("Q_CIRCLE_LIVE_ITEM", 17, "player_tag_q_circle_live_item", 135, str, i3, defaultConstructorMarker);
        MEMBER_LIST = new GuildLivePlayerTag("MEMBER_LIST", 18, "player_tag_member_list", 142, str2, i16, defaultConstructorMarker2);
        ONLINE_MEMBER_DIALOG = new GuildLivePlayerTag("ONLINE_MEMBER_DIALOG", 19, "player_tag_online_member_dialog", 143, str, i3, defaultConstructorMarker);
    }

    GuildLivePlayerTag(String str, int i3, String str2, int i16, String str3) {
        this.str = str2;
        this.playerSceneId = i16;
        this.id = str3;
    }

    public static GuildLivePlayerTag valueOf(String str) {
        return (GuildLivePlayerTag) Enum.valueOf(GuildLivePlayerTag.class, str);
    }

    public static GuildLivePlayerTag[] values() {
        return (GuildLivePlayerTag[]) $VALUES.clone();
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getPlayerSceneId() {
        return this.playerSceneId;
    }

    @NotNull
    public final String getStr() {
        return this.str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    /* synthetic */ GuildLivePlayerTag(String str, int i3, String str2, int i16, String str3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, i16, (i17 & 4) != 0 ? "" : str3);
    }
}
