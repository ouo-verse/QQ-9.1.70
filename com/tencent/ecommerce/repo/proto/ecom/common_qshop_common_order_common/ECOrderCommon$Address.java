package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$Address extends MessageMicro<ECOrderCommon$Address> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90}, new String[]{"id", "province", "city", "district", "street", "detail_address", "name", DeviceType.DeviceCategory.MOBILE, "masked_mobile", "is_default", "label"}, new Object[]{0L, "", "", "", "", "", "", "", "", 0, ""}, ECOrderCommon$Address.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f105232id = PBField.initInt64(0);
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField street = PBField.initString("");
    public final PBStringField detail_address = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField mobile = PBField.initString("");
    public final PBStringField masked_mobile = PBField.initString("");
    public final PBInt32Field is_default = PBField.initInt32(0);
    public final PBStringField label = PBField.initString("");
}
