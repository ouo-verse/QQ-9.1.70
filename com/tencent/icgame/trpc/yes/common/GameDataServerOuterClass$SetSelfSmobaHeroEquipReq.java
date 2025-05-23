package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SetSelfSmobaHeroEquipReq extends MessageMicro<GameDataServerOuterClass$SetSelfSmobaHeroEquipReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uid", "hero_id", "equip_idx", "equip_str", GdtGetUserInfoHandler.KEY_AREA, "partition"}, new Object[]{0L, 0, 0, "", 0, 0}, GameDataServerOuterClass$SetSelfSmobaHeroEquipReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field hero_id = PBField.initUInt32(0);
    public final PBUInt32Field equip_idx = PBField.initUInt32(0);
    public final PBStringField equip_str = PBField.initString("");
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
}
