package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqCommonInfo extends MessageMicro<ThirdPartLogin$ReqCommonInfo> {
    public static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_req_need_uid_flag = PBField.initBool(false);
    public final PBUInt32Field uint32_req_need_verify_scenes = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_support_self_phone_check = PBField.initUInt32(0);
    public final PBBoolField bool_req_support_diff_passwd_can_verify = PBField.initBool(false);
    public final PBStringField str_verify_sig = PBField.initString("");
    public final PBBoolField bool_req_support_connect_pskey = PBField.initBool(false);
    public final PBBoolField bool_req_passwd_err_support_identity_verify = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{72, 80, 88, 96, 106, 112, 120}, new String[]{"bool_req_need_uid_flag", "uint32_req_need_verify_scenes", "uint32_req_support_self_phone_check", "bool_req_support_diff_passwd_can_verify", "str_verify_sig", "bool_req_support_connect_pskey", "bool_req_passwd_err_support_identity_verify"}, new Object[]{bool, 0, 0, bool, "", bool, bool}, ThirdPartLogin$ReqCommonInfo.class);
    }
}
