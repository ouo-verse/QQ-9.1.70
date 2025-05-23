package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetWeeklySummaryRequest extends MessageMicro<weather$GetWeeklySummaryRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"adcode"}, new Object[]{0}, weather$GetWeeklySummaryRequest.class);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
}
