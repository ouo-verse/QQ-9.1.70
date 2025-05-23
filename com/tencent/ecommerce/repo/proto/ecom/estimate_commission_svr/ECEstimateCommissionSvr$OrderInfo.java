package com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECEstimateCommissionSvr$OrderInfo extends MessageMicro<ECEstimateCommissionSvr$OrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{AlbumCacheData.CREATE_TIME, "order_price", "order_id"}, new Object[]{"", 0L, ""}, ECEstimateCommissionSvr$OrderInfo.class);
    public final PBStringField create_time = PBField.initString("");
    public final PBInt64Field order_price = PBField.initInt64(0);
    public final PBStringField order_id = PBField.initString("");
}
