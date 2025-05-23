package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$SpecInfo extends MessageMicro<ECSampleData$SpecInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECSampleData$SpecInfo.class);
    public final PBRepeatMessageField<ECSampleData$SpecItem> items = PBField.initRepeatMessage(ECSampleData$SpecItem.class);
}
