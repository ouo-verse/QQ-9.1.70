package com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class RobotCallingStatusSync$GeneralMsgReq extends MessageMicro<RobotCallingStatusSync$GeneralMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f381578msg;
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBBytesField ptt_ext_info;

    public RobotCallingStatusSync$GeneralMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f381578msg = PBField.initBytes(byteStringMicro);
        this.ptt_ext_info = PBField.initBytes(byteStringMicro);
    }

    static {
        String[] strArr = {QQHealthReportApiImpl.MSG_TYPE_KEY, "msg", "ptt_ext_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, strArr, new Object[]{0, byteStringMicro, byteStringMicro}, RobotCallingStatusSync$GeneralMsgReq.class);
    }
}
