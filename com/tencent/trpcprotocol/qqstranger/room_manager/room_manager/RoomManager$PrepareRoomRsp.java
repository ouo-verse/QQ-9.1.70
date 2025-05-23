package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class RoomManager$PrepareRoomRsp extends MessageMicro<RoomManager$PrepareRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 48, 58, 66}, new String[]{"ret_code", "ret_msg", "default_room_name", "remain_times", "game_options", "room_type_options"}, new Object[]{0, "", "", 0, null, null}, RoomManager$PrepareRoomRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBStringField default_room_name = PBField.initString("");
    public final PBUInt32Field remain_times = PBField.initUInt32(0);
    public final PBRepeatMessageField<RoomManager$GameOption> game_options = PBField.initRepeatMessage(RoomManager$GameOption.class);
    public final PBRepeatMessageField<RoomManager$RoomTypeOption> room_type_options = PBField.initRepeatMessage(RoomManager$RoomTypeOption.class);
}
