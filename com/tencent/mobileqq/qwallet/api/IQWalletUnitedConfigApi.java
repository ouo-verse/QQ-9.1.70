package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H&J)\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletUnitedConfigApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "name", "", "isSwitchOn", "default", "", "T", "getConfig", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getStringConfig", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletUnitedConfigApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277092a;

    @NotNull
    public static final String QWALLET_ACCOUNT_CHANGE_FINISH_SWITCH = "qwallet_account_change_finish_switch";

    @NotNull
    public static final String QWALLET_AMS_EXPOSURE_CHECKER = "qwallet_ams_exposure_checker";

    @NotNull
    public static final String QWALLET_APIGOTOVIEW_CONTEXT = "qwallet_apigotoview_context";

    @NotNull
    public static final String QWALLET_APP_PAY_DISABLE_LAUNCH_WITH_ACTIVITY = "qwallet_app_pay_disable_launch_with_activity";

    @NotNull
    public static final String QWALLET_BIND_BANK_TIP_CONFIG = "qwallet_bind_bank_tip_config";

    @NotNull
    public static final String QWALLET_BUY_GOODS_CALLBACK_WEAK_REF = "qwallet_buy_goods_callback_weak_ref";

    @NotNull
    public static final String QWALLET_C2C_GROUPID_USE_CURRENT_UIN = "qwallet_c2c_groupid_use_current_uin";

    @NotNull
    public static final String QWALLET_CFTSKEY_PSKEY_CONFIG = "qwallet_cftskey_pskey_config";

    @NotNull
    public static final String QWALLET_CGI_ONERROR_DIALOG = "qwallet_cgi_onerror_dialog";

    @NotNull
    public static final String QWALLET_CHILD_REAL_NAME_CONFIG = "qwallet_child_realname_config";

    @NotNull
    public static final String QWALLET_COMMON_CONSTANT = "qwallet_common_constant";

    @NotNull
    public static final String QWALLET_COMMON_POP_WINDOW_CONFIG = "qwallet_common_pop_window_config";

    @NotNull
    public static final String QWALLET_CONFIRM_TRANS_RELOAD = "qwallet_confirm_trans_reload";

    @NotNull
    public static final String QWALLET_COOKIE_JAR_ENABLE = "qwallet_cookie_jar_enable_8968";

    @NotNull
    public static final String QWALLET_DISABLE_MIDAS_RESULT_MONITOR = "qwallet_disable_midas_result_monitor";

    @NotNull
    public static final String QWALLET_ENABLE_COMPOSE_DEFAULT_SKIN_HB_DETAIL = "qwallet_enable_compose_default_skin_hb_detail";

    @NotNull
    public static final String QWALLET_ERROR_FINISH_CGI_LIST = "qwallet_error_finish_cgi_list";

    @NotNull
    public static final String QWALLET_EXCLUSIVE_HB_NEW_SELECTOR = "qwallet_exclusive_hb_new_selector";

    @NotNull
    public static final String QWALLET_F2F_HB_CODE_CONFIG = "qwallet_f2f_hb_code_config";

    @NotNull
    public static final String QWALLET_FILAMENT_CONFIG = "qwallet_filament_config";

    @NotNull
    public static final String QWALLET_FINANCIAL_OAUTH_LOGIN_WEAK_REF = "qwallet_financial_oauth_login_weak_ref";

    @NotNull
    public static final String QWALLET_GATEWAY_SSO_CONFIG = "qwallet_cgi_gateway_sso_config";

    @NotNull
    public static final String QWALLET_HB_COMMON_CONFIG = "qwallet_hb_common_config";

    @NotNull
    public static final String QWALLET_HB_DETAIL_IMAGE_MIDDLE_MODE = "qwallet_hb_detail_image_middle_mode";

    @NotNull
    public static final String QWALLET_HOME_9170_BELT_CONFIG = "qwallet_home_9170_belt_config";

    @NotNull
    public static final String QWALLET_HOME_CAROUSEL_RED_DOT = "qwallet_home_carousel_red_dot";

    @NotNull
    public static final String QWALLET_HOME_CHECK_URL_DIFF = "qwallet_home_check_url_diff";

    @NotNull
    public static final String QWALLET_HOME_COMMON_CONFIG = "qwallet_home_common_config";

    @NotNull
    public static final String QWALLET_HOME_NOT_BLOCK_CLICK = "qwallet_home_block_click";

    @NotNull
    public static final String QWALLET_HOME_PREVIEW_MODE = "qwallet_home_preview_mode";

    @NotNull
    public static final String QWALLET_HOME_PRE_GET_ADV = "qwallet_home_pre_get_adv";

    @NotNull
    public static final String QWALLET_INTERCEPT_APP_CONFIG = "qwallet_intercept_app_config";

    @NotNull
    public static final String QWALLET_LAUNCH_WXMINIAPP_CONFIG = "qwallet_launch_wxminiapp_config";

    @NotNull
    public static final String QWALLET_MAKE_SKIN_ENTRY_SWITCH = "qwallet_make_skin_entry_config";

    @NotNull
    public static final String QWALLET_MSG_COMMON_CONFIG = "qwallet_msg_common_config";

    @NotNull
    public static final String QWALLET_MYUN_PROXY_WHITELIST = "qwallet_myun_proxy_whitelist";

    @NotNull
    public static final String QWALLET_PAY_SUCC_DISABLE_FINANCE_AD = "qwallet_pay_succ_disable_finance_ad";

    @NotNull
    public static final String QWALLET_PB_HANDLE_TRPC_ERROR = "qwallet_pb_handle_trpc_error";

    @NotNull
    public static final String QWALLET_PEEK_RUNTIME_SWITCH = "qwallet_peek_runtime_switch";

    @NotNull
    public static final String QWALLET_PIC_LOADER_ENABLE_CACHE = "qwallet_pic_loader_enable_cache";

    @NotNull
    public static final String QWALLET_PRELOAD_ADDITION_CONFIG = "qwallet_preload_addition_config";

    @NotNull
    public static final String QWALLET_PRIVACY_TIP_CONFIG = "qwallet_privacy_tip_config";

    @NotNull
    public static final String QWALLET_QUICK_BIND_CARD_SWITCH = "qwallet_quick_bind_card_switch";

    @NotNull
    public static final String QWALLET_RECYCLE_HB_VIEW = "qwallet_recycle_hb_view";

    @NotNull
    public static final String QWALLET_REVERT_TO_OLD_PAY_CHANNEL = "qwallet_revert_to_old_pay_channel";

    @NotNull
    public static final String QWALLET_SERVICE_MANAGER_CONFIG = "qwallet_service_manager_config";

    @NotNull
    public static final String QWALLET_SOTER_PREPARE_AUTH = "qwallet_soter_prepare_auth_at_sub_thread";

    @NotNull
    public static final String QWALLET_SOTER_UPDATE_DO_NOT_LAUNCH_SET = "qwallet_soter_update_do_not_launch_set";

    @NotNull
    public static final String QWALLET_SSO_CONFIG = "qwallet_sso_config";

    @NotNull
    public static final String QWALLET_STUDENT_VERIFY_CONFIG = "qwallet_student_verify_config";

    @NotNull
    public static final String QWALLET_TRANSFER_TIP_CONFIG = "qwallet_transfer_tip_config";

    @NotNull
    public static final String QWALLET_WX_OPENPAY_CONFIG = "qwallet_wx_openpay_config";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletUnitedConfigApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277092a = new Companion();

        Companion() {
        }
    }

    @NotNull
    <T> T getConfig(@NotNull String name, @NotNull T r26);

    @NotNull
    String getStringConfig(@NotNull String name, @NotNull String r26);

    boolean isSwitchOn(@NotNull String name);

    boolean isSwitchOn(@NotNull String name, boolean r26);
}
