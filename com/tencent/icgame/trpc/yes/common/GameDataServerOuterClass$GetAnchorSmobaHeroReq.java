package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetAnchorSmobaHeroReq extends MessageMicro<GameDataServerOuterClass$GetAnchorSmobaHeroReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26}, new String[]{AudienceReportConst.ANCHOR_ID, AudienceReportConst.ROOM_ID}, new Object[]{"", ""}, GameDataServerOuterClass$GetAnchorSmobaHeroReq.class);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBStringField room_id = PBField.initString("");
}
