package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelReq extends MessageMicro<SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uid", "from_channel_id", "channel_name", "user_id", "a2_key"}, new Object[]{0L, "", "", "", ByteStringMicro.EMPTY}, SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField from_channel_id = PBField.initString("");
    public final PBStringField channel_name = PBField.initString("");
    public final PBStringField user_id = PBField.initString("");
    public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
}
