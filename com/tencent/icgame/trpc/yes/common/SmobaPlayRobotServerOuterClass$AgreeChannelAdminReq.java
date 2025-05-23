package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class SmobaPlayRobotServerOuterClass$AgreeChannelAdminReq extends MessageMicro<SmobaPlayRobotServerOuterClass$AgreeChannelAdminReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"channel_id", "user_id", "tmp_channel_name"}, new Object[]{"", "", ""}, SmobaPlayRobotServerOuterClass$AgreeChannelAdminReq.class);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField tmp_channel_name = PBField.initString("");
}
