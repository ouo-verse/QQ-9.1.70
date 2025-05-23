package com.tencent.odroom;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class ODRoomSwitchProto$RoomInfo extends MessageMicro<ODRoomSwitchProto$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56}, new String[]{AudienceReportConst.ROOM_ID, AudienceReportConst.ROOM_NAME, "room_logo_url", "anchor_uin", "anchor_nick", "anchor_pic", "online_num"}, new Object[]{0L, "", "", 0L, "", "", 0}, ODRoomSwitchProto$RoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField room_name = PBField.initString("");
    public final PBStringField room_logo_url = PBField.initString("");
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0);
    public final PBStringField anchor_nick = PBField.initString("");
    public final PBStringField anchor_pic = PBField.initString("");
    public final PBUInt32Field online_num = PBField.initUInt32(0);
}
