package com.tencent.mobileqq.vas.pay.api.impl.pbFile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class midasPayCoinb$BuyGoodsReq extends MessageMicro<midasPayCoinb$BuyGoodsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"src_user", "dst_user", "product", "access_appid", "is_consume", "recharge_pf_ext"}, new Object[]{null, null, null, 0, Boolean.FALSE, ""}, midasPayCoinb$BuyGoodsReq.class);
    public midasPayCoinb$UserInfo src_user = new midasPayCoinb$UserInfo();
    public midasPayCoinb$UserInfo dst_user = new midasPayCoinb$UserInfo();
    public final PBRepeatMessageField<midasPayCoinb$ProductItem> product = PBField.initRepeatMessage(midasPayCoinb$ProductItem.class);
    public final PBInt32Field access_appid = PBField.initInt32(0);
    public final PBBoolField is_consume = PBField.initBool(false);
    public final PBStringField recharge_pf_ext = PBField.initString("");
}
