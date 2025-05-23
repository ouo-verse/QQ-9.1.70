package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$ToBotData extends MessageMicro<RobotCallingStatusSync$ToBotData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"realtime_speech_msg"}, new Object[]{0}, RobotCallingStatusSync$ToBotData.class);
    public final PBInt32Field realtime_speech_msg = PBField.initInt32(0);
}
