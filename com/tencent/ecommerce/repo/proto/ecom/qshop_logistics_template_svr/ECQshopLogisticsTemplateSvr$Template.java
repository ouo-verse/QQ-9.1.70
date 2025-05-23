package com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$SellerAddress;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopLogisticsTemplateSvr$Template extends MessageMicro<ECQshopLogisticsTemplateSvr$Template> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64, 72, 82, 88}, new String[]{"id", "name", "send_address", "free_shipping_areas", "unreachable_areas", AlbumCacheData.CREATE_TIME, "update_time", "create_uid", "status", "shop_id", "is_system_default"}, new Object[]{0L, "", null, null, null, 0L, 0L, 0L, 0, "", 0}, ECQshopLogisticsTemplateSvr$Template.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f105251id = PBField.initInt64(0);
    public final PBStringField name = PBField.initString("");
    public ECDeliveryAddress$SellerAddress send_address = new ECDeliveryAddress$SellerAddress();
    public ECQshopLogisticsTemplateSvr$FreeShippingAreas free_shipping_areas = new MessageMicro<ECQshopLogisticsTemplateSvr$FreeShippingAreas>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$FreeShippingAreas
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"areas"}, new Object[]{null}, ECQshopLogisticsTemplateSvr$FreeShippingAreas.class);
        public final PBRepeatMessageField<ECQshopLogisticsTemplateSvr$Area> areas = PBField.initRepeatMessage(ECQshopLogisticsTemplateSvr$Area.class);
    };
    public ECQshopLogisticsTemplateSvr$UnreachableAreas unreachable_areas = new MessageMicro<ECQshopLogisticsTemplateSvr$UnreachableAreas>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_logistics_template_svr.ECQshopLogisticsTemplateSvr$UnreachableAreas
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"unreachable_areas"}, new Object[]{null}, ECQshopLogisticsTemplateSvr$UnreachableAreas.class);
        public final PBRepeatMessageField<ECQshopLogisticsTemplateSvr$UnreachableArea> unreachable_areas = PBField.initRepeatMessage(ECQshopLogisticsTemplateSvr$UnreachableArea.class);
    };
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field update_time = PBField.initInt64(0);
    public final PBInt64Field create_uid = PBField.initInt64(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField shop_id = PBField.initString("");
    public final PBUInt32Field is_system_default = PBField.initUInt32(0);
}
