package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$CreateCODMGroupRoomRsp extends MessageMicro<GameDataServerOuterClass$CreateCODMGroupRoomRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"group_room_id", "group_room_guid", "room_svr_addr"}, new Object[]{"", "", ""}, GameDataServerOuterClass$CreateCODMGroupRoomRsp.class);
    public final PBStringField group_room_id = PBField.initString("");
    public final PBStringField group_room_guid = PBField.initString("");
    public final PBStringField room_svr_addr = PBField.initString("");
}
