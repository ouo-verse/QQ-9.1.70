package com.tencent.mobileqq.vas.comm.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H&J)\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/comm/api/IGameCenterUnitedConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "name", "", "isSwitchOn", "default", "", "T", "getConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "getConfigJsonObj", "Lcom/tencent/mobileqq/vas/comm/api/ResCallback;", "callback", "", "loadResConfigJsonObjAsync", "Companion", "a", "qqvas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IGameCenterUnitedConfigApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308928a;

    @NotNull
    public static final String FLOAT_DLG_CONFIG = "101324";

    @NotNull
    public static final String GAMCENTER_MSG_PARTNER_CONFIG = "gamcenter_msg_partner_config";

    @NotNull
    public static final String GAMECENTER_DOWNLOADER_CONF = "gamecenter_downloader_conf";

    @NotNull
    public static final String GAMECENTER_DOWNLOAD_QUERY_ACCELERATE = "gamecenter_download_query_accelerate";

    @NotNull
    public static final String GAMECENTER_SIDEBAR_MY_GAME_CONFIG = "gamecenter_sidebar_my_game_config";

    @NotNull
    public static final String GAMEPLAT_ARKSRC_PRELOAD = "gameplat_arksrc_preload";

    @NotNull
    public static final String GAMEPLAT_BUBBLE_REQUEST_INTERVAL = "gameplat_bubble_request_interval";

    @NotNull
    public static final String GAMEPLAT_CENTER_HIPPY_SWITCH = "gameplat_center_hippy_switch";

    @NotNull
    public static final String GAMEPLAT_DIRECTJUMP_SWITCH = "gameplat_directjump_switch";

    @NotNull
    public static final String GAMEPLAT_DOWNLOADER_NOT_DELETE = "gameplat_downloader_not_delete";

    @NotNull
    public static final String GAMEPLAT_GAME_PUB_HIPPY = "gameplat_game_pub_hippy";

    @NotNull
    public static final String GAMEPLAT_MALL_HIPPY = "gameplat_mall_hippy";

    @NotNull
    public static final String GAMEPLAT_META_DREAM_GAME_TEAMING_SWITCH_CONFIG = "101615";

    @NotNull
    public static final String GAMEPLAT_META_DREAM_INTERACT_MSG_TAB_SWITCH_CONFIG = "101637";

    @NotNull
    public static final String GAMEPLAT_META_DREAM_MSG_GREETING_CONFIG = "101539";

    @NotNull
    public static final String GAMEPLAT_META_DREAM_NOTIFICATION_SWITCH_CONFIG = "101637";

    @NotNull
    public static final String GAMEPLAT_MSG_AIO_CONFIG = "gameplat_msg_aio_config";

    @NotNull
    public static final String GAMEPLAT_MSG_FUNC_SWITCH = "gameplat_msg_func_switch";

    @NotNull
    public static final String GAMEPLAT_MSG_GREETING_CONFIG = "gameplat_msg_greeting_config";

    @NotNull
    public static final String GAMEPLAT_PUB_H5_CONFIG = "gameplat_pub_h5_config";

    @NotNull
    public static final String GAMEPLAT_PUB_SESSION_CONFIG = "gameplat_pub_session_config";

    @NotNull
    public static final String GAMEPLAT_TIANSHU_PUSH_REQ = "gameplat_tianshu_push_req";

    @NotNull
    public static final String GAMEPLAT_WANGZHEPROFILE_JUMP_SWITCH = "gameplat_wangzheprofile_jump_switch";

    @NotNull
    public static final String GAME_CENTER_DISTRIBUTE_BTN_CONFIG = "game_center_distribute_btn_config";

    @NotNull
    public static final String GAME_CENTER_DISTRIBUTE_REMOVE_LISTENER_KUIKLY_SWITCH = "game_center_distribute_remove_listener_kuikly_switch";

    @NotNull
    public static final String GAME_CENTER_GUILD_CHANNEL_PASS_CONFIG = "gamecenter_guild_channel_replace_config";

    @NotNull
    public static final String GAME_CENTER_HONORKING_PARTNER_TEAMING_SWITCH_CONFIG = "102163";

    @NotNull
    public static final String GAME_CENTER_IS_SUPPORT_SPLIT_MODE = "105643";

    @NotNull
    public static final String GAME_CENTER_REPORT_GAME_SHARE_LINK_SWITCH = "gamecenter_report_game_share_link_switch";

    @NotNull
    public static final String GAME_CENTER_TAB_AD_FLOAT_CONFIG = "gamecenter_tab_ad_float_config";

    @NotNull
    public static final String GAME_CENTER_VIDEO_REPORT_CONFIG = "gamecenter_video_report_config";

    @NotNull
    public static final String GAME_CENTER_YUNGAME_AUTO_LOGIN = "gamecenter_yungame_auto_login";

    @NotNull
    public static final String GAME_CENTER_YUNGAME_AUTO_LOGIN_RES = "gamecenter_yungame_auto_login_res";

    @NotNull
    public static final String GAME_ENTER_PAGE = "gamecenter_enter_config";

    @NotNull
    public static final String GAME_INSTALL_CHANNEL_CONFIG = "qqgame_install_channel_config";

    @NotNull
    public static final String GAME_MSG_QUICK_REPLY_CONFIG = "gamemsg_quick_reply_config";

    @NotNull
    public static final String GAME_PUB_ACCOUNT_ENTER_KUIKLY_CONFIG = "gamecenter_pub_account_kuikly_config";

    @NotNull
    public static final String GAME_PUB_ACCOUNT_PRELOAD_KUIKLY_BUNDLE_LIST = "105761";

    @NotNull
    public static final String HIPPP_ANDROID_RES = "hippy_android_res";

    @NotNull
    public static final String HIPPY_ANDROID_PAD = "hippy_android_pad";

    @NotNull
    public static final String HIPPY_DOM_CACHE = "hippy_dom_cache";

    @NotNull
    public static final String HIPPY_URL_INTERCEPT_CONFIG = "hippy_url_intercept_config";

    @NotNull
    public static final String HIPPY_USE_CUSTOM_COOKIE_MANAGER = "103088";

    @NotNull
    public static final String KUIKLY_WEIXIN_AUTH_CODE_CONFIG = "106060";

    @NotNull
    public static final String PROFILE_GAMEINFO_CARD_SETTING_SWITCH = "profile_gameinfo_card_setting_switch";

    @NotNull
    public static final String QQSO_CLEAN_FILE_WHEN_CRC_FAILED = "qqso_clean_file_when_crc_failed";

    @NotNull
    public static final String QQSO_CLEAR_OLD_VERSION_CONFIG = "qqso_clear_old_version_config";

    @NotNull
    public static final String TROOP_UNITED_GAME_CARD_SWITCH = "102899";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/comm/api/IGameCenterUnitedConfigApi$a;", "", "<init>", "()V", "qqvas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308928a = new Companion();

        Companion() {
        }
    }

    @NotNull
    <T> T getConfig(@NotNull String name, @NotNull T r26);

    @NotNull
    JSONObject getConfigJsonObj(@NotNull String name);

    boolean isSwitchOn(@NotNull String name);

    boolean isSwitchOn(@NotNull String name, boolean r26);

    void loadResConfigJsonObjAsync(@NotNull String name, @Nullable ResCallback callback);
}
