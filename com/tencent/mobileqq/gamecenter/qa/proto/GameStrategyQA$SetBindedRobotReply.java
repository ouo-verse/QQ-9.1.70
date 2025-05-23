package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$SetBindedRobotReply extends MessageMicro<GameStrategyQA$SetBindedRobotReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "err_msg"}, new Object[]{0, ""}, GameStrategyQA$SetBindedRobotReply.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
