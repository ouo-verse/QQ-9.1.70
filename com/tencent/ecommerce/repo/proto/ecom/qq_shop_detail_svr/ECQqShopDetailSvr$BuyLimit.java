package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$BuyLimit extends MessageMicro<ECQqShopDetailSvr$BuyLimit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"user_daily_limit"}, new Object[]{0}, ECQqShopDetailSvr$BuyLimit.class);
    public final PBInt32Field user_daily_limit = PBField.initInt32(0);
}
