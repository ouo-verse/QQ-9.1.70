package com.tenpay.sdk;

import java.util.List;
import qk2.CgiErrorFinishConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Cgi {
    public static String ACTION_WEBVIEW_CLOSE = "com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE";
    public static String BROADCAST_INTENT_ACTION_EXIT = "com.tenpay.sdk.EXIT";
    public static String BROADCAST_INTENT_ACTION_PAYSUCC = "com.tenpay.sdk.PAYSUCC";
    public static String BROADCAST_INTENT_ACTION_PUSH = "com.tenpay.sdk.PUSH";
    public static int BUSS_DOMAIN_SWITCH_WALLET = 1;
    public static String CTPAY_BANK_TYPE = "3355";
    public static final String DEFAULT_CACHE_ROOT = "sdcard/tencent/QWallet/";
    public static final String DOMAIN_YUN_SERVER = "myun.tenpay.com";
    public static final String ENCRYPT_VERSION = "V01_";
    public static int ENTER_FROM_PAY = 0;
    public static String GrabHB_StateKey = "graphb_state";
    public static String HBList_IsFromKey = "from_HIS";
    public static final int ONE_MINUTE = 59;
    public static final int PASS_ERROR_DURATION = 1000;
    public static String PWD_FIND_ENTRY = "https://myun.tenpay.com/mqq/password/way.html";
    public static int QQGroupType_DiscussionGroup = 2;
    public static int QQGroupType_DiscussionGroupTemp = 4;
    public static int QQGroupType_Group = 1;
    public static int QQGroupType_GroupTemp = 3;
    public static String QRCODE_HB_HOST = "https://mqq.tenpay.com/qrhb?";
    public static String QUERY_CARD_BIN_CONF_URI = "/cgi-bin/clientv1.0/wal_query_cardbin_conf.cgi?";
    public static String RETURN_MSG_JSON_ERROR_KEY = "err_msg";
    public static String RETURN_MSG_KEY = "retmsg";
    public static final String SHA = "F0D6C4CEE093903BFD05D6303A581B97E8442ABD";
    public static final String TENPAY_DOMAIN = "tenpay.com";
    public static String URI_AAPAY_DETAIL = "https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?";
    public static String URI_BALANCE_GET_CODE = "/cgi-bin/clientv1.0/qpay_balance.cgi?";
    public static String URI_BIND_NEW_CARD_WHEN_PAY = "/cgi-bin/clientv1.0/qpay_itg_fpay.cgi?";
    public static String URI_CERT_ACTIVATE = "/cgi-bin/clientv1.0/qpay_cert_activate.cgi?";
    public static String URI_CERT_APPLY = "/cgi-bin/clientv1.0/qpay_cert_apply.cgi?";
    public static String URI_CERT_CONFIRM = "/cgi-bin/clientv1.0/qpay_cert_confirm.cgi?";
    public static String URI_CERT_CONFIRM_QUIET = "/cgi-bin/clientv1.0/qpay_cert_confirm_quiet.cgi?";
    public static String URI_CFT_USER_AUTHEN = "/cgi-bin/clientv1.0/qwallet_itg_authen.cgi?";
    public static String URI_CFT_USER_BIND = "/cgi-bin/clientv1.0/qwallet_itg_verify.cgi?";
    public static String URI_CHANGE_PWD = "/cgi-bin/clientv1.0/modify_password.cgi?";
    public static String URI_CODE_IVR_CONFIRM = "/cgi-bin/clientv1.0/qpay_ivr_confirm.cgi?";
    public static String URI_CODE_PAY_APPLY = "/cgi-bin/scan/code_open.cgi?";
    public static String URI_CODE_PAY_CANCEL = "/cgi-bin/scan/code_close.cgi?";
    public static String URI_CODE_PAY_CODE_CHECK = "/cgi-bin/scan/code_check.cgi?";
    public static String URI_CODE_PAY_CODE_GEN = "/cgi-bin/scan/code_generate.cgi?";
    public static String URI_CODE_PAY_CODE_MARK = "/cgi-bin/scan/code_mark.cgi?";
    public static String URI_CODE_TRANS_GEN = "https://mqq.tenpay.com/cgi-bin/qr_code/qr_code_generate.cgi?";
    public static String URI_CTPAY_AUTHEN = "/cgi-bin/ctpay/qpay_ctpay_authen.cgi?";
    public static String URI_CTPAY_CONTRACT = "https://wepay.tenpay.com/ctpay/contract/version.html";
    public static String URI_CTPAY_GUIDE = "/cgi-bin/ctpay/qpay_ctpay_guide.cgi?";
    public static String URI_CTPAY_HELP = "https://wepay.tenpay.com/ctpay/introduction.html";
    public static String URI_CTPAY_VERIFY = "/cgi-bin/ctpay/qpay_ctpay_verify.cgi?";
    public static String URI_FAST_EXCUTEPAY = "/cgi-bin/clientv1.0/qpay_itg_verify.cgi?";
    public static String URI_FAST_PREPAY = "/cgi-bin/clientv1.0/qpay_ydt.cgi?";
    public static String URI_GET_PASS_TIME = "/cgi-bin/clientv1.0/timeseed?";
    public static String URI_GET_QRCODE_HB = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_qr_list.cgi?";
    public static String URI_HB_Detail_Server = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_na_detail.cgi?";
    public static String URI_HB_GROUP_PACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_group_pack.cgi?";
    public static String URI_HB_HISTORY_DELETE = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_remove.cgi?";
    public static String URI_HB_LIST = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_na_list.cgi?";
    public static String URI_HB_NA_GRAP = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_na_grap.cgi?";
    public static String URI_HB_NA_MCH_GRAP = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_na_mch_grap.cgi?";
    public static String URI_HB_NA_PRE_GRAP = "https://mqq.tenpay.com/cgi-bin/hongbao/hb_pre_grap.cgi?";
    public static String URI_HB_NA_QR_GRAP = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_qr_grab.cgi?";
    public static String URI_HB_NA_QZONE_GRAP = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_zone_grab.cgi?";
    public static String URI_HB_PACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_pack.cgi?";
    public static String URI_HB_PACK_CONFIRM = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_pack_confirm.cgi?";
    public static String URI_HB_PAY_CONFIRM = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_na_payconfirm.cgi?";
    public static String URI_HB_QZONE_CALLBACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_zone_callback.cgi?";
    public static String URI_HB_QZONE_PACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_zone_pack.cgi?";
    public static String URI_HB_QZONE_VISITOR_CALLBACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_zone_visitor_callback.cgi?";
    public static String URI_HB_SHARE = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_share.cgi?";
    public static String URI_MAKE_QRCODE_HB_CALLBACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_qr_callback.cgi?";
    public static String URI_MINORREG_APPLY = "/cgi-bin/clientv1.0/qwallet_minorreg_apply.cgi?";
    public static String URI_MINORREG_CLOSE = "/cgi-bin/clientv1.0/qwallet_minorreg_close.cgi?";
    public static String URI_MINORREG_CONFIRM = "/cgi-bin/clientv1.0/qwallet_minorreg_confirm.cgi?";
    public static String URI_MINORREG_DONE = "/cgi-bin/clientv1.0/qwallet_minorreg_done.cgi?";
    public static String URI_MINORREG_QUERY = "/cgi-bin/clientv1.0/qwallet_minorreg_query.cgi?";
    public static String URI_NONE_CFT_USER_AUTHEN = "/cgi-bin/clientv1.0/qwallet_authen.cgi?";
    public static String URI_NONE_CFT_USER_REGISTER_BIND = "/cgi-bin/clientv1.0/qwallet_regbind.cgi?";
    public static String URI_NONE_CFT_USER_SMSCODE_VALIDATE = "/cgi-bin/clientv1.0/qwallet_verify.cgi?";
    public static String URI_PASS_SDK_AUTH = "/cgi-bin/qwallet_app/qpwd_sdk_auth.cgi?";
    public static String URI_PASS_VERIFY = "/cgi-bin/qwallet_app/qpwd_token_get.cgi?";
    public static String URI_PAYMENT_TRANS_DETAIL = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpayment_trans_detail.cgi?";
    public static String URI_PAY_GATE = "/cgi-bin/clientv1.0/qpay_gate.cgi?";
    public static String URI_PAY_UNIFIED_CONFIG = "/cgi-bin/qwallet_misc/qpay_unified_config.cgi?";
    public static String URI_PHONE_PRE = "/cgi-bin/clientv1.0/bind_mobile_auth.cgi?";
    public static String URI_PHONE_VERIFY = "/cgi-bin/clientv1.0/bind_mobile_verify.cgi?";
    public static String URI_QPAY_HB_WXPACK = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_wxpack.cgi?";
    public static String URI_QQPAY_PROTOCOL = "https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_tenpay_list.shtml?abbr=";
    public static String URI_QQPAY_SUPPORT = "https://www.tenpay.com/v2/html5/basic/public/agreement/coverage.shtml?abbr=";
    public static String URI_QUERY_BANK_CACHE_CONF = "/cgi-bin/clientv1.0/bank_cache_conf.cgi?";
    public static String URI_QUERY_TRANS = "/cgi-bin/scan/code_callback.cgi?";
    public static String URI_QUERY_USER = "/cgi-bin/clientv1.0/qwallet_userinfo.cgi?";
    public static String URI_QUERY_WEIXIN_PARAM = "/cgi-bin/clientv1.0/qpay_get_wxpayparam.cgi?";
    public static String URI_QUERY_WX_PAY_RESULT = "https://mqq.tenpay.com/cgi-bin/hongbao/qpay_hb_wxpack_callback.cgi?";
    public static String URI_QWALLET_CONTRACT = "https://mqq.tenpay.com/mqq/auth/protocol_list.shtml?_wv=1";
    public static String URI_QWALLET_QPAY_REWARD_CALLBACK = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpay_reward_callback.cgi?";
    public static String URI_QWALLET_QPAY_REWARD_ORDER = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpay_reward_na_order.cgi?";
    public static String URI_QWallet_AUTH = "/cgi-bin/clientv1.0/qwallet_name_auth.cgi?";
    public static String URI_QWallet_AUTH_RESET_PASSWD = "/cgi-bin/clientv1.0/qwallet_auth_reset_passwd.cgi?";
    public static String URI_QWallet_CONFIRM_WITHDRAW = "/cgi-bin/clientv1.0/qwallet_confirm_drawing.cgi?";
    public static String URI_QWallet_NAME_AUTH_NOTIFY = "/cgi-bin/clientv1.0/qwallet_nameauth_notify.cgi?";
    public static String URI_QWallet_NEWUSER_DEPOSIT = "/cgi-bin/clientv1.0/qwallet_charge_regbind.cgi?";
    public static String URI_QWallet_RECORD = "https://myun.tenpay.com/v2/hybrid/www/mobile_qq/account/v2/record.shtml?_wv=1027&";
    public static String URI_QWallet_REQUEST_DEPOSIT = "/cgi-bin/clientv1.0/qwallet_charge_authen.cgi?";
    public static String URI_QWallet_REQUEST_TRANSFER = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpayment_transaction.cgi?";
    public static String URI_QWallet_REQUEST_TRANSFER_PUSH = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpayment_qrcode_push.cgi?";
    public static String URI_QWallet_REQUEST_WITHDRAW = "/cgi-bin/clientv1.0/qwallet_request_drawing.cgi?";
    public static String URI_QWallet_VERIFY_DEPOSIT = "/cgi-bin/clientv1.0/qwallet_charge_verify.cgi?";
    public static String URI_QWallet_WITHDRAW_BANK = "/cgi-bin/clientv1.0/qwallet_draw_bank.cgi?";
    public static String URI_QWallet_WITHDRAW_RECORD = "https://myun.tenpay.com/v2/hybrid/www/mobile_qq/account/withdraw/record.shtml?_wv=1027&";
    public static String URI_REGISTER_BIND_NEW_CARD_WHEN_PAY = "/cgi-bin/clientv1.0/qpay_fauth.cgi?";
    public static String URI_REGISTER_PAY_BIND = "/cgi-bin/clientv1.0/qpay_fpay_regbind.cgi?";
    public static String URI_REGISTER_YZ_MESSAGE = "/cgi-bin/clientv1.0/qpay_verify.cgi?";
    public static String URI_RESET_PASS = "/cgi-bin/clientv1.0/reset_password.cgi?";
    public static String URI_RESET_PWD = "/cgi-bin/clientv1.0/qwallet_appeal_reset_pwd.cgi?";
    public static String URI_Soter_FINGER_PAY_CHECK = "/cgi-bin/soter/qpay_soter_check.cgi?";
    public static String URI_Soter_FINGER_PAY_CLOSE = "/cgi-bin/soter/qpay_soter_close.cgi?";
    public static String URI_Soter_FINGER_PAY_OPEN = "/cgi-bin/soter/qpay_soter_open.cgi?";
    public static String URI_Soter_FINGER_PAY_PRE_OPEN = "/cgi-bin/soter/qpay_soter_pre_open.cgi?";
    public static String URI_TRANSFER_PAY_CONFIRM = "https://mqq.tenpay.com/cgi-bin/qwallet_app/qpayment_na_payconfirm.cgi?";
    public static String URI_UINCONFIG_PULLCONFIG = "https://mqq.tenpay.com/cgi-bin/qpay_config/qpay_config_download.cgi?ver=2.0";
    public static String URI_UNBIND_BANKCARD = "/cgi-bin/clientv1.0/qwallet_delbind.cgi?";
    public static String URI_VALIDATE_PAY_PASS = "/cgi-bin/clientv1.0/qpay_p_verify.cgi?";
    public static String URI_VERIFY_QRCODE = "https://mqq.tenpay.com/cgi-bin/qr_code/qr_code_verify.cgi?";
    public static String URI_WALLET_AD_PULL = "/cgi-bin/qwallet_misc/qwallet_ad_pull.cgi?";
    public static String URI_WALLET_MIDAS = "/cgi-bin/clientv1.0/qwallet_midas.cgi?";
    public static String URI_YDTBANK_QUERY = "/cgi-bin/clientv1.0/wal_bank_query.cgi?pay_type=YDT|FASTPAY&";
    public static String URL_FRIENDPAY_ORDER_QUERY = "/cgi-bin/clientv1.0/qpay_pfa_order_query.cgi?";
    public static String URL_FRIENDPAY_VERIFY = "/cgi-bin/clientv1.0/qpay_pfa_multi_apply.cgi?";
    public static String URL_FRIEND_QPAY_SPFA_PAY = "/cgi-bin/clientv1.0/qpay_spfa_pay.cgi?";
    public static String URL_GET_IMG = "/images/client/android/";
    public static String URL_MQQ_PRECONNECT = "https://mqq.tenpay.com/cgi-bin/misc/mqq_pre_link.cgi";
    public static String URL_MYUN_PRECONNECT = "https://myun.tenpay.com/cgi-bin/misc/myun_pre_link.cgi";
    public static String URL_SHIMING_CHECK_MSG = "/cgi-bin/clientv1.0/check_custodian_sms.cgi?";
    public static String URL_SHIMING_SEND_MSG = "/cgi-bin/clientv1.0/send_custodian_sms.cgi?";
    public static String URL_WALLET_GATE = "/cgi-bin/clientv1.0/qwallet.cgi?";
    public static String domain_name = null;
    public static int scene_FingerPay = 1;
    public static boolean userInfoExtendEnc = true;
    public static String wallet_domain;
    public static StringBuffer host_ip = new StringBuffer();
    public static List<String> errorFinishList = CgiErrorFinishConfig.e();
    public static List<String> errorAfterToastFinishList = CgiErrorFinishConfig.f();
}
