package com.tencent.mobileqq.msf.core.auth.pb;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* loaded from: classes15.dex */
public final class ThirdPartLogin {
    static IPatchRedirector $redirector_ = null;
    public static final int BUTTON_ACTION_CLOSE = 1;
    public static final int BUTTON_ACTION_JUMP_URL = 2;
    public static final int FORBID_REASON_LEAK_PROTECT = 60;
    public static final int FORBID_REASON_STOLEN_PROTECT = 42;
    public static final int THIRD_LOGIN_APPLE = 4;
    public static final int THIRD_LOGIN_FACEBOOK = 2;
    public static final int THIRD_LOGIN_GOOGLE = 1;
    public static final int THIRD_LOGIN_PHONE = 3;
    public static final int THIRD_LOGIN_WECHAT = 5;
    public static final int TIPS_SENEDES_ID_CHANGE_PASS_WORD = 2;
    public static final int TIPS_SENEDES_ID_COMMON = 5;
    public static final int TIPS_SENEDES_ID_DEFAULT = 0;
    public static final int TIPS_SENEDES_ID_GOTO_PROCESS = 3;
    public static final int TIPS_SENEDES_ID_IM_FORBID = 1;
    public static final int TIPS_SENEDES_ID_LERAN_MOR = 4;
    public static final int VERIFY_SCENES_DEVICE_LOCK_NEED_VEIRYF = 1;
    public static final int VERIFY_SCENES_DOUBLE_CHECK_NEED_VERIFY = 2;
    public static final int VERIFY_SCENES_INPUT_PHONE_LOGIN_NEED_VEIRFY = 4;
    public static final int VERIFY_SCENES_SELF_PHONE_LOGIN_NEED_VEIRFY = 3;
    public static final int VERIFY_SCENES_THIRD_LOGIN_NEED_VEIRFY = 5;
    public static final int VERIFY_SCENES_UNKNOWN = 0;

    /* loaded from: classes15.dex */
    public static final class A1Sig extends MessageMicro<A1Sig> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_a1_sig;
        public final PBBytesField bytes_encrypt_uin;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_encrypt_uin", "bytes_a1_sig"}, new Object[]{byteStringMicro, byteStringMicro}, A1Sig.class);
        }

        public A1Sig() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_encrypt_uin = PBField.initBytes(byteStringMicro);
            this.bytes_a1_sig = PBField.initBytes(byteStringMicro);
        }
    }

    /* loaded from: classes15.dex */
    public static final class Button extends MessageMicro<Button> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_text", "uint32_action", "str_jump_url"}, new Object[]{"", 0, ""}, Button.class);
        public final PBStringField str_text = PBField.initString("");
        public final PBUInt32Field uint32_action = PBField.initUInt32(0);
        public final PBStringField str_jump_url = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class PicVerifyInfo extends MessageMicro<PicVerifyInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_rand_key;
        public final PBBytesField bytes_verify_sig;
        public final PBUInt64Field uint64_appid = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_appid", "bytes_verify_sig", "bytes_rand_key"}, new Object[]{0L, byteStringMicro, byteStringMicro}, PicVerifyInfo.class);
        }

        public PicVerifyInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_verify_sig = PBField.initBytes(byteStringMicro);
            this.bytes_rand_key = PBField.initBytes(byteStringMicro);
        }
    }

    /* loaded from: classes15.dex */
    public static final class RandSalt extends MessageMicro<RandSalt> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_encrypt_uin", "uint64_salt"}, new Object[]{ByteStringMicro.EMPTY, 0L}, RandSalt.class);
        public final PBBytesField bytes_encrypt_uin = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_salt = PBField.initUInt64(0);
    }

    /* loaded from: classes15.dex */
    public static final class ReqBindPhoneLogin extends MessageMicro<ReqBindPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_pic_verify_info"}, new Object[]{null}, ReqBindPhoneLogin.class);
        public PicVerifyInfo msg_pic_verify_info = new PicVerifyInfo();
    }

    /* loaded from: classes15.dex */
    public static final class ReqBody extends MessageMicro<ReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42, 74, 82, 162, 242, 322, 402, 410, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 610, 618, 626}, new String[]{"uint64_seq", "msg_req_client_info", "msg_req_common_info", "msg_req_third_login", "msg_req_self_phone", "msg_req_connect_login", "msg_req_bind_phone_login", "msg_req_mask_qq_login", "msg_req_cmd_4", "msg_req_cmd_9", "msg_req_cmd_17", "msg_req_cmd_18", "msg_req_cmd_23", "msg_req_cmd_24", "msg_req_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ReqBody.class);
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public ReqCommonInfo msg_req_common_info = new ReqCommonInfo();
        public ReqClientInfo msg_req_client_info = new ReqClientInfo();
        public ReqBodyThirdLogin msg_req_third_login = new ReqBodyThirdLogin();
        public ReqBodySelfPhone msg_req_self_phone = new ReqBodySelfPhone();
        public ReqConnectLogin msg_req_connect_login = new ReqConnectLogin();
        public ReqBindPhoneLogin msg_req_bind_phone_login = new ReqBindPhoneLogin();
        public ReqMaskQQLogin msg_req_mask_qq_login = new ReqMaskQQLogin();
        public ReqCmd4 msg_req_cmd_4 = new ReqCmd4();
        public ReqCmd9 msg_req_cmd_9 = new ReqCmd9();
        public ReqCmd17 msg_req_cmd_17 = new ReqCmd17();
        public ReqCmd18 msg_req_cmd_18 = new ReqCmd18();
        public ReqCmd23 msg_req_cmd_23 = new ReqCmd23();
        public ReqCmd24 msg_req_cmd_24 = new ReqCmd24();
        public ReqCmd25 msg_req_cmd_25 = new ReqCmd25();
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodyApple extends MessageMicro<ReqBodyApple> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 242, 250}, new String[]{"str_appid", "str_user_id", "str_identity_token", "str_authorization_code", "str_nick_name", "str_gender"}, new Object[]{"", "", "", "", "", ""}, ReqBodyApple.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_user_id = PBField.initString("");
        public final PBStringField str_identity_token = PBField.initString("");
        public final PBStringField str_authorization_code = PBField.initString("");
        public final PBStringField str_nick_name = PBField.initString("");
        public final PBStringField str_gender = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodyFaceBook extends MessageMicro<ReqBodyFaceBook> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_access_token"}, new Object[]{"", ""}, ReqBodyFaceBook.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_access_token = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodyGoogle extends MessageMicro<ReqBodyGoogle> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_id_token"}, new Object[]{"", ""}, ReqBodyGoogle.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_id_token = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhone extends MessageMicro<ReqBodySelfPhone> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106, 114}, new String[]{"msg_req_check_phone", "msg_req_get_url", "msg_req_check_phone_v4", "msg_req_get_url_v4", "msg_req_phone_login"}, new Object[]{null, null, null, null, null}, ReqBodySelfPhone.class);
        public ReqBodySelfPhoneCheck msg_req_check_phone = new ReqBodySelfPhoneCheck();
        public ReqBodySelfPhoneGetUrl msg_req_get_url = new ReqBodySelfPhoneGetUrl();
        public ReqBodySelfPhoneCheckV4 msg_req_check_phone_v4 = new ReqBodySelfPhoneCheckV4();
        public ReqBodySelfPhoneGetUrlV4 msg_req_get_url_v4 = new ReqBodySelfPhoneGetUrlV4();
        public ReqBodySelfPhoneLogin msg_req_phone_login = new ReqBodySelfPhoneLogin();
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhoneCheck extends MessageMicro<ReqBodySelfPhoneCheck> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 104, 114}, new String[]{"str_upurl", "str_token", "str_msg_id", "int32_channel_id", "str_cell_ip"}, new Object[]{"", "", "", 0, ""}, ReqBodySelfPhoneCheck.class);
        public final PBStringField str_upurl = PBField.initString("");
        public final PBStringField str_token = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
        public final PBStringField str_cell_ip = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhoneCheckV4 extends MessageMicro<ReqBodySelfPhoneCheckV4> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"str_msg_id", "str_cell_ip", "rpt_self_phone_token"}, new Object[]{"", "", null}, ReqBodySelfPhoneCheckV4.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBRepeatMessageField<SelfPhoneToken> rpt_self_phone_token = PBField.initRepeatMessage(SelfPhoneToken.class);
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhoneGetUrl extends MessageMicro<ReqBodySelfPhoneGetUrl> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, ReqBodySelfPhoneGetUrl.class);
        public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhoneGetUrlV4 extends MessageMicro<ReqBodySelfPhoneGetUrlV4> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, ReqBodySelfPhoneGetUrlV4.class);
        public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodySelfPhoneLogin extends MessageMicro<ReqBodySelfPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_phone_token = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField bool_support_auxinfo_check = PBField.initBool(false);
        public final PBBoolField bool_support_unbind_phone = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 96}, new String[]{"bytes_phone_token", "bool_support_auxinfo_check", "bool_support_unbind_phone"}, new Object[]{ByteStringMicro.EMPTY, bool, bool}, ReqBodySelfPhoneLogin.class);
        }
    }

    /* loaded from: classes15.dex */
    public static final class ReqBodyThirdLogin extends MessageMicro<ReqBodyThirdLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uin_account_type", "msg_req_google", "msg_req_facebook", "msg_req_phone", "msg_req_apple", "msg_req_wechat"}, new Object[]{0, 0, null, null, null, null, null}, ReqBodyThirdLogin.class);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
        public final PBUInt32Field uin_account_type = PBField.initUInt32(0);
        public ReqBodyGoogle msg_req_google = new ReqBodyGoogle();
        public ReqBodyFaceBook msg_req_facebook = new ReqBodyFaceBook();
        public ReqPhoneLogin msg_req_phone = new ReqPhoneLogin();
        public ReqBodyApple msg_req_apple = new ReqBodyApple();
        public ReqWechat msg_req_wechat = new ReqWechat();
    }

    /* loaded from: classes15.dex */
    public static final class ReqClientInfo extends MessageMicro<ReqClientInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_client_qua", "uint32_client_platform", "str_qimei36"}, new Object[]{"", 0, ""}, ReqClientInfo.class);
        public final PBStringField str_client_qua = PBField.initString("");
        public final PBUInt32Field uint32_client_platform = PBField.initUInt32(0);
        public final PBStringField str_qimei36 = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd17 extends MessageMicro<ReqCmd17> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 82, 90}, new String[]{"uint32_country_code", "str_mobile_phone", "bool_support_abolish_switch_of_phone_login", "msg_req_phone_sms_extend_login", "msg_req_phone_sms_aux_verify_login"}, new Object[]{0, "", Boolean.FALSE, null, null}, ReqCmd17.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
        public ReqPhoneSmsExtendLogin msg_req_phone_sms_extend_login = new ReqPhoneSmsExtendLogin();
        public ReqPhoneSmsAuxVerifyLogin msg_req_phone_sms_aux_verify_login = new ReqPhoneSmsAuxVerifyLogin();
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd18 extends MessageMicro<ReqCmd18> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_sms_token"}, new Object[]{""}, ReqCmd18.class);
        public final PBStringField str_sms_token = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd23 extends MessageMicro<ReqCmd23> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"bool_support_abolish_switch_of_phone_login", "msg_req_tim_wechat"}, new Object[]{Boolean.FALSE, null}, ReqCmd23.class);
        public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
        public ReqTimWeChat msg_req_tim_wechat = new ReqTimWeChat();
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd24 extends MessageMicro<ReqCmd24> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_mobile_phone", "str_waterprof_wall_sig"}, new Object[]{0, "", ""}, ReqCmd24.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBStringField str_waterprof_wall_sig = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd25 extends MessageMicro<ReqCmd25> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_a1_list"}, new Object[]{null}, ReqCmd25.class);
        public final PBRepeatMessageField<A1Sig> rpt_a1_list = PBField.initRepeatMessage(A1Sig.class);
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd4 extends MessageMicro<ReqCmd4> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_new_device_check_sig", "str_new_device_check_uin_token"}, new Object[]{0, "", ""}, ReqCmd4.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_new_device_check_sig = PBField.initString("");
        public final PBStringField str_new_device_check_uin_token = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqCmd9 extends MessageMicro<ReqCmd9> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqCmd9.class);
    }

    /* loaded from: classes15.dex */
    public static final class ReqCommonInfo extends MessageMicro<ReqCommonInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField bool_req_need_uid_flag = PBField.initBool(false);
        public final PBUInt32Field uint32_req_need_verify_scenes = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_support_self_phone_check = PBField.initUInt32(0);
        public final PBBoolField bool_req_support_diff_passwd_can_verify = PBField.initBool(false);
        public final PBStringField str_verify_sig = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{72, 80, 88, 96, 106}, new String[]{"bool_req_need_uid_flag", "uint32_req_need_verify_scenes", "uint32_req_support_self_phone_check", "bool_req_support_diff_passwd_can_verify", "str_verify_sig"}, new Object[]{bool, 0, 0, bool, ""}, ReqCommonInfo.class);
        }
    }

    /* loaded from: classes15.dex */
    public static final class ReqConnectLogin extends MessageMicro<ReqConnectLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_connect_data"}, new Object[]{""}, ReqConnectLogin.class);
        public final PBStringField str_connect_data = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqMaskQQLogin extends MessageMicro<ReqMaskQQLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_encrypt_uin_info"}, new Object[]{ByteStringMicro.EMPTY}, ReqMaskQQLogin.class);
        public final PBBytesField bytes_encrypt_uin_info = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* loaded from: classes15.dex */
    public static final class ReqPhoneLogin extends MessageMicro<ReqPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_country_code", "str_phone_num"}, new Object[]{"", ""}, ReqPhoneLogin.class);
        public final PBStringField str_country_code = PBField.initString("");
        public final PBStringField str_phone_num = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class ReqPhoneSmsAuxVerifyLogin extends MessageMicro<ReqPhoneSmsAuxVerifyLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88}, new String[]{"bool_req_support_aux_verify"}, new Object[]{Boolean.FALSE}, ReqPhoneSmsAuxVerifyLogin.class);
        public final PBBoolField bool_req_support_aux_verify = PBField.initBool(false);
    }

    /* loaded from: classes15.dex */
    public static final class ReqPhoneSmsExtendLogin extends MessageMicro<ReqPhoneSmsExtendLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_support_flag"}, new Object[]{0}, ReqPhoneSmsExtendLogin.class);
        public final PBUInt32Field uint32_support_flag = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class ReqTimWeChat extends MessageMicro<ReqTimWeChat> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80}, new String[]{"uint32_support_mobile_register"}, new Object[]{0}, ReqTimWeChat.class);
        public final PBUInt32Field uint32_support_mobile_register = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class ReqWechat extends MessageMicro<ReqWechat> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"str_appid", "str_code"}, new Object[]{"", ""}, ReqWechat.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_code = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspBindPhoneLogin extends MessageMicro<RspBindPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBindPhoneLogin.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspBody extends MessageMicro<RspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 74, 82, 162, 242, 322, 402, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 642, 650, 690, 698, 706}, new String[]{"uint64_seq", "msg_rsp_common_info", "msg_rsp_third_login", "msg_rsp_self_phone", "msg_rsp_connect_login", "msg_rsp_bind_phone_login", "msg_rsp_lft_info", "msg_rsp_tips_info", "msg_rsp_cmd_4", "msg_rsp_cmd_9", "msg_rsp_cmd_17", "msg_rsp_cmd_18", "msg_rsp_cmd_23", "msg_rsp_cmd_24", "msg_rsp_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, RspBody.class);
        public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
        public RspCommonInfo msg_rsp_common_info = new RspCommonInfo();
        public RspBodyThirdLogin msg_rsp_third_login = new RspBodyThirdLogin();
        public RspBodySelfPhone msg_rsp_self_phone = new RspBodySelfPhone();
        public RspConnectLogin msg_rsp_connect_login = new RspConnectLogin();
        public RspBindPhoneLogin msg_rsp_bind_phone_login = new RspBindPhoneLogin();
        public RspLftInfo msg_rsp_lft_info = new RspLftInfo();
        public RspTipsInfo msg_rsp_tips_info = new RspTipsInfo();
        public RspCmd4 msg_rsp_cmd_4 = new RspCmd4();
        public RspCmd9 msg_rsp_cmd_9 = new RspCmd9();
        public RspCmd17 msg_rsp_cmd_17 = new RspCmd17();
        public RspCmd18 msg_rsp_cmd_18 = new RspCmd18();
        public RspCmd23 msg_rsp_cmd_23 = new RspCmd23();
        public RspCmd24 msg_rsp_cmd_24 = new RspCmd24();
        public RspCmd25 msg_rsp_cmd_25 = new RspCmd25();
    }

    /* loaded from: classes15.dex */
    public static final class RspBodyApple extends MessageMicro<RspBodyApple> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBodyApple.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspBodyFaceBook extends MessageMicro<RspBodyFaceBook> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, RspBodyFaceBook.class);
        public final PBStringField str_user_profile = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspBodyGoogle extends MessageMicro<RspBodyGoogle> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, RspBodyGoogle.class);
        public final PBStringField str_user_profile = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspBodySelfPhone extends MessageMicro<RspBodySelfPhone> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106}, new String[]{"msg_rsp_check_phone", "msg_rsp_get_url", "msg_rsp_get_url_v4", "msg_rsp_phone_login"}, new Object[]{null, null, null, null}, RspBodySelfPhone.class);
        public RspBodySelfPhoneCheck msg_rsp_check_phone = new RspBodySelfPhoneCheck();
        public RspBodySelfPhoneGetUrl msg_rsp_get_url = new RspBodySelfPhoneGetUrl();
        public RspBodySelfPhoneGetUrlV4 msg_rsp_get_url_v4 = new RspBodySelfPhoneGetUrlV4();
        public RspBodySelfPhoneLogin msg_rsp_phone_login = new RspBodySelfPhoneLogin();
    }

    /* loaded from: classes15.dex */
    public static final class RspBodySelfPhoneCheck extends MessageMicro<RspBodySelfPhoneCheck> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96, 104}, new String[]{"str_upload_redirect_url", "str_msg_id", "int32_channel_id", "int32_channel_carrier_type"}, new Object[]{"", "", 0, 0}, RspBodySelfPhoneCheck.class);
        public final PBStringField str_upload_redirect_url = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
        public final PBInt32Field int32_channel_carrier_type = PBField.initInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class RspBodySelfPhoneGetUrl extends MessageMicro<RspBodySelfPhoneGetUrl> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96}, new String[]{"str_upload_url", "str_msg_id", "int32_channel_id"}, new Object[]{"", "", 0}, RspBodySelfPhoneGetUrl.class);
        public final PBStringField str_upload_url = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class RspBodySelfPhoneGetUrlV4 extends MessageMicro<RspBodySelfPhoneGetUrlV4> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"str_msg_id", "rpt_self_phone_url"}, new Object[]{"", null}, RspBodySelfPhoneGetUrlV4.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBRepeatMessageField<SelfPhoneUrl> rpt_self_phone_url = PBField.initRepeatMessage(SelfPhoneUrl.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspBodySelfPhoneLogin extends MessageMicro<RspBodySelfPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 98, 106, 114}, new String[]{"rpt_bind_uin_info", "int32_phone_bind_result", "str_phone_bind_msg_title", "str_phone_bind_msg_content", "str_unbind_wording"}, new Object[]{null, 0, "", "", ""}, RspBodySelfPhoneLogin.class);
        public final PBRepeatMessageField<UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(UinInfo.class);
        public final PBInt32Field int32_phone_bind_result = PBField.initInt32(0);
        public final PBStringField str_phone_bind_msg_title = PBField.initString("");
        public final PBStringField str_phone_bind_msg_content = PBField.initString("");
        public final PBStringField str_unbind_wording = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspBodyThirdLogin extends MessageMicro<RspBodyThirdLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 96, 106, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uint64_qq_uin", "uint32_register_flag", "str_register_token", "msg_rsp_google", "msg_rsp_facebook", "msg_rsp_phone", "msg_rsp_apple", "msg_rsp_wechat"}, new Object[]{0, 0L, 0, "", null, null, null, null, null}, RspBodyThirdLogin.class);
        public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_register_flag = PBField.initUInt32(0);
        public final PBStringField str_register_token = PBField.initString("");
        public RspBodyGoogle msg_rsp_google = new RspBodyGoogle();
        public RspBodyFaceBook msg_rsp_facebook = new RspBodyFaceBook();
        public RspPhoneLogin msg_rsp_phone = new RspPhoneLogin();
        public RspBodyApple msg_rsp_apple = new RspBodyApple();
        public RspWechat msg_rsp_wechat = new RspWechat();
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd17 extends MessageMicro<RspCmd17> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspCmd17.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd18 extends MessageMicro<RspCmd18> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"msg_rsp_phone_sms_extend_login", "str_sms_token", "msg_rsp_phone_sms_aux_verify_login"}, new Object[]{null, "", null}, RspCmd18.class);
        public RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new RspPhoneSmsExtendLogin();
        public final PBStringField str_sms_token = PBField.initString("");
        public RspPhoneSmsAuxVerifyLogin msg_rsp_phone_sms_aux_verify_login = new RspPhoneSmsAuxVerifyLogin();
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd23 extends MessageMicro<RspCmd23> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_time_wechat"}, new Object[]{null}, RspCmd23.class);
        public RspTimWeChat msg_rsp_time_wechat = new RspTimWeChat();
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd24 extends MessageMicro<RspCmd24> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_salt_list"}, new Object[]{null}, RspCmd24.class);
        public final PBRepeatMessageField<RandSalt> rpt_salt_list = PBField.initRepeatMessage(RandSalt.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd25 extends MessageMicro<RspCmd25> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_bind_uin_info"}, new Object[]{null}, RspCmd25.class);
        public final PBRepeatMessageField<UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(UinInfo.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd4 extends MessageMicro<RspCmd4> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspCmd4.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspCmd9 extends MessageMicro<RspCmd9> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_phone_sms_extend_login"}, new Object[]{null}, RspCmd9.class);
        public RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new RspPhoneSmsExtendLogin();
    }

    /* loaded from: classes15.dex */
    public static final class RspCommonInfo extends MessageMicro<RspCommonInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 96}, new String[]{"uint32_need_verify_scenes", "msg_rsp_nt", "uint32_a1_seq"}, new Object[]{0, null, 0}, RspCommonInfo.class);
        public final PBUInt32Field uint32_need_verify_scenes = PBField.initUInt32(0);
        public RspNT msg_rsp_nt = new RspNT();
        public final PBUInt32Field uint32_a1_seq = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class RspConnectLogin extends MessageMicro<RspConnectLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspConnectLogin.class);
    }

    /* loaded from: classes15.dex */
    public static final class RspLftInfo extends MessageMicro<RspLftInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88}, new String[]{"uint32_lft_forbid_area", "uint32_lft_forbid_reason"}, new Object[]{0, 0}, RspLftInfo.class);
        public final PBUInt32Field uint32_lft_forbid_area = PBField.initUInt32(0);
        public final PBUInt32Field uint32_lft_forbid_reason = PBField.initUInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class RspNT extends MessageMicro<RspNT> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_uid", "bytes_ua2"}, new Object[]{"", ByteStringMicro.EMPTY}, RspNT.class);
        public final PBStringField str_uid = PBField.initString("");
        public final PBBytesField bytes_ua2 = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* loaded from: classes15.dex */
    public static final class RspPhoneLogin extends MessageMicro<RspPhoneLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, RspPhoneLogin.class);
        public final PBStringField str_user_profile = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspPhoneSmsAuxVerifyLogin extends MessageMicro<RspPhoneSmsAuxVerifyLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"bind_login_uin_info", "str_aux_verify_url"}, new Object[]{null, ""}, RspPhoneSmsAuxVerifyLogin.class);
        public UinInfo bind_login_uin_info = new UinInfo();
        public final PBStringField str_aux_verify_url = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspPhoneSmsExtendLogin extends MessageMicro<RspPhoneSmsExtendLogin> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 98, 106, 114}, new String[]{"rpt_bind_uin_info", "int32_phone_bind_result", "str_phone_bind_msg_title", "str_phone_bind_msg_content", "str_unbind_wording"}, new Object[]{null, 0, "", "", ""}, RspPhoneSmsExtendLogin.class);
        public final PBRepeatMessageField<UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(UinInfo.class);
        public final PBInt32Field int32_phone_bind_result = PBField.initInt32(0);
        public final PBStringField str_phone_bind_msg_title = PBField.initString("");
        public final PBStringField str_phone_bind_msg_content = PBField.initString("");
        public final PBStringField str_unbind_wording = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspTimWeChat extends MessageMicro<RspTimWeChat> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_wechat_register_token"}, new Object[]{""}, RspTimWeChat.class);
        public final PBStringField str_wechat_register_token = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspTipsInfo extends MessageMicro<RspTipsInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66}, new String[]{"uint32_scene_id", "str_review_protect_url", "uint32_guid_to_main_login_flag", "str_guid_to_main_login_wording", "msg_left_button", "msg_right_button", "str_title", "str_content"}, new Object[]{0, "", 0, "", null, null, "", ""}, RspTipsInfo.class);
        public final PBUInt32Field uint32_scene_id = PBField.initUInt32(0);
        public final PBStringField str_review_protect_url = PBField.initString("");
        public final PBUInt32Field uint32_guid_to_main_login_flag = PBField.initUInt32(0);
        public final PBStringField str_guid_to_main_login_wording = PBField.initString("");
        public Button msg_left_button = new Button();
        public Button msg_right_button = new Button();
        public final PBStringField str_title = PBField.initString("");
        public final PBStringField str_content = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class RspWechat extends MessageMicro<RspWechat> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_profile"}, new Object[]{""}, RspWechat.class);
        public final PBStringField str_profile = PBField.initString("");
    }

    /* loaded from: classes15.dex */
    public static final class SelfPhoneToken extends MessageMicro<SelfPhoneToken> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_token", "int32_channel_id"}, new Object[]{"", 0}, SelfPhoneToken.class);
        public final PBStringField str_token = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class SelfPhoneUrl extends MessageMicro<SelfPhoneUrl> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88}, new String[]{"str_upload_url", "int32_channel_id"}, new Object[]{"", 0}, SelfPhoneUrl.class);
        public final PBStringField str_upload_url = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    }

    /* loaded from: classes15.dex */
    public static final class UinInfo extends MessageMicro<UinInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_a1_sig;
        public final PBBytesField bytes_encrypt_uin;
        public final PBStringField str_key_uin;
        public final PBStringField str_mask_uin = PBField.initString("");
        public final PBStringField str_nick = PBField.initString("");
        public final PBStringField str_image_url = PBField.initString("");

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"str_mask_uin", "str_nick", "str_image_url", "bytes_encrypt_uin", "str_key_uin", "bytes_a1_sig"}, new Object[]{"", "", "", byteStringMicro, "", byteStringMicro}, UinInfo.class);
        }

        public UinInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_encrypt_uin = PBField.initBytes(byteStringMicro);
            this.str_key_uin = PBField.initString("");
            this.bytes_a1_sig = PBField.initBytes(byteStringMicro);
        }
    }

    ThirdPartLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
