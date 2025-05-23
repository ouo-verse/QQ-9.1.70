package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$RcmdRoomSwitchReq extends MessageMicro<ODRoomSwitchProto$RcmdRoomSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field curr_roomid = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBFloatField longitude = PBField.initFloat(0.0f);
    public final PBFloatField latitude = PBField.initFloat(0.0f);
    public final PBUInt32Field source = PBField.initUInt32(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 37, 40}, new String[]{"curr_roomid", "gender", "longitude", "latitude", "source"}, new Object[]{0, 0, valueOf, valueOf, 0}, ODRoomSwitchProto$RcmdRoomSwitchReq.class);
    }
}
