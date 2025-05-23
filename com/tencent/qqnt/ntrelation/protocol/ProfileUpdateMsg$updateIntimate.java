package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$updateIntimate extends MessageMicro<ProfileUpdateMsg$updateIntimate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{165608, 165616, 248002}, new String[]{"iconFlag", "ssListenTogetherOpen", QCircleDaTongConstant.ElementParamValue.MUTUAL}, new Object[]{0, Boolean.FALSE, null}, ProfileUpdateMsg$updateIntimate.class);
    public final PBUInt32Field iconFlag = PBField.initUInt32(0);
    public final PBBoolField ssListenTogetherOpen = PBField.initBool(false);
    public final PBRepeatMessageField<ProfileUpdateMsg$updateMutualMark> mutual = PBField.initRepeatMessage(ProfileUpdateMsg$updateMutualMark.class);
}
