package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$SpuInfo extends MessageMicro<ECOrderCommon$SpuInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90, 96, 130}, new String[]{"spu_id", "title", "main_pics", "detail_pics", "price", "category", "property", "brand_id", "shop_id", AlbumCacheData.CREATE_TIME, "spu_link", "update_time", "trade_info"}, new Object[]{"", "", null, null, null, null, null, "", "", 0L, "", 0L, null}, ECOrderCommon$SpuInfo.class);
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<ECOrderCommon$PicInfo> main_pics = PBField.initRepeatMessage(ECOrderCommon$PicInfo.class);
    public final PBRepeatMessageField<ECOrderCommon$PicInfo> detail_pics = PBField.initRepeatMessage(ECOrderCommon$PicInfo.class);
    public ECOrderCommon$SpuPrice price = new ECOrderCommon$SpuPrice();
    public ECOrderCommon$CategoryInfo category = new ECOrderCommon$CategoryInfo();
    public ECOrderCommon$PropertyInfo property = new ECOrderCommon$PropertyInfo();
    public final PBStringField brand_id = PBField.initString("");
    public final PBStringField shop_id = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBStringField spu_link = PBField.initString("");
    public final PBInt64Field update_time = PBField.initInt64(0);
    public ECOrderCommon$ProductTradeInfo trade_info = new ECOrderCommon$ProductTradeInfo();
}
