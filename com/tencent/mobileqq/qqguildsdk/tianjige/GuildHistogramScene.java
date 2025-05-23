package com.tencent.mobileqq.qqguildsdk.tianjige;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b4\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "GUILD_AIO_OPEN_DURATION", "GUILD_LIVE_PLAY_BLOCK_RATE", "GUILD_CHANGE_TIME_COST", "GUILD_DIRECT_MSG_LIST_TIME_COST", "GUILD_MEMBER_LIST_TIME_COST", "GUILD_PUBLIC_ACCOUNT_INIT_TIME_COST", "GUILD_NOTICE_COST", "GUILD_ASSISTANT_COST", "GUILD_MEMBER_SELECT_TIME_COST", "GUILD_NT_SERVICE_CALL_DURATION", "GUILD_NT_ORM_CALL_DURATION", "GUILD_NT_INIT_DURATION", "GUILD_LOAD_GUILD_LIST_DURATION", "GUILD_MINI_APP_LOAD_DURATION", "GUILD_FACADE_FRAGMENT_ON_CREATE_VIEW_DURATION", "GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST", "GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST", "GUILD_AIO_ENTER_TO_ANIM_TIME_COST", "GUILD_AIO_FIRST_VIEW_TIME_COST", "GUILD_AIO_BIND_COMPONENT_TIME_COST", "GUILD_AIO_BIND_INPUT_TIME_COST", "GUILD_AIO_BIND_TITLE_TIME_COST", "GUILD_AIO_MSG_PRE_PARSE_TIME_COST", "GUILD_START_UP_DIRECTLY_TIME_COST", "GUILD_START_UP_MSG2GUILD_TIME_COST", "GUILD_FEED_ENTER_MY_FEEDS_TIME_COST", "GUILD_FEED_ENTER_FEEDS_SQUARE_TIME_COST", "MEDIA_GUILD_PULL_WEB_VIEW", "MEDIA_GUILD_GET_AUTH_CODE", "MEDIA_GUILD_WEB_VIEW_FINISH", "MEDIA_GUILD_WEB_RENDER_START", "MEDIA_GUILD_WEB_RENDER_COMPLETE", "MEDIA_GUILD_WEB_USE_OFFLINE", "MEDIA_GUILD_SHOW_AUTH_PANEL", "MKD_PARSE_TIME", "MKD_CODE_PARSE_TIME", "MKD_MEASURE_TIME", "MKD_LAYOUT_TIME", "MKD_DRAW_TIME", "MKD_CODE_MEASURE_TIME", "MKD_CODE_DRAW_TIME", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public enum GuildHistogramScene {
    GUILD_AIO_OPEN_DURATION("guild_aio_open_duration"),
    GUILD_LIVE_PLAY_BLOCK_RATE("gpro_quality_time_cost_living_play_block"),
    GUILD_CHANGE_TIME_COST("gpro_quality_time_cost_change_guild"),
    GUILD_DIRECT_MSG_LIST_TIME_COST("gpro_quality_time_cost_direct_msg_list"),
    GUILD_MEMBER_LIST_TIME_COST("gpro_quality_time_cost_channel_member_list"),
    GUILD_PUBLIC_ACCOUNT_INIT_TIME_COST("gpro_quality_time_cost_public_account"),
    GUILD_NOTICE_COST("gpro_quality_time_cost_guild_notice_page"),
    GUILD_ASSISTANT_COST("gpro_quality_time_cost_guild_helper_page"),
    GUILD_MEMBER_SELECT_TIME_COST("gpro_quality_time_cost_member_select"),
    GUILD_NT_SERVICE_CALL_DURATION("guild_nt_service_call_duration"),
    GUILD_NT_ORM_CALL_DURATION("guild_nt_orm_call_duration"),
    GUILD_NT_INIT_DURATION("guild_nt_init_duration"),
    GUILD_LOAD_GUILD_LIST_DURATION("guild_load_guild_list_duration"),
    GUILD_MINI_APP_LOAD_DURATION("guild_mini_app_load_duration"),
    GUILD_FACADE_FRAGMENT_ON_CREATE_VIEW_DURATION("guild_facade_fragment_on_create_view_duration"),
    GUILD_AIO_LOAD_FIRST_PAGE_TIME_COST("gpro_quality_time_cost_aio_load_first_page"),
    GUILD_AIO_LOAD_LATEST_DB_MSG_TIME_COST("gpro_quality_time_cost_aio_load_latest_db_msg"),
    GUILD_AIO_ENTER_TO_ANIM_TIME_COST("gpro_quality_time_cost_aio_enter_to_anim"),
    GUILD_AIO_FIRST_VIEW_TIME_COST("gpro_quality_time_cost_aio_first_view"),
    GUILD_AIO_BIND_COMPONENT_TIME_COST("gpro_quality_time_cost_aio_bind"),
    GUILD_AIO_BIND_INPUT_TIME_COST("gpro_quality_time_cost_aio_input_bind"),
    GUILD_AIO_BIND_TITLE_TIME_COST("gpro_quality_time_cost_aio_title_bind"),
    GUILD_AIO_MSG_PRE_PARSE_TIME_COST("gpro_quality_time_cost_aio_msg_pre_parse"),
    GUILD_START_UP_DIRECTLY_TIME_COST("gpro_quality_time_cost_start_up_directly"),
    GUILD_START_UP_MSG2GUILD_TIME_COST("gpro_quality_time_cost_start_up_msg2guild"),
    GUILD_FEED_ENTER_MY_FEEDS_TIME_COST("gpro_quality_time_cost_feed_enter_my_feeds"),
    GUILD_FEED_ENTER_FEEDS_SQUARE_TIME_COST("gpro_quality_time_cost_feed_enter_feeds_square"),
    MEDIA_GUILD_PULL_WEB_VIEW("guild_lobby_pull_up_webview"),
    MEDIA_GUILD_GET_AUTH_CODE("guild_lobby_get_auth_code"),
    MEDIA_GUILD_WEB_VIEW_FINISH("guild_lobby_h5_did_ready"),
    MEDIA_GUILD_WEB_RENDER_START("guild_lobby_h5_start_rendering"),
    MEDIA_GUILD_WEB_RENDER_COMPLETE("guild_lobby_h5_compete_rendering"),
    MEDIA_GUILD_WEB_USE_OFFLINE("media_guild_web_use_offline"),
    MEDIA_GUILD_SHOW_AUTH_PANEL("guild_lobby_pull_up_user_auth_panel"),
    MKD_PARSE_TIME("mkd_parse_time"),
    MKD_CODE_PARSE_TIME("mkd_code_parse_time"),
    MKD_MEASURE_TIME("mkd_measure_time"),
    MKD_LAYOUT_TIME("mkd_layout_time"),
    MKD_DRAW_TIME("mkd_draw_time"),
    MKD_CODE_MEASURE_TIME("mkd_code_measure_time"),
    MKD_CODE_DRAW_TIME("mkd_code_draw_time");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private String scene;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene$a;", "", "", "value", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "a", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GuildHistogramScene a(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (GuildHistogramScene guildHistogramScene : GuildHistogramScene.values()) {
                if (Intrinsics.areEqual(guildHistogramScene.getScene(), value)) {
                    return guildHistogramScene;
                }
            }
            return null;
        }

        Companion() {
        }
    }

    GuildHistogramScene(String str) {
        this.scene = str;
    }

    @NotNull
    public final String getScene() {
        return this.scene;
    }

    public final void setScene(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }
}
