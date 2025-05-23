package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECOrderCommon$PropertyItem extends MessageMicro<ECOrderCommon$PropertyItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "value"}, new Object[]{"", "", ""}, ECOrderCommon$PropertyItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105236id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
