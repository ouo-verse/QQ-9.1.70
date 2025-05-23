package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$GetYoloRoomDataReq extends MessageMicro<YoloRoomOuterClass$GetYoloRoomDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{AudienceReportConst.ROOM_ID, "client_max_id", "is_update_heartbeat"}, new Object[]{0L, 0L, 0}, YoloRoomOuterClass$GetYoloRoomDataReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBUInt64Field client_max_id = PBField.initUInt64(0);
    public final PBInt32Field is_update_heartbeat = PBField.initInt32(0);
}
