package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWeeklySummaryReply extends MessageMicro<weather$GetWeeklySummaryReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"week_begin", "week_end", "weather", "festivals"}, new Object[]{0L, 0L, null, null}, weather$GetWeeklySummaryReply.class);
    public final PBUInt64Field week_begin = PBField.initUInt64(0);
    public final PBUInt64Field week_end = PBField.initUInt64(0);
    public Oidb_0xca6$RspBody weather = new Oidb_0xca6$RspBody();
    public final PBRepeatMessageField<Festival$FestivalDate> festivals = PBField.initRepeatMessage(Festival$FestivalDate.class);
}
