package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GetRoomNameReq extends MessageMicro<RoomManager$GetRoomNameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"game_id", "game_sub_id", "room_type"}, new Object[]{0, 0L, 0}, RoomManager$GetRoomNameReq.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt64Field game_sub_id = PBField.initInt64(0);
    public final PBUInt32Field room_type = PBField.initUInt32(0);
}
