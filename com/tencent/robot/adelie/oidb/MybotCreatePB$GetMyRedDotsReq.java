package com.tencent.robot.adelie.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes25.dex */
public final class MybotCreatePB$GetMyRedDotsReq extends MessageMicro<MybotCreatePB$GetMyRedDotsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"robot_uin"}, new Object[]{0L}, MybotCreatePB$GetMyRedDotsReq.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
}
