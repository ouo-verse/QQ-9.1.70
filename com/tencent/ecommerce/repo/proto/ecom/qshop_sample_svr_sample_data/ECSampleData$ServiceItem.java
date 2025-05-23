package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$ServiceItem extends MessageMicro<ECSampleData$ServiceItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"service_type", "icon", "title", "desc"}, new Object[]{0, "", "", ""}, ECSampleData$ServiceItem.class);
    public final PBInt32Field service_type = PBField.initInt32(0);
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
