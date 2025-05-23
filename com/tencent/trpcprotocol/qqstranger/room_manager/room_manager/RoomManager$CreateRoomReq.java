package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$CreateRoomReq extends MessageMicro<RoomManager$CreateRoomReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{Node.ATTRS_ATTR, "game_id", "game_ext", "room_type"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0}, RoomManager$CreateRoomReq.class);
    public final PBRepeatMessageField<RoomManager$TypeValue> attrs = PBField.initRepeatMessage(RoomManager$TypeValue.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBBytesField game_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field room_type = PBField.initUInt32(0);
}
