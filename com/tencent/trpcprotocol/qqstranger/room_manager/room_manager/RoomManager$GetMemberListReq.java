package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$GetMemberListReq extends MessageMicro<RoomManager$GetMemberListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{AudienceReportConst.ROOM_ID, "page", "size", "user_detail"}, new Object[]{0L, 0L, 0L, Boolean.FALSE}, RoomManager$GetMemberListReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field page = PBField.initUInt64(0);
    public final PBUInt64Field size = PBField.initUInt64(0);
    public final PBBoolField user_detail = PBField.initBool(false);
}
