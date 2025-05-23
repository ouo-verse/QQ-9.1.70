package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GetMemberListV2Req extends MessageMicro<RoomManager$GetMemberListV2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"cookies", AudienceReportConst.ROOM_ID}, new Object[]{"", 0L}, RoomManager$GetMemberListV2Req.class);
    public final PBStringField cookies = PBField.initString("");
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
