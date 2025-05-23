package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$AnchorEquipRuneStatus extends MessageMicro<GameDataServerOuterClass$AnchorEquipRuneStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{AudienceReportConst.ANCHOR_ID, "equip_status"}, new Object[]{"", 0}, GameDataServerOuterClass$AnchorEquipRuneStatus.class);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBInt32Field equip_status = PBField.initInt32(0);
}
