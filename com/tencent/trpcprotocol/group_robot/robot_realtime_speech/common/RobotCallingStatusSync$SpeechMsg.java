package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$SpeechMsg extends MessageMicro<RobotCallingStatusSync$SpeechMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"send_type", "upgrade_msg", "text_msg", "task_id"}, new Object[]{0, "", "", ""}, RobotCallingStatusSync$SpeechMsg.class);
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBStringField upgrade_msg = PBField.initString("");
    public final PBStringField text_msg = PBField.initString("");
    public final PBStringField task_id = PBField.initString("");
}
