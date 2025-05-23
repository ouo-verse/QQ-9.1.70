package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetSmobaConfigRsp extends MessageMicro<GameDataServerOuterClass$GetSmobaConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"game_mode_list", "grade_list", "lane_type_list", "big_grade_level_conf_list", "game_mode_conf_list", "hero_conf_list", "ladder_grade_conf_list", "team_name_list"}, new Object[]{null, null, null, null, null, null, null, ""}, GameDataServerOuterClass$GetSmobaConfigRsp.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaConfigItem> game_mode_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaConfigItem.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaConfigItem> grade_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaConfigItem.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaConfigItem> lane_type_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaConfigItem.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaBigGradeLevel> big_grade_level_conf_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaBigGradeLevel.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaGameMode> game_mode_conf_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaGameMode.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaHero> hero_conf_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaHero.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaLadderGrade> ladder_grade_conf_list = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaLadderGrade.class);
    public final PBRepeatField<String> team_name_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}
