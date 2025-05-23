package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleRsp extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{VasQQSettingMeImpl.EXPIRE_TIME, "battle_access_info", "players"}, new Object[]{0, "", null}, YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleRsp.class);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBStringField battle_access_info = PBField.initString("");
    public final PBRepeatMessageField<YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo> players = PBField.initRepeatMessage(YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo.class);
}
