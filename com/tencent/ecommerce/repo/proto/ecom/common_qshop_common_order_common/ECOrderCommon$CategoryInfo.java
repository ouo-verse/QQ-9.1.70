package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$CategoryInfo extends MessageMicro<ECOrderCommon$CategoryInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"first_cat_id", "first_cat_name", "second_cat_id", "second_cat_name", "third_cat_id", "third_cat_name"}, new Object[]{"", "", "", "", "", ""}, ECOrderCommon$CategoryInfo.class);
    public final PBStringField first_cat_id = PBField.initString("");
    public final PBStringField first_cat_name = PBField.initString("");
    public final PBStringField second_cat_id = PBField.initString("");
    public final PBStringField second_cat_name = PBField.initString("");
    public final PBStringField third_cat_id = PBField.initString("");
    public final PBStringField third_cat_name = PBField.initString("");
}
