package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$ElapsedTime extends MessageMicro<RobotCallingStatusSync$ElapsedTime> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"path_id", "task_id", "elapsed_time", "curr_time"}, new Object[]{0, "", 0, 0L}, RobotCallingStatusSync$ElapsedTime.class);
    public final PBEnumField path_id = PBField.initEnum(0);
    public final PBStringField task_id = PBField.initString("");
    public final PBUInt32Field elapsed_time = PBField.initUInt32(0);
    public final PBUInt64Field curr_time = PBField.initUInt64(0);
}
