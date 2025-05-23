package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderInfo$Bulletin extends MessageMicro<ECOrderInfo$Bulletin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "content"}, new Object[]{"", ""}, ECOrderInfo$Bulletin.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
