package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$BuyerInfo extends MessageMicro<ECOrder$BuyerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_id"}, new Object[]{""}, ECOrder$BuyerInfo.class);
    public final PBStringField user_id = PBField.initString("");
}
