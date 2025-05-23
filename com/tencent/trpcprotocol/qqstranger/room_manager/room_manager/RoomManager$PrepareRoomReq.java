package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class RoomManager$PrepareRoomReq extends MessageMicro<RoomManager$PrepareRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"page_source"}, new Object[]{0}, RoomManager$PrepareRoomReq.class);
    public final PBEnumField page_source = PBField.initEnum(0);
}
