package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address;

import com.heytap.databaseengine.type.DeviceType;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.weiyun.poi.PoiDbManager;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECDeliveryAddress$SellerAddress extends MessageMicro<ECDeliveryAddress$SellerAddress> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112, 120, 130, 138, 144, 152, 160, 168}, new String[]{"id", "province", "province_id", "city", PoiDbManager.COL_POI_CITY_ID, "district", "district_id", "street", "street_id", "detail_address", "name", DeviceType.DeviceCategory.MOBILE, "masked_mobile", "is_default", "address_type", "shop_id", "storehouse_id", AlbumCacheData.CREATE_TIME, "update_time", "is_send_default", "is_return_default"}, new Object[]{0L, "", "", "", "", "", "", "", "", "", "", "", "", 0, 0, "", "", 0L, 0L, 0, 0}, ECDeliveryAddress$SellerAddress.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f105231id = PBField.initInt64(0);
    public final PBStringField province = PBField.initString("");
    public final PBStringField province_id = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField city_id = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField district_id = PBField.initString("");
    public final PBStringField street = PBField.initString("");
    public final PBStringField street_id = PBField.initString("");
    public final PBStringField detail_address = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField mobile = PBField.initString("");
    public final PBStringField masked_mobile = PBField.initString("");
    public final PBInt32Field is_default = PBField.initInt32(0);
    public final PBUInt32Field address_type = PBField.initUInt32(0);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField storehouse_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBUInt32Field is_send_default = PBField.initUInt32(0);
    public final PBUInt32Field is_return_default = PBField.initUInt32(0);
}
