package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponFlow extends MessageMicro<ECCouponCommon$CouponFlow> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34, 40, 160}, new String[]{"flow_base", "user_id", "order_id", "op_type", AlbumCacheData.CREATE_TIME}, new Object[]{null, "", "", 0, 0L}, ECCouponCommon$CouponFlow.class);
    public final PBRepeatMessageField<ECCouponCommon$CouponFlowBase> flow_base = PBField.initRepeatMessage(ECCouponCommon$CouponFlowBase.class);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField order_id = PBField.initString("");
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
}
