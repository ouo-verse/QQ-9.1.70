package com.tencent.trpcprotocol.qqstranger.room_admin.room_admin;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomAdmin$IsKickOutReq extends MessageMicro<RoomAdmin$IsKickOutReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AudienceReportConst.ROOM_ID, "uid"}, new Object[]{0L, ""}, RoomAdmin$IsKickOutReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField uid = PBField.initString("");
}
