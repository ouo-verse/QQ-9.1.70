package com.tencent.trpcprotocol.qqva;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class midasPayCoinb$ChargeProductItem extends MessageMicro<midasPayCoinb$ChargeProductItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "product_price", "coin_num", "coin_present_num", "quantity", "first_save_present"}, new Object[]{"", 0, 0, 0, 0, ""}, midasPayCoinb$ChargeProductItem.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBInt32Field product_price = PBField.initInt32(0);
    public final PBInt32Field coin_num = PBField.initInt32(0);
    public final PBInt32Field coin_present_num = PBField.initInt32(0);
    public final PBInt32Field quantity = PBField.initInt32(0);
    public final PBStringField first_save_present = PBField.initString("");
}
