package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$ExtInfo extends MessageMicro<ECOrderCommon$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"key", "value", "explain"}, new Object[]{"", "", ""}, ECOrderCommon$ExtInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
    public final PBStringField explain = PBField.initString("");
}
