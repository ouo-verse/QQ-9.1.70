package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$GetRoomRsp extends MessageMicro<RoomRcmd$GetRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", AegisLogger.ROOM_INFO}, new Object[]{0L, "", null}, RoomRcmd$GetRoomRsp.class);
    public final PBUInt64Field ret_code = PBField.initUInt64(0);
    public final PBStringField ret_msg = PBField.initString("");
    public RoomRcmd$RoomInfo room_info = new RoomRcmd$RoomInfo();
}
