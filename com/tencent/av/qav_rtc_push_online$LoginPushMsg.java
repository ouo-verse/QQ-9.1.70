package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class qav_rtc_push_online$LoginPushMsg extends MessageMicro<qav_rtc_push_online$LoginPushMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rooms"}, new Object[]{null}, qav_rtc_push_online$LoginPushMsg.class);
    public final PBRepeatMessageField<qav_rtc_push_online$RoomInfo> rooms = PBField.initRepeatMessage(qav_rtc_push_online$RoomInfo.class);
}
