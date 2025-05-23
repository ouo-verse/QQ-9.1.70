package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$SwitchGameReq extends MessageMicro<RoomManager$SwitchGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{AudienceReportConst.ROOM_ID, "game_id", "game_ext"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, RoomManager$SwitchGameReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBBytesField game_ext = PBField.initBytes(ByteStringMicro.EMPTY);
}
