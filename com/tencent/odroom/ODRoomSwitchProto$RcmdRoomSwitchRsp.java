package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$RcmdRoomSwitchRsp extends MessageMicro<ODRoomSwitchProto$RcmdRoomSwitchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret", "front_list", "after_list", "update_time"}, new Object[]{0, null, null, 20}, ODRoomSwitchProto$RcmdRoomSwitchRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBRepeatMessageField<ODRoomSwitchProto$SwitchRoomInfo> front_list = PBField.initRepeatMessage(ODRoomSwitchProto$SwitchRoomInfo.class);
    public final PBRepeatMessageField<ODRoomSwitchProto$SwitchRoomInfo> after_list = PBField.initRepeatMessage(ODRoomSwitchProto$SwitchRoomInfo.class);
    public final PBUInt32Field update_time = PBField.initUInt32(20);
}
