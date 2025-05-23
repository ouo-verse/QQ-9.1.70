package com.tencent.odroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$SwitchRoomInfo extends MessageMicro<ODRoomSwitchProto$SwitchRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"roomid"}, new Object[]{0}, ODRoomSwitchProto$SwitchRoomInfo.class);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
}
