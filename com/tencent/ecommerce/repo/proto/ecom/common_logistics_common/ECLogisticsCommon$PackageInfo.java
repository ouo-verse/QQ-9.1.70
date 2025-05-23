package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECLogisticsCommon$PackageInfo extends MessageMicro<ECLogisticsCommon$PackageInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"product_name", "product_icon", "spu_id", "sku_id"}, new Object[]{"", "", "", ""}, ECLogisticsCommon$PackageInfo.class);
    public final PBStringField product_name = PBField.initString("");
    public final PBStringField product_icon = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
}
