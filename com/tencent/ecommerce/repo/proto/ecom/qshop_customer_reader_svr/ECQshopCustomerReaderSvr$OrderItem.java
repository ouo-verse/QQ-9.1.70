package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$OrderItem extends MessageMicro<ECQshopCustomerReaderSvr$OrderItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 66, 74, 82}, new String[]{"order_id", "state", "order_price", "discount", "free_shipping", "shipping_cost", "sku_num", "time_record", "product_carts", "shop_info"}, new Object[]{"", 0, 0, 0, Boolean.FALSE, 0, 0, null, null, null}, ECQshopCustomerReaderSvr$OrderItem.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field order_price = PBField.initUInt32(0);
    public final PBUInt32Field discount = PBField.initUInt32(0);
    public final PBBoolField free_shipping = PBField.initBool(false);
    public final PBUInt32Field shipping_cost = PBField.initUInt32(0);
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public ECQshopCustomerReaderSvr$TimeRecord time_record = new MessageMicro<ECQshopCustomerReaderSvr$TimeRecord>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$TimeRecord
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 808}, new String[]{AlbumCacheData.CREATE_TIME, "pay_time", "cancel_time", "send_time", "receive_time", "refund_time", "update_time"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, 0L}, ECQshopCustomerReaderSvr$TimeRecord.class);
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBInt64Field pay_time = PBField.initInt64(0);
        public final PBInt64Field cancel_time = PBField.initInt64(0);
        public final PBInt64Field send_time = PBField.initInt64(0);
        public final PBInt64Field receive_time = PBField.initInt64(0);
        public final PBInt64Field refund_time = PBField.initInt64(0);
        public final PBInt64Field update_time = PBField.initInt64(0);
    };
    public final PBRepeatMessageField<ECQshopCustomerReaderSvr$ProductCart> product_carts = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$ProductCart.class);
    public ECQshopCustomerReaderSvr$ShopInfo shop_info = new MessageMicro<ECQshopCustomerReaderSvr$ShopInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$ShopInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"shop_id", "shop_title", "shop_icon", "shop_link"}, new Object[]{"", "", "", ""}, ECQshopCustomerReaderSvr$ShopInfo.class);
        public final PBStringField shop_id = PBField.initString("");
        public final PBStringField shop_title = PBField.initString("");
        public final PBStringField shop_icon = PBField.initString("");
        public final PBStringField shop_link = PBField.initString("");
    };
}
