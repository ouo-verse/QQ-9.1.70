package com.tencent.robot.adelie.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes25.dex */
public final class MybotCreatePB$GetMyRedDotsRsp extends MessageMicro<MybotCreatePB$GetMyRedDotsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"red_dots"}, new Object[]{null}, MybotCreatePB$GetMyRedDotsRsp.class);
    public final PBRepeatMessageField<MybotCreatePB$MyRedDot> red_dots = PBField.initRepeatMessage(MybotCreatePB$MyRedDot.class);
}
