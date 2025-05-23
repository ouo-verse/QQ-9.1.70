package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address;

import com.heytap.databaseengine.type.DeviceType;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECDeliveryAddress$Address extends MessageMicro<ECDeliveryAddress$Address> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90, 96, 104, 114}, new String[]{"id", "province", "city", "district", "street", "detail_address", "name", DeviceType.DeviceCategory.MOBILE, "masked_mobile", "is_default", "label", AlbumCacheData.CREATE_TIME, "update_time", "uid"}, new Object[]{0L, "", "", "", "", "", "", "", "", 0, "", 0L, 0L, ""}, ECDeliveryAddress$Address.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f105230id = PBField.initInt64(0);
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
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBStringField uid = PBField.initString("");
}
