package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspCmd25 extends MessageMicro<ThirdPartLogin$RspCmd25> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_bind_uin_info", "str_unbind_wording"}, new Object[]{null, ""}, ThirdPartLogin$RspCmd25.class);
    public final PBRepeatMessageField<ThirdPartLogin$UinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(ThirdPartLogin$UinInfo.class);
    public final PBStringField str_unbind_wording = PBField.initString("");
}
