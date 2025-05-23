package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$GetRoomListRsp extends MessageMicro<RoomRcmd$GetRoomListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "ret_msg", "room_items", "is_end"}, new Object[]{0L, "", null, Boolean.FALSE}, RoomRcmd$GetRoomListRsp.class);
    public final PBUInt64Field ret_code = PBField.initUInt64(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<RoomRcmd$RoomItem> room_items = PBField.initRepeatMessage(RoomRcmd$RoomItem.class);
    public final PBBoolField is_end = PBField.initBool(false);
}
