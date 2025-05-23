package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$BattlePartnerConfig extends MessageMicro<YoloBattlePartnerOuterClass$BattlePartnerConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 40}, new String[]{"battle_game", "anchor_nick", "queue_switch"}, new Object[]{0, "", Boolean.FALSE}, YoloBattlePartnerOuterClass$BattlePartnerConfig.class);
    public final PBEnumField battle_game = PBField.initEnum(0);
    public final PBStringField anchor_nick = PBField.initString("");
    public final PBBoolField queue_switch = PBField.initBool(false);
}
