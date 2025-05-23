package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GetRoomInfoRsp extends MessageMicro<RoomManager$GetRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"ret_code", "ret_msg", "seq", AegisLogger.ROOM_INFO, "is_member", "user_role"}, new Object[]{0, "", 0L, null, Boolean.FALSE, 0}, RoomManager$GetRoomInfoRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public RoomManager$RoomInfo room_info = new RoomManager$RoomInfo();
    public final PBBoolField is_member = PBField.initBool(false);
    public final PBEnumField user_role = PBField.initEnum(0);
}
