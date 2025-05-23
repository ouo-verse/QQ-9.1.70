package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class RoomRcmd$GetRoomListByPageReq extends MessageMicro<RoomRcmd$GetRoomListByPageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"page", "size", "read_room_list"}, new Object[]{0, 0, 0L}, RoomRcmd$GetRoomListByPageReq.class);
    public final PBUInt32Field page = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBRepeatField<Long> read_room_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
