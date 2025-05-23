package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SmobaEquip extends MessageMicro<GameDataServerOuterClass$SmobaEquip> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"equip_id", "name", "remark", "attr", "skill", "category", "icon"}, new Object[]{0, "", "", null, null, "", ""}, GameDataServerOuterClass$SmobaEquip.class);
    public final PBUInt32Field equip_id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaCommAttr> attr = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaCommAttr.class);
    public final PBRepeatMessageField<GameDataServerOuterClass$SmobaSkill> skill = PBField.initRepeatMessage(GameDataServerOuterClass$SmobaSkill.class);
    public final PBStringField category = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
}
