package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$UserRoom extends MessageMicro<UserProxyCmdOuterClass$UserRoom> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{AudienceReportConst.ROOM_ID, "room_type"}, new Object[]{0L, 0}, UserProxyCmdOuterClass$UserRoom.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBInt32Field room_type = PBField.initInt32(0);
}
