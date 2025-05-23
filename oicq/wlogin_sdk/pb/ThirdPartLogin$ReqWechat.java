package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqWechat extends MessageMicro<ThirdPartLogin$ReqWechat> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"str_appid", "str_code", "str_profile_sig"}, new Object[]{"", "", ""}, ThirdPartLogin$ReqWechat.class);
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_code = PBField.initString("");
    public final PBStringField str_profile_sig = PBField.initString("");
}
