package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$BindedRobot extends MessageMicro<GameStrategyQA$BindedRobot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "robot_id"}, new Object[]{0, ""}, GameStrategyQA$BindedRobot.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField robot_id = PBField.initString("");
}
