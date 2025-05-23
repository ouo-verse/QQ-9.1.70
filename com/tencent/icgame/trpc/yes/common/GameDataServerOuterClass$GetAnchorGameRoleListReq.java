package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GetAnchorGameRoleListReq extends MessageMicro<GameDataServerOuterClass$GetAnchorGameRoleListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{AudienceReportConst.ANCHOR_ID, "game_id", "uid", "a2_key", AudienceReportConst.ROOM_ID}, new Object[]{"", 0, 0L, ByteStringMicro.EMPTY, 0L}, GameDataServerOuterClass$GetAnchorGameRoleListReq.class);
    public final PBStringField anchor_id = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBBytesField a2_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
