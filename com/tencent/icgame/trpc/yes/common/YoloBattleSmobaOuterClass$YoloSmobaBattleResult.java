package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaBattleResult extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaBattleResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"game_id", "battle_id", "camp_settle_list", "smoba_config"}, new Object[]{0, "", null, null}, YoloBattleSmobaOuterClass$YoloSmobaBattleResult.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField battle_id = PBField.initString("");
    public final PBRepeatMessageField<SmobaDataOuterClass$GameCampSettleInfo> camp_settle_list = PBField.initRepeatMessage(SmobaDataOuterClass$GameCampSettleInfo.class);
    public YoloBattleSmobaOuterClass$YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass$YoloSmobaBattleConfig();
}
