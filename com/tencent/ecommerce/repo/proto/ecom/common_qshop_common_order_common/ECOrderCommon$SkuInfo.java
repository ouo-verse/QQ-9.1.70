package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$SkuInfo extends MessageMicro<ECOrderCommon$SkuInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 64}, new String[]{"sku_id", "sku_code", "spu_id", "preview_pics", "spec", "price", AlbumCacheData.CREATE_TIME, "activity_price"}, new Object[]{"", "", "", null, null, 0L, 0L, 0L}, ECOrderCommon$SkuInfo.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField sku_code = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBRepeatMessageField<ECOrderCommon$PicInfo> preview_pics = PBField.initRepeatMessage(ECOrderCommon$PicInfo.class);
    public ECOrderCommon$SpecInfo spec = new ECOrderCommon$SpecInfo();
    public final PBInt64Field price = PBField.initInt64(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field activity_price = PBField.initInt64(0);
}
