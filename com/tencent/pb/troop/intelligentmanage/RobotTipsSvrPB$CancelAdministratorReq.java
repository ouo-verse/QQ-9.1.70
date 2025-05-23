package com.tencent.pb.troop.intelligentmanage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class RobotTipsSvrPB$CancelAdministratorReq extends MessageMicro<RobotTipsSvrPB$CancelAdministratorReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "robot_uin"}, new Object[]{0L, 0L}, RobotTipsSvrPB$CancelAdministratorReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
}
