package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspBodyThirdLogin extends MessageMicro<ThirdPartLogin$RspBodyThirdLogin> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 96, 106, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uint64_qq_uin", "uint32_register_flag", "str_register_token", "msg_rsp_google", "msg_rsp_facebook", "msg_rsp_phone", "msg_rsp_apple", "msg_rsp_wechat"}, new Object[]{0, 0L, 0, "", null, null, null, null, null}, ThirdPartLogin$RspBodyThirdLogin.class);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_register_flag = PBField.initUInt32(0);
    public final PBStringField str_register_token = PBField.initString("");
    public ThirdPartLogin$RspBodyGoogle msg_rsp_google = new MessageMicro<ThirdPartLogin$RspBodyGoogle>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodyGoogle
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, ThirdPartLogin$RspBodyGoogle.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public ThirdPartLogin$RspBodyFaceBook msg_rsp_facebook = new MessageMicro<ThirdPartLogin$RspBodyFaceBook>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodyFaceBook
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, ThirdPartLogin$RspBodyFaceBook.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public ThirdPartLogin$RspPhoneLogin msg_rsp_phone = new MessageMicro<ThirdPartLogin$RspPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspPhoneLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"str_user_profile"}, new Object[]{""}, ThirdPartLogin$RspPhoneLogin.class);
        public final PBStringField str_user_profile = PBField.initString("");
    };
    public ThirdPartLogin$RspBodyApple msg_rsp_apple = new MessageMicro<ThirdPartLogin$RspBodyApple>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspBodyApple
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ThirdPartLogin$RspBodyApple.class);
    };
    public ThirdPartLogin$RspWechat msg_rsp_wechat = new MessageMicro<ThirdPartLogin$RspWechat>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$RspWechat
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82}, new String[]{"str_profile"}, new Object[]{""}, ThirdPartLogin$RspWechat.class);
        public final PBStringField str_profile = PBField.initString("");
    };
}
