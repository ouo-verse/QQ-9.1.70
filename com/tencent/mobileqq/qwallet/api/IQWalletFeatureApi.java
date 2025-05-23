package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated(message = "\u540e\u7eed\u4f7f\u7528IQWalletUnitedConfigApi")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletFeatureApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "init", "", "name", "", "isFeatureSwitch", "default", "Lorg/json/JSONObject;", "getJSONObject", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletFeatureApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277088a;

    @NotNull
    public static final String QWALLET_AD_CONTENT_DISABLE_CLICK = "qwallet_ad_content_disable_click";

    @NotNull
    public static final String QWALLET_AD_DISABLE_AUTOPLAY_CELLULAR = "qwallet_ad_disable_autoplay_cellular";

    @NotNull
    public static final String QWALLET_CGI_REPORT = "qwallet_cgi_report";

    @NotNull
    public static final String QWALLET_COOKIE_JAR_ENABLE = "qwallet_cookie_jar_enable";

    @NotNull
    public static final String QWALLET_CURRENT_NICKNAME = "qwallet_current_nickname";

    @NotNull
    public static final String QWALLET_DISABLE_BUNDLE_CLASSLOADER = "qwallet_disable_bundle_classloader";

    @NotNull
    public static final String QWALLET_DISABLE_CALLBACK_LAUNCH_WECHAT = "qwallet_disable_callback_launch_wechat";

    @NotNull
    public static final String QWALLET_DISABLE_CLOSE_MIDAS_BRIDGE = "qwallet_disable_close_midas_bridge";

    @NotNull
    public static final String QWALLET_DISABLE_LIGHT_SDK_LOAD = "qwallet_disable_light_sdk_load";

    @NotNull
    public static final String QWALLET_DYNAMIC_CFTUTILS_SO = "qwallet_dynamic_cftutils_so";

    @NotNull
    public static final String QWALLET_ECDH_CONFIG = "qwallet_ecdh_config";

    @NotNull
    public static final String QWALLET_FORBID_CUSTOM_TEXT_COMMAND = "qwallet_forbid_custom_text_command";

    @NotNull
    public static final String QWALLET_FORBID_NEW_HB_DETAIL_SKIN = "qwallet_forbid_new_hb_detail_skin";

    @NotNull
    public static final String QWALLET_FORBID_NEW_HOMEPAGE = "qwallet_forbid_new_homepage";

    @NotNull
    public static final String QWALLET_HB_DETAIL_VIDEO_MUST_LOADED = "qwallet_hb_detail_video_must_loaded";

    @NotNull
    public static final String QWALLET_HTTP_LOGIC_ERROR_DIALOG = "qwallet_http_logic_error_dialog";

    @NotNull
    public static final String QWALLET_KEY_BOARD_ACCESSIBLE = "qwallet_key_board_accessible";

    @NotNull
    public static final String QWALLET_NEW_FAKE_URL = "qwallet_new_fake_url";

    @NotNull
    public static final String QWALLET_OPEN_PAY_ACTIVITY_REFERENCE = "qwallet_open_activity_reference";

    @NotNull
    public static final String QWALLET_PAG_ANIM_STRATEGY = "qwallet_pag_anim_strategy";

    @NotNull
    public static final String QWALLET_PUBLIC_ACCOUNT_TAB = "qwallet_public_account_tab";

    @NotNull
    public static final String QWALLET_RED_PACKET_PANEL_CONFIG = "qwallet_red_packet_panel_config";

    @NotNull
    public static final String QWALLET_RELEASE_LOGIC_CONTEXT = "qwallet_release_logic_context";

    @NotNull
    public static final String QWALLET_SP_MIGRATE_CONFIG = "qwallet_sp_migrate_config";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletFeatureApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277088a = new Companion();

        Companion() {
        }
    }

    @Nullable
    JSONObject getJSONObject(@NotNull String name);

    void init();

    boolean isFeatureSwitch(@NotNull String name);

    boolean isFeatureSwitch(@NotNull String name, boolean r26);
}
