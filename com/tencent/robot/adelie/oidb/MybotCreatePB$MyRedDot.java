package com.tencent.robot.adelie.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes25.dex */
public final class MybotCreatePB$MyRedDot extends MessageMicro<MybotCreatePB$MyRedDot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"revoke_id", "biz_type", "robot_uin", "info"}, new Object[]{"", 0, 0L, null}, MybotCreatePB$MyRedDot.class);
    public final PBStringField revoke_id = PBField.initString("");
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
    public MybotCreatePB$RedDotsInfo info = new MybotCreatePB$RedDotsInfo();
}
