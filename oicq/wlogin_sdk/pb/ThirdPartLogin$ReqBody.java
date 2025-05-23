package oicq.wlogin_sdk.pb;

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
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqBody extends MessageMicro<ThirdPartLogin$ReqBody> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42, 74, 82, 162, 242, 322, 402, 410, 482, PlayerResources.ViewId.GET_MORE_JUMP_AREA, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, 610, 618, 626}, new String[]{"uint64_seq", "msg_req_client_info", "msg_req_common_info", "msg_req_third_login", "msg_req_self_phone", "msg_req_connect_login", "msg_req_bind_phone_login", "msg_req_mask_qq_login", "msg_req_cmd_4", "msg_req_cmd_9", "msg_req_cmd_17", "msg_req_cmd_18", "msg_req_cmd_23", "msg_req_cmd_24", "msg_req_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ThirdPartLogin$ReqBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public ThirdPartLogin$ReqCommonInfo msg_req_common_info = new ThirdPartLogin$ReqCommonInfo();
    public ThirdPartLogin$ReqClientInfo msg_req_client_info = new MessageMicro<ThirdPartLogin$ReqClientInfo>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqClientInfo
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_client_qua", "uint32_client_platform", "str_qimei36"}, new Object[]{"", 0, ""}, ThirdPartLogin$ReqClientInfo.class);
        public final PBStringField str_client_qua = PBField.initString("");
        public final PBUInt32Field uint32_client_platform = PBField.initUInt32(0);
        public final PBStringField str_qimei36 = PBField.initString("");
    };
    public ThirdPartLogin$ReqBodyThirdLogin msg_req_third_login = new ThirdPartLogin$ReqBodyThirdLogin();
    public ThirdPartLogin$ReqBodySelfPhone msg_req_self_phone = new MessageMicro<ThirdPartLogin$ReqBodySelfPhone>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhone
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106, 114}, new String[]{"msg_req_check_phone", "msg_req_get_url", "msg_req_check_phone_v4", "msg_req_get_url_v4", "msg_req_phone_login"}, new Object[]{null, null, null, null, null}, ThirdPartLogin$ReqBodySelfPhone.class);
        public ThirdPartLogin$ReqBodySelfPhoneCheck msg_req_check_phone = new MessageMicro<ThirdPartLogin$ReqBodySelfPhoneCheck>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhoneCheck
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 104, 114}, new String[]{"str_upurl", "str_token", "str_msg_id", "int32_channel_id", "str_cell_ip"}, new Object[]{"", "", "", 0, ""}, ThirdPartLogin$ReqBodySelfPhoneCheck.class);
            public final PBStringField str_upurl = PBField.initString("");
            public final PBStringField str_token = PBField.initString("");
            public final PBStringField str_msg_id = PBField.initString("");
            public final PBInt32Field int32_channel_id = PBField.initInt32(0);
            public final PBStringField str_cell_ip = PBField.initString("");
        };
        public ThirdPartLogin$ReqBodySelfPhoneGetUrl msg_req_get_url = new MessageMicro<ThirdPartLogin$ReqBodySelfPhoneGetUrl>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhoneGetUrl
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, ThirdPartLogin$ReqBodySelfPhoneGetUrl.class);
            public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
            public final PBStringField str_mobile_phone = PBField.initString("");
            public final PBStringField str_cell_ip = PBField.initString("");
            public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
        };
        public ThirdPartLogin$ReqBodySelfPhoneCheckV4 msg_req_check_phone_v4 = new MessageMicro<ThirdPartLogin$ReqBodySelfPhoneCheckV4>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhoneCheckV4
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"str_msg_id", "str_cell_ip", "rpt_self_phone_token"}, new Object[]{"", "", null}, ThirdPartLogin$ReqBodySelfPhoneCheckV4.class);
            public final PBStringField str_msg_id = PBField.initString("");
            public final PBStringField str_cell_ip = PBField.initString("");
            public final PBRepeatMessageField<ThirdPartLogin$SelfPhoneToken> rpt_self_phone_token = PBField.initRepeatMessage(ThirdPartLogin$SelfPhoneToken.class);
        };
        public ThirdPartLogin$ReqBodySelfPhoneGetUrlV4 msg_req_get_url_v4 = new MessageMicro<ThirdPartLogin$ReqBodySelfPhoneGetUrlV4>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhoneGetUrlV4
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, ThirdPartLogin$ReqBodySelfPhoneGetUrlV4.class);
            public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
            public final PBStringField str_mobile_phone = PBField.initString("");
            public final PBStringField str_cell_ip = PBField.initString("");
            public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
        };
        public ThirdPartLogin$ReqBodySelfPhoneLogin msg_req_phone_login = new MessageMicro<ThirdPartLogin$ReqBodySelfPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodySelfPhoneLogin
            public static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_phone_token = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBBoolField bool_support_auxinfo_check = PBField.initBool(false);
            public final PBBoolField bool_support_unbind_phone = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 96}, new String[]{"bytes_phone_token", "bool_support_auxinfo_check", "bool_support_unbind_phone"}, new Object[]{ByteStringMicro.EMPTY, bool, bool}, ThirdPartLogin$ReqBodySelfPhoneLogin.class);
            }
        };
    };
    public ThirdPartLogin$ReqConnectLogin msg_req_connect_login = new MessageMicro<ThirdPartLogin$ReqConnectLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqConnectLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_connect_data"}, new Object[]{""}, ThirdPartLogin$ReqConnectLogin.class);
        public final PBStringField str_connect_data = PBField.initString("");
    };
    public ThirdPartLogin$ReqBindPhoneLogin msg_req_bind_phone_login = new MessageMicro<ThirdPartLogin$ReqBindPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBindPhoneLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_pic_verify_info"}, new Object[]{null}, ThirdPartLogin$ReqBindPhoneLogin.class);
        public ThirdPartLogin$PicVerifyInfo msg_pic_verify_info = new MessageMicro<ThirdPartLogin$PicVerifyInfo>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$PicVerifyInfo
            public static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField bytes_rand_key;
            public final PBBytesField bytes_verify_sig;
            public final PBUInt64Field uint64_appid = PBField.initUInt64(0);

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_appid", "bytes_verify_sig", "bytes_rand_key"}, new Object[]{0L, byteStringMicro, byteStringMicro}, ThirdPartLogin$PicVerifyInfo.class);
            }

            {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.bytes_verify_sig = PBField.initBytes(byteStringMicro);
                this.bytes_rand_key = PBField.initBytes(byteStringMicro);
            }
        };
    };
    public ThirdPartLogin$ReqMaskQQLogin msg_req_mask_qq_login = new ThirdPartLogin$ReqMaskQQLogin();
    public ThirdPartLogin$ReqCmd4 msg_req_cmd_4 = new MessageMicro<ThirdPartLogin$ReqCmd4>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd4
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_new_device_check_sig", "str_new_device_check_uin_token"}, new Object[]{0, "", ""}, ThirdPartLogin$ReqCmd4.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_new_device_check_sig = PBField.initString("");
        public final PBStringField str_new_device_check_uin_token = PBField.initString("");
    };
    public ThirdPartLogin$ReqCmd9 msg_req_cmd_9 = new MessageMicro<ThirdPartLogin$ReqCmd9>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd9
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$ReqCmd9.class);
    };
    public ThirdPartLogin$ReqCmd17 msg_req_cmd_17 = new MessageMicro<ThirdPartLogin$ReqCmd17>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd17
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 82, 90}, new String[]{"uint32_country_code", "str_mobile_phone", "bool_support_abolish_switch_of_phone_login", "msg_req_phone_sms_extend_login", "msg_req_phone_sms_aux_verify_login"}, new Object[]{0, "", Boolean.FALSE, null, null}, ThirdPartLogin$ReqCmd17.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
        public ThirdPartLogin$ReqPhoneSmsExtendLogin msg_req_phone_sms_extend_login = new MessageMicro<ThirdPartLogin$ReqPhoneSmsExtendLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqPhoneSmsExtendLogin
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_support_flag"}, new Object[]{0}, ThirdPartLogin$ReqPhoneSmsExtendLogin.class);
            public final PBUInt32Field uint32_support_flag = PBField.initUInt32(0);
        };
        public ThirdPartLogin$ReqPhoneSmsAuxVerifyLogin msg_req_phone_sms_aux_verify_login = new MessageMicro<ThirdPartLogin$ReqPhoneSmsAuxVerifyLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqPhoneSmsAuxVerifyLogin
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88}, new String[]{"bool_req_support_aux_verify"}, new Object[]{Boolean.FALSE}, ThirdPartLogin$ReqPhoneSmsAuxVerifyLogin.class);
            public final PBBoolField bool_req_support_aux_verify = PBField.initBool(false);
        };
    };
    public ThirdPartLogin$ReqCmd18 msg_req_cmd_18 = new MessageMicro<ThirdPartLogin$ReqCmd18>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd18
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_sms_token"}, new Object[]{""}, ThirdPartLogin$ReqCmd18.class);
        public final PBStringField str_sms_token = PBField.initString("");
    };
    public ThirdPartLogin$ReqCmd23 msg_req_cmd_23 = new MessageMicro<ThirdPartLogin$ReqCmd23>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd23
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"bool_support_abolish_switch_of_phone_login", "msg_req_tim_wechat"}, new Object[]{Boolean.FALSE, null}, ThirdPartLogin$ReqCmd23.class);
        public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
        public ThirdPartLogin$ReqTimWeChat msg_req_tim_wechat = new MessageMicro<ThirdPartLogin$ReqTimWeChat>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqTimWeChat
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80}, new String[]{"uint32_support_mobile_register"}, new Object[]{0}, ThirdPartLogin$ReqTimWeChat.class);
            public final PBUInt32Field uint32_support_mobile_register = PBField.initUInt32(0);
        };
    };
    public ThirdPartLogin$ReqCmd24 msg_req_cmd_24 = new MessageMicro<ThirdPartLogin$ReqCmd24>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqCmd24
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_country_code", "str_mobile_phone", "waterprof_wall_info"}, new Object[]{0, "", null}, ThirdPartLogin$ReqCmd24.class);
        public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public ThirdPartLogin$WaterprofWallInfo waterprof_wall_info = new MessageMicro<ThirdPartLogin$WaterprofWallInfo>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$WaterprofWallInfo
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"str_waterprof_wall_sig", "iframe_randstr", "iframe_sid"}, new Object[]{"", "", ""}, ThirdPartLogin$WaterprofWallInfo.class);
            public final PBStringField str_waterprof_wall_sig = PBField.initString("");
            public final PBStringField iframe_randstr = PBField.initString("");
            public final PBStringField iframe_sid = PBField.initString("");
        };
    };
    public ThirdPartLogin$ReqCmd25 msg_req_cmd_25 = new ThirdPartLogin$ReqCmd25();
}
