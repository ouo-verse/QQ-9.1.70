package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class GroupRoomManageProto$GetGameStatusByGroupCodeRsp extends MessageMicro<GroupRoomManageProto$GetGameStatusByGroupCodeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{AudienceReportConst.ROOM_ID, "app_type", "game_id", "is_group_member"}, new Object[]{0, 0, 0, 0}, GroupRoomManageProto$GetGameStatusByGroupCodeRsp.class);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field game_id = PBField.initUInt32(0);
    public final PBUInt32Field is_group_member = PBField.initUInt32(0);
}
