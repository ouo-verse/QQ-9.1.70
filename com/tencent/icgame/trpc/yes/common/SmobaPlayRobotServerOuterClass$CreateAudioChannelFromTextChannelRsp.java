package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelRsp extends MessageMicro<SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"channel_id"}, new Object[]{""}, SmobaPlayRobotServerOuterClass$CreateAudioChannelFromTextChannelRsp.class);
    public final PBStringField channel_id = PBField.initString("");
}
