package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQA$GetBindedRobotReply extends MessageMicro<GameStrategyQA$GetBindedRobotReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{IRobotUtilApi.MMKV_SCENE_ID}, new Object[]{null}, GameStrategyQA$GetBindedRobotReply.class);
    public GameStrategyQA$BindedRobot robot = new GameStrategyQA$BindedRobot();
}
