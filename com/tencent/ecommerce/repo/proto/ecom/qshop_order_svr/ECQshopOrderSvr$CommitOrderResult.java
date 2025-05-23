package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$CommitOrderResult extends MessageMicro<ECQshopOrderSvr$CommitOrderResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 66, 74, 80}, new String[]{"order_id", "box_order_ids", "pay_url_params", DefaultTVKDataProvider.KEY_PAY_TYPE, "order_price", "shop_id", "spu_id", "sku_id", "first_cat_id", "has_address"}, new Object[]{"", "", "", 0, 0L, "", "", "", "", Boolean.FALSE}, ECQshopOrderSvr$CommitOrderResult.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBRepeatField<String> box_order_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField pay_url_params = PBField.initString("");
    public final PBUInt32Field pay_type = PBField.initUInt32(0);
    public final PBUInt64Field order_price = PBField.initUInt64(0);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField first_cat_id = PBField.initString("");
    public final PBBoolField has_address = PBField.initBool(false);
}
