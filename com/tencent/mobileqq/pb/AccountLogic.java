package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class AccountLogic {
    public static final int ACCOUNT_TYPE_UNKNOW = 0;
    public static final int ACCOUNT_TYPE_WX = 1;
    public static final int BINDING_STATE_BIND = 2;
    public static final int BINDING_STATE_UNBIND = 1;
    public static final int BINDING_STATE_UNKNOW = 0;
    public static final int BIND_RESULT_EXIST_BIND = 1;
    public static final int BIND_RESULT_NEED_SECURE_CHECK = 2;
    public static final int BIND_RESULT_SUCCESS = 3;
    public static final int BIND_RESULT_UNKNOW = 0;
    public static final int OPERATION_TYPE_UNKNOW = 0;
    public static final int OPERATION_TYPE_WX_BIND = 1;
    public static final int OPERATION_TYPE_WX_UNBIND = 2;
    public static final int SIG_TYPE_APPEAL = 3;
    public static final int SIG_TYPE_FACE = 1;
    public static final int SIG_TYPE_SMS = 2;
    public static final int SIG_TYPE_UNKNOW = 0;
    public static final int UNBIND_RESULT_NEED_SECURE_CHECK = 2;
    public static final int UNBIND_RESULT_NEED_SEC_CHECK = 3;
    public static final int UNBIND_RESULT_NO_BIND = 1;
    public static final int UNBIND_RESULT_SUCCESS = 4;
    public static final int UNBIND_RESULT_UNKNOW = 0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class AppealInfo extends MessageMicro<AppealInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"appid", "receipt", "phone"}, new Object[]{0, 0, ""}, AppealInfo.class);
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBUInt32Field receipt = PBField.initUInt32(0);
        public final PBStringField phone = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11cdRequest extends MessageMicro<Cmd0x11cdRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", "third_part_info"}, new Object[]{0, null}, Cmd0x11cdRequest.class);
        public final PBEnumField account_type = PBField.initEnum(0);
        public ThirdPartReqInfo third_part_info = new ThirdPartReqInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11cdResponse extends MessageMicro<Cmd0x11cdResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"binding_state", "third_part_info", "uin_info"}, new Object[]{0, null, null}, Cmd0x11cdResponse.class);
        public final PBEnumField binding_state = PBField.initEnum(0);
        public ThirdPartRspInfo third_part_info = new ThirdPartRspInfo();
        public UinInfo uin_info = new UinInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11ceRequest extends MessageMicro<Cmd0x11ceRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34, 42}, new String[]{"profile_sig", "account_type", "third_part_info", "sig_info"}, new Object[]{"", 0, null, ""}, Cmd0x11ceRequest.class);
        public final PBStringField profile_sig = PBField.initString("");
        public final PBEnumField account_type = PBField.initEnum(0);
        public ThirdPartReqInfo third_part_info = new ThirdPartReqInfo();
        public final PBStringField sig_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11ceResponse extends MessageMicro<Cmd0x11ceResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 34, 42}, new String[]{"bind_result", "third_part_info", "profile_sig", "secure_check_url"}, new Object[]{0, null, "", ""}, Cmd0x11ceResponse.class);
        public final PBEnumField bind_result = PBField.initEnum(0);
        public ThirdPartRspInfo third_part_info = new ThirdPartRspInfo();
        public final PBStringField profile_sig = PBField.initString("");
        public final PBStringField secure_check_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11cfRequest extends MessageMicro<Cmd0x11cfRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34, 42, 48}, new String[]{"profile_sig", "account_type", "third_part_info", "sig_info", "is_been_confirmed"}, new Object[]{"", 0, null, "", Boolean.FALSE}, Cmd0x11cfRequest.class);
        public final PBStringField profile_sig = PBField.initString("");
        public final PBEnumField account_type = PBField.initEnum(0);
        public ThirdPartReqInfo third_part_info = new ThirdPartReqInfo();
        public final PBStringField sig_info = PBField.initString("");
        public final PBBoolField is_been_confirmed = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11cfResponse extends MessageMicro<Cmd0x11cfResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"unbind_result", "profile_sig", "secure_check_url"}, new Object[]{0, "", ""}, Cmd0x11cfResponse.class);
        public final PBEnumField unbind_result = PBField.initEnum(0);
        public final PBStringField profile_sig = PBField.initString("");
        public final PBStringField secure_check_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11d0Request extends MessageMicro<Cmd0x11d0Request> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Cmd0x11d0Request.class);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11d0Response extends MessageMicro<Cmd0x11d0Response> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"third_part_info_list"}, new Object[]{null}, Cmd0x11d0Response.class);
        public final PBRepeatMessageField<ThirdPartRspInfo> third_part_info_list = PBField.initRepeatMessage(ThirdPartRspInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11fdRequest extends MessageMicro<Cmd0x11fdRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", "third_part_info"}, new Object[]{0, null}, Cmd0x11fdRequest.class);
        public final PBEnumField account_type = PBField.initEnum(0);
        public ThirdPartReqInfo third_part_info = new ThirdPartReqInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x11fdResponse extends MessageMicro<Cmd0x11fdResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"binding_state_qq", "bind_state_thirdpart", "third_part_info", "uin_info", "profile_sig"}, new Object[]{0, 0, null, null, ""}, Cmd0x11fdResponse.class);
        public final PBEnumField binding_state_qq = PBField.initEnum(0);
        public final PBEnumField bind_state_thirdpart = PBField.initEnum(0);
        public ThirdPartRspInfo third_part_info = new ThirdPartRspInfo();
        public UinInfo uin_info = new UinInfo();
        public final PBStringField profile_sig = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class FaceSigInfo extends MessageMicro<FaceSigInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appid", "openid", RemoteCommand.RESULT_KEY, SessionDbHelper.SESSION_ID}, new Object[]{"", "", "", ""}, FaceSigInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField result_key = PBField.initString("");
        public final PBStringField session = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ProfileSigInfo extends MessageMicro<ProfileSigInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"generate_time", "uin", "operation_type", "sig_check_pass", "sig_type", "third_part_info"}, new Object[]{0L, 0L, 0, Boolean.FALSE, 0, null}, ProfileSigInfo.class);
        public final PBUInt64Field generate_time = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBEnumField operation_type = PBField.initEnum(0);
        public final PBBoolField sig_check_pass = PBField.initBool(false);
        public final PBEnumField sig_type = PBField.initEnum(0);
        public ThirdPartRspInfo third_part_info = new ThirdPartRspInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class SigInfo extends MessageMicro<SigInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"sig_type", "face_sig_info", "sms_sig_info", "appeal_sig_info"}, new Object[]{0, null, null, null}, SigInfo.class);
        public final PBEnumField sig_type = PBField.initEnum(0);
        public FaceSigInfo face_sig_info = new FaceSigInfo();
        public SmsSigInfo sms_sig_info = new SmsSigInfo();
        public AppealInfo appeal_sig_info = new AppealInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class SmsSigInfo extends MessageMicro<SmsSigInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"country_code", "phone", "key_type", "sms_token"}, new Object[]{"", "", 0, ""}, SmsSigInfo.class);
        public final PBStringField country_code = PBField.initString("");
        public final PBStringField phone = PBField.initString("");
        public final PBUInt32Field key_type = PBField.initUInt32(0);
        public final PBStringField sms_token = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ThirdPartReqInfo extends MessageMicro<ThirdPartReqInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"wx_info"}, new Object[]{null}, ThirdPartReqInfo.class);
        public WxReqInfo wx_info = new WxReqInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class ThirdPartRspInfo extends MessageMicro<ThirdPartRspInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"account_type", "wx_info"}, new Object[]{0, null}, ThirdPartRspInfo.class);
        public final PBEnumField account_type = PBField.initEnum(0);
        public WxRspInfo wx_info = new WxRspInfo();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class UinInfo extends MessageMicro<UinInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "head_url", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME}, new Object[]{0L, "", ByteStringMicro.EMPTY}, UinInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField head_url = PBField.initString("");
        public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class WxReqInfo extends MessageMicro<WxReqInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"appid", "code", "union_id"}, new Object[]{"", "", ""}, WxReqInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField code = PBField.initString("");
        public final PBStringField union_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class WxRspInfo extends MessageMicro<WxRspInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"union_id", "openid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "head_img_url", "accsess_token", "appid"}, new Object[]{"", "", "", "", "", ""}, WxRspInfo.class);
        public final PBStringField union_id = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField head_img_url = PBField.initString("");
        public final PBStringField accsess_token = PBField.initString("");
        public final PBStringField appid = PBField.initString("");
    }

    AccountLogic() {
    }
}
