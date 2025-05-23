package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqBodyThirdLogin extends MessageMicro<ThirdPartLogin$ReqBodyThirdLogin> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 162, 170, 178, 186, 194}, new String[]{"uint32_service_type", "uin_account_type", "msg_req_google", "msg_req_facebook", "msg_req_phone", "msg_req_apple", "msg_req_wechat"}, new Object[]{0, 0, null, null, null, null, null}, ThirdPartLogin$ReqBodyThirdLogin.class);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt32Field uin_account_type = PBField.initUInt32(0);
    public ThirdPartLogin$ReqBodyGoogle msg_req_google = new MessageMicro<ThirdPartLogin$ReqBodyGoogle>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodyGoogle
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_id_token"}, new Object[]{"", ""}, ThirdPartLogin$ReqBodyGoogle.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_id_token = PBField.initString("");
    };
    public ThirdPartLogin$ReqBodyFaceBook msg_req_facebook = new MessageMicro<ThirdPartLogin$ReqBodyFaceBook>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodyFaceBook
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_appid", "str_access_token"}, new Object[]{"", ""}, ThirdPartLogin$ReqBodyFaceBook.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_access_token = PBField.initString("");
    };
    public ThirdPartLogin$ReqPhoneLogin msg_req_phone = new MessageMicro<ThirdPartLogin$ReqPhoneLogin>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqPhoneLogin
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"str_country_code", "str_phone_num"}, new Object[]{"", ""}, ThirdPartLogin$ReqPhoneLogin.class);
        public final PBStringField str_country_code = PBField.initString("");
        public final PBStringField str_phone_num = PBField.initString("");
    };
    public ThirdPartLogin$ReqBodyApple msg_req_apple = new MessageMicro<ThirdPartLogin$ReqBodyApple>() { // from class: oicq.wlogin_sdk.pb.ThirdPartLogin$ReqBodyApple
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 242, 250}, new String[]{"str_appid", "str_user_id", "str_identity_token", "str_authorization_code", "str_nick_name", "str_gender"}, new Object[]{"", "", "", "", "", ""}, ThirdPartLogin$ReqBodyApple.class);
        public final PBStringField str_appid = PBField.initString("");
        public final PBStringField str_user_id = PBField.initString("");
        public final PBStringField str_identity_token = PBField.initString("");
        public final PBStringField str_authorization_code = PBField.initString("");
        public final PBStringField str_nick_name = PBField.initString("");
        public final PBStringField str_gender = PBField.initString("");
    };
    public ThirdPartLogin$ReqWechat msg_req_wechat = new ThirdPartLogin$ReqWechat();
}
