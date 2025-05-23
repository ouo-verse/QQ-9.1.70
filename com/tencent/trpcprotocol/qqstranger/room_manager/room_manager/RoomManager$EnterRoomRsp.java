package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$EnterRoomRsp extends MessageMicro<RoomManager$EnterRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "ret_msg", AegisLogger.ROOM_INFO, "user_role"}, new Object[]{0, "", null, 0}, RoomManager$EnterRoomRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public RoomManager$RoomInfo room_info = new RoomManager$RoomInfo();
    public final PBUInt32Field user_role = PBField.initUInt32(0);
}
