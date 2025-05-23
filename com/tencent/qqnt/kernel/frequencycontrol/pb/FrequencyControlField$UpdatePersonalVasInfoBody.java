package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes24.dex */
public final class FrequencyControlField$UpdatePersonalVasInfoBody extends MessageMicro<FrequencyControlField$UpdatePersonalVasInfoBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1772008, 1772016}, new String[]{"uin", "qq_va_data_change_rand"}, new Object[]{0L, 0}, FrequencyControlField$UpdatePersonalVasInfoBody.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field qq_va_data_change_rand = PBField.initInt32(0);
}
