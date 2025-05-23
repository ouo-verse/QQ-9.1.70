package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$ElapsedTimeReport extends MessageMicro<RobotCallingStatusSync$ElapsedTimeReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"elapsed_times"}, new Object[]{null}, RobotCallingStatusSync$ElapsedTimeReport.class);
    public final PBRepeatMessageField<RobotCallingStatusSync$ElapsedTime> elapsed_times = PBField.initRepeatMessage(RobotCallingStatusSync$ElapsedTime.class);
}
