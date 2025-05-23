package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$GetRoomReq extends MessageMicro<RoomRcmd$GetRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"source"}, new Object[]{""}, RoomRcmd$GetRoomReq.class);
    public final PBStringField source = PBField.initString("");
}
