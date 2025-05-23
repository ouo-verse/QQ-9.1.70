package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$Service extends MessageMicro<ECOrderCommon$Service> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECOrderCommon$Service.class);
    public final PBRepeatMessageField<ECOrderCommon$ServiceItem> items = PBField.initRepeatMessage(ECOrderCommon$ServiceItem.class);
}
