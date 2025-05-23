package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$GetRoomListByGameIdReq extends MessageMicro<ODRoomSwitchProto$GetRoomListByGameIdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"game_id", "index", "source"}, new Object[]{0, 1, 0}, ODRoomSwitchProto$GetRoomListByGameIdReq.class);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(1);
    public final PBUInt32Field source = PBField.initUInt32(0);
}
