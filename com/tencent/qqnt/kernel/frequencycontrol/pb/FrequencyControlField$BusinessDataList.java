package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$BusinessDataList extends MessageMicro<FrequencyControlField$BusinessDataList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"businessDataList"}, new Object[]{null}, FrequencyControlField$BusinessDataList.class);
    public final PBRepeatMessageField<FrequencyControlField$BusinessData> businessDataList = PBField.initRepeatMessage(FrequencyControlField$BusinessData.class);
}
