package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$GetRoomListByGameIdRsp extends MessageMicro<ODRoomSwitchProto$GetRoomListByGameIdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "room_list", "index_end"}, new Object[]{0, null, 0}, ODRoomSwitchProto$GetRoomListByGameIdRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBRepeatMessageField<ODRoomSwitchProto$RoomInfo> room_list = PBField.initRepeatMessage(ODRoomSwitchProto$RoomInfo.class);
    public final PBUInt32Field index_end = PBField.initUInt32(0);
}
