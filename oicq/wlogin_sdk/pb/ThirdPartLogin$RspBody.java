package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspBody extends MessageMicro<ThirdPartLogin$RspBody> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 74, 82, 162, 242, 322, 402, 482, P2VGlobalConfig.WATER_MARKER_WIDTH, PlayerResources.ViewId.GET_MORE_JUMP_AREA, 642, 650, 690, 698, 706}, new String[]{"uint64_seq", "msg_rsp_common_info", "msg_rsp_third_login", "msg_rsp_self_phone", "msg_rsp_connect_login", "msg_rsp_bind_phone_login", "msg_rsp_lft_info", "msg_rsp_tips_info", "msg_rsp_cmd_4", "msg_rsp_cmd_9", "msg_rsp_cmd_17", "msg_rsp_cmd_18", "msg_rsp_cmd_23", "msg_rsp_cmd_24", "msg_rsp_cmd_25"}, new Object[]{0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ThirdPartLogin$RspBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public ThirdPartLogin$RspCommonInfo msg_rsp_common_info = new ThirdPartLogin$RspCommonInfo();
    public ThirdPartLogin$RspBodyThirdLogin msg_rsp_third_login = new ThirdPartLogin$RspBodyThirdLogin();
    public ThirdPartLogin$RspBodySelfPhone msg_rsp_self_phone = new MessageMicro<ThirdPartLogin$RspBodySelfPhone>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodySelfPhone
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106}, new String[]{"msg_rsp_check_phone", "msg_rsp_get_url", "msg_rsp_get_url_v4", "msg_rsp_phone_login"}, new Object[]{null, null, null, null}, ThirdPartLogin$RspBodySelfPhone.class);
        public ThirdPartLogin$RspBodySelfPhoneCheck msg_rsp_check_phone = new MessageMicro<ThirdPartLogin$RspBodySelfPhoneCheck>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodySelfPhoneCheck
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96, 104}, new String[]{"str_upload_redirect_url", "str_msg_id", "int32_channel_id", "int32_channel_carrier_type"}, new Object[]{"", "", 0, 0}, ThirdPartLogin$RspBodySelfPhoneCheck.class);
            public final PBStringField str_upload_redirect_url = PBField.initString("");
            public final PBStringField str_msg_id = PBField.initString("");
            public final PBInt32Field int32_channel_id = PBField.initInt32(0);
            public final PBInt32Field int32_channel_carrier_type = PBField.initInt32(0);
        };
        public ThirdPartLogin$RspBodySelfPhoneGetUrl msg_rsp_get_url = new MessageMicro<ThirdPartLogin$RspBodySelfPhoneGetUrl>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodySelfPhoneGetUrl
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96}, new String[]{"str_upload_url", "str_msg_id", "int32_channel_id"}, new Object[]{"", "", 0}, ThirdPartLogin$RspBodySelfPhoneGetUrl.class);
            public final PBStringField str_upload_url = PBField.initString("");
            public final PBStringField str_msg_id = PBField.initString("");
            public final PBInt32Field int32_channel_id = PBField.initInt32(0);
        };
        public ThirdPartLogin$RspBodySelfPhoneGetUrlV4 msg_rsp_get_url_v4 = new MessageMicro<ThirdPartLogin$RspBodySelfPhoneGetUrlV4>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodySelfPhoneGetUrlV4
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"str_msg_id", "rpt_self_phone_url"}, new Object[]{"", null}, ThirdPartLogin$RspBodySelfPhoneGetUrlV4.class);
            public final PBStringField str_msg_id = PBField.initString("");
            public final PBRepeatMessageField<ThirdPartLogin$SelfPhoneUrl> rpt_self_phone_url = PBField.initRepeatMessage(ThirdPartLogin$SelfPhoneUrl.class);
        };
        public ThirdPartLogin$RspBodySelfPhoneLogin msg_rsp_phone_login = new MessageMicro<ThirdPartLogin$RspBodySelfPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodySelfPhoneLogin
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 98, 106, 114}, new String[]{"rpt_bind_uin_info", "int32_phone_bind_result", "str_phone_bind_msg_title", "str_phone_bind_msg_content", "str_unbind_wording"}, new Object[]{null, 0, "", "", ""}, ThirdPartLogin$RspBodySelfPhoneLogin.class);
            public final PBRepeatMessageField<ThirdPartLogin$UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(ThirdPartLogin$UinInfo.class);
            public final PBInt32Field int32_phone_bind_result = PBField.initInt32(0);
            public final PBStringField str_phone_bind_msg_title = PBField.initString("");
            public final PBStringField str_phone_bind_msg_content = PBField.initString("");
            public final PBStringField str_unbind_wording = PBField.initString("");
        };
    };
    public ThirdPartLogin$RspConnectLogin msg_rsp_connect_login = new MessageMicro<ThirdPartLogin$RspConnectLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspConnectLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$RspConnectLogin.class);
    };
    public ThirdPartLogin$RspBindPhoneLogin msg_rsp_bind_phone_login = new MessageMicro<ThirdPartLogin$RspBindPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBindPhoneLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$RspBindPhoneLogin.class);
    };
    public ThirdPartLogin$RspLftInfo msg_rsp_lft_info = new MessageMicro<ThirdPartLogin$RspLftInfo>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspLftInfo
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88}, new String[]{"uint32_lft_forbid_area", "uint32_lft_forbid_reason"}, new Object[]{0, 0}, ThirdPartLogin$RspLftInfo.class);
        public final PBUInt32Field uint32_lft_forbid_area = PBField.initUInt32(0);
        public final PBUInt32Field uint32_lft_forbid_reason = PBField.initUInt32(0);
    };
    public ThirdPartLogin$RspTipsInfo msg_rsp_tips_info = new MessageMicro<ThirdPartLogin$RspTipsInfo>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspTipsInfo
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 74}, new String[]{"uint32_scene_id", "str_review_protect_url", "uint32_guid_to_main_login_flag", "str_guid_to_main_login_wording", "msg_left_button", "msg_right_button", "str_title", "str_content", "msg_buttons"}, new Object[]{0, "", 0, "", null, null, "", "", null}, ThirdPartLogin$RspTipsInfo.class);
        public final PBUInt32Field uint32_scene_id = PBField.initUInt32(0);
        public final PBStringField str_review_protect_url = PBField.initString("");
        public final PBUInt32Field uint32_guid_to_main_login_flag = PBField.initUInt32(0);
        public final PBStringField str_guid_to_main_login_wording = PBField.initString("");
        public ThirdPartLogin$Button msg_left_button = new MessageMicro<ThirdPartLogin$Button>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$Button
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_text", "uint32_action", "str_jump_url"}, new Object[]{"", 0, ""}, ThirdPartLogin$Button.class);
            public final PBStringField str_text = PBField.initString("");
            public final PBUInt32Field uint32_action = PBField.initUInt32(0);
            public final PBStringField str_jump_url = PBField.initString("");
        };
        public ThirdPartLogin$Button msg_right_button = new MessageMicro<ThirdPartLogin$Button>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$Button
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_text", "uint32_action", "str_jump_url"}, new Object[]{"", 0, ""}, ThirdPartLogin$Button.class);
            public final PBStringField str_text = PBField.initString("");
            public final PBUInt32Field uint32_action = PBField.initUInt32(0);
            public final PBStringField str_jump_url = PBField.initString("");
        };
        public final PBStringField str_title = PBField.initString("");
        public final PBStringField str_content = PBField.initString("");
        public final PBRepeatMessageField<ThirdPartLogin$Button> msg_buttons = PBField.initRepeatMessage(ThirdPartLogin$Button.class);
    };
    public ThirdPartLogin$RspCmd4 msg_rsp_cmd_4 = new MessageMicro<ThirdPartLogin$RspCmd4>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspCmd4
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$RspCmd4.class);
    };
    public ThirdPartLogin$RspCmd9 msg_rsp_cmd_9 = new MessageMicro<ThirdPartLogin$RspCmd9>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspCmd9
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_phone_sms_extend_login"}, new Object[]{null}, ThirdPartLogin$RspCmd9.class);
        public ThirdPartLogin$RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new ThirdPartLogin$RspPhoneSmsExtendLogin();
    };
    public ThirdPartLogin$RspCmd17 msg_rsp_cmd_17 = new MessageMicro<ThirdPartLogin$RspCmd17>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspCmd17
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$RspCmd17.class);
    };
    public ThirdPartLogin$RspCmd18 msg_rsp_cmd_18 = new MessageMicro<ThirdPartLogin$RspCmd18>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspCmd18
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"msg_rsp_phone_sms_extend_login", "str_sms_token", "msg_rsp_phone_sms_aux_verify_login"}, new Object[]{null, "", null}, ThirdPartLogin$RspCmd18.class);
        public ThirdPartLogin$RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new ThirdPartLogin$RspPhoneSmsExtendLogin();
        public final PBStringField str_sms_token = PBField.initString("");
        public ThirdPartLogin$RspPhoneSmsAuxVerifyLogin msg_rsp_phone_sms_aux_verify_login = new MessageMicro<ThirdPartLogin$RspPhoneSmsAuxVerifyLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspPhoneSmsAuxVerifyLogin
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"bind_login_uin_info", "str_aux_verify_url"}, new Object[]{null, ""}, ThirdPartLogin$RspPhoneSmsAuxVerifyLogin.class);
            public ThirdPartLogin$UinInfo bind_login_uin_info = new ThirdPartLogin$UinInfo();
            public final PBStringField str_aux_verify_url = PBField.initString("");
        };
    };
    public ThirdPartLogin$RspCmd23 msg_rsp_cmd_23 = new MessageMicro<ThirdPartLogin$RspCmd23>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspCmd23
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"msg_rsp_time_wechat"}, new Object[]{null}, ThirdPartLogin$RspCmd23.class);
        public ThirdPartLogin$RspTimWeChat msg_rsp_time_wechat = new MessageMicro<ThirdPartLogin$RspTimWeChat>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspTimWeChat
            public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_wechat_register_token"}, new Object[]{""}, ThirdPartLogin$RspTimWeChat.class);
            public final PBStringField str_wechat_register_token = PBField.initString("");
        };
    };
    public ThirdPartLogin$RspCmd24 msg_rsp_cmd_24 = new ThirdPartLogin$RspCmd24();
    public ThirdPartLogin$RspCmd25 msg_rsp_cmd_25 = new ThirdPartLogin$RspCmd25();
}
