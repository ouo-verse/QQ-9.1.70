package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspPhoneSmsExtendLogin extends MessageMicro<ThirdPartLogin$RspPhoneSmsExtendLogin> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 88, 98, 106, 114}, new String[]{"rpt_bind_uin_info", "int32_phone_bind_result", "str_phone_bind_msg_title", "str_phone_bind_msg_content", "str_unbind_wording"}, new Object[]{null, 0, "", "", ""}, ThirdPartLogin$RspPhoneSmsExtendLogin.class);
    public final PBRepeatMessageField<ThirdPartLogin$UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(ThirdPartLogin$UinInfo.class);
    public final PBInt32Field int32_phone_bind_result = PBField.initInt32(0);
    public final PBStringField str_phone_bind_msg_title = PBField.initString("");
    public final PBStringField str_phone_bind_msg_content = PBField.initString("");
    public final PBStringField str_unbind_wording = PBField.initString("");
}
