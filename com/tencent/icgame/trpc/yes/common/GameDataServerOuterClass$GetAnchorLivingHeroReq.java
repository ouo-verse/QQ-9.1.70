package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetAnchorLivingHeroReq extends MessageMicro<GameDataServerOuterClass$GetAnchorLivingHeroReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{AudienceReportConst.ANCHOR_ID, "game_id", AudienceReportConst.ROOM_ID}, new Object[]{"", 0, ""}, GameDataServerOuterClass$GetAnchorLivingHeroReq.class);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField room_id = PBField.initString("");
}
