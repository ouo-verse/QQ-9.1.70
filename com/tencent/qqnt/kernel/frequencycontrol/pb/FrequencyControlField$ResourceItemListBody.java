package com.tencent.qqnt.kernel.frequencycontrol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FrequencyControlField$ResourceItemListBody extends MessageMicro<FrequencyControlField$ResourceItemListBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1771210}, new String[]{"item_list"}, new Object[]{null}, FrequencyControlField$ResourceItemListBody.class);
    public final PBRepeatMessageField<FrequencyControlField$ResourceItem> item_list = PBField.initRepeatMessage(FrequencyControlField$ResourceItem.class);
}
