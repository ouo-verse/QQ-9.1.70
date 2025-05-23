package com.tencent.mobileqq.qqguildsdk.tianjige;

import com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildCounterNames;", "", "", "counterName", "Ljava/lang/String;", "getCounterName", "()Ljava/lang/String;", "setCounterName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "PIC_DOWNLOAD", "GUILD_JOIN_SUCC_RATE", "GUILD_JUMP_SUCC_RATE", "GUILD_IPC_SUCC_RATE", "NT_DB_OPEN", "NT_SERVICE_CALL", "NT_PUSH_COUNT", "GUILD_LIVE_HTTPDNS_PLAY", "GUILD_LIVE_HTTPDNS_REQUEST", "GUILD_MINI_CONTAINER_WHITE_SCREEN", "GUILD_MINI_CONTAINER_LOAD", "GUILD_URL_JUMP_INFO_DECODE_SUCC_RATE", "MEDIA_GUILD_PULL_WEB_VIEW", "MEDIA_GUILD_GET_AUTH_CODE", "MEDIA_GUILD_WEB_VIEW_FINISH", "MEDIA_GUILD_WEB_RENDER_START", "MEDIA_GUILD_WEB_RENDER_COMPLETE", "MEDIA_GUILD_SHOW_AUTH_PANEL", "MEDIA_GUILD_WEB_USE_OFFLINE", "GUILD_LISTEN", "MORE_BTN_CLICK", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public enum GuildCounterNames {
    PIC_DOWNLOAD("guild_pic_download_total"),
    GUILD_JOIN_SUCC_RATE("gpro_quality_event_join_guild"),
    GUILD_JUMP_SUCC_RATE("gpro_quality_event_url_jump"),
    GUILD_IPC_SUCC_RATE("gpro_quality_event_ipc"),
    NT_DB_OPEN("guild_nt_db_open_total"),
    NT_SERVICE_CALL("guild_nt_service_call_total"),
    NT_PUSH_COUNT("guild_nt_push_count"),
    GUILD_LIVE_HTTPDNS_PLAY("gpro_quality_living_first_frame_httpdns_count"),
    GUILD_LIVE_HTTPDNS_REQUEST("gpro_quality_living_request_httpdns_count"),
    GUILD_MINI_CONTAINER_WHITE_SCREEN(ReportProxy.COUNTER_EVENT_WHITE_SCREEN),
    GUILD_MINI_CONTAINER_LOAD(ReportProxy.COUNTER_EVENT_LOAD),
    GUILD_URL_JUMP_INFO_DECODE_SUCC_RATE("guild_url_jump_info_decode"),
    MEDIA_GUILD_PULL_WEB_VIEW("guild_lobby_pull_up_webview"),
    MEDIA_GUILD_GET_AUTH_CODE("guild_lobby_get_auth_code"),
    MEDIA_GUILD_WEB_VIEW_FINISH("guild_lobby_h5_did_ready"),
    MEDIA_GUILD_WEB_RENDER_START("guild_lobby_h5_start_rendering"),
    MEDIA_GUILD_WEB_RENDER_COMPLETE("guild_lobby_h5_compete_rendering"),
    MEDIA_GUILD_SHOW_AUTH_PANEL("guild_lobby_pull_up_user_auth_panel"),
    MEDIA_GUILD_WEB_USE_OFFLINE("media_guild_web_use_offline"),
    GUILD_LISTEN("guild_listen"),
    MORE_BTN_CLICK("more_btn_click");


    @NotNull
    private String counterName;

    GuildCounterNames(String str) {
        this.counterName = str;
    }

    @NotNull
    public final String getCounterName() {
        return this.counterName;
    }

    public final void setCounterName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.counterName = str;
    }
}
