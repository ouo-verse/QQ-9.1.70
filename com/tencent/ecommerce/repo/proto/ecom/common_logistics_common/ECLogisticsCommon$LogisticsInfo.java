package com.tencent.ecommerce.repo.proto.ecom.common_logistics_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$SellerAddress;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECLogisticsCommon$LogisticsInfo extends MessageMicro<ECLogisticsCommon$LogisticsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 98, 106, 114}, new String[]{"logistics_code", "order_id", "shipper_company", "trail_trace", "send_type", "logistics_type", AlbumCacheData.CREATE_TIME, "update_time", "current_status", "send_address", "return_address", "receive_address", CoverDBCacheData.PACKAGE_INFO, "after_sale_id"}, new Object[]{"", "", null, null, 0, 0, 0L, 0L, null, null, null, null, null, ""}, ECLogisticsCommon$LogisticsInfo.class);
    public final PBStringField logistics_code = PBField.initString("");
    public final PBStringField order_id = PBField.initString("");
    public ECLogisticsCommon$ShipperCompany shipper_company = new ECLogisticsCommon$ShipperCompany();
    public ECLogisticsCommon$TrailTrace trail_trace = new ECLogisticsCommon$TrailTrace();
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBUInt32Field logistics_type = PBField.initUInt32(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public ECLogisticsCommon$TraceStatus current_status = new ECLogisticsCommon$TraceStatus();
    public ECDeliveryAddress$SellerAddress send_address = new ECDeliveryAddress$SellerAddress();
    public ECDeliveryAddress$SellerAddress return_address = new ECDeliveryAddress$SellerAddress();
    public ECDeliveryAddress$Address receive_address = new ECDeliveryAddress$Address();
    public ECLogisticsCommon$PackageInfo package_info = new ECLogisticsCommon$PackageInfo();
    public final PBStringField after_sale_id = PBField.initString("");
}
