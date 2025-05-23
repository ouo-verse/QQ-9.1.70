package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes31.dex */
public final class ECOrderCommon$PropertyInfo extends MessageMicro<ECOrderCommon$PropertyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECOrderCommon$PropertyInfo.class);
    public final PBRepeatMessageField<ECOrderCommon$PropertyItem> items = PBField.initRepeatMessage(ECOrderCommon$PropertyItem.class);
}
