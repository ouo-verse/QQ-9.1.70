package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$GeneralMsgRsp extends MessageMicro<RobotCallingStatusSync$GeneralMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "msg"}, new Object[]{0, ByteStringMicro.EMPTY}, RobotCallingStatusSync$GeneralMsgRsp.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381579msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
