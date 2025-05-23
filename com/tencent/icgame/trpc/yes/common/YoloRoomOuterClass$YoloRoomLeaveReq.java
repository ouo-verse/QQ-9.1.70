package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomLeaveReq extends MessageMicro<YoloRoomOuterClass$YoloRoomLeaveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{AudienceReportConst.ROOM_ID, "force_exit", "room_type"}, new Object[]{0L, 0, 0}, YoloRoomOuterClass$YoloRoomLeaveReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field force_exit = PBField.initInt32(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
}
