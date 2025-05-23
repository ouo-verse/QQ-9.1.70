package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$LeaveRoomReq extends MessageMicro<RoomManager$LeaveRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "leave_reason"}, new Object[]{0L, 0L}, RoomManager$LeaveRoomReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field leave_reason = PBField.initUInt64(0);
}
