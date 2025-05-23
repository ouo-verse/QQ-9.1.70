package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CouponProto$GetShopsByBidsResp extends MessageMicro<CouponProto$GetShopsByBidsResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "shops"}, new Object[]{0, null}, CouponProto$GetShopsByBidsResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto$Shop> shops = PBField.initRepeatMessage(CouponProto$Shop.class);
}
