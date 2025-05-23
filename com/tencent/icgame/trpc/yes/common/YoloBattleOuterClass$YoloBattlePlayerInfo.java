package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattleOuterClass$YoloBattlePlayerInfo extends MessageMicro<YoloBattleOuterClass$YoloBattlePlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"players", "players_quit_in_game"}, new Object[]{null, 0L}, YoloBattleOuterClass$YoloBattlePlayerInfo.class);
    public final PBRepeatMessageField<YoloBattleOuterClass$YoloBattleOnePlayer> players = PBField.initRepeatMessage(YoloBattleOuterClass$YoloBattleOnePlayer.class);
    public final PBRepeatField<Long> players_quit_in_game = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
