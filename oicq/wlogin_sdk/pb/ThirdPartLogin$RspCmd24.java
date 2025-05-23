package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$RspCmd24 extends MessageMicro<ThirdPartLogin$RspCmd24> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_salt_list"}, new Object[]{null}, ThirdPartLogin$RspCmd24.class);
    public final PBRepeatMessageField<ThirdPartLogin$RandSalt> rpt_salt_list = PBField.initRepeatMessage(ThirdPartLogin$RandSalt.class);
}
