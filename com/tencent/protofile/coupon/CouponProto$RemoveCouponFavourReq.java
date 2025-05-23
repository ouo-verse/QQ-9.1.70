package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class CouponProto$RemoveCouponFavourReq extends MessageMicro<CouponProto$RemoveCouponFavourReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"bid", "cid", "source_id"}, new Object[]{0, 0, 0}, CouponProto$RemoveCouponFavourReq.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field cid = PBField.initUInt32(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
}
