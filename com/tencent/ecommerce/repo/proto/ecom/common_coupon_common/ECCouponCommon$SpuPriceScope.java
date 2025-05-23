package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECCouponCommon$SpuPriceScope extends MessageMicro<ECCouponCommon$SpuPriceScope> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{Element.ELEMENT_NAME_MIN, "max"}, new Object[]{0L, 0L}, ECCouponCommon$SpuPriceScope.class);
    public final PBUInt64Field min = PBField.initUInt64(0);
    public final PBUInt64Field max = PBField.initUInt64(0);
}
