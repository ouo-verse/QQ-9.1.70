package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GetAnchorRoomInfoReq extends MessageMicro<PremadesTeamServerOuterClass$GetAnchorRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{AudienceReportConst.ANCHOR_ID, "game_id", AudienceReportConst.ROOM_ID, "uid", "anchor_uid"}, new Object[]{"", 0, 0L, 0L, 0L}, PremadesTeamServerOuterClass$GetAnchorRoomInfoReq.class);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
}
