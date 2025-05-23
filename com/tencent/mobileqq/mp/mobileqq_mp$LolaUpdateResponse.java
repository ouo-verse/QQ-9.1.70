package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$LolaUpdateResponse extends MessageMicro<mobileqq_mp$LolaUpdateResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret_info", "response_item"}, new Object[]{null, null}, mobileqq_mp$LolaUpdateResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBRepeatMessageField<mobileqq_mp$UpdateResponseItem> response_item = PBField.initRepeatMessage(mobileqq_mp$UpdateResponseItem.class);
}
