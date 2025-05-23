package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$BotStatusSync extends MessageMicro<RobotCallingStatusSync$BotStatusSync> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"status", "seq", "msg", "speech_msg"}, new Object[]{0, 0, ByteStringMicro.EMPTY, null}, RobotCallingStatusSync$BotStatusSync.class);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381577msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public RobotCallingStatusSync$SpeechMsg speech_msg = new RobotCallingStatusSync$SpeechMsg();
}
