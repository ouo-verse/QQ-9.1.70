package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$RefreshRoomListReq extends MessageMicro<RoomRcmd$RefreshRoomListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"size", "read_room_list"}, new Object[]{0, 0L}, RoomRcmd$RefreshRoomListReq.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBRepeatField<Long> read_room_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
