package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$BasicInfo extends MessageMicro<ECOrder$BasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56, 64, 80, 90, 138, 162, 170}, new String[]{"order_id", "state", WadlProxyConsts.CHANNEL, "channel_name", "pindao_id", "goods_type", "os_type", "promotion_type", "order_price", "display_order_id", AlbumCacheData.CREATE_TIME, "saas_type", "saas_type_str"}, new Object[]{"", 0, 0, "", "", 0, 0, 0, 0L, "", "", "", ""}, ECOrder$BasicInfo.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBInt32Field state = PBField.initInt32(0);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBStringField channel_name = PBField.initString("");
    public final PBStringField pindao_id = PBField.initString("");
    public final PBInt32Field goods_type = PBField.initInt32(0);
    public final PBInt32Field os_type = PBField.initInt32(0);
    public final PBInt32Field promotion_type = PBField.initInt32(0);
    public final PBInt64Field order_price = PBField.initInt64(0);
    public final PBStringField display_order_id = PBField.initString("");
    public final PBStringField saas_type = PBField.initString("");
    public final PBStringField saas_type_str = PBField.initString("");
    public final PBStringField create_time = PBField.initString("");
}
