package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$ProductCart extends MessageMicro<ECQshopCustomerReaderSvr$ProductCart> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 80}, new String[]{"spu_id", "title", "main_pics", "sku", AlbumCacheData.CREATE_TIME}, new Object[]{"", "", null, null, 0L}, ECQshopCustomerReaderSvr$ProductCart.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<ECQshopCustomerReaderSvr$PicInfo> main_pics = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$PicInfo.class);
    public ECQshopCustomerReaderSvr$SkuInfo sku = new MessageMicro<ECQshopCustomerReaderSvr$SkuInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$SkuInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 56}, new String[]{"sku_id", "preview_pics", "spec", "price", AlbumCacheData.CREATE_TIME}, new Object[]{"", null, null, 0L, 0L}, ECQshopCustomerReaderSvr$SkuInfo.class);
        public final PBStringField sku_id = PBField.initString("");
        public final PBRepeatMessageField<ECQshopCustomerReaderSvr$PicInfo> preview_pics = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$PicInfo.class);
        public ECQshopCustomerReaderSvr$SpecInfo spec = new MessageMicro<ECQshopCustomerReaderSvr$SpecInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr.ECQshopCustomerReaderSvr$SpecInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, ECQshopCustomerReaderSvr$SpecInfo.class);
            public final PBRepeatMessageField<ECQshopCustomerReaderSvr$SpecItem> items = PBField.initRepeatMessage(ECQshopCustomerReaderSvr$SpecItem.class);
        };
        public final PBInt64Field price = PBField.initInt64(0);
        public final PBInt64Field create_time = PBField.initInt64(0);
    };
    public final PBInt64Field create_time = PBField.initInt64(0);
}
