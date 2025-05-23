package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$SetBindedRobotRequest extends MessageMicro<GameStrategyQA$SetBindedRobotRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"guild_id", "channel_id", IRobotUtilApi.MMKV_SCENE_ID}, new Object[]{0L, 0L, null}, GameStrategyQA$SetBindedRobotRequest.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public GameStrategyQA$BindedRobot robot = new GameStrategyQA$BindedRobot();
}
