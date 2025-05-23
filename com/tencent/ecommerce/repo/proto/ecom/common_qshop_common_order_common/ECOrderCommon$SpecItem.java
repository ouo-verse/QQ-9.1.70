package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$SpecItem extends MessageMicro<ECOrderCommon$SpecItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "name", "value"}, new Object[]{"", "", ""}, ECOrderCommon$SpecItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105237id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
