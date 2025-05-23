package com.tencent.av;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_rtc_push_online$RoomInfo extends MessageMicro<qav_rtc_push_online$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"business_type", AudienceReportConst.ROOM_ID, "group_id", "user_num", "users"}, new Object[]{0, 0, 0L, 0, null}, qav_rtc_push_online$RoomInfo.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field user_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<qav_rtc_push_online$UserInfo> users = PBField.initRepeatMessage(qav_rtc_push_online$UserInfo.class);
}
