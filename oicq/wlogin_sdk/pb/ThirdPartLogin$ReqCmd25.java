package oicq.wlogin_sdk.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes28.dex */
public final class ThirdPartLogin$ReqCmd25 extends MessageMicro<ThirdPartLogin$ReqCmd25> {
    public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_a1_list"}, new Object[]{null}, ThirdPartLogin$ReqCmd25.class);
    public final PBRepeatMessageField<ThirdPartLogin$A1Sig> rpt_a1_list = PBField.initRepeatMessage(ThirdPartLogin$A1Sig.class);
}
